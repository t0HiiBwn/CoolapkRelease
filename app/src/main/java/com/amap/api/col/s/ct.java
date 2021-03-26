package com.amap.api.col.s;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class ct extends bp {
    protected Context a;
    protected br b;

    public abstract byte[] d();

    protected String i() {
        return "2.1";
    }

    public ct(Context context, br brVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = brVar;
    }

    @Override // com.amap.api.col.s.cy
    public final Map<String, String> e() {
        String f = bi.f(this.a);
        String a2 = bl.a();
        String a3 = bl.a(this.a, a2, "key=".concat(String.valueOf(f)));
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.amap.api.col.s.cy
    public final byte[] g() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(p());
            byteArrayOutputStream.write(q());
            byteArrayOutputStream.write(r());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                cd.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            cd.a(th2, "bre", "geb");
            return null;
        }
    }

    private static byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bs.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                cd.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            cd.a(th2, "bre", "gbh");
            return null;
        }
    }

    private byte[] p() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            Context context = this.a;
            br brVar = this.b;
            byte[] a2 = bl.a(context, brVar != null && "navi".equals(brVar.b()));
            byteArrayOutputStream.write(bs.a(a2.length));
            byteArrayOutputStream.write(a2);
            byte[] a3 = bs.a(i());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(bs.a(a3.length));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = bs.a(l());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(bs.a(a4.length));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                cd.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            cd.a(th2, "bre", "gred");
        }
        return new byte[]{0};
    }

    public final String l() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.d(), this.b.b());
    }

    private static byte[] q() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                cd.a(th, "bre", "grrd");
            }
            return byteArray;
        } catch (Throwable th2) {
            cd.a(th2, "bre", "grrd");
        }
        return new byte[]{0};
    }

    private byte[] r() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d = d();
            if (d != null) {
                if (d.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a2 = bn.a(d);
                    byteArrayOutputStream.write(bs.a(a2.length));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        cd.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                cd.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            cd.a(th3, "bre", "gred");
        }
        return new byte[]{0};
    }
}
