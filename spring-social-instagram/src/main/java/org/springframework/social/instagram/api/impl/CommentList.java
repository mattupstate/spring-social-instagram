package org.springframework.social.instagram.api.impl;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.instagram.api.Comment;

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
