package org.springframework.social.instagram.api;

import java.util.List;

public class PagedMediaList {
	
    private final List<Media> list;
    private final Pagination pagination;
    
    public PagedMediaList(List<Media> list, Pagination pagination) {
	    this.list = list;
	    this.pagination = pagination;
	}
    
	public Pagination getPagination() {
	    return pagination;
	}
	
	public List<Media> getList() {
	    return list;
	}
}
