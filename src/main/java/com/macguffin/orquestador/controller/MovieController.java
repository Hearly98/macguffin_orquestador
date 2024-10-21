package com.macguffin.orquestador.controller;

import com.macguffin.orquestador.dtos.MovieDTO;
import com.macguffin.orquestador.dtos.MovieUpdateDTO;
import com.macguffin.orquestador.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    @GetMapping()
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable("id") Long movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/create")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.createMovie(movieDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MovieUpdateDTO> updateMovie(@PathVariable("id") Long movieId, @RequestBody MovieUpdateDTO movieUpdateDTO) {
        return movieService.updateMovie(movieId, movieUpdateDTO);
    }
}
