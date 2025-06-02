package com.springboot.web.cyclic;

import org.springframework.stereotype.Service;

@Service
public class CommentService {
	
	private PostService postService;

	public CommentService(PostService postService) {
		
		this.postService = postService;
	}
	
}
