package com.tencent.imsdk.utils;

import android.os.Build;
import android.util.Base64;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class IMFunc {
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public interface RequestListener {
        void onFail(String str);

        void onSuccess(byte[] bArr);
    }

    public static byte[] getHmacSHA1(byte[] bArr, String str) throws Exception {
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(str.getBytes(), "HmacSHA1"));
        try {
            return instance.doFinal(bArr);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public static String base64Encode(byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    public static byte[] gzCompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes());
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static String byte2hex(byte[] bArr) {
        return byte2hexInternal(bArr);
    }

    public static String byte2hexInternal(byte[] bArr) {
        try {
            StringBuilder sb = new StringBuilder();
            if (bArr == null || bArr.length == 0) {
                return "b2h failed";
            }
            for (byte b : bArr) {
                char[] cArr = digits;
                char c = cArr[b & 15];
                sb.append(cArr[((byte) (b >>> 4)) & 15]);
                sb.append(c);
            }
            return sb.toString();
        } catch (OutOfMemoryError unused) {
            System.gc();
            return "b2h failed";
        }
    }

    public static String calcSHA(byte[] bArr) throws Exception {
        MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(bArr);
        return byte2hexInternal(instance.digest()).replace(" ", "");
    }

    public static String getExceptionInfo(Throwable th) {
        if (th == null) {
            return "";
        }
        String th2 = th.toString();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                th2 = th2 + "\n\tat " + stackTraceElement.toString();
            }
        }
        return th2;
    }

    public static boolean httpPostReq(String str, final byte[] bArr, final Map<String, String> map, final RequestListener requestListener) {
        try {
            final HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            new Thread(new Runnable() {
                /* class com.tencent.imsdk.utils.IMFunc.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(bArr.length));
                        httpURLConnection.setRequestProperty("connection", "close");
                        for (Map.Entry entry : map.entrySet()) {
                            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                        }
                        httpURLConnection.getOutputStream().write(bArr);
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10240);
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        RequestListener requestListener = requestListener;
                        if (requestListener != null) {
                            requestListener.onSuccess(byteArray);
                        }
                    } catch (Throwable th) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                    httpURLConnection.disconnect();
                }
            }).start();
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            if (requestListener == null) {
                return false;
            }
            requestListener.onFail(getExceptionInfo(th));
            return false;
        }
    }

    public static byte[] getParamBytes(String str, String str2, String str3, String str4) {
        return ("--" + str + "\r\nContent-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str3 + "\"\r\n\r\n" + str4 + "\r\n").getBytes();
    }

    public static byte[] getParamBytes(String str, String str2, String str3, byte[] bArr) {
        byte[] bytes = ("--" + str + "\r\nContent-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str3 + "\"\r\n\r\n").getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length + 2)];
        System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
        System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
        System.arraycopy("\r\n".getBytes(), 0, bArr2, bytes.length + bArr.length, 2);
        return bArr2;
    }

    public static String appSignature(int i, String str, String str2, long j, String str3, String str4) throws Exception {
        if (str == null || str2 == null || str3 == null || str4 == null) {
            return "-1";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String str5 = "a=" + i + "&k=" + str + "&e=" + (j + currentTimeMillis) + "&t=" + currentTimeMillis + "&r=" + Math.abs(new Random().nextInt()) + "&f=" + str3 + "&b=" + str4;
        byte[] hmacSHA1 = getHmacSHA1(str5.getBytes(), str2);
        byte[] bArr = new byte[(hmacSHA1.length + str5.getBytes().length)];
        System.arraycopy(hmacSHA1, 0, bArr, 0, hmacSHA1.length);
        System.arraycopy(str5.getBytes(), 0, bArr, hmacSHA1.length, str5.getBytes().length);
        return base64Encode(bArr);
    }

    public static int getClientInstType() {
        String str = Build.MANUFACTURER;
        if (isBrandXiaoMi()) {
            return 2000;
        }
        if (isBrandHuawei()) {
            return 2001;
        }
        if (isBrandMeizu()) {
            return 2003;
        }
        if (isBrandOppo()) {
            return 2004;
        }
        return isBrandVivo() ? 2005 : 2002;
    }

    public static boolean isBrandXiaoMi() {
        return "xiaomi".equalsIgnoreCase(Build.BRAND) || "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandHuawei() {
        return "huawei".equalsIgnoreCase(Build.BRAND) || "huawei".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandMeizu() {
        return "meizu".equalsIgnoreCase(Build.BRAND) || "meizu".equalsIgnoreCase(Build.MANUFACTURER) || "22c4185e".equalsIgnoreCase(Build.BRAND);
    }

    public static boolean isBrandOppo() {
        return "oppo".equalsIgnoreCase(Build.BRAND) || "oppo".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean isBrandVivo() {
        return "vivo".equalsIgnoreCase(Build.BRAND) || "vivo".equalsIgnoreCase(Build.MANUFACTURER);
    }
}
