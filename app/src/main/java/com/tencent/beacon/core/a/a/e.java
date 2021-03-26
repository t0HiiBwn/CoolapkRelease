package com.tencent.beacon.core.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.g;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: DBOpenHelper */
public final class e extends SQLiteOpenHelper {
    private static Map<String, e> b = new HashMap();
    private static Map<String, Object> c = new HashMap();
    private Context a;
    private SQLiteDatabase d;

    /* JADX WARNING: Illegal instructions before constructor call */
    private e(Context context, String str) {
        super(context, r4, (SQLiteDatabase.CursorFactory) null, d.a);
        String str2;
        if (g.a(str)) {
            str2 = "beacon_db";
        } else {
            str2 = "beacon_db_" + str;
        }
        this.d = null;
        this.a = context;
    }

    public static synchronized e a(Context context, String str) {
        e eVar;
        synchronized (e.class) {
            eVar = b.get(str);
            if (eVar == null) {
                eVar = new e(context, str);
                b.put(str, eVar);
                c.put(str, new Object());
            }
        }
        return eVar;
    }

    public static Object a(String str) {
        Object obj = c.get(str);
        if (obj != null) {
            return obj;
        }
        Object obj2 = new Object();
        c.put(str, obj2);
        return obj2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            String[][] strArr = d.b;
            String[][] strArr2 = d.b;
            for (int i = 0; i < 7; i++) {
                String[] strArr3 = strArr2[i];
                b.g("[db] Table:%s", strArr3[0]);
                sQLiteDatabase.execSQL(strArr3[1]);
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        b.g("[db] Upgrade a db  [%s] from v %d to v %d , deleted all tables!", "beacon_db", Integer.valueOf(i), Integer.valueOf(i2));
        a(sQLiteDatabase);
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        if (b(sQLiteDatabase)) {
            b.g("[db] drop all success recreate!", new Object[0]);
            onCreate(sQLiteDatabase);
            return;
        }
        b.c("[db] drop all fail try deleted file,may next time will success!", new Object[0]);
        File databasePath = this.a.getDatabasePath("beacon_db");
        if (databasePath != null && databasePath.canWrite()) {
            databasePath.delete();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        com.tencent.beacon.core.b.e.a(this.a);
        if (Integer.parseInt(com.tencent.beacon.core.b.e.c()) >= 11) {
            b.g("[db] Downgrade a db  [%s] from v %d to  v%d , deleted all tables!", "beacon_db", Integer.valueOf(i), Integer.valueOf(i2));
            a(sQLiteDatabase);
        }
    }

    private synchronized boolean b(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            ArrayList<String> arrayList = new ArrayList();
            Cursor query = sQLiteDatabase.query("sqlite_master", new String[]{"name"}, "type = 'table'", null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    arrayList.add(query.getString(0));
                }
            }
            if (arrayList.size() > 0) {
                for (String str : arrayList) {
                    if (!str.equals("sqlite_sequence") && !str.equals("android_metadata")) {
                        sQLiteDatabase.execSQL(String.format(Locale.US, "drop table if exists %s", str));
                        b.g("[db] drop %s", str);
                    }
                }
            }
            if (query != null) {
                if (!query.isClosed()) {
                    query.close();
                }
            }
        } catch (Throwable th) {
            if (0 != 0 && !cursor.isClosed()) {
                cursor.close();
            }
            throw th;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        int i = 0;
        while (true) {
            sQLiteDatabase = this.d;
            if (sQLiteDatabase != null || i >= 5) {
                break;
            }
            i++;
            try {
                this.d = super.getWritableDatabase();
            } catch (Exception unused) {
                b.c("[db] getWritableDatabase error count %d", Integer.valueOf(i));
                if (i == 5) {
                    b.d("[db] error get DB failed", new Object[0]);
                } else {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        b.a(e);
                    }
                }
            }
        }
        return sQLiteDatabase;
    }
}
