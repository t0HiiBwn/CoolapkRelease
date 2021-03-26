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

public abstract class cu {

    public static class a extends ct {
        public a() {
            super(1);
        }

        @Override // com.xiaomi.push.ct
        public String a(Context context, String str, List<bb> list) {
            URL url;
            if (list == null) {
                url = new URL(str);
            } else {
                Uri.Builder buildUpon = Uri.parse(str).buildUpon();
                for (bb bbVar : list) {
                    buildUpon.appendQueryParameter(bbVar.a(), bbVar.b());
                }
                url = new URL(buildUpon.toString());
            }
            return bc.a(context, url);
        }
    }

    static int a(int i, int i2) {
        return (((i2 + 243) / 1448) * 132) + 1080 + i + i2;
    }

    static int a(int i, int i2, int i3) {
        return (((i2 + 200) / 1448) * 132) + 1011 + i2 + i + i3;
    }

    private static int a(ct ctVar, String str, List<bb> list, String str2) {
        if (ctVar.a() == 1) {
            return a(str.length(), a(str2));
        }
        if (ctVar.a() != 2) {
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

    static int a(List<bb> list) {
        int i = 0;
        for (bb bbVar : list) {
            if (!TextUtils.isEmpty(bbVar.a())) {
                i += bbVar.a().length();
            }
            if (!TextUtils.isEmpty(bbVar.b())) {
                i += bbVar.b().length();
            }
        }
        return i * 2;
    }

    public static String a(Context context, String str, List<bb> list) {
        return a(context, str, list, new a(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa  */
    public static String a(Context context, String str, List<bb> list, ct ctVar, boolean z) {
        cm cmVar;
        IOException iOException;
        String str2;
        String str3;
        IOException e;
        if (bc.b(context)) {
            try {
                ArrayList<String> arrayList = new ArrayList<>();
                if (z) {
                    cm a2 = cq.a().m186a(str);
                    if (a2 != null) {
                        arrayList = a2.a(str);
                    }
                    cmVar = a2;
                } else {
                    cmVar = null;
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
                        if (!ctVar.m195a(context, next, (List<bb>) arrayList2)) {
                            return str4;
                        }
                        String a3 = ctVar.a(context, next, (List<bb>) arrayList2);
                        try {
                            if (!TextUtils.isEmpty(a3)) {
                                if (cmVar != null) {
                                    try {
                                        cmVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(ctVar, next, arrayList2, a3));
                                    } catch (IOException e2) {
                                        iOException = e2;
                                        str2 = a3;
                                    }
                                }
                                return a3;
                            }
                            if (cmVar != null) {
                                str3 = a3;
                                try {
                                    cmVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(ctVar, next, arrayList2, a3), null);
                                } catch (IOException e3) {
                                    e = e3;
                                }
                            } else {
                                str3 = a3;
                            }
                            str4 = str3;
                        } catch (IOException e4) {
                            e = e4;
                            str3 = a3;
                            iOException = e;
                            str2 = str3;
                            if (cmVar != null) {
                                cmVar.a(next, System.currentTimeMillis() - currentTimeMillis, (long) a(ctVar, next, arrayList2, str2), iOException);
                            }
                            iOException.printStackTrace();
                            str4 = str2;
                        }
                    } catch (IOException e5) {
                        iOException = e5;
                        str2 = str4;
                        if (cmVar != null) {
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
