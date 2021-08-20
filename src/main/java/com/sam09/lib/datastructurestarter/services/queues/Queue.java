package com.sam09.lib.datastructurestarter.services.queues;

import java.util.List;

/**
 * @author soumyabrata09
 */
public interface Queue {
    /**
     * @return Determines whether a Queue is Empty
     */
    boolean isEmpty();

    /**
     * @return Determines the capacity of the Queue and returns the same
     */
    int capacity();

    /**
     * @param data Queue data which to be inserted
     * @return Returns a boolean flag based on the success/failure of the operation
     */
    boolean enqueue(Object data);

    /**
     * @return Returns the Queue object
     * @throws Exception
     */
    Object dequeue() throws Exception;

    /**
     * @return It prints the Queue elements
     */
    List<Object> printQueue();

    /**
     * @return Determines the size of the Queue and returns the same
     */
    int sizeOf();
}
