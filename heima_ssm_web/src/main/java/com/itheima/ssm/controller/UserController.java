package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IRoleService;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UserInfo> list = userService.findAll();
        mv.addObject("userList",list);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.setViewName("user-show");
        mv.addObject("user",userInfo);
        return mv;
    }

    /**
     * 用于查找要操作的用户及可以添加的角色，参数是要操作的用户id
     * @return
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo user = userService.findById(id);
        List<Role> roleList = iRoleService.findOtherRole(id);
        mv.addObject("user", user);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(String userId, String[] ids) throws Exception {
        userService.addRoleToUser(userId,ids);
        return "redirect:findAll.do";
    }
}
