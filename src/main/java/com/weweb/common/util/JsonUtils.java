package com.weweb.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.weweb.common.entity.Result;

/**
 * Created by syan on 2016/5/11.
 */
public class JsonUtils {
    public static JSONObject toJsonObj(Object obj) {
        JSONArray dataArray = new JSONArray();
        dataArray.add(obj);
        JSONObject paramObject = new JSONObject();
        paramObject.put("data", dataArray);
        return paramObject;
    }

    //data is not array
    public static JSONObject toJsonObject(Object obj) {
        JSONObject paramObject = new JSONObject();
        paramObject.put("data", obj);
        return paramObject;
    }
    public static String toString(Object obj) {
        JSONObject paramObject = new JSONObject();
        paramObject.put("data", obj);
       return JSON.toJSONString(paramObject);
    }
    public static String toString(Result result) {
        return JSON.toJSONString(result);
    }
}
