package com.sam09.lib.datastructurestarter.services;

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
        linkedList = populateList();
        log.info(" Linked List: " + linkedList.traverse());
        assertEquals(3,linkedList.sizeOf());
    }

    @Test
    public void insertAtTestValid() throws Exception {
        linkedList = populateList();
        linkedList.insertAt(randomize(),2);
        log.info(" Linked List: " + linkedList.traverse());
        assertEquals(4,linkedList.sizeOf());
    }

    @Test(expected = Exception.class)
    public void insertAtFirstTestInvalid() throws Exception {
        linkedList = populateList();
        linkedList.insertAt(randomize(),6);
    }

    @Test
    public void removeFirstTestValid() throws Exception {
        linkedList = populateList();
        linkedList.removeFirst();
        log.info(" Linked List: " + linkedList.traverse());
        assertEquals(2,linkedList.sizeOf());
    }

    @Test
    public void removeAtTestValid() throws Exception {
        linkedList = populateList();
        linkedList.removeAt(1);
        log.info(" Linked List: " + linkedList.traverse());
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