package com.wpca.controller;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.map.MapUtil;
import com.google.code.kaptcha.Producer;
import com.wpca.common.lang.Const;
import com.wpca.common.lang.Result;
import com.wpca.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.Principal;

/**
 * @author XieQijiang
 * @Pcakage com.wpca.controller.AutoController
 * @Date 2022年09月07日 08:50
 * @Description
 */
@Slf4j
@RestController
public class AutoController extends BaseController {
    @Autowired
    Producer producer;

    @GetMapping("/captcha")
    public Result captcha() throws IOException {

        String redisKey = UUID.randomUUID().toString();
        String code=producer.createText();

        redisKey="aaaaa";
        code="111111";

        //log
        log.info("生成了redisKey："+redisKey);
        log.info("验证码为："+code);


        BufferedImage image=producer.createImage(code);//生成图片

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ImageIO.write(image,"jpg",outputStream);  //将图片写入流中 这样就能生成验证码哦啦

        Base64Encoder encoder=new Base64Encoder(); // base64生成器

        String str= "data:image/jpeg;base64,";  //base64验证码的前缀

        String base64Img =str+encoder.encode(outputStream.toByteArray());

        redisUtil.hset(Const.captcha_KEY,redisKey,code,120);//将输入存入redis中


        return Result.succ(
                MapUtil.builder().put("redisKey",redisKey)
                        .put("captchaImg",base64Img)
                        .build()
        );
    }



    /*
    * 返回用户的个人信息
    * */
    @GetMapping("/sys/userInfo")
    public  Result userInfo(Principal principal){
        SysUser sysUser= sysUserService.getByUsername(principal.getName());
        return Result.succ(MapUtil.builder()
                .put("id",sysUser.getId())
                    .put("username",sysUser.getUsername())
                .put("avater",sysUser.getAvatar())
                .put("created",sysUser.getCreateTime())
                .put("update",sysUser.getUpdateTime())
                .map()
        );


    }


}
