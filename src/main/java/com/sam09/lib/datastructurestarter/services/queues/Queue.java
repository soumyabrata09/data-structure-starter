package com.sam09.lib.datastructurestarter.services.queues;

import java.util.List;

public interface Queue {
    boolean isEmpty();
    int capacity();
    boolean enqueue(Object data);
    Object dequeue() throws Exception;
    List<Object> printQueue();
    int sizeOf();
}
