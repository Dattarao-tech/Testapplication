package com.springboot.web.security.Entity;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.springboot.web.security.Repository.TestRepo;
import com.springboot.web.security.Service.DataBaseService;
@Component
public class FileProccessorScheduler {
	  
	@Autowired
	 private TestRepo testrepo;  // Assuming TestRepo is autowired properly
	  
	  @Autowired
	  private DataBaseService databaseService;

	    @Scheduled(fixedRate = 60000) // Run every 60 seconds, adjust as needed
	    public void processFile() {
	        try {
	            // Read the text file from the local directory
	            String filePath = "C:\\Users\\Microsoft\\Desktop\\titorial\\example.txt";
	            java.nio.file.Path path = Paths.get(filePath);
	            List<String> fileLines = Files.readAllLines(path);

	            // Process each line and perform database operations
	            for (String line : fileLines) {
	                processFileEntry(line);
	            }
	        } catch (Exception e) {
	            // Handle exceptions (e.g., file not found, parsing errors)
	            // Create a separate file for wrong entries
	            createErrorFile("C:\\Users\\Microsoft\\Desktop\\titorial\\errora.txt", e.getMessage());
	        }
	    }
	    public void processFileEntry(String entry) {
	        // Assuming the format is: "StatusCode,Data"
	        String[] parts = entry.split(",");
	        if (parts.length == 2) {
	            String statusCode = parts[0].trim();
	            String data = parts[1].trim();
	            
	            switch (statusCode) {
	                case "A":
	                    // Assuming testrepo.save returns the saved TestEntity
	                    TestEntity testEntityA = new TestEntity();  // Create TestEntity based on your needs
	                    testEntityA.setData(data);
	                    testrepo.save(testEntityA);
	                    break;
	                case "B":
	                    // Assuming data contains the ID to delete
	                    try {
	                        Long entityId = Long.parseLong(data);
	                        testrepo.deleteById(entityId);
	                    } catch (NumberFormatException e) {
	                        createErrorFile("C:\\Users\\Microsoft\\Desktop\\titorial\\errorb.txt", "Invalid ID for deletion: " + data);
	                    }
	                    break;
	                    
	                case "C":
	                    // Assuming data contains the ID and new data
	                    String[] updateParts = data.split(":");
	                    if (updateParts.length == 2) {
	                        try {
	                            Long entityId = Long.parseLong(updateParts[0].trim());
	                            String newData = updateParts[1].trim();
	                            databaseService.UpdateData(entityId);
	                        } catch (NumberFormatException e) {
	                            createErrorFile("C:\\Users\\Microsoft\\Desktop\\titorial\\errorb.txt", "Invalid ID for update: " + updateParts[0]);
	                        }
	                    } else {
	                        createErrorFile("path/to/your/error-file.txt", "Invalid format for update: " + data);
	                    }
	                    break;
	                // Add cases for other status codes as needed
	                default:
	                    createErrorFile("path/to/your/error-example.txt", "Unknown status code: " + statusCode);
	            }
	        } else {
	            createErrorFile("C:\\Users\\Microsoft\\Desktop\\titorial\\errorc.txt", "Invalid format: " + entry);
	        }
	    }
	    private void createErrorFile(String filePath, String errorMessage) {
	        try {
	            // Create a Path object for the error file
	            java.nio.file.Path errorFilePath = Paths.get(filePath);

	            // Check if the error file already exists, create it if not
	            if (!Files.exists(errorFilePath)) {
	                Files.createFile(errorFilePath);
	            }
	            // Append the error message to the error file
	            Files.write(errorFilePath, errorMessage.getBytes(), StandardOpenOption.APPEND);

	        } catch (Exception e) {
	            // Handle IOException (e.g., file creation error)
	            e.printStackTrace();
	        }
	    }
	}
