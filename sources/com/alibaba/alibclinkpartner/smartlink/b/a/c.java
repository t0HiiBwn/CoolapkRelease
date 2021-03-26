package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import java.util.Map;

public class c extends a {
    public String a;
    public String b;
    public ALSLUri.ALSLdegradeType c;

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return "cf.linkpartner.1.3";
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> b2 = super.b();
        b2.put("target", this.a);
        b2.put("url", this.b);
        b2.put("degradeType", this.c.toString());
        return b2;
    }
}
