package com.ligang.whiteelephant.controller.user;

import com.ligang.whiteelephant.dao.user.AdminRepository;
import com.ligang.whiteelephant.entity.user.Administrator;
import com.ligang.whiteelephant.entity.user.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "管理员增删改查模块")
@RestController
@RequestMapping("/admin")
@CrossOrigin
@ResponseBody
public class AdminController {


    private AdminRepository adminRepository;
    private HttpSession httpSession;

    public AdminController(AdminRepository adminRepository, HttpSession httpSession) {
        this.adminRepository = adminRepository;
        this.httpSession = httpSession;
    }

    @ApiOperation(value = "管理员注册", notes = "实现注册管理员")
    @RequestMapping(value = "/register")
    @ResponseBody
    public Map<String,Object> registerAdmin(@RequestBody Administrator admin){
        Map<String,Object> result = new HashMap<>();
        if (StringUtils.isEmpty(adminRepository.selectAdminByName(admin.getUsername()))){
            adminRepository.save(admin);
            System.out.println("注册成功");
            result.put("data",0);
        }else {
            result.put("data",1);
        }
        return result;
    }

    @ApiOperation(value = "管理员登录", notes = "实现管理员登录")
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> loginUser(@RequestBody Administrator admin){
        Map<String,Object> result = new HashMap<>();
        if (!StringUtils.isEmpty(adminRepository.selectAdminWithPassword(admin.getUsername(),admin.getPassword()))){
            admin.setId(adminRepository.selectAdminByNameToId(admin.getUsername()));
            admin.setSessionId(httpSession.getId());
            admin.setLoginTime(LocalDateTime.now()+"");
            adminRepository.updateAdminById(admin.getLoginTime(),admin.getSessionId(),admin.getId());
            System.out.println("user:"+admin.toString());
            result.put("data",admin);
        }else {
            result.put("data",1);
        }
        return result;
    }

    @ApiOperation(value = "管理员修改", notes = "实现管理员修改")
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> updateUser(@RequestBody Administrator admin){
        Map<String,Object> result = new HashMap<>();
        if (StringUtils.isEmpty(adminRepository.selectAdminByName(admin.getUsername()))){
            adminRepository.updateAdminByIdWithUP(admin.getUsername(),admin.getPassword(),admin.getId());
            result.put("data",0);
        }else {
            result.put("data",1);
        }
        return result;
    }

    @ApiOperation(value = "管理员删除", notes = "实现管理员修改")
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,Object> deleteUser(@RequestBody Administrator admin){
        Map<String,Object> result = new HashMap<>();
        if (!StringUtils.isEmpty(adminRepository.selectAdminById(admin.getId()))){
            System.out.println(admin);
            adminRepository.deleteAdminById(admin.getId());
            result.put("data",0);
        }else {
            result.put("data",1);
        }
        return result;
    }

    @ApiOperation(value = "获取所有管理员",notes = "实现管理员列表")
    @RequestMapping("/alladmin")
    @ResponseBody
    public List<Administrator> getAllUser(){
        return adminRepository.selectAllAdmin();
    }
}
