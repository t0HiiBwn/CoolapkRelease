package com.pgl.sys.ces.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.List;

public class a {
    private static a c;
    private Context a = null;
    private List<String> b = new ArrayList();

    private a(Context context) {
        this.a = context;
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public int a() {
        Intent registerReceiver = this.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return Math.round(((((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1))) * 100.0f) * 10.0f) / 10;
    }

    public int b() {
        Intent registerReceiver = this.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra("plugged", -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return "-10001";
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public String c() {
        int b2;
        int a2;
        synchronized (this) {
            b2 = b();
            a2 = a();
        }
        return "" + ((b2 * 10000) + a2);
    }

    public void d() {
        String c2 = c();
        if (c2 != null) {
            this.b.add(c2);
            try {
                int size = this.b.size();
                if (size > 20) {
                    ArrayList arrayList = new ArrayList(this.b.subList(size - 10, size));
                    this.b.clear();
                    this.b = arrayList;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized String e() {
        String str = "";
        int size = this.b.size();
        if (size <= 0) {
            return str;
        }
        if (size == 1) {
            return this.b.get(0);
        }
        try {
            List<String> list = this.b;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List<String> subList = list.subList(i, size);
            for (int i2 = 0; i2 < subList.size(); i2++) {
                str = str + subList.get(i2) + ",";
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }
}
