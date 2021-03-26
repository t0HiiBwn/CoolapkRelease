package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.an;
import java.io.File;

public class gx implements XMPushService.l {
    private static boolean a;

    /* renamed from: a  reason: collision with other field name */
    private int f533a;

    /* renamed from: a  reason: collision with other field name */
    private Context f534a;
    private boolean b;

    public gx(Context context) {
        this.f534a = context;
    }

    private String a(String str) {
        return "com.xiaomi.xmsf".equals(str) ? "1000271" : this.f534a.getSharedPreferences("pref_registered_pkg_names", 0).getString(str, null);
    }

    private void a(Context context) {
        this.b = an.a(context).a(hh.TinyDataUploadSwitch.a(), true);
        int a2 = an.a(context).a(hh.TinyDataUploadFrequency.a(), 7200);
        this.f533a = a2;
        this.f533a = Math.max(60, a2);
    }

    public static void a(boolean z) {
        a = z;
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a */
    private boolean mo385a() {
        return Math.abs((System.currentTimeMillis() / 1000) - this.f534a.getSharedPreferences("mipush_extra", 4).getLong("last_tiny_data_upload_timestamp", -1)) > ((long) this.f533a);
    }

    private boolean a(hb hbVar) {
        if (bc.b(this.f534a) && hbVar != null && !TextUtils.isEmpty(a(this.f534a.getPackageName())) && new File(this.f534a.getFilesDir(), "tiny_data.data").exists() && !a) {
            return !an.a(this.f534a).a(hh.ScreenOnOrChargingTinyDataUploadSwitch.a(), false) || i.m470a(this.f534a) || i.m473b(this.f534a);
        }
        return false;
    }

    @Override // com.xiaomi.push.service.XMPushService.l
    /* renamed from: a  reason: collision with other method in class */
    public void mo385a() {
        a(this.f534a);
        if (this.b && mo385a()) {
            b.m41a("TinyData TinyDataCacheProcessor.pingFollowUpAction ts:" + System.currentTimeMillis());
            hb a2 = ha.a(this.f534a).a();
            if (!a(a2)) {
                b.m41a("TinyData TinyDataCacheProcessor.pingFollowUpAction !canUpload(uploader) ts:" + System.currentTimeMillis());
                return;
            }
            a = true;
            gy.a(this.f534a, a2);
        }
    }
}
