package com.macguffin.orquestador.controller;

import com.macguffin.orquestador.dtos.RegisterDTO;
import com.macguffin.orquestador.services.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegisterController {
    private final RegisterService registerService;
    @PostMapping
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
        return registerService.register(registerDTO);
    }
}
