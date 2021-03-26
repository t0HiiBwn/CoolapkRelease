package com.tencent.msdk.dns.core.rest.a;

import com.tencent.msdk.dns.core.rest.share.b;
import java.util.Locale;

/* compiled from: AesHttpDnsConfig */
final class c extends b {
    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String a() {
        return "119.29.29.99";
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String b() {
        return "119.28.28.88";
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public int c() {
        return 80;
    }

    c() {
    }

    @Override // com.tencent.msdk.dns.core.rest.share.b
    public String a(String str, String str2) {
        return String.format(Locale.US, "http://%s/d?%s&alg=aes", str, str2);
    }
}
