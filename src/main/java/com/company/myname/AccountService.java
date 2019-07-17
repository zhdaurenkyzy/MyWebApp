package com.company.myname;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private String pageUrl;
    Map<String, String> accountList = new HashMap<>();

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String registration(String newName, String newPassword) {
        if (!(newName.isEmpty()) & (!(newPassword.isEmpty()))) {
            if (accountList.containsKey(newName)) {
                System.out.println("Account already exists!");
                pageUrl = "registrationPage.jsp";
            } else {
                Account account = new Account(newName, newPassword);
                accountList.put(account.getName(), account.getPassword());
                System.out.println("You are registered!");
                pageUrl = "index.jsp";
            }
        }
        return pageUrl;
    }

    public String signUp(String name, String password) {
        if (accountList.containsKey(name) & accountList.containsValue(password)) {
            pageUrl = "mainPage.jsp";
            System.out.println("You are logged in as: " + name);
        } else {
            System.out.println("You entered a wrong username or password! Try again!");
            pageUrl = "index.jsp";
        }
        return pageUrl;
    }
}
