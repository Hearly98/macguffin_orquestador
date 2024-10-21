package com.macguffin.orquestador.servicesImpl;

import com.macguffin.orquestador.dtos.GenreDTO;
import com.macguffin.orquestador.dtos.GenreUpdateDTO;
import com.macguffin.orquestador.feignClient.GenreFeignClient;
import com.macguffin.orquestador.services.GenreService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreFeignClient genreFeignClient;

    @Override
    public ResponseEntity<List<GenreDTO>> genreList(){
        return new ResponseEntity<>(genreFeignClient.genreList(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenreDTO> getGenreById(Long id) {
        return new ResponseEntity<>(genreFeignClient.getGenreById(id), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GenreDTO> createGenre(GenreDTO genreDTO) {
        return new ResponseEntity<>(genreFeignClient.createGenre(genreDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<GenreUpdateDTO> updateGenre(Long id, GenreUpdateDTO genreUpdateDTO) {
        try {
            GenreUpdateDTO updatedGenre = genreFeignClient.updateGenre(id, genreUpdateDTO);
            return new ResponseEntity<>(updatedGenre, HttpStatus.OK);
        } catch (FeignException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
