package com.macguffin.orquestador.feignClient;

import com.macguffin.orquestador.dtos.SubscriptionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "subscription-api", url = "http://localhost:8083/api/suscripciones")
public interface SubscriptionFeignClient {

    @GetMapping
    List<SubscriptionDTO>subscriptionList();
    @GetMapping("/get-data-by-userId/{userId}")
    SubscriptionDTO getSubByUserId(@PathVariable Integer userId);

    @PostMapping("/subscribe/{userId}")
   SubscriptionDTO subscribeUser(@PathVariable("userId") Integer userId, @RequestBody SubscriptionDTO subscriptionDTO);

    @PatchMapping("/desactivar/{userId}")
    Void deactivateSubscription(@PathVariable("userId") Integer userId);

    @GetMapping("/user/{userId}/has-active-subscription")
    Boolean hasActiveSubscription(@PathVariable("userId") Integer userId);

    @GetMapping("/user/{userId}/has-active-subscription-by-username")
    Boolean hasActiveSubscription(@PathVariable String username);

    @PatchMapping("/activar/{userId}")
    Void activateSubscription(@PathVariable("userId") Integer userId);
    @PutMapping("/actualizar/{userId}")
    SubscriptionDTO updateSubscription(@PathVariable Integer userId, @RequestBody SubscriptionDTO newSubscriptionData);
    @GetMapping("/count-inactive")
    Long countInactiveSubscriptions();
    @GetMapping("/count-active")
    Long countActiveSubscriptions();
}
