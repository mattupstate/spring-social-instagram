package org.springframework.social.instagram.api;

import java.util.List;

public class CommentsInfo {
    
    private final int total;
    private final List<Comment> list;
    
    public CommentsInfo(int total, List<Comment> list) {
        this.total = total;
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public List<Comment> getList() {
        return list;
    }
}
