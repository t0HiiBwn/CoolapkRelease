package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/* compiled from: HttpUtils */
public final class e {
    private static u a = null;

    /* compiled from: HttpUtils */
    public static class a {
        public int F = -1;
        public byte[] e = null;
    }

    static {
        System.setProperty("http.keepAlive", "true");
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x01f8 A[Catch:{ IOException -> 0x0213 }, LOOP:1: B:114:0x01f1->B:116:0x01f8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01fc A[EDGE_INSN: B:117:0x01fc->B:118:? ?: BREAK  , SYNTHETIC, Splitter:B:117:0x01fc] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0220 A[SYNTHETIC, Splitter:B:132:0x0220] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x022e A[SYNTHETIC, Splitter:B:140:0x022e] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0256 A[SYNTHETIC, Splitter:B:160:0x0256] */
    public static a a(int i, String str, Map<String, Object> map, boolean z) {
        byte[] bArr;
        DataOutputStream dataOutputStream;
        Throwable th;
        Throwable th2;
        Exception e;
        DataOutputStream dataOutputStream2;
        InputStream inputStream;
        Throwable th3;
        IOException e2;
        InputStream inputStream2;
        byte[] bArr2;
        int read;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            char c = 1;
            if (httpURLConnection != null) {
                try {
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        if (a == null && !TextUtils.isEmpty(url.getHost())) {
                            a = new u(url.getHost());
                        }
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(a);
                    }
                } catch (Throwable unused) {
                }
                int i2 = 3;
                if (i == 2 || i == 3) {
                    httpURLConnection.setDoOutput(true);
                }
                httpURLConnection.setDoInput(true);
                if (i == 2 || i == 3) {
                    httpURLConnection.setRequestMethod("POST");
                } else {
                    try {
                        httpURLConnection.setRequestMethod("GET");
                    } catch (ProtocolException e3) {
                        e3.printStackTrace();
                        return aVar;
                    }
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setRequestProperty("Connection", "close");
                if (z) {
                    httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                }
                httpURLConnection.setInstanceFollowRedirects(true);
                if (i == 2 || i == 3) {
                    if (i == 2) {
                        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=GJircTeP");
                    } else if (i == 3) {
                        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    }
                    if (map == null || map.size() <= 0) {
                        bArr = null;
                    } else {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Set<String> keySet = map.keySet();
                        String[] strArr = new String[keySet.size()];
                        keySet.toArray(strArr);
                        String[] a2 = g.a().a(strArr, true);
                        int length = a2.length;
                        int i3 = 0;
                        while (i3 < length) {
                            String str2 = a2[i3];
                            if (i == 2) {
                                byte[] bArr3 = (byte[]) map.get(str2);
                                if (bArr3 != null) {
                                    try {
                                        Object[] objArr = new Object[2];
                                        objArr[0] = str2;
                                        objArr[c] = str2;
                                        byteArrayOutputStream.write(String.format("--GJircTeP\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream \r\n\r\n", objArr).getBytes());
                                        byteArrayOutputStream.write(bArr3);
                                        byteArrayOutputStream.write("\r\n".getBytes());
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                            } else if (i == i2) {
                                String str3 = (String) map.get(str2);
                                if (byteArrayOutputStream.size() > 0) {
                                    try {
                                        byteArrayOutputStream.write(("&" + str2 + "=" + str3).getBytes());
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                } else {
                                    try {
                                        byteArrayOutputStream.write((str2 + "=" + str3).getBytes());
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                            i3++;
                            c = 1;
                            i2 = 3;
                        }
                        if (i == 2) {
                            try {
                                byteArrayOutputStream.write("--GJircTeP--\r\n".getBytes());
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr != null ? bArr.length : 0));
                } else {
                    bArr = null;
                }
                try {
                    httpURLConnection.connect();
                    if ((i == 2 || i == 3) && bArr != null && bArr.length > 0) {
                        dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream2.write(bArr);
                            dataOutputStream2.flush();
                        } catch (Exception e8) {
                            e = e8;
                            dataOutputStream = dataOutputStream2;
                        } catch (Throwable th4) {
                            th2 = th4;
                            dataOutputStream = dataOutputStream2;
                            th = th2;
                            if (dataOutputStream != null) {
                            }
                            throw th;
                        }
                    } else {
                        dataOutputStream2 = null;
                    }
                    if (dataOutputStream2 != null) {
                        try {
                            dataOutputStream2.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    try {
                        aVar.F = httpURLConnection.getResponseCode();
                        i.a("UtAnalytics", "responseCode:", Integer.valueOf(aVar.F));
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    if (z) {
                        try {
                            if ("gzip".equals(httpURLConnection.getContentEncoding())) {
                                inputStream2 = new GZIPInputStream(httpURLConnection.getInputStream());
                                inputStream = inputStream2;
                                System.currentTimeMillis();
                                bArr2 = new byte[2048];
                                while (true) {
                                    read = inputStream.read(bArr2, 0, 2048);
                                    if (read == -1) {
                                        byteArrayOutputStream2.write(bArr2, 0, read);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e11) {
                                            e11.printStackTrace();
                                        }
                                    }
                                }
                                inputStream.close();
                                if (byteArrayOutputStream2.size() > 0) {
                                    aVar.e = byteArrayOutputStream2.toByteArray();
                                }
                            }
                        } catch (IOException e12) {
                            e2 = e12;
                            inputStream = null;
                            try {
                                e2.printStackTrace();
                                if (inputStream != null) {
                                }
                                return aVar;
                            } catch (Throwable th5) {
                                th3 = th5;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e13) {
                                        e13.printStackTrace();
                                    }
                                }
                                throw th3;
                            }
                        } catch (Throwable th6) {
                            th3 = th6;
                            inputStream = null;
                            if (inputStream != null) {
                            }
                            throw th3;
                        }
                    }
                    inputStream2 = new DataInputStream(httpURLConnection.getInputStream());
                    inputStream = inputStream2;
                    try {
                        System.currentTimeMillis();
                        bArr2 = new byte[2048];
                        while (true) {
                            read = inputStream.read(bArr2, 0, 2048);
                            if (read == -1) {
                            }
                            byteArrayOutputStream2.write(bArr2, 0, read);
                        }
                        inputStream.close();
                        if (byteArrayOutputStream2.size() > 0) {
                        }
                    } catch (IOException e14) {
                        e2 = e14;
                        e2.printStackTrace();
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e15) {
                                e15.printStackTrace();
                            }
                        }
                        return aVar;
                    }
                } catch (Exception e16) {
                    e = e16;
                    dataOutputStream = null;
                    try {
                        e.printStackTrace();
                        i.a("UtAnalytics", "http", e);
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        return aVar;
                    } catch (Throwable th7) {
                        th2 = th7;
                        th = th2;
                        if (dataOutputStream != null) {
                            try {
                                dataOutputStream.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    dataOutputStream = null;
                    if (dataOutputStream != null) {
                    }
                    throw th;
                }
            } else {
                i.a("UtAnalytics", "conn", httpURLConnection);
            }
            return aVar;
        } catch (MalformedURLException e19) {
            e19.printStackTrace();
            return aVar;
        } catch (IOException e20) {
            e20.printStackTrace();
            return aVar;
        }
    }
}
