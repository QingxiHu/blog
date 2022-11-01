package com.xxg.blog.security.common;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @version 1.0
 * @time 2022/10/30 17:44
 * @Author SmallWatermelon
 * @since 1.8
 */
public class CustomPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
