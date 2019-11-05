package com.company;

public class HeapNode {
    public int key;
    public boolean isMarked;
    public HeapNode nextNode;
    public HeapNode prevNode;
    public HeapNode parentNode;
    public HeapNode child;
    public int rank; // Number Of children.

    /**
     * public HeapNode(int k)
     * Constructor for a HeapNode object.
     *
     * @param k - key of the node.
     * @complexity O(1)
     * @pre none.
     */
    public HeapNode(int k) {
        key = k;
        isMarked = false;
        nextNode = this;
        prevNode = this;
        parentNode = null;
        child = null;
        rank = 0;
    }
}
