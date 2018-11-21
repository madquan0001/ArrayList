package com.company;

public class MyListTest {
    public static void main(String[] args) {
        // write your code here
        MyList<String> myList = new MyList<>();
        myList.add(0, "Quan");
        myList.add(1, "is");
        myList.add(2, "my");
        myList.add(3, "name");
        myList.add(4, "ok");
        myList.add(5, "?");
        myList.remove(1);
        System.out.println(myList.size());
        if(myList.contains("Quan")){
            System.out.println("best");
        }
        System.out.println(myList.get(4));
        if(myList.add("ok")){
            System.out.println("nothing");
        }else{
            System.out.println("moment");
        }
        System.out.println(myList.indexOf("ga"));
        myList.ensureCapacity(2);
        System.out.println();
    }
}
