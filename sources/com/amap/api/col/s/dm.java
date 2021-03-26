package com.amap.api.col.s;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/* compiled from: StatisticsPubDataStrategy */
public final class dm extends dn {
    public dm() {
    }

    public dm(dn dnVar) {
        super(dnVar);
    }

    @Override // com.amap.api.col.s.dn
    protected final byte[] a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new SimpleDateFormat("yyyyMMdd HHmmss").format(new Date()));
        stringBuffer.append(" ");
        stringBuffer.append(UUID.randomUUID().toString());
        stringBuffer.append(" ");
        if (stringBuffer.length() != 53) {
            return new byte[0];
        }
        byte[] a = bs.a(stringBuffer.toString());
        byte[] bArr2 = new byte[(a.length + bArr.length)];
        System.arraycopy(a, 0, bArr2, 0, a.length);
        System.arraycopy(bArr, 0, bArr2, a.length, bArr.length);
        return bArr2;
    }
}
