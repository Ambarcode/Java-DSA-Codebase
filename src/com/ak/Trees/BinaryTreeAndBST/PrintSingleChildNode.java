package com.ak.Trees.BinaryTreeAndBST;

public class PrintSingleChildNode {
    //we have to print the parent who have only single child

    //ye h preorder ka kaam
    //initially parent==null
    private static void printSingle(Node parent ,Node node){
        if (node==null) return;

        if (parent!=null && parent.left==node && parent.right==null){
            //we have to print the node whose parent has only single child
            System.out.print(node.data+" ");
        }
        else if(parent!=null && parent.right==node && parent.left==null){
            System.out.print(node.data+" ");
        }

    }
}
