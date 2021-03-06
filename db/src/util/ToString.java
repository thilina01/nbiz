/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.nanosl.lib.db.Manager;
import entity.Config;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thilina
 */
public class ToString {

    static final Manager manager = Manager.getInstance();
    static int times;

    static {
        String qry = "CREATE TABLE if not exists `config` (\n"
                + "  `config_key` varchar(20) NOT NULL,\n"
                + "  `config_value` varchar(100) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`config_key`)\n"
                + ") ENGINE=InnoDB DEFAULT CHARSET=utf8 ;";
        try (Connection connection = manager.getConnection()) {
            connection.createStatement().execute(qry);
        } catch (SQLException ex) {
            Logger.getLogger(ToString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    static Map<Class, String> map = new HashMap<>();
    static Map<Class, ArrayList<Method>> methodMap = new HashMap<>();

    public static String get(Object o) {
        Class c = o.getClass();
        if (!methodMap.containsKey(c)) {
            methodMap.put(c, getMethods(o));
        }
        return getToReturn(o);
    }

    public static void remove(String className) {
        try {
            methodMap.remove(Class.forName("entity." + className));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//        try {
//        } catch (IllegalArgumentException ex) {
//            Logger.getLogger(ToString.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "not found";
//            String configValueFull;
//            if (!map.containsKey(c)) {
//                System.out.println("called " + ++times + "at: " + System.currentTimeMillis());
//                Config config = getConfig(o);
//                configValueFull = config.getConfigValue();
//                map.put(c, configValueFull);
//            } else {
//                configValueFull = map.get(c);
//            }
//                return getToReturn(o);
//            } else {
//                String toString = "";

//                return toString;
//    public static void updateMap(Config config) {
//
//        try {
//            Class<?> c = Class.forName("entity." + config.getConfigKey());
//            map.put(c, config.getConfigValue());
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ToString.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    private static Config getConfig(Object o) {
        Class c = o.getClass();
        String canonicalName = c.getName();
        String className = canonicalName.substring(canonicalName.lastIndexOf(".") + 1);
        String idFieldNames = "";
        Config config = manager.find(Config.class, className);
        if (config == null) {
            config = new Config(className);
            for (Field field : c.getDeclaredFields()) {
                Annotation[] annotations = field.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    String annotationString = annotation.toString();
                    if (annotationString.equalsIgnoreCase("@javax.persistence.Id()") || annotationString.equalsIgnoreCase("@javax.persistence.EmbeddedId()") || annotationString.contains("@javax.persistence.Basic(")) {
                        idFieldNames += idFieldNames.contains(field.getName()) ? "" : field.getName() + ",";
                    }
                }
            }
            config.setConfigValue(idFieldNames.substring(0, idFieldNames.length() - 1));
            manager.update(config);
        }
        return config;
    }

    private static String getToReturn(Object o) {
        ArrayList<Method> methods = methodMap.get(o.getClass());
        String toReturn = "";
        for (Method method : methods) {
            try {
                Object result = method.invoke(o);
                if (result == null) {
                    continue;
                }
                toReturn += result.toString() + ((methods.get(methods.size() - 1).equals(method)) ? "" : " | ");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ToString.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return toReturn;
    }

    private static ArrayList<Method> getMethods(Object o) {
        ArrayList<Method> methods = new ArrayList<>();
        try {
            Config config = getConfig(o);
            String configValueFull = config.getConfigValue();
            String[] configValues = configValueFull.split(",");
            List<String> strings = Arrays.asList(configValues);
            BeanInfo beanInfo = Introspector.getBeanInfo(o.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (String string : strings) {
//            if (string.equalsIgnoreCase("t")) {
//                toString = toString.concat("      ");
//            } else {
                for (PropertyDescriptor pd : propertyDescriptors) {
                    String propertyName = pd.getName();
                    if (pd.getReadMethod() != null && !"class".equals(propertyName) && string.equalsIgnoreCase(propertyName)) {//propertyName.equalsIgnoreCase(configValue)
                        Method method = pd.getReadMethod();
                        if (method == null) {
                            continue;
                        }
                        methods.add(method);
//                Object result = method.invoke(o);
//                if (result == null) {
//                    continue;
//                }
//                        toString += result.toString() + ((strings.get(strings.size() - 1).equals(string)) ? "" : " ~ ");
                    }
//            }
                }
            }
        } catch (IntrospectionException ex) {
        }
        return methods;
    }
}
