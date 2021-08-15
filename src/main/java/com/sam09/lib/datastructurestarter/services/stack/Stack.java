package com.sam09.lib.datastructurestarter.services.stack;

import java.util.List;

public interface Stack {
    boolean isEmpty();
    boolean push(String data) throws Exception;
    String pop() throws Exception;
    String peek() throws Exception;
    int sizeOf();
    List printStack();
}
