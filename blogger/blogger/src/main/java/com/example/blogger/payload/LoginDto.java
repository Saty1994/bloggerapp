package com.example.blogger.payload;

import lombok.Getter;
import lombok.Setter;

public class LoginDto {

    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Getter
    @Setter
        private String usernameOrEmail;
        private String password;
    }

