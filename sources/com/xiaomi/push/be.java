package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.service.l;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class be {
    private static volatile be a;
    private Context b;
    private bd c;
    private final HashMap<String, bb> d = new HashMap<>();
    private ThreadPoolExecutor e = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final ArrayList<a> f = new ArrayList<>();

    public static abstract class a implements Runnable {
        private String a;
        protected String b;
        protected bb c = null;
        private WeakReference<Context> d;
        private Random e = new Random();
        private int f = 0;
        private a g;

        public a(String str) {
            this.a = str;
        }

        public Object a() {
            return null;
        }

        void a(Context context) {
            a aVar = this.g;
            if (aVar != null) {
                aVar.a(context, a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            be.a(context).a(this);
        }

        void a(bb bbVar, Context context) {
            this.c = bbVar;
            this.b = bbVar.a();
            this.d = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.g = aVar;
        }

        public void b(Context context) {
        }

        public boolean b() {
            return this.c == null || TextUtils.isEmpty(this.b) || this.d == null;
        }

        public String c() {
            return this.a;
        }

        public SQLiteDatabase d() {
            return this.c.getWritableDatabase();
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.d;
            if (weakReference != null && (context = weakReference.get()) != null && context.getFilesDir() != null && this.c != null && !TextUtils.isEmpty(this.a)) {
                File file = new File(this.a);
                jd.a(context, new File(file.getParentFile(), ag.b(file.getAbsolutePath())), new bg(this, context));
            }
        }
    }

    public static abstract class b<T> extends a {
        private List<String> a;
        private String d;
        private String[] e;
        private String f;
        private String g;
        private String h;
        private int i;
        private List<T> j = new ArrayList();

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2) {
            super(str);
            this.a = list;
            this.d = str2;
            this.e = strArr;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = i2;
        }

        @Override // com.xiaomi.push.be.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.j.clear();
            List<String> list = this.a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.a.size()];
                this.a.toArray(strArr2);
                strArr = strArr2;
            }
            int i2 = this.i;
            if (i2 > 0) {
                str = String.valueOf(i2);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.d, this.e, this.f, this.g, this.h, str);
            if (query != null && query.moveToFirst()) {
                do {
                    T b = b(context, query);
                    if (b != null) {
                        this.j.add(b);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.j);
        }

        public abstract void a(Context context, List<T> list);

        public abstract T b(Context context, Cursor cursor);

        @Override // com.xiaomi.push.be.a
        public SQLiteDatabase d() {
            return this.c.getReadableDatabase();
        }
    }

    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.be.a
        public final void a(Context context) {
            super.a(context);
            Iterator<a> it2 = this.a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }

        @Override // com.xiaomi.push.be.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it2 = this.a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }
    }

    public static class d extends a {
        private String a;
        protected String[] d;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.d = strArr;
        }

        @Override // com.xiaomi.push.be.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.d);
        }
    }

    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.be.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private be(Context context) {
        this.b = context;
    }

    public static be a(Context context) {
        if (a == null) {
            synchronized (be.class) {
                if (a == null) {
                    a = new be(context);
                }
            }
        }
        return a;
    }

    private void a() {
        j.a(this.b).b(new bf(this), l.a(this.b).a(gn.StatDataProcessFrequency.a(), 5));
    }

    private bb b(String str) {
        bb bbVar = this.d.get(str);
        if (bbVar == null) {
            synchronized (this.d) {
                if (bbVar == null) {
                    bbVar = this.c.a(this.b, str);
                    this.d.put(str, bbVar);
                }
            }
        }
        return bbVar;
    }

    public String a(String str) {
        return b(str).a();
    }

    public void a(a aVar) {
        bb bbVar;
        if (aVar != null) {
            if (this.c != null) {
                String c2 = aVar.c();
                synchronized (this.d) {
                    bbVar = this.d.get(c2);
                    if (bbVar == null) {
                        bbVar = this.c.a(this.b, c2);
                        this.d.put(c2, bbVar);
                    }
                }
                if (!this.e.isShutdown()) {
                    aVar.a(bbVar, this.b);
                    synchronized (this.f) {
                        this.f.add(aVar);
                        a();
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public void a(Runnable runnable) {
        if (!this.e.isShutdown()) {
            this.e.execute(runnable);
        }
    }

    public void a(ArrayList<a> arrayList) {
        if (this.c != null) {
            HashMap hashMap = new HashMap();
            if (!this.e.isShutdown()) {
                Iterator<a> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next.b()) {
                        next.a(b(next.c()), this.b);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.c());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.c(), arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        c cVar = new c(str, arrayList3);
                        cVar.a(((a) arrayList3.get(0)).c, this.b);
                        this.e.execute(cVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    public void b(a aVar) {
        bb bbVar;
        if (aVar != null) {
            if (this.c != null) {
                String c2 = aVar.c();
                synchronized (this.d) {
                    bbVar = this.d.get(c2);
                    if (bbVar == null) {
                        bbVar = this.c.a(this.b, c2);
                        this.d.put(c2, bbVar);
                    }
                }
                if (!this.e.isShutdown()) {
                    aVar.a(bbVar, this.b);
                    a((Runnable) aVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }
}
