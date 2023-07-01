package com.ak.Arrays.ArrayQuestion;

public class PunishmentNumber {
    public int punishmentNumber(int n){
        int sum=0;
        for (int i = 1; i <=n ; i++) {
            int squaredValue=i*i;
            if(isPunishment(squaredValue,i)){
                sum+=squaredValue;
            }
        }
        return sum;
    }

    private boolean isPunishment(int squaredValue , int i) {

        if(i<0 || squaredValue<i) return false;
        if (squaredValue==i) return true;


        return isPunishment(squaredValue/10 , i-squaredValue%10)||isPunishment(squaredValue/100 , i-squaredValue%100)||isPunishment(squaredValue/1000 , i-squaredValue%1000);

    }
}
