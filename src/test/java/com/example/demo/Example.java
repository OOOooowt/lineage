package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author laowang
 * @date 2022/11/11
 * @Version 1.0
 */

public class Example {
    @Test
    public void testSet() {
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set1.add("5");
        Set<String> set2 = new HashSet<>();
        set2.add("2");
        set2.add("3");
        set2.add("6");
        set1.removeAll(set2);
        System.out.println(set1);
    }

    @Test
    public void testCase() {
        String s1 = "Hello";
        String s2 = "hello";
        System.out.println(s1.equalsIgnoreCase(s2));
    }
}
