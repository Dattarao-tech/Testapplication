package com.sts.springboot.topiccontroller;

import java.util.Arrays;
import java.util.List;

public class TopicService {

	List<Topic> topics = Arrays.asList(new Topic("java " ,"java  framework" , "java framework Descripation"),
			new Topic("Spring " ,"Spring framewok" , "Spring framework Descripation"),
			new Topic("javascript " ," javascript Spring framewok" , "javascript framework Descripation"));
	
	public List<Topic> getAllTopic(){
		return topics;

	}
}
