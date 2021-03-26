package com.qq.e.comm.managers.plugin;

import android.content.Context;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PM {
    private static final Map<Class<?>, String> n = new HashMap<Class<?>, String>() {
        /* class com.qq.e.comm.managers.plugin.PM.AnonymousClass2 */

        {
            put(POFactory.class, "com.qq.e.comm.plugin.POFactoryImpl");
        }
    };
    private ExecutorService a = Executors.newSingleThreadExecutor();
    private final Context b;
    private String c;
    private File d;
    private int e;
    private DexClassLoader f;
    private RandomAccessFile g;
    private FileLock h;
    private boolean i;
    private a.AbstractC0086a j;
    private POFactory k;
    private int l;
    private a.b m = new a.b() {
        /* class com.qq.e.comm.managers.plugin.PM.AnonymousClass1 */

        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void a() {
            PM.a(PM.this);
        }

        @Override // com.qq.e.comm.managers.plugin.PM.a.b
        public final void b() {
            PM.this.f();
        }
    };

    public interface a {

        /* renamed from: com.qq.e.comm.managers.plugin.PM$a$a  reason: collision with other inner class name */
        public interface AbstractC0086a {
            void onLoadFail();

            void onLoadSuccess();
        }

        public interface b {
            void a();

            void b();
        }
    }

    public PM(Context context, a.AbstractC0086a aVar) {
        this.b = context.getApplicationContext();
        this.j = aVar;
        long currentTimeMillis = System.currentTimeMillis();
        this.i = d();
        if (b()) {
            a();
        }
        this.l = (int) (System.currentTimeMillis() - currentTimeMillis);
    }

    private void a() {
        StringBuilder sb = new StringBuilder("PluginFile:\t");
        File file = this.d;
        sb.append(file == null ? "null" : file.getAbsolutePath());
        GDTLogger.d(sb.toString());
        if (this.c == null || this.d == null) {
            this.f = null;
            return;
        }
        try {
            this.f = new DexClassLoader(this.d.getAbsolutePath(), d.a(this.b).getAbsolutePath(), null, getClass().getClassLoader());
            e();
        } catch (Throwable th) {
            GDTLogger.e("exception while init plugin class loader", th);
            f();
        }
    }

    static /* synthetic */ void a(PM pm) {
        try {
            if (pm.f == null && pm.c()) {
                pm.a();
            }
        } catch (Exception e2) {
            GDTLogger.report("Exception while init online plugin: ", e2);
            pm.f();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004f, code lost:
        if (r2 == false) goto L_0x0052;
     */
    private boolean b() {
        StringBuilder sb;
        boolean z;
        boolean z2 = false;
        try {
            GDTLogger.d("TimeStap_BEFORE_PLUGIN_INIT:" + System.currentTimeMillis());
            if (!c()) {
                if (this.i) {
                    Context context = this.b;
                    if (a.a(context, d.b(context), d.e(this.b))) {
                        this.c = Sig.ASSET_PLUGIN_SIG;
                        this.d = d.b(this.b);
                        this.e = 1203;
                        z = true;
                    } else {
                        GDTLogger.e("Fail to prepair Defult plugin ");
                    }
                }
                z = false;
            }
            z2 = true;
            sb = new StringBuilder("TimeStap_AFTER_PLUGIN_INIT:");
        } catch (Throwable th) {
            GDTLogger.d("TimeStap_AFTER_PLUGIN_INIT:" + System.currentTimeMillis());
            throw th;
        }
        sb.append(System.currentTimeMillis());
        GDTLogger.d(sb.toString());
        return z2;
    }

    private boolean c() {
        if (this.i) {
            a aVar = new a(d.d(this.b), d.g(this.b));
            if (aVar.a()) {
                boolean a2 = aVar.a(d.b(this.b), d.e(this.b));
                GDTLogger.d("NextExist,Updated=" + a2);
            }
        }
        a aVar2 = new a(d.b(this.b), d.e(this.b));
        if (!aVar2.a()) {
            return false;
        }
        if (aVar2.b() < 1203) {
            GDTLogger.d("last updated plugin version =" + this.e + ";asset plugin version=1203");
            return false;
        }
        this.c = aVar2.c();
        this.e = aVar2.b();
        this.d = d.b(this.b);
        return true;
    }

    private boolean d() {
        try {
            File h2 = d.h(this.b);
            if (!h2.exists()) {
                h2.createNewFile();
                StringUtil.writeTo("lock", h2);
            }
            if (!h2.exists()) {
                return false;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(h2, "rw");
            this.g = randomAccessFile;
            FileLock tryLock = randomAccessFile.getChannel().tryLock();
            this.h = tryLock;
            if (tryLock == null) {
                return false;
            }
            this.g.writeByte(37);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void e() {
        a.AbstractC0086a aVar = this.j;
        if (aVar != null) {
            aVar.onLoadSuccess();
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        a.AbstractC0086a aVar = this.j;
        if (aVar != null) {
            aVar.onLoadFail();
        }
    }

    public <T> T getFactory(Class<T> cls) throws c {
        GDTLogger.d("GetFactoryInstaceforInterface:" + cls);
        ClassLoader classLoader = Sig.ASSET_PLUGIN_SIG == null ? getClass().getClassLoader() : this.f;
        StringBuilder sb = new StringBuilder("PluginClassLoader is parent");
        sb.append(getClass().getClassLoader() == classLoader);
        GDTLogger.d(sb.toString());
        if (classLoader != null) {
            try {
                String str = n.get(cls);
                if (!StringUtil.isEmpty(str)) {
                    Class<?> loadClass = classLoader.loadClass(str);
                    T cast = cls.cast(loadClass.getDeclaredMethod("getInstance", new Class[0]).invoke(loadClass, new Object[0]));
                    GDTLogger.d("ServiceDelegateFactory =" + ((Object) cast));
                    return cast;
                }
                throw new c("factory  implemention name is not specified for interface:" + cls.getName());
            } catch (Throwable th) {
                throw new c("Fail to getfactory implement instance for interface:" + cls.getName(), th);
            }
        } else {
            throw new c("Fail to init GDTADPLugin,PluginClassLoader == null;while loading factory impl for:" + cls);
        }
    }

    public int getInitCostTime() {
        return this.l;
    }

    public String getLocalSig() {
        return this.c;
    }

    public POFactory getPOFactory() throws c {
        if (this.k == null) {
            this.k = (POFactory) getFactory(POFactory.class);
        }
        return this.k;
    }

    public int getPluginVersion() {
        return this.e;
    }

    public void update(String str, String str2) {
        if (this.i) {
            b bVar = new b(this.b, this.a);
            bVar.a(this.m);
            bVar.a(str, str2);
        }
    }
}
