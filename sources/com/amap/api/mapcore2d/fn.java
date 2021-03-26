package com.amap.api.mapcore2d;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsPubDataStrategy */
public class fn extends fo {
    public fn() {
    }

    public fn(fo foVar) {
        super(foVar);
    }

    @Override // com.amap.api.mapcore2d.fo
    protected byte[] a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a = db.a(stringBuffer.toString());
        byte[] bArr2 = new byte[(a.length + bArr.length)];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(bArr, 0, bArr2, a.length, bArr.length);
        return bArr2;
    }
}
