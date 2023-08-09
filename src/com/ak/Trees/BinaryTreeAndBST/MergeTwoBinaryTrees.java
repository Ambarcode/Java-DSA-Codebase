package com.ak.Trees.BinaryTreeAndBST;

public class MergeTwoBinaryTrees {
    public Node mergeTrees(Node root1, Node root2) {
        if(root1 ==null) return root2;
        if(root2==null) return root1;

        root1.data+=root2.data;
        root1.left=mergeTrees(root1.left,root2.left);
        root1.right=mergeTrees(root1.right,root2.right);

        return root1;
    }
}
