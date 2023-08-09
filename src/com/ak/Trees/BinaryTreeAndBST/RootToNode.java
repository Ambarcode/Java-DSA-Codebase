package com.ak.Trees.BinaryTreeAndBST;

import java.util.ArrayList;
import java.util.List;

public class RootToNode {
    //if we get the node , we'll return true and waapis

    public ArrayList<Integer> solve(Node node, int target) {
        ArrayList<Integer> list=new ArrayList<>();
        if(node==null) return list;
        traverse(node, target , list);
        return list;
    }

    private boolean traverse(Node node, int target, List<Integer> list) {
        if (node==null) return false;
        list.add(node.data);
        if (node.data==target) return true;

        if (traverse(node.left , target, list) || traverse(node.right,target,list))
            return true;

        //backtrack
        list.remove(list.size()-1);
        return false;
    }
}
