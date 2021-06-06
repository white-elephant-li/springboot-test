package com.ligang.whiteelephant.controller.user;

import com.ligang.whiteelephant.dao.user.UserRepository;
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

@Api(tags = "用户名增删改查模块")
@RestController
@RequestMapping("/user")
@CrossOrigin
@ResponseBody
public class UserController {
    private UserRepository userRepository;
    private HttpSession session;

    public UserController(UserRepository userRepository, HttpSession session) {
        this.userRepository = userRepository;
        this.session = session;
    }


    @ApiOperation(value = "用户名登录", notes = "实现登录用户名")
    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> loginUser(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        if (!StringUtils.isEmpty(userRepository.selectUserWithPassword(user.getUsername(),user.getPassword()))){
            user.setId(userRepository.selectUserByNameToId(user.getUsername()));
            user.setSessionId(session.getId());
            user.setLoginTime(LocalDateTime.now()+"");
            System.out.println("user:"+user.toString());
            userRepository.updateUserByName(user.getLoginTime(),user.getSessionId(),user.getId());
            result.put("data",user);
        }else {
            result.put("data",1);
        }
        return result;
    }

    @ApiOperation(value = "获得所有的用户", notes = "获取用户名列表")
    @RequestMapping("/alluser")
    @ResponseBody
    public List<User> getAllUser(){
        return userRepository.selectAllUser();
    }

    @ApiOperation(value = "注册用户", notes = "实现用户注册")
    @RequestMapping("/register")
    @ResponseBody
    public Map<String,Object> registerUser(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        if (StringUtils.isEmpty(userRepository.selectUserByName(user.getUsername()))){
            userRepository.save(user);
            System.out.println("注册成功");
            result.put("data",0);
        }else {
            System.out.println("用户名重复，请再次尝试");
            result.put("data",1);
        }
        return result;
    }

    @ApiOperation(value = "展示所有用户", notes = "实现用户展示")
    @RequestMapping("/userlist")
    @ResponseBody
    public List<Object> selectWithoutPassword(){
        return userRepository.selectUserWithoutPass();
    }

    @ApiOperation(value = "修改用户", notes = "实现用户属性修改")
    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> updatePassword(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        userRepository.updatePassById(user.getPassword(),user.getId());
        result.put("data",0);
        return result;
    }

    @ApiOperation(value = "删除用户", notes = "实现用户删除")
    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,Object> deletePassword(@RequestBody User user){
        Map<String,Object> result = new HashMap<>();
        if (!StringUtils.isEmpty(userRepository.selectUserById(user.getId()))){
            System.out.println(user);
            userRepository.deleteUserById(user.getId());
            result.put("data",0);
        }else {
            result.put("data",1);
        }
        return result;
    }



}
