package com.springboot.web.security.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.web.security.Service.StringOccuranceService;
import com.springboot.web.security.Service.StringOcuuranceRequest;
import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/api")
public class StringOccuranceController {
	
	    @Autowired
	    StringOccuranceService stringOccuranceService;

	    public StringOccuranceController(StringOccuranceService stringOccuranceService) {
	        this.stringOccuranceService = stringOccuranceService;
	    }
	    public StringOccuranceController() {
			// TODO Auto-generated constructor stub
		}
		@PostMapping("/countOccurrences")
	    public List<Integer> countOccurrences(HttpServletRequest httpRequest) throws JsonMappingException, JsonProcessingException {
	        String requestBody = getRequestBody(httpRequest);
	        StringOcuuranceRequest request = parseJson(requestBody, StringOcuuranceRequest.class);
	        return stringOccuranceService.countOccurrences(request);
	    }
	   private StringOcuuranceRequest parseJson(String requestBody, Class<StringOcuuranceRequest> class1) throws JsonMappingException, JsonProcessingException{
			// TODO Auto-generated method stub
	            ObjectMapper objectMapper = new ObjectMapper();
	            return objectMapper.readValue(requestBody, class1);	       
	        }
	    private String getRequestBody(HttpServletRequest httpRequest) {
	        try {
	            BufferedReader reader = httpRequest.getReader();
	            StringBuilder stringBuilder = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                stringBuilder.append(line);
	            }
	            return stringBuilder.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("Error reading the request body", e);
	        }
	  }
	   @PostMapping("/api/countOccurrences")
	    public List<Integer> countOccurrences(@RequestBody StringOcuuranceRequest request) {
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
	            int count = 0;
	            for (int i = 1; i <= query.length(); i++) {
	                String substring = query.substring(0, i);
	                count += stringOccurrences.getOrDefault(substring, 0);
	            }
	            result.add(count);
	        }
//
	        return result;
	   }
//	public List<Integer> countOccurrences(List<String> inputStrings, List<String> queryStrings) {
//        List<Integer> result = new ArrayList<>();
//        Map<String, Integer> stringOccurrences = new HashMap<>();
//
//        for (String s : inputStrings) {
//            for (int i = 1; i <= s.length(); i++) {
//                String substring = s.substring(0, i);
//                stringOccurrences.put(substring, stringOccurrences.getOrDefault(substring, 0) + 1);
//            }
//        }
//        for (String query : queryStrings) {
//            int count = 0;
//            for (int i = 1; i <= query.length(); i++) {
//                String substring = query.substring(0, i);
//                count += stringOccurrences.getOrDefault(substring, 0);
//            }
//            result.add(count);
//        }
//        return result;
//
////	@PostMapping("/api/countOccurrences")
////    public ResponseEntity<List<Integer>> countOccurrences(@RequestBody StringOcuuranceRequest request) {
////        List<Integer> results = stringOccuranceService.countOccurrences(request.getInputeString(), request.getQuearyString());
////        return ResponseEntity.ok(results);
////    }
	   
}


