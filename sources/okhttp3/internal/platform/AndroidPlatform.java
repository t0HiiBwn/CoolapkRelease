package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J-\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0011\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0006H\u0016J \u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00132\b\u0010&\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020(H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getSelectedProtocol", "getStackTraceForCloseable", "", "closer", "isCleartextTrafficPermitted", "", "logCloseableLeak", "message", "stackTrace", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "CustomTrustRootIndex", "okhttp"}, k = 1, mv = {1, 4, 0})
/* compiled from: AndroidPlatform.kt */
public final class AndroidPlatform extends Platform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isSupported;
    private final CloseGuard closeGuard;
    private final List<SocketAdapter> socketAdapters;

    public AndroidPlatform() {
        SocketAdapter[] socketAdapterArr = {StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())};
        ArrayList arrayList = new ArrayList();
        for (Object obj : CollectionsKt.listOfNotNull((Object[]) socketAdapterArr)) {
            if (((SocketAdapter) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
        this.closeGuard = CloseGuard.Companion.get();
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        Intrinsics.checkNotNullParameter(socket, "socket");
        Intrinsics.checkNotNullParameter(inetSocketAddress, "address");
        try {
            socket.connect(inetSocketAddress, i);
        } catch (ClassCastException e) {
            if (Build.VERSION.SDK_INT == 26) {
                throw new IOException("Exception in connect", e);
            }
            throw e;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        T t;
        Intrinsics.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        Iterator<T> it2 = this.socketAdapters.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.matchesSocketFactory(sSLSocketFactory)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.trustManager(sSLSocketFactory);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        T t;
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        Intrinsics.checkNotNullParameter(list, "protocols");
        Iterator<T> it2 = this.socketAdapters.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.matchesSocket(sSLSocket)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            t2.configureTlsExtensions(sSLSocket, str, list);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        T t;
        Intrinsics.checkNotNullParameter(sSLSocket, "sslSocket");
        Iterator<T> it2 = this.socketAdapters.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (t.matchesSocket(sSLSocket)) {
                break;
            }
        }
        T t2 = t;
        if (t2 != null) {
            return t2.getSelectedProtocol(sSLSocket);
        }
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String str) {
        Intrinsics.checkNotNullParameter(str, "closer");
        return this.closeGuard.createAndOpen(str);
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (!this.closeGuard.warnIfOpen(obj)) {
            Platform.log$default(this, str, 5, null, 4, null);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String str) {
        Intrinsics.checkNotNullParameter(str, "hostname");
        if (Build.VERSION.SDK_INT >= 24) {
            return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        NetworkSecurityPolicy instance = NetworkSecurityPolicy.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "NetworkSecurityPolicy.getInstance()");
        return instance.isCleartextTrafficPermitted();
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
        AndroidCertificateChainCleaner buildIfSupported = AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager);
        return buildIfSupported != null ? buildIfSupported : super.buildCertificateChainCleaner(x509TrustManager);
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            Intrinsics.checkNotNullExpressionValue(declaredMethod, "method");
            declaredMethod.setAccessible(true);
            return new CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÂ\u0003J\t\u0010\b\u001a\u00020\u0005HÂ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "findByIssuerAndSignatureMethod", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "component2", "copy", "equals", "", "other", "", "findByIssuerAndSignature", "Ljava/security/cert/X509Certificate;", "cert", "hashCode", "", "toString", "", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AndroidPlatform.kt */
    public static final class CustomTrustRootIndex implements TrustRootIndex {
        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static /* synthetic */ CustomTrustRootIndex copy$default(CustomTrustRootIndex customTrustRootIndex, X509TrustManager x509TrustManager, Method method, int i, Object obj) {
            if ((i & 1) != 0) {
                x509TrustManager = customTrustRootIndex.trustManager;
            }
            if ((i & 2) != 0) {
                method = customTrustRootIndex.findByIssuerAndSignatureMethod;
            }
            return customTrustRootIndex.copy(x509TrustManager, method);
        }

        public final CustomTrustRootIndex copy(X509TrustManager x509TrustManager, Method method) {
            Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
            Intrinsics.checkNotNullParameter(method, "findByIssuerAndSignatureMethod");
            return new CustomTrustRootIndex(x509TrustManager, method);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CustomTrustRootIndex)) {
                return false;
            }
            CustomTrustRootIndex customTrustRootIndex = (CustomTrustRootIndex) obj;
            return Intrinsics.areEqual(this.trustManager, customTrustRootIndex.trustManager) && Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, customTrustRootIndex.findByIssuerAndSignatureMethod);
        }

        public int hashCode() {
            X509TrustManager x509TrustManager = this.trustManager;
            int i = 0;
            int hashCode = (x509TrustManager != null ? x509TrustManager.hashCode() : 0) * 31;
            Method method = this.findByIssuerAndSignatureMethod;
            if (method != null) {
                i = method.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "CustomTrustRootIndex(trustManager=" + this.trustManager + ", findByIssuerAndSignatureMethod=" + this.findByIssuerAndSignatureMethod + ")";
        }

        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method) {
            Intrinsics.checkNotNullParameter(x509TrustManager, "trustManager");
            Intrinsics.checkNotNullParameter(method, "findByIssuerAndSignatureMethod");
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            Intrinsics.checkNotNullParameter(x509Certificate, "cert");
            try {
                Object invoke = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
                if (invoke != null) {
                    return ((TrustAnchor) invoke).getTrustedCert();
                }
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            } catch (IllegalAccessException e) {
                throw new AssertionError("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* compiled from: AndroidPlatform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isSupported() {
            return AndroidPlatform.isSupported;
        }

        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new AndroidPlatform();
            }
            return null;
        }
    }

    static {
        boolean z = true;
        boolean z2 = false;
        if (Platform.Companion.isAndroid() && Build.VERSION.SDK_INT < 30) {
            if (Build.VERSION.SDK_INT >= 21) {
                z2 = true;
            }
            if (!z2) {
                throw new IllegalStateException(("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT).toString());
            }
        } else {
            z = false;
        }
        isSupported = z;
    }
}
