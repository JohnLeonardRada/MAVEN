package com.exist.exercise3.model;

public class Content implements java.lang.Comparable<Content>{
    private String key;
    private String value;

    public Content(){}

    public Content(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Content c) {
        return this.value.compareTo(c.value);
    }
}
