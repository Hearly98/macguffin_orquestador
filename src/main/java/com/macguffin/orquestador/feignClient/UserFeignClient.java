package com.macguffin.orquestador.feignClient;

import com.macguffin.orquestador.dtos.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-api", url = "http://localhost:8084/auth/clientes")
public interface UserFeignClient {
    @GetMapping("/count")
    Long getClientCount();
    @GetMapping("/{username}")
    UserDTO findByUsername(@PathVariable("username") String username);
    @GetMapping("/{id}/exists")
    boolean userExists(@PathVariable("id") Integer userId);
}
