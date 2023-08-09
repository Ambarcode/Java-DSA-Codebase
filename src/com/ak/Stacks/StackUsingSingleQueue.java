package com.ak.Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {
    Queue<Integer> q = new LinkedList<Integer>();

    // Push operation
    void push(int val)
    {
        // get previous size of queue
        int size = q.size();

        // Add current element
        q.add(val);

        // Pop (or Dequeue) all previous
        // elements and put them after current
        // element
        for (int i = 0; i < size; i++)
        {
            // this will add front element into
            // rear of queue
            int x = q.remove();
            q.add(x);
        }
    }

    // Removes the top element
    int pop()
    {
        if (q.isEmpty())
        {
            System.out.println("No elements");
            return -1;
        }
        int x = q.remove();
        return x;
    }

    // Returns top of stack
    int top()
    {
        if (q.isEmpty())
            return -1;
        return q.peek();
    }
}
