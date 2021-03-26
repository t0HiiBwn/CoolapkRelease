package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import com.xiaomi.push.be;

public class ba extends be.e {
    private String a = "MessageInsertJob";

    public ba(String str, ContentValues contentValues, String str2) {
        super(str, contentValues);
        this.a = str2;
    }

    public static ba a(Context context, String str, gm gmVar) {
        byte[] a2 = ht.a(gmVar);
        if (a2 == null || a2.length <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) 0);
        contentValues.put("messageId", "");
        contentValues.put("messageItemId", gmVar.m());
        contentValues.put("messageItem", a2);
        contentValues.put("appId", ar.a(context).b());
        contentValues.put("packageName", ar.a(context).a());
        contentValues.put("createTimeStamp", Long.valueOf(System.currentTimeMillis()));
        contentValues.put("uploadTimestamp", (Integer) 0);
        return new ba(str, contentValues, "a job build to insert message to db");
    }
}
