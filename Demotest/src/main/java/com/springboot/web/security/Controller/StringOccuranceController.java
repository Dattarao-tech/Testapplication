package com.springboot.web.security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.security.Sevice.StringOccuranceRequst;


@RestController
@RequestMapping("/api/test")
public class StringOccuranceController {
	@Autowired
	private StringOccuranceRequst stringOccuranceService;
	
    @SuppressWarnings("unchecked")
	@PostMapping("/countOccurrences")
    public static ResponseEntity<List<Integer>> countOccurrences(@RequestBody StringOccuranceRequst request) {
    	System.out.println("reciveed request "+request);
        List<Integer> result = null;
		try {
			result = (List<Integer>) StringOccuranceController.countOccurrences(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.ok(result);
     }   
}