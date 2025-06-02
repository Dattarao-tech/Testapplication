package com.springboot.web.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.security.Entity.Task;
import com.springboot.web.security.service.TaskServiceimpl;

@RestController
@RequestMapping("/api")
public class TestController {

	  @Autowired
	  private TaskServiceimpl taskServiceimpl;
	  @PostMapping
	   public ResponseEntity<Task> createTask(@RequestBody Task task) {
	     Task createdTask = taskServiceimpl.createTask(task);
	     return ResponseEntity.ok(createdTask); 
	 }
}
