package com.macguffin.orquestador.servicesImpl;

import com.macguffin.orquestador.feignClient.GenreFeignClient;
import com.macguffin.orquestador.feignClient.MovieFeignClient;
import com.macguffin.orquestador.feignClient.SubscriptionFeignClient;
import com.macguffin.orquestador.feignClient.UserFeignClient;
import com.macguffin.orquestador.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final UserFeignClient userFeignClient;
    private final MovieFeignClient movieFeignClient;
    private final GenreFeignClient genreFeignClient;
    private final SubscriptionFeignClient subscriptionFeignClient;
    @Override
    public ResponseEntity<Long> getClientCount() {
        return new ResponseEntity<>(userFeignClient.getClientCount(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> getGenresCount() {
        return new ResponseEntity<>(genreFeignClient.getGenreCount(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> getMoviesCount() {
        return new ResponseEntity<>(movieFeignClient.getMovieCount(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> countActiveSubscriptions() {
        return new ResponseEntity<>(subscriptionFeignClient.countActiveSubscriptions(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> countInactiveSubscriptions() {
        return new ResponseEntity<>(subscriptionFeignClient.countInactiveSubscriptions(), HttpStatus.OK);
    }
}
