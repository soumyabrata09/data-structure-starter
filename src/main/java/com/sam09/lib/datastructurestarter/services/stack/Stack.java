package com.sam09.lib.datastructurestarter.services.stack;

import java.util.List;

/**
 * @author soumyabrata09
 */
public interface Stack {
    /**
     * @return Determines whether Stack is Empty
     */
    boolean isEmpty();

    /**
     * @param data Data to be inserted to Stack
     * @return Boolean flag value based the success/failure of the operation
     * @throws Exception
     */
    boolean push(String data) throws Exception;

    /**
     * @return Returns the removed element from the TOP of the Stack
     * @throws Exception
     */
    String pop() throws Exception;

    /**
     * @return Only peeks the TOP data from the Stack but does not remove it
     * @throws Exception
     */
    String peek() throws Exception;

    /**
     * @return Returns the size of the Stack
     */
    int sizeOf();

    /**
     * @return Retuns the Stack elements in the form of ArrayList
     */
    List printStack();
}
