package com.mmu.gen;

import com.mmu.gen.inter.MyQueue;

/**
 * Created by mu on 7/14/17.
 */
public class CircularArrayBlockingQueue<E> implements MyQueue<E> {
    private final int capacity;
    private int front,rear, current;
    private Object[] storage;

    public CircularArrayBlockingQueue(int capacity){
        this.capacity=capacity;
        this.storage= new Object[capacity];
    }

    public void enqueue(E element) {

        while (isFull()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        if (isEmpty()) {
            notifyAll();
        }

        current++;
        storage[front] = element;
        front = (front + 1) % capacity;
    }

    public E dequeue() {

        while (isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {

            }
        }

        if (isFull()) {
            notifyAll();
        }

        current--;

        E temp = (E) storage[rear];
        storage[rear] = null;
        rear = (rear + 1) % capacity;

        return temp;
    }

    public boolean isFull(){
        return current == capacity;
    }

    public boolean isEmpty(){
        return current==0;
    }
}
