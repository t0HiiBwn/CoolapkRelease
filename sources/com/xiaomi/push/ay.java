package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.be;
import java.util.ArrayList;
import java.util.List;

public class ay extends be.b<Long> {
    private long a = 0;
    private String d;

    public ay(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.d = str6;
    }

    public static ay a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new ay(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* renamed from: a */
    public Long b(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.be.a
    public Object a() {
        return Long.valueOf(this.a);
    }

    @Override // com.xiaomi.push.be.b
    public void a(Context context, List<Long> list) {
        if (context != null && list != null && list.size() > 0) {
            this.a = list.get(0).longValue();
        }
    }
}
