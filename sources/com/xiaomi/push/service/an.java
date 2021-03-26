package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ad;
import com.xiaomi.push.bf;
import com.xiaomi.push.hh;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class an {
    private static volatile an a;

    /* renamed from: a  reason: collision with other field name */
    protected SharedPreferences f955a;

    /* renamed from: a  reason: collision with other field name */
    private HashSet<a> f956a = new HashSet<>();

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.mId;
        }

        protected abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private an(Context context) {
        this.f955a = context.getSharedPreferences("mipush_oc", 0);
    }

    public static an a(Context context) {
        if (a == null) {
            synchronized (an.class) {
                if (a == null) {
                    a = new an(context);
                }
            }
        }
        return a;
    }

    private String a(int i) {
        return "normal_oc_" + i;
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        if (pair.second instanceof Integer) {
            editor.putInt(str, ((Integer) pair.second).intValue());
        } else if (pair.second instanceof Long) {
            editor.putLong(str, ((Long) pair.second).longValue());
        } else if (pair.second instanceof String) {
            String str2 = (String) pair.second;
            if (str.equals(a(hh.AppIsInstalledList.a()))) {
                str2 = bf.a(str2);
            }
            editor.putString(str, str2);
        } else if (pair.second instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) pair.second).booleanValue());
        }
    }

    private String b(int i) {
        return "custom_oc_" + i;
    }

    public int a(int i, int i2) {
        String b = b(i);
        if (this.f955a.contains(b)) {
            return this.f955a.getInt(b, 0);
        }
        String a2 = a(i);
        return this.f955a.contains(a2) ? this.f955a.getInt(a2, 0) : i2;
    }

    public String a(int i, String str) {
        String b = b(i);
        if (this.f955a.contains(b)) {
            return this.f955a.getString(b, null);
        }
        String a2 = a(i);
        return this.f955a.contains(a2) ? this.f955a.getString(a2, null) : str;
    }

    public synchronized void a() {
        this.f956a.clear();
    }

    public synchronized void a(a aVar) {
        if (!this.f956a.contains(aVar)) {
            this.f956a.add(aVar);
        }
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (!ad.a(list)) {
            SharedPreferences.Editor edit = this.f955a.edit();
            for (Pair<Integer, Object> pair : list) {
                if (!(pair.first == null || pair.second == null)) {
                    a(edit, pair, a(((Integer) pair.first).intValue()));
                }
            }
            edit.commit();
        }
    }

    public boolean a(int i, boolean z) {
        String b = b(i);
        if (this.f955a.contains(b)) {
            return this.f955a.getBoolean(b, false);
        }
        String a2 = a(i);
        return this.f955a.contains(a2) ? this.f955a.getBoolean(a2, false) : z;
    }

    void b() {
        b.c("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f956a);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public void b(List<Pair<Integer, Object>> list) {
        if (!ad.a(list)) {
            SharedPreferences.Editor edit = this.f955a.edit();
            for (Pair<Integer, Object> pair : list) {
                if (pair.first != null) {
                    String b = b(((Integer) pair.first).intValue());
                    if (pair.second == null) {
                        edit.remove(b);
                    } else {
                        a(edit, pair, b);
                    }
                }
            }
            edit.commit();
        }
    }
}
