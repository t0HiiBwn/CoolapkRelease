package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class WebViewSSLCheckThread extends Thread {
    private static final String TAG = "WebViewSSLCheckThread";
    private SSLSocketFactory L;
    private org.apache.http.conn.ssl.SSLSocketFactory M;
    private X509HostnameVerifier N;
    private SslErrorHandler O;
    private String P;
    private Callback Q;
    private HostnameVerifier hostnameVerifier;
    private Context u;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    public WebViewSSLCheckThread() {
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactory(new c(context)));
        setHostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory((KeyStore) null, new c(context)));
        } catch (UnrecoverableKeyException e) {
            String str2 = TAG;
            g.e(str2, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier2) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier2);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.O = sslErrorHandler;
        this.P = str;
        this.M = sSLSocketFactory;
        this.N = x509HostnameVerifier;
        this.Q = callback;
        this.u = context;
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, null);
    }

    public static void checkServerCertificateWithOK(final SslErrorHandler sslErrorHandler, final String str, final Context context, final Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            g.e(TAG, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactory secureSSLSocketFactory = new SecureSSLSocketFactory(new c(context));
            secureSSLSocketFactory.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactory, new c(context));
            builder.hostnameVerifier(SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new okhttp3.Callback() {
                /* class com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.AnonymousClass1 */

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    String str = WebViewSSLCheckThread.TAG;
                    g.e(str, "onFailure , IO Exception : " + iOException.getMessage());
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onCancel(context, str);
                    } else {
                        sslErrorHandler.cancel();
                    }
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    g.e(WebViewSSLCheckThread.TAG, "onResponse . proceed");
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onProceed(context, str);
                    } else {
                        sslErrorHandler.proceed();
                    }
                }
            });
        } catch (Exception e) {
            String str2 = TAG;
            g.e(str2, "checkServerCertificateWithOK: exception : " + e.getMessage());
            sslErrorHandler.cancel();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Throwable th;
        HttpsURLConnection httpsURLConnection;
        Exception e;
        super.run();
        HttpsURLConnection httpsURLConnection2 = null;
        if (this.M == null || this.N == null) {
            if (this.L == null || this.hostnameVerifier == null) {
                b();
                return;
            }
            try {
                URLConnection openConnection = new URL(this.P).openConnection();
                if (openConnection instanceof HttpsURLConnection) {
                    httpsURLConnection = (HttpsURLConnection) openConnection;
                    try {
                        httpsURLConnection.setSSLSocketFactory(this.L);
                        httpsURLConnection.setHostnameVerifier(this.hostnameVerifier);
                        httpsURLConnection.setRequestMethod("GET");
                        httpsURLConnection.setConnectTimeout(10000);
                        httpsURLConnection.setReadTimeout(20000);
                        httpsURLConnection.connect();
                        httpsURLConnection2 = httpsURLConnection;
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            g.e(TAG, "exception : " + e.getMessage());
                            b();
                            if (httpsURLConnection == null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (httpsURLConnection != null) {
                                httpsURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                }
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                c();
            } catch (Exception e3) {
                e = e3;
                httpsURLConnection = null;
                g.e(TAG, "exception : " + e.getMessage());
                b();
                if (httpsURLConnection == null) {
                    httpsURLConnection.disconnect();
                }
            } catch (Throwable th3) {
                th = th3;
                httpsURLConnection = null;
                if (httpsURLConnection != null) {
                }
                throw th;
            }
        } else if (this.O == null || TextUtils.isEmpty(this.P)) {
            g.e(TAG, "sslErrorHandler or url is null");
            b();
        } else {
            try {
                this.M.setHostnameVerifier(this.N);
                org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory = this.M;
                if (sSLSocketFactory instanceof SecureApacheSSLSocketFactory) {
                    ((SecureApacheSSLSocketFactory) sSLSocketFactory).setContext(this.u);
                }
                BasicHttpParams basicHttpParams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                SchemeRegistry schemeRegistry = new SchemeRegistry();
                schemeRegistry.register(new Scheme("https", this.M, 443));
                schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                HttpGet httpGet = new HttpGet();
                httpGet.setURI(new URI(this.P));
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                g.c(TAG, "status code is : " + execute.getStatusLine().getStatusCode());
                f.a((Reader) null);
                c();
            } catch (Exception e4) {
                g.e(TAG, "run: exception : " + e4.getMessage());
                b();
                f.a((Reader) null);
            } catch (Throwable th4) {
                f.a((Reader) null);
                throw th4;
            }
        }
    }

    public String getUrl() {
        return this.P;
    }

    public void setUrl(String str) {
        this.P = str;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.O;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.O = sslErrorHandler;
    }

    public Callback getCallback() {
        return this.Q;
    }

    public void setCallback(Callback callback) {
        this.Q = callback;
    }

    public Context getContext() {
        return this.u;
    }

    public void setContext(Context context) {
        this.u = context;
    }

    private void b() {
        String str = TAG;
        g.c(str, "callbackCancel: ");
        Callback callback = this.Q;
        if (callback != null) {
            callback.onCancel(this.u, this.P);
        } else if (this.O != null) {
            g.c(str, "callbackCancel 2: ");
            this.O.cancel();
        }
    }

    private void c() {
        g.c(TAG, "callbackProceed: ");
        Callback callback = this.Q;
        if (callback != null) {
            callback.onProceed(this.u, this.P);
            return;
        }
        SslErrorHandler sslErrorHandler = this.O;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.M;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.M = sSLSocketFactory;
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.N;
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.N = x509HostnameVerifier;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.L;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.L = sSLSocketFactory;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier2) {
        this.hostnameVerifier = hostnameVerifier2;
    }
}
