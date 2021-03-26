package com.coolapk.market.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BuildProperties {
    private final Properties properties;

    private BuildProperties() throws IOException {
        Properties properties2 = new Properties();
        this.properties = properties2;
        properties2.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
    }

    public boolean containsKey(Object obj) {
        return this.properties.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.properties.containsValue(obj);
    }

    public Set<Map.Entry<Object, Object>> entrySet() {
        return this.properties.entrySet();
    }

    public String getProperty(String str) {
        return this.properties.getProperty(str);
    }

    public String getProperty(String str, String str2) {
        return this.properties.getProperty(str, str2);
    }

    public boolean isEmpty() {
        return this.properties.isEmpty();
    }

    public Enumeration<Object> keys() {
        return this.properties.keys();
    }

    public Set<Object> keySet() {
        return this.properties.keySet();
    }

    public int size() {
        return this.properties.size();
    }

    public Collection<Object> values() {
        return this.properties.values();
    }

    public static BuildProperties newInstance() throws IOException {
        return new BuildProperties();
    }
}
