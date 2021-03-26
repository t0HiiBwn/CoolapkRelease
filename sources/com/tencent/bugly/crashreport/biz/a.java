package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.ar;
import com.tencent.bugly.proguard.k;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.t;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
public final class a {
    private Context a;
    private long b;
    private int c;
    private boolean d = true;

    static /* synthetic */ void a(a aVar, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> a2;
        if (userInfoBean == null) {
            return;
        }
        if (z || userInfoBean.b == 1 || (a2 = aVar.a(com.tencent.bugly.crashreport.common.info.a.a(aVar.a).d)) == null || a2.size() < 20) {
            long a3 = p.a().a("t_ui", a(userInfoBean), (o) null, true);
            if (a3 >= 0) {
                x.c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(a3));
                userInfoBean.a = a3;
                return;
            }
            return;
        }
        x.a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(a2.size()));
    }

    public a(Context context, boolean z) {
        this.a = context;
        this.d = z;
    }

    public final void a(int i, boolean z, long j) {
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        int i2 = 0;
        if (a2 == null || a2.c().f || i == 1 || i == 3) {
            if (i == 1 || i == 3) {
                this.c++;
            }
            com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(this.a);
            UserInfoBean userInfoBean = new UserInfoBean();
            userInfoBean.b = i;
            userInfoBean.c = a3.d;
            userInfoBean.d = a3.g();
            userInfoBean.e = System.currentTimeMillis();
            userInfoBean.f = -1;
            userInfoBean.n = a3.k;
            if (i == 1) {
                i2 = 1;
            }
            userInfoBean.o = i2;
            userInfoBean.l = a3.a();
            userInfoBean.m = a3.q;
            userInfoBean.g = a3.r;
            userInfoBean.h = a3.s;
            userInfoBean.i = a3.t;
            userInfoBean.k = a3.u;
            userInfoBean.r = a3.t();
            userInfoBean.s = a3.y();
            userInfoBean.p = a3.z();
            userInfoBean.q = a3.A();
            w.a().a(new RunnableC0143a(userInfoBean, z), 0);
            return;
        }
        x.e("UserInfo is disable", new Object[0]);
    }

    public final void a() {
        this.b = z.b() + 86400000;
        w.a().a(new b(), (this.b - System.currentTimeMillis()) + 5000);
    }

    /* renamed from: com.tencent.bugly.crashreport.biz.a$a  reason: collision with other inner class name */
    /* compiled from: BUGLY */
    class RunnableC0143a implements Runnable {
        private boolean a;
        private UserInfoBean b;

        public RunnableC0143a(UserInfoBean userInfoBean, boolean z) {
            this.b = userInfoBean;
            this.a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.bugly.crashreport.common.info.a b2;
            try {
                UserInfoBean userInfoBean = this.b;
                if (userInfoBean != null) {
                    if (!(userInfoBean == null || (b2 = com.tencent.bugly.crashreport.common.info.a.b()) == null)) {
                        userInfoBean.j = b2.e();
                    }
                    x.c("[UserInfo] Record user info.", new Object[0]);
                    a.a(a.this, this.b, false);
                }
                if (this.a) {
                    a aVar = a.this;
                    w a2 = w.a();
                    if (a2 != null) {
                        a2.a(new Runnable() {
                            /* class com.tencent.bugly.crashreport.biz.a.AnonymousClass2 */

                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    a.this.c();
                                } catch (Throwable th) {
                                    x.a(th);
                                }
                            }
                        });
                    }
                }
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f2  */
    public synchronized void c() {
        boolean z;
        if (this.d) {
            u a2 = u.a();
            if (a2 != null) {
                com.tencent.bugly.crashreport.common.strategy.a a3 = com.tencent.bugly.crashreport.common.strategy.a.a();
                if (a3 != null) {
                    if (!a3.b() || a2.b(1001)) {
                        String str = com.tencent.bugly.crashreport.common.info.a.a(this.a).d;
                        ArrayList arrayList = new ArrayList();
                        final List<UserInfoBean> a4 = a(str);
                        if (a4 != null) {
                            int size = a4.size() - 20;
                            if (size > 0) {
                                int i = 0;
                                while (i < a4.size() - 1) {
                                    int i2 = i + 1;
                                    for (int i3 = i2; i3 < a4.size(); i3++) {
                                        if (a4.get(i).e > a4.get(i3).e) {
                                            a4.set(i, a4.get(i3));
                                            a4.set(i3, a4.get(i));
                                        }
                                    }
                                    i = i2;
                                }
                                for (int i4 = 0; i4 < size; i4++) {
                                    arrayList.add(a4.get(i4));
                                }
                            }
                            Iterator<UserInfoBean> it2 = a4.iterator();
                            int i5 = 0;
                            while (it2.hasNext()) {
                                UserInfoBean next = it2.next();
                                if (next.f != -1) {
                                    it2.remove();
                                    if (next.e < z.b()) {
                                        arrayList.add(next);
                                    }
                                }
                                if (next.e > System.currentTimeMillis() - 600000 && (next.b == 1 || next.b == 4 || next.b == 3)) {
                                    i5++;
                                }
                            }
                            if (i5 > 15) {
                                x.d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i5));
                                z = false;
                                if (arrayList.size() > 0) {
                                    a(arrayList);
                                }
                                if (z || a4.size() == 0) {
                                    x.c("[UserInfo] There is no user info in local database.", new Object[0]);
                                }
                                x.c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(a4.size()));
                                ar a5 = com.tencent.bugly.proguard.a.a(a4, this.c == 1 ? 1 : 2);
                                if (a5 == null) {
                                    x.d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                                    return;
                                }
                                byte[] a6 = com.tencent.bugly.proguard.a.a((k) a5);
                                if (a6 == null) {
                                    x.d("[UserInfo] Failed to encode data.", new Object[0]);
                                    return;
                                }
                                am a7 = com.tencent.bugly.proguard.a.a(this.a, 840, a6);
                                if (a7 == null) {
                                    x.d("[UserInfo] Request package is null.", new Object[0]);
                                    return;
                                }
                                u.a().a(1001, a7, com.tencent.bugly.crashreport.common.strategy.a.a().c().p, StrategyBean.a, new t() {
                                    /* class com.tencent.bugly.crashreport.biz.a.AnonymousClass1 */

                                    @Override // com.tencent.bugly.proguard.t
                                    public final void a(boolean z) {
                                        if (z) {
                                            x.c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                            long currentTimeMillis = System.currentTimeMillis();
                                            for (UserInfoBean userInfoBean : a4) {
                                                userInfoBean.f = currentTimeMillis;
                                                a.a(a.this, userInfoBean, true);
                                            }
                                        }
                                    }
                                }, this.c == 1);
                                return;
                            }
                        } else {
                            a4 = new ArrayList<>();
                        }
                        z = true;
                        if (arrayList.size() > 0) {
                        }
                        if (z) {
                        }
                        x.c("[UserInfo] There is no user info in local database.", new Object[0]);
                    }
                }
            }
        }
    }

    public final void b() {
        w a2 = w.a();
        if (a2 != null) {
            a2.a(new Runnable() {
                /* class com.tencent.bugly.crashreport.biz.a.AnonymousClass2 */

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.c();
                    } catch (Throwable th) {
                        x.a(th);
                    }
                }
            });
        }
    }

    /* compiled from: BUGLY */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < a.this.b) {
                w.a().a(new b(), (a.this.b - currentTimeMillis) + 5000);
                return;
            }
            a.this.a(3, false, 0L);
            a.this.a();
        }
    }

    /* compiled from: BUGLY */
    class c implements Runnable {
        private long a = 21600000;

        public c(long j) {
            this.a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            w a2 = w.a();
            if (a2 != null) {
                a2.a(new Runnable() {
                    /* class com.tencent.bugly.crashreport.biz.a.AnonymousClass2 */

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            a.this.c();
                        } catch (Throwable th) {
                            x.a(th);
                        }
                    }
                });
            }
            a aVar2 = a.this;
            long j = this.a;
            w.a().a(new c(j), j);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ad A[Catch:{ all -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2 A[DONT_GENERATE] */
    public final List<UserInfoBean> a(String str) {
        Cursor cursor;
        Throwable th;
        String str2;
        try {
            if (z.a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = p.a().a("t_ui", null, str2, null, null, true);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean a2 = a(cursor);
                    if (a2 != null) {
                        arrayList.add(a2);
                    } else {
                        try {
                            long j = cursor.getLong(cursor.getColumnIndex("_id"));
                            sb.append(" or _id");
                            sb.append(" = ");
                            sb.append(j);
                        } catch (Throwable unused) {
                            x.d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    x.d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", sb2.substring(4), (String[]) null, (o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            if (!x.a(th)) {
            }
            return null;
        }
    }

    private static void a(List<UserInfoBean> list) {
        if (list != null && list.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < list.size() && i < 50) {
                sb.append(" or _id");
                sb.append(" = ");
                sb.append(list.get(i).a);
                i++;
            }
            String sb2 = sb.toString();
            if (sb2.length() > 0) {
                sb2 = sb2.substring(4);
            }
            sb.setLength(0);
            try {
                x.c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(p.a().a("t_ui", sb2, (String[]) null, (o) null, true)));
            } catch (Throwable th) {
                if (!x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    private static ContentValues a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.b));
            contentValues.put("_pc", userInfoBean.c);
            contentValues.put("_dt", z.a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static UserInfoBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) z.a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
