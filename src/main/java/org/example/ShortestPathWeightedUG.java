package org.example;

import java.util.*;

//This is Dijikstra Algorithm
//Dijkstra’s Algorithm is not valid for negative weights or negative cycles.
public class ShortestPathWeightedUG {

    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int[] dijikstra(int V, int[][] graph){
        int[]parent = new int[V];
        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);

        List<List<Integer>> adj = new ArrayList<>();
        Util util = new Util();
        util.convertToAdjList(V, graph, adj);
        //We can take queue, but it has 2 issues:
        //
        //
        //We can take priority Queue to get minimum distance node, to avoid unnecessary
        //traversal as in Queue

        //We can use set - it only takes one instance that too smaller one,
        //solving any extra traversal issue

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[0] = 0;
        parent[0] =0;
        pq.add(new Pair(0,0)); //dist, node
        while(!pq.isEmpty()){
            int f = pq.peek().first; //dist
            int s = pq.peek().second; //node
            pq.remove();

            for(int it : adj.get(s)){
                parent[it] = s;
                if(dist[it] > dist[s]+f)
                    dist[it] = dist[s]+f;
            }

        }

        return dist;
    }

}