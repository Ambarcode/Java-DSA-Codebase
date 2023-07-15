package com.ak.Stacks;

import java.util.ArrayList;

class StackUsingArrayList<T> {
    private ArrayList<T> stack;

    public StackUsingArrayList() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void print() {
        System.out.print("Stack: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
}

 class Main {
    public static void main(String[] args) {
        StackUsingArrayList<Integer> stack = new StackUsingArrayList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.print(); // Output: Stack: 3 2 1

        int item1 = stack.pop();
        int item2 = stack.pop();

        System.out.println("Popped items: " + item1 + ", " + item2); // Output: Popped items: 3, 2

        stack.print(); // Output: Stack: 1

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? false

        stack.pop(); // Popping the last item

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? true
    }
}

