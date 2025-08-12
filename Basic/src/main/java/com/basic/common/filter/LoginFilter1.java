package com.basic.common.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter1 implements Filter {
    private static final String[] WHITE_LIST = {"/", "/signup", "/login"};

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("LOGIN_DIRECTOR") == null) {
                throw new RuntimeException("로그인 해주세요.");
            }
        }
        chain.doFilter(request, response);
    }

    private boolean isWhiteList(String requestURI) {return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);}
}
