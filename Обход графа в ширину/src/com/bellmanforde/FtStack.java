package com.bellmanforde;

public class FtStack {
    private static final int SIZE = 10;
    private int top;
    private int[] array;

    public FtStack() {
        array = new int[SIZE];
        top = -1;
    }

    public void push(int v) {
        array[++top] = v;
    }

    public int pop() {
        return array[top--];
    }

    public int pick() {
        return array[top];
    }

    public boolean isEmpty() {
        if(top == -1 )
            return true;
        else return false;
    }
}
