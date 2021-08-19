package com.sam09.lib.datastructurestarter.utility;

import com.sam09.lib.datastructurestarter.services.lists.DoublyLinkedList;
import com.sam09.lib.datastructurestarter.services.lists.SinglyLinkedList;
import com.sam09.lib.datastructurestarter.services.queues.PriorityQueue;
import com.sam09.lib.datastructurestarter.services.queues.Queue;
import com.sam09.lib.datastructurestarter.services.queues.QueueService;
import com.sam09.lib.datastructurestarter.services.stack.Stack;
import com.sam09.lib.datastructurestarter.services.stack.StackService;

import java.util.Random;
import java.util.stream.IntStream;

public class TestUtils {

    public static final int DEFAULT_RAND_LENGTH = 100;
    private static final int DEFAULT_TARGET_LENGTH = 5;

    public static int randomize(int randLength){
        return new Random().nextInt(randLength);
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
        Stack stackInstance = new StackService(size);

        for (int i=0; i<size; i++) {
            stackInstance.push(TestUtils.randomizeAlphabet(DEFAULT_TARGET_LENGTH));
        }

        return stackInstance;
    }

    public static SinglyLinkedList populateList(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.prepend(randomize(DEFAULT_RAND_LENGTH));

        return list;
    }

    public static DoublyLinkedList populateDoublyList() throws Exception {
        // by default, it populates 4 node data with random value
        DoublyLinkedList list = new DoublyLinkedList();
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.append(randomize(DEFAULT_RAND_LENGTH));
        list.insertAt(randomize(DEFAULT_RAND_LENGTH),2);

        return list;
    }

    public static Queue populateQueueData() { // sample 5 random data we're populating
        int sampleCapacity = 5;
        Queue q = new QueueService(sampleCapacity);
        IntStream.range(0, sampleCapacity)
                .mapToObj(i -> randomizeAlphabet(DEFAULT_TARGET_LENGTH))
                .forEach(q::enqueue);
        return q;
    }

    public static PriorityQueue populatePQ(PriorityQueue pq) throws Exception { // sample 5 random data we're populating

        for (int i = 0; i <pq.capacity() ; i++) {
            pq.insert(randomize(DEFAULT_RAND_LENGTH),randomizeAlphabet(DEFAULT_TARGET_LENGTH));
        }
        return pq;
    }
}
