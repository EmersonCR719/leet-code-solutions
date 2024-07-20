package leetcode;

import java.util.Arrays;

public class MainMatrix {

    public static void main(String[] args) {

        Matrix matrix = new Matrix();

        int[][] grid = new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};

        System.out.println(Arrays.deepToString(matrix.largestLocal(grid)));
    }
}
