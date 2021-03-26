package com.huawei.agconnect.config.a;

import android.content.Context;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.Objects;

public class a extends AGConnectServicesConfig {
    private final Context a;
    private final String b;
    private LazyInputStream c;
    private volatile b d;
    private final Object e = new Object();

    public a(Context context, String str) {
        this.a = context;
        this.b = str;
    }

    private static LazyInputStream a(Context context, final InputStream inputStream) {
        return new LazyInputStream(context) {
            /* class com.huawei.agconnect.config.a.a.AnonymousClass1 */

            @Override // com.huawei.agconnect.config.LazyInputStream
            public InputStream get(Context context) {
                return inputStream;
            }
        };
    }

    private static String a(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        return '/' + str.substring(i);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public boolean getBoolean(String str, boolean z) {
        return Boolean.parseBoolean(getString(str, String.valueOf(z)));
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public int getInt(String str) {
        return getInt(str, 0);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public int getInt(String str, int i) {
        try {
            return Integer.parseInt(getString(str, String.valueOf(i)));
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public String getString(String str) {
        return getString(str, null);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public String getString(String str, String str2) {
        Objects.requireNonNull(str, "path must not be null.");
        if (this.d == null) {
            synchronized (this.e) {
                if (this.d == null) {
                    LazyInputStream lazyInputStream = this.c;
                    if (lazyInputStream != null) {
                        this.d = new d(lazyInputStream.loadInputStream());
                        this.c.close();
                        this.c = null;
                    } else {
                        this.d = new g(this.a, this.b);
                    }
                }
            }
        }
        return this.d.a(a(str), str2);
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(LazyInputStream lazyInputStream) {
        this.c = lazyInputStream;
    }

    @Override // com.huawei.agconnect.config.AGConnectServicesConfig
    public void overlayWith(InputStream inputStream) {
        overlayWith(a(this.a, inputStream));
    }
}
