package com.stage.PV.generatepv;


import com.stage.PV.authentication.AuthenticateAndGetUserClient;
import com.stage.PV.authentication.JwtTokenContextHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeneratePvService {

    private AuthenticateAndGetUserClient authenticateAndGetUserClient;

    public int authenticate(GeneratePvRequest request) {
        JwtTokenContextHolder.setToken(request.token());
        var response = this.authenticateAndGetUserClient.authenticateAndGetUser().orElseThrow(
                () -> new RuntimeException("No authenticated user found")
        );
        return response.idUser();
    }
}
