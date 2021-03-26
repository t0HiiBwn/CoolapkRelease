package com.bytedance.sdk.openadsdk.h;

import android.content.Context;
import android.location.Address;
import com.bytedance.sdk.adnet.c.b;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import java.util.Map;

/* compiled from: TTAdNetDepend */
public class c implements b {
    String a = "sp_multi_ttadnet_config";
    private Context b;

    @Override // com.bytedance.sdk.adnet.c.b
    public Address a(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String b() {
        return "openadsdk";
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String c() {
        return "android";
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int d() {
        return 3412;
    }

    public c(Context context) {
        this.b = context;
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public int a() {
        return Integer.parseInt("1371");
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String e() {
        return k.a(this.b);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String a(Context context, String str, String str2) {
        return a.b(this.a, str, str2);
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public void a(Context context, Map<String, ?> map) {
        if (map != null) {
            try {
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Integer) {
                        a.a(this.a, entry.getKey(), (Integer) value);
                    } else if (value instanceof Long) {
                        a.a(this.a, entry.getKey(), (Long) value);
                    } else if (value instanceof Float) {
                        a.a(this.a, entry.getKey(), (Float) value);
                    } else if (value instanceof Boolean) {
                        a.a(this.a, entry.getKey(), (Boolean) value);
                    } else if (value instanceof String) {
                        a.a(this.a, entry.getKey(), (String) value);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.adnet.c.b
    public String[] f() {
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm.pstatp.com"};
    }
}
