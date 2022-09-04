package com.wpca.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @title: MyBatisPlusConfig
 * @Author Huang Jinpo
 * @Date: 2022/9/4 16:23
 * @Version 1.0
 */

@Configuration
@MapperScan("com.wpca.mapper")
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        //iterceptor
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        // 防止全表更新和删除 eg 如果条件where条件不满足的话 可能会造成全表的一个更新，这里采用的是
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }


    //避免分页插件存在问题
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {

        //return null;
        return configuration -> configuration.setUseDeprecatedExecutor(false);


    }
}
