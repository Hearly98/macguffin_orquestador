package com.macguffin.orquestador.controller;

import com.macguffin.orquestador.dtos.LoginDTO;
import com.macguffin.orquestador.services.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;
    @PostMapping
    public ResponseEntity<Map<String, String>>login(@RequestBody LoginDTO loginDTO){
        return loginService.login(loginDTO);
    }
}
