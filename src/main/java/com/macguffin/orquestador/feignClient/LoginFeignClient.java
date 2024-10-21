package com.macguffin.orquestador.feignClient;

import com.macguffin.orquestador.dtos.LoginDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "login-api", url = "http://localhost:8084/auth")
public interface LoginFeignClient {
@PostMapping("/login")
Map<String, String> login(@RequestBody LoginDTO loginDTO);
}
