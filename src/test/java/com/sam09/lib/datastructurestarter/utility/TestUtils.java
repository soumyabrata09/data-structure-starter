package com.sam09.lib.datastructurestarter.utility;

import com.sam09.lib.datastructurestarter.services.lists.DoublyLinkedList;
import com.sam09.lib.datastructurestarter.services.lists.SinglyLinkedList;
import com.sam09.lib.datastructurestarter.services.stack.Stack;
import com.sam09.lib.datastructurestarter.services.stack.StackService;

import java.util.Random;

public class TestUtils {

    public static int randomize(){
        return new Random().nextInt(1000);
    }

    public static String randomizeAlphabet(int targetLength){
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

    public static Stack populateStackData(int size) throws Exception {
        int targetLimit = 5;
        Stack stackInstance = new StackService(size);

        for (int i=0; i<size; i++) {
            stackInstance.push(TestUtils.randomizeAlphabet(targetLimit));
        }
        return stackInstance;
    }

    public static SinglyLinkedList populateList(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.prepend(randomize());
        list.prepend(randomize());
        list.prepend(randomize());

        return list;
    }

    public static DoublyLinkedList populateDoublyList() throws Exception {
        // by default it populates 4 node data with random value
        DoublyLinkedList list = new DoublyLinkedList();
        list.prepend(randomize());
        list.prepend(randomize());
        list.append(randomize());
        list.insertAt(randomize(),2);

        return list;
    }
}
