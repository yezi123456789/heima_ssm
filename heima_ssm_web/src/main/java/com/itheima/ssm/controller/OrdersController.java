package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService iOrdersService;

//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll(){
//        ModelAndView mv = new ModelAndView();
//        List<Orders> orders = iOrdersService.findAll();
//        mv.addObject("ordersList",orders);
//        mv.setViewName("orders-list");
//        return mv;
//    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1")int page,@RequestParam(name="size", required = true, defaultValue = "4") int size){
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = iOrdersService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-pages-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name="id",required = true) String id){
        ModelAndView mv = new ModelAndView();
        Orders orders = iOrdersService.findById(id);
        mv.setViewName("orders-show");
        mv.addObject("orders",orders);
        return mv;
    }
}
