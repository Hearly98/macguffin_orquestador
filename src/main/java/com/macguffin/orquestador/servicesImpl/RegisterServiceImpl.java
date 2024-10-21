package com.macguffin.orquestador.servicesImpl;

import com.macguffin.orquestador.dtos.RegisterDTO;
import com.macguffin.orquestador.feignClient.RegisterFeignClient;
import com.macguffin.orquestador.services.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService{
    private final RegisterFeignClient registerFeignClient;
    @Override
    public ResponseEntity<String> register(RegisterDTO registerDTO){
        String response = registerFeignClient.register(registerDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
