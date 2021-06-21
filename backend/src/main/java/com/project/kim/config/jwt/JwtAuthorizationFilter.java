package com.project.kim.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.project.kim.domain.User;
import com.project.kim.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class JwtAuthorizationFilter implements Filter {
    private UserRepository userRepository;

    public JwtAuthorizationFilter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("JwtAuthorizationFilter 작동");

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String jwtToken = req.getHeader(JwtProps.header);
        System.out.println(jwtToken);
        if (jwtToken == null) {
            PrintWriter out = resp.getWriter();
            out.print("jwtToken not found");
            out.flush();
        } else {
            jwtToken = jwtToken.replace(JwtProps.auth, "");
            System.out.println(jwtToken);
            try {
                int personId = JWT.require(Algorithm.HMAC512(JwtProps.secret)).build().verify(jwtToken).getClaim("id").asInt();
                System.out.println("personId:"+personId);
                HttpSession session = req.getSession();
                User userEntity = userRepository.findById(personId).get();
                System.out.println(userEntity.getEmail());
                session.setAttribute("principal", userEntity);
                chain.doFilter(request, response);
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("--------여기 오류");
                PrintWriter out = resp.getWriter();
                out.print("verify fail");
                out.flush();
            }
        }
    }
}