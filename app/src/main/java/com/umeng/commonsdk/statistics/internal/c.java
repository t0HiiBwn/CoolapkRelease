package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.k;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: NetworkHelper */
public class c {
    private static boolean e;
    private static boolean f;
    private static boolean g;
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;
    private b d;

    public c(Context context) {
        this.c = context;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(b.b)) {
            return;
        }
        if (b.b.startsWith("460") || b.b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (!g) {
            ImprintHandler.getImprintService(this.c).registImprintCallback("cfgfd", new UMImprintChangeCallback() {
                /* class com.umeng.commonsdk.statistics.internal.c.AnonymousClass1 */

                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public void onImprintValueChanged(String str, String str2) {
                    if (FieldManager.b()) {
                        FieldManager.a().a(c.this.c, str2);
                        UMRTLog.e("MobclickRT", "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                        UMWorkDispatch.sendEvent(c.this.c, 32788, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                    }
                }
            });
            g = true;
        }
    }

    private void d() {
        if (!f) {
            UMRTLog.e("MobclickRT", "--->>> 注册零号报文 imprint 应答处理回调。");
            ImprintHandler.getImprintService(this.c).registPreProcessCallback("iscfg", new UMImprintPreProcessCallback() {
                /* class com.umeng.commonsdk.statistics.internal.c.AnonymousClass2 */

                @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
                public boolean onPreProcessImprintKey(String str, String str2) {
                    UMRTLog.e("MobclickRT", "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.a().a(c.this.c);
                    UMWorkDispatch.sendEvent(c.this.c, 32784, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                    ImprintHandler.getImprintService(c.this.c).a("iscfg");
                    return true;
                }
            });
            ImprintHandler.getImprintService(this.c).registImprintCallback("cfgfd", new UMImprintChangeCallback() {
                /* class com.umeng.commonsdk.statistics.internal.c.AnonymousClass3 */

                @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
                public void onImprintValueChanged(String str, String str2) {
                    UMRTLog.e("MobclickRT", "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                    FieldManager.a().a(c.this.c, str2);
                    UMWorkDispatch.sendEvent(c.this.c, 32784, com.umeng.commonsdk.internal.b.a(c.this.c).a(), null);
                    if (FieldManager.allow("header_foreground_count")) {
                        UMRTLog.i("MobclickRT", "--->>> recv zcfg response: foregound count timer enabled.");
                        if (!UMWorkDispatch.eventHasExist()) {
                            UMWorkDispatch.sendEventEx(c.this.c, 8213, CoreProtocol.getInstance(c.this.c), null, 0);
                        }
                    }
                    if (FieldManager.allow("header_first_resume")) {
                        UMRTLog.i("MobclickRT", "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                        k.a(c.this.c).b(c.this.c);
                    }
                    ImprintHandler.getImprintService(c.this.c).unregistImprintCallback("cfgfd", this);
                }
            });
            f = true;
        }
    }

    public byte[] a(byte[] bArr, boolean z, boolean z2, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i = 0;
        byte[] bArr2 = null;
        while (true) {
            if (i >= AnalyticsConstants.APPLOG_URL_LIST.length) {
                break;
            }
            String str2 = AnalyticsConstants.APPLOG_URL_LIST[i];
            if (z2) {
                d();
            } else {
                c();
            }
            bArr2 = a(bArr, str2 + File.separator + str);
            if (bArr2 != null) {
                b bVar = this.d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z);
                }
            } else {
                b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i++;
            }
        }
        return bArr2;
    }

    private boolean e() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (this.c.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
            if (!DeviceConfig.checkPermission(this.c, "android.permission.ACCESS_NETWORK_STATE") || connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || activeNetworkInfo.getType() == 1 || (extraInfo = activeNetworkInfo.getExtraInfo()) == null || (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap"))) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.c, th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0177 A[SYNTHETIC, Splitter:B:103:0x0177] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012b A[SYNTHETIC, Splitter:B:66:0x012b] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0137 A[SYNTHETIC, Splitter:B:71:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014b A[SYNTHETIC, Splitter:B:83:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0157 A[SYNTHETIC, Splitter:B:88:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x016b A[SYNTHETIC, Splitter:B:98:0x016b] */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        boolean z;
        try {
            b bVar = this.d;
            if (bVar != null) {
                bVar.onRequestStart();
            }
            if (e()) {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.a, this.b)));
            } else {
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            }
            try {
                z = true;
                if (!e) {
                    httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                    SSLContext instance = SSLContext.getInstance("TLS");
                    instance.init(null, null, new SecureRandom());
                    httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
                    e = true;
                }
                httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.c).b());
                httpsURLConnection.setRequestProperty("Content-Type", a.a(this.c).a());
                httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                outputStream = httpsURLConnection.getOutputStream();
            } catch (SSLHandshakeException unused) {
                outputStream = null;
                UMLog.aq("A_10201", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e2) {
                        UMCrashManager.reportCrash(this.c, e2);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused2) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            } catch (UnknownHostException unused3) {
                outputStream = null;
                try {
                    UMLog.aq("A_10200", 2, "\\|");
                    return null;
                } finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e3) {
                            UMCrashManager.reportCrash(this.c, e3);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused4) {
                        }
                        httpsURLConnection.disconnect();
                    }
                }
            } catch (Throwable unused5) {
                outputStream = null;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(this.c, e4);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused6) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            }
            try {
                outputStream.write(bArr);
                outputStream.flush();
                httpsURLConnection.connect();
                b bVar2 = this.d;
                if (bVar2 != null) {
                    bVar2.onRequestEnd();
                }
                int responseCode = httpsURLConnection.getResponseCode();
                String headerField = httpsURLConnection.getHeaderField("Content-Type");
                if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                    z = false;
                }
                boolean z2 = AnalyticsConstants.UM_DEBUG;
                if (responseCode != 200 || !z) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e5) {
                            UMCrashManager.reportCrash(this.c, e5);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused7) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return null;
                }
                InputStream inputStream = httpsURLConnection.getInputStream();
                try {
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e6) {
                            UMCrashManager.reportCrash(this.c, e6);
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused8) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    return readStreamToByteArray;
                } finally {
                    HelperUtils.safeClose(inputStream);
                }
            } catch (SSLHandshakeException unused9) {
                UMLog.aq("A_10201", 2, "\\|");
                if (outputStream != null) {
                }
                if (httpsURLConnection != null) {
                }
                return null;
            } catch (UnknownHostException unused10) {
                UMLog.aq("A_10200", 2, "\\|");
                return null;
            } catch (Throwable unused11) {
                if (outputStream != null) {
                }
                if (httpsURLConnection != null) {
                }
                return null;
            }
        } catch (SSLHandshakeException unused12) {
            httpsURLConnection = null;
            outputStream = null;
            UMLog.aq("A_10201", 2, "\\|");
            if (outputStream != null) {
            }
            if (httpsURLConnection != null) {
            }
            return null;
        } catch (UnknownHostException unused13) {
            httpsURLConnection = null;
            outputStream = null;
            UMLog.aq("A_10200", 2, "\\|");
            return null;
        } catch (Throwable unused14) {
            httpsURLConnection = null;
            outputStream = null;
            if (outputStream != null) {
            }
            if (httpsURLConnection != null) {
            }
            return null;
        }
    }
}
