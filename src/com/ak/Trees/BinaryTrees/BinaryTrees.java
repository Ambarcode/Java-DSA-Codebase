package com.ak.Trees.BinaryTrees;

import java.util.Scanner;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;
    }
}

class BinaryTreeOperations {
    private static final Scanner scanner = new Scanner(System.in);

    // Method to insert nodes into the binary tree
    BinaryTreeNode insert(String nodeName) {
        System.out.println("Enter the " + nodeName + " data, or press -1 to exit:");
        int data = scanner.nextInt();
        if (data == -1)
            return null;

        BinaryTreeNode node = new BinaryTreeNode(data);

        System.out.println("Enter the left child of " + node.data + ":");
        node.left = insert("leftNode");

        System.out.println("Enter the right child of " + node.data + ":");
        node.right = insert("rightNode");

        return node;
    }

    // Method to print the binary tree
    void print(BinaryTreeNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " -> ");

        if (root.left != null)
            System.out.print("Left " + root.left.data);
        else
            System.out.print("Left NULL");

        if (root.right != null)
            System.out.println(" Right " + root.right.data);
        else
            System.out.println("Right NULL");

        print(root.left);
        print(root.right);
    }

    //Now we'll look into some traversals techniques

    //Depth First Traversal(DFS)-> Recursive Traversal (Stack based)
    //Three ways:
    // Inorder : Left Root Right
    //Preorder:  Root Left Right
    //Postorder: Left Right Root

    void inorder(BinaryTreeNode root){
        if (root==null) return;

        inorder(root.left);
        System.out.print(root.data +" ");
        inorder(root.right);
    }

    void postOrder(BinaryTreeNode root){
        if (root==null) return;

        System.out.print(root.data+" ");
        postOrder(root.left);
        postOrder(root.right);

    }
    void preOrder(BinaryTreeNode root){
        if (root==null) return;

        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data+" ");

    }
}

public class BinaryTrees {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BinaryTreeOperations opr = new BinaryTreeOperations();
        BinaryTreeNode root = null;

        while (true) {
            System.out.println("Binary Tree Operations ");
            System.out.println("1. Insert");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> root = opr.insert("rootNode"); // Insert operation
                case 2 -> opr.print(root); // Print operation
                case 3 -> System.exit(0); // Exit the program
                default -> System.out.println("Invalid choice. Please try again."); // Invalid choice
            }
        }
    }
}
