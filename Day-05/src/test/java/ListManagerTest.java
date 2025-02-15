package com.junittest.basicunittest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
class ListManagerTest {

    private ListManager listManager;
    private List<Integer> testList;

    @BeforeEach
    void setUp() {
        listManager = new ListManager();
        testList = new ArrayList<>(); // Fresh list before each test
    }

    @Test
    void testAddElement() {
        listManager.addElement(testList, 5);
        assertTrue(testList.contains(5));

        listManager.addElement(testList, 10);
        assertEquals(2, testList.size());
    }

    @Test
    void testRemoveElement() {
        testList.add(5);
        testList.add(10);

        assertTrue(listManager.removeElement(testList, 5));
        assertFalse(testList.contains(5));

        assertFalse(listManager.removeElement(testList, 20)); // Element not in list
    }

    @Test
    void testGetSize() {
        assertEquals(0, listManager.getSize(testList));

        testList.add(5);
        assertEquals(1, listManager.getSize(testList));

        testList.add(10);
        assertEquals(2, listManager.getSize(testList));

        testList.remove(Integer.valueOf(5));
        assertEquals(1, listManager.getSize(testList));
    }

}