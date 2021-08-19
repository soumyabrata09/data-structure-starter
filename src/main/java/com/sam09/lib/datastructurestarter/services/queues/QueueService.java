package com.sam09.lib.datastructurestarter.services.queues;

import com.sam09.lib.datastructurestarter.constants.ErrorConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QueueService implements  Queue{
    private static final Logger log = LoggerFactory.getLogger(QueueService.class);
    //Implementing Queue with Array
    private Object[] queueElement;
    private int capacity;
    private int rear;
    private int front;
    private int size;

    public QueueService(int capacity) {
        this.capacity = capacity;
        rear = 0;
        front = 0;
        size = 0;
        queueElement = new Object[this.capacity];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public boolean enqueue(Object data) {
        if (size == capacity){
            log.info("Can not enqueue any new element as: " + ErrorConst.QUEUE_FULL.getMessage());
            return false;
        }
        else {
            queueElement[rear] = data;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }
    }

    @Override
    public Object dequeue() throws Exception {
        if (isEmpty()) {
            log.error("Cannot dequeue any element as: " + ErrorConst.EMPTY_QUEUE.getMessage());
            throw new Exception(ErrorConst.EMPTY_QUEUE.getMessage());
        }
        else {
            Object dequeuedData = queueElement[front];
            front = (front + 1) % capacity;
            size--;
            //update the queueElement after dequeue operation
           /* queueElement = IntStream.range(front,queueElement.length)
                    .filter( e -> e != front)
                    .mapToObj(e -> queueElement[e])
                    .toArray();*/
            return dequeuedData;
        }
    }

    @Override
    public List<Object> printQueue() {
        /*
        List<Object> list = new ArrayList<>();
        for (int i= front; i< queueElement.length -1; i++) {
            list.add(queueElement[i]);
        }*/
        return Arrays
                .stream(queueElement, front, queueElement.length - 1)
                .collect(Collectors.toList());
    }

    @Override
    public int sizeOf() {
        return this.size;
    }
}
