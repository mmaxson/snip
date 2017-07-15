package com.mmu.gen.inter;

/**
 * Created by mu on 7/14/17.
 */
public interface MyQueue<E> {
    void enqueue( E element );
    E dequeue();
    boolean isEmpty();
    boolean isFull();
}
