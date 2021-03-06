package com.sam09.lib.datastructurestarter.services.lists;

import com.sam09.lib.datastructurestarter.constants.Traversal;
import com.sam09.lib.datastructurestarter.utility.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//@RunWith(SpringJUnit4ClassRunner.class)
public class DoublyLinkedListTest {

    private static final Logger log = LoggerFactory.getLogger(DoublyLinkedListTest.class);
    DoublyLinkedList linkedList;

    @Before
    public void setUp() throws Exception {
        linkedList = new DoublyLinkedList();
    }

    @Test
    public void sizeOfTest() throws Exception {
        linkedList = TestUtils.populateDoublyList();
        assertNotNull(linkedList.sizeOf());
        assertEquals(4,linkedList.sizeOf());
    }

    @Test
    public void traverseForwardTest() {
        linkedList.prepend(923);
        linkedList.prepend(641);
        linkedList.append(193);
        linkedList.append(266);

        List<Object> traversedList = linkedList.traverse(Traversal.FORWARD);
        log.info("List Value  Forward: " + traversedList);
        for (Object data : traversedList) {
            assertNotNull(data);
        }
    }

    @Test
    public void traverseBackwardTest() {
        linkedList.prepend(923);
        linkedList.prepend(641);
        linkedList.append(193);
        linkedList.append(266);
        List<Object> traversedList = linkedList.traverse(Traversal.BACKWARD);
        log.info("List Value Backward: " + traversedList);
        for ( Object data : traversedList ) {
            assertNotNull(data);
        }
    }

    @Test
    public void prependTest() throws Exception {
        linkedList = TestUtils.populateDoublyList();// by default it populates 4 node data with random value
        linkedList.prepend(23);
        log.info("List of Data after Prepending: " + linkedList.traverse(Traversal.FORWARD));
        assertEquals(5, linkedList.sizeOf());
        log.info("HEAD Data: " + linkedList.getHead().getData());
        assertEquals(23,linkedList.getHead().getData());
    }

    @Test
    public void appendTest() throws Exception {
        linkedList = TestUtils.populateDoublyList(); // by default it populates 4 node data with random value
        linkedList.append(32);
        log.info("List of Data after Appending: " + linkedList.traverse(Traversal.FORWARD));
        assertEquals(5, linkedList.sizeOf());
        log.info("TAIL Data: " + linkedList.getTail().getData());
        assertEquals(32,linkedList.getTail().getData());
    }

    @Test
    public void insertAtTestValid() throws Exception {
        int INDEX = 3;
        linkedList = TestUtils.populateDoublyList(); // by default it populates 4 node data with random value
        log.info("List of value before insertion at " + INDEX + ": " + linkedList.traverse(Traversal.FORWARD));
        linkedList.insertAt(TestUtils.randomize(
                TestUtils.DEFAULT_RAND_LENGTH),INDEX);
        log.info("List of value after insertion at " + INDEX + ": " + linkedList.traverse(Traversal.FORWARD));
        assertEquals(5,linkedList.sizeOf());
    }

    @Test(expected = Exception.class)
    public void insertAtTestInvalid() throws Exception {
        linkedList.insertAt(TestUtils.randomize(
                TestUtils.DEFAULT_RAND_LENGTH),7);
    }

    @Test
    public void removeFirstValid() throws Exception {
        linkedList = TestUtils.populateDoublyList(); // by default it populates 4 node data with random value
        log.info("List of value before removal of first node: " + linkedList.traverse(Traversal.FORWARD));
        linkedList.removeFirst();
        log.info("List of value after removing first node: " + linkedList.traverse(Traversal.FORWARD));
        assertEquals(3, linkedList.sizeOf());
    }

    @Test(expected = Exception.class)
    public void removeFirstInvalid() throws Exception {
        linkedList.removeFirst();
    }

    @Test
    public void removeLastValid() throws  Exception {
        linkedList = TestUtils.populateDoublyList(); // by default it populates 4 node data with random value
        log.info("List of value before removal of last node: " + linkedList.traverse(Traversal.FORWARD));
        linkedList.removeLast();
        log.info("List of value after removing last node: " + linkedList.traverse(Traversal.FORWARD));
        assertEquals(3,linkedList.sizeOf());
    }

    @Test(expected = Exception.class)
    public void removeLastInvalid() throws  Exception {
        linkedList.removeLast();
    }

    @Test
    public void removeAtValid() throws Exception {
        int INDEX = 2;
        linkedList = TestUtils.populateDoublyList(); // by default it populates 4 node data with random value
        log.info("List of value before removal at " + INDEX +": " + linkedList.traverse(Traversal.FORWARD));
        linkedList.removeAt(INDEX);
        log.info("List of value after removing node at " + INDEX + ": " + linkedList.traverse(Traversal.FORWARD));
        assertEquals(3,linkedList.sizeOf());
    }

    @Test(expected = Exception.class)
    public void removeAtInvalid() throws Exception {
        linkedList.removeAt(9);
    }
}