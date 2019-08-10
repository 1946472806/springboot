package org.sang.config;

import org.sang.service.MyBatisSecurityRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


//------------------------------------ 这个注册登陆账号密码是保存在MyBatis数据库中的 ----------------------------------------------
@Configuration
public class MyBatisSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    MyBatisSecurityRegService myBatisSecurityRegService;
    @Bean
    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();  不加密
        return new BCryptPasswordEncoder(10);  //强哈希加密
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(myBatisSecurityRegService); //信息保存在MyBatis数据库
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/admins/**")
                .hasRole("admin")
                .antMatchers("/users/**")
                .hasRole("user")
                .antMatchers("/dbs/**")
                .hasRole("dba")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .and()
                .csrf()
                .disable();
    }

}
