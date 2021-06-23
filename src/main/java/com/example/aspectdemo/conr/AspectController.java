package com.example.aspectdemo.conr;

/**
 * @Author: Frank
 * @Date: 2021-06-23 9:47
 */

import com.example.aspectdemo.util.JSONObj;
import com.example.aspectdemo.util.StringUtilz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class AspectController {
    @Autowired
    private StringUtilz stringUtilz;


    @GetMapping("/")
    public String test(String hi){
        stringUtilz.toUpper2(hi);
        return "test"+" "+ StringUtilz.toUpper(hi);

    }
}
