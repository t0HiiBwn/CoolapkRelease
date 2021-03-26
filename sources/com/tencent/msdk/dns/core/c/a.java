package com.tencent.msdk.dns.core.c;

import com.tencent.msdk.dns.base.e.c;
import com.tencent.msdk.dns.base.log.b;
import com.tencent.msdk.dns.core.IpSet;
import com.tencent.msdk.dns.core.f;
import com.tencent.msdk.dns.core.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: Sorter */
public final class a implements i {
    private final int a;
    private String b;
    private String c;
    private List<String> d;
    private List<String> e;

    private a(int i) {
        this.b = null;
        this.c = null;
        this.d = Collections.emptyList();
        this.e = Collections.emptyList();
        this.a = i;
    }

    @Override // com.tencent.msdk.dns.core.i
    public synchronized void a(f fVar, String[] strArr) {
        if (fVar == null) {
            throw new IllegalArgumentException("dns".concat(" can not be null"));
        } else if (strArr == null) {
            throw new IllegalArgumentException("ips".concat(" can not be null"));
        } else if (!com.tencent.msdk.dns.base.e.a.a((Object[]) strArr)) {
            int i = 0;
            if ("Local".equals(fVar.a().a)) {
                b.b("sorter put lookup from local: %s", Arrays.toString(strArr));
                int length = strArr.length;
                while (i < length) {
                    String str = strArr[i];
                    if (this.b == null && c.a(str)) {
                        this.b = str;
                    } else if (this.c == null && c.b(str)) {
                        this.c = str;
                    }
                    i++;
                }
            } else {
                b.b("sorter put lookup from rest(%d): %s", Integer.valueOf(fVar.a().b), Arrays.toString(strArr));
                int length2 = strArr.length;
                while (i < length2) {
                    String str2 = strArr[i];
                    if (c.a(str2)) {
                        this.d = a(this.d, str2);
                    } else if (c.b(str2)) {
                        this.e = a(this.e, str2);
                    }
                    i++;
                }
            }
        }
    }

    @Override // com.tencent.msdk.dns.core.i
    public IpSet a() {
        Set b2 = com.tencent.msdk.dns.base.a.a.b();
        if ((this.a & 1) != 0) {
            if (!this.d.isEmpty()) {
                b2.addAll(this.d);
            } else {
                String str = this.b;
                if (str != null) {
                    b2.add(str);
                }
            }
        }
        Set b3 = com.tencent.msdk.dns.base.a.a.b();
        if ((this.a & 2) != 0) {
            if (!this.e.isEmpty()) {
                b3.addAll(this.e);
            } else {
                String str2 = this.c;
                if (str2 != null) {
                    b3.add(str2);
                }
            }
        }
        return new IpSet((String[]) b2.toArray(com.tencent.msdk.dns.core.a.a), (String[]) b3.toArray(com.tencent.msdk.dns.core.a.a));
    }

    private List<String> a(List<String> list, String str) {
        if (Collections.emptyList() == list) {
            list = new ArrayList<>();
        }
        list.add(str);
        return list;
    }

    /* renamed from: com.tencent.msdk.dns.core.c.a$a  reason: collision with other inner class name */
    /* compiled from: Sorter */
    public static class C0149a implements i.a {
        @Override // com.tencent.msdk.dns.core.i.a
        public i a(int i) {
            return new a(i);
        }
    }
}
