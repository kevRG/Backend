package com.example.springb.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class CustomLinkedList<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Optional<T> find(Predicate<T> filter) {
        Node<T> current = head;
        while (current != null) {
            if (filter.test(current.getData())) {
                return Optional.of(current.getData());
            }
            current = current.getNext();
        }
        return Optional.empty();
    }

    public List<T> toList() {
        List<T> list = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            list.add(current.getData());
            current = current.getNext();
        }
        return list;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }
}