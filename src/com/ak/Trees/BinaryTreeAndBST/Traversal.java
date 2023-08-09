package com.ak.Trees.BinaryTreeAndBST;

public class Traversal {
    //Pre //Post //Inorder
    private static void preOrder(Node node){
        if (node==null) return;
        //Node Left Right
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    private static void postOrder(Node node){
        if (node==null) return;
        //Left Right Node
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }

    private static void inOrder(Node node){
        if (node==null) return;
        //Left Node Right
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }

    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
        Node root=new Node();
        root=Node.create(root,arr);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        traversal(root);
    }

    private static void traversal(Node node){
        if (node==null) return;

        System.out.print(node.data+ " in Preorder ");
        traversal(node.left);
        System.out.print(node.data+" in Inorder ");
        traversal(node.right);
        System.out.print(node.data+" in PostOrder ");
    }

    }



