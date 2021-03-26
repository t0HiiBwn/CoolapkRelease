package com.alibaba.baichuan.trade.common.utils.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class HttpHelper {
    public static final int INVALID_RESPONSE_CODE = -999;

    public static class HttpHelperException extends Exception {
        public int statusCode;

        HttpHelperException(Throwable th) {
            super(th);
        }
    }

    private static int a(int i) {
        return i;
    }

    private static InputStream a(String str) {
        int i = -999;
        try {
            HttpURLConnection b = b(str);
            i = b.getResponseCode();
            c(i);
            return b.getInputStream();
        } catch (Exception e) {
            HttpHelperException httpHelperException = new HttpHelperException(e);
            httpHelperException.statusCode = i;
            throw httpHelperException;
        }
    }

    private static String a() {
        return "UTF-8";
    }

    private static String a(InputStream inputStream, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return new String(byteArrayOutputStream.toByteArray(), str);
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                try {
                    sb.append("&");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            } else {
                z = true;
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        return sb.toString();
    }

    private static int b(int i) {
        return i;
    }

    private static HttpURLConnection b(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(a(5000));
            httpURLConnection.setReadTimeout(b(5000));
            return httpURLConnection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void c(int i) {
        if (i != 200) {
            throw new RuntimeException("http request exception, response code: " + i);
        }
    }

    public static String get(String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = "";
            sb.append(map == null ? str2 : "?");
            if (map != null) {
                str2 = a(map);
            }
            sb.append(str2);
            return IOUtils.toString(a(sb.toString()), "UTF-8");
        } catch (Exception e) {
            if (e instanceof HttpHelperException) {
                throw e;
            }
            throw new HttpHelperException(e);
        }
    }

    public static String getHttp(String str) {
        try {
            HttpURLConnection b = b(str);
            c(b.getResponseCode());
            return a(b.getInputStream(), a());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005f A[SYNTHETIC, Splitter:B:23:0x005f] */
    public static String postForm(Map<String, String> map, String str) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        Exception e;
        OutputStream outputStream = null;
        try {
            byte[] bytes = a(map).getBytes("UTF-8");
            httpURLConnection = b(str);
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bytes);
                outputStream.flush();
                c(httpURLConnection.getResponseCode());
                String a = a(httpURLConnection.getInputStream(), a());
                IOUtils.closeQuietly(outputStream);
                if (httpURLConnection != null) {
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused) {
                    }
                }
                return a;
            } catch (Exception e2) {
                e = e2;
                try {
                    throw new HttpHelperException(e);
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly(outputStream);
                    if (httpURLConnection != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            throw new HttpHelperException(e);
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            IOUtils.closeQuietly(outputStream);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }
}
