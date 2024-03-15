package com.example.demo.User.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.User.Mapper.UserMapper;
import com.example.demo.User.config.IfNull;
import com.example.demo.User.config.ResultInfo;
import com.example.demo.User.entity.User;
import com.example.demo.User.service.UserService;
import com.example.demo.User.util.JWTUtils;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-03-04 23:16:00
 */
@RestController
@Slf4j
@RequestMapping("/User")
@CrossOrigin(origins = {"*","null"})
public class UserController{
    /**
     * 服务对象
     */
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JWTUtils jwtutils;
    @Autowired
    ResultInfo resultInfo;
    @Autowired
    Gson gson;
    @GetMapping("/selectAll")

    // 自定义注解
    @IfNull
    public String selectAll(@RequestParam(value = "id",defaultValue = "",required = true) Integer id) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id);
        System.out.println(gson.toJson(userMapper.selectList(queryWrapper)));
        return gson.toJson(userMapper.selectList(queryWrapper));
    }
    @GetMapping("/Page")
        public String selectById(
                @RequestBody
                @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                @RequestParam(value = "pageSize", defaultValue = "5")  Integer pageSize) {

        Page<User> page = userService.UserPage(pageNo, pageSize);
        ResultInfo resultInfo= new ResultInfo();
        resultInfo.Success(page);
        String pageone = gson.toJson(resultInfo);
        System.out.println(gson.toJson(resultInfo));
        return pageone;
    }
    @GetMapping("/JwtToken")
    public String JwtToken() {
        jwtutils.Setjwttoken();
        return jwtutils.Getjwtutils();
    }
    @GetMapping("/selectOne/")
    public ResultInfo selectOne(@RequestParam String name) {
        System.out.println(name);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", name);
        User user= userMapper.selectOne(queryWrapper);
        if(user == null) {
            resultInfo.setResultInfo(400, "用户不存在");
            System.out.println(resultInfo);
        }
        else {
            resultInfo.Success(user);
            System.out.println(resultInfo);
            return resultInfo;
        }
        System.out.println(user);
        resultInfo.Success(user);
        return resultInfo;
    }
    @PostMapping("/insert")
    public String Userinsert(@RequestBody User user) {
        userMapper.insert(user);
        return "插入成功";
    }
    @PostMapping("/update")
    public String userupdate(@RequestBody User user) {
        userMapper.updateById(user);
        return "更新成功";
    }
    @GetMapping("/delete")

    public String Userdelete(@RequestParam(value = "user_id") Integer id) {
        userMapper.deleteById(id);
        return "删除成功";
    }

    @PostMapping("/selectById")
    @CrossOrigin
    public ResultInfo selectById(@RequestParam Integer id) {
        User user = userMapper.selectById(id);
        if(user == null) {
            resultInfo.setResultInfo(400, "用户不存在");
            System.out.println(resultInfo);
        }
        else {
            resultInfo.Success(user);
            System.out.println(resultInfo);
            return resultInfo;
        }
        log.isInfoEnabled();
        gson.toJson(resultInfo);
        return resultInfo;
    }

}

