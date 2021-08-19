package com.sam09.lib.datastructurestarter.services.stack;

import com.sam09.lib.datastructurestarter.utility.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
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

    @Test
    public void pushOperationTest() throws Exception {
        stack = TestUtils.populateStackData(3);
        log.info("Stack Data after pushing: " + stack.printStack());
        assertFalse(stack.isEmpty());
        assertEquals(3,stack.sizeOf());
    }

    @Test(expected = Exception.class)
    public void pushOperationTestInvalid() throws Exception {
        stack = TestUtils.populateStackData(5);
        stack.push(TestUtils.randomizeAlphabet(5));
    }

    @Test
    public void popOperationTest() throws Exception {
        stack = TestUtils.populateStackData(3);
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
        stack.push(TestUtils.randomizeAlphabet(5));
        stack.push(ACTUAL);
        assertEquals(ACTUAL,stack.peek());
    }

    @Test(expected = Exception.class)
    public  void peekOperationTestInvalid() throws  Exception {
        stack.peek();
    }

    @Test
    public void sizeOfTest() throws Exception {
        stack = TestUtils.populateStackData(2);
        assertEquals(2,stack.sizeOf());
    }

}