package com.sina.weibo.sdk.network.base;

import android.os.Bundle;
import com.sina.weibo.sdk.network.IRequestParam;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public class RequestBodyHelper {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String OCTET_STREAM = "application/octet-stream";

    public static void fillRequestBody(IRequestParam iRequestParam, HttpURLConnection httpURLConnection, String str) throws IOException {
        byte[] byteArray = iRequestParam.getPostBundle().getByteArray("body_byte_array");
        OutputStream outputStream = httpURLConnection.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        if (byteArray != null) {
            if (iRequestParam.needGzip()) {
                dataOutputStream.write(transGzip(byteArray));
            } else {
                dataOutputStream.write(byteArray);
            }
        } else if (isMultipartRequest(iRequestParam)) {
            fillMultiBody(dataOutputStream, iRequestParam, str);
        } else {
            Bundle postBundle = iRequestParam.getPostBundle();
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String str2 : postBundle.keySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append("&");
                }
                try {
                    String valueOf = String.valueOf(postBundle.get(str2));
                    sb.append(URLEncoder.encode(str2, "UTF-8"));
                    sb.append("=");
                    sb.append(URLEncoder.encode(valueOf, "UTF-8"));
                } catch (Exception unused) {
                }
            }
            DataOutputStream dataOutputStream2 = new DataOutputStream(dataOutputStream);
            if (iRequestParam.needGzip()) {
                dataOutputStream2.write(transGzip(sb.toString().getBytes("UTF-8")));
            } else {
                dataOutputStream2.write(sb.toString().getBytes("UTF-8"));
            }
            dataOutputStream2.flush();
            dataOutputStream2.close();
        }
        outputStream.flush();
        outputStream.close();
    }

    public static boolean isMultipartRequest(IRequestParam iRequestParam) {
        return !iRequestParam.files().isEmpty() || !iRequestParam.byteArrays().isEmpty();
    }

    private static void fillMultiBody(OutputStream outputStream, IRequestParam iRequestParam, String str) throws IOException {
        Bundle postBundle = iRequestParam.getPostBundle();
        for (String str2 : postBundle.keySet()) {
            StringBuilder sb = new StringBuilder(100);
            sb.setLength(0);
            sb.append("--");
            sb.append(str);
            sb.append("\r\n");
            sb.append("Content-Disposition: form-data; name=\"");
            sb.append(str2);
            sb.append("\"");
            sb.append("\r\n");
            sb.append("Content-Type: text/plain;charset:\"UTF-8\"\r\n");
            sb.append("Content-Transfer-Encoding: 8bit");
            sb.append("\r\n");
            sb.append("\r\n");
            sb.append(String.valueOf(postBundle.get(str2)));
            sb.append("\r\n");
            outputStream.write(sb.toString().getBytes("UTF-8"));
        }
        Map<String, IRequestParam.ValuePart<File>> files = iRequestParam.files();
        for (String str3 : files.keySet()) {
            IRequestParam.ValuePart<File> valuePart = files.get(str3);
            T t = valuePart.value;
            String str4 = valuePart.mimeType;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("--");
            stringBuffer.append(str);
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Disposition: form-data; name=\"");
            stringBuffer.append(str3);
            stringBuffer.append("\";");
            stringBuffer.append("filename=\"");
            stringBuffer.append(t.getName());
            stringBuffer.append("\"");
            stringBuffer.append("\r\n");
            stringBuffer.append("Content-Type: " + str4 + ";charset:\"UTF-8\"\r\n");
            stringBuffer.append("\r\n");
            outputStream.write(stringBuffer.toString().getBytes("UTF-8"));
            FileInputStream fileInputStream = new FileInputStream((File) t);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                outputStream.write(bArr, 0, read);
            }
            fileInputStream.close();
            outputStream.write("\r\n".getBytes());
        }
        Map<String, byte[]> byteArrays = iRequestParam.byteArrays();
        for (String str5 : byteArrays.keySet()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("--");
            stringBuffer2.append(str);
            stringBuffer2.append("\r\n");
            stringBuffer2.append("Content-Disposition: form-data; name=\"");
            stringBuffer2.append(str5);
            stringBuffer2.append("\"");
            stringBuffer2.append("\r\n");
            stringBuffer2.append("Content-Type: text/plain;charset:\"UTF-8\"\r\n");
            stringBuffer2.append("\r\n");
            outputStream.write(stringBuffer2.toString().getBytes());
            outputStream.write(byteArrays.get(str5));
            outputStream.write("\r\n".getBytes());
        }
        outputStream.write(("--" + str + "--\r\n").getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private static byte[] transGzip(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
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
}
