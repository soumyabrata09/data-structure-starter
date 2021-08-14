package com.sam09.lib.datastructurestarter.services;

import java.util.List;

public interface SinglyList {
    void prepend(Object data);
    void insertAt(Object data, int index) throws Exception;
    Node removeFirst() throws Exception;
    Node removeAt(int index) throws Exception;
    List traverse();
    int sizeOf();
    //void rotate(int index) throws Exception;
}
