package com.springboot.web.security.model;

import org.springframework.context.annotation.Bean;

import com.springboot.web.security.Entity.Task;
import com.springboot.web.security.service.TaskServiceimpl;

public class AppConfig {
	
    @Bean
    public TaskServiceimpl taskService() {
        return new TaskServiceimpl() {
			
			@Override
			public Task createTask(Task task) {
				// TODO Auto-generated method stub
				return null;
			}
		};
    }
}
