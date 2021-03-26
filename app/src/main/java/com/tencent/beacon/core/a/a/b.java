package com.tencent.beacon.core.a.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: AnalyticsDAO */
public final class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.util.List, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009d, code lost:
        r13 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009e, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a0, code lost:
        r13 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:12:0x002a] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static synchronized List a(Context context, String str) {
        ?? r1;
        ?? r13;
        synchronized (b.class) {
            Cursor cursor = null;
            if (context == null) {
                com.tencent.beacon.core.d.b.d("[db] queryReqData context null ", new Object[0]);
                return null;
            }
            try {
                Cursor query = e.a(context, str).getWritableDatabase().query("t_req_data", null, null, null, null, null, "_time DESC ", "1");
                try {
                    if (query.moveToNext()) {
                        r13 = new ArrayList();
                        r13.add(Integer.valueOf(query.getInt(query.getColumnIndex("_id"))));
                        r13.add(query.getString(query.getColumnIndex("_rid")));
                        r13.add(Long.valueOf(query.getLong(query.getColumnIndex("_time"))));
                        r13.add(query.getBlob(query.getColumnIndex("_datas")));
                        r13.add(Integer.valueOf(query.getInt(query.getColumnIndex("_cnt"))));
                        com.tencent.beacon.core.d.b.a("[db] queryReqData get +1", new Object[0]);
                        cursor = r13;
                    }
                    if (query != null && !query.isClosed()) {
                        query.close();
                    }
                    com.tencent.beacon.core.d.b.b("[db] queryReqData end", new Object[0]);
                    r1 = cursor;
                } catch (Exception unused) {
                    cursor = query;
                    cursor.close();
                    com.tencent.beacon.core.d.b.b("[db] queryReqData end", new Object[0]);
                    r1 = r13;
                    return r1;
                } catch (Throwable th) {
                }
            } catch (Exception unused2) {
                r13 = null;
                cursor.close();
                com.tencent.beacon.core.d.b.b("[db] queryReqData end", new Object[0]);
                r1 = r13;
                return r1;
            } catch (Throwable th2) {
                Throwable th3 = th2;
                cursor.close();
                com.tencent.beacon.core.d.b.b("[db] queryReqData end", new Object[0]);
                throw th3;
            }
            return r1;
        }
    }

    public static synchronized boolean a(Context context, String str, byte[] bArr, String str2, int i) {
        boolean z;
        synchronized (b.class) {
            boolean z2 = false;
            if (context == null || bArr == null || str2 == null) {
                com.tencent.beacon.core.d.b.d("[db] AnalyticsDAO.insertReqData() have null args", new Object[0]);
                return false;
            }
            try {
                SQLiteDatabase writableDatabase = e.a(context, str).getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("_rid", str2);
                contentValues.put("_time", Long.valueOf(new Date().getTime()));
                contentValues.put("_cnt", Integer.valueOf(i));
                contentValues.put("_datas", bArr);
                if (writableDatabase.insert("t_req_data", null, contentValues) < 0) {
                    com.tencent.beacon.core.d.b.d("[db] insertReqData failure! return", new Object[0]);
                    z = false;
                } else {
                    z = true;
                }
                com.tencent.beacon.core.d.b.b("[db] insertReqData end", new Object[0]);
                z2 = z;
            } catch (Throwable th) {
                com.tencent.beacon.core.d.b.b("[db] insertReqData end", new Object[0]);
                throw th;
            }
            return z2;
        }
    }

    public static synchronized boolean a(Context context, String str, String str2) {
        synchronized (b.class) {
            boolean z = false;
            if (context == null) {
                com.tencent.beacon.core.d.b.d("[db] deleteReqData context is null", new Object[0]);
                return false;
            } else if (str2 == null || str2.trim().equals("")) {
                return false;
            } else {
                String str3 = "_rid = '" + str2 + "' ";
                com.tencent.beacon.core.d.b.b("[db] deleteReqData where: " + str3, new Object[0]);
                try {
                    int delete = e.a(context, str).getWritableDatabase().delete("t_req_data", str3, null);
                    com.tencent.beacon.core.d.b.b("[db] deleteReqData num: " + delete, new Object[0]);
                    boolean z2 = true;
                    if (delete != 1) {
                        z2 = false;
                    }
                    com.tencent.beacon.core.d.b.b("[db] deleteReqData end", new Object[0]);
                    z = z2;
                } catch (Throwable th) {
                    com.tencent.beacon.core.d.b.b("[db] deleteReqData end", new Object[0]);
                    throw th;
                }
                return z;
            }
        }
    }

    public static synchronized boolean a(Context context, String str, List<a> list) {
        synchronized (b.class) {
            boolean z = false;
            if (context == null) {
                com.tencent.beacon.core.d.b.d("[db] insert have null args", new Object[0]);
                return false;
            } else if (list.size() <= 0) {
                com.tencent.beacon.core.d.b.b("[db] insert list size == 0 return true", new Object[0]);
                return true;
            } else {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = e.a(context, str).getWritableDatabase();
                    writableDatabase.beginTransaction();
                    for (int i = 0; i < list.size(); i++) {
                        a aVar = list.get(i);
                        ContentValues contentValues = new ContentValues();
                        if (aVar.a > 0) {
                            contentValues.put("_id", Long.valueOf(aVar.a));
                        }
                        contentValues.put("_prority", Integer.valueOf(aVar.c));
                        contentValues.put("_time", Long.valueOf(aVar.d));
                        contentValues.put("_type", Integer.valueOf(aVar.b));
                        contentValues.put("_datas", aVar.e);
                        contentValues.put("_length", Long.valueOf(aVar.f));
                        long insert = writableDatabase.insert("t_event", "_id", contentValues);
                        if (insert < 0) {
                            com.tencent.beacon.core.d.b.d("[db] insert failure! return", new Object[0]);
                        }
                        aVar.a = insert;
                    }
                    writableDatabase.setTransactionSuccessful();
                    try {
                        writableDatabase.endTransaction();
                    } catch (Exception unused) {
                        com.tencent.beacon.core.d.b.b("[db] db.endTransaction() error.", new Object[0]);
                    }
                    com.tencent.beacon.core.d.b.b("[db] insert events to [%s] end", "t_event");
                    z = true;
                } catch (Throwable th) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Exception unused2) {
                        com.tencent.beacon.core.d.b.b("[db] db.endTransaction() error.", new Object[0]);
                    }
                    com.tencent.beacon.core.d.b.b("[db] insert events to [%s] end", "t_event");
                    throw th;
                }
                return z;
            }
        }
    }

    public static synchronized int a(Context context, String str, int[] iArr) {
        synchronized (b.class) {
            int i = -1;
            if (context == null) {
                com.tencent.beacon.core.d.b.d("[db] delete context is null arg", new Object[0]);
                return -1;
            }
            String str2 = "_time >= -1 and _time <= 9223372036854775807";
            if (iArr != null && iArr.length > 0) {
                String str3 = "";
                for (int i2 = 0; i2 < iArr.length; i2++) {
                    str3 = str3 + " or _type = " + iArr[i2];
                }
                str2 = str2 + " and ( " + str3.substring(4) + " )";
            }
            com.tencent.beacon.core.d.b.b("[db] delete where: " + str2, new Object[0]);
            try {
                int delete = e.a(context, str).getWritableDatabase().delete("t_event", str2, null);
                com.tencent.beacon.core.d.b.b("[db] deleted num: " + delete, new Object[0]);
                com.tencent.beacon.core.d.b.b("[db] delete end", new Object[0]);
                i = delete;
            } catch (Throwable th) {
                com.tencent.beacon.core.d.b.b("[db] delete end", new Object[0]);
                throw th;
            }
            return i;
        }
    }

    public static synchronized int a(Context context, String str, Long[] lArr) {
        int i;
        Throwable th;
        synchronized (b.class) {
            if (context == null) {
                com.tencent.beacon.core.d.b.d("[db] deleteList have null args!", new Object[0]);
                return -1;
            } else if (lArr == null || lArr.length <= 0) {
                return 0;
            } else {
                try {
                    SQLiteDatabase writableDatabase = e.a(context, str).getWritableDatabase();
                    StringBuffer stringBuffer = new StringBuffer();
                    i = 0;
                    for (int i2 = 0; i2 < lArr.length; i2++) {
                        try {
                            long longValue = lArr[i2].longValue();
                            stringBuffer.append(" or  _id = " + longValue);
                            if (i2 > 0 && i2 % 25 == 0) {
                                com.tencent.beacon.core.d.b.b("[db] current position: " + i2, new Object[0]);
                                i += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                                stringBuffer.setLength(0);
                                com.tencent.beacon.core.d.b.b("[db] current deleteNum: " + i, new Object[0]);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                com.tencent.beacon.core.d.b.d("[db] " + th.getMessage(), new Object[0]);
                                com.tencent.beacon.core.d.b.b("[db] deleteList end!", new Object[0]);
                                return i;
                            } catch (Throwable th3) {
                                com.tencent.beacon.core.d.b.b("[db] deleteList end!", new Object[0]);
                                throw th3;
                            }
                        }
                    }
                    if (stringBuffer.length() > 0) {
                        i += writableDatabase.delete("t_event", stringBuffer.substring(4), null);
                        stringBuffer.setLength(0);
                    }
                    com.tencent.beacon.core.d.b.a("[db] total deleteNum: " + i, new Object[0]);
                    com.tencent.beacon.core.d.b.b("[db] deleteList end!", new Object[0]);
                } catch (Throwable th4) {
                    th = th4;
                    i = 0;
                    com.tencent.beacon.core.d.b.d("[db] " + th.getMessage(), new Object[0]);
                    com.tencent.beacon.core.d.b.b("[db] deleteList end!", new Object[0]);
                    return i;
                }
                return i;
            }
        }
    }

    public static synchronized List<a> a(Context context, String str, int[] iArr, int i) {
        List<a> b;
        synchronized (b.class) {
            b = b(context, str, iArr, i);
        }
        return b;
    }

    private static List<a> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int columnIndex = cursor.getColumnIndex("_id");
        int columnIndex2 = cursor.getColumnIndex("_prority");
        int columnIndex3 = cursor.getColumnIndex("_time");
        int columnIndex4 = cursor.getColumnIndex("_type");
        int columnIndex5 = cursor.getColumnIndex("_datas");
        int columnIndex6 = cursor.getColumnIndex("_length");
        while (cursor.moveToNext()) {
            a aVar = new a();
            aVar.a = cursor.getLong(columnIndex);
            aVar.e = cursor.getBlob(columnIndex5);
            aVar.c = cursor.getInt(columnIndex2);
            aVar.d = cursor.getLong(columnIndex3);
            aVar.b = cursor.getInt(columnIndex4);
            aVar.f = cursor.getLong(columnIndex6);
            arrayList.add(aVar);
        }
        com.tencent.beacon.core.d.b.b("[db] in parseCursor end", new Object[0]);
        return arrayList;
    }

    public static synchronized int b(Context context, String str, int[] iArr) {
        synchronized (b.class) {
            int i = -1;
            if (context == null) {
                com.tencent.beacon.core.d.b.a("[db] querySum context is null arg", new Object[0]);
                return -1;
            }
            String str2 = "";
            for (int i2 = 0; i2 < 4; i2++) {
                str2 = str2 + " or _type = " + iArr[i2];
            }
            String str3 = "_time >= -1 and _time <= 9223372036854775807 and ( " + str2.substring(4) + " )";
            com.tencent.beacon.core.d.b.b("[db] query where: " + str3, new Object[0]);
            Cursor cursor = null;
            try {
                cursor = e.a(context, str).getWritableDatabase().query("t_event", new String[]{"count(*) as sum"}, str3, null, null, null, null);
                cursor.moveToNext();
                int i3 = cursor.getInt(cursor.getColumnIndex("sum"));
                com.tencent.beacon.core.d.b.b("[db] query sum: " + i3, new Object[0]);
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                com.tencent.beacon.core.d.b.b("[db] querySum end", new Object[0]);
                i = i3;
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                com.tencent.beacon.core.d.b.b("[db] querySum end", new Object[0]);
                throw th;
            }
            return i;
        }
    }

    private static synchronized List<a> b(Context context, String str, int[] iArr, int i) {
        List<a> c;
        synchronized (b.class) {
            c = c(context, str, iArr, i);
        }
        return c;
    }

    private static synchronized List<a> c(Context context, String str, int[] iArr, int i) {
        Throwable th;
        List<a> list;
        synchronized (b.class) {
            Cursor cursor = null;
            List<a> list2 = null;
            if (context != null) {
                String str2 = "";
                if (iArr != null) {
                    if (iArr.length > 0) {
                        String str3 = "";
                        for (int i2 = 0; i2 < iArr.length; i2++) {
                            str3 = str3 + " or _type = " + iArr[i2];
                        }
                        str2 = str2 + str3.substring(4);
                    }
                }
                String str4 = str2.length() > 0 ? " ( " + str2 + " ) " : "";
                String str5 = "_prority ASC , _time DESC ";
                if (str5.endsWith(" , ")) {
                    str5 = str5.substring(0, str5.length() - 3);
                }
                com.tencent.beacon.core.d.b.b("[db] where:%s", str4);
                try {
                    Cursor query = e.a(context, str).getWritableDatabase().query("t_event", null, str4, null, null, null, str5, i >= 0 ? String.valueOf(i) : null);
                    try {
                        com.tencent.beacon.core.d.b.b("[db] result num: " + query.getCount(), new Object[0]);
                        if (query.getCount() > 0) {
                            list2 = a(query);
                        }
                        if (list2 != null) {
                            com.tencent.beacon.core.d.b.b("[db] total num: " + list2.size(), new Object[0]);
                        }
                        if (query != null && !query.isClosed()) {
                            query.close();
                        }
                        com.tencent.beacon.core.d.b.b("[db] in query end", new Object[0]);
                    } catch (Throwable th2) {
                        th = th2;
                        list = null;
                        cursor = query;
                        try {
                            com.tencent.beacon.core.d.b.d(th.getMessage(), new Object[0]);
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            com.tencent.beacon.core.d.b.b("[db] in query end", new Object[0]);
                            list2 = list;
                            return list2;
                        } catch (Throwable th3) {
                            if (cursor != null && !cursor.isClosed()) {
                                cursor.close();
                            }
                            com.tencent.beacon.core.d.b.b("[db] in query end", new Object[0]);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                    list = null;
                    com.tencent.beacon.core.d.b.d(th.getMessage(), new Object[0]);
                    cursor.close();
                    com.tencent.beacon.core.d.b.b("[db] in query end", new Object[0]);
                    list2 = list;
                    return list2;
                }
                return list2;
            }
            com.tencent.beacon.core.d.b.d("[db] query args context == null || timeStart > timeEnd || miniCount > maxCount || miniUploadCount > maxUploadCount ,pls check", new Object[0]);
            return null;
        }
    }
}
