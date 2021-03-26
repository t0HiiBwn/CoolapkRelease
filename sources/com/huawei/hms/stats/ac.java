package com.huawei.hms.stats;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class ac {
    protected static bl a(String str, String str2) {
        bl blVar = new bl();
        blVar.a(bg.a().d(str, str2));
        return blVar;
    }

    protected static bm a(String str, String str2, String str3, String str4) {
        bm bmVar = new bm();
        bmVar.f(str);
        bmVar.a(b.e());
        bmVar.c(str2);
        bmVar.e(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        bmVar.d(stringBuffer.toString());
        return bmVar;
    }

    protected static bn a(String str, String str2, String str3) {
        bn bnVar = new bn();
        bnVar.a(b.b());
        bnVar.b(b.d());
        bnVar.c(str3);
        bnVar.d(bg.a().e(str2, str));
        return bnVar;
    }

    protected static x a() {
        af.b("hmsSdk", "generate UploadData");
        ae.a().b();
        if (!TextUtils.isEmpty(ae.a().d())) {
            return new x(ae.a().c());
        }
        af.c("hmsSdk", "event chifer is empty");
        return null;
    }

    protected static Map<String, String> b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", b.e());
        hashMap.put("App-Ver", b.f());
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "2.2.0.305");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("servicetag", str);
        af.a("hmsSdk", "sendData RequestId : %s", str2);
        hashMap.put("Request-Id", str2);
        return hashMap;
    }
}
