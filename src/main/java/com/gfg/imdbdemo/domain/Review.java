package com.gfg.imdbdemo.domain;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="review_table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {
/****
 *   Association types
 *  ONE AND MANY
 * @OneToMany
 * @ManyToOne
 * @ManyToMany
 * @OneToOne
 *
 *
 * */


/***
 *  2 Approch for average rating calculation
 *
 *  1. On every get request, query the review_table and get the average of all rating where movie id is ?
 *      eX: query the review_table and find the avg
 *
 *
 *  2. On every post request of review, update movie_table with the rating
 *          new rating= old rating+ ((new_value-old_rating/size) of review)
 *
 *          Ex:
 *          current movie rating : 0
 *          1st post review request: 4
 *
 *           rating= 0 +((4-0)/1)  -> 4
 *
 *          2nd post review : 3
 *
 *          rating= 4+ ((3-4)/2) -> 4 -0.5  = 3.5
 *
 *
 * */


/**
 * Relationships
 *
 * 1. Unidirectional relationship  -> one entity is connected with the another entity with no back reference. (loosely coupled)
 *
 * 2. Bidirectional relationship  -> both entities refer to each other. ( tightly coupled)
 *
 * */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long reviewId; //reviewid     mysql= -> int

    private String movieReview;

    private double rating;
    /**
     * Fetch Type:
     *
     * 1. Eager: It will also query the foregion table and get the data from table
     *    1 query with all joins in the table.
     *
     * 2. Lazy: It will query the requested table only
     *   it will run multiple queries.
     *      *      1. find the data of the requested table
     *      *      2. 2nd query to get the values of the referenced table.
     *      if the refrence is called, then it will query the referece
     *         ex: getMovie() -> at that time new query will be fired to sql.
     *
     * */




    // many review to one movie
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn
    private Movie movie; // it will add foregion key in mysql table with <TABLE_NAME>_<ID_NAME> --> // movie_movie_id



    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date updatedDate;


}
