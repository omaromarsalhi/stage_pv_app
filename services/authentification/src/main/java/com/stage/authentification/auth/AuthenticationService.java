package com.stage.authentification.auth;


import com.stage.authentification.exeption.TokenExpiredException;
import com.stage.authentification.exeption.UserNotFoundException;
import com.stage.authentification.jwt.JwtService;
import com.stage.authentification.token.TokenBlackList;
import com.stage.authentification.token.TokenBlackListRepository;
import com.stage.authentification.user.Role;
import com.stage.authentification.user.User;
import com.stage.authentification.user.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final TokenBlackListRepository tokenBlackListRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken, jwtToken);
    }


    public AuthenticationResponse login(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new UserNotFoundException("Invalid email or password");
        }

        var user = userRepository.findByEmail(request.email()).orElseThrow(() -> new UserNotFoundException("User not found"));
        return generateTokens(user);
    }

    public AuthenticationResponse refresh(RefreshTokenRequest request) {
        var user = userRepository.findByEmail(request.username()).orElseThrow(() -> new UserNotFoundException("User not found"));
        tokenBlackListRepository.expireTokenByUser(user.getIdUser(),jwtService.extractClaim(request.refreshToken(), Claims::getId));
        return generateMainToken(user, request.refreshToken());
    }

    private AuthenticationResponse generateTokens(User user) {
        var jwtToken = jwtService.generateToken(user);
        var tokenBlackList = TokenBlackList.builder()
                .jti(jwtService.extractClaim(jwtToken, Claims::getId))
                .user(user)
                .build();
        tokenBlackListRepository.save(tokenBlackList);

        var jwtRefreshToken = jwtService.generateRefreshToken(user.getEmail());
        var refreshTokenBlackList = TokenBlackList.builder()
                .jti(jwtService.extractClaim(jwtRefreshToken, Claims::getId))
                .user(user)
                .build();
        tokenBlackListRepository.save(refreshTokenBlackList);
        return new AuthenticationResponse(jwtToken, jwtRefreshToken);
    }

    private AuthenticationResponse generateMainToken(User user, String refreshToken) {
        if (jwtService.isTokenValid(refreshToken, user)) {
            var jwtToken = jwtService.generateToken(user);
            var tokenBlackList = TokenBlackList.builder()
                    .jti(jwtService.extractClaim(jwtToken, Claims::getId))
                    .user(user)
                    .build();
            tokenBlackListRepository.save(tokenBlackList);
            return new AuthenticationResponse(jwtToken, refreshToken);
        } else
            throw new TokenExpiredException("invalid refresh token");
    }

}
