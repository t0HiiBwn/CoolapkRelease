package com.tencent.android.tpush.e;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Build;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.f;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class a {
    private static long a = 0;
    private static long b = 172800000;
    private static com.tencent.android.tpush.e.a.a c;

    private static com.tencent.android.tpush.e.a.a d(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new com.tencent.android.tpush.e.a.a(context.getApplicationContext());
                }
            }
        }
        return c;
    }

    public static boolean a(Context context, Intent intent) {
        long longExtra = intent.getLongExtra("msgId", -1);
        ContentValues contentValues = new ContentValues();
        contentValues.put("msgid", Long.valueOf(longExtra));
        boolean z = true;
        contentValues.put("message", Rijndael.encrypt(intent.toUri(1)));
        contentValues.put("time", Long.valueOf(f.b(intent)));
        contentValues.put("busiid", Long.valueOf(intent.getLongExtra("busiMsgId", 0)));
        contentValues.put("showedtime", (Integer) 0);
        contentValues.put("status", (Integer) 0);
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.insert("messagetoshow", null, contentValues) <= 0) {
                TLogger.e("MessageInfoManager", "addCacheMessage Error! ");
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "addNewCacheMessage Error! " + th);
            return false;
        }
    }

    public static boolean a(Context context, long j) {
        e(context);
        return a(context, j, 1);
    }

    public static boolean b(Context context, long j) {
        e(context);
        return a(context, j, 2);
    }

    public static boolean c(Context context, long j) {
        return a(context, j, 3);
    }

    public static boolean d(Context context, long j) {
        return a(context, j, 4);
    }

    private static boolean a(Context context, long j, int i) {
        ContentValues contentValues = new ContentValues();
        boolean z = true;
        if (i == 1 || i == 2) {
            contentValues.put("showedtime", Long.valueOf(System.currentTimeMillis()));
        }
        contentValues.put("status", Integer.valueOf(i));
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (((long) writableDatabase.update("messagetoshow", contentValues, "msgid=?", new String[]{j + ""})) <= 0) {
                TLogger.d("MessageInfoManager", "updateCacheMessage Error! msgId:" + j + ", status:" + i);
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "updateCacheMessage Error! " + th);
            return false;
        }
    }

    private static boolean e(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = a;
        boolean z = true;
        if (j == 0 || currentTimeMillis - j > 86400000) {
            a = currentTimeMillis;
            long j2 = currentTimeMillis - b;
            try {
                SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
                if (writableDatabase.delete("messagetoshow", "status >= ? AND showedtime < ? ", new String[]{"1", j2 + ""}) <= 0) {
                    TLogger.d("MessageInfoManager", "delOldShowedCacheMessage Error! toDelTime: " + j2);
                    z = false;
                }
                writableDatabase.close();
            } catch (Throwable th) {
                TLogger.e("MessageInfoManager", "delOldShowedCacheMessage Error! " + th);
                return false;
            }
        }
        return z;
    }

    public static boolean e(Context context, long j) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", "msgid=?", new String[]{j + ""}) <= 0) {
                TLogger.d("MessageInfoManager", "delCacheMessage Error! msgid to delete: " + j);
                if (writableDatabase != null) {
                    try {
                        writableDatabase.close();
                    } catch (Throwable unused) {
                        TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
                    }
                }
                return false;
            }
            if (writableDatabase != null) {
                try {
                    writableDatabase.close();
                } catch (Throwable unused2) {
                    TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
                }
            }
            return true;
        } catch (Throwable unused3) {
            TLogger.w("MessageInfoManager", "unexpected for delCacheMessage, db close error");
        }
        return false;
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", null, null) <= 0) {
                TLogger.w("MessageInfoManager", "delAllCacheMessage but no mssgage in db");
                z = false;
            } else {
                z = true;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "delAllCacheMessage Error! " + th);
            return false;
        }
    }

    public static boolean f(Context context, long j) {
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            boolean z = true;
            if (writableDatabase.delete("messagetoshow", "busiid=?", new String[]{j + ""}) <= 0) {
                TLogger.d("MessageInfoManager", "delCacheMessageByBusiId Error! msgid to delete which busiId = : " + j);
                z = false;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "delCacheMessageByBusiId Error! " + th);
            return false;
        }
    }

    public static boolean b(Context context) {
        boolean z;
        try {
            SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
            if (writableDatabase.delete("messagetoshow", "msgid < 0", null) <= 0) {
                TLogger.d("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! ");
                z = false;
            } else {
                z = true;
            }
            writableDatabase.close();
            return z;
        } catch (Throwable th) {
            TLogger.e("MessageInfoManager", "deleteAllLocalCacheMsgIntent Error! " + th);
            return false;
        }
    }

    public static ArrayList<Intent> c(Context context) {
        ArrayList<Intent> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase readableDatabase = d(context).getReadableDatabase();
            SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
            sQLiteQueryBuilder.setTables("messagetoshow");
            Cursor query = sQLiteQueryBuilder.query(readableDatabase, new String[]{"message"}, "status=0", null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    try {
                        Intent parseUri = Intent.parseUri(Rijndael.decrypt(query.getString(0)), 1);
                        parseUri.addCategory("android.intent.category.BROWSABLE");
                        parseUri.setComponent(null);
                        if (Build.VERSION.SDK_INT >= 15) {
                            try {
                                parseUri.getClass().getMethod("setSelector", Intent.class).invoke(parseUri, null);
                            } catch (Throwable th) {
                                TLogger.w("MessageInfoManager", "invoke intent.setComponent error.", th);
                            }
                        }
                        arrayList.add(parseUri);
                    } catch (URISyntaxException e) {
                        TLogger.e("MessageInfoManager", "getCacheMessages Error: " + e);
                    }
                }
                query.close();
            }
            readableDatabase.close();
        } catch (Throwable th2) {
            TLogger.e("MessageInfoManager", "getNewCacheMessages Error! " + th2);
        }
        return arrayList;
    }
}
