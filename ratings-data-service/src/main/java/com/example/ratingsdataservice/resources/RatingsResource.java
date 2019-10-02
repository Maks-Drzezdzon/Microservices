package com.example.ratingsdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingsdataservice.models.Rating;
import com.example.ratingsdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	
	@RequestMapping("/{movieId}")
	public Rating getMoiveRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 1);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		/*
		 * wrap data in object to make api more backward compatible 
		 */
		UserRating userRating = new UserRating();
		userRating.initData(userId);
		return userRating;
	}
	
}
