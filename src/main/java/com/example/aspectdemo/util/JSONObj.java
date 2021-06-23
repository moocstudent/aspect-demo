package com.example.aspectdemo.util;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @Author: Frank
 * @Date: 2021-06-23 11:17
 */
@Component
public class JSONObj extends JSONObject {


    @Override
    public JSONObject putOpt(String key, Object value) throws JSONException {
        if (key != null && value != null) {
            this.set(key, value);
        }
        return this;
    }

}
