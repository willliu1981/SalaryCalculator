package com.test;

import com.model.Apple;
import com.model.Banana;
import com.model.Fruit;
import com.model.Kiwi;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Fruit> fruitList = new ArrayList<Fruit>();
        fruitList.add(new Apple());
        fruitList.add(new Banana());
        fruitList.add(new Kiwi());

        for (Fruit unit : fruitList) {
            if (unit instanceof Apple) {
                Apple apple = (Apple) unit;
                System.out.println("這是蘋果");
                System.out.println(apple.toString());
                System.out.println("");
            } else if (unit instanceof Banana) {
                Banana banana = (Banana) unit;
                System.out.println("這是香蕉");
                System.out.println(banana.toString());
                System.out.println("");
            } else if (unit instanceof Kiwi) {
                Kiwi kiwi = (Kiwi) unit;
                System.out.println("這是奇異果");
                System.out.println(kiwi.toString());
                System.out.println("");
            }

        }
    }
}
