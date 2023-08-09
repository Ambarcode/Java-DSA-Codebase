package com.ak.Trees.BinaryTreeAndBST;

public class MaximumPathSum {
    //we have to calculate maximum path sum in a BT
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(Node root) {
        help(root);
        return maxSum;
    }

    private int help(Node node){
        if(node==null) return 0;


        //to handle the nodes , containing negative values
        int leftSum=Math.max(0,help(node.left));
        int rightSum=Math.max(0,help(node.right));

        maxSum=Math.max(maxSum, leftSum+rightSum+node.data);

        //either include the rightMaxPath or leftMax path
        return node.data+Math.max(leftSum,rightSum);
    }
}
