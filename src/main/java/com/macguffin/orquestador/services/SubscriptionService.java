package com.macguffin.orquestador.services;

import com.macguffin.orquestador.dtos.SubscriptionDTO;
import org.springframework.http.ResponseEntity;

public interface SubscriptionService {
    ResponseEntity<Object>subscriptionList();
    ResponseEntity<SubscriptionDTO> subscribeUser(Integer userId, SubscriptionDTO subscriptionDTO);

    ResponseEntity<Void> deactivateSubscription(Integer userId);

    ResponseEntity<Void> activateSubscription(Integer userId);

    ResponseEntity<SubscriptionDTO> updateSubscription(Integer userId, SubscriptionDTO newSubscriptionData);
}
