package com.jck.travel.flight.filter;

import com.jck.travel.flight.service.AuthenticationService;
import com.jck.travel.flight.util.exception.AuthenticationException;
import com.jck.travel.flight.util.exception.BadRequestException;
import com.jck.travel.flight.util.exception.JSONResponseNotFoundException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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

        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Headers", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST");
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }

        JSONObject error = new JSONObject();
        try {
            if (authenticationService.isValidRequestHeaders(request) && authenticationService.isAuthorised(request)) {
                request.setAttribute("credentials", authenticationService.getUserCredentials(request).get("token"));
                filterChain.doFilter(request, response);
            } else {
                error.put("status", "401");
                error.put("message", "Unauthorised Access");
                authenticationService.sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, error);
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            error.put("status", "401");
            error.put("message", "Unauthorised Access");
            authenticationService.sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, error);
        } catch (BadRequestException e) {
            e.printStackTrace();
            error.put("status", "400");
            error.put("message", "Bad Request");
            authenticationService.sendErrorResponse(response, HttpServletResponse.SC_BAD_REQUEST, error);
        } catch (JSONResponseNotFoundException e) {
            e.printStackTrace();
            error.put("status", "500");
            error.put("message", "Internal Server Error : JSON Response Not Found");
            authenticationService.sendErrorResponse(response, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, error);
        }
    }

    @Override
    public void destroy() {

    }
}
