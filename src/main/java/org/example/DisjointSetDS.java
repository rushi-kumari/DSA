package org.example;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetDS {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSetDS(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int findUltimateParent(int node){
        if(node == parent.get(node))
            return node;
        int par = findUltimateParent(parent.get(node));
        parent.set(node,par);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if(ulp_u == ulp_v)return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u,ulp_v);
        }
        else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_v,ulp_u);
            int ulp_u_rank = rank.get(ulp_u);
            rank.set(ulp_u,ulp_u_rank+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUltimateParent(u);
        int ulp_v = findUltimateParent(v);
        if(ulp_u == ulp_v)return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u,ulp_v);
            int size_u = size.get(ulp_u);
            int size_v = size.get(ulp_v);
            size.set(ulp_v,size_u+size_v);
        }
        else{ //as we increase size in all cases, but earlier rank was increased only in one case
            parent.set(ulp_v,ulp_u);
            int size_u = size.get(ulp_u);
            int size_v = size.get(ulp_v);
            size.set(ulp_u,size_u+size_v);
        }
    }
}
