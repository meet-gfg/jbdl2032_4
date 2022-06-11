package com.gfg.imdbdemo.service;

import com.gfg.imdbdemo.domain.Movie;
import com.gfg.imdbdemo.repositories.MovieRepository;
import com.gfg.imdbdemo.service.request.MovieRequest;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
}
