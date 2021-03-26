package okhttp3.internal.platform;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

/* compiled from: Platform.kt */
public class Platform {
    public static final Companion Companion;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());
    private static volatile Platform platform;

    public static final Platform get() {
        return Companion.get();
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        return null;
    }

    public boolean isCleartextTrafficPermitted(String str) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        return true;
    }

    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLS");
        Intrinsics.checkNotNullExpressionValue(instance, "SSLContext.getInstance(\"TLS\")");
        return instance;
    }

    public X509TrustManager platformTrustManager() {
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init((KeyStore) null);
        Intrinsics.checkNotNullExpressionValue(instance, "factory");
        TrustManager[] trustManagers = instance.getTrustManagers();
        Intrinsics.checkNotNull(trustManagers);
        boolean z = true;
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            z = false;
        }
        if (z) {
            TrustManager trustManager = trustManagers[0];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager) trustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String arrays = Arrays.toString(trustManagers);
        Intrinsics.checkNotNullExpressionValue(arrays, "java.util.Arrays.toString(this)");
        sb.append(arrays);
        throw new IllegalStateException(sb.toString().toString());
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        try {
            Class<?> cls = Class.forName("sun.security.ssl.SSLContextImpl");
            Intrinsics.checkNotNullExpressionValue(cls, "sslContextClass");
            Object readFieldOrNull = Util.readFieldOrNull(sSLSocketFactory, cls, "context");
            if (readFieldOrNull != null) {
                return (X509TrustManager) Util.readFieldOrNull(readFieldOrNull, X509TrustManager.class, "trustManager");
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public static /* synthetic */ void log$default(Platform platform2, String str, int i, Throwable th, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 4;
            }
            if ((i2 & 4) != 0) {
                th = null;
            }
            platform2.log(str, i, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    public void log(String str, int i, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "message");
        logger.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object getStackTraceForCloseable(String str) {
        Intrinsics.checkNotNullParameter(str, "closer");
        if (logger.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void logCloseableLeak(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(str, 5, (Throwable) obj);
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
        return new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        return new BasicTrustRootIndex((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
        try {
            SSLContext newSSLContext = newSSLContext();
            newSSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = newSSLContext.getSocketFactory();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    /* compiled from: Platform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform get() {
            return Platform.platform;
        }

        public static /* synthetic */ void resetForTests$default(Companion companion, Platform platform, int i, Object obj) {
            if ((i & 1) != 0) {
                platform = companion.findPlatform();
            }
            companion.resetForTests(platform);
        }

        public final void resetForTests(Platform platform) {
            Intrinsics.checkNotNullParameter(platform, "platform");
            Platform.platform = platform;
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                T next = it2.next();
                if (next != Protocol.HTTP_1_0) {
                    arrayList.add(next);
                }
            }
            ArrayList<Protocol> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (Protocol protocol : arrayList2) {
                arrayList3.add(protocol.toString());
            }
            return arrayList3;
        }

        public final boolean isAndroid() {
            return Intrinsics.areEqual("Dalvik", System.getProperty("java.vm.name"));
        }

        private final boolean isConscryptPreferred() {
            Provider provider = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
            return Intrinsics.areEqual("Conscrypt", provider.getName());
        }

        private final boolean isOpenJSSEPreferred() {
            Provider provider = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
            return Intrinsics.areEqual("OpenJSSE", provider.getName());
        }

        private final boolean isBouncyCastlePreferred() {
            Provider provider = Security.getProviders()[0];
            Intrinsics.checkNotNullExpressionValue(provider, "Security.getProviders()[0]");
            return Intrinsics.areEqual("BC", provider.getName());
        }

        public final Platform findPlatform() {
            Companion companion = this;
            if (companion.isAndroid()) {
                return companion.findAndroidPlatform();
            }
            return companion.findJvmPlatform();
        }

        private final Platform findAndroidPlatform() {
            AndroidLog.INSTANCE.enable();
            Platform buildIfSupported = Android10Platform.Companion.buildIfSupported();
            if (buildIfSupported != null) {
                return buildIfSupported;
            }
            Platform buildIfSupported2 = AndroidPlatform.Companion.buildIfSupported();
            Intrinsics.checkNotNull(buildIfSupported2);
            return buildIfSupported2;
        }

        private final Platform findJvmPlatform() {
            OpenJSSEPlatform buildIfSupported;
            BouncyCastlePlatform buildIfSupported2;
            ConscryptPlatform buildIfSupported3;
            Companion companion = this;
            if (companion.isConscryptPreferred() && (buildIfSupported3 = ConscryptPlatform.Companion.buildIfSupported()) != null) {
                return buildIfSupported3;
            }
            if (companion.isBouncyCastlePreferred() && (buildIfSupported2 = BouncyCastlePlatform.Companion.buildIfSupported()) != null) {
                return buildIfSupported2;
            }
            if (companion.isOpenJSSEPreferred() && (buildIfSupported = OpenJSSEPlatform.Companion.buildIfSupported()) != null) {
                return buildIfSupported;
            }
            Jdk9Platform buildIfSupported4 = Jdk9Platform.Companion.buildIfSupported();
            if (buildIfSupported4 != null) {
                return buildIfSupported4;
            }
            Platform buildIfSupported5 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            if (buildIfSupported5 != null) {
                return buildIfSupported5;
            }
            return new Platform();
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> list) {
            Intrinsics.checkNotNullParameter(list, "protocols");
            Buffer buffer = new Buffer();
            for (String str : alpnProtocolNames(list)) {
                buffer.writeByte(str.length());
                buffer.writeUtf8(str);
            }
            return buffer.readByteArray();
        }
    }

    static {
        Companion companion = new Companion(null);
        Companion = companion;
        platform = companion.findPlatform();
    }
}
