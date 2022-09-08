package com.wpca.common.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author XieQijiang
 * @Pcakage com.markhub.common.exception.CaptchaException
 * @Date 2022年07月15日 16:46
 * @Description
 */
public class CaptchaException extends AuthenticationException {


    public CaptchaException(String msg) {
        super(msg);
    }
}
