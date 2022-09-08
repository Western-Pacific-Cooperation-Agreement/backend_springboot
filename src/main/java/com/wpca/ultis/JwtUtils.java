package com.wpca.ultis;

import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author WPCA-XieQijiang
 * @Pcakage com.wpca.ultis.JwtUtils
 * @Date 2022年07月16日 09:42
 * @Description
 */
@Data
@Component
@ConfigurationProperties(prefix = "wpca.jwt")
public class JwtUtils {

    private long expire;
    private String secret;
    private String header;


    //生成jwt
    public String generateToken(String username){
        //当前时间
        Date nowDate = new Date();
        //过期的时间
        Date expireDate =new Date(nowDate.getTime()+1000*expire);

        return  Jwts.builder()
                .setHeaderParam("typ","JWT")
                .setSubject(username)
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)//7天过期
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }

    //解析jwt
   public Claims getClaimByToken(String jwt){

       try {
           return Jwts.parser()
                   .setSigningKey(secret)
                   .parseClaimsJws(jwt)
                   .getBody();
       } catch (Exception e) {

        //不合法
           return null;
       }
   }


    //jwt是否过期
   public boolean isTokenExpired(Claims claims){
        return claims.getExpiration().before(new Date());
   }


}
