package com.testPackage.ioFlowTest;

import org.assertj.core.util.Lists;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * 写数据到某个文件中
 */
public  class IoTest {

    private static String source = "D:\\编程单词\\success.txt";
    private static String encode = "gbk";

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

    public static void main(String[] args) throws IOException {

        List<String> list = Lists.newArrayList();
        list.add("abc");
        list.add("add");
        list.add("success");
        IoTest ioTest = new IoTest();
        ioTest.writeFileLine(source,encode,list);

    }

}


























