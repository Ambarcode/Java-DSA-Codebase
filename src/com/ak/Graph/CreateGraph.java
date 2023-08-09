package com.ak.Graph;

import java.util.ArrayList;

public class CreateGraph {
    //we'll be creating graph using Array of Arraylist
    public static class Edge{
        int src;
        int des;

        public Edge(int src , int des){
            this.src=src;
            this.des=des;
        }
    }

    public static class EdgeWeighted{
        int src;
        int des;
        int cost;
        public EdgeWeighted(int src , int des, int cost){
            this.src=src;
            this.des=des;
            this.cost=cost;
        }
    }

    private static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length ; i++) {
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));
        graph[2].add(new Edge(2,3));
        graph[2].add(new Edge(2,0));
        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(1,3));
    }

    private static void createGraphWeighted(ArrayList<EdgeWeighted>[] graph){
        for (int i = 0; i < graph.length ; i++) {
            graph[i]=new ArrayList<EdgeWeighted>();
        }
        graph[0].add(new EdgeWeighted(0,2,2));
        graph[2].add(new EdgeWeighted(2,3,-1));
        graph[2].add(new EdgeWeighted(2,0,2));
        graph[3].add(new EdgeWeighted(3,2,-1));
        graph[3].add(new EdgeWeighted(3,1,0));
        graph[3].add(new EdgeWeighted(1,3,0));
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge>[] graph=new ArrayList[V];
        createGraph(graph);

        //To print neighbour
        //for example 2's neighbour
        for (int i = 0; i <graph[2].size() ; i++) {
            Edge e=graph[2].get(i);
            System.out.print(e.des+" ");
        }
        System.out.println();


        //For Weighted graph
        ArrayList<EdgeWeighted>[] graph1=new ArrayList[V];
        createGraphWeighted(graph1);

    }
}
