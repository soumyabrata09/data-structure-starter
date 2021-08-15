package com.sam09.lib.datastructurestarter.services.LinkedLists;

public class AdvancedNode {
    private Object data;
    private AdvancedNode prev;
    private AdvancedNode next;

    public AdvancedNode(Object data, AdvancedNode prev, AdvancedNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public AdvancedNode getPrev() {
        return prev;
    }

    public void setPrev(AdvancedNode prev) {
        this.prev = prev;
    }

    public AdvancedNode getNext() {
        return next;
    }

    public void setNext(AdvancedNode next) {
        this.next = next;
    }
}
