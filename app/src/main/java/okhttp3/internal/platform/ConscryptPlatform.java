package okhttp3.internal.platform;

import java.security.KeyStore;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0011\u0010\u000b\u001a\r\u0012\t\u0012\u00070\r¢\u0006\u0002\b\u000e0\fH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "newSslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "sslSocketFactory", "Companion", "DisabledHostnameVerifier", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: ConscryptPlatform.kt */
public final class ConscryptPlatform extends Platform {
    public static final Companion Companion;
    private static final boolean isSupported;
    private final Provider provider;

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        return null;
    }

    private ConscryptPlatform() {
        Provider newProvider = Conscrypt.newProvider();
        Intrinsics.checkNotNullExpressionValue(newProvider, "Conscrypt.newProvider()");
        this.provider = newProvider;
    }

    public /* synthetic */ ConscryptPlatform(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLS", this.provider);
        Intrinsics.checkNotNullExpressionValue(instance, "SSLContext.getInstance(\"TLS\", provider)");
        return instance;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        Intrinsics.checkNotNullExpressionValue(instance, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = instance.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        boolean z = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z = false;
        }
        if (z) {
            TrustManager trustManager = trustManagers[0];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, DisabledHostnameVerifier.INSTANCE);
            return x509TrustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\fJ\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$DisabledHostnameVerifier;", "Lorg/conscrypt/ConscryptHostnameVerifier;", "()V", "verify", "", "certs", "", "Ljava/security/cert/X509Certificate;", "hostname", "", "session", "Ljavax/net/ssl/SSLSession;", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ConscryptPlatform.kt */
    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {
        public static final DisabledHostnameVerifier INSTANCE = new DisabledHostnameVerifier();

        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }

        public boolean verify(X509Certificate[] x509CertificateArr, String str, SSLSession sSLSession) {
            return true;
        }

        private DisabledHostnameVerifier() {
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Object[] array = Platform.Companion.alpnProtocolNames(list).toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
            return;
        }
        super.configureTlsExtensions(sSLSocket, str, list);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            return Conscrypt.getApplicationProtocol(sSLSocket);
        }
        return super.getSelectedProtocol(sSLSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
        SSLContext newSSLContext = newSSLContext();
        newSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = newSSLContext.getSocketFactory();
        Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\r"}, d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "atLeastVersion", "major", "", "minor", "patch", "buildIfSupported", "Lokhttp3/internal/platform/ConscryptPlatform;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: ConscryptPlatform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isSupported() {
            return ConscryptPlatform.isSupported;
        }

        public final ConscryptPlatform buildIfSupported() {
            if (isSupported()) {
                return new ConscryptPlatform(null);
            }
            return null;
        }

        public static /* synthetic */ boolean atLeastVersion$default(Companion companion, int i, int i2, int i3, int i4, Object obj) {
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = 0;
            }
            return companion.atLeastVersion(i, i2, i3);
        }

        public final boolean atLeastVersion(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            if (version.major() != i) {
                if (version.major() > i) {
                    return true;
                }
                return false;
            } else if (version.minor() != i2) {
                if (version.minor() > i2) {
                    return true;
                }
                return false;
            } else if (version.patch() >= i3) {
                return true;
            } else {
                return false;
            }
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, companion.getClass().getClassLoader());
            if (Conscrypt.isAvailable() && companion.atLeastVersion(2, 1, 0)) {
                z = true;
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        isSupported = z;
    }
}
