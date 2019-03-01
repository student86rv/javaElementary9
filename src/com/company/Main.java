package com.company;

public class Main {

    public static void main(String[] args) {
	
	MyMap map = new MyTreeMap();
	map.put(5, 6);
	map.put(9, 2);
	map.put(3, 11);
	System.out.println(map);
    }
}
