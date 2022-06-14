package com.gfg.imdbdemo.service.request;

import com.gfg.imdbdemo.domain.Movie;
import com.gfg.imdbdemo.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {

    private String movieReview;

    private double rating;

    private Long movieId;

    public Review toReview(){
        return Review.builder()
                .movieReview(movieReview)
                .rating(rating)
                .movie(Movie.builder()
                        .movieId(movieId)
                        .build())
                .build();

    }

}




























