package com.uvg.gt;

public interface ITree<T extends Comparable<T>> {
    /**
     * Checks if the tree is empty or not.
     * 
     * @return True is it's empty, false otherwise.
     */
    public boolean isEmpty();

    /**
     * Inserts an item into the tree.
     * 
     * @param item The item to insert.
     */
    public void insert(T item);

    /**
     * Gets an item from the tree if it exists.
     * 
     * @param item The item to search for
     * @return the item if it exists, null otherwise.
     */
    public T get(T item);

    /**
     * Checks if the tree contains a certain item.
     * 
     * @param item the item to check
     * @return true if the item exists otherwise false.
     */
    public boolean contains(T item);

    /**
     * @return the root of the tree.
     */
    public BinaryTreeNode<T> getRoot();
}
