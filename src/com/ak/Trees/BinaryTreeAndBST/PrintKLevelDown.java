package com.ak.Trees.BinaryTreeAndBST;

public class PrintKLevelDown {

    private static void printKLevelDown(Node node , int k){
         if (node==null || k<0) return;

         if (k==0) System.out.print(node.data+" ");

         printKLevelDown(node.left,k-1); //to reach till kth level
         printKLevelDown(node.right,k-1);
    }

    public static void main(String[] args) {
        Integer[] arr={50,25,12,null,null,37,30,null,null,null,75, 62, null, 70, null,null,87,null,null};
        Node root=new Node();
        root=Node.create(root,arr);
        printKLevelDown(root,2);
    }
}
