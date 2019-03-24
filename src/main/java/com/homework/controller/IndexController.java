package com.homework.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.code.kaptcha.Producer;
import com.homework.entity.Post;
import com.homework.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * Created with IDEA.
 * User:haibo.
 * DATE:2019/3/22/022
 */
@Slf4j
@Controller
public class IndexController extends BaseController {
    //
    // private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";
    //验证码的生成器
    @Autowired
    private Producer producer;


    @GetMapping("/capthca.jpg")
    public void captcha(HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store,no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //把验证码存到shrio的session中
        SecurityUtils.getSubject().getSession().setAttribute(KAPTCHA_SESSION_KEY, text);

        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);


    }


    @GetMapping("/")
    public String index() throws Exception {
        Page<Post> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);
        IPage<Map<String, Object>> pageData = postService.pageMaps(page, null);
        userService.join(pageData, "user_id");
        req.setAttribute("pageData", pageData);
        log.info("----" + pageData.getRecords());
        log.info("-----" + page.getPages());
        return "index";


    }
}