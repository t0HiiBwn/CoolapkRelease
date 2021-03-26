package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public class cw {
    public static int a(Context context, int i) {
        int a = gn.a(context);
        if (-1 == a) {
            return -1;
        }
        return (i * (a == 0 ? 13 : 11)) / 10;
    }

    public static int a(hc hcVar) {
        return em.a(hcVar.a());
    }

    public static int a(in inVar, hc hcVar) {
        int a;
        switch (cx.a[hcVar.ordinal()]) {
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
                return em.a(hcVar.a());
            case 11:
                a = em.a(hcVar.a());
                if (inVar != null) {
                    try {
                        if (inVar instanceof ht) {
                            String str = ((ht) inVar).f661d;
                            if (!TextUtils.isEmpty(str) && em.a(em.m291a(str)) != -1) {
                                a = em.a(em.m291a(str));
                                break;
                            }
                        } else if (inVar instanceof ib) {
                            String str2 = ((ib) inVar).f722d;
                            if (!TextUtils.isEmpty(str2)) {
                                if (em.a(em.m291a(str2)) != -1) {
                                    a = em.a(em.m291a(str2));
                                }
                                if (hm.UploadTinyData.equals(em.m291a(str2))) {
                                    return -1;
                                }
                            }
                        }
                    } catch (Exception unused) {
                        b.d("PERF_ERROR : parse Notification type error");
                        return a;
                    }
                }
                break;
            case 12:
                a = em.a(hcVar.a());
                if (inVar != null) {
                    try {
                        if (inVar instanceof hx) {
                            String b = ((hx) inVar).b();
                            if (!TextUtils.isEmpty(b) && ew.a(b) != -1) {
                                a = ew.a(b);
                                break;
                            }
                        } else if (inVar instanceof hw) {
                            String a2 = ((hw) inVar).a();
                            if (!TextUtils.isEmpty(a2) && ew.a(a2) != -1) {
                                return ew.a(a2);
                            }
                        }
                    } catch (Exception unused2) {
                        b.d("PERF_ERROR : parse Command type error");
                        break;
                    }
                }
                break;
            default:
                return -1;
        }
        return a;
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i > 0 && i2 > 0) {
            int a = a(context, i2);
            if (i != em.a(hm.UploadTinyData)) {
                en.a(context.getApplicationContext()).a(str, i, 1, (long) a);
            }
        }
    }

    public static void a(String str, Context context, hy hyVar, int i) {
        hc a;
        if (context != null && hyVar != null && (a = hyVar.a()) != null) {
            int a2 = a(a);
            if (i <= 0) {
                byte[] a3 = im.a(hyVar);
                i = a3 != null ? a3.length : 0;
            }
            a(str, context, a2, i);
        }
    }

    public static void a(String str, Context context, in inVar, hc hcVar, int i) {
        a(str, context, a(inVar, hcVar), i);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context != null && bArr != null && bArr.length > 0) {
            hy hyVar = new hy();
            try {
                im.a(hyVar, bArr);
                a(str, context, hyVar, bArr.length);
            } catch (is unused) {
                b.m41a("fail to convert bytes to container");
            }
        }
    }
}
