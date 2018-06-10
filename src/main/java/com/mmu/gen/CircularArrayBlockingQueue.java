package com.mmu.gen;

import com.mmu.gen.inter.MyQueue;

/**
 * Created by mu on 7/14/17.
 */
public class CircularArrayBlockingQueue<E> implements MyQueue<E> {
    private final int capacity;
    private int front, rear, numberOfElements;
    private Object[] storage;

    public CircularArrayBlockingQueue(int capacity){
        this.capacity=capacity;
        this.storage= new Object[capacity];
    }

    public synchronized void enqueue(E element) throws InterruptedException {

        while (isFull()) {
            wait();
        }

        if (isEmpty()) {
            notifyAll();
        }

        numberOfElements++;
        storage[front] = element;
        front = (front + 1) % capacity;
    }

    public synchronized E dequeue() throws InterruptedException{

        while (isEmpty()) {
            wait();
        }

        if (isFull()) {
            notifyAll();
        }

        numberOfElements--;

        E temp = (E) storage[rear];
        storage[rear] = null;
        rear = (rear + 1) % capacity;

        return temp;
    }

    public boolean isFull(){
        return numberOfElements == capacity;
    }

    public boolean isEmpty(){
        return numberOfElements ==0;
    }
}
