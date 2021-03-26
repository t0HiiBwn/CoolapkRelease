package com.tencent.beacon.cover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;

/* compiled from: CompUpdate */
public final class c extends BroadcastReceiver implements Runnable {
    private static boolean e;
    private static int f;
    private Context a;
    private List<a> b = null;
    private String c = null;
    private boolean d = false;

    public c(Context context) {
        this.a = context;
        if (context.getFilesDir() != null) {
            this.c = context.getFilesDir().getAbsolutePath() + File.separator + "beacon/comp";
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null) {
                g.a("W", "CompUpdate onReceive ConnectivityManager is null!", new Object[0]);
                return;
            }
            NetworkInfo.State state = null;
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null) {
                state = networkInfo.getState();
            }
            if (state != null && state == NetworkInfo.State.CONNECTED && this.b != null && f != 1 && !e) {
                new Thread(this).start();
            }
        } catch (Exception unused) {
            g.a("E", "onReceive has a exception", new Object[0]);
        }
    }

    public final void a() {
        if (this.a != null && !this.d) {
            this.d = true;
            this.a.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        b();
    }

    private synchronized void b() {
        List<a> list = this.b;
        if (list != null && list.size() > 0) {
            f = 1;
            if (!g.g(this.a)) {
                g.a("W", "it's not on wifi stat, cancel!", new Object[0]);
                f = 2;
            } else if (g.c() < 10485760) {
                g.a("W", "Not enough storage, cancel!", new Object[0]);
                e.a(this.a).b("Not enough storage");
                e.a(this.a).a(true);
                f = 2;
            } else {
                for (a aVar : this.b) {
                    if (!a(aVar)) {
                        f = 2;
                        return;
                    }
                    String str = this.c + "/" + aVar.d + ".tmp";
                    boolean a2 = g.a(this.c + "/" + aVar.d + ".ziptmp", str);
                    if (!a2) {
                        g.a("E", "unzip file failure: " + str, new Object[0]);
                    }
                    File file = new File(str);
                    if (file.exists()) {
                        aVar.f = (int) file.length();
                        if (aVar.g.equals(g.a(file))) {
                            a2 = true;
                        }
                    }
                    if ("libBeacon.so".equals(aVar.d) || "5.jar".equals(aVar.d)) {
                        g.a(this.a);
                        continue;
                    }
                    if (!a2) {
                        f = 2;
                        return;
                    }
                }
                e = true;
                f = 2;
                c();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0113 A[SYNTHETIC, Splitter:B:76:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0118 A[Catch:{ Exception -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011d A[Catch:{ Exception -> 0x0120 }] */
    private boolean a(a aVar) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        InputStream inputStream2;
        Throwable th;
        Exception e2;
        if (aVar.e != null && !"".equals(aVar.e.trim())) {
            try {
                URL url = new URL(aVar.e);
                int i = 0;
                loop0:
                while (true) {
                    int i2 = i + 1;
                    if (i >= 3) {
                        break;
                    }
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setInstanceFollowRedirects(false);
                        httpURLConnection.setConnectTimeout(20000);
                        httpURLConnection.setReadTimeout(30000);
                        if (httpURLConnection != null) {
                            try {
                                if (httpURLConnection.getResponseCode() != 200) {
                                    g.a("E", "http response code: " + httpURLConnection.getResponseCode(), new Object[0]);
                                } else if (aVar.f > 0 && aVar.f == httpURLConnection.getContentLength()) {
                                    try {
                                        inputStream = httpURLConnection.getInputStream();
                                        if (inputStream != null) {
                                            try {
                                                String contentEncoding = httpURLConnection.getContentEncoding();
                                                GZIPInputStream gZIPInputStream = (contentEncoding == null || !contentEncoding.contains("gzip")) ? inputStream : new GZIPInputStream(inputStream);
                                                try {
                                                    byte[] bArr = new byte[4096];
                                                    String str = this.c;
                                                    fileOutputStream = new FileOutputStream(new File(str, aVar.d + ".ziptmp"));
                                                    while (true) {
                                                        try {
                                                            int read = gZIPInputStream.read(bArr, 0, 4096);
                                                            if (read <= 0) {
                                                                break loop0;
                                                            }
                                                            fileOutputStream.write(bArr, 0, read);
                                                            fileOutputStream.flush();
                                                        } catch (Exception e3) {
                                                            e2 = e3;
                                                            inputStream2 = gZIPInputStream;
                                                            try {
                                                                e2.printStackTrace();
                                                                g.a("E", "read InputStream error!", new Object[0]);
                                                                if (inputStream2 != null) {
                                                                }
                                                                if (inputStream != null) {
                                                                }
                                                                if (fileOutputStream != null) {
                                                                }
                                                                g.a(30000);
                                                                i = i2;
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                                if (inputStream2 != null) {
                                                                    try {
                                                                        inputStream2.close();
                                                                    } catch (Exception unused) {
                                                                        throw th;
                                                                    }
                                                                }
                                                                if (inputStream != null) {
                                                                    inputStream.close();
                                                                }
                                                                if (fileOutputStream != null) {
                                                                    fileOutputStream.close();
                                                                }
                                                                throw th;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            inputStream2 = gZIPInputStream;
                                                            if (inputStream2 != null) {
                                                            }
                                                            if (inputStream != null) {
                                                            }
                                                            if (fileOutputStream != null) {
                                                            }
                                                            throw th;
                                                        }
                                                    }
                                                    g.a("D", "down load file:" + this.c + aVar.d + ".ziptmp", new Object[0]);
                                                    if (gZIPInputStream != null) {
                                                        try {
                                                            gZIPInputStream.close();
                                                        } catch (Exception unused2) {
                                                            return true;
                                                        }
                                                    }
                                                    if (inputStream != null) {
                                                        inputStream.close();
                                                    }
                                                    fileOutputStream.close();
                                                    return true;
                                                } catch (Exception e4) {
                                                    e2 = e4;
                                                    inputStream2 = gZIPInputStream;
                                                    fileOutputStream = null;
                                                    e2.printStackTrace();
                                                    g.a("E", "read InputStream error!", new Object[0]);
                                                    if (inputStream2 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    g.a(30000);
                                                    i = i2;
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    inputStream2 = gZIPInputStream;
                                                    fileOutputStream = null;
                                                    if (inputStream2 != null) {
                                                    }
                                                    if (inputStream != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Exception e5) {
                                                e2 = e5;
                                                inputStream2 = null;
                                                fileOutputStream = null;
                                                e2.printStackTrace();
                                                g.a("E", "read InputStream error!", new Object[0]);
                                                if (inputStream2 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                g.a(30000);
                                                i = i2;
                                            } catch (Throwable th5) {
                                                th = th5;
                                                inputStream2 = null;
                                                fileOutputStream = null;
                                                if (inputStream2 != null) {
                                                }
                                                if (inputStream != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                throw th;
                                            }
                                        } else if (inputStream != null) {
                                            inputStream.close();
                                        }
                                    } catch (Exception e6) {
                                        e2 = e6;
                                        inputStream2 = null;
                                        inputStream = null;
                                        fileOutputStream = null;
                                        e2.printStackTrace();
                                        g.a("E", "read InputStream error!", new Object[0]);
                                        if (inputStream2 != null) {
                                            inputStream2.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        g.a(30000);
                                        i = i2;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        inputStream2 = null;
                                        inputStream = null;
                                        fileOutputStream = null;
                                        if (inputStream2 != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (fileOutputStream != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception unused3) {
                            }
                        }
                        g.a(30000);
                    } catch (Exception unused4) {
                        g.a(30000);
                    }
                    i = i2;
                }
            } catch (Exception unused5) {
                g.a("W", "download url is error! " + aVar.e, new Object[0]);
            }
        }
        return false;
    }

    private void c() {
        String str;
        boolean z;
        for (a aVar : this.b) {
            File file = new File(this.c, aVar.d);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            String str2 = this.c;
            new File(str2, aVar.d + ".tmp").renameTo(file);
        }
        h a2 = h.a(this.a);
        List arrayList = new ArrayList();
        if (a2 != null) {
            arrayList.addAll(a2.a());
        }
        if (arrayList.size() == 0) {
            arrayList = this.b;
            str = g.a(arrayList);
        } else {
            for (a aVar2 : this.b) {
                if (aVar2 != null) {
                    int size = arrayList.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            z = false;
                            break;
                        }
                        a aVar3 = (a) arrayList.get(i);
                        if (aVar3 != null && aVar3.a == aVar2.a) {
                            arrayList.set(i, aVar2);
                            z = true;
                            break;
                        }
                        i++;
                    }
                    if (!z) {
                        arrayList.add(aVar2);
                    }
                }
            }
            str = g.a(arrayList);
        }
        if (!"".equals(str)) {
            g.a(this.a, "COMP_INFO", str);
            g.a("D", "new config:" + str, new Object[0]);
        }
        g.a("I", "update component success.", new Object[0]);
        b.a(this.a, arrayList).a();
    }

    public final void a(List<a> list) {
        this.b = list;
        if (f != 1 && !e) {
            new Thread(this).start();
        }
    }
}
