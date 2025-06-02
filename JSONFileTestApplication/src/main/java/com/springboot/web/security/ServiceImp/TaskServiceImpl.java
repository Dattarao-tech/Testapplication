package com.springboot.web.security.ServiceImp;

import org.springframework.stereotype.Service;

import com.springboot.web.security.Entity.Task;
import com.springboot.web.security.Service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	public Task createTask(Task task) {
		// TODO Auto-generated method stub
		task.setId(12l);
		task.setDescription("this is somethinge to maashge");
		return task;
		
	}
}
