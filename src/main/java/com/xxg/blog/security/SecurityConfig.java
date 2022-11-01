package com.xxg.blog.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxg.blog.security.common.CustomPasswordEncoder;
import com.xxg.blog.security.filter.LoginFilter;
import com.xxg.blog.service.impl.MyUserDetailServiceImpl;
import com.xxg.blog.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

/**
 * @version 1.0
 * @time 2022/10/29 19:53
 * @Author SmallWatermelon
 * @since 1.8
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailServiceImpl myUserDetailServiceImpl;

    /**
     * 构造器注入 防止循环依赖
     * @param myUserDetailServiceImpl
     */
    @Autowired
    public SecurityConfig(MyUserDetailServiceImpl myUserDetailServiceImpl) {
        this.myUserDetailServiceImpl = myUserDetailServiceImpl;
    }

    /**
     * spring security主要配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //放行的接口
                .antMatchers("/api/vc.jpg").permitAll()
                .antMatchers("/api/user/all").permitAll()
                //所有请求都需要得到认证
                .anyRequest().authenticated()
                .and()
                //表单验证
                .formLogin()
                //自定义异常处理
                .and()
                .exceptionHandling()
                .authenticationEntryPoint((req, resp, ex) -> {
                    R r = new R();
                    r.put("msg", "认证之后才能访问!");
                    r.put("code", HttpStatus.UNAUTHORIZED.value());
                    r.put("错误信息", ex.getMessage());
                    resp.setContentType("application/json;charset=UTF-8");
                    String s = new ObjectMapper().writeValueAsString(r);
                    resp.getWriter().println(s);
                })
                //自定义退出处理
                .and()
                .logout()
                .logoutUrl("api/logout")
                .logoutSuccessHandler((req, resp, auth) -> {
                    R r = new R();
                    r.put("msg", "注销成功");
                    r.put("code", 200);
                    r.put("userinfo", auth.getPrincipal());
                    resp.setContentType("application/json;charset=UTF-8");
                    String s = new ObjectMapper().writeValueAsString(r);
                    resp.getWriter().println(s);
                })
                .and()
                .cors()
                .configurationSource(corsConfigurationSource())
                .and().csrf().disable();

        //替换原有的表单验证
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * 自定义 LoginFilter
     * @return
     * @throws Exception
     */
    @Bean
    public LoginFilter loginFilter() throws Exception {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setFilterProcessesUrl("/api/doLogin");
        loginFilter.setUsernameParameter("username");
        loginFilter.setPasswordParameter("password");
        loginFilter.setKaptchaParameter("kaptcha");
        loginFilter.setAuthenticationManager(authenticationManagerBean());
        //登录成功返回前端的json数据
        loginFilter.setAuthenticationSuccessHandler((req, resp, authentication) -> {
            R r = new R();
            r.put("msg", "登录成功");
            r.put("code", HttpStatus.OK.value());
            r.put("userinfo", authentication.getPrincipal());
            resp.setContentType("application/json;charset=UTF-8");
            String s = new ObjectMapper().writeValueAsString(r);
            resp.getWriter().println(s);
        });
        //登录失败返回前端的json数据
        loginFilter.setAuthenticationFailureHandler((req, resp, ex) -> {
            R r = new R();
            r.put("msg", "登录失败: " + ex.getMessage());
            r.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
            resp.setContentType("application/json;charset=UTF-8");
            String s = new ObjectMapper().writeValueAsString(r);
            resp.getWriter().println(s);
        });

        return loginFilter;
    }

    /**
     * 自定义 configure
     * @param builder
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(myUserDetailServiceImpl)
                .passwordEncoder(new CustomPasswordEncoder());
    }

    /**
     * 自定义AuthenticationManager
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 跨域请求处理
     * @return
     */
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
