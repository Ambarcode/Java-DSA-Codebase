package com.ak.Trees.BinaryTreeAndBST;

public class BalancedBST {
    //we have to check whether the given tree is balanced binary tree or not
    public boolean isBalanced(Node root) {
        return helper(root) != -1;
    }

    private int helper(Node node){
        if(node==null) return 0;
        int lH=helper(node.left);
        if(lH==-1) return -1;
        int rH=helper(node.right);
        if(rH==-1) return -1;

        if(Math.abs(lH-rH)>1) return -1;
        return 1+Math.max(lH,rH);
    }
}
