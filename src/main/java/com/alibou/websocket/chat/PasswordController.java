package com.alibou.websocket.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/win-daily-prizes")
    public String validatePassword(@RequestBody String passwordAttempt) {
        return passwordService.validatePassword(passwordAttempt);
    }

}
