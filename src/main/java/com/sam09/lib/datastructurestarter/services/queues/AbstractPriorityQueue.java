package com.sam09.lib.datastructurestarter.services.queues;

import java.util.List;
import java.util.Objects;

/**
 * @author soumyabrata09
 */
public abstract class AbstractPriorityQueue {
    class QueueItem {
        private int key;
        private Object value;

        public QueueItem() {
            this.key = 0;
            this.value = null;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            QueueItem queueItem = (QueueItem) o;
            return key == queueItem.key && Objects.equals(value, queueItem.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return "QueueItem{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    /**
     * @return Returns a PriorityQueue Object
     * @throws Exception
     */
    abstract public Object popMax() throws Exception;

    /**
     * @return Returns a PriorityQueue Object
     * @throws Exception
     */
    abstract public Object peekMax() throws Exception;

    /**
     * @param key Priority of the List
     * @param value Actual value of the List
     * @return Returns boolean flag
     * @throws Exception
     */
    abstract public boolean insert(int key, Object value) throws Exception;

    /**
     * @return Returns the size of the PriorityQueue
     */
    abstract public int sizeOf();

    /**
     * @return Returns the capacity of the PriorotyQueue
     */
    abstract public int capacity();

    /**
     * @return It adds the queue elements to ArrayList and returns it
     */
    abstract public List<QueueItem> printQueue();
}
