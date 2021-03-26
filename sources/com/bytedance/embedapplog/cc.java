package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.embedapplog.cf;

final class cc implements cf {
    private bs<Boolean> a = new bs<Boolean>() {
        /* class com.bytedance.embedapplog.cc.AnonymousClass1 */

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return false;
        }
    };

    cc() {
    }

    @Override // com.bytedance.embedapplog.cf
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        return this.a.b(context).booleanValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A[DONT_GENERATE] */
    @Override // com.bytedance.embedapplog.cf
    public cf.a b(Context context) {
        Throwable th;
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                cf.a aVar = new cf.a();
                aVar.b = a(cursor);
                if (cursor != null) {
                    cursor.close();
                }
                return aVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
            th.printStackTrace();
            return null;
        }
    }

    private String a(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
