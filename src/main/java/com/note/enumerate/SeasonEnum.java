package com.note.enumerate;

/**
 * 季节枚举类
 */
public enum SeasonEnum {
    SPRING(1,"春天"), SUMMER(2,"夏天"), AUTUMN(3,"秋天"), WINTER(4,"冬天");
    int seq;
    String value;

    public int getSeq() {
        return seq;
    }

    public String getValue() {
        return value;
    }

    SeasonEnum(int seq, String value) {
        this.seq = seq;
        this.value = value;
    }}
