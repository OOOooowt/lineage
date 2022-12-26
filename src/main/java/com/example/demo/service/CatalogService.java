package com.example.demo.service;

/**
 * TODO
 *
 * @author laowang
 * @date 2022/11/8
 * @Version 1.0
 */
public interface CatalogService {
    /**
     * 新增目录
     * @return
     */
    String insertCatalog();
/**
     * 更新目录
     * @return
     */
    String updateCatalog();


    void deleteCatalog(String catalog);

}
