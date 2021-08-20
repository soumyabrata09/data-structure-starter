package com.sam09.lib.datastructurestarter.services.trees;

import java.util.Objects;

public class TreeNode {
    private Object key;
    TreeNode left;
    TreeNode right;
    private int level;

    public TreeNode(Object key) {
        this.key = key;
        left = null;
        right = null;
        level = 0;
    }

    /*public TreeNode(Object key, Object leftNodeKey, Object rightNodeKey) {
        this.key = key;
        this.left.key = leftNodeKey;
        this.right.key = rightNodeKey;
    }*/

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return level == treeNode.level && Objects.equals(key, treeNode.key) && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, left, right, level);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                ", left=" + left +
                ", right=" + right +
                ", level=" + level +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
