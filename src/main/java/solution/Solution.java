package solution;

public class Solution {
    public static int getResult(int[][] matrix) {
        int rightPrice;
        int downPrice;
        int[][] way = new int[4][4];
        for(int i = 0 ; i < 4 ; i++)
            for(int j = 0 ; j < 4 ; j++)
                way[i][j] = Integer.MAX_VALUE;
        way[0][0] = 0;
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                if(j < 3) {
                    rightPrice = matrix[i][j + 1];
                    way[i][j+1] = Integer.min(way[i][j] + rightPrice , way[i][j+1]);
                }

                if(i < 3) {
                    downPrice = matrix[i + 1][j];
                    way[i+1][j] = Integer.min(way[i][j] + downPrice , way[i+1][j]);
                }
            }
        }


        return way[3][3];
    }
}
