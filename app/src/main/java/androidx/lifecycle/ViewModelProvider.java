package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider {
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private final Factory mFactory;
    private final ViewModelStore mViewModelStore;

    public interface Factory {
        <T extends ViewModel> T create(Class<T> cls);
    }

    static class OnRequeryFactory {
        void onRequery(ViewModel viewModel) {
        }

        OnRequeryFactory() {
        }
    }

    static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        public abstract <T extends ViewModel> T create(String str, Class<T> cls);

        KeyedFactory() {
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner) {
        this(r0, r3);
        Factory factory;
        ViewModelStore viewModelStore = viewModelStoreOwner.getViewModelStore();
        if (viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory) {
            factory = ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory();
        } else {
            factory = NewInstanceFactory.getInstance();
        }
    }

    public ViewModelProvider(ViewModelStoreOwner viewModelStoreOwner, Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(ViewModelStore viewModelStore, Factory factory) {
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }

    public <T extends ViewModel> T get(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends ViewModel> T get(String str, Class<T> cls) {
        T t = (T) this.mViewModelStore.get(str);
        if (cls.isInstance(t)) {
            Factory factory = this.mFactory;
            if (factory instanceof OnRequeryFactory) {
                ((OnRequeryFactory) factory).onRequery(t);
            }
            return t;
        }
        Factory factory2 = this.mFactory;
        T t2 = factory2 instanceof KeyedFactory ? (T) ((KeyedFactory) factory2).create(str, cls) : (T) factory2.create(cls);
        this.mViewModelStore.put(str, t2);
        return t2;
    }

    public static class NewInstanceFactory implements Factory {
        private static NewInstanceFactory sInstance;

        static NewInstanceFactory getInstance() {
            if (sInstance == null) {
                sInstance = new NewInstanceFactory();
            }
            return sInstance;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory sInstance;
        private Application mApplication;

        public static AndroidViewModelFactory getInstance(Application application) {
            if (sInstance == null) {
                sInstance = new AndroidViewModelFactory(application);
            }
            return sInstance;
        }

        public AndroidViewModelFactory(Application application) {
            this.mApplication = application;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return (T) super.create(cls);
            }
            try {
                return cls.getConstructor(Application.class).newInstance(this.mApplication);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }
}
