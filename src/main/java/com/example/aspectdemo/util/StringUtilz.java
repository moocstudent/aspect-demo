package com.example.aspectdemo.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: Frank
 * @Date: 2021-06-23 9:59
 */
@Component
public class StringUtilz {

    public static String toUpper(String word){
        return word.toUpperCase();
    }

    @Autowired
    private JSONObj jsonObj;

    public String toUpper2(String word){
        word.compareToIgnoreCase(word.toUpperCase());
        ObjectUtil.isNotNull(word);
        jsonObj.putOpt(word,word);
        return word.toUpperCase();
    }
}
