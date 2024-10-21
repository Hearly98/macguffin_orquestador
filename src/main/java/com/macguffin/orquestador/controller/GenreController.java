package com.macguffin.orquestador.controller;

import com.macguffin.orquestador.dtos.GenreDTO;
import com.macguffin.orquestador.dtos.GenreUpdateDTO;
import com.macguffin.orquestador.services.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;
    @Operation(summary = "Obtiene todos los géneros registrados")
    @GetMapping()
    public ResponseEntity<List<GenreDTO>>genreList(){
        return genreService.genreList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenreDTO> getGenreById(Long id){
        return genreService.getGenreById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO genreDTO){
        return genreService.createGenre(genreDTO);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<GenreUpdateDTO> updateGenre(@PathVariable Long id, @RequestBody GenreUpdateDTO genreUpdateDTO){
        return genreService.updateGenre(id, genreUpdateDTO);

    }
}
