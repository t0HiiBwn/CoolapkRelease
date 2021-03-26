package com.loc;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* compiled from: CollectionUploader */
public final class cb {
    public static boolean a(byte[] bArr) {
        String str;
        if (bArr == null) {
            return false;
        }
        byte[] bArr2 = null;
        try {
            di diVar = new di();
            diVar.b.put("Content-Type", "application/octet-stream");
            diVar.b.put("aps_c_src", Base64.encodeToString(("lc_" + ((int) de.a())).getBytes(), 2));
            diVar.b.put("aps_c_key", Base64.encodeToString((de.c() + "*" + de.f()).getBytes(), 2));
            diVar.d = bArr;
            if (bs.a) {
                str = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            } else {
                str = (bs.b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            }
            diVar.a = str;
            dj a = cv.a().a(diVar);
            if (a != null && a.a == 200) {
                bArr2 = a.c;
            }
            return bArr2 != null && "true".equals(new String(bArr2, StandardCharsets.UTF_8));
        } catch (Exception e) {
            dg.a(e);
            return false;
        }
    }
}
