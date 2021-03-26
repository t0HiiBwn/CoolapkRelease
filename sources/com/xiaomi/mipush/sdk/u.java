package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.a.a.a.c;
import com.xiaomi.push.aa;
import com.xiaomi.push.ce;
import com.xiaomi.push.jg;
import java.io.File;
import java.util.HashMap;

final class u implements Runnable {
    final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f160a;

    u(Context context, boolean z) {
        this.a = context;
        this.f160a = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() {
        File file;
        Throwable th;
        String str;
        File file2 = null;
        try {
            HashMap<String, String> a2 = ac.a(this.a, "");
            if (this.f160a) {
                str = this.a.getFilesDir().getAbsolutePath();
            } else {
                str = this.a.getExternalFilesDir(null).getAbsolutePath() + ce.a;
            }
            File logFile = Logger.getLogFile(str);
            if (logFile == null) {
                c.a("log file null");
                return;
            }
            file = new File(str, this.a.getPackageName() + ".zip");
            try {
                jg.a(file, logFile);
                if (file.exists()) {
                    aa.a((this.f160a ? "https://api.xmpush.xiaomi.com/upload/xmsf_log?file=" : "https://api.xmpush.xiaomi.com/upload/app_log?file=") + file.getName(), a2, file, "file");
                } else {
                    c.a("zip log file failed");
                }
            } catch (Throwable th2) {
                th = th2;
                file2 = file;
                c.a(th);
                file = file2;
                if (file == null) {
                }
            }
            if (file == null && file.exists()) {
                file.delete();
            }
        } catch (Throwable th3) {
            th = th3;
            c.a(th);
            file = file2;
            if (file == null) {
            }
        }
    }
}
