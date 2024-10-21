package com.macguffin.orquestador.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieUpdateDTO extends MovieDTO {
    private Long movie_id;
}
