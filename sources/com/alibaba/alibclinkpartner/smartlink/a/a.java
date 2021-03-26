package com.alibaba.alibclinkpartner.smartlink.a;

import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class a {
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7 A[SYNTHETIC, Splitter:B:29:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b2 A[SYNTHETIC, Splitter:B:35:0x00b2] */
    public static b a(String str, Map<String, String> map) {
        Throwable th;
        Exception e;
        b bVar = new b();
        BufferedReader bufferedReader = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            a(httpURLConnection, map);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            int responseCode = httpURLConnection.getResponseCode();
            bVar.a = responseCode;
            if (responseCode == 200) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    bVar.b = sb.toString();
                    bVar.c = httpURLConnection.getHeaderFields();
                    ALSLLogUtil.d("ALSLHttpManager", "get请求", "http get请求成功");
                    try {
                        bufferedReader2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return bVar;
                } catch (Exception e3) {
                    e = e3;
                    bufferedReader = bufferedReader2;
                    try {
                        ALSLLogUtil.e("ALSLHttpManager", "get", "http get请求失败，错误信息为：" + e.toString());
                        if (bufferedReader != null) {
                        }
                        return bVar;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                    }
                    throw th;
                }
            } else {
                bVar.c = httpURLConnection.getHeaderFields();
                ALSLLogUtil.d("ALSLHttpManager", "get请求", "http get请求失败，错误码：" + httpURLConnection.getResponseCode());
                return bVar;
            }
        } catch (Exception e5) {
            e = e5;
            ALSLLogUtil.e("ALSLHttpManager", "get", "http get请求失败，错误信息为：" + e.toString());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            return bVar;
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (!(httpURLConnection == null || map == null)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        }
    }
}
