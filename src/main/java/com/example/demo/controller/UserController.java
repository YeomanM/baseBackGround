package com.example.demo.controller;

import com.example.demo.entity.BaseResponse;
import com.example.demo.utils.ResponseUtil;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/")
    public BaseResponse test(){
        return ResponseUtil.successResponse();
    }

}

