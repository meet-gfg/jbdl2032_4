package com.gfg.imdbdemo.service;

import com.gfg.imdbdemo.domain.Review;
import com.gfg.imdbdemo.repositories.ReviewRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReviewService {

    Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    ReviewRepository reviewRepository;

    public void addReview(Review review) {
        Review savedReview = reviewRepository.save(review);
        logger.info("saved the review for movie", review.getReviewId());
    }


    public Review getReviewById(Long reviewId) {
        /*
        Optional<Review> optionalReview=reviewRepository.findById(reviewId);
        if(optionalReview.isPresent())
            return optionalReview.get();
        else {
            // throw exception
            return null; // or return blank new Review();
        }
        */
        Review review = reviewRepository.findById(reviewId).orElse(null);
        System.out.println(review.toString());



        return review;

        //  return reviewRepository.findById(reviewId).orElseThrow(new Exception());

    }
}
