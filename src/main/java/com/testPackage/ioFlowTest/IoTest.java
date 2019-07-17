package com.testPackage.ioFlowTest;

import org.assertj.core.util.Lists;

import java.io.*;
import java.util.List;

/**
 * 写数据到某个文件中
 */
public  class IoTest {

    private static String source = "D:\\编程单词\\success.txt";
    private static String encode = "gbk";

    /**
     *  写数据到某个文件中
      * @param source  要写的文件地址
     * @param encode   编码格式
     * @param data     写入的数据
     * @throws IOException
     */
    public void writeFileLine(String source, String encode, List<String> data) throws IOException {

        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(source), encode);

        BufferedWriter bw = new BufferedWriter(writer);
        try {
            for (String str : data) {
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                bw.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private void readFile(String source,String encode) throws IOException {
        InputStreamReader inputStreamReader  = new InputStreamReader(new FileInputStream(source),encode);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        try {
            StringBuilder sb = new StringBuilder();
            String s = bufferedReader.readLine();
            while (s!=null){
                sb.append(s);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if (inputStreamReader != null){
                inputStreamReader.close();
            }
        }

    }


    public static void main(String[] args) throws IOException {

//        List<String> list = Lists.newArrayList();
//        list.add("abc");
//        list.add("add");
//        list.add("success");
        IoTest ioTest = new IoTest();
//        ioTest.writeFileLine(source,encode,list);

        ioTest.readFile(source,encode);

    }

}


























