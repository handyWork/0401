package com.springBoot.zookeeperLock;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.apache.ibatis.javassist.bytecode.ByteArray;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    public static void main(String[] args) {
//        ExcelReader reader = ExcelUtil.getReader("E:/abc.xls");
//        List<List<Object>> readAll = reader.read();
//
//        ArrayList<Object> lists = Lists.newArrayList();
//        Map map = new HashMap();
//        for (List<Object> row:readAll) {
//            for(int i = 0;i<row.size();i++){
//                map.put(i,row.get(i));
//            }
//        }
//        lists.add(map);
//        System.out.println();
        String abc = "A";
        parse(abc);
    }


    private static int parse(String string){

//        Byte aByte = new Byte(string);

        String s = "A";
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++){
////            System.out.println(" " + chars[i] + " " + (int)chars[i] );
//            System.err.println(((int) chars[i] - 65));
//        }
//        System.out.println(chars);

//        byte[] bytes= Encoding.ASCII.GetBytes(s);

        Double a = 12.00;
        Double b = 12.00;

//        Map<String, Object> map = Maps.newHashMap(String,);
        HashMap<String, Object> map = new HashMap<>();
        map.put("1","20.00");

        Double o = Double.valueOf((String) map.get("1")) ;

//        Double c = a+b;
        System.out.println(o);

        return 0;
    }


}





















