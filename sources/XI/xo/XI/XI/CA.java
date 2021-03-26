package XI.xo.XI.XI;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

public class CA {
    public static volatile CA J9;
    public K0 CA = new K0();
    public XI K0 = new XI("oaid");

    /* renamed from: XI  reason: collision with root package name */
    public XI f187XI = new XI("udid");
    public XI kM = new XI("aaid");
    public BroadcastReceiver vs;
    public XI xo = new XI("vaid");

    public static final CA XI() {
        if (J9 == null) {
            synchronized (CA.class) {
                if (J9 == null) {
                    J9 = new CA();
                }
            }
        }
        return J9;
    }

    public static kM XI(Cursor cursor) {
        kM kMVar = new kM(null, 0);
        if (cursor.isClosed()) {
            return kMVar;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            kMVar.f190XI = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("code");
        if (columnIndex2 >= 0) {
            kMVar.K0 = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("expired");
        if (columnIndex3 >= 0) {
            kMVar.kM = cursor.getLong(columnIndex3);
        }
        return kMVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    public final String XI(Context context, XI xi) {
        Throwable th;
        Cursor cursor;
        String str;
        Exception e;
        boolean XI2;
        StringBuilder sb;
        String str2;
        Cursor cursor2 = null;
        r0 = null;
        String str3 = null;
        if (xi == null) {
            return null;
        }
        if (xi.f189XI > System.currentTimeMillis()) {
            return xi.K0;
        }
        if (!XI(context, true)) {
            return null;
        }
        String str4 = xi.kM;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{xi.kM}, null);
            if (cursor != null) {
                try {
                    kM XI3 = XI(cursor);
                    str3 = XI3.f190XI;
                    xi.K0 = str3;
                    xi.f189XI = XI3.kM;
                    xi.xo = XI3.K0;
                    String str5 = xi.kM;
                    int i = xi.xo;
                    if (XI3.K0 != 1000) {
                        XI(context);
                        if (!XI(context, false)) {
                            XI2 = XI(context, true);
                            sb = new StringBuilder();
                            str2 = "not support, forceQuery isSupported: ";
                        }
                    }
                    if (cursor == null) {
                        return str3;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = null;
                    cursor2 = cursor;
                    try {
                        e.getMessage();
                        if (cursor2 != null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
                cursor.close();
                return str3;
            }
            if (XI(context, false)) {
                XI2 = XI(context, true);
                sb = new StringBuilder();
                str2 = "forceQuery isSupported : ";
            }
            if (cursor == null) {
            }
            cursor.close();
            return str3;
            sb.append(str2);
            sb.append(XI2);
            sb.toString();
            if (cursor == null) {
            }
        } catch (Exception e3) {
            e = e3;
            str = null;
            e.getMessage();
            if (cursor2 != null) {
                return str;
            }
            cursor = cursor2;
            str3 = str;
            cursor.close();
            return str3;
        }
        cursor.close();
        return str3;
    }

    public final synchronized void XI(Context context) {
        if (this.vs == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            xo xoVar = new xo();
            this.vs = xoVar;
            context.registerReceiver(xoVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ad, code lost:
        if (r1 != null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b6, code lost:
        if (0 == 0) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b8, code lost:
        r1.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ca  */
    public final boolean XI(Context context, boolean z) {
        String str;
        K0 k0;
        ProviderInfo resolveContentProvider;
        Boolean bool = this.CA.K0;
        boolean z2 = true;
        boolean z3 = false;
        if (!(bool != null) || z) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            Cursor cursor = null;
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo("com.meizu.safe", 0);
                if (packageInfo != null) {
                    str = packageInfo.versionName;
                    k0 = this.CA;
                    if (k0.K0 == null) {
                        if (TextUtils.isEmpty(str) ? false : TextUtils.equals(k0.f188XI, str)) {
                            Boolean bool2 = this.CA.K0;
                            if (bool2 != null) {
                                return bool2.booleanValue();
                            }
                            return false;
                        }
                    }
                    this.CA.f188XI = str;
                    resolveContentProvider = packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0);
                    if ((resolveContentProvider == null || (resolveContentProvider.applicationInfo.flags & 1) == 0 || !TextUtils.equals("com.meizu.safe", resolveContentProvider.packageName)) ? false : true) {
                        try {
                            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                            if (cursor != null) {
                                kM XI2 = XI(cursor);
                                if (1000 == XI2.K0 && !"0".equals(XI2.f190XI)) {
                                    z2 = false;
                                }
                                cursor.close();
                                z3 = z2;
                            }
                        } catch (Exception e) {
                            e.getMessage();
                        } catch (Throwable th) {
                            if (0 != 0) {
                                cursor.close();
                            }
                            throw th;
                        }
                        this.CA.K0 = Boolean.valueOf(z3);
                        return z3;
                    }
                    this.CA.K0 = Boolean.FALSE;
                    return false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                e2.getMessage();
            }
            str = null;
            k0 = this.CA;
            if (k0.K0 == null) {
            }
            this.CA.f188XI = str;
            resolveContentProvider = packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0);
            if (resolveContentProvider == null) {
                if ((resolveContentProvider == null || (resolveContentProvider.applicationInfo.flags & 1) == 0 || !TextUtils.equals("com.meizu.safe", resolveContentProvider.packageName)) ? false : true) {
                }
            }
            if ((resolveContentProvider == null || (resolveContentProvider.applicationInfo.flags & 1) == 0 || !TextUtils.equals("com.meizu.safe", resolveContentProvider.packageName)) ? false : true) {
            }
        } else if (bool != null) {
            return bool.booleanValue();
        } else {
            return false;
        }
    }
}
