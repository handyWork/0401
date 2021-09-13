package com.testPackage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Sets;

import java.util.HashMap;
import java.util.HashSet;

public class test {

    public static void main(String[] args) {

        HashMap<Object, Object> roolMap = new HashMap<>();
        roolMap.put("roolId", "11111");
        roolMap.put("roolName", "管理员");
        HashMap<Object, Object> roolMap2 = new HashMap<>();
        roolMap2.put("roolId", "22222");
        roolMap2.put("roolName", "开发人员");

        HashMap<Object, Object> departMap = new HashMap<>();
        departMap.put("departId", "22222");
        departMap.put("departName", "开发部");
        HashMap<Object, Object> departMap2 = new HashMap<>();
        departMap2.put("departId", "3333333");
        departMap2.put("departName", "技术部");

//        TreeSet<Object> treeSet = Sets.newTreeSet();
//        treeSet.add(departMap);
//        treeSet.add(departMap2);
        HashSet<Object> departmentSet = Sets.newHashSet();
        departmentSet.add(departMap);
        departmentSet.add(departMap2);

        HashSet<Object> roolSet = Sets.newHashSet();
        roolSet.add(roolMap);
        roolSet.add(roolMap2);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("rool", roolSet);
        jsonObject.put("department", departmentSet);
        String s1 = jsonObject.toJSONString();

//        String s = JSON.toJSONString(endlist);
//        System.out.println(s);
        System.out.println(s1);

        // 将对象转为  json串
        Object o = new Object();
        JSON.toJSON(0);


    }
}
