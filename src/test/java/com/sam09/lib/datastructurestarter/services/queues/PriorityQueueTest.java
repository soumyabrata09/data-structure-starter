package com.sam09.lib.datastructurestarter.services.queues;

import com.sam09.lib.datastructurestarter.utility.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class)
public class PriorityQueueTest {

    private static final Logger log = LoggerFactory.getLogger(PriorityQueueTest.class);
    PriorityQueue priorityQueue;
    private int capacity = 5;

    @Before
    public void setUp() throws Exception {
        priorityQueue = TestUtils.populatePQ(new PriorityQueue(capacity));
    }

    @Test
    public void sizeOf() {
    }

    @Test
    public void capacityTest() {
        assertEquals(capacity,priorityQueue.capacity());
    }

    @Test
    public void insertTest() {
        log.info("Priority Queue contents: " + priorityQueue.printQueue());
        assertEquals(capacity,priorityQueue.sizeOf());
    }

    @Test
    public void popMaxTest() throws Exception {
        log.info("Priority Queue contents before popping Max item: " + priorityQueue.printQueue()
                + " & sizeOf: " + priorityQueue.sizeOf());
        Object removed = priorityQueue.popMax();
        log.info("Popped item: " + removed);
        log.info("Priority Queue contents after popping Max item: " + priorityQueue.printQueue()
                + " & sizeOf: " + priorityQueue.sizeOf());

        assertEquals(4,priorityQueue.sizeOf());
    }

    @Test
    public void peekMaxTest() throws Exception {
        Object peeked = priorityQueue.peekMax();
        log.info("Peeked element: " + peeked);
        assertNotNull(peeked);
    }

}