package com.project.kim.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.kim.domain.User;
import com.project.kim.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class JwtAuthenticationFilter implements Filter {
    private UserRepository userRepository;

    public JwtAuthenticationFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("JwtAuthenticationFilter 작동");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        PrintWriter out = resp.getWriter();

        String method = req.getMethod();

        if(!method.equals("POST")) {
            out.print("required post method");
            out.flush();
        }else {
            System.out.println("들어오고");
            ObjectMapper om = new ObjectMapper();
            try {
                User user = om.readValue(req.getInputStream(), User.class);
                User userEntity = validationUser(user);
                if(userEntity == null) {
                    // 디비에 데이터 없을떄
                    out.print(false);
                }else {
                    System.out.println("인증되었습니다.");
                    String jwtToken =
                            JWT.create()
//                                    .withSubject("kimToken")
                                    .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60))
                                    .withClaim("id", userEntity.getId())
                                    .sign(Algorithm.HMAC512(JwtProps.secret));

                    resp.addHeader(JwtProps.header, JwtProps.auth+jwtToken);
                    out.print(true);
                }
                out.flush();
            } catch (Exception e) {
                System.out.println("오류 : "+e.getMessage());
            }
        }
    }
    //snsGb 100 이면 일반 로그인 그외 sns 로그인
    private User validationUser(User user) throws Exception{
        User userEntity = new User();
        if(user.getSnsGb()==100) {
            System.out.println(user.getPassword());
            userEntity = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
            System.out.println(userEntity.getSnsGb());
            return userEntity;
        }

        userEntity = userRepository.findByEmailAndSnsGb(user.getEmail(), user.getSnsGb());
        if(userEntity == null){
            userRepository.save(user);
            userEntity =
                    userRepository.findByEmailAndSnsGb(user.getEmail(), user.getSnsGb());
        }

        return userEntity;
    }
}