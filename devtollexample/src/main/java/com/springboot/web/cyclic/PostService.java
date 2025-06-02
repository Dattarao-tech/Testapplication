package com.springboot.web.cyclic;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	private CommentService commentservice;
	PostService(@Lazy CommentService commentservice){
		this.commentservice=commentservice;
		
	}
}
