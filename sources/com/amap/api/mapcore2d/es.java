package com.amap.api.mapcore2d;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class es extends ew {
    protected Context a;
    protected da b;

    public abstract byte[] b();

    public abstract byte[] c();

    protected String d() {
        return "2.1";
    }

    public boolean e() {
        return true;
    }

    protected boolean k() {
        return false;
    }

    public es(Context context, da daVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = daVar;
    }

    @Override // com.amap.api.mapcore2d.ew
    public Map<String, String> g() {
        String f = cq.f(this.a);
        String a2 = ct.a();
        Context context = this.a;
        String a3 = ct.a(context, a2, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.amap.api.mapcore2d.ew
    public final byte[] a_() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(q());
            byteArrayOutputStream.write(i());
            byteArrayOutputStream.write(r());
            byteArrayOutputStream.write(s());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                dl.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            dl.a(th2, "bre", "geb");
            return null;
        }
    }

    private byte[] q() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(db.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                dl.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            dl.a(th2, "bre", "gbh");
            return null;
        }
    }

    public byte[] i() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (e()) {
                byte[] a2 = ct.a(this.a, k());
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a3 = db.a(d());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = db.a(j());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a4));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                dl.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            dl.a(th2, "bre", "gred");
        }
        return new byte[]{0};
    }

    public String j() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.c(), this.b.a());
    }

    protected byte[] a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    private byte[] r() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] b2 = b();
            if (b2 != null) {
                if (b2.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(b2));
                    byteArrayOutputStream.write(b2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        dl.a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                dl.a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            dl.a(th3, "bre", "grrd");
        }
        return new byte[]{0};
    }

    private byte[] s() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c = c();
            if (c != null) {
                if (c.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a2 = ct.a(this.a, c);
                    byteArrayOutputStream.write(a(a2));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        dl.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                dl.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            dl.a(th3, "bre", "gred");
        }
        return new byte[]{0};
    }
}
