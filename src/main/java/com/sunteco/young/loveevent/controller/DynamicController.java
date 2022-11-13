package com.sunteco.young.loveevent.controller;

import com.sunteco.young.loveevent.config.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DynamicController {
    @Autowired
    private ContentService contentService;

    @GetMapping("/dynamic")
    public ResponseEntity<String> updateUser(@RequestParam(value = "name1", required = false) String user1,
                                             @RequestParam(value = "name2", required = false) String user2) {
        String result = contentService.getDynamicHtmlContent(user1, user2);
        return ResponseEntity.ok(result);
    }
}
