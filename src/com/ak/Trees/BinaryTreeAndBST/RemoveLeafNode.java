package com.ak.Trees.BinaryTreeAndBST;

public class RemoveLeafNode {
    private static Node removeLeaf(Node node){
        if (node==null) return null;

        node.left=removeLeaf(node.left);
        node.right=removeLeaf(node.right);

        if (node.right==null && node.left==null){
            return null;
        }
        return node;
    }
}
