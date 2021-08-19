package com.sam09.lib.datastructurestarter.services.queues;

import com.sam09.lib.datastructurestarter.utility.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
public class QueueServiceTest {

    private static final Logger log = LoggerFactory.getLogger(QueueServiceTest.class);
    private int capacity = 10;
    Queue queue;

    @Before
    public void setUp() throws Exception {
        queue = new QueueService(capacity);
    }

    @Test
    public void isEmptyTest() {
        log.info("Initially Queue isEmpty(): " + queue.isEmpty());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void capacityTest() {
        assertNotNull(queue.capacity());
        log.info("Queue Capacity: " + queue.capacity());
        assertEquals(capacity,queue.capacity());
    }

    @Test
    public void enqueueTest() {
        queue = TestUtils.populateQueueData(); // this utility by default populates 5 random data
        log.info("Queue Elements after enqueue operation: " + queue.printQueue());
        assertEquals(5,queue.sizeOf());
    }

    @Test
    public void dequeueTest() throws Exception {
        queue = TestUtils.populateQueueData(); // this utility by default populates 5 random data
        queue.enqueue("ASSD");
        log.info("Queue Elements after enqueue operation: " + queue.printQueue());

        Object removed = null;
        removed = queue.dequeue();
        log.info("Deleted Queue element: " + removed);
        log.info("Queue Elements after dequeue operation: " + queue.printQueue());

        removed = queue.dequeue();
        log.info("Deleted Queue element: " + removed);
        log.info("Queue Elements after dequeue operation: " + queue.printQueue());

        assertEquals(3,queue.sizeOf());
    }

}