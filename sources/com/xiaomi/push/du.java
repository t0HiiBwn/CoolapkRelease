package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.xiaomi.push.service.an;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;

public class du extends ai.a {
    private Context a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f322a;

    /* renamed from: a  reason: collision with other field name */
    private an f323a;

    public du(Context context) {
        this.a = context;
        this.f322a = context.getSharedPreferences("mipush_extra", 0);
        this.f323a = an.a(context);
    }

    private List<hk> a(File file) {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileLock lock;
        dg a2 = dh.a().m199a();
        String a3 = a2 == null ? "" : a2.a();
        FileLock fileLock = null;
        if (TextUtils.isEmpty(a3)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        synchronized (dm.a) {
            try {
                File file2 = new File(this.a.getExternalFilesDir(null), "push_cdata.lock");
                y.m681a(file2);
                randomAccessFile = new RandomAccessFile(file2, "rw");
                try {
                    lock = randomAccessFile.getChannel().lock();
                } catch (Exception unused) {
                    fileInputStream = null;
                    try {
                        fileLock.release();
                    } catch (IOException unused2) {
                    }
                    y.a(fileInputStream);
                    y.a(randomAccessFile);
                    return arrayList;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                    y.a(fileInputStream);
                    y.a(randomAccessFile);
                    throw th;
                }
                try {
                    fileInputStream = new FileInputStream(file);
                    while (true) {
                        try {
                            if (fileInputStream.read(bArr) != 4) {
                                break;
                            }
                            int a4 = ac.a(bArr);
                            byte[] bArr2 = new byte[a4];
                            if (fileInputStream.read(bArr2) != a4) {
                                break;
                            }
                            byte[] a5 = dl.a(a3, bArr2);
                            if (!(a5 == null || a5.length == 0)) {
                                hk hkVar = new hk();
                                im.a(hkVar, a5);
                                arrayList.add(hkVar);
                                a(hkVar);
                            }
                        } catch (Exception unused4) {
                            fileLock = lock;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            y.a(fileInputStream);
                            y.a(randomAccessFile);
                            return arrayList;
                        } catch (Throwable th3) {
                            th = th3;
                            fileLock = lock;
                            if (fileLock != null && fileLock.isValid()) {
                                fileLock.release();
                            }
                            y.a(fileInputStream);
                            y.a(randomAccessFile);
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
                    y.a(fileInputStream);
                } catch (Exception unused6) {
                    fileInputStream = null;
                    fileLock = lock;
                    fileLock.release();
                    y.a(fileInputStream);
                    y.a(randomAccessFile);
                    return arrayList;
                } catch (Throwable th4) {
                    th = th4;
                    fileInputStream = null;
                    fileLock = lock;
                    fileLock.release();
                    y.a(fileInputStream);
                    y.a(randomAccessFile);
                    throw th;
                }
            } catch (Exception unused7) {
                randomAccessFile = null;
                fileInputStream = null;
                fileLock.release();
                y.a(fileInputStream);
                y.a(randomAccessFile);
                return arrayList;
            } catch (Throwable th5) {
                th = th5;
                randomAccessFile = null;
                fileInputStream = null;
                fileLock.release();
                y.a(fileInputStream);
                y.a(randomAccessFile);
                throw th;
            }
            y.a(randomAccessFile);
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    private void mo141a() {
        SharedPreferences.Editor edit = this.f322a.edit();
        edit.putLong("last_upload_data_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private void a(hk hkVar) {
        if (hkVar.f567a == he.AppInstallList && !hkVar.f568a.startsWith("same_")) {
            SharedPreferences.Editor edit = this.f322a.edit();
            edit.putLong("dc_job_result_time_4", hkVar.f566a);
            edit.putString("dc_job_result_4", bi.a(hkVar.f568a));
            edit.commit();
        }
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    private boolean mo209a() {
        if (bc.d(this.a)) {
            return false;
        }
        if ((bc.f(this.a) || bc.e(this.a)) && !c()) {
            return true;
        }
        return (bc.g(this.a) && !b()) || bc.h(this.a);
    }

    private boolean b() {
        if (!this.f323a.a(hh.Upload3GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f322a.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.f323a.a(hh.Upload3GFrequency.a(), 432000)));
    }

    private boolean c() {
        if (!this.f323a.a(hh.Upload4GSwitch.a(), true)) {
            return false;
        }
        return Math.abs((System.currentTimeMillis() / 1000) - this.f322a.getLong("last_upload_data_timestamp", -1)) > ((long) Math.max(86400, this.f323a.a(hh.Upload4GFrequency.a(), 259200)));
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a  reason: collision with other method in class */
    public String mo210a() {
        return "1";
    }

    @Override // java.lang.Runnable
    public void run() {
        File file = new File(this.a.getExternalFilesDir(null), "push_cdata.data");
        if (!bc.c(this.a)) {
            if (file.length() > 1863680) {
                file.delete();
            }
        } else if (!mo209a() && file.exists()) {
            List<hk> a2 = a(file);
            if (!ad.a(a2)) {
                int size = a2.size();
                if (size > 4000) {
                    a2 = a2.subList(size - 4000, size);
                }
                hv hvVar = new hv();
                hvVar.a(a2);
                byte[] a3 = y.a(im.a(hvVar));
                ib ibVar = new ib("-1", false);
                ibVar.c(hm.DataCollection.f576a);
                ibVar.a(a3);
                dg a4 = dh.a().m199a();
                if (a4 != null) {
                    a4.a(ibVar, hc.Notification, null);
                }
                mo141a();
            }
            file.delete();
        }
    }
}
