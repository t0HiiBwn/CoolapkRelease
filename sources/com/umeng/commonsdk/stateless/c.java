package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* compiled from: UMSLNetWorkSenderHelper */
public class c {
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;

    public c(Context context) {
        this.c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.i = DataHelper.assembleStatelessURL(imprintProperty);
        }
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.h = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.k = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.i = a.k;
        if (TextUtils.isEmpty(b.b)) {
            return;
        }
        if (b.b.startsWith("460") || b.b.startsWith("461")) {
            a.i = a.h;
        }
    }

    private boolean c() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        Context context = this.c;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.c.getPackageName()) != 0) {
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

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0129 A[SYNTHETIC, Splitter:B:39:0x0129] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x013e A[SYNTHETIC, Splitter:B:48:0x013e] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0145  */
    public boolean a(byte[] bArr, String str, String str2, String str3) {
        HttpsURLConnection httpsURLConnection;
        SSLHandshakeException e;
        InputStream inputStream;
        Throwable th;
        boolean z = false;
        if (bArr == null || str == null) {
            ULog.i("walle", "[stateless] sendMessage, envelopeByte == null || path == null ");
            return false;
        }
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            a.h = a.k;
            b();
        }
        String str4 = a.i;
        if (TextUtils.isEmpty(str2)) {
            str2 = str4;
        }
        OutputStream outputStream = null;
        try {
            if (c()) {
                httpsURLConnection = (HttpsURLConnection) new URL(str2 + File.separator + str).openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.a, this.b)));
            } else {
                httpsURLConnection = (HttpsURLConnection) new URL(str2 + File.separator + str).openConnection();
            }
            try {
                httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(instance.getSocketFactory());
                httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                httpsURLConnection.setRequestProperty("Content-Type", "ut/" + str3);
                httpsURLConnection.setConnectTimeout(30000);
                httpsURLConnection.setReadTimeout(30000);
                httpsURLConnection.setRequestMethod("POST");
                httpsURLConnection.setDoOutput(true);
                httpsURLConnection.setDoInput(true);
                httpsURLConnection.setUseCaches(false);
                OutputStream outputStream2 = httpsURLConnection.getOutputStream();
                outputStream2.write(bArr);
                outputStream2.flush();
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    UMRTLog.i("MobclickRT", "--->>> send stateless message success : " + a.i + "/" + str);
                    z = true;
                }
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (Exception unused) {
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        inputStream = httpsURLConnection.getInputStream();
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                    httpsURLConnection.disconnect();
                }
            } catch (SSLHandshakeException e2) {
                e = e2;
                MLog.e("SSLHandshakeException, Failed to send message.", e);
                if (0 != 0) {
                }
                if (httpsURLConnection != null) {
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                try {
                    MLog.e("Exception,Failed to send message.", th);
                    if (0 != 0) {
                    }
                    if (httpsURLConnection != null) {
                    }
                    return z;
                } catch (Throwable th3) {
                    if (0 != 0) {
                        try {
                            outputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (httpsURLConnection != null) {
                        try {
                            httpsURLConnection.getInputStream().close();
                        } catch (IOException unused4) {
                        }
                        httpsURLConnection.disconnect();
                    }
                    throw th3;
                }
            }
        } catch (SSLHandshakeException e3) {
            e = e3;
            httpsURLConnection = null;
            MLog.e("SSLHandshakeException, Failed to send message.", e);
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (Exception unused5) {
                }
            }
            if (httpsURLConnection != null) {
                inputStream = httpsURLConnection.getInputStream();
                inputStream.close();
                httpsURLConnection.disconnect();
            }
            return z;
        } catch (Throwable th4) {
            th = th4;
            httpsURLConnection = null;
            MLog.e("Exception,Failed to send message.", th);
            if (0 != 0) {
                try {
                    outputStream.close();
                } catch (Exception unused6) {
                }
            }
            if (httpsURLConnection != null) {
                inputStream = httpsURLConnection.getInputStream();
                inputStream.close();
                httpsURLConnection.disconnect();
            }
            return z;
        }
        return z;
    }
}
