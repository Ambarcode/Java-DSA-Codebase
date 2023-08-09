package com.ak.Trees.BinaryTreeAndBST;

import java.util.*;

public class TopView {


    public static class Pair{
        Node node;
        int vertical;

        Pair(Node node , int vertical){
            this.node=node;
            this.vertical=vertical;
        }
    }
    //We'll use the Level-order traversal , as recursive traversal will store the last occurrence
    static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans=new ArrayList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> queue=new ArrayDeque<>();
        queue.offer(new Pair(root,0));
        while (!queue.isEmpty()){
            Pair pair=queue.poll();
            Node node=pair.node;
            int ver=pair.vertical; //contains the vertical

            if (!map.containsKey(ver)) map.put(ver,node.data);
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
