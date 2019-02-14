package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    public List<Product> findALl(int page,int size) throws Exception;

    public void save(Product product);

    Product findById(String id) throws Exception;
}
