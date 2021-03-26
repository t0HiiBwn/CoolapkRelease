package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    private static volatile SecureApacheSSLSocketFactory H = null;
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    private static final String TAG = SecureApacheSSLSocketFactory.class.getSimpleName();
    private SSLContext g;
    private SSLSocket t;
    private Context u;
    private String[] v;
    private X509TrustManager w;
    private String[] x;
    private String[] y;
    private String[] z;

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.t = null;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.t = null;
        if (context == null) {
            g.e(TAG, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SecureX509SingleInstance.getInstance(context);
        this.w = instance;
        this.g.init(null, new X509TrustManager[]{instance}, new SecureRandom());
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.t = null;
        this.g = SSLUtil.setSSLContext();
        HiCloudX509TrustManager hiCloudX509TrustManager = new HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.g.init(null, new X509TrustManager[]{hiCloudX509TrustManager}, new SecureRandom());
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.t = null;
        this.g = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.g.init(null, new X509TrustManager[]{x509TrustManager}, new SecureRandom());
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        c.setContext(context);
        if (H == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (H == null) {
                    H = new SecureApacheSSLSocketFactory(keyStore, context);
                }
            }
        }
        return H;
    }

    static void a(X509TrustManager x509TrustManager) {
        g.c(TAG, "sasf update socket factory trust manager");
        try {
            H = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            g.e(TAG, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            g.e(TAG, "KeyManagementException");
        } catch (UnrecoverableKeyException unused3) {
            g.e(TAG, "UnrecoverableKeyException");
        } catch (KeyStoreException unused4) {
            g.e(TAG, "KeyStoreException");
        } catch (CertificateException unused5) {
            g.e(TAG, "CertificateException");
        } catch (IOException unused6) {
            g.e(TAG, "IOException");
        }
    }

    public SSLContext getSslContext() {
        return this.g;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.g = sSLContext;
    }

    public Context getContext() {
        return this.u;
    }

    public void setContext(Context context) {
        this.u = context.getApplicationContext();
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.v;
        return strArr != null ? strArr : new String[0];
    }

    public SSLSocket getSslSocket() {
        return this.t;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.t = sSLSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z2) throws IOException {
        g.c(TAG, "createSocket: socket host port autoClose");
        Socket createSocket = this.g.getSocketFactory().createSocket(socket, str, i, z2);
        if (createSocket instanceof SSLSocket) {
            b(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.t = sSLSocket;
            this.v = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        g.c(TAG, "createSocket: ");
        Socket createSocket = this.g.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            b(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.t = sSLSocket;
            this.v = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.w;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    public String[] getBlackCiphers() {
        return this.x;
    }

    public void setBlackCiphers(String[] strArr) {
        this.x = strArr;
    }

    public String[] getWhiteCiphers() {
        return this.y;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.y = strArr;
    }

    public String[] getProtocols() {
        return this.z;
    }

    public void setProtocols(String[] strArr) {
        this.z = strArr;
    }

    public X509TrustManager getX509TrustManager() {
        return this.w;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.w = x509TrustManager;
    }

    private void b(Socket socket) {
        boolean z2;
        boolean z3 = true;
        if (!a.a(this.z)) {
            g.c(TAG, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.z);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!a.a(this.y) || !a.a(this.x)) {
            g.c(TAG, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!a.a(this.y)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.y);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.x);
            }
        } else {
            z3 = false;
        }
        if (!z2) {
            g.c(TAG, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (!z3) {
            g.c(TAG, "set default cipher suites");
            SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
        }
    }
}
