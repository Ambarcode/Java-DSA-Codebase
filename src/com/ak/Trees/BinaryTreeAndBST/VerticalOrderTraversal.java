package com.ak.Trees.BinaryTreeAndBST;

import java.sql.ClientInfoStatus;
import java.util.*;

public class VerticalOrderTraversal {

    //for the traversal we have to make a class
    private static class Triplet {
        Node node;
        int row;
        int col;

        Triplet(Node node, int row, int col) {
            this.node = node;
            this.row = 0;
            this.col = 0;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        //The first key correspond to the vertical , the second key correspond to level and the value correspond to node.val
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); //Priority Queue for handling overlapping values such that they are to be arranged in increasing order
        Queue<Triplet> queue = new LinkedList<>(); //we are using level order traversal
        queue.offer(new Triplet(root, 0, 0));
        while (!queue.isEmpty()) {
            Triplet tp = queue.poll();
            Node node = tp.node;

            int x = tp.row; //vertical
            int y = tp.col; //level

            if(!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left != null) {
                queue.offer(new Triplet(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                queue.offer(new Triplet(node.right, x + 1, y + 1));
            }
        }

        //now we have to store the results in increasing order of vertical and levels
        //i.e. ascending order

        List<List<Integer>> ans = new ArrayList<>();
        //for every vertical
        for (TreeMap<Integer, PriorityQueue<Integer>> temp : map.values()) {
            ans.add(new ArrayList<>()); //adding an empty list for every vertical
            for (PriorityQueue<Integer> que : temp.values()) {
                //ok so i will face a  problem in overlapping
                //so i am adding a while loop
                while (!que.isEmpty()) {
                    ans.get(ans.size() - 1).add(que.poll());
                }
            }
        }
        return ans;
    }

    //we can also use preorder traversal
    public List<List<Integer>> verticalTraversal2(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>(); // Priority Queue for handling overlapping values such that they are to be arranged in increasing order
        preorderTraversal(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();
        // for every vertical
        for (TreeMap<Integer, PriorityQueue<Integer>> temp : map.values()) {
            ans.add(new ArrayList<>()); // adding an empty list for every vertical
            for (PriorityQueue<Integer> que : temp.values()) {
                while (!que.isEmpty()) {
                    ans.get(ans.size() - 1).add(que.poll());
                }
            }
        }
        return ans;
    }

    private void preorderTraversal(Node node, int row, int col, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) {
            return;
        }

        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }
        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new PriorityQueue<>());
        }
        map.get(col).get(row).offer(node.data);

        preorderTraversal(node.left, row + 1, col - 1, map);
        preorderTraversal(node.right, row + 1, col + 1, map);
    }

}
