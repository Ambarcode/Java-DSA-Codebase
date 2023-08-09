package com.ak.OOPs;

public class Student {
    int marks;
    float price;

    public Student(int marks, float price){
        this.marks=marks;
        this.price=price;
    }


//    @Override

    @Override
    public String toString() {
        return marks+" ";
    }
//    public int compareTo(Student o) {
//        return this.marks-o.marks;
//    }
}
