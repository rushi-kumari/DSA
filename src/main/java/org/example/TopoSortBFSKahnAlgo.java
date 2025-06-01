package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortBFSKahnAlgo {
    public void bfs(int V, int[][]graph, List<List<Integer>> list, int[] result){
        int[] indegree = new int[V];
        for(int i = 0; i<V; i++){
            for(int it : list.get(i))
                indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<V; i++){
            if(indegree[i] == 0)
                q.offer(i);
        }
        int i = 0;
        while(!q.isEmpty()){
            int ele = q.peek();
            q.poll();

            result[i++] = ele;
            for(int it : list.get(ele)){
                indegree[it]--;
                if(indegree[it] == 0)
                    q.add(it);
            }
        }
    }

    public int[] topSort(int V, int[][]graph){
        int[] sortedOrder = new int[V];
        List<List<Integer>> list = new ArrayList<>();
        Util util = new Util();
        util.convertToAdjList(V,graph,list);
        bfs(V, graph, list, sortedOrder);
        return sortedOrder;
    }
}
