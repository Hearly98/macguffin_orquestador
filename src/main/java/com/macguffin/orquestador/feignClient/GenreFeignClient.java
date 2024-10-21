package com.macguffin.orquestador.feignClient;

import com.macguffin.orquestador.dtos.GenreDTO;
import com.macguffin.orquestador.dtos.GenreUpdateDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="genre-api", url ="http://localhost:8082/api/genres")
public interface GenreFeignClient {
    @GetMapping("/list")
    List<GenreDTO> genreList();
    @GetMapping("/count")
    Long getGenreCount();
    @GetMapping("/update/{id}")
    GenreDTO getGenreById(@PathVariable Long genreId);
    @PostMapping("/create")
    GenreDTO createGenre(GenreDTO genreDTO);
    @PutMapping("/update/{id}")
    GenreUpdateDTO updateGenre(@PathVariable("id") Long id,@RequestBody GenreUpdateDTO genreUpdateDTO);

}
