package com.springboot.web.security.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.web.security.Service.RatingRequest;
import com.springboot.web.security.Service.RatingService;
@RestController
@RequestMapping("/api")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	 @PostMapping("/adduser")
	 @ResponseBody
	 public String addRating( @RequestBody RatingRequest  request) {
		return ratingService.addRating(request.getUser(), request.getRating());
	    }
	    @GetMapping("/average/{user}")
	    @ResponseBody
	    public ResponseEntity<?> getAverageRating(@PathVariable String user) {
	        Double averageRating = ratingService.getAverageRating(user);

	        if (averageRating != null) {
	            return ResponseEntity.ok().body("Average rating for user " + user + ": " + averageRating);
	        } else {
	            return ResponseEntity.ok().body("No ratings available for user " + user);
	        }
	    }
	    @GetMapping("/all/{user}")
	    @ResponseBody
	    public ResponseEntity<?> getAllRatingsForUser(@PathVariable String user) {
	        List<Integer> ratings = ratingService.getAllRatingsForUser(user);
	        
	        if (!ratings.isEmpty()) {
	            return ResponseEntity.ok().body("Ratings for user " + user + ": " + ratings);
	        } else {
	            return ResponseEntity.ok().body("No ratings available for user " + user);
	        }
	    }
	  }