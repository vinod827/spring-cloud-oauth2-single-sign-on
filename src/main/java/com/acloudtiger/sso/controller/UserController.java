package com.acloudtiger.sso.controller;

import com.acloudtiger.sso.model.UserDetails;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@EnableOAuth2Sso
public class UserController {

    private Map<Integer, UserDetails> usersMap = new HashMap();

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public Collection<UserDetails> getUsers(){
        if(ObjectUtils.isEmpty(usersMap)){
            usersMap.put(1, new UserDetails("Vijay", "Kumar", 33, "Faridabad"));
            usersMap.put(1, new UserDetails("Viresh", "Kumar", 33, "Kerala"));
            usersMap.put(1, new UserDetails("Rudra", "Menon", 33, "Delhi"));
        }
        return usersMap.values();
    }

    @RequestMapping(path = "/user/{userId}", method = RequestMethod.POST)
    public Collection<UserDetails> saveUser(@PathVariable Integer userId){
        if(ObjectUtils.isEmpty(usersMap)){
            usersMap.put(userId, new UserDetails("Vinod", "Kumar", 33, "India"));
        }
        return usersMap.values();
    }


}