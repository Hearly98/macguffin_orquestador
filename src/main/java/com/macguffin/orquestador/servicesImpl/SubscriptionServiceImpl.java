package com.macguffin.orquestador.servicesImpl;

import com.macguffin.orquestador.dtos.SubscriptionDTO;
import com.macguffin.orquestador.feignClient.SubscriptionFeignClient;
import com.macguffin.orquestador.feignClient.UserFeignClient;
import com.macguffin.orquestador.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionFeignClient subscriptionFeignClient;
    private final UserFeignClient userFeignClient;

    @Override
    public ResponseEntity<Object> subscriptionList() {
        return new ResponseEntity<>(subscriptionFeignClient.subscriptionList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriptionDTO> subscribeUser(Integer userId, SubscriptionDTO subscriptionDTO) {
        return  new ResponseEntity<>(subscriptionFeignClient.subscribeUser(userId, subscriptionDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deactivateSubscription(Integer userId) {
        if (!userFeignClient.userExists(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        subscriptionFeignClient.deactivateSubscription(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
@Override
    public ResponseEntity<Void> activateSubscription(Integer userId) {
        if (!userFeignClient.userExists(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        subscriptionFeignClient.activateSubscription(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
@Override
    public ResponseEntity<SubscriptionDTO> updateSubscription(Integer userId, SubscriptionDTO newSubscriptionData) {
        if (!userFeignClient.userExists(userId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SubscriptionDTO currentSubscription = subscriptionFeignClient.getSubByUserId(userId);
        if (currentSubscription == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SubscriptionDTO updatedSubscription = subscriptionFeignClient.updateSubscription(userId, newSubscriptionData);
        return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
    }
}
