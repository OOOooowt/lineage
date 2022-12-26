package com.example.demo;

import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TODO
 *
 * @author laowang
 * @date 2022/11/8
 * @Version 1.0
 */
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        method6();
//        method5();
//        method4();
//        method3();
//        method2();
//        method1();
    }

    private static void method6() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date authDate = simpleDateFormat.parse("");
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private static void method5() {
        String hahUrl = "jdbc:mysql://10.180.59.223:3716/asset";
        String pattern = "jdbc:(?<type>[a-z]+)://(?<host>[a-zA-Z0-9-//.]+):(?<port>[0-9]+)/(?<database>[a-zA-Z0-9_]+)?";


        String str1 = "jdbc:oracle:thin:@10.180.59.45:1521/datawarehouse";
        String str3 = "jdbc:mysql://10.180.59.223:3716/asset";
        String str4 = "jdbc:mysql://10.180.59.223:3716/";
        String str2 = "jdbc:mysql://10.180.59.223:3716";

        if (str1.startsWith("jdbc:mysql://")) {
            String[] split = str2.replace("jdbc:mysql://", "").split("/");

            System.out.println(split[0]);

        } else {
            System.out.println("qita");
        }

        System.out.println("sdfs".split("/")[0]);


    }

    private static void method4() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date parse = simpleDateFormat.parse("");
            Date parse2 = simpleDateFormat.parse("2022-11-05 00:36:20");
            System.out.println(parse.after(parse2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void method3() {

        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();


        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> sets = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set2.add("4");
        sets.add("1");
        sets.add("2");
        sets.add("3");
        sets.add("4");
        sets.add("5");
        sets.add("6");
        sets.removeAll(set1);
        sets.removeAll(set2);
        System.out.println(sets);
    }

    private static void method2() {

        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();

        paramsMap.set("grant_type", "password");
        paramsMap.set("username", "yourname");
        paramsMap.set("password", "yourpassword");
        System.out.println(paramsMap);
    }

    private static void method1() {
        JSONObject connectorJson = new JSONObject();
        connectorJson.put("catalogName", "name");
        connectorJson.put("connectorName", "connector");
        JSONObject prop = new JSONObject();
        prop.put("connection-user", "urll");
        prop.put("connection-url", "user");
        prop.put("connection-password", "password");
        connectorJson.put("properties", prop);
        String connectorJsonString = connectorJson.toJSONString();
        System.out.println(connectorJsonString);
    }
}
