package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.a;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class SSFCompatiableSystemCA extends SSLSocketFactory {
    private static volatile SSFCompatiableSystemCA A = null;
    private static final String TAG = "SSFCompatiableSystemCA";
    private SSLContext g;
    private SSLSocket t;
    private Context u;
    private String[] v;
    private X509TrustManager w;
    private String[] x;
    private String[] y;
    private String[] z;

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    private SSFCompatiableSystemCA(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.g = null;
        this.t = null;
        if (context == null) {
            g.e(TAG, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager instance = SSFSecureX509SingleInstance.getInstance(context);
        this.w = instance;
        this.g.init(null, new X509TrustManager[]{instance}, new SecureRandom());
    }

    public static SSFCompatiableSystemCA getInstance(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        c.setContext(context);
        if (A == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (A == null) {
                    A = new SSFCompatiableSystemCA(context);
                }
            }
        }
        if (A.u == null && context != null) {
            A.setContext(context);
        }
        return A;
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.g = null;
        this.t = null;
        this.g = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.g.init(null, new X509TrustManager[]{x509TrustManager}, new SecureRandom());
    }

    static void a(X509TrustManager x509TrustManager) {
        g.c(TAG, "ssfc update socket factory trust manager");
        try {
            A = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (NoSuchAlgorithmException unused) {
            g.e(TAG, "NoSuchAlgorithmException");
        } catch (KeyManagementException unused2) {
            g.e(TAG, "KeyManagementException");
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

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.v;
        return strArr != null ? strArr : new String[0];
    }

    public SSLSocket getSslSocket() {
        return this.t;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        g.c(TAG, "createSocket: host , port");
        Socket createSocket = this.g.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof SSLSocket) {
            b(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.t = sSLSocket;
            this.v = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z2) throws IOException {
        g.c(TAG, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.g.getSocketFactory().createSocket(socket, str, i, z2);
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
