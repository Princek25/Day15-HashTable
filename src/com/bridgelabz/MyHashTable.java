package com.bridgelabz;

public class MyHashTable<K, V> {
    MyMapNode head;
    MyMapNode tail;

    public V get(K word) {
        MyMapNode<K, V> myNode = searchNode(word);
        return (myNode == null) ? null : myNode.getValue();
    }

    public MyMapNode<K, V> searchNode(K word) {
        MyMapNode<K, V> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            position++;
            if (currentNode.getKey().equals(word)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    public void add(K key, V value) {
        MyMapNode<K, V> myNode = searchNode(key);
        if (myNode == null) {
            myNode = new MyMapNode<>(key, value);
            this.append(myNode);
        } else
            myNode.setValue(value);
    }

    private void append(MyMapNode<K, V> myNode) {
        if (this.head == null)
            this.head = myNode;
        if (this.tail == null)
            this.tail = myNode;
        else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }

    @Override
    public String toString() {
        return "MyLinkedListNodes{" + head + '}';
    }

    public void remove(K word) {
        MyMapNode currentNode = head;
        MyMapNode previousNode = null;
        while (currentNode != null && currentNode.getKey().equals(word)) {
            head = currentNode.getNext();
            return;
        }
        while (currentNode != null && !(currentNode.getKey().equals(word))) {
            previousNode = currentNode;
            currentNode = currentNode.getNext();
        }
        if (currentNode != null) {
            previousNode.next = currentNode.next;
        }
        if (currentNode == null)
            System.out.println("Word not found!");
    }
}
