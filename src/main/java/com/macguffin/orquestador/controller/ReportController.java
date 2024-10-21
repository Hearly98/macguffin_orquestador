package com.macguffin.orquestador.controller;

import com.macguffin.orquestador.services.GenreService;
import com.macguffin.orquestador.services.MovieService;
import com.macguffin.orquestador.services.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;
    private final MovieService movieService;
    private final GenreService genreService;
    @GetMapping("/totalClients")
    public ResponseEntity<Long> getClientCount(){
        return reportService.getClientCount();
    }
    @GetMapping("/totalMovies")
    public ResponseEntity<Long> getTotalMovies() {
        return reportService.getMoviesCount();
    }
    @GetMapping("/totalGenres")
    public ResponseEntity<Long> getTotalGenres() {
        return reportService.getGenresCount();
    }
    @GetMapping("/totalInactive")
    public ResponseEntity<Long> countInactiveSubscriptions(){
        return reportService.countInactiveSubscriptions();
    }
    @GetMapping("/totalActive")
    public ResponseEntity<Long> countActiveSubscriptions(){
        return reportService.countActiveSubscriptions();
    }
}
