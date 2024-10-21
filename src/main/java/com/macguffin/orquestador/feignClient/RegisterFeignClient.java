package com.macguffin.orquestador.feignClient;

import com.macguffin.orquestador.dtos.RegisterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "register-api", url = "http://localhost:8084/auth")
public interface RegisterFeignClient {
    @PostMapping("/register")
    String register(@RequestBody RegisterDTO registerDTO);
}
