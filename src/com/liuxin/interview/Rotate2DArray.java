package com.liuxin.interview;

/**
 * Created by Xin on 11/6/2014.
 */
public class Rotate2DArray {

    public static void rotate(int[][] input) {
        for(int i = 0; i < input.length / 2; i++) {
            int x = i, y = i, length = input.length - 2 * i;
            for(int j = 0; j < input.length - 2 * i - 1; j++) {
                int t = input[x+j][y + length - 1];
                input[x + j][y + length -1] = input[x][y + j];

                int temp = input[x + length -1][y + length -1 -j];
                input[x + length - 1][y + length -j - 1] = t;
                t = temp;

                temp = input [x + length -1 -j][y];
                input[x + length -1 - j][y] = t;
                t = temp;

                input[x][y + j] = t;
            };
        }
        print(input);
    }

    public static void rotateExterior(int[][] input, int level) {
        int x = level, y = level, length = input.length - 2 * level;
        for(int i = 0; i < input.length - 2 * length; i++) {
            int t = input[x+i][y + length - 1];
            input[x + i][y + length -1] = input[x][y + i];

            int temp = input[x + length -1][y + length -1 -i];
            input[x + length - 1][y + length -i - 1] = t;
            t = temp;

            temp = input [x + length -1 -i][y];
            input[x + length -1 - i][y] = t;
            t = temp;

            input[x][y + i] = t;
        }
    }

    public static void print(int[][] input) {
        for(int i = 0; i < input.length; i++) {
            for(int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15 ,16}};
        print(input);
        rotate(input);
    }
}
