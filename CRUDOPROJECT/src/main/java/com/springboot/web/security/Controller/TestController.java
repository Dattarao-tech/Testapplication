package com.springboot.web.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.security.Entity.TestEntity;
import com.springboot.web.security.Service.DataBaseService;
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	  @Autowired
	  private DataBaseService databaseService;
	
	  @PostMapping("/cred")
	  public ResponseEntity<TestEntity> createRecord(@RequestBody TestEntity testEntity) {		   
	    	databaseService.CreateData(testEntity);
	        return new ResponseEntity<>(HttpStatus.CREATED);
	 	}
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
	        databaseService.DeletData(1L);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<TestEntity> updateRecord(@PathVariable Long id) {
	        databaseService.UpdateData(id);
	        return new ResponseEntity<TestEntity>(HttpStatus.OK);
	    }
	    @GetMapping("/{id}")
	    public ResponseEntity<TestEntity> getRecord(@PathVariable Long id) {
	        TestEntity entity = databaseService.findById(id);
	        if (entity != null) {
	            return new ResponseEntity<>(entity, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    // Additional methods as needed
}
