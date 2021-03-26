package com.alibaba.mtl.log.d;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: UtSslSocketFactory */
public class u extends SSLSocketFactory {
    private String ag;
    private Method b = null;

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public u(String str) {
        this.ag = str;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.ag == null) {
            this.ag = str;
        }
        i.a("", "host", this.ag, "port", Integer.valueOf(i), "autoClose", Boolean.valueOf(z));
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance("X509");
            instance.init((KeyStore) null);
            sSLCertificateSocketFactory.setTrustManagers(new TrustManager[]{new a(instance.getTrustManagers()[0])});
        } catch (Exception e) {
            i.a("", e);
        }
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (Build.VERSION.SDK_INT >= 17) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.ag);
        } else {
            try {
                if (this.b == null) {
                    Method method = sSLSocket.getClass().getMethod("setHostname", String.class);
                    this.b = method;
                    method.setAccessible(true);
                }
                this.b.invoke(sSLSocket, this.ag);
            } catch (Exception e2) {
                i.a("", "SNI not useable", null, e2);
            }
        }
        i.a("", "SSLSession PeerHost", sSLSocket.getSession().getPeerHost());
        return sSLSocket;
    }

    /* compiled from: UtSslSocketFactory */
    public static class a implements X509TrustManager {
        TrustManager a;

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public a(TrustManager trustManager) {
            this.a = trustManager;
        }

        /* JADX WARNING: Removed duplicated region for block: B:7:0x0010  */
        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                ((X509TrustManager) this.a).checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException e) {
                Throwable th = e;
                while (th.getCause() != null) {
                    th = th.getCause();
                    if ((th instanceof CertificateExpiredException) || (th instanceof CertificateNotYetValidException)) {
                        i.a("", th);
                        return;
                    }
                    while (th.getCause() != null) {
                    }
                }
                throw e;
            }
        }
    }
}
