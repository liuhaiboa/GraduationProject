package com.homework.controller;

import com.homework.service.CategoryService;
import com.homework.service.PostService;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IDEA.
 * User:haibo.
 * DATE:2019/3/22/022
 */
public class BaseController {
    @Autowired
    HttpServletRequest req;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;


}