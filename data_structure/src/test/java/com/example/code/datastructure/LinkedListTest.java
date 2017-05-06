package com.example.code.datastructure;

import com.example.code.datastructure.LinkedList.LinkedList;
import com.example.code.datastructure.LinkedList.Operations;
import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by pvtyuan on 2017/5/6.
 */
public class LinkedListTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public LinkedList makeLinkedList (int [] list) {

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.length; i++) {
            linkedList.add(list[i]);
        }

        return linkedList;
    }

    public LinkedList makeLoopedLinkedList(int [] list, int junctionPosition) {

        LinkedList.Node junctionNode = null;
        LinkedList.Node node = null;

        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < list.length; i++) {
            node = linkedList.add(list[i]);
            if (i == junctionPosition) {
                junctionNode = node;
            }
        }
        node.next = junctionNode;
        return linkedList;
    }

    @Test
    public void testRemoveDuplicate() {
        int [] list = {1, 2, 1, 3, 3};
        LinkedList linkedList = makeLinkedList(list);

        Operations.removeDuplicate(linkedList);

        assertArrayEquals(new Object[] {1, 2, 3}, linkedList.toArray());
    }

    @Test
    public void testFindLastKNode() {
        int [] list = {1, 2, 5, 1, 6, 3, 3};
        LinkedList linkedList = makeLinkedList(list);

        assertEquals(6, Operations.findLastKNode(linkedList, 3));
    }

    @Test
    public void testReverse() {
        int [] list1 = {1};
        LinkedList linkedList1 = makeLinkedList(list1);

        Operations.reverse(linkedList1);

        Object [] a = linkedList1.toArray();

        assertArrayEquals(new Object[] {1}, linkedList1.toArray());
    }

    @Test
    public void testReverse2() {
        int [] list = {1, 2, 4, 0};
        LinkedList linkedList = makeLinkedList(list);

        Operations.reverse(linkedList);

        assertArrayEquals(new Object[] {0, 4, 2, 1}, linkedList.toArray());
    }

    @Test
    public void testFindMiddleNode() {
        int [] list = {1, 2, 4, 0};
        LinkedList linkedList = makeLinkedList(list);

        assertEquals(2, Operations.findMiddleNode(linkedList));
    }

    @Test
    public void testFindMiddleNode2() {
        int [] list = {1, 2, 4, 0, 5};
        LinkedList linkedList = makeLinkedList(list);

        assertEquals(4, Operations.findMiddleNode(linkedList));
    }

    @Test
    public void testHasLoop() {
        int [] list = {1, 2, 4, 0, 5, 7};
        LinkedList linkedList = makeLoopedLinkedList(list, 3);

        assertEquals(true, Operations.hasLoop(linkedList));
    }

    @Test
    public void testFindJunctionNode() {
        int [] list = {1, 2, 4, 0, 5, 7, 3};
        LinkedList linkedList = makeLoopedLinkedList(list, 3);

        assertEquals(0, Operations.findJunctionNode(linkedList));
    }

    @Test
    public void testDeleteNodeUnknownHead() {
        int [] list = {1, 2, 4, 0, 5, 7, 3};
        LinkedList linkedList = makeLinkedList(list);

        Operations.deleteNodeUnkownHead(linkedList.at(3));

        assertArrayEquals(new Object[] {1, 2, 4, 5, 7, 3}, linkedList.toArray());
    }


}
