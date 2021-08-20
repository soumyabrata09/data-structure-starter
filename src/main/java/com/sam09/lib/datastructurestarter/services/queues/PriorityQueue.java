package com.sam09.lib.datastructurestarter.services.queues;

import com.sam09.lib.datastructurestarter.constants.ErrorConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author soumyabrata09
 */
@Service
public class PriorityQueue extends AbstractPriorityQueue{
    private static final Logger log = LoggerFactory.getLogger(PriorityQueue.class);

    private int size;
    private QueueItem[] elements;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        size = 0;
        elements = new QueueItem[this.capacity];
    }

    @Override
    public boolean insert(int key, Object value) throws Exception {
        if ( size > capacity ) {
            log.info("Insertion operation failed as: " + (size <0 ? ErrorConst.EMPTY_QUEUE.getMessage() : ErrorConst.QUEUE_FULL.getMessage()));
            throw new Exception( (size <0  ? ErrorConst.EMPTY_QUEUE.getMessage() : ErrorConst.QUEUE_FULL.getMessage()) );
        }
        else {
            QueueItem item = new QueueItem();
            item.setKey(key);
            item.setValue(value);
            elements[size] = item;
            size++;
            return true;
        }
    }

    @Override
    public Object popMax() throws Exception {
        if (size <0) {
            log.info("Pop operation can not be performed as: " + ErrorConst.EMPTY_QUEUE.getMessage());
            throw new Exception(ErrorConst.EMPTY_QUEUE.getMessage());
        }
        else {
            IntStream.range(0, size)
                    .filter(i -> elements[i].getKey() > elements[size - 1].getKey())
                    .forEach(i -> {
                            QueueItem temp = elements[i];// swapping to the end of the array
                            elements[i] = elements[size - 1];
                            elements[size - 1] = temp;
                    });
            QueueItem max = elements[size-1];
            elements[size-1] = null;
            size--;
            return max.getValue();
        }
    }

    @Override
    public Object peekMax() throws Exception {
        if (size <0) {
            log.info("Peeking operation can not be performed as: " + ErrorConst.EMPTY_QUEUE.getMessage());
            throw new Exception(ErrorConst.EMPTY_QUEUE.getMessage());
        }
        else {
            /*for (int i = 0; i < size; i++) {
                if (elements[i].getKey() > elements[size-1].getKey()) {
                    QueueItem temp = elements[i];// swapping to the end of the array
                    elements[i] = elements[size-1];
                    elements[size-1] = temp;
                }
            }*/

            IntStream.range(0, size)
                    .filter(i -> elements[i].getKey() > elements[size - 1].getKey())
                    .forEach(i -> {
                        QueueItem temp = elements[i];// swapping to the end of the array
                        elements[i] = elements[size - 1];
                        elements[size - 1] = temp;
                    });
            return elements[size-1].getValue();
        }
    }

    @Override
    public int sizeOf() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public List<QueueItem> printQueue() {
        List<QueueItem> list = Arrays.stream(elements)
                .collect(Collectors.toList());
        return list;
    }
}
