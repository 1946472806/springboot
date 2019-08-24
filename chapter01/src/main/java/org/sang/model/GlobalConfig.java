package org.sang.model;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalConfig {
    @ModelAttribute
    public Map<String, String> userInfo() {
        HashMap<String, String> map = new HashMap<>();
        map.put("username", "胡歌");
        map.put("gender", "男");
        return map;
    }

    @ModelAttribute
    public String userInfos() {
        return "没有键的值";
    }

    @InitBinder("b")
    public void init(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }

    @InitBinder("a")
    public void init2(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("a.");
    }
}
