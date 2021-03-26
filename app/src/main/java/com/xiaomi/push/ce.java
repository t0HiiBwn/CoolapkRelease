package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.service.an;
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

public class ce {
    private static volatile ce a;

    /* renamed from: a  reason: collision with other field name */
    private Context f251a;

    /* renamed from: a  reason: collision with other field name */
    private cd f252a;

    /* renamed from: a  reason: collision with other field name */
    private final ArrayList<a> f253a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, cc> f254a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f255a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static abstract class a implements Runnable {
        private int a = 0;

        /* renamed from: a  reason: collision with other field name */
        protected cc f256a = null;

        /* renamed from: a  reason: collision with other field name */
        private a f257a;

        /* renamed from: a  reason: collision with other field name */
        private String f258a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f259a;

        /* renamed from: a  reason: collision with other field name */
        private Random f260a = new Random();
        protected String b;

        public a(String str) {
            this.f258a = str;
        }

        public SQLiteDatabase a() {
            return this.f256a.getWritableDatabase();
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m172a() {
            return null;
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m173a() {
            return this.f258a;
        }

        void a(Context context) {
            a aVar = this.f257a;
            if (aVar != null) {
                aVar.a(context, m172a());
            }
            b(context);
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(Context context, Object obj) {
            ce.a(context).a(this);
        }

        void a(cc ccVar, Context context) {
            this.f256a = ccVar;
            this.b = ccVar.a();
            this.f259a = new WeakReference<>(context);
        }

        public void a(a aVar) {
            this.f257a = aVar;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m174a() {
            return this.f256a == null || TextUtils.isEmpty(this.b) || this.f259a == null;
        }

        public void b(Context context) {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context;
            WeakReference<Context> weakReference = this.f259a;
            if (weakReference != null && (context = weakReference.get()) != null && context.getFilesDir() != null && this.f256a != null && !TextUtils.isEmpty(this.f258a)) {
                File file = new File(this.f258a);
                v.a(context, new File(file.getParentFile(), bh.b(file.getAbsolutePath())), new cg(this, context));
            }
        }
    }

    public static abstract class b<T> extends a {
        private int a;

        /* renamed from: a  reason: collision with other field name */
        private String f261a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f262a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f263a;
        private List<T> b = new ArrayList();
        private String c;
        private String d;
        private String e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i) {
            super(str);
            this.f262a = list;
            this.f261a = str2;
            this.f263a = strArr;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.a = i;
        }

        @Override // com.xiaomi.push.ce.a
        public SQLiteDatabase a() {
            return this.f256a.getReadableDatabase();
        }

        public abstract T a(Context context, Cursor cursor);

        @Override // com.xiaomi.push.ce.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.b.clear();
            List<String> list = this.f262a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f262a.size()];
                this.f262a.toArray(strArr2);
                strArr = strArr2;
            }
            int i = this.a;
            if (i > 0) {
                str = String.valueOf(i);
            }
            Cursor query = sQLiteDatabase.query(this.b, strArr, this.f261a, this.f263a, this.c, this.d, this.e, str);
            if (query != null && query.moveToFirst()) {
                do {
                    T a2 = a(context, query);
                    if (a2 != null) {
                        this.b.add(a2);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, (List) this.b);
        }

        public abstract void a(Context context, List<T> list);
    }

    public static class c extends a {
        private ArrayList<a> a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        @Override // com.xiaomi.push.ce.a
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

        @Override // com.xiaomi.push.ce.a
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

        /* renamed from: a  reason: collision with other field name */
        protected String[] f264a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.a = str2;
            this.f264a = strArr;
        }

        @Override // com.xiaomi.push.ce.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.b, this.a, this.f264a);
        }
    }

    public static class e extends a {
        private ContentValues a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.a = contentValues;
        }

        @Override // com.xiaomi.push.ce.a
        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.b, null, this.a);
        }
    }

    private ce(Context context) {
        this.f251a = context;
    }

    private cc a(String str) {
        cc ccVar = this.f254a.get(str);
        if (ccVar == null) {
            synchronized (this.f254a) {
                if (ccVar == null) {
                    ccVar = this.f252a.a(this.f251a, str);
                    this.f254a.put(str, ccVar);
                }
            }
        }
        return ccVar;
    }

    public static ce a(Context context) {
        if (a == null) {
            synchronized (ce.class) {
                if (a == null) {
                    a = new ce(context);
                }
            }
        }
        return a;
    }

    private void a() {
        ai.a(this.f251a).b(new cf(this), an.a(this.f251a).a(hh.StatDataProcessFrequency.a(), 5));
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m171a(String str) {
        return a(str).a();
    }

    public void a(a aVar) {
        cc ccVar;
        if (aVar != null) {
            if (this.f252a != null) {
                String a2 = aVar.m173a();
                synchronized (this.f254a) {
                    ccVar = this.f254a.get(a2);
                    if (ccVar == null) {
                        ccVar = this.f252a.a(this.f251a, a2);
                        this.f254a.put(a2, ccVar);
                    }
                }
                if (!this.f255a.isShutdown()) {
                    aVar.a(ccVar, this.f251a);
                    synchronized (this.f253a) {
                        this.f253a.add(aVar);
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
        if (!this.f255a.isShutdown()) {
            this.f255a.execute(runnable);
        }
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f252a != null) {
            HashMap hashMap = new HashMap();
            if (!this.f255a.isShutdown()) {
                Iterator<a> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next.m174a()) {
                        next.a(a(next.m173a()), this.f251a);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.m173a());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.m173a(), arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        c cVar = new c(str, arrayList3);
                        cVar.a(((a) arrayList3.get(0)).f256a, this.f251a);
                        this.f255a.execute(cVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    public void b(a aVar) {
        cc ccVar;
        if (aVar != null) {
            if (this.f252a != null) {
                String a2 = aVar.m173a();
                synchronized (this.f254a) {
                    ccVar = this.f254a.get(a2);
                    if (ccVar == null) {
                        ccVar = this.f252a.a(this.f251a, a2);
                        this.f254a.put(a2, ccVar);
                    }
                }
                if (!this.f255a.isShutdown()) {
                    aVar.a(ccVar, this.f251a);
                    a((Runnable) aVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }
}
