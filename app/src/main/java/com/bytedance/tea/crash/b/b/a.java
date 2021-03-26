package com.bytedance.tea.crash.b.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.tea.crash.g.j;
import java.util.HashMap;

/* compiled from: AbsDAO */
public abstract class a<T> {
    protected final String a = "_id";
    protected final String b;

    protected abstract ContentValues a(T t);

    protected abstract HashMap<String, String> a();

    protected a(String str) {
        this.b = str;
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CREATE TABLE ");
            sb.append(this.b);
            sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
            HashMap<String, String> a2 = a();
            if (a2 != null) {
                for (String str : a2.keySet()) {
                    sb.append(str);
                    sb.append(" ");
                    sb.append(a2.get(str));
                    sb.append(",");
                }
                sb.delete(sb.length() - 1, sb.length());
                sb.append(")");
                sQLiteDatabase.execSQL(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase, T t) {
        if (sQLiteDatabase != null && t != null) {
            try {
                sQLiteDatabase.insert(this.b, null, a((a<T>) t));
            } catch (Exception e) {
                j.b(e);
            }
        }
    }
}
