package com.ss.android.downloadlib.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.g.a;
import org.json.JSONObject;

/* compiled from: ClickEventHelper */
public class c {
    private static volatile c b;
    private SQLiteDatabase a;

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private c() {
        try {
            this.a = new b(k.a()).getWritableDatabase();
        } catch (Throwable th) {
            com.ss.android.downloadlib.h.k.a(th);
        }
    }

    public boolean b() {
        return a.c().a("click_event_switch", 0) == 1;
    }

    public boolean c() {
        return a.c().a("click_event_switch", 0) == 2;
    }

    public void a(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && j > 0 && !TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (!TextUtils.isEmpty(optString)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ad_id", Long.valueOf(j));
                    contentValues.put("req_id", optString);
                    contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                    this.a.insert("click_event", null, contentValues);
                    c(j, str);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean b(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        boolean z = false;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen() || j <= 0 || TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            String optString = new JSONObject(str).optString("req_id");
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            Cursor query = this.a.query("click_event", b.a, "time > ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString}, null, null, null, null);
            if (query.getCount() > 0) {
                z = true;
            }
            if (query != null) {
                query.close();
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            if (0 != 0) {
                cursor.close();
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    private void c(long j, String str) {
        SQLiteDatabase sQLiteDatabase = this.a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen() && j > 0 && !TextUtils.isEmpty(str)) {
            try {
                String optString = new JSONObject(str).optString("req_id");
                if (!TextUtils.isEmpty(optString)) {
                    this.a.delete("click_event", "time < ? AND ad_id = ? AND req_id = ?", new String[]{String.valueOf(System.currentTimeMillis() - 1209600000), String.valueOf(j), optString});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
