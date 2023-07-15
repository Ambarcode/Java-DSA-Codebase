package com.ak.Stacks;

public class StackUsingLL {
    public static void main(String[] args) {
        CustomStack<Integer> stack = new CustomStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Peek: " + stack.peek()); // Output: 3

        int item1 = stack.pop();
        int item2 = stack.pop();

        System.out.println("Popped items: " + item1 + ", " + item2); // Output: 3, 2

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false

        stack.pop(); // Popping the last item

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: true
    }
}
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class CustomStack<T> {
    private Node<T> top;

    public CustomStack() {
        top = null;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}


