package com.macguffin.orquestador.controller;

import com.macguffin.orquestador.dtos.SubscriptionDTO;
import com.macguffin.orquestador.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService subscriptionService;
    @GetMapping
    public ResponseEntity<Object> subscriptionList(){
        return subscriptionService.subscriptionList();
    }
    @PostMapping("/suscribe/{userId}")
    public ResponseEntity<SubscriptionDTO> subscribeUser(@PathVariable Integer userId,@RequestBody SubscriptionDTO subscriptionDTO){
        return subscriptionService.subscribeUser(userId, subscriptionDTO);
    }
    @PatchMapping("/deactivate/{userId}")
    public ResponseEntity<Void> deactivateSubscription(@PathVariable Integer userId){
        return subscriptionService.deactivateSubscription(userId);
    }
    @PatchMapping("/activate/{userId}")
    public ResponseEntity<Void> activateSubscription(@PathVariable Integer userId){
        return subscriptionService.activateSubscription(userId);
    }
    @PutMapping("/update/{userId}")
    public ResponseEntity<SubscriptionDTO> updateSubscription(@PathVariable Integer userId,@RequestBody SubscriptionDTO subscriptionData){
        return subscriptionService.updateSubscription(userId, subscriptionData);
    }
}
