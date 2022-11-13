package com.sunteco.young.loveevent.controller;

import com.sunteco.young.loveevent.config.ContentService;
import com.sunteco.young.loveevent.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

@Controller
public class IndexController {
    @Autowired
    private ContentService contentService;
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ResponseEntity<String> notSupportTenantPage() {
        return new ResponseEntity<>(contentService.getIndexHtmlContent(), HttpStatus.OK);
    }


}
