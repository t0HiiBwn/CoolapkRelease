package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.j;
import com.xiaomi.push.service.l;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

public class db extends j.a {
    private Context a;
    private SharedPreferences b;
    private l c;

    public db(Context context) {
        this.a = context;
        this.b = context.getSharedPreferences("mipush_extra", 0);
        this.c = l.a(context);
    }

    private List<gq> a(File file) {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileLock lock;
        ch b2 = ci.a().b();
        String a2 = b2 == null ? "" : b2.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (cn.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                jg.c(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    lock = randomAccessFile.getChannel().lock();
                } catch (Exception unused) {
                    fileInputStream = null;
                    try {
                        fileLock.release();
                    } catch (IOException unused2) {
                    }
                    jg.a(fileInputStream);
                    jg.a(randomAccessFile);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                    jg.a(fileInputStream);
                    jg.a(randomAccessFile);
                    throw th;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    while (true) {
                        try {
                            if (fileInputStream.read(bArr) != 4) {
                                break;
                            }
                            int a3 = d.a(bArr);
                            byte[] bArr2 = new byte[a3];
                            if (fileInputStream.read(bArr2) != a3) {
                                break;
                            }
                            byte[] a4 = cm.a(a2, bArr2);
                            if (!(a4 == null || a4.length == 0)) {
                                gq gqVar = new gq();
                                ht.a(gqVar, a4);
                                arrayList.add(gqVar);
                            }
                        } catch (Exception unused4) {
                            fileLock = lock;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            jg.a(fileInputStream);
                            jg.a(randomAccessFile);
                            return arrayList;
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = lock;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            jg.a(fileInputStream);
                            jg.a(randomAccessFile);
                            throw th;
                        }
                    }
                    if (lock != null) {
                        if (lock.isValid()) {
                            try {
                                lock.release();
                            } catch (IOException unused5) {
                            }
                        }
                    }
                    jg.a(fileInputStream);
                } catch (Exception unused6) {
                    fileInputStream = null;
                    fileLock = lock;
                    fileLock.release();
                    jg.a(fileInputStream);
                    jg.a(randomAccessFile);
                    return arrayList;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    fileLock = lock;
                    fileLock.release();
                    jg.a(fileInputStream);
                    jg.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
                fileLock.release();
                jg.a(fileInputStream);
                jg.a(randomAccessFile);
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                fileInputStream = null;
                fileLock.release();
                jg.a(fileInputStream);
                jg.a(randomAccessFile);
                throw th;
            }
            jg.a(randomAccessFile);
        }
        return arrayList;
    }

    private boolean b() {
        if (aa.e(this.a)) {
            return false;
        }
        if (!aa.g(this.a) || d()) {
            return (aa.h(this.a) && !c()) || aa.i(this.a);
        }
        return true;
    }

    private boolean c() {
        if (!this.c.a(gn.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.c.a(gn.Upload3GFrequency.a(), 432000)));
    }

    private boolean d() {
        if (!this.c.a(gn.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.b.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.c.a(gn.Upload4GFrequency.a(), 259200)));
    }

    private void e() {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    @Override // com.xiaomi.push.j.a
    public int a() {
        return 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!aa.d(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!b() && file.exists()) {
            List<gq> a2 = a(file);
            if (!e.a(a2)) {
                int size = a2.size();
                if (size > 4000) {
                    a2 = a2.subList(size - 4000, size);
                }
                hc hcVar = new hc();
                hcVar.a(a2);
                byte[] a3 = jg.a(ht.a(hcVar));
                hi hiVar = new hi("-1", false);
                hiVar.c(gs.DataCollection.S);
                hiVar.a(a3);
                ch b2 = ci.a().b();
                if (b2 != null) {
                    b2.a(hiVar, gi.Notification, null);
                }
                e();
            }
            file.delete();
        }
    }
}
