package com.bytedance.tea.crash.upload;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.tea.crash.g.f;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.h;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashUploader */
public class b {
    public static boolean a;
    private static c b;

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return true;
    }

    public static f a(long j, String str, byte[] bArr, a aVar, String str2, boolean z) throws IOException {
        if (str == null) {
            return new f(201);
        }
        if (bArr == null) {
            bArr = new byte[0];
        }
        int length = bArr.length;
        String str3 = null;
        if (a.GZIP == aVar && length > 128) {
            bArr = b(bArr);
            str3 = "gzip";
        } else if (a.DEFLATER == aVar && length > 128) {
            bArr = a(bArr);
            str3 = "deflate";
        }
        byte[] bArr2 = bArr;
        if (bArr2 == null) {
            return new f(202);
        }
        if (!z) {
            return a(str, bArr2, str2, str3, "POST", true, false);
        }
        byte[] a2 = TTEncryptUtils.a(bArr2, bArr2.length);
        if (a2 != null) {
            if (TextUtils.isEmpty(new URL(str).getQuery())) {
                if (!str.endsWith("?")) {
                    str = str + "?";
                }
            } else if (!str.endsWith("&")) {
                str = str + "&";
            }
            str = str + "tt_data=a";
            str2 = "application/octet-stream;tt-data=a";
            bArr2 = a2;
        }
        return a(str, bArr2, str2, str3, "POST", true, true);
    }

    private static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[8192];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        deflater.end();
        return byteArrayOutputStream.toByteArray();
    }

    private static byte[] b(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        try {
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            gZIPOutputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x010f A[SYNTHETIC, Splitter:B:86:0x010f] */
    private static f a(String str, byte[] bArr, String str2, String str3, String str4, boolean z, boolean z2) {
        InputStream inputStream;
        Throwable th;
        URL url;
        byte[] bArr2;
        Throwable th2;
        DataOutputStream dataOutputStream;
        Throwable th3;
        HttpURLConnection httpURLConnection = null;
        GZIPInputStream gZIPInputStream = null;
        try {
            c cVar = b;
            if (cVar != null) {
                str = cVar.a(str, bArr);
            }
            LinkedList<Pair> linkedList = new LinkedList();
            if (z2) {
                url = new URL(com.bytedance.tea.a.a.a.a.a(str, linkedList));
            } else {
                url = new URL(str);
            }
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
            if (z2) {
                try {
                    if (!linkedList.isEmpty()) {
                        for (Pair pair : linkedList) {
                            if (pair != null) {
                                httpURLConnection2.setRequestProperty((String) pair.first, (String) pair.second);
                            }
                        }
                    }
                } catch (Throwable th4) {
                    httpURLConnection = httpURLConnection2;
                    th = th4;
                    inputStream = null;
                    try {
                        j.b(th);
                        return new f(207, th);
                    } finally {
                        if (httpURLConnection != null) {
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception unused) {
                            }
                        }
                        f.a(inputStream);
                    }
                }
            }
            if (z) {
                httpURLConnection2.setDoOutput(true);
            } else {
                httpURLConnection2.setDoOutput(false);
            }
            if (str2 != null) {
                httpURLConnection2.setRequestProperty("Content-Type", str2);
            }
            if (str3 != null) {
                httpURLConnection2.setRequestProperty("Content-Encoding", str3);
            }
            httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip");
            if (str4 != null) {
                httpURLConnection2.setRequestMethod(str4);
                if (bArr != null && bArr.length > 0) {
                    try {
                        dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            f.a(dataOutputStream);
                        } catch (Throwable th5) {
                            th3 = th5;
                            f.a(dataOutputStream);
                            throw th3;
                        }
                    } catch (Throwable th6) {
                        th3 = th6;
                        dataOutputStream = null;
                        f.a(dataOutputStream);
                        throw th3;
                    }
                }
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode == 200) {
                    inputStream = httpURLConnection2.getInputStream();
                    try {
                        if ("gzip".equalsIgnoreCase(httpURLConnection2.getContentEncoding())) {
                            try {
                                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(inputStream);
                                try {
                                    bArr2 = a(gZIPInputStream2);
                                    f.a(gZIPInputStream2);
                                } catch (Throwable th7) {
                                    th2 = th7;
                                    gZIPInputStream = gZIPInputStream2;
                                    f.a(gZIPInputStream);
                                    throw th2;
                                }
                            } catch (Throwable th8) {
                                th2 = th8;
                                f.a(gZIPInputStream);
                                throw th2;
                            }
                        } else {
                            bArr2 = a(inputStream);
                        }
                        f c = c(bArr2);
                        if (httpURLConnection2 != null) {
                            try {
                                httpURLConnection2.disconnect();
                            } catch (Exception unused2) {
                            }
                        }
                        f.a(inputStream);
                        return c;
                    } catch (Throwable th9) {
                        httpURLConnection = httpURLConnection2;
                        th = th9;
                        j.b(th);
                        return new f(207, th);
                    }
                } else {
                    f fVar = new f(206, "http response code " + responseCode);
                    if (httpURLConnection2 != null) {
                        try {
                            httpURLConnection2.disconnect();
                        } catch (Exception unused3) {
                        }
                    }
                    f.a(null);
                    return fVar;
                }
            } else {
                throw new IllegalArgumentException("request method is not null");
            }
        } catch (Throwable th10) {
            th = th10;
            inputStream = null;
            j.b(th);
            return new f(207, th);
        }
    }

    private static f c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return new f(203);
        }
        String str = new String(bArr, Charset.forName("utf-8"));
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() > 0) {
                return new f(0, jSONObject);
            }
            return new f(204, str);
        } catch (JSONException unused) {
            return new f(204, str);
        }
    }

    public static f a(String str, String str2) {
        return a(str, str2, b());
    }

    public static f b(String str, String str2) {
        return a(str, str2, a());
    }

    public static f a(String str, String str2, String str3) {
        try {
            e eVar = new e(str, "UTF-8", true);
            eVar.a("json", str2);
            eVar.a("file", new File(str3));
            String a2 = eVar.a();
            try {
                JSONObject jSONObject = new JSONObject(a2);
                if ("succ".equals(jSONObject.optString("succ_kind"))) {
                    return new f(0, jSONObject);
                }
                return new f(204, a2);
            } catch (JSONException e) {
                return new f(205, e);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return new f(207);
        }
    }

    public static String a(Map map) {
        return h.e().a();
    }

    public static f a(String str, String str2, boolean z) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(str)) {
                    return a(2097152, str, str2.getBytes(), a.GZIP, "application/json; charset=utf-8", z);
                }
            }
            return new f(201);
        } catch (Throwable th) {
            j.b(th);
            return new f(207, th);
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                try {
                    return byteArrayOutputStream.toByteArray();
                } finally {
                    f.a(byteArrayOutputStream);
                }
            }
        }
    }

    /* compiled from: CrashUploader */
    public enum a {
        NONE(0),
        GZIP(1),
        DEFLATER(2);
        
        final int d;

        private a(int i) {
            this.d = i;
        }
    }

    /* renamed from: com.bytedance.tea.crash.upload.b$b  reason: collision with other inner class name */
    /* compiled from: CrashUploader */
    public enum EnumC0070b {
        NONE(0),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        WIFI(4),
        MOBILE_4G(5);
        
        final int g;

        private EnumC0070b(int i) {
            this.g = i;
        }
    }
}
