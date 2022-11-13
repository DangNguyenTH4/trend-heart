package com.sunteco.young.loveevent.controller;

import com.sunteco.young.loveevent.config.ContentService;
import com.sunteco.young.loveevent.config.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContentService contentService;
    @GetMapping("/update")
    public ResponseEntity<String> updateUser(@RequestParam(value = "name1", required = false) String user1,
                                             @RequestParam(value = "name2", required = false) String user2){
        if(userService.isAllowUpdate()){
            userService.update(user1, user2);
            contentService.applyNewName();
            return ResponseEntity.ok("DONE");
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not allow update, update env and restart app");
    }
}
