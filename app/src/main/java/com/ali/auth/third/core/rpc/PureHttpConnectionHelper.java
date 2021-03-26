package com.ali.auth.third.core.rpc;

import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.IOUtils;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PureHttpConnectionHelper extends a {
    private static final String a = "PureHttpConnectionHelper";

    public static String get(String str) {
        HttpURLConnection httpURLConnection;
        OutputStreamWriter outputStreamWriter;
        Throwable th;
        SDKLogger.d(a, "get url = " + str);
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
            } catch (Throwable th2) {
                outputStreamWriter = null;
                th = th2;
                try {
                    throw new RuntimeException(th);
                } catch (Throwable th3) {
                    IOUtils.closeQuietly(outputStreamWriter);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused) {
                        }
                    }
                    throw th3;
                }
            }
            try {
                outputStreamWriter.flush();
                if (httpURLConnection.getResponseCode() == 200) {
                    String byteArrayOutputStream = a(httpURLConnection.getInputStream()).toString(a(httpURLConnection.getContentType()));
                    IOUtils.closeQuietly(outputStreamWriter);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception unused2) {
                        }
                    }
                    return byteArrayOutputStream;
                }
                throw new RuntimeException("http request exception, response code: " + httpURLConnection.getResponseCode());
            } catch (Throwable th4) {
                th = th4;
                throw new RuntimeException(th);
            }
        } catch (Throwable th5) {
            outputStreamWriter = null;
            th = th5;
            httpURLConnection = null;
            throw new RuntimeException(th);
        }
    }
}
