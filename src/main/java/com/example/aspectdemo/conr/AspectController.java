package com.example.aspectdemo.conr;

/**
 * @Author: Frank
 * @Date: 2021-06-23 9:47
 */

import com.example.aspectdemo.util.StringUtilz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class AspectController {

    @GetMapping("/")
    public String test(String hi){
        return "test"+" "+ StringUtilz.toUpper(hi);
    }
}
