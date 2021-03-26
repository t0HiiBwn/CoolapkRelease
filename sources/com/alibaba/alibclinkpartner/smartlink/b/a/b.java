package com.alibaba.alibclinkpartner.smartlink.b.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class b extends a {
    public List<String> a = new ArrayList();

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public String a() {
        return "cf.linkpartner.4.1";
    }

    @Override // com.alibaba.alibclinkpartner.smartlink.b.a.a
    public Map<String, String> b() {
        Map<String, String> b = super.b();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.a) {
            stringBuffer.append(str);
            stringBuffer.append("^");
        }
        b.put("installedMatrixAppList", stringBuffer.toString());
        return b;
    }
}
