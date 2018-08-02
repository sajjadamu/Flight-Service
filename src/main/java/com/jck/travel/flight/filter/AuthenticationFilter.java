package com.jck.travel.flight.filter;

import com.jck.travel.flight.service.AuthenticationService;
import com.jck.travel.flight.util.exception.AuthenticationException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        final JSONObject error = new JSONObject();
        error.put("status", "401");
        error.put("message", "Unauthorised Access");

        try {
            if (authenticationService.isValidRequestHeaders(request) && authenticationService.isAuthorised(request)) {
                filterChain.doFilter(request, response);
            } else {
                authenticationService.sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, error);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            authenticationService.sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, error);
        }
    }

    @Override
    public void destroy() {

    }
}
