package com.example.demo.controller;

import com.alibaba.fastjson2.JSONObject;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author laowang
 * @date 2022/11/4
 * @Version 1.0
 */
@RestController
public class TestController {

    @Value("${openlookeng.url}")
    private String url;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/get")
    public void getLog() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from test_sqllog;");
        System.out.println(maps);

    }

    @GetMapping("/insert")
    public String testController() {
        catalogService.insertCatalog();
        return "";
    }

    @GetMapping("/update")
    public String update() {
        return "";
    }

    @GetMapping("/deleteAll")
    public String testController2() {
        List<String> list = new ArrayList<>();
        list.add("gp_17");
        list.add("gp_18");
        list.add("gp_19");
        list.add("gp_26");
        list.add("gp_2");
        list.add("gp_5");
        list.add("gp_6");
        list.add("gp_3");
        list.add("gp_1");
        list.add("gp_10");
        list.add("gp_4");
        list.add("gp_7");
        list.add("gp_9");
        list.add("gp_14");
        list.add("gp_11");
        list.add("gp_12");
        list.add("gp_13");
        list.add("gp_15");
        list.add("gp_16");
        list.add("gp_20");
        list.add("gp_21");
        list.add("gp_22");
        list.add("gp_23");
        list.add("gp_24");
        list.add("gp_25");
        list.add("gp_8");
        for (String catalog : list) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Presto-User", "admin");
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            ResponseEntity<String> exchange = restTemplate.exchange(url + catalog, HttpMethod.DELETE, entity, String.class);
            System.out.println(exchange);
        }

        return "";
    }
    @GetMapping("/deleteAll2")
    public String testController23() {
        List<String> list = new ArrayList<>();
        list.add("own_mysql_2");
        list.add("own_mysql_3");
        list.add("own_oracle_7");
        list.add("own_oracle_4");
        list.add("own_mysql_1");
        list.add("own_oracle_6");
        list.add("own_oracle_5");
        list.add("own_mysql_8");
        list.add("own_mysql_9");
        list.add("own_greenplum_10");
        for (String catalog : list) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-Presto-User", "admin");
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            ResponseEntity<String> exchange = restTemplate.exchange(url + catalog, HttpMethod.DELETE, entity, String.class);
            System.out.println(exchange);
        }

        return "";
    }

    @GetMapping("/all")
    public String getAll_v1() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Presto-User", "admin");
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url + "/v1/catalog", HttpMethod.GET, entity
                , new ParameterizedTypeReference<List<Object>>() {
                });
        List<Object> list = exchange.getBody();

        return list.toString();
    }

    @GetMapping("/all2")
    public String getAll_v13() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Presto-User", "admin");
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url + "/v1/catalog", HttpMethod.GET, entity
                , new ParameterizedTypeReference<List<Object>>() {
                });
        List<Object> body = exchange.getBody();
        System.out.println(body.get(0));
        return "result";
    }

    @PostMapping
    public String updateConnector() {
        return "";
    }

}