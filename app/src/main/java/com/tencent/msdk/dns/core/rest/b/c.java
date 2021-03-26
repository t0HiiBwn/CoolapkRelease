package com.tencent.msdk.dns.core.rest.b;

import com.tencent.msdk.dns.core.rest.share.b;
import java.util.Locale;

/* compiled from: DesHttpDnsConfig */
final class c extends b {
    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String a() {
        return "182.254.116.117";
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String b() {
        return "119.29.29.29";
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public int c() {
        return 80;
    }

    c() {
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String a(String str, String str2) {
        return String.format(Locale.US, "http://%s/d?%s", str, str2);
    }
}
