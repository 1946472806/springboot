//package org.sang.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
////------------------------------------ 这个注册登陆账号密码是保存在内存中的 ----------------------------------------------
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Bean
//    PasswordEncoder passwordEncoder(){
////        return NoOpPasswordEncoder.getInstance();  不加密
//        return new BCryptPasswordEncoder(10);  //强哈希加密
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.inMemoryAuthentication()  //信息保存在内存中
////                .withUser("root").password("123").roles("ADMIN","DBA")  //不加密
//                .withUser("root").password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq").roles("ADMIN","DBA") //加密
//                .and()
////                .withUser("admin").password("123").roles("ADMIN","USER")  //不加密
//                .withUser("admin").password("$2a$10$RMuFXGQ5AtH4wOvkUqyvuecpqUSeoxZYqilXzbz50dceRsga.WYiq").roles("ADMIN","USER")
//                .and()
////                .withUser("sang").password("123").roles("USER"); //不加密
//                .withUser("sang").password("$2a$10$eUHbAOMq4bpxTvOVz33LIehLe3fu6NwqC9tdOcxJXEhyZ4simqXTC").roles("USER");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
//                .antMatchers("/user/**")
//                .access("hasAnyRole('ADMIN','USER')")
//                .antMatchers("/db/**")
//                .access("hasAnyRole('ADMIN') and hasRole('DBA')")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true)
//                .addLogoutHandler(new LogoutHandler() {
//                    @Override
//                    public void logout(HttpServletRequest req,
//                                       HttpServletResponse resp,
//                                       Authentication auth) {
//
//                    }
//                })
//                .logoutSuccessHandler(new LogoutSuccessHandler() {
//                    @Override
//                    public void onLogoutSuccess(HttpServletRequest req,
//                                                HttpServletResponse resp,
//                                                Authentication auth)
//                            throws IOException {
//                        resp.sendRedirect("/axf/login");
//                    }
//                })
//                .and()
//                .csrf()
//                .disable();
//    }
//
//}
