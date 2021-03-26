package com.huawei.hms.update.a;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.a.a.a;
import com.huawei.hms.update.a.a.c;
import com.huawei.hms.update.b.b;
import com.huawei.hms.update.provider.UpdateProvider;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.FileUtil;
import com.huawei.hms.utils.IOUtils;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: UpdateDownload */
public class d implements a {
    private final Context a;
    private final com.huawei.hms.update.b.d b = new b();
    private final a c = new a();
    private com.huawei.hms.update.a.a.b d;
    private File e;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    private synchronized void a(com.huawei.hms.update.a.a.b bVar) {
        this.d = bVar;
    }

    /* access modifiers changed from: private */
    public synchronized void a(int i, int i2, int i3) {
        com.huawei.hms.update.a.a.b bVar = this.d;
        if (bVar != null) {
            bVar.a(i, i2, i3, this.e);
        }
    }

    public Context b() {
        return this.a;
    }

    @Override // com.huawei.hms.update.a.a.a
    public void a() {
        HMSLog.i("UpdateDownload", "Enter cancel.");
        a((com.huawei.hms.update.a.a.b) null);
        this.b.b();
    }

    @Override // com.huawei.hms.update.a.a.a
    public void a(com.huawei.hms.update.a.a.b bVar, c cVar) {
        Checker.checkNonNull(bVar, "callback must not be null.");
        HMSLog.i("UpdateDownload", "Enter downloadPackage.");
        a(bVar);
        if (cVar == null || !cVar.a()) {
            HMSLog.e("UpdateDownload", "In downloadPackage, Invalid update info.");
            a(2201, 0, 0);
        } else if (!"mounted".equals(Environment.getExternalStorageState())) {
            HMSLog.e("UpdateDownload", "In downloadPackage, Invalid external storage for downloading file.");
            a(2204, 0, 0);
        } else {
            String str = cVar.b;
            if (TextUtils.isEmpty(str)) {
                HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
                a(2201, 0, 0);
                return;
            }
            Context context = this.a;
            File localFile = UpdateProvider.getLocalFile(context, str + ".apk");
            this.e = localFile;
            if (localFile == null) {
                HMSLog.e("UpdateDownload", "In downloadPackage, Failed to get local file for downloading.");
                a(2204, 0, 0);
                return;
            }
            File parentFile = localFile.getParentFile();
            if (parentFile == null || (!parentFile.mkdirs() && !parentFile.isDirectory())) {
                HMSLog.e("UpdateDownload", "In downloadPackage, Failed to create directory for downloading file.");
                a(2201, 0, 0);
            } else if (parentFile.getUsableSpace() < ((long) (cVar.d * 3))) {
                HMSLog.e("UpdateDownload", "In downloadPackage, No space for downloading file.");
                a(2203, 0, 0);
            } else {
                try {
                    a(cVar);
                } catch (com.huawei.hms.update.b.a unused) {
                    HMSLog.w("UpdateDownload", "In downloadPackage, Canceled to download the update file.");
                    a(2101, 0, 0);
                }
            }
        }
    }

    void a(c cVar) throws com.huawei.hms.update.b.a {
        HMSLog.i("UpdateDownload", "Enter downloadPackage.");
        b bVar = null;
        try {
            String str = cVar.b;
            if (TextUtils.isEmpty(str)) {
                HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package,  packageName is null: ");
                a(2201, 0, 0);
            } else {
                this.c.a(b(), str);
                if (!this.c.b(cVar.c, cVar.d, cVar.e)) {
                    this.c.a(cVar.c, cVar.d, cVar.e);
                    bVar = a(this.e, cVar.d, str);
                } else if (this.c.b() != this.c.a()) {
                    bVar = a(this.e, cVar.d, str);
                    bVar.a((long) this.c.b());
                } else if (FileUtil.verifyHash(cVar.e, this.e)) {
                    a(2000, 0, 0);
                } else {
                    this.c.a(cVar.c, cVar.d, cVar.e);
                    bVar = a(this.e, cVar.d, str);
                }
                int a2 = this.b.a(cVar.c, bVar, this.c.b(), this.c.a(), this.a);
                if (a2 != 200 && a2 != 206) {
                    HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Download the package, HTTP code: " + a2);
                    a(2201, 0, 0);
                } else if (!FileUtil.verifyHash(cVar.e, this.e)) {
                    a(2202, 0, 0);
                } else {
                    a(2000, 0, 0);
                    this.b.a();
                    IOUtils.closeQuietly((OutputStream) bVar);
                    return;
                }
            }
            this.b.a();
            IOUtils.closeQuietly((OutputStream) bVar);
        } catch (IOException e2) {
            HMSLog.e("UpdateDownload", "In DownloadHelper.downloadPackage, Failed to download." + e2.getMessage());
            a(2201, 0, 0);
        } catch (Throwable th) {
            this.b.a();
            IOUtils.closeQuietly((OutputStream) null);
            throw th;
        }
    }

    private b a(File file, final int i, final String str) throws IOException {
        return new b(file, i) {
            /* class com.huawei.hms.update.a.d.AnonymousClass1 */
            private long d = 0;
            private int e;

            {
                this.e = d.this.c.b();
            }

            @Override // com.huawei.hms.update.a.b, java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) throws IOException {
                super.write(bArr, i, i2);
                int i3 = this.e + i2;
                this.e = i3;
                if (i3 <= 209715200) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Math.abs(currentTimeMillis - this.d) > 1000) {
                        this.d = currentTimeMillis;
                        a(this.e);
                    }
                    int i4 = this.e;
                    if (i4 == i) {
                        a(i4);
                    }
                }
            }

            private void a(int i) {
                d.this.c.a(d.this.b(), i, str);
                d.this.a(2100, i, i);
            }
        };
    }
}
