package com.travel.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.travel.item.mapper")
public class ItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemApplication.class);
        System.out.println("hello world");
        System.out.println("是啊");
        int a = 2;
        int b = 3;
        int d = 5;
    }
}
