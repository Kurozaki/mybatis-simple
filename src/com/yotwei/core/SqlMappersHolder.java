package com.yotwei.core;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YotWei on 2018/8/6.
 */
public enum SqlMappersHolder {

    INSTANCE;

    private Map<String, MapperInfo> mi = null;

    SqlMappersHolder() {
        if (mi != null)
            return;
        mi = new HashMap<>();

        File dir = new File(SqlMappersHolder.class
                .getClassLoader()
                .getResource(Config.DEFAULT.getMapperPath())
                .getFile());


        SAXReader reader = new SAXReader();
        try {
            for (String file : dir.list()) {
                Document doc = reader.read(new File(dir, file));
                Element root = doc.getRootElement();
                String className = root.attributeValue("namespace");

                for (Object o : root.elements()) {
                    Element e = (Element) o;

                    MapperInfo info = new MapperInfo();
                    info.setQueryType(QueryType.value(e.getName()));
                    info.setInterfaceName(className);
                    info.setMethodName(e.attributeValue("id"));
                    info.setResultType(e.attributeValue("resultType"));
                    info.setSql(e.getText());

                    mi.put(idOf(className, e.attributeValue("id")), info);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public MapperInfo getMapperInfo(String className, String methodName) {
        return mi.get(idOf(className, methodName));
    }

    private String idOf(String className, String methodName) {
        return className + "." + methodName;
    }
}
