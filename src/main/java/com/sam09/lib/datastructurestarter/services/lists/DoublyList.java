package com.sam09.lib.datastructurestarter.services.lists;

import com.sam09.lib.datastructurestarter.constants.Traversal;

import java.util.List;

/**
 * @author soumyabrata09
 */
public interface DoublyList {
    int sizeOf();
    List traverse(Traversal movement);
    void prepend(Object data);
    void append(Object data);
    void insertAt(Object data, int index) throws Exception;
    AdvancedNode removeFirst() throws Exception;
    AdvancedNode removeLast() throws Exception;
    AdvancedNode removeAt(int index) throws Exception;
    AdvancedNode getHead();
    AdvancedNode getTail();
}
