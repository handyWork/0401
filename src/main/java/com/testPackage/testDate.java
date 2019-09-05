package com.testPackage;

/**
 * 测试应该完成的时间是 本月/下月/超期 的情况
 */
public class testDate {

    private static String time = "20190901";

    public String comepareToDate() {
        // 应该完成的时间
        int year = 2020;
        int moth = 11;
        int day = 4;

        // 当前时间
        int dateyear = 2019;
        int datemoth = 9;
        int dateday = 5;

        String str = "";
        if (dateyear - year > 0) {
            return str = "超期";
        }

        if (dateyear - year == 0) {
            // 判断月份
            if (datemoth - moth > 0) {
                str = "超期";
            } else if (datemoth - moth == 0) {
                // 判断天数
                if (dateday - day > 0) {
                    str = "超期";
                } else {
                    str = "本月";
                }
            } else if (datemoth - moth == -1) {
                str = "下月";
            } else {
                str = "未超期++";
            }
            return str;
        }
        return "未超期++";
    }

    public static void main(String[] args) {

        testDate test = new testDate();
        System.out.println(test.comepareToDate());


    }
}
