package com.example.code.datastructure.LinkedList;

import java.awt.*;

/**
 * Created by pvtyuan on 2017/5/6.
 */
public class LinkedList {

    public Node head;

    public Node add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }

            node.next = newNode;
        }
        return newNode;
    }

    public int length() {
        int size = 0;
        Node node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public Node at(int i) {

        Node node = head;
        if (i < length()) {
            for (int j = 0; j < i; j++) {
                node = node.next;
            }
        }
        return node;
    }

    public Node tail() {

        Node node = head;
        while (node.next != null)
            node = node.next;

        return node;
    }

    @Override
    public String toString() {
        if (Operations.hasLoop(this)) {
            return "ops, this linked list has loop";
        }

        StringBuffer buffer = new StringBuffer("[");
        Node node = head;
        while (node != null) {
            buffer.append(node.toString());
            if (node.next != null) {
                buffer.append(", ");
            }
            node = node.next;
        }
        buffer.append("]");
        return buffer.toString();
    }

    public Object [] toArray() {
        Object [] array = new Object[length()];
        Node node = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = node.value;
            node = node.next;
        }
        return array;
    }

    public static class Node {
        public Object value;
        public Node next;

        public Node(Object value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
