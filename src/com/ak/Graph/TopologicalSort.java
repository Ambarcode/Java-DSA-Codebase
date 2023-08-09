package com.ak.Graph;

import java.security.spec.EdDSAParameterSpec;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    //It is performed on Acyclic directed  acyclic graph

    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    private static void topologicalSort(ArrayList<Edge>[] graph , int curr , boolean[] vis, Stack<Integer> stack){
        vis[curr]=true;
        for (int i=0;i<graph[curr].size();i++){
            Edge edge=graph[curr].get(i);
            if (!vis[edge.dest]){
                topologicalSort(graph, edge.dest,vis, stack);
            }
        }
        //for those vertices which does not have any dependency should be placed last
        stack.push(curr);
    }

    public static void main(String[] args) {

        int V=6;
        ArrayList<Edge>[] graph =new ArrayList[V];
        createGraph(graph);
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[V];
        for (int i = 0; i <V ; i++) {
            if (!vis[i]){
                topologicalSort(graph, i, vis, st);
            }
        }

        while (!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }
}
