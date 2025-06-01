package org.example;

import java.util.*;

public class ShortestPathUG {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[] shortPath(int V, int U, int[][] graph, int src) {
        if(V == 0) return new int[1];
        List<List<Integer>> list = new ArrayList<>();
        Util util = new Util();
        util.convertToAdjList(V, graph, list);

        for(int i = 0;i<U;i++) {
            list.get(graph[i][0]).add(graph[i][1]);
            list.get(graph[i][1]).add(graph[i][0]);
        }
        int[] dist = new int[V]; //considering 0 as src
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        Queue<Pair> q = new LinkedList<>(); //node, dist
        q.add(new Pair(src,0));

        while(!q.isEmpty()){
            int node = q.peek().first;
            int d = q.peek().second;
            q.poll();

            for(int ele: list.get(node)){
                if(d+1 < dist[ele]){
                    dist[ele] = 1+d;
                    q.add(new Pair(ele,dist[ele]));
                }
            }
        }
        return dist;
    }
}
