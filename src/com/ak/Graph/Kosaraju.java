package com.ak.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Kosaraju{
    //The algorithm is used to find the strongly connected components of the graph
    static class Edge{
        int src;
        int dest;

        public Edge(int src ,int dest){
            this.src=src;
            this.dest=dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    static void dfs(ArrayList<Edge>[] graph , int curr, boolean[] vis){
        System.out.print(curr+" ");
        vis[curr]=true;
        for (int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if (!vis[e.dest]){
                dfs(graph, e.dest,vis);
            }
        }
    }

    //topological sorting
    static void topological(ArrayList<Edge>[] graph , int curr , boolean[] vis, Stack<Integer> st){
        vis[curr]=true;
        for (int i=0;i<graph[curr].size();i++){
            Edge edge=graph[curr].get(i);
            if (!vis[edge.dest]){
                topological(graph, edge.dest, vis, st);
            }
        }
        st.push(curr);
    }

    //now the kosaraju method for finding no. of strongly connected components
    public static void kosaraju(ArrayList<Edge>[]graph , int V){
        //step 1: topological sort
        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[V];
        for (int i=0;i<V;i++){
            if (!vis[i]){
                topological(graph, i, vis, st);
            }
        }

        //step 2: transpose the graph
        ArrayList<Edge>[] transpose=new ArrayList[V];
        for (int i=0;i<V;i++){
            vis[i]=false;  // to save time (not associated with this loop)
            transpose[i]=new ArrayList<>();
        }

        //now we'll store the destination in source and source in destination
        //transpose
        for (int i=0;i<V;i++){
            for (int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j); //source to destination : destination to source
                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }
        //now we'll remove element from the stack and perform dfs
          while (!st.isEmpty()){
              int ver=st.pop();
              if (!vis[ver]){
                  dfs(transpose, ver, vis);
                  System.out.println();
              }

          }
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph=new ArrayList[V];
        for (int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        createGraph(graph);
        kosaraju(graph,V);
    }
}
