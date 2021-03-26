package com.tencent.open.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.utils.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
public class f extends SQLiteOpenHelper {
    protected static final String[] a = {"key"};
    protected static f b;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(e.a());
            }
            fVar = b;
        }
        return fVar;
    }

    public f(Context context) {
        super(context, "sdk_report.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
        onCreate(sQLiteDatabase);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x008a, code lost:
        if (r1 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x008c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x009f, code lost:
        if (r1 == null) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00a3, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0062 A[SYNTHETIC, Splitter:B:33:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x006c A[SYNTHETIC, Splitter:B:44:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0085 A[SYNTHETIC] */
    public synchronized List<Serializable> a(String str) {
        Throwable th;
        Exception e;
        Serializable serializable;
        ObjectInputStream objectInputStream;
        Throwable th2;
        List<Serializable> synchronizedList = Collections.synchronizedList(new ArrayList());
        if (TextUtils.isEmpty(str)) {
            return synchronizedList;
        }
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase == null) {
            return synchronizedList;
        }
        Cursor cursor = null;
        ObjectInputStream objectInputStream2 = null;
        try {
            Cursor query = readableDatabase.query("via_cgi_report", null, "type = ?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        do {
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(query.getBlob(query.getColumnIndex("blob")));
                            try {
                                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                                try {
                                    serializable = (Serializable) objectInputStream.readObject();
                                    try {
                                        objectInputStream.close();
                                    } catch (IOException unused) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                } catch (Exception unused3) {
                                    if (objectInputStream != null) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused4) {
                                    }
                                    serializable = null;
                                    if (serializable != null) {
                                    }
                                    if (!query.moveToNext()) {
                                    }
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    objectInputStream2 = objectInputStream;
                                    if (objectInputStream2 != null) {
                                    }
                                    try {
                                        byteArrayInputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                    throw th2;
                                }
                            } catch (Exception unused6) {
                                objectInputStream = null;
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (IOException unused7) {
                                    }
                                }
                                byteArrayInputStream.close();
                                serializable = null;
                                if (serializable != null) {
                                }
                                if (!query.moveToNext()) {
                                    if (query != null) {
                                    }
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                if (objectInputStream2 != null) {
                                    try {
                                        objectInputStream2.close();
                                    } catch (IOException unused8) {
                                    }
                                }
                                byteArrayInputStream.close();
                                throw th2;
                            }
                            if (serializable != null) {
                                synchronizedList.add(serializable);
                            }
                        } while (!query.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
                        if (cursor != null) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (readableDatabase != null) {
                            readableDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    cursor = query;
                    if (cursor != null) {
                    }
                    if (readableDatabase != null) {
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "getReportItemFromDB has exception.", e);
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0080, code lost:
        if (r1 != null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0082, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0092, code lost:
        if (r1 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0096, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0058 A[SYNTHETIC, Splitter:B:38:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0062  */
    public synchronized void a(String str, List<Serializable> list) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        int size = list.size();
        if (size != 0) {
            if (size > 20) {
                size = 20;
            }
            if (!TextUtils.isEmpty(str)) {
                b(str);
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase != null) {
                    writableDatabase.beginTransaction();
                    try {
                        ContentValues contentValues = new ContentValues();
                        for (int i = 0; i < size; i++) {
                            Serializable serializable = list.get(i);
                            if (serializable != null) {
                                contentValues.put("type", str);
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                                ObjectOutputStream objectOutputStream2 = null;
                                try {
                                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                                    try {
                                        objectOutputStream.writeObject(serializable);
                                        try {
                                            objectOutputStream.close();
                                        } catch (IOException unused) {
                                        }
                                    } catch (IOException unused2) {
                                        if (objectOutputStream != null) {
                                        }
                                        byteArrayOutputStream.close();
                                        contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                        writableDatabase.insert("via_cgi_report", null, contentValues);
                                        contentValues.clear();
                                    } catch (Throwable th2) {
                                        th = th2;
                                        objectOutputStream2 = objectOutputStream;
                                        if (objectOutputStream2 != null) {
                                        }
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (IOException unused3) {
                                        }
                                        throw th;
                                    }
                                } catch (IOException unused4) {
                                    objectOutputStream = null;
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    byteArrayOutputStream.close();
                                    contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                    writableDatabase.insert("via_cgi_report", null, contentValues);
                                    contentValues.clear();
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (objectOutputStream2 != null) {
                                        try {
                                            objectOutputStream2.close();
                                        } catch (IOException unused5) {
                                        }
                                    }
                                    byteArrayOutputStream.close();
                                    throw th;
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException unused6) {
                                }
                                contentValues.put("blob", byteArrayOutputStream.toByteArray());
                                writableDatabase.insert("via_cgi_report", null, contentValues);
                            }
                            contentValues.clear();
                        }
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Exception unused7) {
                        com.tencent.open.a.f.e("openSDK_LOG.ReportDatabaseHelper", "saveReportItemToDB has exception.");
                        writableDatabase.endTransaction();
                    } catch (Throwable th4) {
                        writableDatabase.endTransaction();
                        if (writableDatabase != null) {
                            writableDatabase.close();
                        }
                        throw th4;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        if (r0 != null) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0020, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002e, code lost:
        if (r0 == null) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        return;
     */
    public synchronized void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                try {
                    writableDatabase.delete("via_cgi_report", "type = ?", new String[]{str});
                } catch (Exception e) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportDatabaseHelper", "clearReportItem has exception.", e);
                } catch (Throwable th) {
                    if (writableDatabase != null) {
                        writableDatabase.close();
                    }
                    throw th;
                }
            }
        }
    }
}
