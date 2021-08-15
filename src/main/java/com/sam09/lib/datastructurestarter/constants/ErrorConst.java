package com.sam09.lib.datastructurestarter.constants;

public enum ErrorConst {
    OUT_OF_BOUND("INDEX OUT OF BOUND"),
    EMPTY("LIST IS EMPTY"),
    ZEROTH_INDEX("ROTATION INDEX SHOULD NOT BE 0"),
    STACK_OVERFLOW("Stack is full"),
    STACK_UNDERFLOW("Stack is empty");
    private String message;
    ErrorConst(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
