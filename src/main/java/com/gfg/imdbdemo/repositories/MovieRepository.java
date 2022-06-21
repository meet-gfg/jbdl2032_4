package com.gfg.imdbdemo.repositories;

import com.gfg.imdbdemo.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * if mysql fails with safe update while deleting and updating, run following command
 *
 * SET SQL_SAFE_UPDATES=0
 *
 * */

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {


    /***
     * 1. Auto decode -> findByTitle -> JPA will decode and query will be select  * from ... where title=-?
     * 2. @Query annotation -> it accepts the query in JPQL, where it uses JAVA classes to decode
     * 3. @Query(nativeQuery=true) -> it accepts the raw mysql query in form of prepared statement
     * */

    Movie findByTitle(String title);

    Movie findByTitleAndRating(String title, Double rating);

    @Query("select m from Movie m where m.title= :name")
    Movie findByName(String name);

    @Query("select m from Movie m where m.title= ?1")
    Movie findByName1(String name);

    @Query(value = "select * from movie_table m where m.title= ? and m.rating=?",nativeQuery = true)
    Movie findByNameAndRating(String name,Double rating);

}
