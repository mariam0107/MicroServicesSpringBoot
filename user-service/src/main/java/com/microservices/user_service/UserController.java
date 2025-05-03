package com.microservices.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.management.ValueExp;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") String userId){
        User user1 = new User(userId,"UserName"+userId,"userPhoneNumber"+userId);

        Posts posts = restTemplate.getForObject("http://localhost:8081/post/1",Posts.class);
        user1.setPosts(posts);

        Notifications notifications = restTemplate.getForObject("http://localhost:8080/notifications/1", Notifications.class);
        user1.setNotifications(notifications);

        return  user1;
    }

}
