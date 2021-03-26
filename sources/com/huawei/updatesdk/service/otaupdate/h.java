package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.updatesdk.service.e.c;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class h {
    private static h a = new h();
    private String b;
    private String c;
    private String d = null;

    private static class a extends AsyncTask<Void, Void, String> {
        private a() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x006d A[SYNTHETIC, Splitter:B:14:0x006d] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0096 A[SYNTHETIC, Splitter:B:25:0x0096] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1 A[SYNTHETIC, Splitter:B:31:0x00a1] */
        /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        public String doInBackground(Void... voidArr) {
            Throwable th;
            Exception e;
            String str;
            Cursor cursor = null;
            String str2 = null;
            try {
                Cursor cursor2 = com.huawei.updatesdk.a.b.a.a.a().b().getContentResolver().query(Uri.parse("content://com.huawei.appmarket.commondata/item/1"), null, null, null, null);
                if (cursor2 != null) {
                    try {
                        if (cursor2.moveToFirst()) {
                            str2 = cursor2.getString(cursor2.getColumnIndex("homecountry"));
                            h.a().b(str2);
                            com.huawei.updatesdk.service.a.a.a().b(System.currentTimeMillis());
                            com.huawei.updatesdk.service.a.a.a().b(str2);
                            Log.i("ServiceZoneUtil", "AccountZoneFromHiApp = " + str2);
                            if (cursor2 != null) {
                                return str2;
                            }
                            try {
                                cursor2.close();
                                return str2;
                            } catch (Exception unused) {
                                com.huawei.updatesdk.a.a.b.a.a.a.d("ServiceZoneUtil", "cursor Execption");
                                return str2;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str = null;
                        cursor = cursor2;
                        try {
                            Log.e("ServiceZoneUtil", "close cursor error: " + e.toString());
                            if (cursor != null) {
                            }
                            return str;
                        } catch (Throwable th2) {
                            cursor2 = cursor;
                            th = th2;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception unused2) {
                                    com.huawei.updatesdk.a.a.b.a.a.a.d("ServiceZoneUtil", "cursor Execption");
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                Log.e("ServiceZoneUtil", "cursor == null: ");
                if (cursor2 != null) {
                }
            } catch (Exception e3) {
                e = e3;
                str = null;
                Log.e("ServiceZoneUtil", "close cursor error: " + e.toString());
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused3) {
                        com.huawei.updatesdk.a.a.b.a.a.a.d("ServiceZoneUtil", "cursor Execption");
                    }
                }
                return str;
            }
        }
    }

    private h() {
    }

    public static h a() {
        return a;
    }

    public void a(Context context) {
        this.c = null;
        if (c.b(context)) {
            if (Math.abs(System.currentTimeMillis() - com.huawei.updatesdk.service.a.a.a().d()) < 86400000) {
                a().b(com.huawei.updatesdk.service.a.a.a().e());
                return;
            }
            a aVar = new a();
            aVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
            try {
                aVar.get(1000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                aVar.cancel(true);
                Log.e("ServiceZoneUtil", "init AccountZone error: " + e.toString());
            }
        }
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return !TextUtils.isEmpty(this.b) ? this.b : this.c;
    }

    public void c(String str) {
        this.d = str;
    }

    public boolean d() {
        String str = this.b;
        if (str != null) {
            return str.equals(this.c);
        }
        return true;
    }
}
