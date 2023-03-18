package com.uvg.gt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ITreeTests {

    @ParameterizedTest
    @MethodSource("createTreesImplementations")
    public void isEmptyWorks(ITree<Integer> tree) {
        assertTrue(tree.isEmpty());
        tree.insert(5);
        assertFalse(tree.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("createTreesImplementations")
    public void insertAndGetWorks(ITree<Integer> tree) {
        tree.insert(25);
        tree.insert(10);
        tree.insert(35);
        tree.insert(1);
        tree.insert(40);

        assertEquals(10, tree.get(10));
        assertEquals(35, tree.get(35));
        assertEquals(40, tree.get(40));
        assertEquals(1, tree.get(1));
    }

    @ParameterizedTest
    @MethodSource("createTreesImplementations")
    public void containsWorks(ITree<Integer> tree) {
        tree.insert(55);
        tree.insert(100);
        tree.insert(4);
        tree.insert(35);
        tree.insert(15);
        tree.insert(70);

        assertTrue(tree.contains(4));
        assertTrue(tree.contains(100));
        assertTrue(tree.contains(15));
    }

    private static Stream<Arguments> createTreesImplementations() {
        return Stream.of(Arguments.of(new BinaryTree<Integer>()));
    }

}
