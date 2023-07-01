package com.ak.Recursion;

import java.util.ArrayList;

public class DiceRoll {
    static void diceGame(String up, int target){
        if(target==0){
            System.out.println(up);
        }

        for (int i = 1; i <=6 && i<=target ; i++) {
           diceGame(up+i,target-i);
        }
    }

        static ArrayList<String> diceGame2(String up, int target) {
            ArrayList<String> results = new ArrayList<>();
            if (target == 0) {
                results.add(up);
            }
            for (int i = 1; i <= 6 && i <= target; i++) {
                ArrayList<String> subResults = diceGame2(up + i, target - i);
                results.addAll(subResults);
            }

            return results;
        }

    public static void main(String[] args) {
        ArrayList<String> ans=diceGame2("",3);
        System.out.println(ans);
    }
}
