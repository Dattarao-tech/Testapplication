package com.springboot.web.security.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
@Service
public class StringOccuranceService {
	
	public List<Integer> countOccurrences(StringOcuuranceRequest request) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> stringOccurrences = new HashMap<>();
        List<String> inputStrings = request.getInputeString();
        List<String> queryStrings = request.getQuearyString();

        if (inputStrings == null || queryStrings == null) {
            throw new IllegalArgumentException("Both inputStrings and queryStrings must be provided");
        }
        // Count occurrences of each string in the inputStrings
        for (String s : inputStrings) {
            for (int i = 1; i <= s.length(); i++) {
                String substring = s.substring(0, i);
                stringOccurrences.put(substring, stringOccurrences.getOrDefault(substring, 0) + 1);
            }
        }
        // Count occurrences of each queryString using the precomputed occurrences
        for (String query : queryStrings) {
            int count = stringOccurrences.getOrDefault(query, 0);
            result.add(count);
        }
        return result;	
//	 public List<Integer> countOccurrences(StringOcuuranceRequest request) {
//	        List<Integer> result = new ArrayList<>();
//	        Map<String, Integer> stringOccurrences = new HashMap<>();
//
//	        List<String> inputStrings = request.getInputeString();
//	        List<String> queryStrings = request.getQuearyString();
//
//	        if (inputStrings == null || queryStrings == null) {
//	            throw new IllegalArgumentException("Both inputStrings and queryStrings must be provided");
//	        }
//
//	        // Count occurrences of each string in the inputStrings
//	        for (String s : inputStrings) {
//	            for (int i = 1; i <= s.length(); i++) {
//	                String substring = s.substring(0, i);
//	                stringOccurrences.put(substring, stringOccurrences.getOrDefault(substring, 0) + 1);
//	            }
//	        }
//
//	        // Count occurrences of each queryString using the precomputed occurrences
//	        for (String query : queryStrings) {
//	            int count = 0;
//	            for (int i = 1; i <= query.length(); i++) {
//	                String substring = query.substring(0, i);
//	                count += stringOccurrences.getOrDefault(substring, 0);
//	            }
//	            result.add(count);
//	        }
//	        return result;
	
	}
}