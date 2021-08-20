package com.sam09.lib.datastructurestarter.services.lists;

import java.util.List;

/**
 * @author soumyabrata09
 */
public interface SinglyList {
    void prepend(Object data);
    void insertAt(Object data, int index) throws Exception;
    Node removeFirst() throws Exception;
    Node removeAt(int index) throws Exception;
    List traverse();
    int sizeOf();
    Node getHead();
    //void rotate(int index) throws Exception;
}
