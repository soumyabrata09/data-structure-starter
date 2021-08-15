package com.sam09.lib.datastructurestarter.services.stack;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class StackServiceTest {

    private static final Logger log = LoggerFactory.getLogger(StackServiceTest.class);
    Stack stack;
    private static final int stackSize = 5;
    private static final String ACTUAL = "ABCDEF";
    @Before
    public void setUp() throws Exception {
        stack = new StackService(stackSize);
    }

    @Test
    public void isEmptyTest() {
        assertTrue(stack.isEmpty());
    }

    private String randomizeAlphabet(int targetLength){
        /*Random.ints, added in JDK 8, to generate an alphabetic String
        below is a demonstration of how to create them*/
        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'
        Random rand = new Random();
        String generatedString = rand.ints(leftLimit,rightLimit+1)
                .limit(targetLength)
                .collect(StringBuilder::new,StringBuilder::appendCodePoint,StringBuilder::append)
                .toString();
        return generatedString;
    }

    private Stack populateStackData(int size) throws Exception {
        int targetLimit = 5;
        Stack stackInstance = new StackService(size);

        for (int i=0; i<size; i++) {
            stackInstance.push(randomizeAlphabet(targetLimit));
        }
        return stackInstance;
    }
    @Test
    public void pushOperationTest() throws Exception {
        stack = populateStackData(3);
        log.info("Stack Data after pushing: " + stack.printStack());
        assertFalse(stack.isEmpty());
        assertEquals(3,stack.sizeOf());
    }

    @Test(expected = Exception.class)
    public void pushOperationTestInvalid() throws Exception {
        stack = populateStackData(5);
        stack.push(randomizeAlphabet(5));
    }

    @Test
    public void popOperationTest() throws Exception {
        stack = populateStackData(3);
        log.info("Stack data before popping: " + stack.printStack());
        String peeked = stack.peek();
        String popped = stack.pop();
        assertEquals(peeked,popped);
    }

    @Test(expected = Exception.class)
    public void popOperationTestInvalid() throws Exception {
        stack.pop();
    }

    @Test
    public void peekOperationTest() throws Exception {
        stack.push(randomizeAlphabet(5));
        stack.push(ACTUAL);
        assertEquals(ACTUAL,stack.peek());
    }

    @Test(expected = Exception.class)
    public  void peekOperationTestInvalid() throws  Exception {
        stack.peek();
    }

    @Test
    public void sizeOfTest() throws Exception {
        stack = populateStackData(2);
        assertEquals(2,stack.sizeOf());
    }

}