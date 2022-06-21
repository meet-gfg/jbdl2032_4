package com.gfg.imdbdemo.controller;

import com.gfg.imdbdemo.domain.Review;
import com.gfg.imdbdemo.service.ReviewService;
import com.gfg.imdbdemo.service.request.ReviewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    ReviewService reviewService;

    @PostMapping("/add/review")
    public void addReview(@RequestBody ReviewRequest reviewRequest){
        reviewService.addReview(reviewRequest.toReview());
    }

    @GetMapping("/find/review")
    public Review getReview(@RequestParam Long reviewId){
       return reviewService.getReviewById(reviewId);
    }
}
