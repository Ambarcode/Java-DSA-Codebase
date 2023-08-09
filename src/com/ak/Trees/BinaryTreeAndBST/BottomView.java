package com.ak.Trees.BinaryTreeAndBST;

import java.util.*;

public class BottomView {
    private static class Pair{
        Node node;
        int vertical;

        Pair(Node node , int vertical){
            this.node=node;
            this.vertical=vertical;
        }
    }
    //It's the same as top view but instead of storing first occurrence at each vertical we'll store the last occurrence
    static ArrayList<Integer> bottomView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> queue=new ArrayDeque<>();
        queue.offer(new Pair(root,0));
        while (!queue.isEmpty()){
            Pair pair=queue.poll();
            Node node=pair.node;
            int ver=pair.vertical; //contains the vertical

            map.put(ver,node.data);
            if (node.left!=null){
                queue.offer(new Pair(node.left,ver-1));
            }

            if (node.right!=null){
                queue.offer(new Pair(node.right,ver+1));
            }
        }

        //storing the answer in ans
        for (Map.Entry<Integer,Integer> mp: map.entrySet()){
            ans.add(mp.getValue());
        }
        return ans;
    }
}
