package com.huawei.updatesdk.a.b.d;

import com.huawei.updatesdk.a.b.d.a.d;
import com.huawei.updatesdk.service.appmgr.bean.b;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static Map<String, Class> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("client.updateCheck", b.class);
    }

    public static d a(String str) throws InstantiationException, IllegalAccessException {
        Class cls = a.get(str);
        if (cls != null) {
            return (d) cls.newInstance();
        }
        throw new InstantiationException("ResponseBean class not found, method:" + str);
    }
}
