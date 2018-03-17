package com.mmu.gen;

import com.mmu.gen.inter.MyStack;

public class ArrayStack<E> implements MyStack<E> {
    private int capacity;
    private Object[] data;
    private int top;

    public ArrayStack(int capacity) {
        capacity = capacity;
        data = new Object[capacity];
        top = -1;
    }

    public void push(E element) {
        data[++top] = element;
    }

    public E pop() {
        return (E) data[top--];
    }

    public E peek() {
        return (E) data[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == capacity - 1);
    }

    public static void main(String[] args) {
        MyStack<Integer> theStack = new ArrayStack(10);
        theStack.push(10);
        theStack.push(20);
        theStack.push(30);
        theStack.push(40);
        theStack.push(50);

        while (!theStack.isEmpty()) {
            System.out.print(theStack.pop());
            System.out.print(" ");
        }
        System.out.println("");
    }
}
