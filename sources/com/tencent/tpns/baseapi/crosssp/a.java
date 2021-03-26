package com.tencent.tpns.baseapi.crosssp;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.tpns.baseapi.base.SettingsContentProvider;
import com.tencent.tpns.baseapi.base.util.Logger;

/* compiled from: ProGuard */
public class a {
    public static volatile a a;
    private Context b;

    public static a a(Context context) {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
        return a;
    }

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    public C0158a a() {
        return new C0158a(this.b);
    }

    public String a(String str, String str2) {
        try {
            return SettingsContentProvider.getStringValue(ProviderMessage.query(this.b, SettingsContentProvider.getContentUri(this.b, str, "string"), null, null, null, null), str2);
        } catch (Throwable th) {
            Logger.e("SettingsPreferences", "error = ", th);
            return "";
        }
    }

    public long a(String str, long j) {
        try {
            return SettingsContentProvider.getLongValue(ProviderMessage.query(this.b, SettingsContentProvider.getContentUri(this.b, str, "long"), null, null, null, null), j);
        } catch (Throwable th) {
            Logger.e("SettingsPreferences", "error = ", th);
            return 0;
        }
    }

    public float a(String str, float f) {
        try {
            return SettingsContentProvider.getFloatValue(ProviderMessage.query(this.b, SettingsContentProvider.getContentUri(this.b, str, "float"), null, null, null, null), f);
        } catch (Throwable th) {
            Logger.e("SettingsPreferences", "error = ", th);
            return 0.0f;
        }
    }

    public boolean a(String str, boolean z) {
        try {
            return SettingsContentProvider.getBooleanValue(ProviderMessage.query(this.b, SettingsContentProvider.getContentUri(this.b, str, "boolean"), null, null), z);
        } catch (Throwable th) {
            Logger.e("SettingsPreferences", "error = ", th);
            return false;
        }
    }

    public int a(String str, int i) {
        try {
            return SettingsContentProvider.getIntValue(ProviderMessage.query(this.b, SettingsContentProvider.getContentUri(this.b, str, "integer"), null, null, null, null), i);
        } catch (Throwable th) {
            Logger.e("SettingsPreferences", "error = ", th);
            return 0;
        }
    }

    /* renamed from: com.tencent.tpns.baseapi.crosssp.a$a  reason: collision with other inner class name */
    /* compiled from: ProGuard */
    public static class C0158a {
        Context a;
        private ContentValues b;

        private C0158a(Context context) {
            this.b = new ContentValues();
            this.a = context;
        }

        public void a() {
            try {
                ProviderMessage.insert(this.a, SettingsContentProvider.getContentUri(this.a, "key", "type"), this.b);
            } catch (Throwable th) {
                Logger.e("SettingsPreferences", "apply", th);
            }
        }

        public void b() {
            a();
        }

        public C0158a a(String str, String str2) {
            this.b.put(str, str2);
            return this;
        }

        public C0158a a(String str, long j) {
            this.b.put(str, Long.valueOf(j));
            return this;
        }

        public C0158a a(String str, boolean z) {
            this.b.put(str, Boolean.valueOf(z));
            return this;
        }

        public C0158a a(String str, int i) {
            this.b.put(str, Integer.valueOf(i));
            return this;
        }

        public C0158a a(String str, float f) {
            this.b.put(str, Float.valueOf(f));
            return this;
        }

        public void a(String str) {
            this.b.putNull(str);
        }
    }
}
