package com.ak.OOPs;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.function.Consumer;

public class LambdaExpression {
    //now we'll see the working of lambda expression
    public static void main(String[] args) {
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list.add(i+1);
        }

        //lambda Expression
        //list.forEach((item) -> System.out.println(item*2));

        //we can also store that stuff in the consumer part
        Consumer<Integer> consumer=(item) -> System.out.println(item*2);

        //or we can create our own interface
        //we are assigning lambda expression to the stuff that are variables
        Operation sum=(a,b)->a+b;
        Operation diff=(a,b)->a-b;
        Operation multiply=(a,b)->a*b;

        LambdaExpression calculator =new LambdaExpression();
        System.out.println(calculator.calculate(10,2, sum));


    }

    private int calculate(int a , int b, Operation opr){
        return opr.operation(a, b);
    }
}
interface Operation{
    int operation(int a , int b);
}
