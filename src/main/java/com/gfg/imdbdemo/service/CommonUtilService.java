package com.gfg.imdbdemo.service;

import com.gfg.imdbdemo.domain.Movie;
import org.springframework.stereotype.Service;

@Service
public class CommonUtilService {

    private final String movieIdentifier="MOVIE::";

    public String getMovieKey(Movie movie){
        return movieIdentifier+movie.getTitle();
    }
}
