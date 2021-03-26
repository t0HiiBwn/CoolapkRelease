package com.huawei.hms.update.b;

import android.content.Context;
import com.huawei.hms.support.log.HMSLog;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: HttpsUtils */
final class f extends SSLSocketFactory {
    private static final Object a = new Object();
    private static SocketFactory b;
    private final SSLContext c;
    private Context d;

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    private f(Context context) throws NoSuchAlgorithmException, KeyManagementException, CertificateException, KeyStoreException, IOException {
        this.d = context;
        SSLContext instance = SSLContext.getInstance("TLSv1.2");
        this.c = instance;
        instance.init(null, new X509TrustManager[]{new e(this.d)}, null);
    }

    public static SocketFactory a(Context context) {
        Exception e;
        synchronized (a) {
            try {
                if (b == null) {
                    b = new f(context);
                }
                return b;
            } catch (KeyManagementException e2) {
                e = e2;
                HMSLog.e("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e.getMessage());
                return SSLSocketFactory.getDefault();
            } catch (NoSuchAlgorithmException e3) {
                e = e3;
                HMSLog.e("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e.getMessage());
                return SSLSocketFactory.getDefault();
            } catch (IOException e4) {
                e = e4;
                HMSLog.e("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e.getMessage());
                return SSLSocketFactory.getDefault();
            } catch (CertificateException e5) {
                e = e5;
                HMSLog.e("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e.getMessage());
                return SSLSocketFactory.getDefault();
            } catch (KeyStoreException e6) {
                e = e6;
                HMSLog.e("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e.getMessage());
                return SSLSocketFactory.getDefault();
            } catch (IllegalArgumentException e7) {
                e = e7;
                HMSLog.e("TLSSocketFactory", "Failed to new TLSSocketFactory instance." + e.getMessage());
                return SSLSocketFactory.getDefault();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(SSLSocket sSLSocket) {
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        if (!(enabledCipherSuites == null || enabledCipherSuites.length == 0)) {
            ArrayList arrayList = new ArrayList();
            for (String str : enabledCipherSuites) {
                if (!a(str)) {
                    arrayList.add(str);
                }
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[0]));
        }
    }

    private static boolean a(String str) {
        return str.contains("RC2") || str.contains("RC4") || str.contains("DES") || str.contains("MD2") || str.contains("MD4") || str.contains("MD5") || str.contains("ANON") || str.contains("NULL") || str.contains("SKIPJACK") || str.contains("SHA1") || str.contains("TEA") || str.contains("SHA0") || str.contains("RIPEMD") || str.contains("TLS_EMPTY_RENEGOTIATION_INFO_SCSV") || str.contains("aNULL") || str.contains("eNULL") || str.contains("TLS_DH_anon_WITH_AES_256_CBC_SHA") || str.contains("DES40") || str.contains("DESX") || str.contains("TLS_RSA") || str.contains("SSL_RSA");
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.c.getSocketFactory().createSocket(socket, str, i, z);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        Socket createSocket = this.c.getSocketFactory().createSocket(str, i);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.c.getSocketFactory().createSocket(str, i, inetAddress, i2);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.c.getSocketFactory().createSocket(inetAddress, i);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.c.getSocketFactory().createSocket(inetAddress, i, inetAddress2, i2);
        a(createSocket);
        return createSocket;
    }

    private void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            b(sSLSocket);
            a(sSLSocket);
        }
    }

    private void b(SSLSocket sSLSocket) {
        sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
    }
}
