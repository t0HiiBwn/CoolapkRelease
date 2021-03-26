package org.repackage.com.vivo.identifier;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

public class DataBaseOperation {
    private static final String a = "VMS_IDLG_SDK_DB";
    private static final String b = "content://com.vivo.vms.IdProvider/IdentifierId";
    private static final String c = "value";
    private static final String d = "OAID";
    private static final String e = "AAID";
    private static final String f = "VAID";
    private static final String g = "OAIDSTATUS";
    private static final int h = 0;
    private static final int i = 1;
    private static final int j = 2;
    private static final int k = 4;

    /* renamed from: l  reason: collision with root package name */
    private Context f1514l;

    public DataBaseOperation(Context context) {
        this.f1514l = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006d  */
    public String a(int i2, String str) {
        Uri uri;
        Cursor query;
        Uri uri2;
        String str2 = null;
        if (i2 == 0) {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i2 == 1) {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i2 == 2) {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i2 != 4) {
            uri = null;
            query = this.f1514l.getContentResolver().query(uri, null, null, null, null);
            if (query == null) {
                if (query.moveToNext()) {
                    str2 = query.getString(query.getColumnIndex("value"));
                }
                query.close();
            } else {
                Log.d("VMS_IDLG_SDK_DB", "return cursor is null,return");
            }
            return str2;
        } else {
            uri2 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS");
        }
        uri = uri2;
        query = this.f1514l.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
        }
        return str2;
    }
}
