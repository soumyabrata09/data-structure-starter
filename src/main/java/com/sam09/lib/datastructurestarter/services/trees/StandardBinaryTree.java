package com.sam09.lib.datastructurestarter.services.trees;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public interface StandardBinaryTree {

    void preorder(TreeNode node);
    void inorder(TreeNode node);
    void postorder(TreeNode node);
    List<Object> printTraversalByOrder(Object obj, Method method, TreeNode node)
            throws InvocationTargetException, IllegalAccessException;
}
