package com.sam09.lib.datastructurestarter.services.trees;

import com.sam09.lib.datastructurestarter.utility.TestUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private static final Logger log = LoggerFactory.getLogger(BinaryTreeTest.class);
    BinaryTree bTree;
    @Before
    public void setUp() throws Exception {
        bTree = TestUtils.populateSampleTreeData(new BinaryTree());
    }

    @Test
    public void getRootTest() {
        log.info("Root value: " + bTree.getRoot().getKey());
        assertNotNull(bTree.getRoot());
    }

    @Test
    public void preorderTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method invokingMethod = TestUtils.getInvokingMethod(TestUtils.PREORDER, BinaryTree.class,TreeNode.class);
        List<Object> preorderList = bTree.printTraversalByOrder(bTree, invokingMethod, bTree.getRoot());

        log.info("\nPreorder Traversal-> " + preorderList);
        assertTrue(!preorderList.isEmpty());
    }

    @Test
    public void inorderTest() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method invokingMethod = TestUtils.getInvokingMethod(TestUtils.INORDER, BinaryTree.class, TreeNode.class);
        List<Object> inorderedList = bTree.printTraversalByOrder(bTree, invokingMethod, bTree.getRoot());

        log.info("\nInorder Traversal-> " + inorderedList);
        assertTrue(!inorderedList.isEmpty());
    }

    @Test
    public void postorderTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method invokingMethod = TestUtils.getInvokingMethod(TestUtils.POSTORDER, BinaryTree.class, TreeNode.class);
        List<Object> postorderedList = bTree.printTraversalByOrder(bTree,invokingMethod, bTree.getRoot());

        log.info("\nPostorder Traversal-> " + postorderedList);
        assertTrue(!postorderedList.isEmpty());
    }
}