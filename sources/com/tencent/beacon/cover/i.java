package com.tencent.beacon.cover;

import android.content.Context;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: VersionUpdateRequester */
public final class i implements Runnable {
    private String a = null;
    private Context b;
    private List<a> c = null;
    private c d = null;

    public i(Context context, List<a> list) {
        this.b = context;
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.addAll(list);
        this.a = g.f(this.b);
        c cVar = new c(this.b);
        this.d = cVar;
        cVar.a();
    }

    private String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkey", g.b(this.b));
            jSONObject.put("appversion", g.c(this.b));
            jSONObject.put("model", g.a());
            jSONObject.put("aid", g.d(this.b));
            jSONObject.put("imei", g.e(this.b));
            jSONObject.put("cpuabi", g.b());
            jSONObject.put("coverSDKver", "1.0.0");
            JSONArray jSONArray = new JSONArray();
            List<a> list = this.c;
            if (list != null) {
                for (a aVar : list) {
                    if (aVar != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("compId", aVar.a);
                        jSONObject2.put("compVer", aVar.b);
                        jSONObject2.put("compType", aVar.c);
                        jSONObject2.put("md5", aVar.g);
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.put("compList", jSONArray);
        } catch (Exception unused) {
        }
        g.a("D", "post json data:" + jSONObject.toString(), new Object[0]);
        return jSONObject.toString();
    }

    private boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.getString("appkey").equals(g.b(this.b)) || !jSONObject.getString("appversion").equals(g.c(this.b)) || !jSONObject.getString("coverSDKver").equals("1.0.0")) {
                return false;
            }
            if (jSONObject.getInt("isUpdate") == 1) {
                JSONArray jSONArray = jSONObject.getJSONArray("updateList");
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        a aVar = new a();
                        aVar.a = jSONObject2.getInt("compId");
                        aVar.b = jSONObject2.getString("compVer");
                        aVar.c = jSONObject2.getInt("compType");
                        aVar.d = jSONObject2.getString("name");
                        aVar.e = jSONObject2.getString("url");
                        aVar.f = jSONObject2.getInt("size");
                        aVar.g = jSONObject2.getString("md5");
                        if (aVar.c == g.c) {
                            aVar.h = jSONObject.getString("cpuabi");
                        }
                        arrayList.add(aVar);
                    }
                    if (arrayList.size() > 0) {
                        this.d.a(arrayList);
                    }
                }
            }
            return true;
        } catch (Exception unused) {
            g.a("E", "parse the response data to json object failed!", new Object[0]);
            return false;
        }
    }

    private boolean b() {
        byte[] a2;
        String a3 = a();
        String a4 = g.a(this.b, this.a);
        try {
            byte[] a5 = g.a(true, this.a, a3.getBytes("utf-8"));
            if (a5 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/x-www-form-urlencoded");
                hashMap.put("Content-Length", String.valueOf(a5.length));
                hashMap.put("encr_type", "rsapost");
                hashMap.put("rsa_encr_key", a4);
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (i >= 3) {
                        break;
                    }
                    g.a("D", "start http post: http://oth.update.mdt.qq.com:8080/beacon/vercheck", new Object[0]);
                    HttpURLConnection a6 = a("http://oth.update.mdt.qq.com:8080/beacon/vercheck", hashMap);
                    if (!(a6 == null || (a2 = a(a6, a5)) == null)) {
                        try {
                            if (g.a(false, this.a, a2) != null) {
                                String str = new String(g.a(false, this.a, a2));
                                g.a("D", "ResponseData: " + str, new Object[0]);
                                return a(str);
                            }
                        } catch (Exception unused) {
                            g.a("E", "decode response data error!", new Object[0]);
                        }
                    }
                    g.a(10000);
                    i = i2;
                }
            }
            return false;
        } catch (Exception unused2) {
            g.a("E", "Encry post data error!", new Object[0]);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0061 A[Catch:{ Exception -> 0x0077, all -> 0x0072 }, LOOP:0: B:24:0x005a->B:26:0x0061, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b A[SYNTHETIC, Splitter:B:29:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a5 A[SYNTHETIC, Splitter:B:52:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ac A[SYNTHETIC, Splitter:B:56:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b4 A[SYNTHETIC, Splitter:B:63:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bb A[SYNTHETIC, Splitter:B:67:0x00bb] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0065 A[EDGE_INSN: B:71:0x0065->B:27:0x0065 ?: BREAK  , SYNTHETIC] */
    protected static byte[] a(HttpURLConnection httpURLConnection, byte[] bArr) {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        InputStream inputStream;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        byte[] bArr2;
        int read;
        InputStream inflaterInputStream;
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e2) {
            e2.printStackTrace();
            g.a("E", "httpURLConnection write post data error!", new Object[0]);
        }
        InputStream inputStream3 = null;
        try {
            if (httpURLConnection.getResponseCode() == 200) {
                InputStream inputStream4 = httpURLConnection.getInputStream();
                String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    if (contentEncoding != null && contentEncoding.equalsIgnoreCase("deflate")) {
                        inflaterInputStream = new InflaterInputStream(inputStream4, new Inflater(true));
                    }
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        bArr2 = new byte[128];
                        while (true) {
                            read = inputStream4.read(bArr2);
                            if (read != -1) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream2.toByteArray();
                        if (inputStream4 != null) {
                            try {
                                inputStream4.close();
                            } catch (IOException unused) {
                            }
                        }
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException unused2) {
                        }
                        return byteArray;
                    } catch (Exception e3) {
                        byteArrayOutputStream = byteArrayOutputStream2;
                        e = e3;
                        inputStream = inputStream4;
                        try {
                            g.a("E", "parse response failure: " + e.toString(), new Object[0]);
                            if (inputStream != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream3 = inputStream;
                            if (inputStream3 != null) {
                                try {
                                    inputStream3.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        inputStream2 = inputStream4;
                        byteArrayOutputStream = byteArrayOutputStream2;
                        th = th3;
                        inputStream3 = inputStream2;
                        if (inputStream3 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                } else {
                    inflaterInputStream = new GZIPInputStream(inputStream4);
                }
                inputStream4 = inflaterInputStream;
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bArr2 = new byte[128];
                    while (true) {
                        read = inputStream4.read(bArr2);
                        if (read != -1) {
                        }
                        byteArrayOutputStream2.write(bArr2, 0, read);
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (inputStream4 != null) {
                    }
                    byteArrayOutputStream2.close();
                    return byteArray;
                } catch (Exception e4) {
                    e = e4;
                    inputStream = inputStream4;
                    byteArrayOutputStream = null;
                    g.a("E", "parse response failure: " + e.toString(), new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused6) {
                        }
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream2 = inputStream4;
                    byteArrayOutputStream = null;
                    inputStream3 = inputStream2;
                    if (inputStream3 != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            byteArrayOutputStream = null;
            inputStream = null;
            g.a("E", "parse response failure: " + e.toString(), new Object[0]);
            if (inputStream != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            return null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            if (inputStream3 != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
        return null;
    }

    protected static HttpURLConnection a(String str, Map<String, String> map) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setReadTimeout(20000);
                if (Build.VERSION.SDK_INT > 13) {
                    httpURLConnection.setRequestProperty("Connection", "close");
                } else {
                    httpURLConnection.setRequestProperty("http.keepAlive", "false");
                }
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
                return httpURLConnection;
            } catch (Exception unused) {
                return httpURLConnection;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (b()) {
            g.a("I", "version check request success!", new Object[0]);
        }
    }
}
