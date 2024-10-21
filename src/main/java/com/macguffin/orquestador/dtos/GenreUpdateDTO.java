package com.macguffin.orquestador.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreUpdateDTO extends GenreDTO {
    private Long genre_id;
}
