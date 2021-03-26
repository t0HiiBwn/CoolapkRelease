package mtopsdk.security;

import java.util.HashMap;
import mtopsdk.mtop.global.MtopConfig;

public interface ISign {
    String getAppKey(a aVar);

    String getAvmpSign(String str, String str2, int i);

    String getCommonHmacSha1Sign(String str, String str2);

    String getMiniWua(HashMap<String, String> hashMap, HashMap<String, String> hashMap2);

    String getMtopApiSign(HashMap<String, String> hashMap, String str, String str2);

    String getSecBodyDataEx(String str, String str2, String str3, HashMap<String, String> hashMap, int i);

    String getSign(HashMap<String, String> hashMap, String str);

    HashMap<String, String> getUnifiedSign(HashMap<String, String> hashMap, HashMap<String, String> hashMap2, String str, String str2, boolean z);

    String getWua(HashMap<String, String> hashMap, String str);

    void init(MtopConfig mtopConfig);

    public static class a {
        public int a;
        public String b;

        public a(int i, String str) {
            this.a = i;
            this.b = str;
        }
    }
}
