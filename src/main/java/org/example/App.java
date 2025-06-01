package org.example;

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

        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        ShortestPathDAG obj = new ShortestPathDAG();
        int ans[] = obj.shortestPath(n, m, edge);

        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
}
