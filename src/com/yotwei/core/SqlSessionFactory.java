package com.yotwei.core;


/**
 * Created by YotWei on 2018/8/6.
 */
public class SqlSessionFactory {

    static {
        SqlMappersHolder inst = SqlMappersHolder.INSTANCE;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public SqlSession openSession() {
        return new SqlSession();
    }
}
