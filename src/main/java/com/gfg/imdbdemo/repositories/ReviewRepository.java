package com.gfg.imdbdemo.repositories;

import com.gfg.imdbdemo.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
