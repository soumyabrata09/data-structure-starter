package com.sam09.lib.datastructurestarter.services.LinkedLists;

import com.sam09.lib.datastructurestarter.constants.ErrorConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SinglyLinkedList implements SinglyList {
    private static final Logger log = LoggerFactory.getLogger(SinglyLinkedList.class);
    private Node HEAD;
    private int size;

    public SinglyLinkedList(){
        HEAD = null;
    }

    @Override
    public void prepend(Object data) {
        //create a new node with null pointer
        Node header = new Node(data, null);
        //set the pointer of the new Node to be the Node which was previously HEAD
        header.setNext(this.HEAD);
        //make the mew Node as the Current HEAD
        this.HEAD = header;
        //increase size
        size++;
        log.info("Data added to the list successfully");
    }

    @Override
    public void insertAt(Object data, int index) throws Exception {
        if (index >= 0 && index < this.size){
            //create a statring node with null value but a pointer to the HEAD
            Node start = new Node(null,this.HEAD);
            //create a before Node which will be the node in front of the new Node that is going to be added at the given position
            Node before = start;
            //iterate through the list to get to the index location provided
            for(int i=0; i<index; i++){
                before = before.getNext();
            }
            before.setNext(new Node(data,before.getNext())); //add the data to the current index location and point to the next Node
            this.HEAD = start.getNext();
            size++;//increase the size
            log.info("Data added to the list successfully at index " + index);
        }
        else {
            log.error("Data an not be added to the given index position as error throws with reason as " + ErrorConst.OUT_OF_BOUND.getMessage());
            throw new Exception(ErrorConst.OUT_OF_BOUND.getMessage());
        }
    }

    @Override
    public Node removeFirst() throws Exception {
        if (null != this.HEAD) {
            Node temp = this.HEAD;
            this.HEAD = temp.getNext();//start HEAD from the next Pointer
            temp.setNext(null); // set temp to null
            size--; //reduce the size of the List
            log.info("Data successfully removed");
            return temp; // return the removed Node data
        }
        else {
            log.error("Data can not be removed as " + ErrorConst.EMPTY.getMessage());
            throw new Exception(ErrorConst.EMPTY.getMessage());
        }
    }

    @Override
    public Node removeAt(int index) throws Exception {
        if(index >=0 && index < this.size){
            //create a start node with null value and pointer to the HEAD
            Node start = new Node(null, this.HEAD);
            //create a before Node will be in the front of the Node which will be removed at given index location
            Node before = start;
            //iterate to the given index location
            for(int i =0; i< index; i++){
                before = before.getNext();
            }
            Node temp = before.getNext(); // copy the rest of the list from the next pointer of the Node before
            before.setNext(temp.getNext());
            temp.setNext(null); //disjoint the temp Node by setting next pointer to null
            this.HEAD = start.getNext(); // update the HEAD node
            size--;//reduce the size of the List
            log.info("Data has been removed successfully at index " + index);
            return temp; // return the removed Node
        }
        else {
            log.error("Data Can not be removed at the given index location as " + ErrorConst.OUT_OF_BOUND.getMessage());
            throw new Exception(ErrorConst.OUT_OF_BOUND.getMessage());
        }
    }

    @Override
    public List traverse() {
        List arList = new ArrayList<>();
        Node current = HEAD;
        while (current != null){
            arList.add(current.getData());
            current = current.getNext();
        }
        return arList;
    }

    @Override
    public int sizeOf() {
        return this.size;
    }

    @Override
    public Node getHead() {
        return this.HEAD;
    }

   /* @Override
    public void rotate(int index) throws Exception {
        if(index == 0){
            log.error(ErrorConst.ZEROTH_INDEX.getMessage());
            throw new Exception(ErrorConst.ZEROTH_INDEX.getMessage());
        }
        Node start = this.HEAD;
        for (int i=1; i<=index; i++){
            start = start.getNext();
        }
        Node temp = new Node(start.getData(),start.getNext());
//        temp.setData(start.getData());
//        temp.setNext(start.getNext());
        int counter =0;
        while ( null != start.getNext()){// reach the end of current List
            counter++;
            log.info("Iteration " + counter +" and start Node data(): "+ start.getData());
            start = start.getNext();
            log.info("AFTER NEXT OP::Iteration " + counter +" and start Node data(): "+ start.getData());
        }
        log.info("Outside of the While loop start Node data() " + start.getData() + " " + start.getNext());
        //log.info("HEAD data(): " + this.HEAD.getData() + " start Node: " + start.getData());
        start.setNext(this.HEAD); // set the last pointer to the HEAD
        this.HEAD = temp.getNext();
        temp.setNext(null); // destroy the temp Node
        log.info("Size after rotation: " + this.size);
    }*/
}
