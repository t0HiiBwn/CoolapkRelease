package com.alibaba.baichuan.trade.common.adapter.ut.performance;

import java.util.LinkedHashMap;
import java.util.Map;

public class AlibcDimensionValueSet {
    protected Map<String, String> a;

    @Deprecated
    public AlibcDimensionValueSet() {
        if (this.a == null) {
            this.a = new LinkedHashMap();
        }
    }

    public static AlibcDimensionValueSet create() {
        return new AlibcDimensionValueSet();
    }

    public AlibcDimensionValueSet addValues(AlibcDimensionValueSet alibcDimensionValueSet) {
        Map<String, String> map;
        if (!(alibcDimensionValueSet == null || (map = alibcDimensionValueSet.getMap()) == null)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.a.put(entry.getKey(), entry.getValue() != null ? entry.getValue() : "null");
            }
        }
        return this;
    }

    public boolean containValue(String str) {
        return this.a.containsKey(str);
    }

    public Map<String, String> getMap() {
        return this.a;
    }

    public String getValue(String str) {
        return this.a.get(str);
    }

    public AlibcDimensionValueSet setValue(String str, String str2) {
        Map<String, String> map = this.a;
        if (str2 == null) {
            str2 = "null";
        }
        map.put(str, str2);
        return this;
    }
}
