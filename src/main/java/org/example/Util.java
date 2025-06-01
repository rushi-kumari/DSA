package org.example;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public void convertToAdjList(int V, int[][]graph, List<List<Integer>> list){
        for(int i = 0;i< V; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i< graph.length; i++){
            for(int j =0; j< graph[0].length; j++){
                if(graph[i][j] == 1)
                    list.get(i).add(j);
            }
        }
    }
}
