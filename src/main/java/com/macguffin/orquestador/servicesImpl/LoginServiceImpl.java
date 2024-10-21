package com.macguffin.orquestador.servicesImpl;
import com.macguffin.orquestador.dtos.UserDTO;
import com.macguffin.orquestador.services.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import com.macguffin.orquestador.dtos.LoginDTO;
import com.macguffin.orquestador.feignClient.LoginFeignClient;
import com.macguffin.orquestador.feignClient.SubscriptionFeignClient;
import com.macguffin.orquestador.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginFeignClient loginFeignClient;
    @Override
    public ResponseEntity<Map<String, String>>login(LoginDTO loginDTO){
        Map<String, String> loginResponse = loginFeignClient.login(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
    }
