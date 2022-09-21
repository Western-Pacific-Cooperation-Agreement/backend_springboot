package com.wpca.config;

import com.wpca.security.*;

import com.wpca.security.Handler.JwtAccessDeniedHandler;
import com.wpca.security.Handler.JwtLogoutSuccessHandler;
import com.wpca.security.Handler.LoginFailureHandler;
import com.wpca.security.Handler.LoginSuccessHandler;
import com.wpca.security.filter.CaptchaFilter;
import com.wpca.security.filter.JwtAuthentiactionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author XieQijiang
 * @Pcakage com.markhub.config.SecurityConfig
 * @Date 2022年07月15日 09:09
 * @Description
 */

@Configuration
@EnableWebSecurity
public class  SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginFailureHandler loginFailureHandler;

    @Autowired
    LoginSuccessHandler loginSuccessHandler;

    @Autowired
    CaptchaFilter captchaFilter;

    @Autowired
    JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Autowired
    JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    JwtLogoutSuccessHandler jwtLogoutSuccessHandler;

    @Bean
    JwtAuthentiactionFilter jwtAuthenticationFilter() throws Exception {

        JwtAuthentiactionFilter jwtAuthenticationFilter = new JwtAuthentiactionFilter(authenticationManager());

        return jwtAuthenticationFilter;
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private static final String[] URL_WHITELIST = {

            "/login",
            "/logout",
            "/captcha",
            "/favicon.ico",
            "/person/post/*",

            "/test/*",
            "/test",
            "/pdf/*",
            "/pdf/pdfTemplate.pdf",
            "/pdfTemplate.pdf",
            "/pdf/result/*",
            "/product/*/*/*/*/*",
            "/product/*/*/*/*",
            "/product/*/*/*",
            "/product/*/*",
            "/product/*",
            "/product"

    };


    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()

                // 登录配置
                .formLogin()
                .successHandler(loginSuccessHandler)
                .failureHandler(loginFailureHandler)

                .and()
                .logout()
                .logoutSuccessHandler(jwtLogoutSuccessHandler)

                // 禁用session
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                // 配置拦截规则
                .and()
                .authorizeRequests()
                .antMatchers(URL_WHITELIST).permitAll()
                .anyRequest().authenticated()

                // 异常处理器
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                // 配置自定义的过滤器
                .and()
                .addFilter(jwtAuthenticationFilter())
                .addFilterBefore(captchaFilter, UsernamePasswordAuthenticationFilter.class)

        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }



}

