package com.cms.modules.controller;

import com.cms.modules.entity.ResponseResult;
import com.cms.modules.entity.User;
import com.cms.modules.mapper.UserMapper;
import com.cms.util.ResultEnum;
import com.cms.util.ResultGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseResult test(int uid) {
        try {
            User user = new User();
            user.setId(uid);
            return ResultGenerator.genResult(userMapper.query(user).get(0), "成功");
        } catch (Exception e) {
            return ResultGenerator.genErrorResult(ResultEnum.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("login")
    public String login(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("hello", name);
        try {
            Thread.sleep(1000);
//            throw new RuntimeException("advice1 - exception1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "login";
    }
}
