package com.sam09.lib.datastructurestarter.services.trees;

import com.sam09.lib.datastructurestarter.utility.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BinarySearchTreeTest {

    private static final Logger log = LoggerFactory.getLogger(BinarySearchTreeTest.class);
    BinarySearchTree searchTree;

    @Before
    public void setUp() throws Exception {
        searchTree = TestUtils.populateSampleBSTData(new BinarySearchTree());
    }

    @Test
    public void searchTest() {
        TreeNode searched = searchTree.search(searchTree.getRoot(), 69);
        assertEquals(69,searched.getKey());
    }

    @Test
    public void insertTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Object> printList;
        Method invokingMethod = TestUtils.getInvokingMethod(TestUtils.INORDER, BinarySearchTree.class, TreeNode.class);
        printList = searchTree.printTraversalByOrder(searchTree, invokingMethod, searchTree.getRoot());
        log.info("\nBefore Inserting new node, current tree contents are: " + printList + "\n");

        TreeNode inserted = searchTree.insert(searchTree.getRoot(), 39);
        log.info("\nInserted Node: " + inserted);

        printList = searchTree.printTraversalByOrder(searchTree, invokingMethod, searchTree.getRoot());
        log.info("\nAfter Inserting new node, current tree contents are: " + printList + "\n");
        assertNotNull(inserted);
    }

    @Test
    public void deleteTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Object> printList;
        Method invokingMethod = TestUtils.getInvokingMethod(TestUtils.INORDER, BinarySearchTree.class, TreeNode.class);
        printList = searchTree.printTraversalByOrder(searchTree, invokingMethod, searchTree.getRoot());
        log.info("\nBefore Deleting the node, current tree contents are: " + printList + "\n");

        TreeNode deleted = searchTree.delete(searchTree.getRoot(), 41);
        log.info("\nDeleted Node: " + deleted);

        printList = searchTree.printTraversalByOrder(searchTree, invokingMethod, searchTree.getRoot());
        log.info("\nAfter Deleting the node, current tree contents are: " + printList + "\n");
        assertNotNull(deleted);
    }
}