package com.testPackage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        ArrayList<Object> list = Lists.newArrayList();
        list.add("partment");
        list.add("rool");

        ArrayList<Object> list2 = Lists.newArrayList();
        list2.add("partment");
        list2.add("rool");

        HashMap<Object, Object> map = new HashMap<>();
        map.put("A","a");
        map.put("B",list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ccc","12313");
        jsonObject.put("dddd","1111");
        String s1 = jsonObject.toJSONString();

        String s = JSON.toJSONString(map);
        System.out.println(s);
        System.out.println(s1);

    }
}
