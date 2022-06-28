//package com.zhangyan.management.common.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * TODO
// * security配置文件
// * @author ZhangYan
// * @version V1.0
// * @since 2022-06-27 14:48
// */
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////
////    }
////    @Override
////    protected void configure(HttpSecurity httpSecurity) throws Exception {
////        httpSecurity
////                .authorizeRequests()
//////                .antMatchers("/swagger-ui.html").anonymous()
////                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
////                        "/swagger-resources", "/swagger-resources/configuration/security",
////                        "/swagger-ui.html", "/webjars/**").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                .headers().frameOptions().disable()
////        ;
////    }
//
//}
