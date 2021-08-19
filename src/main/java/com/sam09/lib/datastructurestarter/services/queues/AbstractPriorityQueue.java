package com.sam09.lib.datastructurestarter.services.queues;

import java.util.List;
import java.util.Objects;

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

    abstract public Object popMax() throws Exception;
    abstract public Object peekMax() throws Exception;
    abstract public boolean insert(int key, Object value) throws Exception;
    abstract public int sizeOf();
    abstract public int capacity();
    abstract public List<QueueItem> printQueue();
}
