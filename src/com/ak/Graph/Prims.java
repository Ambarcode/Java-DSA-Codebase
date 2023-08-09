package com.ak.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    //Prims Algorithm is used to find the minimum spanning tree
    //for finding the minimum spanning tree , we can assume that we have our non visited MST set , and a visited MST set ,
    //lets say we start with the source vertex , we'll look for the vertex with the minimum cost(Priority Queue)
    //one by one we'll check for the minimum , remove it from the non visited set and add it to the visited set
    // when the non visited set will become empty we get our answer


    //For implementing it , we'll create a Pair class which will store the node and cost associated to reach that node
    //We'll create PriorityQueue of Pair
    //We'll also use a visited array to ensure only minimum cost node is selected only


    static class Edge{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest , int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }

    static class Pair{
        int n;
        int cost;

        public Pair(int n, int cost){
            this.n=n;
            this.cost=cost;
        }
    }

    private static void Prims (ArrayList<Edge>[] graph , int V){
        PriorityQueue<Pair> pq=new PriorityQueue<>((pair1, pair2)-> pair1.cost-pair2.cost); //non-mst
        boolean[] Vis=new boolean[V]; //mst
        int mincost=0;
        pq.add(new Pair(0,0));
        while (!pq.isEmpty()){
            Pair pair=pq.remove();
            if (!Vis[pair.n]){
                //to ensure only minimum cost node is added
                Vis[pair.n]=true;
                mincost+=pair.cost;
                for (int i = 0; i <graph[pair.n].size() ; i++) {
                    Edge e=graph[pair.n].get(i);
                    if (!Vis[e.dest]){
                        pq.add(new Pair(e.dest, e.weight));
                    }
                }
            }
        }
        System.out.println("Minimum Cost : "+mincost);
    }
}
