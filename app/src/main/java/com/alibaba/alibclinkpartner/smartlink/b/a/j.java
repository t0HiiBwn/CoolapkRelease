package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import java.util.Map;

public class j extends a {
    public String a;
    public String b;
    public String c;
    public ALSLUri.ALSLdegradeType d;
    public boolean e;

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return "cf.linkpartner.2.4";
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> b2 = super.b();
        b2.put("target", this.a);
        b2.put("degradeUrl", this.b);
        b2.put("url", this.c);
        b2.put("degradeType", this.d.toString());
        b2.put("isSmart", this.e ? "1" : "0");
        return b2;
    }
}
