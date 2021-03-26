package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* compiled from: ProGuard */
public final class e {
    private static Context a;

    public static final Context a() {
        Context context = a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final void a(Context context) {
        a = context;
    }

    public static final String b() {
        if (a() == null) {
            return "";
        }
        return a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }
}
