package com.travel.item.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("123","1234534","3435","3459342","56460");
        List<String> list2 = new ArrayList<>();
        list1.stream().forEach(s ->{
            if(s.length() > 5){
                return;
            }
            list2.add(s);
        });
        System.out.println(list2 );
    }
}
