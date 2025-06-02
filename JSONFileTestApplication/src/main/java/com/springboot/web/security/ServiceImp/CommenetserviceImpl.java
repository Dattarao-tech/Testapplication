package com.springboot.web.security.ServiceImp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.web.security.Entity.Comment;
import com.springboot.web.security.Entity.CommentData;
import com.springboot.web.security.Service.CommentService;

import lombok.Setter;

@Service
public class CommenetserviceImpl implements CommentService{
	
//	private final List<Comment> comments;
	public CommenetserviceImpl() {
//		this.comments=CommentData.getComments();	
	}
	@Override
	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return null;
	}	
}
	
