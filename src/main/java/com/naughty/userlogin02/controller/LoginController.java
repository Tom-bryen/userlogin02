package com.naughty.userlogin02.controller;

import com.alibaba.fastjson.JSON;
import com.naughty.userlogin02.bean.User;
import com.naughty.userlogin02.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;

    @CrossOrigin
    @RequestMapping("/login")
    public String userLogin(@RequestBody User user) {
        System.out.println("User : " + user);
        String str = "error";
        int count = userDao.getUserByMassage(user.getUsername(), user.getPassword());
        if (count > 0) {
            str = "ok";
        }
        return str;
    }
    @RequestMapping("/json")
    public String  testJson(){
        /*
        1.如果要接受   这里没有指定请求方式      表单形式 的键值对 和json 键值对形式都可以     获得字段 封装成想要的类型
        2.map 和 project 封装成json 形式一样  到头来都是字段
         */
        HashMap map = new HashMap();
        map.put("name","tom");
        map.put("password",123456);

        User user = new User();
        user.setUsername("Kity");
        user.setPassword("123456");
        List<User> ulist = new ArrayList<User>();
        ulist.add(user);
        String sulist = JSON.toJSONString(ulist);
        System.out.println(sulist);
        String smap = JSON.toJSONString(map);
        System.out.println(smap);
        String s1 = JSON.toJSONString(user);
        System.out.println(s1);
        System.out.println(user);
        return sulist;
    }
}
