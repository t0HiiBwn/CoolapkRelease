package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.l;
import java.io.File;

public class gd implements XMPushService.l {
    private static boolean a;
    private Context b;
    private boolean c;
    private int d;

    public gd(Context context) {
        this.b = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.b.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.c = l.a(context).a(gn.TinyDataUploadSwitch.a(), true);
        int a2 = l.a(context).a(gn.TinyDataUploadFrequency.a(), 7200);
        this.d = a2;
        this.d = Math.max(60, a2);
    }

    public static void a(boolean z) {
        a = z;
    }

    private boolean a(gh ghVar) {
        if (aa.c(this.b) && ghVar != null && !TextUtils.isEmpty(a(this.b.getPackageName())) && new File(this.b.getFilesDir(), "tiny_data.data").exists() && !a) {
            return !l.a(this.b).a(gn.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || gw.o(this.b) || gw.p(this.b);
        }
        return false;
    }

    private boolean b() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.b.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1)) > ((long) this.d);
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    public void a() {
        a(this.b);
        if (this.c && b()) {
            c.a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            gh a2 = gg.a(this.b).a();
            if (!a(a2)) {
                c.a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            ge.a(this.b, a2);
        }
    }
}
