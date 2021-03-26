package com.tencent.tpns.baseapi.crosssp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.tpns.baseapi.base.util.Logger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ProGuard */
public class ProviderMessage {
    private static ConcurrentHashMap<String, List<Long>> a = new ConcurrentHashMap<>();

    public static void log(String str) {
        Logger.d("ProviderMessage", "" + str);
    }

    public static Uri insert(Context context, Uri uri, ContentValues contentValues) {
        try {
            return a.a(context, uri, contentValues);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "insert", th);
            return null;
        }
    }

    public static Uri insert(Context context, String str, String str2, ContentValues contentValues) {
        return insert(context, Uri.parse("content://" + str + "/" + str2), contentValues);
    }

    public static String getType(Context context, Uri uri) {
        try {
            return a.a(context, uri);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "getType", th);
            return null;
        }
    }

    public static String getType(Context context, String str, String str2) {
        return getType(context, Uri.parse("content://" + str + "/" + str2));
    }

    public static int update(Context context, String str, String str2, ContentValues contentValues, String str3, String[] strArr) {
        return update(context, Uri.parse("content://" + str + "/" + str2), contentValues, str3, strArr);
    }

    public static int update(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
        try {
            return a.a(context, uri, contentValues, str, strArr);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "update", th);
            return 0;
        }
    }

    public static int delete(Context context, String str, String str2, String str3, String[] strArr) {
        return delete(context, Uri.parse("content://" + str + "/" + str2), str3, strArr);
    }

    public static int delete(Context context, Uri uri, String str, String[] strArr) {
        try {
            return a.a(context, uri, str, strArr);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "delete", th);
            return 0;
        }
    }

    public static Cursor query(Context context, String str, String str2, String[] strArr, String str3, String[] strArr2, String str4) {
        return query(context, Uri.parse("content://" + str + "/" + str2), strArr, str3, strArr2, str4);
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str) {
        return query(context, uri, strArr, str, null, null);
    }

    public static Cursor query(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            return a.a(context, uri, strArr, str, strArr2, str2);
        } catch (Throwable th) {
            Logger.e("ProviderMessage", "query", th);
            return null;
        }
    }

    /* compiled from: ProGuard */
    static class a<T> implements Runnable {
        private Context a;
        private Uri b;
        private String[] c;
        private String d;
        private String[] e;
        private String f;
        private ContentValues g;
        private String h;
        private int i = 3;
        private T j;

        a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            this.a = context;
            this.b = uri;
            this.c = strArr;
            this.d = str;
            this.e = strArr2;
            this.f = str2;
        }

        a(Context context, Uri uri, ContentValues contentValues) {
            this.a = context;
            this.b = uri;
            this.g = contentValues;
        }

        a(Context context, Uri uri) {
            this.a = context;
            this.b = uri;
        }

        a(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
            this.a = context;
            this.b = uri;
            this.g = contentValues;
            this.h = str;
            this.e = strArr;
        }

        a(Context context, Uri uri, String str, String[] strArr) {
            this.a = context;
            this.b = uri;
            this.h = str;
            this.e = strArr;
        }

        public T a() {
            return this.j;
        }

        public void a(T t) {
            this.j = t;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.tencent.tpns.baseapi.crosssp.ProviderMessage$a<T> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                int i2 = this.i;
                if (i2 == 1) {
                    obj = this.a.getContentResolver().query(this.b, this.c, this.d, this.e, this.f);
                } else if (i2 == 2) {
                    obj = this.a.getContentResolver().insert(this.b, this.g);
                } else if (i2 == 3) {
                    obj = this.a.getContentResolver().getType(this.b);
                } else if (i2 != 4) {
                    obj = i2 != 5 ? null : Integer.valueOf(this.a.getContentResolver().delete(this.b, this.h, this.e));
                } else {
                    obj = Integer.valueOf(this.a.getContentResolver().update(this.b, this.g, this.h, this.e));
                }
                a(obj);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "call", th);
            }
        }

        static Cursor a(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            a aVar = new a(context, uri, strArr, str, strArr2, str2);
            Thread thread = new Thread(aVar);
            thread.start();
            try {
                thread.join(1000);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myQuery", th);
            }
            return (Cursor) aVar.a();
        }

        static Uri a(Context context, Uri uri, ContentValues contentValues) {
            a aVar = new a(context, uri, contentValues);
            Thread thread = new Thread(aVar);
            thread.start();
            try {
                thread.join(1000);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myInsert", th);
            }
            return (Uri) aVar.a();
        }

        static String a(Context context, Uri uri) {
            a aVar = new a(context, uri);
            Thread thread = new Thread(aVar);
            thread.start();
            try {
                thread.join(1000);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myGetType", th);
            }
            return (String) aVar.a();
        }

        static int a(Context context, Uri uri, ContentValues contentValues, String str, String[] strArr) {
            a aVar = new a(context, uri, contentValues, str, strArr);
            Thread thread = new Thread(aVar);
            thread.start();
            try {
                thread.join(1000);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myUpdate", th);
            }
            return ((Integer) aVar.a()).intValue();
        }

        static int a(Context context, Uri uri, String str, String[] strArr) {
            a aVar = new a(context, uri, str, strArr);
            Thread thread = new Thread(aVar);
            thread.start();
            try {
                thread.join(1000);
            } catch (Throwable th) {
                Logger.e("ProviderMessage", "myDelete", th);
            }
            return ((Integer) aVar.a()).intValue();
        }
    }
}
