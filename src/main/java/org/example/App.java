package org.example;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        int V = 6;
        int[][] a = { { 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 0, 0, 0, 0 },
                      { 0, 0, 0, 1, 0, 0 },
                      { 0, 1, 0, 0, 0, 0 },
                      { 1, 1, 0, 0, 0, 0 },
                      { 1, 0, 1, 0, 0, 0 }};

//      TopoSortDFS tp = new TopoSortDFS();
//      int[] ans = tp.topSort(V, a);

//      TopoSortBFSKahnAlgo tps = new TopoSortBFSKahnAlgo();
//      int[] ans = tps.topSort(V, a);

//        int n=9, m=10;
//        int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
//
//        ShortestPathUG sug = new ShortestPathUG();
//        int[] ans = sug.shortPath(n, m, edge, 0);

//        int n = 6, m = 7;
//        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
//        ShortestPathDAG obj = new ShortestPathDAG();
//        int ans[] = obj.shortestPath(n, m, edge);

        DisjointSetDS ds = new DisjointSetDS(7);
//        ds.unionByRank(1,2);
//        ds.unionByRank(2,3);
//        ds.unionByRank(4,5);
//        ds.unionByRank(5,6);
//        ds.unionByRank(6,7);
//        if(ds.findUltimateParent(3) == ds.findUltimateParent(7))
//            System.out.println("same");
//        else System.out.println("Not same");
//        ds.unionByRank(3,7);
//        if(ds.findUltimateParent(3) == ds.findUltimateParent(7))
//            System.out.println("same");
//        else System.out.println("Not same");


        ds.unionBySize(1,2);
        ds.unionBySize(2,3);
        ds.unionBySize(4,5);
        ds.unionBySize(5,6);
        ds.unionBySize(6,7);
        if(ds.findUltimateParent(3) == ds.findUltimateParent(7))
            System.out.println("same");
        else System.out.println("Not same");
        ds.unionBySize(3,7);
        if(ds.findUltimateParent(3) == ds.findUltimateParent(7))
            System.out.println("same");
        else System.out.println("Not same");

//        for (int node : ans) {
//            System.out.print(node + " ");
//        }
//        System.out.println("");

        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        NoOfIslandTWO obj = new NoOfIslandTWO();
        List<Integer> ans = obj.noOfislands(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");

    }
}
