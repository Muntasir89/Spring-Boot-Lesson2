package com.practice.firstproject.listener;

import com.practice.firstproject.entity.User;
import com.practice.firstproject.event.RegistrationCompleteEvent;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // Create the verification token for the user and with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
    }
}
