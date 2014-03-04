package org.springframework.social.instagram.api.impl;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.social.instagram.api.Tag;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TagList {
	
	private List<Tag> list;
	
	@JsonCreator
	public TagList(@JsonProperty("data") List<Tag> list) {
		this.list = list;
	}
	
	public List<Tag> getList() {
		return list;
	}
}
