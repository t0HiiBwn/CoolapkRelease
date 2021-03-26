package com.bytedance.sdk.openadsdk.i;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: Urls */
public class l {
    private static final Set<String> a = new HashSet();
    private static final Set<String> b = new HashSet();
    private final ArrayList<a> c;
    private final int d;
    private int e = -1;
    private int f;
    private final int g;

    l(List<String> list) {
        int i;
        if (!list.isEmpty()) {
            int size = list.size();
            this.d = size;
            this.c = new ArrayList<>(size);
            ArrayList arrayList = null;
            ArrayList arrayList2 = null;
            for (String str : list) {
                a aVar = new a(str);
                if (a.contains(str)) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    arrayList2.add(aVar);
                } else if (b.contains(str)) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    arrayList.add(aVar);
                } else {
                    this.c.add(aVar);
                }
            }
            if (arrayList != null) {
                this.c.addAll(arrayList);
            }
            if (arrayList2 != null) {
                this.c.addAll(arrayList2);
            }
            Integer num = e.i;
            if (num == null || num.intValue() <= 0) {
                i = this.d >= 2 ? 1 : 2;
            } else {
                i = num.intValue();
            }
            this.g = i;
            return;
        }
        throw new IllegalArgumentException("urls can't be empty");
    }

    l(String str) {
        ArrayList<a> arrayList = new ArrayList<>(1);
        this.c = arrayList;
        arrayList.add(new a(str));
        this.d = 1;
        this.g = 1;
    }

    boolean a() {
        return this.f < this.g;
    }

    a b() {
        if (a()) {
            int i = this.e + 1;
            if (i >= this.d - 1) {
                this.e = -1;
                this.f++;
            } else {
                this.e = i;
            }
            a aVar = this.c.get(i);
            aVar.b = (this.f * this.d) + this.e;
            return aVar;
        }
        throw new NoSuchElementException();
    }

    /* compiled from: Urls */
    public class a {
        final String a;
        int b;

        a(String str) {
            this.a = str;
        }

        void a() {
            l.a.add(this.a);
        }

        void b() {
            l.b.add(this.a);
        }

        public String toString() {
            return this.a;
        }
    }
}
