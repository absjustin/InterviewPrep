package com.liuxin.interview.arrays;

/**
 * Created by Xin on 11/10/2014.
 * Given an input int n, return the first n row of the Pascal's triangle
 */
public class PascalTriangle {

    public int[][] constructPascalTriangle(int n ) {
        int[][] triangle = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(j == 0 || j == i - 1) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
                }
            }
        }
        return triangle;
    }



    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        int[][] triangle = pt.constructPascalTriangle(9);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
