package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Converter;

class Platform {
    private static final Platform PLATFORM = findPlatform();
    private final boolean hasJava8Types;
    @Nullable
    private final Constructor<MethodHandles.Lookup> lookupConstructor;

    @Nullable
    Executor defaultCallbackExecutor() {
        return null;
    }

    static Platform get() {
        return PLATFORM;
    }

    private static Platform findPlatform() {
        if ("Dalvik".equals(System.getProperty("java.vm.name"))) {
            return new Android();
        }
        return new Platform(true);
    }

    Platform(boolean z) {
        this.hasJava8Types = z;
        Constructor<MethodHandles.Lookup> constructor = null;
        if (z) {
            try {
                constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                constructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.lookupConstructor = constructor;
    }

    List<? extends CallAdapter.Factory> defaultCallAdapterFactories(@Nullable Executor executor) {
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executor);
        if (this.hasJava8Types) {
            return Arrays.asList(CompletableFutureCallAdapterFactory.INSTANCE, defaultCallAdapterFactory);
        }
        return Collections.singletonList(defaultCallAdapterFactory);
    }

    int defaultCallAdapterFactoriesSize() {
        return this.hasJava8Types ? 2 : 1;
    }

    List<? extends Converter.Factory> defaultConverterFactories() {
        return this.hasJava8Types ? Collections.singletonList(OptionalConverterFactory.INSTANCE) : Collections.emptyList();
    }

    int defaultConverterFactoriesSize() {
        return this.hasJava8Types ? 1 : 0;
    }

    boolean isDefaultMethod(Method method) {
        return this.hasJava8Types && method.isDefault();
    }

    @Nullable
    Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        MethodHandles.Lookup lookup;
        Constructor<MethodHandles.Lookup> constructor = this.lookupConstructor;
        if (constructor != null) {
            lookup = constructor.newInstance(cls, -1);
        } else {
            lookup = MethodHandles.lookup();
        }
        return lookup.unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    static final class Android extends Platform {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Android() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.Platform
        public Executor defaultCallbackExecutor() {
            return new MainThreadExecutor();
        }

        @Override // retrofit2.Platform
        @Nullable
        Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return Platform.super.invokeDefaultMethod(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }

        static final class MainThreadExecutor implements Executor {
            private final Handler handler = new Handler(Looper.getMainLooper());

            MainThreadExecutor() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.handler.post(runnable);
            }
        }
    }
}
