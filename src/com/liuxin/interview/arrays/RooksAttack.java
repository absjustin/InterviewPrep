package com.liuxin.interview.arrays;

import java.util.Arrays;

/**
 * @author Xin
 * EPI 6.23
 *
 */
public class RooksAttack {
    public void rooksAttack(int[][] board) {
        boolean wipeFirstRow = false;
        boolean wipeFirstColumn = false;
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j ++) {
                if(board[i][j] == 0 ) {
                    if(i == 0) {
                        wipeFirstRow = true;
                    } else if(j == 0) {
                        wipeFirstColumn = true;
                    } else {
                        board[0][j] = 0;
                        board[i][0] = 0;
                    }
                }
            }
        }
        for(int i = 1; i < board.length; i ++) {
            if(board[i][0] == 0) {
                for(int j = 1; j < board[0].length; j++) {
                    board[i][j] = 0;
                }
            }
        }
        for(int j = 1; j < board[0].length; j ++) {
            if(board[0][j] == 0) {
                for(int i = 1; i < board.length; i++) {
                    board[i][j] = 0;
                }
            }
        }
        if(wipeFirstColumn) {
            for(int i = 0; i < board.length; i ++) {
                board[i][0] = 0;
            }
        }
        if(wipeFirstRow) {
            for(int j = 0; j < board[0].length; j ++) {
                board[0][j] = 0;
            }
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        for(int i = 0; i < 8; i++)
            Arrays.fill(board[i], 1);
        board[0][1] = 0;
        board[3][5] = 0;
        board[4][3] = 0;
        board[6][0] = 0;
        board[6][5] = 0;
        RooksAttack ra = new RooksAttack();
        ra.rooksAttack(board);
    }
}
