package com.ak.OOPs;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    //Creating two Students
    public static void main(String[] args) {
        Student ambar=new Student(100, 99.7f);
        Student abhishek =new Student(200, 99.88889f);
       // System.out.println(ambar.compareTo(abhishek));

        Student[] list=new Student[10];
        for (int i = 0; i <10 ; i++) {
            list[i]=new Student(80+i,89.5f+i);
        }

        Arrays.sort(list, new Comparator<Student>() {  //These are functional interfaces stuff
            @Override
            public int compare(Student o1, Student o2) {
                return -(o1.marks-o2.marks);  //for ascending order stuff(for descending order apply -)
            }
        });

        System.out.println(Arrays.toString(list));
    }

}
