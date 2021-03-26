package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.exception.WeiboHttpException;
import com.sina.weibo.sdk.network.IRequestParam;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.Set;

public class HttpManager {
    private static final String BOUNDARY;
    private static final String END_MP_BOUNDARY;
    private static final String MP_BOUNDARY;
    private static final String TAG = "HttpManager";

    private static native String calcOauthSignNative(Context context, String str, String str2);

    public static void fillCommonRequestParam(IRequestParam iRequestParam) {
    }

    static {
        System.loadLibrary("weibosdkcore");
        String boundry = getBoundry();
        BOUNDARY = boundry;
        MP_BOUNDARY = "--" + boundry;
        END_MP_BOUNDARY = "--" + boundry + "--";
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        String requestHttpExecute = requestHttpExecute(context, str, str2, weiboParameters);
        LogUtil.d("HttpManager", "Response : " + requestHttpExecute);
        return requestHttpExecute;
    }

    private static String requestHttpExecute(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2 = null;
        try {
            setHttpCommonParam(context, weiboParameters);
            if ("GET".equals(str2)) {
                httpURLConnection = ConnectionFactory.createConnect(str + "?" + weiboParameters.encodeUrl(), context);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
            } else {
                httpURLConnection = ConnectionFactory.createConnect(str, context);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.connect();
                if (weiboParameters.hasBinaryData()) {
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    buildParams(dataOutputStream, weiboParameters);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                } else {
                    DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection.getOutputStream());
                    dataOutputStream2.write(weiboParameters.encodeUrl().getBytes("UTF-8"));
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                }
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                String readConnectResponse = readConnectResponse(httpURLConnection, false);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                return readConnectResponse;
            }
            throw new WeiboHttpException(readConnectResponse(httpURLConnection, true), responseCode);
        } catch (IOException e) {
            e.printStackTrace();
            throw new WeiboException(e);
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x005a A[SYNTHETIC, Splitter:B:39:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0061 A[SYNTHETIC, Splitter:B:43:0x0061] */
    private static String readConnectResponse(HttpURLConnection httpURLConnection, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        IOException e;
        InputStream inputStream;
        InputStream inputStream2 = null;
        String str = null;
        inputStream2 = null;
        try {
            byte[] bArr = new byte[8192];
            if (z) {
                inputStream = httpURLConnection.getErrorStream();
            } else {
                inputStream = httpURLConnection.getInputStream();
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                if (inputStream != null) {
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (IOException e2) {
                            inputStream2 = inputStream;
                            e = e2;
                            try {
                                throw new WeiboException(e);
                            } catch (Throwable th2) {
                                th = th2;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            inputStream2 = inputStream;
                            th = th3;
                            if (inputStream2 != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                    }
                    str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused4) {
                }
                return str;
            } catch (IOException e3) {
                inputStream2 = inputStream;
                e = e3;
                byteArrayOutputStream = null;
                throw new WeiboException(e);
            } catch (Throwable th4) {
                inputStream2 = inputStream;
                th = th4;
                byteArrayOutputStream = null;
                if (inputStream2 != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            byteArrayOutputStream = null;
            throw new WeiboException(e);
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
            if (inputStream2 != null) {
            }
            if (byteArrayOutputStream != null) {
            }
            throw th;
        }
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str;
        String str2 = "";
        if (!TextUtils.isEmpty(weiboParameters.getAppKey())) {
            str = Utility.getAid(context, weiboParameters.getAppKey());
            if (!TextUtils.isEmpty(str)) {
                weiboParameters.put("aid", str);
            }
        } else {
            str = str2;
        }
        String timestamp = getTimestamp();
        weiboParameters.put("oauth_timestamp", timestamp);
        Object obj = weiboParameters.get("access_token");
        Object obj2 = weiboParameters.get("refresh_token");
        Object obj3 = weiboParameters.get("phone");
        if (obj != null && (obj instanceof String)) {
            str2 = (String) obj;
        } else if (obj2 != null && (obj2 instanceof String)) {
            str2 = (String) obj2;
        } else if (obj3 != null && (obj3 instanceof String)) {
            str2 = (String) obj3;
        }
        weiboParameters.put("oauth_sign", getOauthSign(context, str, str2, weiboParameters.getAppKey(), timestamp));
    }

    public static String openRedirectUrl4LocationUri(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpURLConnection httpURLConnection;
        if (str2.equals("GET")) {
            if (str.endsWith("?")) {
                str = str + weiboParameters.encodeUrl();
            } else {
                str = str + "?" + weiboParameters.encodeUrl();
            }
            httpURLConnection = ConnectionFactory.createConnect(str, context);
        } else {
            httpURLConnection = ConnectionFactory.createConnect(str, context);
        }
        try {
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode != 302) {
                if (responseCode != 301) {
                    if (responseCode != 200) {
                        str = "";
                    }
                    return str;
                }
            }
            str = httpURLConnection.getHeaderField("Location");
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized String downloadFile(Context context, String str, String str2, String str3) throws WeiboException {
        long j;
        long j2;
        synchronized (HttpManager.class) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, str3);
            if (file2.exists()) {
                return file2.getPath();
            } else if (!URLUtil.isValidUrl(str)) {
                return "";
            } else {
                File file3 = new File(str2, str3 + "_temp");
                HttpURLConnection createConnect = ConnectionFactory.createConnect(str, context);
                createConnect.setConnectTimeout(300000);
                createConnect.setReadTimeout(300000);
                try {
                    createConnect.setRequestMethod("GET");
                } catch (Exception unused) {
                }
                try {
                    if (file3.exists()) {
                        j = file3.length();
                    } else {
                        file3.createNewFile();
                        j = 0;
                    }
                    createConnect.setRequestProperty("RANGE", "bytes=" + j);
                    int responseCode = createConnect.getResponseCode();
                    if (responseCode == 206) {
                        j2 = 0;
                    } else if (responseCode == 200) {
                        j2 = (long) createConnect.getContentLength();
                    } else {
                        throw new WeiboHttpException(readConnectResponse(createConnect, true), responseCode);
                    }
                    InputStream inputStream = createConnect.getInputStream();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.seek(0);
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        randomAccessFile.write(bArr, 0, read);
                    }
                    randomAccessFile.close();
                    inputStream.close();
                    if (j2 != 0) {
                        if (file3.length() >= j2) {
                            file3.renameTo(file2);
                            return file2.getPath();
                        }
                    }
                    file3.delete();
                } catch (Exception unused2) {
                }
                return "";
            }
        }
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        try {
            Set<String> keySet = weiboParameters.keySet();
            for (String str : keySet) {
                if (weiboParameters.get(str) instanceof String) {
                    StringBuilder sb = new StringBuilder(100);
                    sb.setLength(0);
                    sb.append(MP_BOUNDARY);
                    sb.append("\r\n");
                    sb.append("content-disposition: form-data; name=\"");
                    sb.append(str);
                    sb.append("\"\r\n\r\n");
                    sb.append(weiboParameters.get(str));
                    sb.append("\r\n");
                    outputStream.write(sb.toString().getBytes());
                }
            }
            for (String str2 : keySet) {
                Object obj = weiboParameters.get(str2);
                if (obj instanceof Bitmap) {
                    outputStream.write((MP_BOUNDARY + "\r\ncontent-disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"\r\nContent-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write("\r\n".getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    outputStream.write((MP_BOUNDARY + "\r\ncontent-disposition: form-data; name=\"" + str2 + "\"; filename=\"file\"\r\nContent-Type: application/octet-stream; charset=utf-8\r\n\r\n").getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write("\r\n".getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            outputStream.write(("\r\n" + END_MP_BOUNDARY).getBytes());
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    public static String getBoundry() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i);
            long j = currentTimeMillis % 3;
            if (j == 0) {
                stringBuffer.append(((char) ((int) currentTimeMillis)) % '\t');
            } else if (j == 1) {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 65)));
            } else {
                stringBuffer.append((char) ((int) ((currentTimeMillis % 26) + 97)));
            }
        }
        return stringBuffer.toString();
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
        }
        return calcOauthSignNative(context, sb.toString(), str4);
    }
}
