package com.weweb.sys.entity;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by wshen on 5/4/2017.
 */
public class LoginVo {
    @NotBlank(message = "account may not be empty")
    private String account;
    @NotBlank(message = "password may not be empty")
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
