package com.ak.Trees.BinaryTreeAndBST.BinarySearchTree;

class Node {
    int key;
    Node left;
    Node right;

    public Node(int item) {
        key = item;
        left = null;
        right = null;
    }
}
public class GenericBST {
    Node root;

    public GenericBST(){
        root=null;
    }
    // Method to insert a key in the BST
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    // Recursive method to insert a key in the BST
    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRecursive(root.left, key);
        } else if (key > root.key) {
            root.right = insertRecursive(root.right, key);
        }

        return root;
    }


    // Method to perform an in-order traversal of the BST
    public void inorderTraversal() {
        inorderRecursive(root);
    }

    // Recursive method to perform an in-order traversal of the BST
    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }

    // Method to search for a key in the BST
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    // Recursive method to search for a key in the BST
    private boolean searchRecursive(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.key == key) {
            return true;
        }

        if (key < root.key) {
            return searchRecursive(root.left, key);
        } else {
            return searchRecursive(root.right, key);
        }
    }

    private static int minValue(Node root){
        if (root==null) return Integer.MIN_VALUE;
        int min=root.key;
        while (root.left!=null){
            min=root.left.key;
            root=root.left;
        }
        return min;
    }

    private static int maxValue(Node root){
        if (root==null) return Integer.MAX_VALUE;
        int max=root.key;
        while (root.right!=null){
            max=root.left.key;
            root=root.right;
        }
        return max;
    }

    //Now we'll see how to perform delete operation
    //Here we have to handle 3 cases
    private static void delete(Node root , Node parent , boolean isLeft, int data){

        if (data>root.key)  delete(root.right, root,false,data);
        else if (data<root.key)  delete(root.left, root,true,data);
        else {
            //Data found
            //Case 1: if the node to be deleted does not have any left child or right child
            if (root.left==null && root.right==null) {
                if (isLeft) parent.left=null;
                else parent.right=null;
            }

            //Case 2: if right is not null but left is null
            if (root.left==null && root.right!=null){
                if (isLeft){
                    parent.left=root.right;
                }
                else  parent.right=root.right;
            }

            //Case 3: If left is not null but right is null
            if (root.right==null && root.left!=null){
                if (isLeft){
                    parent.left=root.left;
                }
                else  parent.right=root.left;
            }

            //Case 4: root.left!=null and root.right!=null
            // when both left and right!=null , we'll find the left max element and replace it with the root element(current) and delete the last element using case 1
            //or min from right and the same procedure
            if (root.left!=null && root.right!=null){
                //left max
                int max=maxValue(root.left);
                root.key= max;
                delete(root.left,root,true,max);
            }
        }
    }


}
