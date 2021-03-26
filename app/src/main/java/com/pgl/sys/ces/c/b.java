package com.pgl.sys.ces.c;

import android.content.Context;
import com.pgl.a.a.a;
import com.pgl.sys.ces.a.c;

public class b extends com.pgl.a.a.b {
    private Context b = null;

    public b(Context context, String str) {
        super(context, str);
        this.b = context;
        this.a = a.a() + "/v2/s" + a();
    }

    public String a() {
        String str;
        try {
            str = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
        return ((("?os=0&ver=0.6.11.30.08-PGL-Do-fix3&m=2&app_ver=" + str) + "&region=" + c.c(this.b)) + "&appkey=" + com.pgl.sys.ces.b.b()) + "&did=" + com.pgl.sys.ces.b.c();
    }

    @Override // com.pgl.a.a.b
    public boolean a(int i, byte[] bArr) {
        String str;
        boolean z = true;
        if (i == 200 && bArr != null) {
            try {
                if (bArr.length > 0 && (str = (String) com.pgl.sys.ces.a.meta(200, this.b, bArr)) != null && str.length() > 0) {
                    if (str.equalsIgnoreCase("AYE")) {
                        com.pgl.sys.ces.b.d = true;
                        return z;
                    }
                    com.pgl.sys.ces.b.d = false;
                }
            } catch (Throwable unused) {
                com.pgl.sys.ces.b.d = false;
                return false;
            }
        }
        z = false;
        return z;
    }
}
