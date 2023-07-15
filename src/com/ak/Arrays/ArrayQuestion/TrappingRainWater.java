package com.ak.Arrays.ArrayQuestion;

public class TrappingRainWater {
    private static int maximumRainWater(int[] pillars){
        //Intuition: For current pillar , find the pillar on right and pillar on left which is equal ore greater and then subtract them and subtract the height of current pillar , you'll get the amount of water we can easily store in the region
        //formula : min(tallestLest-tallestRight-xPillar)
        //we need to find the LeftTallest Pillar(Prefix Max)
        //we also need to find the rightTallestPillar(Suffix Max)
        //deciding pillar(dp)=min(LP,RP)
        //AmountOfWater=DP-CP
        if (pillars.length==0) return 0;

        //left pillar max(Prefix Sum)
        int[] leftPillarMax=new int[pillars.length];
        leftPillarMax[0]=pillars[0];
        for (int i = 1; i <pillars.length ; i++) {
            leftPillarMax[i]=Math.max(leftPillarMax[i-1],pillars[i]);
        }

        //Right Pillar Max(Suffix Sum)
        int[] rightPillarMax=new int[pillars.length];
        rightPillarMax[rightPillarMax.length-1]=pillars[pillars.length-1];
        for (int i = pillars.length-2; i >=0 ; i--) {
            rightPillarMax[i]=Math.max(rightPillarMax[i+1],pillars[i]);
        }
         int totalWater=0;
        for (int i = 0; i <pillars.length ; i++) {
            int currPillar=pillars[i];
            int min=Math.min(leftPillarMax[i],rightPillarMax[i]);
            if (min>currPillar){
                totalWater+=min-currPillar;
            }
        }
        return totalWater;

    }

    public static void main(String[] args) {
        int[] pillars={0,1,0,3,4,5,2,6,7,8,5};
        System.out.println(maximumRainWater(pillars));
    }
}
