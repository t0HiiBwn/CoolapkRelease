package com.bytedance.sdk.openadsdk.i.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.j.h;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: VideoProxyDB */
public class c {
    private static volatile c b;
    private final SparseArray<Map<String, a>> a;
    private final d c;
    private final Executor d = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new h(5, "video_proxy_db"));
    private volatile SQLiteStatement e;

    private c(Context context) {
        SparseArray<Map<String, a>> sparseArray = new SparseArray<>(2);
        this.a = sparseArray;
        this.c = new d(context.getApplicationContext());
        sparseArray.put(0, new ConcurrentHashMap());
        sparseArray.put(1, new ConcurrentHashMap());
    }

    public static c a(Context context) {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c(context);
                }
            }
        }
        return b;
    }

    public a a(String str, int i) {
        a aVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<String, a> map = this.a.get(i);
        if (map == null) {
            aVar = null;
        } else {
            aVar = map.get(str);
        }
        if (aVar != null) {
            return aVar;
        }
        try {
            Cursor query = this.c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[]{str, String.valueOf(i)}, null, null, null, "1");
            if (query != null) {
                if (query.getCount() > 0 && query.moveToNext()) {
                    aVar = new a(query.getString(query.getColumnIndex("key")), query.getString(query.getColumnIndex("mime")), query.getInt(query.getColumnIndex("contentLength")), i, query.getString(query.getColumnIndex("extra")));
                }
                query.close();
            }
            if (!(aVar == null || map == null)) {
                map.put(str, aVar);
            }
            return aVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a(final a aVar) {
        if (aVar != null) {
            Map<String, a> map = this.a.get(aVar.d);
            if (map != null) {
                map.put(aVar.a, aVar);
            }
            this.d.execute(new Runnable() {
                /* class com.bytedance.sdk.openadsdk.i.b.c.AnonymousClass1 */

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (c.this.e == null) {
                            c cVar = c.this;
                            cVar.e = cVar.c.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
                        } else {
                            c.this.e.clearBindings();
                        }
                        c.this.e.bindString(1, aVar.a);
                        c.this.e.bindString(2, aVar.b);
                        c.this.e.bindLong(3, (long) aVar.c);
                        c.this.e.bindLong(4, (long) aVar.d);
                        c.this.e.bindString(5, aVar.e);
                        c.this.e.executeInsert();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    public void a(Collection<String> collection, int i) {
        if (collection != null && !collection.isEmpty()) {
            int size = collection.size() + 1;
            String[] strArr = new String[size];
            int i2 = -1;
            Map<String, a> map = this.a.get(i);
            for (String str : collection) {
                if (map != null) {
                    map.remove(str);
                }
                i2++;
                strArr[i2] = str;
            }
            strArr[i2 + 1] = String.valueOf(i);
            try {
                SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
                writableDatabase.delete("video_http_header_t", "key IN(" + b(size) + ") AND flag=?", strArr);
            } catch (Throwable unused) {
            }
        }
    }

    private String b(int i) {
        if (i <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(i << 1);
        sb.append("?");
        for (int i2 = 1; i2 < i; i2++) {
            sb.append(",?");
        }
        return sb.toString();
    }

    public void a(final int i) {
        Map<String, a> map = this.a.get(i);
        if (map != null) {
            map.clear();
        }
        this.d.execute(new Runnable() {
            /* class com.bytedance.sdk.openadsdk.i.b.c.AnonymousClass2 */

            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.c.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(i)});
                } catch (Throwable unused) {
                }
            }
        });
    }
}
