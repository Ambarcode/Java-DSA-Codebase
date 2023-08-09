package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(Node root) {
        List<String> ans=new ArrayList<>();
        dfs(root,ans,"");
        return ans;
    }
    public void dfs(Node node, List<String> lis, String s){
        if(node==null) return;
        if(node.left==null && node.right==null){
            s+=node.data+"";
            lis.add(s);
            return;
        }

        s+=node.data+"->";
        dfs(node.left, lis, s);
        dfs(node.right, lis, s);
    }
}
