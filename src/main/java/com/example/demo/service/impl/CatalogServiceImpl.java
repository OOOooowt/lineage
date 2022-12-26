package com.example.demo.service.impl;


import com.alibaba.fastjson2.JSONObject;
import com.example.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author laowang
 * @date 2022/11/8
 * @Version 1.0
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openlookeng.url}")
    private String url;

    @Override
    public String insertCatalog() {
        HttpHeaders headers = getHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("catalogInformation", customJson());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }

    @Override
    public String updateCatalog() {
        HttpHeaders headers = getHeaders();
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("catalogInformation", customJson());
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return response.getBody();
    }

    @Override
    public void deleteCatalog(String catalog) {
        HttpHeaders headers = getHeaders();
        HttpEntity<Object> entity = new HttpEntity<>(headers);
        ResponseEntity<String> exchange = restTemplate.exchange(url +catalog, HttpMethod.DELETE, entity, String.class);
        System.out.println(exchange);
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Presto-User", "admin");
        return headers;
    }

    /**
     * 自定义form-data
     *
     * @return
     */
    private String customJson() {
        JSONObject connectorJson = new JSONObject();
        connectorJson.put("catalogName", "oracle03");
        connectorJson.put("connectorName", "oracle");
        JSONObject prop = new JSONObject();
        prop.put("connection-user", "BASED");
        prop.put("connection-url", "jdbc:oracle:thin:@10.180.54.5:1521/ywdsjdb");
        prop.put("connection-password", "BASEDTOWERBI");
        connectorJson.put("properties", prop);
        return connectorJson.toJSONString();
    }
}