package com.ak.Arrays.ArrayQuestion;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
     //we are provided with gas stations which are represented by the index of the gas array
     //for each gas array index we have x amount of gas  and also a cost array which depicts the amount of  gas required to go to next station

     int startingPoint=0;
     int surplus=0;
     int deficit=0;
     for (int i=0;i<gas.length;i++){
         surplus+=gas[i]-cost[i];
        if (surplus<0){
            deficit+=surplus;
            startingPoint=i+1;
            surplus=0;
        }

     }

     if (surplus+deficit>0) return startingPoint;

     return -1;
    }
}


