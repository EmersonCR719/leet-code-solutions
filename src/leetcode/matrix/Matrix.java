package leetcode.matrix;

public class Matrix {

    public int[][] largestLocal(int[][] grid) {

        int[][] maxLocal = new int[grid.length - 2][grid[0].length - 2];

        for (int i = 0; i < grid.length-2; i++) {
            for (int j = 0; j < grid[0].length-2; j++) {
                maxLocal[i][j] = highestNumber(grid,i,j);
            }
        }
        return maxLocal;
    }

    public int highestNumber(int[][] matrix, int x, int y) {
        int highest = Integer.MIN_VALUE;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                highest = Math.max(highest, matrix[i][j]);
            }
        }
        return highest;
    }
}
