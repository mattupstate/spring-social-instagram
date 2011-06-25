package org.springframework.social.instagram.api.impl;

abstract class AbstractInstagramResponseContainer<C> {

    private C object;
    
    AbstractInstagramResponseContainer(C object) {
        this.object = object;
    }
    
    public C getObject() {
        return object;
    }
}
