package com.ak.Graph;

import java.util.ArrayList;

public class PrintAllPath {

    public static void printAllPaths(ArrayList<BFS.Edge> graph[], int src, int tar, String path, boolean vis[]) {
        if(src == tar) {
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[src].size(); i++) {
            BFS.Edge e = graph[src].get(i);
            if(!vis[e.dest]) {
                vis[e.dest] = true;
                printAllPaths(graph, e.dest, tar, path+"->"+e.dest, vis);
                vis[e.dest] = false;
            }
        }
    }

    public static void main(String[] args) {
        int V=7;
        ArrayList<BFS.Edge> graph[] = new ArrayList[V];
        BFS.createGraph(graph);
        int src = 0;
        int tar = 5;
        boolean vis[] = new boolean[V];
        vis[src] = true;
        printAllPaths(graph, src, tar, ""+src, vis);
    }
}
