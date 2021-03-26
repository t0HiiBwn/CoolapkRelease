package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.ce;

public class cb extends ce.e {
    private String a = "MessageInsertJob";

    public cb(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = str2;
    }

    public static cb a(Context context, String str, hg hgVar) {
        byte[] a2 = im.a(hgVar);
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", hgVar.d());
        contentValues.put("messageItem", a2);
        contentValues.put("appId", bs.a(context).b());
        contentValues.put("packageName", bs.a(context).m149a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new cb(str, contentValues, "a job build to insert message to db");
    }
}
