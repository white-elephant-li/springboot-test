package com.ligang.whiteelephant.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
@ResponseBody
@Api(tags = "连接两个域名")
public class ToVueController {

    @ApiOperation(value = "跳转管理员登录")
    @RequestMapping("/left")
    public void Toleft(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://47.94.251.75/");
    }

    @ApiOperation(value = "跳转用户首页")
    @RequestMapping("/right")
    public void ToRight(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://ligang666.vipgz1.idcfengye.com/");
    }

}
