package com.ak.OOPs;

import java.util.Arrays;
import java.util.List;

//here I am creating my own arraylist
//I'll be creating arraylist of generic type
//here T should be number or its subclasses
public class CustomArrayList<T extends Number>{
    private Object[] data;
    private int size;

    public CustomArrayList(){
        int INITIAL_CAPACITY = 10;
        data=new Object[INITIAL_CAPACITY];
    }

    //.add method
    public void add(T num){
        if (isFull()){
            resize();
        }
        data[size++]=num;

    }

//    public void getList(List<Number> list){
//        //now you can pass only number type
//        //to change this , we can do something like
//        List<? extends Number>
//    }

    private void resize() {
        Object[] currTemp=new Object[2* data.length];
        System.arraycopy(data, 0, currTemp, 0, data.length);
        data=currTemp;
    }

    private boolean isFull() {
        return size== data.length;
    }

    //.remove method
    public T remove(){
        T elem=(T)data[--size];
        return elem;
    }

    //.get method
    public T get(int index){
        return (T)data[index];
    }

    //size
    public int getSize(){
        return size;
    }

    //set method
    public void set(int index, T value){
        data[index]=value;

    }

    @Override
    public String toString(){
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        CustomArrayList<Number> list=new CustomArrayList<>();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.add(40);
//        list.add(50);
//        list.add(60);
//
//        System.out.println(list);

        for (int i = 0; i <30 ; i++) {
            list.add(i);
        }

        //we can also restrict the datatype
        System.out.println(list);
    }

}
