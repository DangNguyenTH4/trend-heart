package com.sunteco.young.loveevent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;

public class UserService {
    private String user1;
    private String user2;
    private boolean allowUpdate;
    public UserService(String user1, String user2, boolean allowUpdate){
        this.user1 = user1;
        this.user2 = user2;
        this.allowUpdate = allowUpdate;
    }
    @PostConstruct
    void init(){
        System.out.println("USER1" + user1);
        System.out.println("USER2" + user2);
        System.out.println("ALLOW" + allowUpdate);
        System.out.println(new String(user1.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
    }

    public void update(String user1, String user2){
        if(!allowUpdate)
            return;
        this.user1 = user1;
        this.user2 = user2;
    }

    public boolean isAllowUpdate() {
        return allowUpdate;
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }
}
