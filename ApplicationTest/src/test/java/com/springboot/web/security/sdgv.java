package com.springboot.web.security;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.springboot.web.security.Controller.StringOccuranceController;
import com.springboot.web.security.Service.StringOcuuranceRequest;

class sdgv {
	@Test
    void testCountOccurrences() {
        // Create an instance of the class containing countOccurrences method
    StringOccuranceController yourClassUnderTest = new StringOccuranceController();
        // Prepare test data
        StringOcuuranceRequest request = new StringOcuuranceRequest();
        request.setInputeString(Arrays.asList("abc", "abcd", "ab"));
        request.setQuearyString(Arrays.asList("ab", "abc", "abcd", "xyz"));

        // Call the method and get the result
        List<Integer> result = yourClassUnderTest.countOccurrences(request);
        // Assert the expected result
        List<Integer> expectedResult = Arrays.asList(6, 8, 9, 0);
        assertEquals(expectedResult, result);
    }
    @Test
    void testCountOccurrencesWithNullInput() {
        // Create an instance of the class containing countOccurrences method
    	StringOccuranceController yourClassUnderTest = new StringOccuranceController();

        // Prepare test data with null inputStrings
        StringOcuuranceRequest request = new StringOcuuranceRequest();
        request.setInputeString(null);
        request.setQuearyString(Arrays.asList("ab", "abc", "abcd", "xyz"));

        // Assert that the method throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            yourClassUnderTest.countOccurrences(request);
        });
    }
    @Test
    void testCountOccurrencesWithNullQuery() {
        // Create an instance of the class containing countOccurrences method
    	StringOccuranceController yourClassUnderTest = new StringOccuranceController();

        // Prepare test data with null queryStrings
        StringOcuuranceRequest request = new StringOcuuranceRequest();
        request.setInputeString(Arrays.asList("abc", "abcd", "ab"));
        request.setQuearyString(null);

        // Assert that the method throws IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            yourClassUnderTest.countOccurrences(request);
        });
    }
}

