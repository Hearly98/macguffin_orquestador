package com.macguffin.orquestador.services;

import com.macguffin.orquestador.dtos.LoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface LoginService {
    ResponseEntity<Map<String, String>> login(LoginDTO loginDTO);
}
