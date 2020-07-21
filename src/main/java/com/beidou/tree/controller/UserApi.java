package com.beidou.tree.controller;

import cn.hutool.json.JSONObject;
import com.beidou.tree.configuration.UserLoginToken;
import com.beidou.tree.entity.User;
import com.beidou.tree.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Perkin
 * @version 1.0
 * @date 2020/7/17 0017 17:14
 */
@RestController
@RequestMapping("api")
public class UserApi {
    @Autowired
    UserService userService;

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.selectByName(user.getName());
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = userService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
