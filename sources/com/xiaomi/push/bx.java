package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.a.a.a.c;

public class bx {
    public static int a(Context context, int i) {
        int b = fs.b(context);
        if (-1 == b) {
            return -1;
        }
        return (i * (b == 0 ? 13 : 11)) / 10;
    }

    public static int a(gi giVar) {
        return du.b(giVar.a());
    }

    public static int a(hu huVar, gi giVar) {
        int b;
        switch (by.a[giVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return du.b(giVar.a());
            case 11:
                b = du.b(giVar.a());
                if (huVar != null) {
                    try {
                        if (huVar instanceof ha) {
                            String str = ((ha) huVar).e;
                            if (!TextUtils.isEmpty(str) && du.a(du.b(str)) != -1) {
                                b = du.a(du.b(str));
                                break;
                            }
                        } else if (huVar instanceof hi) {
                            String str2 = ((hi) huVar).e;
                            if (!TextUtils.isEmpty(str2)) {
                                if (du.a(du.b(str2)) != -1) {
                                    b = du.a(du.b(str2));
                                }
                                if (gs.UploadTinyData.equals(du.b(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        c.d("PERF_ERROR : parse Notification type error");
                        return b;
                    }
                }
                break;
            case 12:
                b = du.b(giVar.a());
                if (huVar != null) {
                    try {
                        if (huVar instanceof he) {
                            String d = ((he) huVar).d();
                            if (!TextUtils.isEmpty(d) && ea.a(d) != -1) {
                                b = ea.a(d);
                                break;
                            }
                        } else if (huVar instanceof hd) {
                            String d2 = ((hd) huVar).d();
                            if (!TextUtils.isEmpty(d2) && ea.a(d2) != -1) {
                                return ea.a(d2);
                            }
                        }
                    } catch (Exception unused2) {
                        c.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return b;
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i > 0 && i2 > 0) {
            int a = a(context, i2);
            if (i != du.a(gs.UploadTinyData)) {
                dv.a(context.getApplicationContext()).a(str, i, 1, (long) a);
            }
        }
    }

    public static void a(String str, Context context, hf hfVar, int i) {
        gi a;
        if (context != null && hfVar != null && (a = hfVar.a()) != null) {
            int a2 = a(a);
            if (i <= 0) {
                byte[] a3 = ht.a(hfVar);
                i = a3 != null ? a3.length : 0;
            }
            a(str, context, a2, i);
        }
    }

    public static void a(String str, Context context, hu huVar, gi giVar, int i) {
        a(str, context, a(huVar, giVar), i);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            hf hfVar = new hf();
            try {
                ht.a(hfVar, bArr);
                a(str, context, hfVar, bArr.length);
            } catch (ia unused) {
                c.a("fail to convert bytes to container");
            }
        }
    }
}
