package com.gfg.imdbdemo.service.response;

import com.gfg.imdbdemo.domain.Genre;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {

    private String title;
    private Genre genre;
    private Double rating;

}
