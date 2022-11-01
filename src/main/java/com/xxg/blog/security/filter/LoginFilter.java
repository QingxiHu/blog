package com.xxg.blog.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @version 1.0
 * @time 2022/10/29 20:24
 * @Author SmallWatermelon
 * @since 1.8
 */


@Data
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    public static final String FORM_KAPTCHA_NAME = "kaptcha";

    private String kaptchaParameter = FORM_KAPTCHA_NAME;

    /**
     * 自定义 spring security 中的 Filter
     *
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        System.out.println("自定义LoginFilter已启动!");

        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        try {
            //1.获取请求验证码
            Map<String, String> userInfo = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            String username = userInfo.get(getUsernameParameter());
            String password = userInfo.get(getPasswordParameter());
            String kaptcha = userInfo.get(getKaptchaParameter());

            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("kaptcha = " + kaptcha);


            //2.获取session中的验证码
            String verifyCode = (String) request.getSession().getAttribute("kaptcha");
            System.out.println("verifyCode = " + verifyCode);

            if (!ObjectUtils.isEmpty(kaptcha) && !ObjectUtils.isEmpty(verifyCode) && kaptcha.equalsIgnoreCase(verifyCode)) {
                //3.获取用户名和密码进行认证
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }catch (AuthenticationException e) {
            e.printStackTrace();
        }
        throw new AuthenticationServiceException("验证码错误!");
    }
}
