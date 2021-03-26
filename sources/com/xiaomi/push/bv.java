package com.xiaomi.push;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class bv {

    public static class a extends bu {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.bu
        public String b(Context context, String str, List<z> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (z zVar : list) {
                    buildUpon.appendQueryParameter(zVar.a(), zVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return aa.a(context, url);
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    private static int a(bu buVar, String str, List<z> list, String str2) {
        if (buVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (buVar.a() != 2) {
            return -1;
        }
        return a(str.length(), a(list), a(str2));
    }

    static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            return 0;
        }
    }

    static int a(List<z> list) {
        int i = 0;
        for (z zVar : list) {
            if (!TextUtils.isEmpty(zVar.a())) {
                i += zVar.a().length();
            }
            if (!TextUtils.isEmpty(zVar.b())) {
                i += zVar.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<z> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
    public static String a(Context context, String str, List<z> list, bu buVar, boolean z) {
        bm bmVar;
        IOException iOException;
        String str2;
        String str3;
        IOException e;
        if (aa.c(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    bm a2 = bq.a().a(str);
                    if (a2 != null) {
                        arrayList = a2.a(str);
                    }
                    bmVar = a2;
                } else {
                    bmVar = null;
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
                Iterator<String> it2 = arrayList.iterator();
                String str4 = null;
                while (it2.hasNext()) {
                    String next = it2.next();
                    ArrayList arrayList2 = list != null ? new ArrayList(list) : null;
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        if (!buVar.a(context, next, arrayList2)) {
                            return str4;
                        }
                        String b = buVar.b(context, next, arrayList2);
                        try {
                            if (!TextUtils.isEmpty(b)) {
                                if (bmVar != null) {
                                    try {
                                        bmVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(buVar, next, arrayList2, b));
                                    } catch (IOException e2) {
                                        iOException = e2;
                                        str2 = b;
                                    }
                                }
                                return b;
                            }
                            if (bmVar != null) {
                                str3 = b;
                                try {
                                    bmVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(buVar, next, arrayList2, b), null);
                                } catch (IOException e3) {
                                    e = e3;
                                }
                            } else {
                                str3 = b;
                            }
                            str4 = str3;
                        } catch (IOException e4) {
                            e = e4;
                            str3 = b;
                            iOException = e;
                            str2 = str3;
                            if (bmVar != null) {
                                bmVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(buVar, next, arrayList2, str2), iOException);
                            }
                            iOException.printStackTrace();
                            str4 = str2;
                        }
                    } catch (IOException e5) {
                        iOException = e5;
                        str2 = str4;
                        if (bmVar != null) {
                        }
                        iOException.printStackTrace();
                        str4 = str2;
                    }
                }
                return str4;
            } catch (MalformedURLException e6) {
                e6.printStackTrace();
            }
        }
        return null;
    }
}
