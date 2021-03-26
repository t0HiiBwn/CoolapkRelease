package com.bytedance.sdk.openadsdk.i.e;

import com.bytedance.sdk.adnet.core.Header;
import com.bytedance.sdk.adnet.core.HttpResponse;
import com.bytedance.sdk.openadsdk.i.i;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: VolleyResponseWrapper */
public class g extends a {
    private HttpResponse c;

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public String e() {
        return "http/1.1";
    }

    public g(HttpResponse httpResponse, f fVar) {
        this.c = httpResponse;
        this.a = new ArrayList();
        for (int i = 0; i < this.c.getHeaders().size(); i++) {
            Header header = this.c.getHeaders().get(i);
            if (header != null) {
                this.a.add(new i.b(header.getName(), header.getValue()));
            }
        }
        this.b = fVar;
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public int a() {
        return this.c.getStatusCode();
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public boolean b() {
        return this.c.getStatusCode() >= 200 && this.c.getStatusCode() < 300;
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public String a(String str, String str2) {
        return a(str) != null ? a(str).b : str2;
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public List<i.b> c() {
        return this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public InputStream d() {
        return this.c.getContent();
    }

    @Override // com.bytedance.sdk.openadsdk.i.e.a
    public String f() {
        return a(this.c.getStatusCode());
    }
}
