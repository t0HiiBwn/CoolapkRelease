package com.tencent.android.tpush.a;

import android.content.pm.ProviderInfo;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class b {
    private String a;
    private ProviderInfo b;
    private ArrayList<ProviderInfo> c;

    public void a(String str) {
        this.a = str;
    }

    public void a(ProviderInfo providerInfo) {
        this.b = providerInfo;
    }

    public ArrayList<ProviderInfo> a() {
        return this.c;
    }

    public void b(ProviderInfo providerInfo) {
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.add(providerInfo);
    }
}
