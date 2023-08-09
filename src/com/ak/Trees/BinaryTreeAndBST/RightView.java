package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    //So basically the approach is to store the node at every level that comes last
    public List<Integer> rightSideView(Node root) {
      List<Integer> ans=new ArrayList<>();
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
            //for right view
            traversal(node.right,currSize+1,ans);
            traversal(node.left,currSize+1,ans);

    }
}
