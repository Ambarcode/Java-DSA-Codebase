package com.ak.Graph;

import java.util.ArrayList;

public class GenericGraph {
    private static void addEdges(ArrayList<ArrayList<Integer>> list , int u , int v) {
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>(V);
        for (int i = 0; i <V ; i++) {
            graph.add(new ArrayList<>());
        }

        addEdges(graph,0,1);
        addEdges(graph,0,2);
        addEdges(graph,1,3);
        addEdges(graph,3,5);
        addEdges(graph,3,4);
        addEdges(graph,3,5);
        addEdges(graph,5,6);
        addEdges(graph,2,4);
    }
}
