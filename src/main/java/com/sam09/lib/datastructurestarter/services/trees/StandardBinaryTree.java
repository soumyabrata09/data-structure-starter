package com.sam09.lib.datastructurestarter.services.trees;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author soumyabrata09
 */
public interface StandardBinaryTree {

    /**
     * @param node Root the of Tree
     *             and Used for Preorder traversal of Tree data
     */
    void preorder(TreeNode node);

    /**
     * @param node Root of the Tree
     *             and Used for Inorder traversal of Tree data
     */
    void inorder(TreeNode node);

    /**
     * @param node Root of the Tree
     *             and Used for Postorder traversal of Tree data
     */
    void postorder(TreeNode node);

    /**
     * @param obj Main Object of Tree Type
     * @param method Method which you wish to pass and eventually that method execution will be invoked
     * @param node ParaeterType of the invoking method
     * @return Returns Tree elements of type List
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    List<Object> printTraversalByOrder(Object obj, Method method, TreeNode node)
            throws InvocationTargetException, IllegalAccessException;
}
