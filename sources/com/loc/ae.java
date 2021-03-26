package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation */
public final class ae {
    private static Map<Class<? extends ad>, ad> d = new HashMap();
    private ah a;
    private SQLiteDatabase b;
    private ad c;

    public ae(Context context, ad adVar) {
        try {
            this.a = new ah(context.getApplicationContext(), adVar.a(), adVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = adVar;
    }

    private static ContentValues a(Object obj, af afVar) {
        ContentValues contentValues = new ContentValues();
        Field[] a2 = a(obj.getClass(), afVar.b());
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(ag.class);
            if (annotation != null) {
                ag agVar = (ag) annotation;
                switch (agVar.b()) {
                    case 1:
                        contentValues.put(agVar.a(), Short.valueOf(field.getShort(obj)));
                        continue;
                    case 2:
                        contentValues.put(agVar.a(), Integer.valueOf(field.getInt(obj)));
                        continue;
                    case 3:
                        contentValues.put(agVar.a(), Float.valueOf(field.getFloat(obj)));
                        continue;
                    case 4:
                        contentValues.put(agVar.a(), Double.valueOf(field.getDouble(obj)));
                        continue;
                    case 5:
                        contentValues.put(agVar.a(), Long.valueOf(field.getLong(obj)));
                        continue;
                    case 6:
                        contentValues.put(agVar.a(), (String) field.get(obj));
                        continue;
                    case 7:
                        try {
                            contentValues.put(agVar.a(), (byte[]) field.get(obj));
                            continue;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        }
                }
            }
        }
        return contentValues;
    }

    private SQLiteDatabase a() {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            y.a(th, "dbs", "grd");
        }
        return this.b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: java.util.Map<java.lang.Class<? extends com.loc.ad>, com.loc.ad> */
    /* JADX WARN: Multi-variable type inference failed */
    public static synchronized ad a(Class<? extends ad> cls) throws IllegalAccessException, InstantiationException {
        ad adVar;
        synchronized (ae.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            adVar = d.get(cls);
        }
        return adVar;
    }

    private static <T> T a(Cursor cursor, Class<T> cls, af afVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj;
        Field[] a2 = a((Class<?>) cls, afVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(ag.class);
            if (annotation != null) {
                ag agVar = (ag) annotation;
                int b2 = agVar.b();
                int columnIndex = cursor.getColumnIndex(agVar.a());
                switch (b2) {
                    case 1:
                        obj = Short.valueOf(cursor.getShort(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 2:
                        obj = Integer.valueOf(cursor.getInt(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 3:
                        obj = Float.valueOf(cursor.getFloat(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 4:
                        obj = Double.valueOf(cursor.getDouble(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 5:
                        obj = Long.valueOf(cursor.getLong(columnIndex));
                        field.set(newInstance, obj);
                        break;
                    case 6:
                        obj = cursor.getString(columnIndex);
                        field.set(newInstance, obj);
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static <T> String a(af afVar) {
        if (afVar == null) {
            return null;
        }
        return afVar.a();
    }

    private static Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private SQLiteDatabase b() {
        try {
            SQLiteDatabase sQLiteDatabase = this.b;
            if (sQLiteDatabase == null || sQLiteDatabase.isReadOnly()) {
                SQLiteDatabase sQLiteDatabase2 = this.b;
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (Throwable th) {
            y.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> af b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(af.class);
        if (!(annotation != null)) {
            return null;
        }
        return (af) annotation;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c A[SYNTHETIC, Splitter:B:52:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ac A[Catch:{ all -> 0x00b2 }] */
    public final <T> List<T> a(String str, Class<T> cls) {
        Throwable th;
        Cursor cursor;
        String str2;
        String str3;
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.c) {
            ArrayList arrayList = new ArrayList();
            af b2 = b(cls);
            String a2 = a(b2);
            if (this.b == null) {
                this.b = a();
            }
            if (this.b == null || TextUtils.isEmpty(a2) || str == null) {
                return arrayList;
            }
            try {
                cursor = this.b.query(a2, null, str, null, null, null, null);
                if (cursor == null) {
                    try {
                        this.b.close();
                        this.b = null;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Throwable th2) {
                                y.a(th2, "dbs", "sld");
                            }
                        }
                        try {
                            SQLiteDatabase sQLiteDatabase2 = this.b;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                                this.b = null;
                            }
                        } catch (Throwable th3) {
                            y.a(th3, "dbs", "sld");
                        }
                        return arrayList;
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            y.a(th, "dbs", "sld");
                            if (cursor != null) {
                            }
                            try {
                                sQLiteDatabase = this.b;
                                if (sQLiteDatabase != null) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                str2 = "dbs";
                                str3 = "sld";
                                y.a(th, str2, str3);
                                return arrayList;
                            }
                            return arrayList;
                        } catch (Throwable th6) {
                            y.a(th6, "dbs", "sld");
                        }
                    }
                } else {
                    while (cursor.moveToNext()) {
                        arrayList.add(a(cursor, cls, b2));
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th7) {
                            y.a(th7, "dbs", "sld");
                        }
                    }
                    try {
                        SQLiteDatabase sQLiteDatabase3 = this.b;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.close();
                            this.b = null;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        str2 = "dbs";
                        str3 = "sld";
                        y.a(th, str2, str3);
                        return arrayList;
                    }
                    return arrayList;
                }
            } catch (Throwable th9) {
                th = th9;
                cursor = null;
                y.a(th, "dbs", "sld");
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th10) {
                        y.a(th10, "dbs", "sld");
                    }
                }
                sQLiteDatabase = this.b;
                if (sQLiteDatabase != null) {
                    sQLiteDatabase.close();
                    this.b = null;
                }
                return arrayList;
            }
        }
        SQLiteDatabase sQLiteDatabase4 = this.b;
        if (sQLiteDatabase4 != null) {
            sQLiteDatabase4.close();
            this.b = null;
        }
        throw th;
        throw th;
    }

    public final void a(Object obj, String str) {
        synchronized (this.c) {
            if (a(str, obj.getClass()).size() == 0) {
                synchronized (this.c) {
                    SQLiteDatabase b2 = b();
                    this.b = b2;
                    if (b2 != null) {
                        try {
                            af b3 = b(obj.getClass());
                            String a2 = a(b3);
                            if (!TextUtils.isEmpty(a2) && b2 != null) {
                                b2.insert(a2, null, a(obj, b3));
                            }
                            SQLiteDatabase sQLiteDatabase = this.b;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.close();
                                this.b = null;
                            }
                        } catch (Throwable th) {
                            SQLiteDatabase sQLiteDatabase2 = this.b;
                            if (sQLiteDatabase2 != null) {
                                sQLiteDatabase2.close();
                                this.b = null;
                            }
                            throw th;
                        }
                    }
                }
            } else {
                synchronized (this.c) {
                    af b4 = b(obj.getClass());
                    String a3 = a(b4);
                    if (!TextUtils.isEmpty(a3)) {
                        ContentValues a4 = a(obj, b4);
                        SQLiteDatabase b5 = b();
                        this.b = b5;
                        if (b5 != null) {
                            try {
                                b5.update(a3, a4, str, null);
                                SQLiteDatabase sQLiteDatabase3 = this.b;
                                if (sQLiteDatabase3 != null) {
                                    sQLiteDatabase3.close();
                                    this.b = null;
                                }
                            } catch (Throwable th2) {
                                SQLiteDatabase sQLiteDatabase4 = this.b;
                                if (sQLiteDatabase4 != null) {
                                    sQLiteDatabase4.close();
                                    this.b = null;
                                }
                                throw th2;
                            }
                        }
                    }
                }
            }
        }
    }
}
