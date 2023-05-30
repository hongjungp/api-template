package com.example.apitemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**", "/")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                    .logoutUrl("/auth/logout")
                    .logoutSuccessUrl("/")
                    .deleteCookies("JSESSIONID")
                    .invalidateHttpSession(true)
                .and();
        ;
        //                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .formLogin().disable()
//                .httpBasic().disable()
//                .authorizeHttpRequests((auth) -> auth
//                        .anyRequest()
//                        .authenticated()
//                );
        return http.build();
    }

    //    http
//            .logout()
//            .logoutSuccessUrl("/logout-success") // 로그아웃 후 리다이렉트할 URL 설정
//                .deleteCookies("JSESSIONID") // 쿠키 삭제
//                .invalidateHttpSession(true) // 세션 무효화
//                .permitAll();
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
