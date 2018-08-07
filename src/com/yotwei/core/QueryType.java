package com.yotwei.core;

/**
 * Created by YotWei on 2018/8/6.
 */
public enum QueryType {
    SELECT, UPDATE, INSERT, DELETE;

    public static QueryType value(String v) {
        return valueOf(v.toUpperCase());
    }
}
