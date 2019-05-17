package com.example.homework_2.utils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;
import java.util.List;

public class XmlUtils {

    /**
     * XML转对象
     * @param clazz 对象类
     * @param str xml字符串
     * @param <T> T
     * @return
     */
    public static <T> T parseFromXml(Class<T> clazz, String xml) {
        //创建解析XML对象
        XStream xStream = new XStream(new DomDriver());
        //处理注解
        xStream.processAnnotations(clazz);
        @SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
                T t = (T)xStream.fromXML(xml);
        return t;
    }
    public static <T> List xmlToList(Class<T> clazz,String xml){
        XStream xStream = new XStream(new DomDriver());
        //处理注解
        xStream.processAnnotations(clazz);
        @SuppressWarnings("unchecked")
        //将XML字符串转为bean对象
                List t = (List)xStream.fromXML(xml);
        return t;
    }
    /**
     * 对象转xml
     * @param obj 对象
     * @return
     */
    public static String toXml(Object obj) {
        XStream xStream = new XStream(new DomDriver());
        xStream.processAnnotations(obj.getClass());
        return xStream.toXML(obj);
    }

    public static  String toXml(List list) {
        XStream xStream = new XStream(new DomDriver());
        if(null!=list.get(0)){
            xStream.processAnnotations(list.get(0).getClass());
        }
        return xStream.toXML(list);
    }

}