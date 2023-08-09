package com.ak.Graph;

import com.ak.Trees.BinaryTreeAndBST.BinarySearchTree.GenericBST;

import java.util.ArrayList;

public class DFS {

    private static void dfs(ArrayList<BFS.Edge>[] graph , int curr, boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;
        for (int i = 0; i <graph[curr].size(); i++) {
            BFS.Edge edge=graph[curr].get(i);
            if (!vis[edge.dest]){
                dfs(graph,edge.dest,vis);
            }
        }
    }

    public static void main(String[] args) {
        int V=7;
        ArrayList<BFS.Edge>[] graph=new ArrayList[7];
        BFS.createGraph(graph);
        boolean[] vis=new boolean[V];
        //for handling the case of disconnected graph
        for (int i = 0; i <V ; i++) {
            if (!vis[i]){
                dfs(graph,i,vis);
            }
        }
    }
}
