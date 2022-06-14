package com.gfg.imdbdemo.domain;

import com.gfg.imdbdemo.service.response.MovieResponse;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="movie_table")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId; // mysql id -> movie_id

    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private Double rating;

   /**
    * if 2nd approch to find avg rating, store this else avoid.
    *
    -> private Double noOfReviews;
    */

    private String adminName;

   /*  /// one movie to many reviews
    @OneToMany
    List<Review> reviewList;
    */



    public MovieResponse toMovieResponse(){
        return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).build();
    }

}
