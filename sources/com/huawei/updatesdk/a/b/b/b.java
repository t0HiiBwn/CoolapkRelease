package com.huawei.updatesdk.a.b.b;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.c.d;
import com.huawei.updatesdk.service.b.c;
import com.huawei.updatesdk.service.c.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

public class b extends AsyncTask<Void, Void, Void> {
    private HttpURLConnection a;
    private boolean b = false;
    private a c;
    private Handler d = new a();

    private static class a extends Handler {
        private a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.obj instanceof a) {
                a aVar = (a) message.obj;
                Intent intent = new Intent();
                com.huawei.updatesdk.a.b.c.b a = com.huawei.updatesdk.a.b.c.b.a(intent);
                int i = message.what;
                if (i != 2) {
                    if (i != 3) {
                        if (i == 4) {
                            g.a(b.d() + "/appmarket.apk", "com.huawei.appmarket");
                        } else if (i != 5) {
                            return;
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("download_status_param", message.what);
                    intent.putExtras(bundle);
                    c.a().a(a);
                    return;
                }
                intent.putExtra("download_apk_size", aVar.b());
                intent.putExtra("download_apk_already", aVar.a());
                c.a().b(a);
            }
        }
    }

    public b(a aVar) {
        this.c = aVar;
    }

    private void a(int i, long j, int i2) {
        a aVar = new a();
        aVar.a(i);
        aVar.a(j);
        Handler handler = this.d;
        if (handler != null) {
            handler.sendMessage(handler.obtainMessage(i2, aVar));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091 A[SYNTHETIC, Splitter:B:31:0x0091] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    private void a(a aVar, String str) {
        Throwable th;
        FileNotFoundException e;
        Exception e2;
        if (aVar != null && !TextUtils.isEmpty(aVar.c())) {
            String str2 = str + "/appmarket.apk";
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str2));
                try {
                    if (!a(aVar, fileOutputStream2, str2)) {
                        d.a(new File(d()));
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                        com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "Close FileOutputStream failed!");
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "DOWNLOAD market package FileNotFoundException error:" + e.toString());
                    if (fileOutputStream == null) {
                        return;
                    }
                    fileOutputStream.close();
                } catch (Exception e4) {
                    e2 = e4;
                    fileOutputStream = fileOutputStream2;
                    try {
                        com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "DOWNLOAD market package Exception error:" + e2.toString());
                        if (fileOutputStream == null) {
                            return;
                        }
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                                com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "Close FileOutputStream failed!");
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "DOWNLOAD market package FileNotFoundException error:" + e.toString());
                if (fileOutputStream == null) {
                }
                fileOutputStream.close();
            } catch (Exception e6) {
                e2 = e6;
                com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "DOWNLOAD market package Exception error:" + e2.toString());
                if (fileOutputStream == null) {
                }
                fileOutputStream.close();
            }
        }
    }

    private void a(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e.toString());
            }
        }
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e2) {
                com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e2.toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.huawei.updatesdk.a.b.b.b, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v1, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r20.b != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001a, code lost:
        if (r20.b != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        a(0, -1, 5);
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0130  */
    /* JADX WARNING: Unknown variable types count: 3 */
    private boolean a(a aVar, OutputStream outputStream, String str) {
        ?? r10;
        int i;
        Throwable th;
        ?? r102;
        boolean z;
        Exception e;
        BufferedInputStream bufferedInputStream;
        OutputStream outputStream2;
        BufferedInputStream bufferedInputStream2;
        Throwable th2;
        OutputStream outputStream3;
        int i2 = 3;
        BufferedInputStream bufferedInputStream3 = null;
        boolean z2 = false;
        long j = -1;
        try {
            HttpURLConnection a2 = c.a().a(aVar.c());
            this.a = a2;
            if (a2 != null) {
                a2.connect();
                int responseCode = this.a.getResponseCode();
                if (200 == responseCode || 206 == responseCode) {
                    j = aVar.b();
                    try {
                        bufferedInputStream2 = new BufferedInputStream(this.a.getInputStream(), 8192);
                        try {
                            ?? bufferedOutputStream = new BufferedOutputStream(outputStream, 8192);
                            try {
                                byte[] bArr = new byte[8192];
                                long j2 = 0;
                                i = 0;
                                while (true) {
                                    try {
                                        int read = bufferedInputStream2.read(bArr);
                                        if (read != -1) {
                                            try {
                                                bufferedOutputStream.write(bArr, 0, read);
                                                i += read;
                                                if (Math.abs(System.currentTimeMillis() - j2) > 1000) {
                                                    j2 = System.currentTimeMillis();
                                                    if (((long) i) != j) {
                                                        a(i, j, 2);
                                                    }
                                                }
                                                bufferedInputStream3 = null;
                                            } catch (Throwable th3) {
                                                th2 = th3;
                                                bufferedInputStream3 = null;
                                                outputStream2 = bufferedOutputStream;
                                                a(bufferedInputStream2, outputStream2);
                                                try {
                                                    throw th2;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    bufferedInputStream = bufferedInputStream3;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    r10 = bufferedInputStream3;
                                                    if (!z2) {
                                                    }
                                                    a(bufferedInputStream3, r10);
                                                    com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                                    e();
                                                    throw th;
                                                }
                                            }
                                        } else {
                                            try {
                                                break;
                                            } catch (Exception e3) {
                                                e = e3;
                                                bufferedInputStream3 = bufferedInputStream2;
                                                bufferedInputStream = bufferedOutputStream;
                                                z = false;
                                                r102 = bufferedInputStream;
                                                try {
                                                    com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e.toString());
                                                    if (!z) {
                                                    }
                                                    a(bufferedInputStream3, r102);
                                                    com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                                    e();
                                                    return false;
                                                } catch (Throwable th5) {
                                                    th = th5;
                                                    z2 = z;
                                                    r10 = r102;
                                                    if (!z2) {
                                                    }
                                                    a(bufferedInputStream3, r10);
                                                    com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                                    e();
                                                    throw th;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                                bufferedInputStream3 = bufferedInputStream2;
                                                r10 = bufferedOutputStream;
                                                if (!z2) {
                                                }
                                                a(bufferedInputStream3, r10);
                                                com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                                e();
                                                throw th;
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th2 = th7;
                                        outputStream2 = bufferedOutputStream;
                                        a(bufferedInputStream2, outputStream2);
                                        throw th2;
                                    }
                                }
                                a(bufferedInputStream2, bufferedOutputStream);
                                if (((long) i) == j && j > 0) {
                                    try {
                                        if (!TextUtils.isEmpty(aVar.d()) && aVar.d().equalsIgnoreCase(d.a(str, "SHA-256"))) {
                                            z = true;
                                            if (z) {
                                                try {
                                                    a(i, j, 4);
                                                } catch (Exception e4) {
                                                    e = e4;
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    z2 = z;
                                                    bufferedInputStream3 = null;
                                                    r10 = 0;
                                                    if (!z2) {
                                                    }
                                                    a(bufferedInputStream3, r10);
                                                    com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                                    e();
                                                    throw th;
                                                }
                                            }
                                            if (!z) {
                                                if (!this.b) {
                                                    i2 = 5;
                                                }
                                                a(i, j, i2);
                                            }
                                            a(null, null);
                                            com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                            e();
                                            return z;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        z = false;
                                        bufferedInputStream3 = null;
                                        r102 = 0;
                                        com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e.toString());
                                        if (!z) {
                                            if (!this.b) {
                                                i2 = 5;
                                            }
                                            a(i, j, i2);
                                        }
                                        a(bufferedInputStream3, r102);
                                        com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                        e();
                                        return false;
                                    } catch (Throwable th9) {
                                        th = th9;
                                        bufferedInputStream3 = null;
                                        r10 = 0;
                                        if (!z2) {
                                            if (!this.b) {
                                                i2 = 5;
                                            }
                                            a(i, j, i2);
                                        }
                                        a(bufferedInputStream3, r10);
                                        com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                        e();
                                        throw th;
                                    }
                                }
                                z = false;
                                if (z) {
                                }
                                if (!z) {
                                }
                                a(null, null);
                                com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
                                e();
                                return z;
                            } catch (Throwable th10) {
                                th2 = th10;
                                outputStream3 = bufferedOutputStream;
                                i = 0;
                                outputStream2 = outputStream3;
                                a(bufferedInputStream2, outputStream2);
                                throw th2;
                            }
                        } catch (Throwable th11) {
                            th2 = th11;
                            outputStream3 = null;
                            i = 0;
                            outputStream2 = outputStream3;
                            a(bufferedInputStream2, outputStream2);
                            throw th2;
                        }
                    } catch (Throwable th12) {
                        th2 = th12;
                        bufferedInputStream2 = null;
                        outputStream3 = null;
                        i = 0;
                        outputStream2 = outputStream3;
                        a(bufferedInputStream2, outputStream2);
                        throw th2;
                    }
                }
            }
            a(0, -1, 3);
            a(null, null);
            com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
            e();
            return false;
        } catch (Exception e6) {
            e = e6;
            r102 = 0;
            z = false;
            i = 0;
            com.huawei.updatesdk.a.a.b.a.a.a.d("DownloadMarketTask", "downloadUrlToStream(String urlString,OutputStream outputStream) " + e.toString());
            if (!z) {
            }
            a(bufferedInputStream3, r102);
            com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
            e();
            return false;
        } catch (Throwable th13) {
            th = th13;
            r10 = 0;
            i = 0;
            if (!z2) {
            }
            a(bufferedInputStream3, r10);
            com.huawei.updatesdk.service.d.a.b.a().remove((Object) this);
            e();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public static String d() {
        String c2 = com.huawei.updatesdk.a.b.a.a.a().c();
        if (TextUtils.isEmpty(c2)) {
            return "";
        }
        String str = c2 + "/updatesdk";
        File file = new File(str);
        return (file.exists() || file.mkdirs()) ? str : "";
    }

    private void e() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        com.huawei.updatesdk.service.d.a.b.a(this);
        a(this.c, d());
        return null;
    }

    public void a() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
            this.b = true;
        }
        d.a(new File(d()));
    }

    public void b() {
        this.d = null;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        a();
    }
}
