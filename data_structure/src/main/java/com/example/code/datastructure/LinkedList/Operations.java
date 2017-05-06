package com.example.code.datastructure.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.awt.HeadlessToolkit;
import sun.awt.image.ImageWatched;

/**
 * Created by pvtyuan on 2017/5/6.
 */
public class Operations {

    private Logger logger = LoggerFactory.getLogger(Operations.class);

    /**
     * remove duplicated item from linked list
     * ex: [1, 2, 1, 3] => [1, 2, 3]
     * @param list
     */
    public static void removeDuplicate(LinkedList list) {
        LinkedList.Node outerNode = list.head;

        while (outerNode != null) {
            LinkedList.Node innerNode = outerNode;
            while (innerNode.next != null) {
                if (outerNode.value == innerNode.next.value) {
                    innerNode.next = innerNode.next.next;
                } else {
                    innerNode = innerNode.next;
                }
            }

            outerNode = outerNode.next;
        }
    }

    /**
     * find the last k item in linked list
     * @param list
     * @param k
     * @return found item, null if not found
     */
    public static Object findLastKNode(LinkedList list, int k) {
        if (k < 1 || k > list.length()) {
            return null;
        }

        LinkedList.Node p1 = list.head;
        LinkedList.Node p2 = list.head;

        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.value;
    }

    public static void reverse(LinkedList list) {

        LinkedList.Node p = list.head;

        LinkedList.Node reversedHead = null;
        LinkedList.Node prev = null;
        LinkedList.Node next = p.next;

        while (p != null) {
            p.next = prev;
            prev = p;
            p = next;
            if (p == null) {
                reversedHead = prev;
            } else {
                next = p.next;
                p.next = prev;
            }
        }
        list.head = reversedHead;
    }

    public static Object findMiddleNode(LinkedList list) {
        LinkedList.Node p1 = list.head;
        LinkedList.Node p2 = list.head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        return p1.value;
    }

    public static boolean hasLoop(LinkedList list) {
        LinkedList.Node p1 = list.head;
        LinkedList.Node p2 = list.head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }

        return false;
    }

    public static Object findJunctionNode(LinkedList list) {
        if (!hasLoop(list)) {
            return null;
        }

        LinkedList.Node p1 = list.head;
        LinkedList.Node p2 = list.head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }

        p2 = list.head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1.value;
    }

    public static void deleteNodeUnkownHead(LinkedList.Node node) {
        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        }
    }

    public static boolean isIntersect(LinkedList list1, LinkedList list2) {
        return list1.tail() == list2.tail();
    }
}
