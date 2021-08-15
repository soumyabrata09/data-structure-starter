package com.sam09.lib.datastructurestarter.services.LinkedLists;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;

import static org.junit.Assert.*;


@RunWith(JUnit4.class)
public class SinglyLinkedListTest {

    private static final Logger log = LoggerFactory.getLogger(SinglyLinkedListTest.class);
    SinglyLinkedList linkedList;
    @Before
    public void setUp() throws Exception {
        linkedList = new SinglyLinkedList();
    }

    private int randomize(){
        return new Random().nextInt(1000);
    }

    private SinglyLinkedList populateList(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.prepend(randomize());
        list.prepend(randomize());
        list.prepend(randomize());

        return list;
    }
    @Test
    public void prependTest() {
        linkedList = populateList(); // by default it will add 3 random node value
        log.info("List of value before prepending: " + linkedList.traverse());
        linkedList.prepend(23);
        log.info(" Linked list value after prepending: " + linkedList.traverse());
        assertEquals(4,linkedList.sizeOf());
        log.info("HEAD value: " + linkedList.getHead().getData());
        assertEquals(23,linkedList.getHead().getData());
    }

    @Test
    public void insertAtTestValid() throws Exception {
        int INDEX = 2;
        linkedList = populateList(); // by default it will add 3 random node value
        log.info("List of value before inserting node value at " + INDEX + ": " + linkedList.traverse());
        linkedList.insertAt(randomize(),INDEX);
        log.info("List of value after inserting node at " + INDEX + ": " + linkedList.traverse());
        assertEquals(4,linkedList.sizeOf());
    }

    @Test(expected = Exception.class)
    public void insertAtFirstTestInvalid() throws Exception {
        linkedList = populateList(); // by default it will add 3 random node value
        linkedList.insertAt(randomize(),6);
    }

    @Test
    public void removeFirstTestValid() throws Exception {
        linkedList = populateList(); // by default it will add 3 random node value
        log.info("List of value before removing first node: " + linkedList.traverse());
        linkedList.removeFirst();
        log.info("List of value after removing first node: " + linkedList.traverse());
        assertEquals(2,linkedList.sizeOf());
    }

    @Test
    public void removeAtTestValid() throws Exception {
        int INDEX = 2;
        linkedList = populateList(); // by default it will add 3 random node value
        log.info("List of value before removing node at " + INDEX + ": " + linkedList.traverse());
        linkedList.removeAt(INDEX);
        log.info(" Linked of value after removing node at " + INDEX + ": " + linkedList.traverse());
        assertEquals(2,linkedList.sizeOf());
    }

    @Test(expected = Exception.class)
    public void removeAtTestInvalid() throws Exception{
        linkedList = populateList();
        linkedList.removeAt(6);
    }

    @Test
    public void sizeOfTest() {
        linkedList = populateList();
        assertNotNull(linkedList.sizeOf());
    }
}