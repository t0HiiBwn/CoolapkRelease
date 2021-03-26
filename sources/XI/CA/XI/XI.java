package XI.CA.XI;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public class XI {

    /* renamed from: XI  reason: collision with root package name */
    public Context f1166XI;

    public XI(Context context) {
        this.f1166XI = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042 A[SYNTHETIC, Splitter:B:18:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    public String XI(int i, String str) {
        Uri uri;
        Cursor cursor;
        String str2;
        Throwable th;
        String str3;
        StringBuilder sb;
        String str4;
        Cursor cursor2 = null;
        r0 = null;
        String str5 = null;
        Cursor cursor3 = null;
        if (i != 0) {
            if (i == 1) {
                sb = new StringBuilder();
                str4 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_";
            } else if (i == 2) {
                sb = new StringBuilder();
                str4 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_";
            } else if (i != 4) {
                uri = null;
                cursor = this.f1166XI.getContentResolver().query(uri, null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToNext()) {
                            str5 = cursor.getString(cursor.getColumnIndex("value"));
                        }
                        cursor.close();
                    } catch (Exception unused) {
                        cursor2 = cursor;
                        str2 = null;
                        if (cursor2 != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        cursor3 = cursor;
                        if (cursor3 != null) {
                        }
                        throw th;
                    }
                }
                if (cursor == null) {
                    return str5;
                }
                cursor.close();
                return str5;
            } else {
                str3 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS";
            }
            sb.append(str4);
            sb.append(str);
            str3 = sb.toString();
        } else {
            str3 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        }
        uri = Uri.parse(str3);
        try {
            cursor = this.f1166XI.getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
            }
            if (cursor == null) {
            }
        } catch (Exception unused2) {
            str2 = null;
            if (cursor2 != null) {
                return str2;
            }
            str5 = str2;
            cursor = cursor2;
            cursor.close();
            return str5;
        } catch (Throwable th3) {
            th = th3;
            if (cursor3 != null) {
                cursor3.close();
            }
            throw th;
        }
        cursor.close();
        return str5;
    }
}
