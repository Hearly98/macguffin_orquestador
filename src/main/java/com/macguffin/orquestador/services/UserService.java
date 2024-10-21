package com.macguffin.orquestador.services;

import com.macguffin.orquestador.dtos.UserDTO;
import com.macguffin.orquestador.feignClient.UserFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserFeignClient userFeignClient;
    public UserDTO getUserByUsername(String username) {
        return userFeignClient.findByUsername(username);
    }
}
