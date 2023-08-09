package com.ak.HashMapAndHeap;

import com.ak.Trees.BinaryTreeAndBST.Node;

import java.util.LinkedList;
import java.util.Queue;

public class CheckMaxHeap {
    //To check whether the tree is a maxheap or not , we'll first check whether it is a complete binary tree or not
    //To check whether the complete binary tree is max heap or not , we'll verify whether the node value is not greater than the parent value
    //to check whether a tree is a Complete or not : Key is once you find a null node , you mustn't get any other non-null node from the tree,if there is the return false.
    //we'll use BFS , level order traversal
    //at each node we'll insert element until the nodes become empty ,we'll pop out from the queue , if we got a non-null value , we'll pop it out
    public static boolean isCompleteTree(Node root) {
        if (root == null) return true;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
            } else {
                while (!queue.isEmpty()) {
                    if (queue.poll() != null) return false;
                }
            }
        }
        return true;
    }

    private static boolean checkMaxHeap(Node root, int parent) {
        if (root == null) return true;
        if (root.data > parent) return false;

        return checkMaxHeap(root.left, root.data) && checkMaxHeap(root.right, root.data);
    }

    public static void main(String[] args) {
        Node root = null;
        root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(1);
        int parent = Integer.MAX_VALUE;
        System.out.println(isCompleteTree(root) & checkMaxHeap(root,parent));
    }
}





