package com.sam09.lib.datastructurestarter.services.LinkedLists;

import com.sam09.lib.datastructurestarter.constants.ErrorConst;
import com.sam09.lib.datastructurestarter.constants.Traversal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoublyLinkedList implements DoublyList {
    private static final Logger log = LoggerFactory.getLogger(DoublyLinkedList.class);
    private AdvancedNode HEAD;
    private AdvancedNode TAIL;
    private int size;

    public DoublyLinkedList() {
        this.HEAD = null;
        this.TAIL = null;
    }


    @Override
    public int sizeOf() {
        return this.size;
    }

    @Override
    public List traverse(Traversal movement) {
        List arList = new ArrayList();
        AdvancedNode current;
        switch(movement){
            case FORWARD:
                current = HEAD;
                while (null != current){
                    arList.add(current.getData());
                    if( null == current.getNext()){
                        break;
                    }
                    current = current.getNext();
                }
                break;
            case BACKWARD:
                current = TAIL;
                while (null != current){
                    arList.add(current.getData());
                    if (null == current.getPrev()){
                        break;
                    }
                    current = current.getPrev();
                }
                break;
        }
        return arList;
    }

    @Override
    public void prepend(Object data) {
        AdvancedNode start = new AdvancedNode(data,null,null);
        start.setNext(HEAD);
        if (HEAD != null){
           HEAD.setPrev(start);
        }
        else {
            TAIL = start; //TAIL becomes the start of the list
        }
        HEAD = start; // make start as HEAD
        size++; //increase the size
    }

    @Override
    public void append(Object data) {
        AdvancedNode last = new AdvancedNode(data,null,null);
        last.setPrev(TAIL);
        if (null != TAIL){
            TAIL.setNext(last);
        }
        else {
            HEAD = last; // HEAD becomes the last Node
        }
        TAIL = last; // make last node as TAIL
        size++; //increase the size
    }

    @Override
    public void insertAt(Object data, int index) throws Exception {
        if (index >=0 && index < this.size){
            AdvancedNode start = new AdvancedNode(null,null,HEAD);
            AdvancedNode before = start;
            //iterate to the given index
            for (int i=0; i<index; i++){
                before = before.getNext();
            }
            AdvancedNode after = before.getNext();
            AdvancedNode inserted = new AdvancedNode(data,before,after);
            before.setNext(inserted);
            after.setPrev(inserted);
            HEAD = start.getNext();
            size++;
        }
        else {
            log.error("Cannot add new node at given index " + index + " as " + ErrorConst.OUT_OF_BOUND.getMessage());
            throw new Exception(ErrorConst.OUT_OF_BOUND.getMessage());
        }
    }

    @Override
    public AdvancedNode removeFirst() throws Exception {
        if (null != HEAD){
            AdvancedNode removed = HEAD;
            HEAD = removed.getNext(); // set HEAD from the next node
            HEAD.setPrev(null);
            //disjoint the removed node from the rest of the linked list
            removed.setNext(null);
            size--; //reduce the size
            return removed; // return the popped node
        }
        else {
            log.error("Cannot delete node as " + ErrorConst.EMPTY.getMessage());
            throw new Exception(ErrorConst.EMPTY.getMessage());
        }
    }

    @Override
    public AdvancedNode removeLast() throws Exception {
        if (null != TAIL){
            AdvancedNode removed = TAIL;
            TAIL = removed.getPrev(); //set TAIL as the previous node
            TAIL.setNext(null);
            //disjoint the removed node from the rest of the Linked list
            removed.setPrev(null);
            size--; // reduce the size
            return removed; // return the popped node
        }
        else {
            log.error("Cannot delete node as " + ErrorConst.EMPTY.getMessage());
            throw new Exception(ErrorConst.EMPTY.getMessage());
        }
    }

    @Override
    public AdvancedNode removeAt(int index) throws Exception {
        if ( index >=0 && index < this.size){
            AdvancedNode start = new AdvancedNode(null,null,HEAD);
            AdvancedNode before = start;
            //iterate to the given index
            for (int i=0; i<index; i++){
                before = before.getNext();
            }
            AdvancedNode removed = before.getNext();// delete the next node of before node
            AdvancedNode after = removed.getNext();
            before.setNext(after);
            after.setPrev(before);
            //disjoint the removed node
            removed.setPrev(null);
            removed.setNext(null);
            HEAD = start.getNext(); // update the HEAD
            size--; //reduce the size
            return removed; // return the popped node
        }
        else {
            log.error("Cannot remove node at given index " + index + " as " + ErrorConst.OUT_OF_BOUND.getMessage());
            throw new Exception(ErrorConst.OUT_OF_BOUND.getMessage());
        }
    }

    @Override
    public AdvancedNode getHead() {
        return this.HEAD;
    }

    @Override
    public AdvancedNode getTail() {
        return this.TAIL;
    }
}
