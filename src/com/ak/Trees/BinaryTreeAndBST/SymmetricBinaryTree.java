package com.ak.Trees.BinaryTreeAndBST;

public class SymmetricBinaryTree {
    public boolean isSymmetric(Node root) {
        return root==null || help(root.left, root.right);
    }
    private boolean help(Node left , Node right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.data!=right.data)return false;
        return help(left.left , right.right) && help(left.right , right.left);
    }
}
