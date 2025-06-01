package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopoSortDFS {

    public void dfs(List<List<Integer>> list, int[] vis, int i, Stack<Integer> st){
        vis[i] = 1;
        for (int it : list.get(i)) {
            if (vis[it] == 0)
                dfs(list, vis, it,st);
        }
        st.push(i);
    }
    public int[] topSort(int V, int[][]graph){
        int[] sortedOrder = new int[V];
        List<List<Integer>> list = new ArrayList<>();
        Util util = new Util();
        util.convertToAdjList(V,graph,list);

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<V; i++){
            if(vis[i] ==0){
                dfs(list, vis, i, st);
            }
        }
        int i = 0;
        while (!st.isEmpty()) {
            sortedOrder[i++] = st.peek();
            st.pop();
        }
        return sortedOrder;
    }
}
