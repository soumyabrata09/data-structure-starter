package com.sam09.lib.datastructurestarter.services.trees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author soumyabrata09
 */
@Service
public class BinarySearchTree extends BinaryTree{

    private static final Logger log = LoggerFactory.getLogger(BinarySearchTree.class);
    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode search(TreeNode node, Object key) {
        if (null == node || key == node.getKey()) {
            return node;
        }
        if ((int)key < (int)node.getKey()) {
            return search(node.getLeft(),key);
        }
        return search(node.getRight(),key);
    }

    public TreeNode insert(TreeNode node, Object key) {
        if (null == node) {
            return new TreeNode(key);
        }
        if ( (int)key < (int)node.getKey()) {
            node.setLeft(insert(node.getLeft(),key));
        }
        else if ((int)key > (int)node.getKey()){
            node.setRight(insert(node.getRight(),key));
        }
        return node;
    }

    public TreeNode delete(TreeNode node, Object key) {
        if (null == node) {
            return null;
        }
        if ( (int)key < (int)node.getKey()) {
            node.setLeft(delete(node.getLeft(),key));
        }
        else if ( (int)key > (int)node.getKey()) {
            node.setRight(delete(node.getRight(),key));
        }
        else { // node to be removed is found here
            if (null == node.getLeft()) {
                return node.getLeft();
            }
            else if (null == node.getRight()){
                return node.getRight();
            }
            node.setKey(findMinNode(node.getRight()));
            node.setRight(delete(node.getRight(),node.getKey()));
        }

        return node;
    }

    /**
     * @param node Takes the TreeNode type data
     * @return Gives the minimum Node value from the rightward sub-child Tree
     */
    private Object findMinNode(TreeNode node) {
        Object minNode = node.getKey();
        while (null != node.getLeft()) {
            minNode = node.getLeft().getKey();
            node = node.getLeft();
        }
        return minNode;
    }
}
