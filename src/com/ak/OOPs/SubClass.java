package com.ak.OOPs;

public class SubClass {
    int weight;
//    public SubClass(int l, int w, int h, int weight) {
//        super(l, w, h);
//        this.weight=weight;
//    }

    public static void main(String[] args) {
        //protected also works for different package for subclass(i.e. the class inheriting it)
      //  A obj=new SubClass(10,5,6,70);
        A obj=new A(10,3,4);
    }

    @Override
    public boolean equals(Object obj) {
        //check if the objects are same
        if (this==obj) return true;

        if (obj==null || getClass()!=obj.getClass())
            return false;

        SubClass newObj=(SubClass) obj;

        return weight==newObj.weight;
    }
}
