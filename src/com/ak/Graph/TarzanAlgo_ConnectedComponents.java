package com.ak.Graph;

import java.util.ArrayList;
import java.util.List;

public class TarzanAlgo_ConnectedComponents {
    static List<List<Integer>> ans = new ArrayList<>();
    //https://leetcode.com/problems/critical-connections-in-a-network/description/
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections){
        //tarZan algorithm
        //first create a graph

        List<List<Integer>> graph =new ArrayList<>();
        for (int i=0;i<n;i++){
            //Initializing graph
            graph.add(i, new ArrayList<>());
        }

        //creating links
        for(List<Integer> connection: connections){
            int u=connection.get(0);
            int v=connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        //taking a discovery time  array and lowest discovery time array
        int[] dis=new int[n];
        int[] low=new int[n];

        //initialising a boolean visited array
        boolean[] vis=new boolean[n];
        int time=0;

        //now performing our modified dfs
        for (int i=0;i<n;i++){
            if (!vis[i]){
                dfs(graph, i, dis,low,0,vis,-1);
            }
        }
        return ans;
    }

    static void dfs(List<List<Integer>> graph , int curr, int[] dis , int[] low , int time ,  boolean[] vis , int par){
        vis[curr]=true;
        //initially the discovery time and lowest discovery time is same for all the vertices
        dis[curr]=low[curr]=time++;
        for (int dest: graph.get(curr)){
            if (dest==par){
                //do nothing in this case
                continue;
            }

            if (vis[dest]){
                //just update the lowest discovery time
                low[curr]=Math.min(dis[dest], low[curr]);
            }

            else {
                //update the lowest discovery time
                dfs(graph,dest,dis,low,time,vis,curr);
                low[curr]=Math.min(dis[dest], low[curr]);
                //check for branching condition
                if (dis[curr]<low[dest]){
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(dest);
                    ans.add(list);
                }
            }
        }
    }
}
