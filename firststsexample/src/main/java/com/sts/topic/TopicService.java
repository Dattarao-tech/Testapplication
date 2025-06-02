package com.sts.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
List<Topic> topics=	Arrays.asList(new Topic(11 ," java springframework" ,"	java Descripation"),
			new Topic(222 ,"springframework" ,"spring	Descripation"),
			new Topic(3333 ," spring boot framework" ,"spring boot	Descripation"));

public List<Topic> getAllTopic(){
	
	return topics;
}
public Topic getTopic(int id) {
	

	return	topics.stream().filter(t -> t.getId()==id).findFirst().get();
	
}
}
