package com.macguffin.orquestador.servicesImpl;

import com.macguffin.orquestador.dtos.MovieDTO;
import com.macguffin.orquestador.dtos.MovieUpdateDTO;
import com.macguffin.orquestador.feignClient.MovieFeignClient;
import com.macguffin.orquestador.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieFeignClient movieFeignClient;
    @Override
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return new ResponseEntity<>(movieFeignClient.movieList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MovieDTO> getMovieById(Long movieId) {
        return new ResponseEntity<>(movieFeignClient.getMovieById(movieId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MovieDTO> createMovie(MovieDTO movieDTO) {
        return new ResponseEntity<>(movieFeignClient.createMovie(movieDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<MovieUpdateDTO> updateMovie(Long movieId, MovieUpdateDTO movieUpdateDTO) {
        return new ResponseEntity<>(movieFeignClient.updateMovie(movieId, movieUpdateDTO), HttpStatus.OK);
    }


}
