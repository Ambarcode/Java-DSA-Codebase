package com.ak.Trees.BinaryTreeAndBST;

public class SumRootToLeafNumbers {
    public int sumNumbers(Node root) {
        return dfs(root,0);
    }

    private int dfs(Node root, int sum){
        if(root==null) return 0;
        sum=sum*10+root.data;

        if(root.left==null && root.right==null){
            return sum;
        }

        return dfs(root.left,sum)+dfs(root.right, sum);
    }
}
