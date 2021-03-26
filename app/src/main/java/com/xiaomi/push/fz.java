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

public abstract class fz {
    private static long a = 0;

    /* renamed from: a  reason: collision with other field name */
    protected static final String f491a = Locale.getDefault().getLanguage().toLowerCase();

    /* renamed from: a  reason: collision with other field name */
    public static final DateFormat f492a;
    private static String b = null;
    private static String c = (gk.a(5) + "-");

    /* renamed from: a  reason: collision with other field name */
    private gd f493a = null;

    /* renamed from: a  reason: collision with other field name */
    private List<fw> f494a = new CopyOnWriteArrayList();

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, Object> f495a = new HashMap();
    private String d = b;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private String i = null;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f492a = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public fz() {
    }

    public fz(Bundle bundle) {
        this.f = bundle.getString("ext_to");
        this.g = bundle.getString("ext_from");
        this.h = bundle.getString("ext_chid");
        this.e = bundle.getString("ext_pkt_id");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f494a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                fw a2 = fw.a((Bundle) parcelable);
                if (a2 != null) {
                    this.f494a.add(a2);
                }
            }
        }
        Bundle bundle2 = bundle.getBundle("ext_ERROR");
        if (bundle2 != null) {
            this.f493a = new gd(bundle2);
        }
    }

    public static synchronized String i() {
        String sb;
        synchronized (fz.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(c);
            long j = a;
            a = 1 + j;
            sb2.append(Long.toString(j));
            sb = sb2.toString();
        }
        return sb;
    }

    public static String q() {
        return f491a;
    }

    /* renamed from: a */
    public Bundle mo349a() {
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(this.d)) {
            bundle.putString("ext_ns", this.d);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundle.putString("ext_from", this.g);
        }
        if (!TextUtils.isEmpty(this.f)) {
            bundle.putString("ext_to", this.f);
        }
        if (!TextUtils.isEmpty(this.e)) {
            bundle.putString("ext_pkt_id", this.e);
        }
        if (!TextUtils.isEmpty(this.h)) {
            bundle.putString("ext_chid", this.h);
        }
        gd gdVar = this.f493a;
        if (gdVar != null) {
            bundle.putBundle("ext_ERROR", gdVar.a());
        }
        List<fw> list = this.f494a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i2 = 0;
            for (fw fwVar : this.f494a) {
                Bundle a2 = fwVar.a();
                if (a2 != null) {
                    bundleArr[i2] = a2;
                    i2++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    public fw a(String str) {
        return a(str, null);
    }

    public fw a(String str, String str2) {
        for (fw fwVar : this.f494a) {
            if ((str2 == null || str2.equals(fwVar.b())) && str.equals(fwVar.m347a())) {
                return fwVar;
            }
        }
        return null;
    }

    public gd a() {
        return this.f493a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Object m351a(String str) {
        Map<String, Object> map = this.f495a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    /* renamed from: a  reason: collision with other method in class */
    public abstract String m352a();

    /* renamed from: a  reason: collision with other method in class */
    public synchronized Collection<fw> m353a() {
        if (this.f494a == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(new ArrayList(this.f494a));
    }

    public void a(fw fwVar) {
        this.f494a.add(fwVar);
    }

    public void a(gd gdVar) {
        this.f493a = gdVar;
    }

    public synchronized Collection<String> b() {
        if (this.f495a == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet(this.f495a.keySet()));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fz fzVar = (fz) obj;
        gd gdVar = this.f493a;
        if (gdVar == null ? fzVar.f493a != null : !gdVar.equals(fzVar.f493a)) {
            return false;
        }
        String str = this.g;
        if (str == null ? fzVar.g != null : !str.equals(fzVar.g)) {
            return false;
        }
        if (!this.f494a.equals(fzVar.f494a)) {
            return false;
        }
        String str2 = this.e;
        if (str2 == null ? fzVar.e != null : !str2.equals(fzVar.e)) {
            return false;
        }
        String str3 = this.h;
        if (str3 == null ? fzVar.h != null : !str3.equals(fzVar.h)) {
            return false;
        }
        Map<String, Object> map = this.f495a;
        if (map == null ? fzVar.f495a != null : !map.equals(fzVar.f495a)) {
            return false;
        }
        String str4 = this.f;
        if (str4 == null ? fzVar.f != null : !str4.equals(fzVar.f)) {
            return false;
        }
        String str5 = this.d;
        String str6 = fzVar.d;
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
        String str = this.d;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.e;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.g;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.h;
        int hashCode5 = (((((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + this.f494a.hashCode()) * 31) + this.f495a.hashCode()) * 31;
        gd gdVar = this.f493a;
        if (gdVar != null) {
            i2 = gdVar.hashCode();
        }
        return hashCode5 + i2;
    }

    public String j() {
        if ("ID_NOT_AVAILABLE".equals(this.e)) {
            return null;
        }
        if (this.e == null) {
            this.e = i();
        }
        return this.e;
    }

    public String k() {
        return this.h;
    }

    public void k(String str) {
        this.e = str;
    }

    public String l() {
        return this.f;
    }

    public void l(String str) {
        this.h = str;
    }

    public String m() {
        return this.g;
    }

    public void m(String str) {
        this.f = str;
    }

    public String n() {
        return this.i;
    }

    public void n(String str) {
        this.g = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0105 A[SYNTHETIC, Splitter:B:56:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0118 A[SYNTHETIC, Splitter:B:65:0x0118] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011f A[SYNTHETIC, Splitter:B:69:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x010d A[SYNTHETIC] */
    protected synchronized String o() {
        StringBuilder sb;
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        ObjectOutputStream objectOutputStream;
        Exception e2;
        Exception e3;
        String str;
        sb = new StringBuilder();
        for (fw fwVar : m353a()) {
            sb.append(fwVar.d());
        }
        Map<String, Object> map = this.f495a;
        if (map != null && !map.isEmpty()) {
            sb.append("<properties xmlns=\"http://www.jivesoftware.com/xmlns/xmpp/properties\">");
            for (String str2 : b()) {
                Object a2 = m351a(str2);
                sb.append("<property>");
                sb.append("<name>");
                sb.append(gk.a(str2));
                sb.append("</name>");
                sb.append("<value type=\"");
                if (a2 instanceof Integer) {
                    sb.append("integer\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Long) {
                    sb.append("long\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Float) {
                    sb.append("float\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Double) {
                    sb.append("double\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof Boolean) {
                    sb.append("boolean\">");
                    sb.append(a2);
                    str = "</value>";
                } else if (a2 instanceof String) {
                    sb.append("string\">");
                    sb.append(gk.a((String) a2));
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
                            objectOutputStream.writeObject(a2);
                            sb.append("java-object\">");
                            sb.append(gk.a(byteArrayOutputStream.toByteArray()));
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

    public void o(String str) {
        this.i = str;
    }

    public String p() {
        return this.d;
    }
}
