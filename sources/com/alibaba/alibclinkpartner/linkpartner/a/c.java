package com.alibaba.alibclinkpartner.linkpartner.a;

import android.os.Bundle;
import android.text.TextUtils;

public class c {
    public static b a;

    public static synchronized void a(String str, String str2, int i, Bundle bundle) {
        synchronized (c.class) {
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                if (a != null) {
                    String[] split = str2.split(",");
                    if (split.length != 0) {
                        String str3 = split[0];
                        Bundle bundle2 = bundle.getBundle("result");
                        if (a.a(str, str3)) {
                            b bVar = a;
                            if (bundle2 == null) {
                                bundle2 = new Bundle();
                            }
                            bVar.a(i, bundle2);
                        }
                        a = null;
                        a.a();
                    }
                }
            }
        }
    }
}
