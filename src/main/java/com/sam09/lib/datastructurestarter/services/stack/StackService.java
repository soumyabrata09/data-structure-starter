package com.sam09.lib.datastructurestarter.services.stack;

import com.sam09.lib.datastructurestarter.constants.ErrorConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StackService implements Stack{

    private static final Logger log = LoggerFactory.getLogger(StackService.class);
    private String[] stack;
    private int size;
    private int top;

    public StackService(int size){
        this.size = size;
        stack = new String[this.size];
        top = -1;
    }
    @Override
    public boolean isEmpty() {
        if (top <0)
            return true;
        else
            return false;
    }

    @Override
    public boolean push(String data) throws Exception {
        if (top == (size -1)) {
            log.info("Can not push data to Stack as " + ErrorConst.STACK_OVERFLOW.getMessage());
            throw new Exception(ErrorConst.STACK_OVERFLOW.getMessage());
        }
        else {
            stack[++top] = data;
            log.info(data + " added to stack successfully");
            return true;
        }
    }

    @Override
    public String pop() throws Exception {
        if (top <0) {
            log.info("Pop operation failed as " + ErrorConst.STACK_UNDERFLOW.getMessage());
            throw new Exception(ErrorConst.STACK_UNDERFLOW.getMessage());
        }
        else {
            String popped = stack[top--];
            return popped;
        }
    }

    @Override
    public String peek() throws Exception {
        if (top <0) {
            log.info("Peek operation failed as " + ErrorConst.STACK_UNDERFLOW.getMessage());
            throw new Exception(ErrorConst.STACK_UNDERFLOW.getMessage());
        }
        else {
          return stack[top];
        }
    }

    @Override
    public int sizeOf() {
        return this.stack.length;
    }

    @Override
    public List printStack() {
        List stackData = new ArrayList<String>();
        Arrays.stream(this.stack).forEach( e -> stackData.add(e));
        return stackData;
    }

}
