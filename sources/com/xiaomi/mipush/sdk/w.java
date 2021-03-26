package com.xiaomi.mipush.sdk;

import com.xiaomi.a.a.a.c;
import com.xiaomi.push.aa;
import com.xiaomi.push.jg;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class w implements Runnable {
    final /* synthetic */ v a;

    w(v vVar) {
        this.a = vVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0108 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() {
        File file;
        IOException e;
        File file2 = null;
        try {
            ArrayList<File> a2 = s.a(v.a(this.a)).a();
            if (a2 != null) {
                if (a2.size() >= 1) {
                    HashMap<String, String> a3 = ac.a(v.a(this.a), "C100000");
                    int i = 0;
                    while (i < a2.size()) {
                        File file3 = a2.get(i);
                        String a4 = s.a(v.a(this.a)).a(file3);
                        file = new File(v.a(this.a).getFilesDir() + "/crash/" + file3.getName() + ".zip");
                        try {
                            jg.a(file, file3);
                            if (file.exists()) {
                                aa.a("https://api.xmpush.xiaomi.com/upload/crash_log?file=" + file.getName(), a3, file, "file");
                                file3.renameTo(new File(v.a(this.a).getFilesDir() + "/crash", a4 + ":0"));
                                v.a(this.a);
                            } else {
                                c.a("zip crash file failed");
                            }
                            i++;
                            file2 = file;
                        } catch (IOException e2) {
                            e = e2;
                            c.a(e);
                            file2 = file;
                            c.a("delete zip crash file failed");
                            synchronized (v.a()) {
                            }
                        } catch (Throwable unused) {
                            file2 = file;
                            c.a("delete zip crash file failed");
                            synchronized (v.a()) {
                            }
                        }
                    }
                    if (file2 != null && file2.exists() && !file2.delete()) {
                        c.a("delete zip crash file failed");
                    }
                    synchronized (v.a()) {
                        v.a().notifyAll();
                    }
                    return;
                }
            }
            c.a("no crash file to upload");
        } catch (IOException e3) {
            file = null;
            e = e3;
            c.a(e);
            file2 = file;
        } catch (Throwable unused2) {
        }
    }
}
