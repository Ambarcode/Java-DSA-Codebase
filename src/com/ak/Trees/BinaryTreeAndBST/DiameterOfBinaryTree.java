package com.ak.Trees.BinaryTreeAndBST;

public class DiameterOfBinaryTree {
    //diameter of binary tree is basically the maximum distance of l.h.s +r.h.s for a particular node
    int diameter=Integer.MIN_VALUE;
    public int diameterOfBinaryTree(Node node) {
        helper(node);
        return diameter;
    }

    private int helper(Node node){
        if(node==null) return 0;
        int leftH=helper(node.left);
        int rightH=helper(node.right);
        diameter=Math.max(diameter,leftH+rightH);
        //but at last we have to return the height only
        return 1+Math.max(leftH,rightH);
    }
}
