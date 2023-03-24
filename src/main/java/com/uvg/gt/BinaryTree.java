package com.uvg.gt;

public class BinaryTree<T extends Comparable<T>> implements ITree<T> {

    private BinaryTreeNode<T> _root = null;

    @Override
    public boolean isEmpty() {
        return _root == null;
    }

    @Override
    public void insert(T item) {
        var node = _root;
        var insertNode = new BinaryTreeNode<>(item);
        boolean insertValueIsLess = false;

        if (isEmpty()) {
            _root = insertNode;
            return;
        }

        node = findPossibleParentNode(item);
        insertValueIsLess = item.compareTo(node.getValue()) < 0;

        if (insertValueIsLess) {
            node.setLeft(insertNode);
        } else {
            node.setRight(insertNode);
        }
    }

    @Override
    public T get(T item) {
        var node = findNodeOf(item);
        if (node == null) {
            return null;
        }

        return node.getValue();
    }

    private BinaryTreeNode<T> findNodeOf(T item) {
        if (isEmpty()) {
            return null;
        }

        if (_root.getValue().compareTo(item) == 0) {
            return _root;
        }

        var node = findPossibleParentNode(item);
        var searchValueIsLess = item.compareTo(node.getValue()) < 0;
        if (searchValueIsLess) {
            node = node.getLeft();
        } else {
            node = node.getRight();
        }

        return node;
    }

    private BinaryTreeNode<T> findPossibleParentNode(T item) {
        if (isEmpty()) {
            return null;
        }

        BinaryTreeNode<T> parentNode = null;
        var currentNode = _root;
        while (true) {
            var nodeValue = currentNode.getValue();

            var insertValueIsEqual = item.compareTo(nodeValue) == 0;
            if (insertValueIsEqual) {
                return parentNode;
            }

            BinaryTreeNode<T> leafNode;
            var insertValueIsLess = item.compareTo(nodeValue) < 0;
            if (insertValueIsLess) {
                leafNode = currentNode.getLeft();
            } else {
                leafNode = currentNode.getRight();
            }

            parentNode = currentNode;
            currentNode = leafNode;

            if (leafNode == null) {
                break;
            }
        }
        return parentNode;
    }

    @Override
    public boolean contains(T item) {
        return get(item) != null;
    }

    @Override
    public BinaryTreeNode<T> getRoot() {
        return _root;
    }

}
