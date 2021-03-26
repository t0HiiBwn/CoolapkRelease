package com.loc;

import android.content.Context;
import android.database.Cursor;
import android.net.Proxy;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

/* compiled from: ProxyUtil */
public final class s {
    private static String a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            ab.b(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    public static java.net.Proxy a(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? a(context, new URI("http://restsdk.amap.com")) : b(context);
        } catch (Throwable th) {
            ab.b(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy a(Context context, URI uri) {
        java.net.Proxy proxy;
        if (c(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null || proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                ab.b(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            ab.b(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == -1) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a6, code lost:
        if (r10 == -1) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ab, code lost:
        r18 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0119, code lost:
        if (r12 == -1) goto L_0x011b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0142 A[SYNTHETIC, Splitter:B:100:0x0142] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x014d A[SYNTHETIC, Splitter:B:105:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x015c A[Catch:{ all -> 0x0158 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b9 A[SYNTHETIC, Splitter:B:53:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d4 A[SYNTHETIC, Splitter:B:66:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013e  */
    private static java.net.Proxy b(Context context) {
        boolean z;
        String str;
        int i;
        Cursor cursor;
        SecurityException e;
        String s;
        int i2;
        Throwable th;
        boolean z2;
        boolean z3;
        Throwable th2;
        boolean z4;
        boolean z5;
        if (c(context)) {
            z = false;
            try {
                cursor = context.getContentResolver().query(Uri.parse("content://telephony/carriers/preferapn"), null, null, null, null);
                if (cursor != null) {
                    try {
                        if (cursor.moveToFirst()) {
                            String string = cursor.getString(cursor.getColumnIndex("apn"));
                            if (string != null) {
                                string = string.toLowerCase(Locale.US);
                            }
                            if (string != null && string.contains("ctwap")) {
                                String a = a();
                                i = b();
                                try {
                                    if (TextUtils.isEmpty(a) || a.equals("null")) {
                                        str = null;
                                        z5 = false;
                                    } else {
                                        str = a;
                                        z5 = true;
                                    }
                                    if (!z5) {
                                        try {
                                            str = u.c("QMTAuMC4wLjIwMA==");
                                        } catch (SecurityException e2) {
                                            e = e2;
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            try {
                                                ab.b(th2, "pu", "gPx1");
                                                th2.printStackTrace();
                                                if (cursor != null) {
                                                }
                                                if (str != null) {
                                                }
                                                if (z) {
                                                }
                                                return null;
                                            } catch (Throwable th4) {
                                                ab.b(th4, "pu", "gPx2");
                                            }
                                        }
                                    }
                                } catch (SecurityException e3) {
                                    e = e3;
                                    str = null;
                                    ab.b(e, "pu", "ghp");
                                    s = n.s(context);
                                    if (s != null) {
                                    }
                                    if (cursor != null) {
                                    }
                                    i = i2;
                                    if (str != null) {
                                    }
                                    if (z) {
                                    }
                                    return null;
                                } catch (Throwable th5) {
                                    th2 = th5;
                                    str = null;
                                    ab.b(th2, "pu", "gPx1");
                                    th2.printStackTrace();
                                    if (cursor != null) {
                                    }
                                    if (str != null) {
                                    }
                                    if (z) {
                                    }
                                    return null;
                                }
                            } else if (string != null && string.contains("wap")) {
                                String a2 = a();
                                i = b();
                                if (TextUtils.isEmpty(a2) || a2.equals("null")) {
                                    str = null;
                                    z4 = false;
                                } else {
                                    str = a2;
                                    z4 = true;
                                }
                                if (!z4) {
                                    str = u.c("QMTAuMC4wLjE3Mg==");
                                }
                            }
                            i2 = 80;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            }
                            i = i2;
                            if (str != null) {
                                try {
                                    if (str.length() > 0 && i != -1) {
                                        z = true;
                                    }
                                } catch (Throwable th7) {
                                    y.a(th7, "pu", "gp2");
                                    th7.printStackTrace();
                                }
                            }
                            if (z) {
                                return new java.net.Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(str, i));
                            }
                        }
                    } catch (SecurityException e4) {
                        e = e4;
                        str = null;
                        i = -1;
                        ab.b(e, "pu", "ghp");
                        s = n.s(context);
                        if (s != null) {
                        }
                        if (cursor != null) {
                        }
                        i = i2;
                        if (str != null) {
                        }
                        if (z) {
                        }
                        return null;
                    } catch (Throwable th8) {
                        th2 = th8;
                        str = null;
                        i = -1;
                        ab.b(th2, "pu", "gPx1");
                        th2.printStackTrace();
                        if (cursor != null) {
                        }
                        if (str != null) {
                        }
                        if (z) {
                        }
                        return null;
                    }
                }
                str = null;
                i2 = -1;
                if (cursor != null) {
                }
            } catch (SecurityException e5) {
                e = e5;
                cursor = null;
                str = null;
                i = -1;
                ab.b(e, "pu", "ghp");
                s = n.s(context);
                if (s != null) {
                    String lowerCase = s.toLowerCase(Locale.US);
                    String a3 = a();
                    int b = b();
                    if (lowerCase.indexOf("ctwap") != -1) {
                        if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                            z3 = false;
                        } else {
                            str = a3;
                            z3 = true;
                        }
                        if (!z3) {
                            str = u.c("QMTAuMC4wLjIwMA==");
                        }
                    } else {
                        if (lowerCase.indexOf("wap") != -1) {
                            if (TextUtils.isEmpty(a3) || a3.equals("null")) {
                                z2 = false;
                            } else {
                                str = a3;
                                z2 = true;
                            }
                            if (!z2) {
                                str = u.c("QMTAuMC4wLjE3Mg==");
                            }
                        }
                        i2 = b;
                    }
                    i2 = 80;
                } else {
                    i2 = i;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th9) {
                        th = th9;
                    }
                }
                i = i2;
                if (str != null) {
                }
                if (z) {
                }
                return null;
            } catch (Throwable th10) {
                th2 = th10;
                cursor = null;
                str = null;
                i = -1;
                ab.b(th2, "pu", "gPx1");
                th2.printStackTrace();
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Throwable th11) {
                        ab.b(th11, "pu", "gPx2");
                    }
                }
                if (str != null) {
                }
                if (z) {
                }
                return null;
            }
            i = i2;
            if (str != null) {
            }
            if (z) {
            }
        }
        return null;
        throw th;
        ab.b(th, "pu", "gPx2");
        i = i2;
        if (str != null) {
        }
        if (z) {
        }
        return null;
    }

    private static boolean c(Context context) {
        return n.q(context) == 0;
    }
}
