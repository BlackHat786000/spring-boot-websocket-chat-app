package com.alibou.websocket.chat;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class PasswordService {

    public String validatePassword(String passwordAttempt) {
        // Set the time zone to IST
        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        LocalTime currentTimeIST = LocalTime.now(istZone);

        // Format the time in the "HHmm" pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        String expectedPassword = currentTimeIST.format(formatter) + "468";

        System.out.println(expectedPassword);

        if (passwordAttempt.equals(expectedPassword)) {
            return "Success";
        } else {
            return "Failure";
        }
    }
}
