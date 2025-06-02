package com.springboot.web.security.Service;

import java.util.List;
import java.util.Map;

import com.springboot.web.security.Entity.Comment;

public interface CommentService {   
	List<Comment> getAllComments();
	
//	List<Map<String, Object>> transformComments(List<Comment> comments);
//	Map<String, List<Map<String, Object>>> generateOutputFormat(List<Comment> comments);
}
