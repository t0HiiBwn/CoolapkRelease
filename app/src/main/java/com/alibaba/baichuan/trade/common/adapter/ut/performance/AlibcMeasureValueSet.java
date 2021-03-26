package com.alibaba.baichuan.trade.common.adapter.ut.performance;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlibcMeasureValueSet {
    private Map<String, AlibcMeasureValue> a = new LinkedHashMap();

    private static Double a(String str) {
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static AlibcMeasureValueSet create() {
        return new AlibcMeasureValueSet();
    }

    public static AlibcMeasureValueSet create(Map<String, Double> map) {
        AlibcMeasureValueSet alibcMeasureValueSet = new AlibcMeasureValueSet();
        if (map != null) {
            for (String str : map.keySet()) {
                Double d = map.get(str);
                if (d != null) {
                    alibcMeasureValueSet.a.put(str, new AlibcMeasureValue(d.doubleValue()));
                }
            }
        }
        return alibcMeasureValueSet;
    }

    public static AlibcMeasureValueSet fromStringMap(Map<String, String> map) {
        AlibcMeasureValueSet alibcMeasureValueSet = new AlibcMeasureValueSet();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Double a2 = a(entry.getValue());
                if (a2 != null) {
                    alibcMeasureValueSet.a.put(entry.getKey(), new AlibcMeasureValue(a2.doubleValue()));
                }
            }
        }
        return alibcMeasureValueSet;
    }

    public void clean() {
        this.a.clear();
    }

    public boolean containValue(String str) {
        return this.a.containsKey(str);
    }

    public Map<String, AlibcMeasureValue> getMap() {
        return this.a;
    }

    public AlibcMeasureValue getValue(String str) {
        return this.a.get(str);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public void setMap(Map<String, AlibcMeasureValue> map) {
        this.a = map;
    }

    public AlibcMeasureValueSet setValue(String str, double d) {
        this.a.put(str, new AlibcMeasureValue(d));
        return this;
    }

    public void setValue(String str, AlibcMeasureValue alibcMeasureValue) {
        this.a.put(str, alibcMeasureValue);
    }
}
