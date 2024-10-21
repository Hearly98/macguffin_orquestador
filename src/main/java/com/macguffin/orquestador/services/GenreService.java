package com.macguffin.orquestador.services;

import com.macguffin.orquestador.dtos.GenreDTO;
import com.macguffin.orquestador.dtos.GenreUpdateDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenreService {
    ResponseEntity<List<GenreDTO>> genreList();
    ResponseEntity<GenreDTO> getGenreById(Long id);
    ResponseEntity<GenreDTO> createGenre(GenreDTO genreDTO);
    ResponseEntity<GenreUpdateDTO> updateGenre(Long id, GenreUpdateDTO genreUpdateDTO);
}
