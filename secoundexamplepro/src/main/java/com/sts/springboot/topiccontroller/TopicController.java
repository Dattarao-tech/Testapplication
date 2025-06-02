package com.sts.springboot.topiccontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@RequestMapping("/Demo")
	public List<Topic> getAllTopic() {
		return 	Arrays.asList(new Topic("Spring " ,"Spring framewok" , "Spring framework Descripation"),
				new Topic("java " ,"java framewok" , "java framework Descripation"),
				new Topic("javacript " ," javacript framewok" , "javasrcreept  framework Descripation"));
	}
  }
