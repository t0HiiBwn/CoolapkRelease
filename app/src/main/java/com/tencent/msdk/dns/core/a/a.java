package com.tencent.msdk.dns.core.a;

import android.text.TextUtils;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.LookupResult;
import com.tencent.msdk.dns.core.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Cache */
public final class a implements e {
    private final Map<String, LookupResult> a = new ConcurrentHashMap();

    @Override // com.tencent.msdk.dns.core.e
    public LookupResult a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.a.get(str);
        }
        throw new IllegalArgumentException("hostname".concat(" can not be empty"));
    }

    @Override // com.tencent.msdk.dns.core.e
    public void a(String str, LookupResult lookupResult) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("hostname".concat(" can not be empty"));
        } else if (lookupResult != null) {
            b.b("Cache %s for %s", lookupResult, str);
            this.a.put(str, lookupResult);
        } else {
            throw new IllegalArgumentException("lookupResult".concat(" can not be null"));
        }
    }

    @Override // com.tencent.msdk.dns.core.e
    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.remove(str);
            return;
        }
        throw new IllegalArgumentException("hostname".concat(" can not be empty"));
    }

    @Override // com.tencent.msdk.dns.core.e
    public void a() {
        this.a.clear();
    }
}
