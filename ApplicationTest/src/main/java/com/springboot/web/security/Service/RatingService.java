package com.springboot.web.security.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RatingService {
	
	private Map<String, List<Integer>> ratingsMap = new HashMap<>();
	
    public String addRating(String user, int rating) {
        // Check if the user exists in the map
        if (ratingsMap.containsKey(user)) {
            // User exists, add the rating to the existing list
            List<Integer> userRatings = ratingsMap.get(user);
            userRatings.add(rating);
        } else {
            // User does not exist, create a new list and add the rating
            List<Integer> newRatingList = new ArrayList<>();
            newRatingList.add(rating);
            ratingsMap.put(user, newRatingList);
        }

        return "Rating added successfully for user: " + user;
    }
    public Double getAverageRating(String user) {
        // Check if the user exists in the map
        if (ratingsMap.containsKey(user)) {
            // User exists, calculate the average rating
            List<Integer> userRatings = ratingsMap.get(user);
            int totalRating = userRatings.stream().mapToInt(Integer::intValue).sum();
            return (double) totalRating / userRatings.size();
        } else {
            // User does not exist, return null or a default value as needed
            return null;
        }
    }
    public List<Integer> getAllRatingsForUser(String user) {
        // Check if the user exists in the map
        if (ratingsMap.containsKey(user)) {
            // User exists, return all ratings for the user
            return ratingsMap.get(user);
        } else {
            // User does not exist, return an empty list or handle it as needed
            return new ArrayList<>();
        }
    }
}
