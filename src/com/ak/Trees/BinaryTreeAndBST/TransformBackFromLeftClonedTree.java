package com.ak.Trees.BinaryTreeAndBST;

public class TransformBackFromLeftClonedTree {
    private static Node transformBack(Node node){
        if (node==null) return null;

        Node lnn=transformBack(node.left.left);
        Node rnn=transformBack(node.right);

        node.left=lnn;
        node.right=rnn;
        return node;
    }
}
