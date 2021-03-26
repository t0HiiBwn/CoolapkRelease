package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class c {

    public interface a {
        void a(Boolean bool);
    }

    private static class b extends AsyncTask<Void, Void, Boolean> {
        a a;

        public b(a aVar) {
            this.a = aVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x006b, code lost:
            if (r1 != null) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r1.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0071, code lost:
            com.huawei.updatesdk.a.a.b.a.a.a.d("AutoUpdateUtil", "cursor Execption");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
            if (0 == 0) goto L_0x0093;
         */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            Cursor cursor = null;
            boolean z = false;
            try {
                Context b = com.huawei.updatesdk.a.b.a.a.a().b();
                cursor = b.getContentResolver().query(Uri.parse("content://com.huawei.appmarket.commondata/item/4"), null, null, null, null);
                if (cursor == null || !cursor.moveToFirst()) {
                    Log.e("AutoUpdateUtil", "cursor == null");
                } else {
                    boolean booleanValue = Boolean.valueOf(cursor.getString(cursor.getColumnIndex("isagree"))).booleanValue();
                    boolean booleanValue2 = Boolean.valueOf(cursor.getString(cursor.getColumnIndex("isopenautoupdate"))).booleanValue();
                    boolean booleanValue3 = Boolean.valueOf(cursor.getString(cursor.getColumnIndex("isneverreminder"))).booleanValue();
                    if (booleanValue && !booleanValue2 && !booleanValue3) {
                        z = true;
                    }
                }
            } catch (Exception e) {
                Log.e("AutoUpdateUtil", "close cursor error: " + e.toString());
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                        com.huawei.updatesdk.a.a.b.a.a.a.d("AutoUpdateUtil", "cursor Execption");
                    }
                }
                throw th;
            }
            return Boolean.valueOf(z);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(bool);
            }
        }
    }

    public void a(Context context, a aVar) {
        if (!com.huawei.updatesdk.service.e.c.c(context) || !h.a().d()) {
            aVar.a(false);
            return;
        }
        b bVar = new b(aVar);
        bVar.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
        try {
            bVar.get(500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            bVar.cancel(true);
            Log.e("AutoUpdateUtil", "init AutoUpdateInfo error: " + e.toString());
            aVar.a(false);
        }
    }
}
