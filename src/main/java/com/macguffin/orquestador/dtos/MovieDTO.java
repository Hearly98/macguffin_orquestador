package com.macguffin.orquestador.dtos;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieDTO {
    private Long movie_id;
    private String title;
    private String description;
    private Long release_year;
    private String poster_url;
    private String movie_Url;
    private GenreDTO genre;
}
