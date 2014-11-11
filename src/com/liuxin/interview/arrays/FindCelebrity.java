package com.liuxin.interview.arrays;

public class FindCelebrity {

    public void findCelebrity(boolean[][] relations) {
        boolean index0Celebrity = true;
        for(int i = 0; i < relations.length; i ++) {
            for(int j = 0; j < relations[0].length; j ++) {
                if(i == 0) {
                    if(i != j && relations[i][j]) {
                        index0Celebrity = false;
                    }
                    relations[i][j] = true;
                } else if(j == 0) {
                    if(i != j && ! relations[i][j]) {
                        index0Celebrity = false;
                    }
                    relations[i][j] = false;
                } else if(i != j && relations[i][j]) {
                    relations[i][0] |= true;
                    relations[0][j] &= true;
                }
            }
        }
        if(index0Celebrity) {
            System.out.println("Person 0 is a celebrity!");
        }
        for(int i = 0; i < relations.length; i ++) {
            if(relations[0][i] && ! relations[i][0]) {
                System.out.println("Person: " + i + " is a celebrity!");
            }
        }
    }
    
    public static void main(String[] args) {
        boolean[][] relations = {{true, true, true, false},{false, true, true, false}, {false, false, true, false}, {true, false, true, true}};
        FindCelebrity fc = new FindCelebrity();
        fc.findCelebrity(relations);
    }
}
