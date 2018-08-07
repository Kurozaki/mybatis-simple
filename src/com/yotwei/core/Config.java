package com.yotwei.core;

/**
 * Created by YotWei on 2018/8/6.
 */
public class Config {

    public static final Config DEFAULT = new Config();

    private Config() {

    }

    private String url = "jdbc:mysql://139.199.195.54:3306/weistudy";
    private String user = "root";
    private String pwd = "kurozakisql";

    private String mapperPath = "mapper/";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

    public String getMapperPath() {
        return mapperPath;
    }
}
