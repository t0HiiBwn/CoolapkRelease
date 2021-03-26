package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.d;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.a.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class c {
    private static c a;
    private static final Object e = new Object();
    private static final String k = (".UTSystemConfig" + File.separator + "Global");

    /* renamed from: a  reason: collision with other field name */
    private com.ta.utdid2.b.a.c f91a = null;

    /* renamed from: a  reason: collision with other field name */
    private d f92a = null;
    private com.ta.utdid2.b.a.c b = null;

    /* renamed from: b  reason: collision with other field name */
    private Pattern f93b = Pattern.compile("[^0-9a-zA-Z=/+]+");
    private String h = null;
    private String i = "xx_utdid_key";
    private String j = "xx_utdid_domain";
    private Context mContext = null;

    private c(Context context) {
        this.mContext = context;
        this.b = new com.ta.utdid2.b.a.c(context, k, "Alvin2", false, true);
        this.f91a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f92a = new d();
        this.i = String.format("K_%d", Integer.valueOf(g.a(this.i)));
        this.j = String.format("D_%d", Integer.valueOf(g.a(this.j)));
    }

    private void c() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar != null) {
            if (g.m20a(cVar.getString("UTDID2"))) {
                String string = this.b.getString("UTDID");
                if (!g.m20a(string)) {
                    f(string);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!g.m20a(this.b.getString("DID"))) {
                this.b.remove("DID");
                z = true;
            }
            if (!g.m20a(this.b.getString("EI"))) {
                this.b.remove("EI");
                z = true;
            }
            if (!g.m20a(this.b.getString("SI"))) {
                this.b.remove("SI");
            } else {
                z2 = z;
            }
            if (z2) {
                this.b.commit();
            }
        }
    }

    public static c a(Context context) {
        if (context != null && a == null) {
            synchronized (e) {
                if (a == null) {
                    c cVar = new c(context);
                    a = cVar;
                    cVar.c();
                }
            }
        }
        return a;
    }

    private void f(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (cVar = this.b) != null) {
                cVar.putString("UTDID2", str);
                this.b.commit();
            }
        }
    }

    private void g(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (str != null && (cVar = this.f91a) != null && !str.equals(cVar.getString(this.i))) {
            this.f91a.putString(this.i, str);
            this.f91a.commit();
        }
    }

    private void h(String str) {
        if (f() && b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (!b(str2)) {
                    try {
                        Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    private void i(String str) {
        String str2;
        try {
            str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            str2 = null;
        }
        if (!str.equals(str2)) {
            try {
                Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
            } catch (Exception unused2) {
            }
        }
    }

    private void j(String str) {
        if (f() && str != null) {
            i(str);
        }
    }

    private String g() {
        com.ta.utdid2.b.a.c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        String string = cVar.getString("UTDID2");
        if (g.m20a(string) || this.f92a.c(string) == null) {
            return null;
        }
        return string;
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f93b.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String getValue() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        return h();
    }

    public synchronized String h() {
        String i2 = i();
        this.h = i2;
        if (!TextUtils.isEmpty(i2)) {
            return this.h;
        }
        try {
            byte[] c = m24c();
            if (c != null) {
                String encodeToString = b.encodeToString(c, 2);
                this.h = encodeToString;
                f(encodeToString);
                String c2 = this.f92a.c(c);
                if (c2 != null) {
                    j(c2);
                    g(c2);
                }
                return this.h;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public synchronized String i() {
        String str;
        String str2 = "";
        try {
            str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
        } catch (Exception unused) {
        }
        if (b(str2)) {
            return str2;
        }
        e eVar = new e();
        boolean z = false;
        try {
            str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused2) {
            str = null;
        }
        if (!g.m20a(str)) {
            String e2 = eVar.e(str);
            if (b(e2)) {
                h(e2);
                return e2;
            }
            String d = eVar.d(str);
            if (b(d)) {
                String c = this.f92a.c(d);
                if (!g.m20a(c)) {
                    j(c);
                    try {
                        str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                    } catch (Exception unused3) {
                    }
                }
            }
            String d2 = this.f92a.d(str);
            if (b(d2)) {
                this.h = d2;
                f(d2);
                g(str);
                h(this.h);
                return this.h;
            }
        } else {
            z = true;
        }
        String g = g();
        if (b(g)) {
            String c2 = this.f92a.c(g);
            if (z) {
                j(c2);
            }
            h(g);
            g(c2);
            this.h = g;
            return g;
        }
        String string = this.f91a.getString(this.i);
        if (!g.m20a(string)) {
            String d3 = eVar.d(string);
            if (!b(d3)) {
                d3 = this.f92a.d(string);
            }
            if (b(d3)) {
                String c3 = this.f92a.c(d3);
                if (!g.m20a(d3)) {
                    this.h = d3;
                    if (z) {
                        j(c3);
                    }
                    f(this.h);
                    return this.h;
                }
            }
        }
        return null;
    }

    /* renamed from: c  reason: collision with other method in class */
    private byte[] m24c() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] bytes = d.getBytes(currentTimeMillis);
        byte[] bytes2 = d.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = e.a(this.mContext);
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(d.getBytes(g.a(str)), 0, 4);
        byteArrayOutputStream.write(d.getBytes(g.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public static String b(byte[] bArr) throws Exception {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(f.a(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), instance.getAlgorithm()));
        return b.encodeToString(instance.doFinal(bArr), 2);
    }

    private boolean f() {
        return this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0;
    }
}
