package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService iPermissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Permission> list = iPermissionService.findAll();
        mv.addObject("permissionList",list);
        mv.setViewName("permission-list");
        return mv;
    }


    @RequestMapping("/save.do")
    public String save(Permission permission){
        iPermissionService.save(permission);
        return "redirect:findAll.do";
    }
}
