package com.sunteco.young.loveevent.config;

import com.sunteco.young.loveevent.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Consumer;

@Component
public class ContentService {
    private static String content;
    private static String contentTemplate;
    @Autowired
    private UserService userService;

    @PostConstruct
    public void init(){
        contentTemplate = this.readTemplate();
        consumeNewNames.accept(List.of(userService.getUser1(), userService.getUser2()));
    }
    public String getIndexHtmlContent() {
        return  content;
    }
    public String getDynamicHtmlContent(String user1, String user2){
        if(StringUtils.isEmpty(user1)){
            user1 = "-";
        }
        if(StringUtils.isEmpty(user2)){
            user2 = "-";
        }
        return this.fillContentToTemplate(List.of(user1, user2));
    }
    public void applyNewName(){
        consumeNewNames.accept(List.of(userService.getUser1(), userService.getUser2()));
    }
    private final Consumer<List<String>> consumeNewNames = (listUser) ->{
        if(contentTemplate == null || contentTemplate.equals("Not found content")){
            contentTemplate = readTemplate();
        }
       content = this.fillContentToTemplate(listUser);
    } ;

    private String readTemplate(){
        String result;
        ClassPathResource staticResourceLoader = new ClassPathResource(Constant.INDEX_HTML_FILE);
        try{
            Reader reader = new InputStreamReader(staticResourceLoader.getInputStream(), StandardCharsets.UTF_8);
            result = FileCopyUtils.copyToString(reader);
        }catch (IOException ex){
            ex.printStackTrace();
            result = "Not found content";
        }

        return result;
    }
    private String fillContentToTemplate(List<String> listUser){
        if(CollectionUtils.isEmpty(listUser)){
            return "NO CONTENT FILLED";
        }
        String result = contentTemplate;
        for(int i = 0 ; i < listUser.size() ; i ++){
            result = result.replace(String.format("${user%s}", i), listUser.get(i) == null ? "-" : listUser.get(i));
        }
        return result;
    }
}
