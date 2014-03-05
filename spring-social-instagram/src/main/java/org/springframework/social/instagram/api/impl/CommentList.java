package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.social.instagram.api.Comment;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CommentList {
	
	private List<Comment> list;
	
	public CommentList(@JsonProperty("data") List<Comment> list) {
		this.list = list;
	}
	
	public List<Comment> getList() {
		return list;
	}
	
}
