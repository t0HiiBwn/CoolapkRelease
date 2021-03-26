package com.alibaba.alibclinkpartner.smartlink.b;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import java.util.HashMap;
import java.util.Map;

public class a {
    private Map<String, String> a = new HashMap();
    private String b;

    private a() {
    }

    public static a a() {
        return new a();
    }

    private String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("https://wgo.mmstat.com/%s?", this.b));
        stringBuffer.append(g.a(this.a));
        return stringBuffer.toString();
    }

    public a a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
        }
        return this;
    }

    public a a(Map<String, String> map) {
        if (map != null) {
            this.a.putAll(map);
        }
        return this;
    }

    public boolean b() {
        String c = c();
        ALSLLogUtil.d("ALSLAplus", "send", "Aplus打点上报的url = " + c);
        com.alibaba.alibclinkpartner.smartlink.a.a.a(c, (Map<String, String>) null);
        return true;
    }
}
