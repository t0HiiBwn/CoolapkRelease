package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class fe {
    protected static final String a = Locale.getDefault().getLanguage().toLowerCase();
    public static final DateFormat b;
    private static String c = null;
    private static String d = (fp.a(5) + "-");
    private static long e = 0;
    private String f = c;
    private String g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private String k = null;
    private List<fb> l = new CopyOnWriteArrayList();
    private final Map<String, Object> m = new HashMap();
    private fi n = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        b = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public fe() {
    }

    public fe(Bundle bundle) {
        this.h = bundle.getString("ext_to");
        this.i = bundle.getString("ext_from");
        this.j = bundle.getString("ext_chid");
        this.g = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.l = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fb a2 = fb.a((Bundle) parcelable);
                if (a2 != null) {
                    this.l.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.n = new fi(bundle2);
        }
    }

    public static synchronized String j() {
        String sb;
        synchronized (fe.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(d);
            long j2 = e;
            e = 1 + j2;
            sb2.append(Long.toString(j2));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String u() {
        return a;
    }

    public void a(fb fbVar) {
        this.l.add(fbVar);
    }

    public void a(fi fiVar) {
        this.n = fiVar;
    }

    public Bundle b() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_ns", this.f);
        }
        if (!TextUtils.isEmpty(this.i)) {
            bundle.putString("ext_from", this.i);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_to", this.h);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_pkt_id", this.g);
        }
        if (!TextUtils.isEmpty(this.j)) {
            bundle.putString("ext_chid", this.j);
        }
        fi fiVar = this.n;
        if (fiVar != null) {
            bundle.putBundle("ext_ERROR", fiVar.a());
        }
        List<fb> list = this.l;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (fb fbVar : this.l) {
                Bundle e2 = fbVar.e();
                if (e2 != null) {
                    bundleArr[i2] = e2;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public fb b(String str, String str2) {
        for (fb fbVar : this.l) {
            if ((str2 == null || str2.equals(fbVar.b())) && str.equals(fbVar.a())) {
                return fbVar;
            }
        }
        return null;
    }

    public abstract String c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fe feVar = (fe) obj;
        fi fiVar = this.n;
        if (fiVar == null ? feVar.n != null : !fiVar.equals(feVar.n)) {
            return false;
        }
        String str = this.i;
        if (str == null ? feVar.i != null : !str.equals(feVar.i)) {
            return false;
        }
        if (!this.l.equals(feVar.l)) {
            return false;
        }
        String str2 = this.g;
        if (str2 == null ? feVar.g != null : !str2.equals(feVar.g)) {
            return false;
        }
        String str3 = this.j;
        if (str3 == null ? feVar.j != null : !str3.equals(feVar.j)) {
            return false;
        }
        Map<String, Object> map = this.m;
        if (map == null ? feVar.m != null : !map.equals(feVar.m)) {
            return false;
        }
        String str4 = this.h;
        if (str4 == null ? feVar.h != null : !str4.equals(feVar.h)) {
            return false;
        }
        String str5 = this.f;
        String str6 = feVar.f;
        if (str5 != null) {
            if (str5.equals(str6)) {
                return true;
            }
        } else if (str6 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.h;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.i;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.j;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode()) * 31;
        fi fiVar = this.n;
        if (fiVar != null) {
            i2 = fiVar.hashCode();
        }
        return hashCode5 + i2;
    }

    public String k() {
        if ("ID_NOT_AVAILABLE".equals(this.g)) {
            return null;
        }
        if (this.g == null) {
            this.g = j();
        }
        return this.g;
    }

    public void k(String str) {
        this.g = str;
    }

    public String l() {
        return this.j;
    }

    public void l(String str) {
        this.j = str;
    }

    public String m() {
        return this.h;
    }

    public void m(String str) {
        this.h = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.i = str;
    }

    public String o() {
        return this.k;
    }

    public void o(String str) {
        this.k = str;
    }

    public fb p(String str) {
        return b(str, null);
    }

    public fi p() {
        return this.n;
    }

    public synchronized Object q(String str) {
        Map<String, Object> map = this.m;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public synchronized Collection<fb> q() {
        if (this.l == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.l));
    }

    public synchronized Collection<String> r() {
        if (this.m == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.m.keySet()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0105 A[SYNTHETIC, Splitter:B:56:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0118 A[SYNTHETIC, Splitter:B:65:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011f A[SYNTHETIC, Splitter:B:69:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x010d A[SYNTHETIC] */
    protected synchronized String s() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        Exception e3;
        String str;
        sb = new StringBuilder();
        for (fb fbVar : q()) {
            sb.append(fbVar.d());
        }
        Map<String, Object> map = this.m;
        if (map != null && !map.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str2 : r()) {
                Object q = q(str2);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(fp.a(str2));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (q instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(q);
                    str = "</value>";
                } else if (q instanceof Long) {
                    sb.append("long\">");
                    sb.append(q);
                    str = "</value>";
                } else if (q instanceof Float) {
                    sb.append("float\">");
                    sb.append(q);
                    str = "</value>";
                } else if (q instanceof Double) {
                    sb.append("double\">");
                    sb.append(q);
                    str = "</value>";
                } else if (q instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(q);
                    str = "</value>";
                } else if (q instanceof String) {
                    sb.append("string\">");
                    sb.append(fp.a((String) q));
                    str = "</value>";
                } else {
                    ObjectOutputStream objectOutputStream2 = null;
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                        } catch (Exception e4) {
                            e3 = e4;
                            objectOutputStream = null;
                            e2 = e3;
                            try {
                                e2.printStackTrace();
                                if (objectOutputStream != null) {
                                }
                                if (byteArrayOutputStream == null) {
                                }
                                byteArrayOutputStream.close();
                                sb.append("</property>");
                            } catch (Throwable th2) {
                                th = th2;
                                objectOutputStream2 = objectOutputStream;
                                if (objectOutputStream2 != null) {
                                    try {
                                        objectOutputStream2.close();
                                    } catch (Exception unused) {
                                    }
                                }
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (objectOutputStream2 != null) {
                            }
                            if (byteArrayOutputStream != null) {
                            }
                            throw th;
                        }
                        try {
                            objectOutputStream.writeObject(q);
                            sb.append("java-object\">");
                            sb.append(fp.a(byteArrayOutputStream.toByteArray()));
                            sb.append("</value>");
                            try {
                                objectOutputStream.close();
                            } catch (Exception unused3) {
                            }
                        } catch (Exception e5) {
                            e2 = e5;
                            e2.printStackTrace();
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (byteArrayOutputStream == null) {
                                sb.append("</property>");
                            }
                            byteArrayOutputStream.close();
                            sb.append("</property>");
                        }
                    } catch (Exception e6) {
                        e3 = e6;
                        byteArrayOutputStream = null;
                        objectOutputStream = null;
                        e2 = e3;
                        e2.printStackTrace();
                        if (objectOutputStream != null) {
                        }
                        if (byteArrayOutputStream == null) {
                        }
                        byteArrayOutputStream.close();
                        sb.append("</property>");
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayOutputStream = null;
                        if (objectOutputStream2 != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        throw th;
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused5) {
                    }
                    sb.append("</property>");
                }
                sb.append(str);
                sb.append("</property>");
            }
            sb.append("</properties>");
        }
        return sb.toString();
    }

    public String t() {
        return this.f;
    }
}
