package com.alibaba.alibclinkpartner.smartlink.b.a;

import com.alibaba.alibclinkpartner.smartlink.config.ALSLUri;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class l extends a {
    public String a;
    public String b;
    public ALSLUri.ALSLdegradeType c;
    public List<String> d = new ArrayList();

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return "cf.linkpartner.5.2";
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> b2 = super.b();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.d) {
            stringBuffer.append(str);
            stringBuffer.append("^");
        }
        b2.put("url", this.a);
        b2.put("target", this.b);
        b2.put("degradeType", this.c.toString());
        b2.put("matrixAppList", stringBuffer.toString());
        return b2;
    }
}
