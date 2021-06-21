package com.project.kim.config;

import com.project.kim.config.filter.CorsFilter;
import com.project.kim.config.jwt.JwtAuthenticationFilter;
import com.project.kim.config.jwt.JwtAuthorizationFilter;
import com.project.kim.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class FilterConfig {

    private final UserRepository userRepository;
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        System.out.println("CORS 필터 등록");
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter());
        bean.addUrlPatterns("/*");
        bean.setOrder(0); // 낮은 번호부터 실행됨.
        return bean;
    }

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilter(){
        System.out.println("JwtAuthenticationFilter 필터 등록1");
        FilterRegistrationBean<JwtAuthenticationFilter> bean =
                new FilterRegistrationBean<>(new JwtAuthenticationFilter(userRepository));
        bean.addUrlPatterns("/login");
        bean.setOrder(1); // 낮은 번호부터 실행됨.
        return bean;
    }
    //추후에 로그인 하고 요청 보낼떄 사용
//    @Bean
//    public FilterRegistrationBean<JwtAuthorizationFilter> jwtAuthorizationFilter(){
//        System.out.println("JwtAuthorizationFilter 필터 등록2");
//        FilterRegistrationBean<JwtAuthorizationFilter> bean =
//                new FilterRegistrationBean<>(new JwtAuthorizationFilter(userRepository));
//        bean.addUrlPatterns("/user/*");
//        bean.setOrder(2); // 낮은 번호부터 실행됨.
//        return bean;
//    }
}