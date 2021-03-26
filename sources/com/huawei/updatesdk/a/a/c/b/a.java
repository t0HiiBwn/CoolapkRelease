package com.huawei.updatesdk.a.a.c.b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.updatesdk.a.a.c.b.a.b;
import java.util.Locale;

public class a {
    private static final Uri a = Uri.parse("content://telephony/carriers/preferapn");
    private static final Uri b = Uri.parse("content://telephony/carriers/preferapn/0");
    private static final Uri c = Uri.parse("content://telephony/carriers/preferapn/1");

    /* renamed from: com.huawei.updatesdk.a.a.c.b.a$a  reason: collision with other inner class name */
    public static class C0077a {
        private String a;
        private String b;
        private String c;

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    public static C0077a a(Context context) throws SecurityException {
        Throwable th;
        SecurityException e;
        Exception e2;
        Cursor cursor;
        C0077a aVar = new C0077a();
        Cursor cursor2 = null;
        try {
            Cursor d = b.b() ? d(context) : c(context);
            if (d == null) {
                if (d != null) {
                    d.close();
                }
                return null;
            }
            while (d.moveToNext()) {
                try {
                    aVar.a(d.getString(d.getColumnIndex("_id")));
                    aVar.c(d.getString(d.getColumnIndex("name")));
                    aVar.b(d.getString(d.getColumnIndex("apn")).toLowerCase(Locale.getDefault()));
                } catch (SecurityException e3) {
                    cursor2 = d;
                    e = e3;
                    try {
                        com.huawei.updatesdk.a.a.b.a.a.a.a("ApnUtil", "getDefaultAPN, SecurityException: ", e);
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    cursor = d;
                    e2 = e4;
                    try {
                        com.huawei.updatesdk.a.a.b.a.a.a.a("ApnUtil", "getDefaultAPN, Exception: ", e2);
                        if (cursor != null) {
                            cursor.close();
                        }
                        if (aVar.a() == null) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    cursor2 = d;
                    th = th4;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (d != null) {
                d.close();
            }
            if (aVar.a() == null) {
                return null;
            }
            return aVar;
        } catch (SecurityException e5) {
            e = e5;
            com.huawei.updatesdk.a.a.b.a.a.a.a("ApnUtil", "getDefaultAPN, SecurityException: ", e);
            throw e;
        } catch (Exception e6) {
            e2 = e6;
            cursor = null;
            com.huawei.updatesdk.a.a.b.a.a.a.a("ApnUtil", "getDefaultAPN, Exception: ", e2);
            if (cursor != null) {
            }
            if (aVar.a() == null) {
            }
        }
    }

    public static boolean b(Context context) {
        try {
            C0077a a2 = a(context);
            if (a2 != null) {
                return a2.b() != null && a2.b().contains("wap");
            }
            return true;
        } catch (SecurityException e) {
            com.huawei.updatesdk.a.a.b.a.a.a.a("ApnUtil", "isWap(), SecurityException: ", e);
            return false;
        }
    }

    private static Cursor c(Context context) {
        return context.getContentResolver().query(a, null, null, null, null);
    }

    private static Cursor d(Context context) {
        Cursor cursor;
        if (b.a().a() == 0) {
            cursor = f(context);
            if (cursor == null) {
                cursor = e(context);
            }
        } else {
            cursor = e(context);
            if (cursor == null) {
                cursor = f(context);
            }
        }
        return cursor == null ? c(context) : cursor;
    }

    private static Cursor e(Context context) {
        return context.getContentResolver().query(c, null, null, null, null);
    }

    private static Cursor f(Context context) {
        return context.getContentResolver().query(b, null, null, null, null);
    }
}
