package com.uvg.gt;

import java.util.List;

public class SearchResult<T> {

    private T _result;
    private List<BinaryTreeNode<T>> _path;

    public SearchResult(T result, List<BinaryTreeNode<T>> path) {
        _result = result;
        _path = path;
    }

    public T getResult() {
        return _result;
    }

    public List<BinaryTreeNode<T>> getPath() {
        return _path;
    }

}
