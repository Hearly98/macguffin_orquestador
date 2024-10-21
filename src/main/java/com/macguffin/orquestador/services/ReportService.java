package com.macguffin.orquestador.services;

import org.springframework.http.ResponseEntity;

public interface ReportService {
    ResponseEntity<Long> getClientCount();
    ResponseEntity<Long> getGenresCount();
    ResponseEntity<Long> getMoviesCount();
    ResponseEntity<Long>countActiveSubscriptions();
    ResponseEntity<Long>countInactiveSubscriptions();
}
