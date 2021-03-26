package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class fw implements ga {
    private String a;

    /* renamed from: a  reason: collision with other field name */
    private List<fw> f485a = null;

    /* renamed from: a  reason: collision with other field name */
    private String[] f486a = null;
    private String b;

    /* renamed from: b  reason: collision with other field name */
    private String[] f487b = null;
    private String c;

    public fw(String str, String str2, String[] strArr, String[] strArr2) {
        this.a = str;
        this.b = str2;
        this.f486a = strArr;
        this.f487b = strArr2;
    }

    public fw(String str, String str2, String[] strArr, String[] strArr2, String str3, List<fw> list) {
        this.a = str;
        this.b = str2;
        this.f486a = strArr;
        this.f487b = strArr2;
        this.c = str3;
        this.f485a = list;
    }

    public static fw a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle("attributes");
        Set<String> keySet = bundle2.keySet();
        String[] strArr = new String[keySet.size()];
        String[] strArr2 = new String[keySet.size()];
        int i = 0;
        for (String str : keySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new fw(string, string2, strArr, strArr2, string3, arrayList);
    }

    public static Parcelable[] a(List<fw> list) {
        return a((fw[]) list.toArray(new fw[list.size()]));
    }

    public static Parcelable[] a(fw[] fwVarArr) {
        if (fwVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[fwVarArr.length];
        for (int i = 0; i < fwVarArr.length; i++) {
            parcelableArr[i] = fwVarArr[i].m346a();
        }
        return parcelableArr;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.a);
        bundle.putString("ext_ns", this.b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f486a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f486a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f487b[i]);
                i++;
            }
        }
        bundle.putBundle("attributes", bundle2);
        List<fw> list = this.f485a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f485a));
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Parcelable m346a() {
        return a();
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m347a() {
        return this.a;
    }

    public String a(String str) {
        if (str == null) {
            throw new IllegalArgumentException();
        } else if (this.f486a == null) {
            return null;
        } else {
            int i = 0;
            while (true) {
                String[] strArr = this.f486a;
                if (i >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i])) {
                    return this.f487b[i];
                }
                i++;
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m348a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = gk.a(str);
        }
        this.c = str;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? gk.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.ga
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.a);
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.b);
            sb.append("\"");
        }
        String[] strArr = this.f486a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f486a.length; i++) {
                if (!TextUtils.isEmpty(this.f487b[i])) {
                    sb.append(" ");
                    sb.append(this.f486a[i]);
                    sb.append("=\"");
                    sb.append(gk.a(this.f487b[i]));
                    sb.append("\"");
                }
            }
        }
        if (!TextUtils.isEmpty(this.c)) {
            sb.append(">");
            sb.append(this.c);
        } else {
            List<fw> list = this.f485a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
                return sb.toString();
            }
            sb.append(">");
            for (fw fwVar : this.f485a) {
                sb.append(fwVar.d());
            }
        }
        sb.append("</");
        sb.append(this.a);
        sb.append(">");
        return sb.toString();
    }

    public String toString() {
        return d();
    }
}
