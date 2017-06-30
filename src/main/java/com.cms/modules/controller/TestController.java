package com.cms.modules.controller;

import com.alibaba.fastjson.JSONObject;
import com.cms.modules.entity.User;
import com.cms.modules.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by taifuyu on 17/6/30.
 */
@Controller
@Slf4j
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping("test")
    public String test() {
        User user = new User();
        user.setName("admin");
        log.info(JSONObject.toJSONString(userMapper.query(user)));
        log.info("test ok....");
        return "ok";
    }
}
