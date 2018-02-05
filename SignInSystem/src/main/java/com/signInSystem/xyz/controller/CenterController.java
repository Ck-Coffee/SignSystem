package com.signInSystem.xyz.controller;


import com.signInSystem.xyz.model.UserPassword;
import com.signInSystem.xyz.model.Users;
import com.signInSystem.xyz.service.IPasswordService;
import com.signInSystem.xyz.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CenterController {
    @Resource
    private IUserService userService;

    @Resource
    private IPasswordService passwordService;
    @RequestMapping("/centerTest")
    public Users centroller(@RequestParam("userPhone") String userPhone) {
        Users user=this.userService.selectUser(userPhone);
        return user;
    }

    @RequestMapping("/centerinstall")
    @ResponseBody
    public String install(@RequestParam("userPhone") String userPhone,@RequestParam("userPwd") String userPwd,@RequestParam("userCurPwd") String userCurPwd) {
        Users user=this.userService.selectUser(userPhone);

        if(user==null){
            return "0";
        }
        int id=user.getUser_id();
        //得到数据库中的password
        //用alter改变password表中的数据
        //加盐

        String algorithmName1="MD5";
        Object source1=userPwd;
        Object salt1= ByteSource.Util.bytes("user");
        int hashIterations1=1024;

        Object afterEncryptionPwd1=new SimpleHash(algorithmName1, source1, salt1, hashIterations1);

        String password1=this.passwordService.selectUserPassword(id);


        //如果和原密码表不匹配，，返回？？？

        if(!password1.equals(afterEncryptionPwd1)){
            return "2";
        }

        String algorithmName="MD5";
        Object source=userCurPwd;
        Object salt= ByteSource.Util.bytes("user");
        int hashIterations=1024;




        //加盐之后的密码
        Object afterEncryptionPwd=new SimpleHash(algorithmName, source, salt, hashIterations);
        //传入对象
        UserPassword nowuserPassword=new UserPassword(id,afterEncryptionPwd.toString(),id);

        int i=passwordService.updateUserPassword(nowuserPassword);

        System.out.println("--------------------"+i);

        return "1";
    }
    }
