package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: KeyArraySorter */
public class g {
    private static g a = new g();

    /* renamed from: a  reason: collision with other field name */
    private a f61a = new a();

    /* renamed from: a  reason: collision with other field name */
    private b f62a = new b();

    private g() {
    }

    public static g a() {
        return a;
    }

    public String[] a(String[] strArr, boolean z) {
        Comparator comparator;
        if (z) {
            comparator = this.f61a;
        } else {
            comparator = this.f62a;
        }
        if (comparator == null || strArr == null || strArr.length <= 0) {
            return null;
        }
        Arrays.sort(strArr, comparator);
        return strArr;
    }

    /* compiled from: KeyArraySorter */
    private class b implements Comparator<String> {
        private b() {
        }

        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2) * -1;
        }
    }

    /* compiled from: KeyArraySorter */
    private class a implements Comparator<String> {
        private a() {
        }

        public int compare(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return 0;
            }
            return str.compareTo(str2);
        }
    }
}
