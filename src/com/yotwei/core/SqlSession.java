package com.yotwei.core;

import java.lang.reflect.Proxy;

/**
 * Created by YotWei on 2018/8/6.
 */
public class SqlSession {

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(),
                new Class[]{cls},
                new SqlExecuteHandler());
    }
}
