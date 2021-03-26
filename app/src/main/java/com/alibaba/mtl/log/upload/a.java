package com.alibaba.mtl.log.upload;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.mtl.log.a.c;
import com.alibaba.mtl.log.a.d;
import com.alibaba.mtl.log.d.a;
import com.alibaba.mtl.log.d.e;
import com.alibaba.mtl.log.d.i;
import com.alibaba.mtl.log.d.k;
import com.alibaba.mtl.log.d.l;
import com.alibaba.mtl.log.d.n;
import com.alibaba.mtl.log.d.t;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

/* compiled from: UploadTask */
public abstract class a implements Runnable {
    static int B;
    private static volatile boolean G;
    private static boolean H;
    int C = -1;
    int D = 0;
    float a = 200.0f;

    public abstract void H();

    public abstract void I();

    @Override // java.lang.Runnable
    public void run() {
        try {
            J();
            H();
        } catch (Throwable unused) {
        }
    }

    public static boolean isRunning() {
        return G;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01fa, code lost:
        com.alibaba.mtl.log.upload.a.G = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01fd, code lost:
        com.alibaba.mtl.log.upload.a.G = false;
     */
    private void J() {
        List<com.alibaba.mtl.log.model.a> list;
        int i;
        String str;
        String str2;
        i.a("UploadTask", "Upload");
        if (!com.alibaba.mtl.log.a.f53s) {
            i.a("UploadTask", "Upload is disabled");
        } else if (l.isConnected() && !H && !G) {
            G = true;
            Map<String, c> b = d.a().b();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= 3) {
                    break;
                } else if (!k.c(com.alibaba.mtl.log.a.getContext())) {
                    i.a("UploadTask", "Other Process is Uploading, break");
                    break;
                } else {
                    com.alibaba.mtl.log.c.c.a().F();
                    if (b != null && b.size() > 0) {
                        List<com.alibaba.mtl.log.model.a> list2 = null;
                        while (true) {
                            if (i2 >= b.size()) {
                                list = list2;
                                i = i2;
                                str = null;
                                break;
                            }
                            c cVar = b.get(i2 + "");
                            if (cVar.a == null || cVar.a.size() <= 0) {
                                str2 = null;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("eventId");
                                sb.append(" in (");
                                for (int i4 = 0; i4 < cVar.a.size(); i4++) {
                                    if (i4 != 0) {
                                        sb.append(" , ");
                                    }
                                    sb.append(cVar.a.get(i4));
                                }
                                sb.append(" ) ");
                                str2 = sb.toString();
                            }
                            list = com.alibaba.mtl.log.c.c.a().a(str2, h());
                            if (list.size() > 0) {
                                String str3 = cVar.Q;
                                i = i2;
                                str = str3;
                                break;
                            }
                            i2++;
                            list2 = list;
                        }
                    } else {
                        i = i2;
                        str = null;
                        list = null;
                    }
                    if (list == null || (list != null && list.size() == 0)) {
                        list = com.alibaba.mtl.log.c.c.a().a((String) null, h());
                    }
                    if (list == null || list.size() == 0) {
                        break;
                    }
                    int b2 = b(list);
                    Map<String, Object> a2 = a(list);
                    if (a2 == null || a2.size() == 0) {
                        break;
                    }
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        String g = com.alibaba.mtl.log.a.a.g();
                        if (!TextUtils.isEmpty(str)) {
                            g = "http://" + str + "/rest/sur";
                        }
                        a.C0013a a3 = a(t.a(g, null, a2), a2);
                        boolean z = a3.I;
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        long j = elapsedRealtime2 - elapsedRealtime;
                        a(Boolean.valueOf(z), j);
                        if (!z) {
                            com.alibaba.mtl.log.b.a.d(list.size() - b2);
                            com.alibaba.mtl.log.b.a.t();
                            if (!a3.g()) {
                                if (a3.h()) {
                                    H = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            int a4 = com.alibaba.mtl.log.c.c.a().a(list);
                            if (a4 < list.size() - b2) {
                                I();
                            }
                            com.alibaba.mtl.log.b.a.a(list, a4);
                            com.alibaba.mtl.log.b.a.s();
                        }
                        long elapsedRealtime3 = SystemClock.elapsedRealtime();
                        i.a("UploadTask", "logs.size():", Integer.valueOf(list.size()), " selfMonitorLogCount:", Integer.valueOf(b2));
                        i.a("UploadTask", "upload isSendSuccess:", Boolean.valueOf(z), " consume:", Long.valueOf(j), " delete consume:", Long.valueOf(elapsedRealtime3 - elapsedRealtime2));
                        try {
                            Thread.sleep((long) new Random().nextInt(5000));
                        } catch (Throwable th) {
                            i.a("UploadTask", "thread sleep interrupted", th);
                        }
                    } catch (Throwable unused) {
                    }
                    k.release();
                    i3++;
                    i2 = i;
                }
            }
            k.release();
            G = false;
            k.release();
        }
    }

