package com.xxg.blog.controller;

import com.google.code.kaptcha.Producer;
import com.xxg.blog.utils.R;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @version 1.0
 * @time 2022/10/31 21:29
 * @Author SmallWatermelon
 * @since 1.8
 */

@RestController
@RequestMapping("/api")
public class VerifyCodeController {

    private final Producer producer;

    @Autowired
    public VerifyCodeController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping("/vc.jpg")
    public R getVerifyCode(HttpSession session) throws IOException {
        R r = new R();

        //1.生成验证码
        String text = producer.createText();
        //2.放入session 或者redis
        session.setAttribute("kaptcha", text);
        //3.生成图片
        BufferedImage image = producer.createImage(text);
        //4. 图片转换为内存中的数组
        FastByteArrayOutputStream stream = new FastByteArrayOutputStream();
        ImageIO.write(image, "jpg", stream);
        //5.转换为base64
        String s = Base64.encodeBase64String(stream.toByteArray());

        return r.put("data", s);
    }
}
