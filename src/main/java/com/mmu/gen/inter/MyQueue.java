package com.mmu.gen.inter;

/**
 * Created by mu on 7/14/17.
 */
public interface MyQueue<E> {
    void enqueue( E element ) throws InterruptedException;
    E dequeue() throws InterruptedException;
    boolean isEmpty();
    boolean isFull();
}
