package com.ss.android.downloadlib.addownload;

import android.text.TextUtils;
import com.ss.android.downloadlib.h.k;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.downloader.g;
import com.ss.android.socialbase.downloader.network.l;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: ChunkCalculatorFactory */
public class d {
    private static b a;
    private static c b;

    public static g a(String str) {
        if (a == null) {
            a = new b(k.i());
        }
        return new a(a, str);
    }

    public static f a() {
        if (b == null) {
            b = new c(k.i());
        }
        return b;
    }

    public static g a(String str, JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("download_chunk_config") || com.ss.android.socialbase.downloader.g.a.f("download_chunk_config")) {
            return a(str);
        }
        return b(jSONObject);
    }

    public static f a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("download_chunk_config") || com.ss.android.socialbase.downloader.g.a.f("download_chunk_config")) {
            return null;
        }
        return c(jSONObject);
    }

    public static g b(JSONObject jSONObject) {
        return new b(jSONObject);
    }

    public static f c(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    /* compiled from: ChunkCalculatorFactory */
    static class c implements f {
        private int a;
        private ArrayList<int[]> b = new ArrayList<>();

        public c(JSONObject jSONObject) {
            a(jSONObject);
        }

        private void a(JSONObject jSONObject) {
            this.a = jSONObject.optInt("is_open_exp", 0);
            b(jSONObject);
        }

        private void b(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.has("download_chunk_config")) {
                String obj = jSONObject.opt("download_chunk_config").toString();
                if (!TextUtils.isEmpty(obj)) {
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = new JSONObject(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (jSONObject2 != null) {
                        String optString = jSONObject2.optString("network_quality_operation");
                        String optString2 = jSONObject2.optString("network_quality_operand");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            try {
                                String[] split = optString.split(",");
                                String[] split2 = optString2.split(",");
                                if (split.length < 5) {
                                    return;
                                }
                                if (split2.length >= 5) {
                                    for (int i = 0; i < 5; i++) {
                                        this.b.add(new int[]{Integer.parseInt(split[i]), Integer.parseInt(split2[i])});
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
        }

        @Override // com.ss.android.socialbase.downloader.downloader.f
        public int a(int i, l lVar) {
            return a() ? b(i, lVar) : i;
        }

        boolean a() {
            int i = this.a;
            return i == 2 || i == 3;
        }

        private int b(int i, l lVar) {
            if (this.b.size() < 5) {
                return i;
            }
            int[] iArr = null;
            int i2 = AnonymousClass1.a[lVar.ordinal()];
            if (i2 == 1) {
                iArr = this.b.get(0);
            } else if (i2 == 2) {
                iArr = this.b.get(1);
            } else if (i2 == 3) {
                iArr = this.b.get(2);
            } else if (i2 == 4) {
                iArr = this.b.get(3);
            } else if (i2 == 5) {
                iArr = this.b.get(4);
            }
            if (iArr == null || iArr.length < 2) {
                return i;
            }
            int i3 = iArr[0];
            if (i3 == 1) {
                i += iArr[1];
            } else if (i3 == 2) {
                i -= iArr[1];
            } else if (i3 == 3) {
                i = iArr[1];
            }
            if (i > 1) {
                return i;
            }
            return 1;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.d$1  reason: invalid class name */
    /* compiled from: ChunkCalculatorFactory */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[l.values().length];
            a = iArr;
            try {
                iArr[l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[l.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: ChunkCalculatorFactory */
    static class b implements g {
        private int a;
        private ArrayList<int[]> b = new ArrayList<>();

        protected boolean b(long j) {
            return true;
        }

        public b(JSONObject jSONObject) {
            a(jSONObject);
        }

        private void a(JSONObject jSONObject) {
            this.a = jSONObject.optInt("is_open_exp", 0);
            b(jSONObject);
        }

        @Override // com.ss.android.socialbase.downloader.downloader.g
        public int a(long j) {
            if (!a() || !b(j)) {
                return 1;
            }
            return a((int) (j / 1048576));
        }

        public boolean a() {
            int i = this.a;
            return i == 1 || i == 3;
        }

        private void b(JSONObject jSONObject) {
            if (jSONObject != null && jSONObject.has("download_chunk_config")) {
                String obj = jSONObject.opt("download_chunk_config").toString();
                if (!TextUtils.isEmpty(obj)) {
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = new JSONObject(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (jSONObject2 != null) {
                        String[] strArr = new String[5];
                        String[][] strArr2 = new String[5][];
                        strArr[1] = jSONObject2.optString("download_chunk_1");
                        strArr[2] = jSONObject2.optString("download_chunk_2");
                        strArr[3] = jSONObject2.optString("download_chunk_3");
                        strArr[4] = jSONObject2.optString("download_chunk_4");
                        for (int i = 1; i < 5; i++) {
                            if (!TextUtils.isEmpty(strArr[i])) {
                                try {
                                    strArr2[i] = strArr[i].split(",");
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                                for (int i2 = 0; i2 < strArr2[i].length - 1; i2 += 2) {
                                    try {
                                        this.b.add(new int[]{i, Integer.parseInt(strArr2[i][i2]), Integer.parseInt(strArr2[i][i2 + 1])});
                                    } catch (Throwable th2) {
                                        th2.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        private int a(int i) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                int[] iArr = this.b.get(i2);
                if (i >= iArr[1] && i < iArr[2]) {
                    return iArr[0];
                }
            }
            return 1;
        }
    }

    /* compiled from: ChunkCalculatorFactory */
    static class a implements g {
        private final String a;
        private b b;

        public a(b bVar, String str) {
            this.b = bVar;
            this.a = str;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.g
        public int a(long j) {
            b bVar;
            if (!k.d(this.a) || (bVar = this.b) == null) {
                return 1;
            }
            return bVar.a(j);
        }
    }
}
