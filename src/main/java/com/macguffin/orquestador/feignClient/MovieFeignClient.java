package com.macguffin.orquestador.feignClient;

import com.macguffin.orquestador.dtos.MovieDTO;
import com.macguffin.orquestador.dtos.MovieUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "movie-api", url = "http://localhost:8082/api/movies")
public interface MovieFeignClient {
    @GetMapping("list")
    List<MovieDTO> movieList();
    @GetMapping("/count")
    Long getMovieCount();
    @GetMapping("/{id}")
    MovieDTO getMovieById(@PathVariable("id") Long movieId);
    @PostMapping("/create")
    MovieDTO createMovie(MovieDTO movieDTO);
    @PutMapping("/{id}")
    MovieUpdateDTO updateMovie(@PathVariable("id") Long id, @RequestBody MovieUpdateDTO movieUpdateDTO);
}
