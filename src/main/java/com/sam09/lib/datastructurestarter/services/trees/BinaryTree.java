package com.sam09.lib.datastructurestarter.services.trees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author soumyabrata09
 */
@Service
public class BinaryTree implements StandardBinaryTree{

    private static final Logger log = LoggerFactory.getLogger(BinaryTree.class);
    TreeNode root;
    private static List<Object> treeList = new ArrayList<>();
    public BinaryTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    @Override
    public void preorder(TreeNode node) {
        if (null == node) {
            return;
        }
        treeList.add(node.getKey());
        Object resultantKey = node.getKey();
        System.out.print(" (" + resultantKey + ") ");
        preorder(node.left);
        preorder(node.right);
    }

    @Override
    public void inorder(TreeNode node) {
        if (null == node) {
            return;
        }
        inorder(node.getLeft());
        treeList.add(node.getKey());
        System.out.print(" (" + node.getKey() + ") ");
        inorder(node.getRight());
    }

    @Override
    public void postorder(TreeNode node) {
        if (null == node) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        treeList.add(node.getKey());
        System.out.print(" (" + node.getKey() + ") ");
    }

    @Override
    public List<Object> printTraversalByOrder(Object obj, Method method, TreeNode node) throws InvocationTargetException, IllegalAccessException {
        Object[] params = new Object[1];
        params[0] = node;
        method.invoke(obj,params);
        System.out.println();
        log.info("ABLE TO SUCCESSFULLY INVOKED THE METHOD DYNAMICALLY");

        List<Object> printList = new ArrayList<>();
        printList.addAll(treeList);
        treeList.clear(); //clearing treeList is must otherwise upon invoking multiple method data will be appended;
        return printList;
    }
}
