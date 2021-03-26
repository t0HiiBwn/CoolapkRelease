package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.core.a;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class LogUploadUtil {
    private static int a;

    public static void uploadFile(final Context context, final String str, final String str2, final String str3, final HttpRequestCallback httpRequestCallback) {
        CommonWorkingThread.getInstance().execute(new Runnable() {
            /* class com.tencent.tpns.baseapi.base.logger.LogUploadUtil.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                LogUploadUtil.b(context, str, str2, str3, httpRequestCallback);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, String str2, String str3, HttpRequestCallback httpRequestCallback) {
        if (context == null) {
            TBaseLogger.w("LogUploadUtil - TPush", "unexpected for uploadFile, context is null");
            a(httpRequestCallback, -1, "context is null");
        } else if (TextUtils.isEmpty(str)) {
            TBaseLogger.w("LogUploadUtil - TPush", "unexpected for uploadFile, log cannot be found");
            a(httpRequestCallback, -1, "unexpected for uploadFile, log cannot be found");
        } else {
            try {
                long accessId = XGApiConfig.getAccessId(context);
                if (accessId == -1) {
                    a(httpRequestCallback, -1, "unexpected for uploadFile, log cannot be found");
                    return;
                }
                String str4 = str + File.separator + str2;
                String str5 = str + File.separator + str3;
                String str6 = str5 + File.separator + accessId + "_" + GuidInfoManager.getToken(context) + "_" + LogUtil.getTodayDateTimeForFilename() + ".zip";
                File file = new File(str6);
                file.getParentFile().mkdirs();
                if (!file.exists() && !file.createNewFile()) {
                    TBaseLogger.w("LogUploadUtil - TPush", "unexpected createNewFile return false");
                }
                a(str4, str6);
                if (file.length() > 104857600) {
                    a(httpRequestCallback, -1, "log upload error, please try again.");
                    a(str5);
                    int i = a + 1;
                    a = i;
                    TBaseLogger.removeOldDebugLogFiles(i);
                    return;
                }
                a(context, file, a.h(context), httpRequestCallback);
                a(str5);
                a(str4);
            } catch (Throwable th) {
                TBaseLogger.w("LogUploadUtil - TPush", "unexpected exception for uploadFile:" + th.getMessage());
                a(httpRequestCallback, -1, "unexpected exception for uploadFile:" + th.getMessage());
            }
        }
    }

    private static void a(Context context, File file, String str, HttpRequestCallback httpRequestCallback) {
        String str2 = "TPNS" + System.currentTimeMillis();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestProperty("connection", "keep-alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + str2);
            long accessId = XGApiConfig.getAccessId(context);
            String accessKey = XGApiConfig.getAccessKey(context);
            StringBuilder sb = new StringBuilder();
            sb.append("Basic ");
            sb.append(Base64.encodeToString((accessId + ":" + accessKey).getBytes("UTF-8"), 0));
            String sb2 = sb.toString();
            httpURLConnection.addRequestProperty("Authorization", sb2);
            TBaseLogger.d("LogUploadUtil - TPush", "Authorization Basic: " + accessId + ":" + accessKey + ", auth:" + sb2);
            if (file != null) {
                TBaseLogger.v("LogUploadUtil - TPush", "action - uploadFile, filename:" + file.getName() + ", url:" + str);
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("--");
                stringBuffer.append(str2);
                stringBuffer.append("\r\n");
                stringBuffer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + file.getName() + "\"\r\n");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Content-Type: application/octet-stream; charset=utf-8");
                sb3.append("\r\n");
                stringBuffer.append(sb3.toString());
                stringBuffer.append("\r\n");
                dataOutputStream.write(stringBuffer.toString().getBytes());
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write("\r\n".getBytes());
                dataOutputStream.write(("--" + str2 + "--\r\n").getBytes());
                dataOutputStream.flush();
                int responseCode = httpURLConnection.getResponseCode();
                String responseMessage = httpURLConnection.getResponseMessage();
                TBaseLogger.v("LogUploadUtil - TPush", "response code:" + responseCode + ", msg:" + responseMessage);
                if (responseCode == 200) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    StringBuffer stringBuffer2 = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer2.append(readLine);
                        } else {
                            TBaseLogger.i("LogUploadUtil - TPush", "HttpPost response data:" + stringBuffer2.toString());
                            a(httpRequestCallback, responseCode, responseMessage, stringBuffer2.toString());
                            bufferedReader.close();
                            return;
                        }
                    }
                } else {
                    TBaseLogger.e("LogUploadUtil - TPush", "HttpPost Server response error");
                    a(httpRequestCallback, responseCode, responseMessage);
                }
            }
        } catch (Throwable th) {
            TBaseLogger.e("LogUploadUtil - TPush", "unexpected for doUploadFile:", th);
            a(httpRequestCallback, -1, "unexpected exception for uploadFile:" + th.getMessage());
        }
    }

    private static void a(String str, String str2) {
        TBaseLogger.v("LogUploadUtil - TPush", "zipFolder, srcFile:" + str + ", zipFile:" + str2);
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
        File file = new File(str);
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            throw new NoSuchFieldException("no log files");
        }
        a(file.getParent() + File.separator, file.getName(), zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    private static void a(String str, String str2, ZipOutputStream zipOutputStream) {
        TBaseLogger.v("LogUploadUtil - TPush", "zipFiles, folder:" + str + ", fileName:" + str2);
        if (zipOutputStream != null) {
            File file = new File(str + str2);
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2);
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        zipOutputStream.putNextEntry(zipEntry);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read != -1) {
                                zipOutputStream.write(bArr, 0, read);
                            } else {
                                zipOutputStream.closeEntry();
                                fileInputStream2.close();
                                return;
                            }
                        }
                    } catch (Throwable unused) {
                        fileInputStream = fileInputStream2;
                        if (fileInputStream == null) {
                            fileInputStream.close();
                        }
                    }
                } catch (Throwable unused2) {
                    if (fileInputStream == null) {
                    }
                }
            } else {
                String[] list = file.list();
                if (list != null) {
                    if (list.length <= 0) {
                        zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                        zipOutputStream.closeEntry();
                    }
                    for (int i = 0; i < list.length; i++) {
                        a(str, str2 + File.separator + list[i], zipOutputStream);
                    }
                }
            }
        }
    }

    private static void a(HttpRequestCallback httpRequestCallback, int i, String str) {
        if (httpRequestCallback != null) {
            httpRequestCallback.onFailure(i, str);
        }
    }

    private static void a(HttpRequestCallback httpRequestCallback, int i, String str, String str2) {
        if (httpRequestCallback != null) {
            try {
                String optString = new JSONObject(str2).optString("url", "");
                TBaseLogger.v("LogUploadUtil - TPush", "fileUrl:" + optString);
                httpRequestCallback.onSuccess(optString);
            } catch (Throwable unused) {
                httpRequestCallback.onFailure(i, str + "\n" + str2);
            }
        }
    }

    private static void a(String str) {
        a(new File(str));
    }

    private static void a(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (file2.isFile()) {
                        file2.delete();
                    } else if (file2.isDirectory()) {
                        a(file2);
                    }
                }
            }
        }
    }
}
