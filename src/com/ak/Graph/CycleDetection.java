package com.ak.Graph;

import java.util.ArrayList;

public class CycleDetection{
    //For cycle detection , we'll check for two things
    //If the neighbour of the parent is already visited, and it's not equal to it' s parent , we got a cycle else , move further
    //Now we'll see how to detect a cycle in a directed graph
    //In this we'll use a recursive stack+visited array

    private static boolean detectDirected(ArrayList<BFS.Edge>[] graph , boolean[] vis , boolean[] recStack , int curr){
        vis[curr]=true;
        recStack[curr]=true;

        for (int i=0;i<graph[curr].size();i++){
            BFS.Edge e=graph[curr].get(i);
            if (recStack[e.dest]) return true;
            else if (!vis[e.dest]){
                if (detectDirected(graph,vis,recStack,e.dest)){
                    return true;
                }
            }
        }
        recStack[curr]=false;
        return false;
    }
}
