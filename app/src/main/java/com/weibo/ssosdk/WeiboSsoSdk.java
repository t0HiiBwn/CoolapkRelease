package com.weibo.ssosdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

public class WeiboSsoSdk {
    private static final String AID_FILE_NAME = "weibo_sso_sdk_aid";
    private static final String INIT_FILE_NAME = "weibo_sso_sdk_init";
    private static final String LOGIN_URL = "https://login.sina.com.cn/visitor/signin";
    private static final int SDK_ACT_UPLOAD = 2;
    private static final int SDK_ACT_VISITORLOGIN = 1;
    public static final String SDK_VERSION_CODE = "1.0";
    private static final String TAG = "WeiboSsoSdk";
    private static final int VERSION = 1;
    private static WeiboSsoSdkConfig config;
    private static WeiboSsoSdk sInstance;
    private boolean isFirstUpload = true;
    private int mCallCount;
    private volatile ReentrantLock mTaskLock = new ReentrantLock(true);
    private VisitorLoginInfo mVisitorLoginInfo;

    private static void LogD(String str) {
    }

    private static void LogE(String str) {
    }

    private native String riseWind(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, int i2);

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() throws Exception {
        WeiboSsoSdkConfig weiboSsoSdkConfig = config;
        if (weiboSsoSdkConfig == null || !weiboSsoSdkConfig.verify()) {
            throw new Exception("config error");
        }
        this.mCallCount = 0;
        new Thread(new Runnable() {
            /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass1 */

            @Override // java.lang.Runnable
            public void run() {
                String str;
                while (true) {
                    try {
                        Thread.sleep(86400000);
                        if (WeiboSsoSdk.this.mVisitorLoginInfo == null || TextUtils.isEmpty(WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) {
                            str = WeiboSsoSdk.this.loadAidFromCache();
                        } else {
                            str = WeiboSsoSdk.this.mVisitorLoginInfo.getAid();
                        }
                        WeiboSsoSdk.getInstance().updateInfo(str, 2);
                    } catch (Exception unused) {
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    Thread.sleep(60000);
                    if (WeiboSsoSdk.this.isFirstUpload) {
                        if (WeiboSsoSdk.this.mVisitorLoginInfo == null || TextUtils.isEmpty(WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) {
                            str = WeiboSsoSdk.this.loadAidFromCache();
                        } else {
                            str = WeiboSsoSdk.this.mVisitorLoginInfo.getAid();
                        }
                        WeiboSsoSdk.this.updateInfo(str, 2);
                    }
                } catch (Exception unused) {
                }
            }
        }).start();
    }

    public static synchronized boolean initConfig(WeiboSsoSdkConfig weiboSsoSdkConfig) {
        synchronized (WeiboSsoSdk.class) {
            if (weiboSsoSdkConfig == null) {
                return false;
            }
            if (!weiboSsoSdkConfig.verify()) {
                return false;
            }
            if (config != null) {
                return false;
            }
            WeiboSsoSdkConfig weiboSsoSdkConfig2 = (WeiboSsoSdkConfig) weiboSsoSdkConfig.clone();
            config = weiboSsoSdkConfig2;
            MfpBuilder.init(weiboSsoSdkConfig2.getApplicationContext());
            return true;
        }
    }

    public static synchronized WeiboSsoSdk getInstance() throws Exception {
        WeiboSsoSdk weiboSsoSdk;
        synchronized (WeiboSsoSdk.class) {
            if (sInstance == null) {
                sInstance = new WeiboSsoSdk();
            }
            weiboSsoSdk = sInstance;
        }
        return weiboSsoSdk;
    }

    public void updateSub(String str) {
        if (!TextUtils.isEmpty(str)) {
            config.setSub(str);
            String visitorSub = this.mVisitorLoginInfo.getVisitorSub();
            if (TextUtils.isEmpty(visitorSub) || !visitorSub.equals(str)) {
                new Thread(new Runnable() {
                    /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass3 */

                    @Override // java.lang.Runnable
                    public void run() {
                        String str;
                        if (WeiboSsoSdk.this.mVisitorLoginInfo == null || TextUtils.isEmpty(WeiboSsoSdk.this.mVisitorLoginInfo.getAid())) {
                            str = WeiboSsoSdk.this.loadAidFromCache();
                        } else {
                            str = WeiboSsoSdk.this.mVisitorLoginInfo.getAid();
                        }
                        try {
                            WeiboSsoSdk.this.updateInfo(str, 2);
                        } catch (Exception unused) {
                        }
                    }
                }).start();
            }
        }
    }

    public static final class VisitorLoginInfo {
        private String mAid = "";
        private String mSubCookie = "";

        public String getAid() {
            return this.mAid;
        }

        public String getVisitorSub() {
            return this.mSubCookie;
        }

        static VisitorLoginInfo parseJson(String str) throws Exception {
            VisitorLoginInfo visitorLoginInfo = new VisitorLoginInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("retcode", "");
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                if (!optString.equals("20000000") || jSONObject2 == null) {
                    throw new Exception("error： " + optString + " msg:" + jSONObject.optString("msg", ""));
                }
                visitorLoginInfo.mAid = jSONObject2.optString("aid", "");
                visitorLoginInfo.mSubCookie = jSONObject2.optString("sub", "");
                return visitorLoginInfo;
            } catch (Exception e) {
                throw e;
            }
        }

        VisitorLoginInfo cloneAidInfo() {
            VisitorLoginInfo visitorLoginInfo = new VisitorLoginInfo();
            visitorLoginInfo.mAid = this.mAid;
            visitorLoginInfo.mSubCookie = this.mSubCookie;
            return visitorLoginInfo;
        }
    }

    private String do_post(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://login.sina.com.cn/visitor/signin").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setConnectTimeout(1000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(str.getBytes());
            outputStream.flush();
            if (httpURLConnection.getResponseCode() != 200) {
                return null;
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void updateInfo(String str, int i) throws Exception {
        String str2;
        if (!TextUtils.isEmpty(config.getAppKey(false))) {
            if (!this.mTaskLock.tryLock()) {
                this.mTaskLock.lock();
                this.mTaskLock.unlock();
                return;
            }
            this.isFirstUpload = false;
            String mfp = MfpBuilder.getMfp(config.getApplicationContext());
            try {
                str2 = URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException unused) {
                str2 = "";
            }
            String do_post = do_post(riseWind(config.getAppKey(true), config.getApplicationContext().getPackageName(), str2, mfp, config.getFrom(true), config.getOldWm(true), config.getWm(true), config.getSub(true), config.getSmid(true), config.getExtraString(true), i, this.mCallCount));
            this.mCallCount++;
            if (do_post != null) {
                try {
                    VisitorLoginInfo parseJson = VisitorLoginInfo.parseJson(do_post);
                    if (parseJson != null && !TextUtils.isEmpty(parseJson.getAid())) {
                        cacheAidInfo(parseJson.getAid());
                    }
                    if (i == 1) {
                        this.mVisitorLoginInfo = parseJson;
                    }
                    this.mTaskLock.unlock();
                } catch (Exception e) {
                    this.mTaskLock.unlock();
                    throw e;
                }
            } else {
                this.mTaskLock.unlock();
                throw new Exception("network error.");
            }
        }
    }

    public VisitorLoginInfo visitorLogin() throws Exception {
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || TextUtils.isEmpty(visitorLoginInfo.getAid()) || TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
            Thread thread = new Thread(new Runnable() {
                /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass4 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                }
            });
            thread.start();
            thread.join();
            VisitorLoginInfo visitorLoginInfo2 = this.mVisitorLoginInfo;
            if (visitorLoginInfo2 == null || TextUtils.isEmpty(visitorLoginInfo2.getAid()) || TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
                throw new Exception("visitor login failed");
            }
        }
        return this.mVisitorLoginInfo;
    }

    public void visitorLogin(final VisitorLoginListener visitorLoginListener) {
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || TextUtils.isEmpty(visitorLoginInfo.getAid()) || TextUtils.isEmpty(this.mVisitorLoginInfo.getVisitorSub())) {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass5 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                    if (WeiboSsoSdk.this.mVisitorLoginInfo == null) {
                        WeiboSsoSdk.this.mVisitorLoginInfo = new VisitorLoginInfo();
                    }
                    visitorLoginListener.handler(WeiboSsoSdk.this.mVisitorLoginInfo);
                }
            });
        } else {
            visitorLoginListener.handler(this.mVisitorLoginInfo);
        }
    }

    public String getAid() throws Exception {
        String loadAidFromCache = loadAidFromCache();
        if (!TextUtils.isEmpty(loadAidFromCache)) {
            return loadAidFromCache;
        }
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || TextUtils.isEmpty(visitorLoginInfo.getAid())) {
            Thread thread = new Thread(new Runnable() {
                /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass6 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                }
            });
            thread.start();
            thread.join();
            VisitorLoginInfo visitorLoginInfo2 = this.mVisitorLoginInfo;
            if (visitorLoginInfo2 == null || TextUtils.isEmpty(visitorLoginInfo2.getAid())) {
                throw new Exception("visitor login failed");
            }
        }
        return this.mVisitorLoginInfo.getAid();
    }

    public void getAid(final AidListener aidListener) throws Exception {
        String loadAidFromCache = loadAidFromCache();
        if (!TextUtils.isEmpty(loadAidFromCache)) {
            aidListener.handler(loadAidFromCache);
        }
        VisitorLoginInfo visitorLoginInfo = this.mVisitorLoginInfo;
        if (visitorLoginInfo == null || TextUtils.isEmpty(visitorLoginInfo.getAid())) {
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                /* class com.weibo.ssosdk.WeiboSsoSdk.AnonymousClass7 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        WeiboSsoSdk.this.updateInfo("", 1);
                    } catch (Exception unused) {
                    }
                    if (WeiboSsoSdk.this.mVisitorLoginInfo == null) {
                        WeiboSsoSdk.this.mVisitorLoginInfo = new VisitorLoginInfo();
                    }
                    aidListener.handler(WeiboSsoSdk.this.mVisitorLoginInfo.getAid());
                }
            });
        } else {
            aidListener.handler(this.mVisitorLoginInfo.getAid());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025 A[SYNTHETIC, Splitter:B:15:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c A[SYNTHETIC, Splitter:B:21:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public String loadAidFromCache() {
        Throwable th;
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(getAidInfoFile(1));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str = new String(bArr);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Exception unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                return "";
            }
            try {
                fileInputStream.close();
                return "";
            } catch (IOException unused4) {
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private File getAidInfoFile(int i) {
        File filesDir = config.getApplicationContext().getFilesDir();
        return new File(filesDir, "weibo_sso_sdk_aid" + i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0027 A[SYNTHETIC, Splitter:B:19:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002e  */
    private synchronized void cacheAidInfo(String str) {
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(getAidInfoFile(1));
                try {
                    fileOutputStream2.write(str.getBytes());
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception unused2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0025 A[SYNTHETIC, Splitter:B:14:0x0025] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002c A[SYNTHETIC, Splitter:B:21:0x002c] */
    private String loadInitFile() {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(getInitFile());
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (Exception unused2) {
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                }
                throw th;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private File getInitFile() {
        return new File(config.getApplicationContext().getFilesDir(), "weibo_sso_sdk_init");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002d  */
    private synchronized void saveInitFile(String str) {
        Throwable th;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(getInitFile());
                try {
                    fileOutputStream2.write(str.getBytes());
                    try {
                        fileOutputStream2.close();
                    } catch (IOException unused) {
                    }
                } catch (Exception unused2) {
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }
}
