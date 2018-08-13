package com.example.demo.controller;


import com.example.demo.aspact.InfoAnnotation;
import com.example.demo.entity.BaseResponse;
import com.example.demo.service.RightService;
import com.example.demo.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Yeoman123
 * @since 2018-06-30
 */
@RestController
@RequestMapping("/right")
public class RightController {

    @Autowired
    private RightService rightService;

    @GetMapping
    public BaseResponse get(@InfoAnnotation Integer userId){
        return rightService.getRightTree(userId);
    }

}

