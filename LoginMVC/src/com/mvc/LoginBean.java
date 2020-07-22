package com.mvc;

public class LoginBean {
    private String name, password;

    public LoginBean()
    {

    }
    public LoginBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean validate() {
        if (password.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }
}
