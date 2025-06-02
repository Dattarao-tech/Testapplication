package com.springboot.web.security.Entity;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Output {
		private String content;
	    private int noofreplies;
	    private List<Comment> repliedmessages;
}
