package com.tencent.tpns.baseapi.core.b;

/* compiled from: ProGuard */
public class a {

    /* renamed from: com.tencent.tpns.baseapi.core.b.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    public enum EnumC0157a {
        CLUSTER_DEFAULT("default", "tpns.tencent.com"),
        CLUSTER_SGP("sgp", "tpns.sgp.tencent.com"),
        CLUSTER_HK("hk", "tpns.hk.tencent.com");
        
        private String d;
        private String e;

        private EnumC0157a(String str, String str2) {
            this.d = str;
            this.e = str2;
        }

        public String a() {
            return this.d;
        }

        public String b() {
            return this.e;
        }
    }
}
