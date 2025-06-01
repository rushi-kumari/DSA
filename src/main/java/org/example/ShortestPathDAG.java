package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPathDAG {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public void topSort( int[]vis, ArrayList<ArrayList<Pair>>adj, int idx, Stack<Integer>st){
        vis[idx] =1;
        for(int i = 0; i < adj.get(idx).size(); i++){
            int v = adj.get(idx).get(i).first;
            if(vis[v] == 0)
                topSort(vis,adj,v,st);
        }

        st.push(idx);
    }
    public int[] shortestPath(int n, int m,  int[][]graph){
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for(int i =0; i<n;i++){
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            int wt = graph[i][2];
            arr.get(u).add(new Pair(v, wt));
        }

        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<n; i++){
            if(vis[i] == 0)
                topSort(vis, arr, i, st);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int)1e9);
        distance[0] = 0;
        while(!st.isEmpty()){
            int node = st.peek();
            st.pop();
            for (int i = 0; i < arr.get(node).size(); i++) {
                int v = arr.get(node).get(i).first;
                int wt = arr.get(node).get(i).second;
                if (distance[v] >  wt + distance[node])
                    distance[v] = wt + distance[node];
            }
        }
        return distance;
    }
}
