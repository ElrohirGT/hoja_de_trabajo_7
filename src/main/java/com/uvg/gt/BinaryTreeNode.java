package com.uvg.gt;

public class BinaryTreeNode<T> {
    private BinaryTreeNode<T> _left;
    private BinaryTreeNode<T> _right;

    private T _value;

    public BinaryTreeNode(T value) {
        _value = value;
    }

    public boolean hasChild() {
        return _left != null || _right != null;
    }

    public BinaryTreeNode<T> getLeft() {
        return _left;
    }

    public BinaryTreeNode<T> getRight() {
        return _right;
    }

    public T getValue() {
        return _value;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        _left = left;
    }

    public void setRight(BinaryTreeNode<T> right) {
        _right = right;
    }

    @Override
    public String toString() {
        return _value.toString();
    }
}