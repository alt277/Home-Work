package ru.gbyte.multy_brackets;


class Stack
{
    private int maxSize;
    private char[] stackArray;
    private int top;


    public Stack(int s)
    {
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j)
    {
        stackArray[++top] = j;
    }

    public char pop()
    {
        return stackArray[top--];
    }

    public char peek() // Чтение элемента с вершины стека
    {
        return stackArray[top];
    }

    public boolean isEmpty() // True, если стек пуст
    {
        return (top == -1);
    }
}


