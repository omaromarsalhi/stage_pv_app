package com.stage.authentification.auth;


import com.stage.authentification.jwt.JwtService;
import com.stage.authentification.user.Role;
import com.stage.authentification.user.User;
import com.stage.authentification.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public  AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.ADMIN)
                .build();

        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public  AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );
        var user = userRepository.findByEmail(request.email()).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        var jwtToken=jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }
}
