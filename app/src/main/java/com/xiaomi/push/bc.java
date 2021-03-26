package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class bc {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
    public static final Pattern c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    public static final class a extends FilterInputStream {
        private boolean a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read;
            if (!this.a && (read = super.read(bArr, i, i2)) != -1) {
                return read;
            }
            this.a = true;
            return -1;
        }
    }

    public static class b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Map<String, String> f223a;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.f223a.toString());
        }
    }

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static NetworkInfo m128a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:1:0x0006 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f1, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00f2, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fd, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0126, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0127, code lost:
        com.xiaomi.push.y.a(r1);
        com.xiaomi.push.y.a((java.io.Closeable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012d, code lost:
        throw r4;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0006] */
    public static ba a(Context context, String str, String str2, Map<String, String> map, String str3) {
        IOException e;
        Throwable th;
        HttpURLConnection a2;
        BufferedReader bufferedReader;
        ba baVar = new ba();
        OutputStream outputStream = null;
        try {
            a2 = m130a(context, m131a(str));
            a2.setConnectTimeout(10000);
            a2.setReadTimeout(15000);
            String str4 = str2;
            if (str2 == 0) {
                str4 = "GET";
            }
            a2.setRequestMethod(str4);
            if (map != null) {
                for (String str5 : map.keySet()) {
                    a2.setRequestProperty(str5, map.get(str5));
                }
            }
            int i = 0;
            if (!TextUtils.isEmpty(str3)) {
                a2.setDoOutput(true);
                byte[] bytes = str3.getBytes();
                OutputStream outputStream2 = a2.getOutputStream();
                try {
                    outputStream2.write(bytes, 0, bytes.length);
                    outputStream2.flush();
                    outputStream2.close();
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th2) {
                    th = th2;
                    str2 = 0;
                    outputStream = outputStream2;
                    throw new IOException(th.getMessage());
                }
            }
            baVar.a = a2.getResponseCode();
            Log.d("com.xiaomi.common.Network", "Http POST Response Code: " + baVar.a);
            while (true) {
                String headerFieldKey = a2.getHeaderFieldKey(i);
                String headerField = a2.getHeaderField(i);
                if (headerFieldKey == null && headerField == null) {
                    break;
                }
                baVar.f222a.put(headerFieldKey, headerField);
                i = i + 1 + 1;
            }
            bufferedReader = new BufferedReader(new InputStreamReader(new a(a2.getInputStream())));
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String property = System.getProperty("line.separator");
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                    stringBuffer.append(property);
                }
                baVar.f221a = stringBuffer.toString();
                bufferedReader.close();
                y.a((Closeable) null);
                y.a((Closeable) null);
                return baVar;
            } catch (IOException e3) {
                e = e3;
                throw new IOException("err while request " + str + ":" + e.getClass().getSimpleName());
            } catch (Throwable th3) {
                th = th3;
                str2 = bufferedReader;
                throw new IOException(th.getMessage());
            }
        } catch (IOException unused) {
            bufferedReader = new BufferedReader(new InputStreamReader(new a(a2.getErrorStream())));
        } catch (Throwable th4) {
        }
    }

    public static ba a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context == null) {
            throw new IllegalArgumentException("context");
        } else if (url != null) {
            URL url2 = !z ? new URL(a(url.toString())) : url;
            try {
                HttpURLConnection.setFollowRedirects(true);
                HttpURLConnection a2 = m130a(context, url2);
                a2.setConnectTimeout(10000);
                a2.setReadTimeout(15000);
                if (!TextUtils.isEmpty(str)) {
                    a2.setRequestProperty("User-Agent", str);
                }
                if (str2 != null) {
                    a2.setRequestProperty("Cookie", str2);
                }
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        a2.setRequestProperty(str3, map.get(str3));
                    }
                }
                if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                    bVar.a = a2.getResponseCode();
                    if (bVar.f223a == null) {
                        bVar.f223a = new HashMap();
                    }
                    int i = 0;
                    while (true) {
                        String headerFieldKey = a2.getHeaderFieldKey(i);
                        String headerField = a2.getHeaderField(i);
                        if (headerFieldKey == null && headerField == null) {
                            break;
                        }
                        if (!TextUtils.isEmpty(headerFieldKey)) {
                            if (!TextUtils.isEmpty(headerField)) {
                                bVar.f223a.put(headerFieldKey, headerField);
                            }
                        }
                        i++;
                    }
                }
                return new a(a2.getInputStream());
            } catch (IOException e) {
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th) {
                throw new IOException(th.getMessage());
            }
        } else {
            throw new IllegalArgumentException("url");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m129a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (d(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + "-" + activeNetworkInfo.getSubtypeName() + "-" + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        Throwable th;
        InputStream inputStream;
        try {
            inputStream = a(context, url, z, str, str3);
            try {
                StringBuilder sb = new StringBuilder(1024);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
                char[] cArr = new char[4096];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (-1 != read) {
                        sb.append(cArr, 0, read);
                    } else {
                        y.a(inputStream);
                        return sb.toString();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                y.a(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            y.a(inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, bh.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0010 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v13 */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        IOException e;
        Throwable th;
        BufferedReader bufferedReader;
        FileInputStream fileInputStream = null;
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes("--*****\r\n");
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
            dataOutputStream.writeBytes("\r\n");
            FileInputStream fileInputStream2 = new FileInputStream((File) file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                    dataOutputStream.flush();
                }
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.writeBytes("--");
                dataOutputStream.writeBytes("*****");
                dataOutputStream.writeBytes("--");
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.flush();
                StringBuffer stringBuffer = new StringBuffer();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new a(httpURLConnection.getInputStream())));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            String stringBuffer2 = stringBuffer.toString();
                            y.a(fileInputStream2);
                            y.a(bufferedReader2);
                            return stringBuffer2;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        throw new IOException("IOException:" + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        fileInputStream = fileInputStream2;
                        file = bufferedReader;
                        throw new IOException(th.getMessage());
                    }
                }
            } catch (IOException e3) {
                e = e3;
                throw new IOException("IOException:" + e.getClass().getSimpleName());
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                fileInputStream = fileInputStream2;
                file = bufferedReader;
                throw new IOException(th.getMessage());
            }
        } catch (IOException e4) {
            e = e4;
            throw new IOException("IOException:" + e.getClass().getSimpleName());
        } catch (Throwable th4) {
            y.a(fileInputStream);
            y.a((Closeable) file);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append("&");
                } catch (UnsupportedEncodingException e) {
                    Log.d("com.xiaomi.common.Network", "Failed to convert from params map to string: " + e.toString());
                    Log.d("com.xiaomi.common.Network", "map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static HttpURLConnection m130a(Context context, URL url) {
        return (HttpURLConnection) (("http".equals(url.getProtocol()) && m132a(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    /* renamed from: a  reason: collision with other method in class */
    private static URL m131a(String str) {
        return new URL(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m132a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (!"CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            return !TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains("ctwap");
        } catch (Exception unused) {
        }
    }

    public static boolean b(Context context) {
        return a(context) >= 0;
    }

    public static boolean c(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || 1 != activeNetworkInfo.getType()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        NetworkInfo a2 = m128a(context);
        return a2 != null && a2.getType() == 0 && 20 == a2.getSubtype();
    }

    public static boolean f(Context context) {
        NetworkInfo a2 = m128a(context);
        return a2 != null && a2.getType() == 0 && 13 == a2.getSubtype();
    }

    public static boolean g(Context context) {
        NetworkInfo a2 = m128a(context);
        if (a2 == null || a2.getType() != 0) {
            return false;
        }
        String subtypeName = a2.getSubtypeName();
        if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
            switch (a2.getSubtype()) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    break;
                case 4:
                case 7:
                case 11:
                case 13:
                default:
                    return false;
            }
        }
        return true;
    }

    public static boolean h(Context context) {
        NetworkInfo a2 = m128a(context);
        if (a2 == null || a2.getType() != 0) {
            return false;
        }
        int subtype = a2.getSubtype();
        return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
    }
}
