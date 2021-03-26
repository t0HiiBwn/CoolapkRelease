package com.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class ar extends q {
    protected Context a;
    protected t b;

    public ar(Context context, t tVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = tVar;
    }

    private static byte[] q() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(u.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                y.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            y.a(th2, "bre", "gbh");
            return null;
        }
    }

    private byte[] r() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (j()) {
                Context context = this.a;
                boolean l = l();
                t tVar = this.b;
                byte[] a2 = m.a(context, l, tVar != null && "navi".equals(tVar.a()));
                byteArrayOutputStream.write(u.a(a2.length));
                byteArrayOutputStream.write(a2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a3 = u.a(g());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(u.a(a3.length));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = u.a(k());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(u.a(a4.length));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                y.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            y.a(th2, "bre", "gred");
        }
        return new byte[]{0};
    }

    private byte[] s() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] a_ = a_();
            if (a_ != null) {
                if (a_.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(u.a(a_.length));
                    byteArrayOutputStream.write(a_);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        y.a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                y.a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            y.a(th3, "bre", "grrd");
        }
        return new byte[]{0};
    }

    private byte[] t() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] f = f();
            if (f != null) {
                if (f.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a2 = o.a(f);
                    byteArrayOutputStream.write(u.a(a2.length));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        y.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                y.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            y.a(th3, "bre", "gred");
        }
        return new byte[]{0};
    }

    public abstract byte[] a_();

    @Override // com.loc.av
    public Map<String, String> b_() {
        String f = k.f(this.a);
        String a2 = m.a();
        Context context = this.a;
        String a3 = m.a(context, a2, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    @Override // com.loc.av
    public final byte[] e() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(q());
            byteArrayOutputStream.write(r());
            byteArrayOutputStream.write(s());
            byteArrayOutputStream.write(t());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                y.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            y.a(th2, "bre", "geb");
            return null;
        }
    }

    public abstract byte[] f();

    protected String g() {
        return "2.1";
    }

    public boolean j() {
        return true;
    }

    public String k() {
        return String.format("platform=Android&sdkversion=%s&product=%s", this.b.c(), this.b.a());
    }

    protected boolean l() {
        return false;
    }
}
