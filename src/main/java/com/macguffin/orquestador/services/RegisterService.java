package com.macguffin.orquestador.services;

import com.macguffin.orquestador.dtos.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface RegisterService {
    ResponseEntity<String> register(RegisterDTO registerDTO);
}
