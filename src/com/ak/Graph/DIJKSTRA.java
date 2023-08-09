package com.ak.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DIJKSTRA {

    //First we'll create Edge class
    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src , int dest, int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));
        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    //Now we'll create a Pair class , which will store the nodes and the distance associated with them
     static class Pair{
        int n;
        int path;

        Pair(int n , int path){
            this.n=n;
            this.path=path;
        }
    }

    //Time Complexity: O(E+ELogV)
    public static void dijkstra(ArrayList<Edge>[] graph , int src , int V){
        //Initialize a Priority Queue which will store nodes on basis of distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((pair1, pair2) -> pair1.path - pair2.path);
        int[] dis=new int[V];
        //Initialize very node other than source to be infinity
        for (int i = 0; i <V ; i++) {
            if (i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }

        //make a visited array
        boolean[] vis=new boolean[V];
        pq.add(new Pair(0,0));

        while (!pq.isEmpty()){
            Pair curr=pq.remove(); //shortest
            if (!vis[curr.n]){
                vis[curr.n]=true;
                for (int i = 0; i <graph[curr.n].size() ; i++) {
                    Edge e=graph[curr.n].get(i);
                    int u=e.src;
                    int v=e.dest;

                    //Relaxation
                    if (dis[u]+e.weight<dis[v]){
                        dis[v]=dis[u]+ e.weight;
                        pq.add(new Pair(v,dis[v]));
                    }
                }
            }
        }

        //Running a loop to print
        System.out.println(Arrays.toString(dis));
    }

    public static void main(String[] args) {
        int V=6;
       ArrayList<Edge>[] graph=new ArrayList[V];
       createGraph(graph);
       dijkstra(graph, 0, V);
    }
}
