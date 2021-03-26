package com.bytedance.sdk.a.b.a.b;

import com.bytedance.sdk.a.b.a.a;
import com.bytedance.sdk.a.b.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpecSelector */
public final class b {
    private final List<k> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    public b(List<k> list) {
        this.a = list;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                kVar = null;
                break;
            }
            kVar = this.a.get(i);
            if (kVar.a(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (kVar != null) {
            this.c = b(sSLSocket);
            a.a.a(kVar, sSLSocket, this.d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i = this.b; i < this.a.size(); i++) {
            if (this.a.get(i).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
