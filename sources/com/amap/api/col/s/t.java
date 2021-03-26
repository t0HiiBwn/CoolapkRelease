package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;

/* compiled from: NearbyDeleteHandler */
public final class t extends b<String, Integer> {
    private Context j;
    private String k;

    public t(Context context, String str) {
        super(context, str);
        this.j = context;
        this.k = str;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bi.f(this.j));
        stringBuffer.append("&userid=");
        stringBuffer.append(this.k);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.cy
    public final String h() {
        return h.c() + "/nearby/data/delete";
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final /* synthetic */ Object a(String str) throws AMapException {
        return 0;
    }
}
