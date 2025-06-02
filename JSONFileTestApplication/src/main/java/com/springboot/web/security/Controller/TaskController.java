package com.springboot.web.security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.security.Entity.Task;
import com.springboot.web.security.ServiceImp.TaskServiceImpl;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private  TaskServiceImpl  taskServiceImpl;

	    @PostMapping
	  public ResponseEntity<Task> createTask(@RequestBody Task task) {
	       Task createdTask = taskServiceImpl.createTask(task);
	        System.out.println(task);
	        return ResponseEntity.ok(createdTask);
	        
	}
}