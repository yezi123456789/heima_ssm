package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * 查询所有订单信息
     * @return
     */
    //public List<Orders> findAll();

    public List<Orders> findAll(int page,int size);

    Orders findById(String id);
}
