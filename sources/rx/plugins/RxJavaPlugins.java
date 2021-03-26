package rx.plugins;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicReference;

public class RxJavaPlugins {
    static final RxJavaErrorHandler DEFAULT_ERROR_HANDLER = new RxJavaErrorHandler() {
        /* class rx.plugins.RxJavaPlugins.AnonymousClass1 */
    };
    private static final RxJavaPlugins INSTANCE = new RxJavaPlugins();
    private final AtomicReference<RxJavaCompletableExecutionHook> completableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaErrorHandler> errorHandler = new AtomicReference<>();
    private final AtomicReference<RxJavaObservableExecutionHook> observableExecutionHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSchedulersHook> schedulersHook = new AtomicReference<>();
    private final AtomicReference<RxJavaSingleExecutionHook> singleExecutionHook = new AtomicReference<>();

    @Deprecated
    public static RxJavaPlugins getInstance() {
        return INSTANCE;
    }

    RxJavaPlugins() {
    }

    public void reset() {
        RxJavaPlugins rxJavaPlugins = INSTANCE;
        rxJavaPlugins.errorHandler.set(null);
        rxJavaPlugins.observableExecutionHook.set(null);
        rxJavaPlugins.singleExecutionHook.set(null);
        rxJavaPlugins.completableExecutionHook.set(null);
        rxJavaPlugins.schedulersHook.set(null);
    }

    public RxJavaErrorHandler getErrorHandler() {
        if (this.errorHandler.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaErrorHandler.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.errorHandler.compareAndSet(null, DEFAULT_ERROR_HANDLER);
            } else {
                this.errorHandler.compareAndSet(null, (RxJavaErrorHandler) pluginImplementationViaProperty);
            }
        }
        return this.errorHandler.get();
    }

    public void registerErrorHandler(RxJavaErrorHandler rxJavaErrorHandler) {
        if (!this.errorHandler.compareAndSet(null, rxJavaErrorHandler)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.errorHandler.get());
        }
    }

    public RxJavaObservableExecutionHook getObservableExecutionHook() {
        if (this.observableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaObservableExecutionHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.observableExecutionHook.compareAndSet(null, RxJavaObservableExecutionHookDefault.getInstance());
            } else {
                this.observableExecutionHook.compareAndSet(null, (RxJavaObservableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.observableExecutionHook.get();
    }

    public void registerObservableExecutionHook(RxJavaObservableExecutionHook rxJavaObservableExecutionHook) {
        if (!this.observableExecutionHook.compareAndSet(null, rxJavaObservableExecutionHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.observableExecutionHook.get());
        }
    }

    public RxJavaSingleExecutionHook getSingleExecutionHook() {
        if (this.singleExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSingleExecutionHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.singleExecutionHook.compareAndSet(null, RxJavaSingleExecutionHookDefault.getInstance());
            } else {
                this.singleExecutionHook.compareAndSet(null, (RxJavaSingleExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.singleExecutionHook.get();
    }

    public void registerSingleExecutionHook(RxJavaSingleExecutionHook rxJavaSingleExecutionHook) {
        if (!this.singleExecutionHook.compareAndSet(null, rxJavaSingleExecutionHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    public RxJavaCompletableExecutionHook getCompletableExecutionHook() {
        if (this.completableExecutionHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaCompletableExecutionHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.completableExecutionHook.compareAndSet(null, new RxJavaCompletableExecutionHook() {
                    /* class rx.plugins.RxJavaPlugins.AnonymousClass2 */
                });
            } else {
                this.completableExecutionHook.compareAndSet(null, (RxJavaCompletableExecutionHook) pluginImplementationViaProperty);
            }
        }
        return this.completableExecutionHook.get();
    }

    public void registerCompletableExecutionHook(RxJavaCompletableExecutionHook rxJavaCompletableExecutionHook) {
        if (!this.completableExecutionHook.compareAndSet(null, rxJavaCompletableExecutionHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.singleExecutionHook.get());
        }
    }

    static Properties getSystemPropertiesSafe() {
        try {
            return System.getProperties();
        } catch (SecurityException unused) {
            return new Properties();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
        r2 = "rxjava.plugin." + r7.substring(0, r7.length() - 6).substring(14) + ".impl";
        r11 = r11.getProperty(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0087, code lost:
        if (r11 == null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a8, code lost:
        throw new java.lang.IllegalStateException("Implementing class declaration for " + r0 + " missing: " + r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a9, code lost:
        r1 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b5 A[SYNTHETIC, Splitter:B:24:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0136 A[RETURN] */
    static Object getPluginImplementationViaProperty(Class<?> cls, Properties properties) {
        Properties properties2 = (Properties) properties.clone();
        String simpleName = cls.getSimpleName();
        String property = properties2.getProperty("rxjava.plugin." + simpleName + ".implementation");
        if (property == null) {
            try {
                Iterator it2 = properties2.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    String obj = entry.getKey().toString();
                    if (obj.startsWith("rxjava.plugin.") && obj.endsWith(".class") && simpleName.equals(entry.getValue().toString())) {
                        break;
                    }
                }
            } catch (SecurityException e) {
                SecurityException e2 = e;
                String str = property;
                e2.printStackTrace();
                property = str;
                if (property == null) {
                }
            }
            property = str;
        }
        if (property == null) {
            return null;
        }
        try {
            return Class.forName(property).asSubclass(cls).newInstance();
        } catch (ClassCastException e3) {
            throw new IllegalStateException(simpleName + " implementation is not an instance of " + simpleName + ": " + property, e3);
        } catch (ClassNotFoundException e4) {
            throw new IllegalStateException(simpleName + " implementation class not found: " + property, e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(simpleName + " implementation not able to be instantiated: " + property, e5);
        } catch (IllegalAccessException e6) {
            throw new IllegalStateException(simpleName + " implementation not able to be accessed: " + property, e6);
        }
    }

    public RxJavaSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            Object pluginImplementationViaProperty = getPluginImplementationViaProperty(RxJavaSchedulersHook.class, getSystemPropertiesSafe());
            if (pluginImplementationViaProperty == null) {
                this.schedulersHook.compareAndSet(null, RxJavaSchedulersHook.getDefaultInstance());
            } else {
                this.schedulersHook.compareAndSet(null, (RxJavaSchedulersHook) pluginImplementationViaProperty);
            }
        }
        return this.schedulersHook.get();
    }

    public void registerSchedulersHook(RxJavaSchedulersHook rxJavaSchedulersHook) {
        if (!this.schedulersHook.compareAndSet(null, rxJavaSchedulersHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
        }
    }
}
