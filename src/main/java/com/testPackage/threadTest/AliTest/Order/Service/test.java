package com.testPackage.threadTest.AliTest.Order.Service;

import java.util.*;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        List<Map<String, String>> list = new ArrayList<>(16) ;
        Map<String,String> map1 = new HashMap<>(16);
        map1.put("name", "val1");
        Map<String,String> map2 = new HashMap<>(16);
        map2.put("name", "val1");
        list.add(map1);
        list.add(map2);
        //打印list里面的数据
        list.forEach(System.out::println);

        ArrayList<Map<String, String>> data = list.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(m -> m.get("name")))), ArrayList::new));
        System.out.println("=======去重前后分界线=======");
        //打印过滤后的数据
        data.forEach(System.out::println);
    }

    private  List<Map<String, Object>> filterListByName(List<Map<String, Object>> list) {
        if(null==list || list.size()<=0){
            return list;
        }else{
            for(int i=0; i<list.size(); i++){
                Map<String, Object> map1 = list.get(i);
                for(int j=i+1; j<list.size(); j++){
                    if(map1.get("name").equals(list.get(j).get("name"))){
                        list.remove(j);
                        j--;
                    }
                }
            }
            return list;
        }
    }
}
