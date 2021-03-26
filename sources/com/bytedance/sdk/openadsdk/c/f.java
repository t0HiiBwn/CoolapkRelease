package com.bytedance.sdk.openadsdk.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import com.bytedance.sdk.openadsdk.utils.s;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEventRepertoryImpl */
public class f implements e<a> {
    private final Context a;
    private final d b = d.a(c());

    public f(Context context) {
        this.a = context;
    }

    public Context c() {
        Context context = this.a;
        return context == null ? p.a() : context;
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public List<a> a(int i, String str) {
        String str2;
        if (i <= 0 || TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str + " DESC limit " + i;
        }
        LinkedList linkedList = new LinkedList();
        Cursor a2 = a.a(c(), "adevent", new String[]{"id", "value"}, null, null, null, null, str2);
        if (a2 != null) {
            while (a2.moveToNext()) {
                try {
                    try {
                        linkedList.add(new a(a2.getString(a2.getColumnIndex("id")), new JSONObject(a2.getString(a2.getColumnIndex("value")))));
                    } catch (JSONException unused) {
                    }
                } finally {
                    if (a2 != null) {
                        a2.close();
                    }
                }
            }
        }
        return linkedList;
    }

    public synchronized void a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", aVar.a);
        contentValues.put("value", aVar.b != null ? aVar.b.toString() : "");
        contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("retry", (Integer) 0);
        a.a(c(), "adevent", contentValues);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list) {
        if (!s.a(list)) {
            LinkedList linkedList = new LinkedList();
            for (a aVar : list) {
                linkedList.add(aVar.a);
            }
            a.a(c(), "DELETE FROM adevent WHERE " + a("id", linkedList, 1000, true));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(int i, long j) {
        b(i, j);
    }

    private synchronized void b(int i, long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        Context c = c();
        a.a(c, "adevent", "gen_time <? AND retry >?", new String[]{currentTimeMillis + "", i + ""});
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public synchronized void a(List<a> list, int i, long j) {
        if (!s.a(list)) {
            try {
                b(list);
                b(i, j);
            } catch (Exception unused) {
            }
        }
    }

    private synchronized void b(List<a> list) {
        LinkedList linkedList = new LinkedList();
        for (a aVar : list) {
            linkedList.add(aVar.a);
        }
        a.a(c(), "UPDATE adevent SET retry = retry+1 WHERE " + a("id", linkedList, 1000, true));
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(boolean z) {
        this.b.a("serverbusy_flag", z);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public boolean a() {
        return this.b.b("serverbusy_flag", false);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.b.b("serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.b.a("serverbusy_retrycount", i);
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS adevent (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }

    private static String a(String str, List<?> list, int i, boolean z) {
        int i2;
        String str2 = z ? " IN " : " NOT IN ";
        String str3 = z ? " OR " : " AND ";
        int min = Math.min(i, 1000);
        int size = list.size();
        if (size % min == 0) {
            i2 = size / min;
        } else {
            i2 = (size / min) + 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = i3 * min;
            String a2 = a(TextUtils.join("','", list.subList(i4, Math.min(i4 + min, size))), "");
            if (i3 != 0) {
                sb.append(str3);
            }
            sb.append(str);
            sb.append(str2);
            sb.append("('");
            sb.append(a2);
            sb.append("')");
        }
        String sb2 = sb.toString();
        return a(sb2, str + str2 + "('')");
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }
}
