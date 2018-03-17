package com.mmu.gen.inter;

/**
 * Created by mu on 7/14/17.
 */
public interface MyStack<E> {
    void push(E element);
    E pop();
    boolean isEmpty();
    boolean isFull();
}
