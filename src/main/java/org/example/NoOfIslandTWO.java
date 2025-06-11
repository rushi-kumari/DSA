package org.example;

import java.util.ArrayList;
import java.util.List;

public class NoOfIslandTWO{
    private boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    public List<Integer> noOfislands(int n, int m, int[][]operators){
        List<Integer> ans = new ArrayList<>();
        int[][] vis = new int[n][m];
        DisjointSetDS ds = new DisjointSetDS(n*m);
        int cnt = 0;
        int len = operators.length;
        for (int i = 0; i < len ; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (vis[row][col] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int ind = 0; ind < 4; ind++) {
                int adjr = row + dr[ind];
                int adjc = col + dc[ind];
                if (isValid(adjr, adjc, n, m)) {
                    if (vis[adjr][adjc] == 1) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = adjr * m + adjc;
                        if (ds.findUltimateParent(nodeNo) != ds.findUltimateParent(adjNodeNo)) {
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }

        return ans;
    }
}
