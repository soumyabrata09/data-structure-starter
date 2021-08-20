/**
 * @author Soumyabrata09
 * @version 1.0.0
 * @since 21st Aug,2021
 * */
package com.sam09.lib.datastructurestarter.utility;

import com.sam09.lib.datastructurestarter.services.lists.DoublyLinkedList;
import com.sam09.lib.datastructurestarter.services.lists.SinglyLinkedList;
import com.sam09.lib.datastructurestarter.services.queues.PriorityQueue;
import com.sam09.lib.datastructurestarter.services.queues.Queue;
import com.sam09.lib.datastructurestarter.services.queues.QueueService;
import com.sam09.lib.datastructurestarter.services.stack.Stack;
import com.sam09.lib.datastructurestarter.services.stack.StackService;
import com.sam09.lib.datastructurestarter.services.trees.BinarySearchTree;
import com.sam09.lib.datastructurestarter.services.trees.BinaryTree;
import com.sam09.lib.datastructurestarter.services.trees.TreeNode;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.stream.IntStream;

public class TestUtils {

    public static final int DEFAULT_RAND_LENGTH = 100;
    private static final int DEFAULT_TARGET_LENGTH = 5;
    public static final String PREORDER = "preorder";
    public static final String INORDER = "inorder";
    public static final String POSTORDER = "postorder";


    /**
     * @param randLength It decides the length of the generated integer
     * @return Returns a random number with given randLength
     */
    public static int randomize(int randLength){
        return new Random().nextInt(randLength);
    }

    /**
     * @param targetLength It decides the length of the generated String
     * @return Returns a random String with given targetLength
     */
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

    /**
     * @param size It decides the size of the Stack
     * @return Creates a sample StackData with given size value
     * @throws Exception
     */
    public static Stack populateStackData(int size) throws Exception {
        Stack stackInstance = new StackService(size);

        for (int i=0; i<size; i++) {
            stackInstance.push(TestUtils.randomizeAlphabet(DEFAULT_TARGET_LENGTH));
        }

        return stackInstance;
    }

    /**
     * @return Creates a sample SinglyLinkedList
     */
    public static SinglyLinkedList populateList(){
        SinglyLinkedList list = new SinglyLinkedList();
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.prepend(randomize(DEFAULT_RAND_LENGTH));

        return list;
    }

    /**
     * @return Creates a sample DoublyLinkedList
     * @throws Exception
     */
    public static DoublyLinkedList populateDoublyList() throws Exception {
        // by default, it populates 4 node data with random value
        DoublyLinkedList list = new DoublyLinkedList();
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.prepend(randomize(DEFAULT_RAND_LENGTH));
        list.append(randomize(DEFAULT_RAND_LENGTH));
        list.insertAt(randomize(DEFAULT_RAND_LENGTH),2);

        return list;
    }

    /**
     * @return Creates a sample Queue
     */
    public static Queue populateQueueData() { // sample 5 random data we're populating
        int sampleCapacity = 5;
        Queue q = new QueueService(sampleCapacity);
        IntStream.range(0, sampleCapacity)
                .mapToObj(i -> randomizeAlphabet(DEFAULT_TARGET_LENGTH))
                .forEach(q::enqueue);
        return q;
    }

    /**
     * @param pq Accepts a PriorityQueue instance as parameter
     * @return Creates a sample PriorityQueue data
     * @throws Exception
     */
    public static PriorityQueue populatePQ(PriorityQueue pq) throws Exception { // sample 5 random data we're populating

        for (int i = 0; i <pq.capacity() ; i++) {
            pq.insert(randomize(DEFAULT_RAND_LENGTH),randomizeAlphabet(DEFAULT_TARGET_LENGTH));
        }
        return pq;
    }

    /**
     * @param tree Takes a BinaryTree instance as parameter
     * @return BinaryTree type instance
     */
    public static BinaryTree populateSampleTreeData(BinaryTree tree) {

        /*Structure:

                    (35)
                /        \
               (8)       (10)
              /   \      /   \
            (43)  (152) (31) (71)
                  /  \      /
                (56) (108) (11)
        */

        tree.setRoot(new TreeNode(35));

        tree.getRoot().setLeft(new TreeNode(8));
        tree.getRoot().setRight(new TreeNode(10));

        tree.getRoot().getLeft().setLeft(new TreeNode(43));
        tree.getRoot().getLeft().setRight(new TreeNode(152));
        tree.getRoot().getLeft().getRight().setLeft(new TreeNode(56));
        tree.getRoot().getLeft().getRight().setRight(new TreeNode(108));

        tree.getRoot().getRight().setLeft(new TreeNode(31));
        tree.getRoot().getRight().setRight(new TreeNode(71));
        tree.getRoot().getRight().getRight().setLeft(new TreeNode(11));

        return tree;
    }

    /**
     * @param tree Takes a BinaryTree instance as parameter
     * @return BinarySearchTree type instance
     */
    public static BinarySearchTree populateSampleBSTData(BinarySearchTree tree) {
        /*Structure:

                    (43)
                /         \
              (25)        (53)
              /   \       /   \
            (18)  (35)  (49) (69)
                  /  \      /
                (30) (41) (61)
        */
        tree.setRoot(new TreeNode(43));

        tree.getRoot().setLeft(new TreeNode(25));
        tree.getRoot().setRight(new TreeNode(53));

        tree.getRoot().getLeft().setLeft(new TreeNode(18));
        tree.getRoot().getLeft().setRight(new TreeNode(35));
        tree.getRoot().getLeft().getRight().setLeft(new TreeNode(30));
        tree.getRoot().getLeft().getRight().setRight(new TreeNode(41));

        tree.getRoot().getRight().setLeft(new TreeNode(49));
        tree.getRoot().getRight().setRight(new TreeNode(69));
        tree.getRoot().getRight().getRight().setLeft(new TreeNode(61));

        return tree;

    }

    /**
     * To pass a method dynamically and then invoking them through a method
     * please go through the below link:
     * @see <a href="https://www.delftstack.com/howto/java/how-to-pass-a-function-as-a-parameter-in-java/">how-to-pass-a-function-as-a-parameter-in-java</a>
     * @param methodName
     *  Name of the method that you want to pass dynamically and invoke it eventually
     * @param clazz
     *  Main class name where methodName resides
     * @param paramTypeClazz
     * It is the type of parameter(could be class/Object/any primitive type) which as parameter methodName takes
     * @return This method will return a java.lang.Method type
     * @throws NoSuchMethodException
     * @see NoSuchMethodException
    */

    public static Method getInvokingMethod(String methodName, Class<? extends Object> clazz, Class<? extends Object> paramTypeClazz) throws NoSuchMethodException {
        Method invokingMethod = clazz.getMethod(methodName,paramTypeClazz);
        return invokingMethod;
    }
}
