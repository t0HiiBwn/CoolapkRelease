package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import java.util.Map;

public class d extends a {
    public String a;
    public String b;
    public ALSLUri.ALSLdegradeType c;

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return "cf.linkpartner.1.1";
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> b2 = super.b();
        b2.put("targetScheme", this.a);
        b2.put("targetUrl", this.b);
        b2.put("degradeType", this.c.toString());
        return b2;
    }
}
