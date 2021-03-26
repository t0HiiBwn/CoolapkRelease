package com.bytedance.sdk.openadsdk.preload.geckox.model;

import com.bytedance.sdk.openadsdk.preload.a.a.c;
import java.util.List;
import java.util.Map;

public class ComponentModel {
    @c(a = "packages")
    private Map<String, List<UpdatePackage>> packages;
    @c(a = "universal_strategies")
    private Map<String, b> universalStrategies;

    public static class a {
        @c(a = "c")
        public String a;
        @c(a = "clean_type")
        public int b;
        @c(a = "version")
        public List<Long> c;
    }

    public static class b {
        @c(a = "specified_clean")
        public List<a> a;
    }

    public Map<String, List<UpdatePackage>> getPackages() {
        return this.packages;
    }

    public Map<String, b> getUniversalStrategies() {
        return this.universalStrategies;
    }
}
