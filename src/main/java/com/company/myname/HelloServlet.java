package com.company.myname;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    AccountService accountService = new AccountService();

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        String stringUrl = httpServletRequest.getRequestURI();
        httpServletResponse.sendRedirect(stringUrl);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, 
    IOException {
        String stringRequest = httpServletRequest.getRequestURI();
        String name = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        if (stringRequest.equals("/registration")) {
            accountService.registration(name, password);
            httpServletResponse.sendRedirect(accountService.getPageUrl());
        } else if (stringRequest.equals("/signUp")) {
            accountService.signUp(name, password);
            httpServletResponse.sendRedirect(accountService.getPageUrl());
        }
    }
}
