package com.bytedance.tea.crash.b.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.tea.crash.b.a.a;
import com.bytedance.tea.crash.g.j;
import java.util.HashMap;

/* compiled from: DuplicateLogDAO */
public class b extends a<a> {
    public b() {
        super("duplicatelog");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public boolean a(SQLiteDatabase sQLiteDatabase, String str) {
        int i;
        Exception e;
        if (sQLiteDatabase == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Cursor query = sQLiteDatabase.query(this.b, null, "path=?", new String[]{str}, null, null, null);
            i = query.getCount();
            try {
                query.close();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
            j.b(e);
            if (i <= 0) {
            }
        }
        if (i <= 0) {
            return true;
        }
        return false;
    }

    public void a(SQLiteDatabase sQLiteDatabase, a aVar) {
        if (aVar != null && !a(sQLiteDatabase, aVar.a)) {
            super.a(sQLiteDatabase, (SQLiteDatabase) aVar);
            try {
                sQLiteDatabase.execSQL("delete from " + this.b + " where _id in (select _id from " + this.b + " order by insert_time desc limit 1000 offset 500)");
            } catch (Exception e) {
                j.b(e);
            }
        }
    }

    @Override // com.bytedance.tea.crash.b.b.a
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public ContentValues a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar.a);
        contentValues.put("insert_time", Long.valueOf(aVar.b));
        return contentValues;
    }
}
