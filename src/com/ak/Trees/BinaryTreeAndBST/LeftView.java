package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;

public class LeftView {

    //The approach is similar to right, but instead we'll traverse in Left Root Right Manner
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if (root==null) return ans;
        traversal(root,0,ans);
        return ans;
    }
    private void traversal(Node node, int currSize, List<Integer> ans){
        if (node==null) return;

        //will store only the first occurrence of every level if move like Right Root Left
        if (currSize==ans.size()) {
            ans.add(node.data);
        }
        //for left view
        traversal(node.left,currSize+1,ans);
        traversal(node.right,currSize+1,ans);

    }
}