    private int b(List<com.alibaba.mtl.log.model.a> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2).T;
            if (str != null && "6005".equalsIgnoreCase(str.toString())) {
                i++;
            }
        }
        return i;
    }

    private int h() {
        if (this.C == -1) {
            String w = l.w();
            if ("wifi".equalsIgnoreCase(w)) {
                this.C = 20;
            } else if ("4G".equalsIgnoreCase(w)) {
                this.C = 16;
            } else if ("3G".equalsIgnoreCase(w)) {
                this.C = 12;
            } else {
                this.C = 8;
            }
        }
        return this.C;
    }

    private a.C0013a a(String str, Map<String, Object> map) {
        if (str != null) {
            byte[] bArr = e.a(2, str, map, false).e;
            i.a("UploadTask", "url:", str);
            if (bArr != null) {
                String str2 = null;
                try {
                    str2 = new String(bArr, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (str2 != null) {
                    i.a("UploadTask", "result:", str2);
                    return com.alibaba.mtl.log.d.a.a(str2);
                }
            }
        }
        return a.C0013a.a;
    }

    private int a(Boolean bool, long j) {
        if (j < 0) {
            return this.C;
        }
        float f = ((float) this.D) / ((float) j);
        if (!bool.booleanValue()) {
            this.C /= 2;
            B++;
        } else if (j > 45000) {
            return this.C;
        } else {
            this.C = (int) ((((double) (f * 45000.0f)) / ((double) this.a)) - ((double) B));
        }
        int i = this.C;
        if (i < 1) {
            this.C = 1;
            B = 0;
        } else if (i > 350) {
            this.C = 350;
        }
        i.a("UploadTask", "winsize:", Integer.valueOf(this.C));
        return this.C;
    }

    private Map<String, Object> a(List<com.alibaba.mtl.log.model.a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            List<String> a2 = a(list.get(i));
            if (a2 != null) {
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    StringBuilder sb = (StringBuilder) hashMap.get(a2.get(i2));
                    if (sb == null) {
                        sb = new StringBuilder();
                        hashMap.put(a2.get(i2), sb);
                    } else {
                        sb.append("\n");
                    }
                    sb.append(list.get(i).k());
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        this.D = 0;
        for (String str : hashMap.keySet()) {
            byte[] a3 = a(((StringBuilder) hashMap.get(str)).toString());
            hashMap2.put(str, a3);
            this.D += a3.length;
        }
        float size = ((float) this.D) / ((float) list.size());
        this.a = size;
        i.a("UploadTask", "averagePackageSize:", Float.valueOf(size));
        return hashMap2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003c A[SYNTHETIC, Splitter:B:25:0x003c] */
    private byte[] a(String str) {
        Throwable th;
        IOException e;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(str.getBytes("UTF-8"));
                gZIPOutputStream2.flush();
                try {
                    gZIPOutputStream2.close();
                } catch (Exception unused) {
                }
            } catch (IOException e2) {
                e = e2;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    e.printStackTrace();
                    if (gZIPOutputStream != null) {
                    }
                    byte[] a2 = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
                    byteArrayOutputStream.close();
                    return a2;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = gZIPOutputStream2;
                if (gZIPOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byte[] a2 = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
            byteArrayOutputStream.close();
            return a2;
        }
        byte[] a2 = n.a(byteArrayOutputStream.toByteArray(), "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK");
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused3) {
        }
        return a2;
    }

    private List<String> a(com.alibaba.mtl.log.model.a aVar) {
        return com.alibaba.mtl.log.a.a.m20a(aVar.T);
    }
}
