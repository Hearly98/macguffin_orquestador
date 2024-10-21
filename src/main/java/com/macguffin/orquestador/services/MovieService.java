package com.macguffin.orquestador.services;

import com.macguffin.orquestador.dtos.MovieDTO;
import com.macguffin.orquestador.dtos.MovieUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    ResponseEntity<List<MovieDTO>> getAllMovies();
    ResponseEntity<MovieDTO> getMovieById(Long movieId);
    ResponseEntity<MovieDTO> createMovie(MovieDTO movieDTO);
    ResponseEntity<MovieUpdateDTO> updateMovie(Long movieId, MovieUpdateDTO movieUpdateDTO);
}
