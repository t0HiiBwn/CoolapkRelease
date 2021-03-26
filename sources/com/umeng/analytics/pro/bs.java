package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bs;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: TUnion */
public abstract class bs<T extends bs<?, ?>, F extends bp> implements bi<T, F> {
    private static final Map<Class<? extends cp>, cq> c;
    protected Object a;
    protected F b;

    protected abstract F a(short s);

    protected abstract Object a(ch chVar, cc ccVar) throws bo;

    protected abstract Object a(ch chVar, short s) throws bo;

    protected abstract void a(ch chVar) throws bo;

    protected abstract void b(F f, Object obj) throws ClassCastException;

    protected abstract void b(ch chVar) throws bo;

    protected abstract cc c(F f);

    protected abstract cm d();

    protected bs() {
        this.b = null;
        this.a = null;
    }

    static {
        HashMap hashMap = new HashMap();
        c = hashMap;
        hashMap.put(cr.class, new b());
        hashMap.put(cs.class, new d());
    }

    protected bs(F f, Object obj) {
        a((bs<T, F>) f, obj);
    }

    protected bs(bs<T, F> bsVar) {
        if (bsVar.getClass().equals(getClass())) {
            this.b = bsVar.b;
            this.a = a(bsVar.a);
            return;
        }
        throw new ClassCastException();
    }

    private static Object a(Object obj) {
        if (obj instanceof bi) {
            return ((bi) obj).deepCopy();
        }
        if (obj instanceof ByteBuffer) {
            return bj.d((ByteBuffer) obj);
        }
        if (obj instanceof List) {
            return a((List) obj);
        }
        if (obj instanceof Set) {
            return a((Set) obj);
        }
        return obj instanceof Map ? a((Map<Object, Object>) ((Map) obj)) : obj;
    }

    private static Map a(Map<Object, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            hashMap.put(a(entry.getKey()), a(entry.getValue()));
        }
        return hashMap;
    }

    private static Set a(Set set) {
        HashSet hashSet = new HashSet();
        for (Object obj : set) {
            hashSet.add(a(obj));
        }
        return hashSet;
    }

    private static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (Object obj : list) {
            arrayList.add(a(obj));
        }
        return arrayList;
    }

    public F a() {
        return this.b;
    }

    public Object b() {
        return this.a;
    }

    public Object a(F f) {
        if (f == this.b) {
            return b();
        }
        throw new IllegalArgumentException("Cannot get the value of field " + f + " because union's set field is " + this.b);
    }

    public Object a(int i) {
        return a((bs<T, F>) a((short) i));
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean b(F f) {
        return this.b == f;
    }

    public boolean b(int i) {
        return b((bs<T, F>) a((short) i));
    }

    @Override // com.umeng.analytics.pro.bi
    public void read(ch chVar) throws bo {
        c.get(chVar.D()).b().b(chVar, this);
    }

    public void a(F f, Object obj) {
        b(f, obj);
        this.b = f;
        this.a = obj;
    }

    public void a(int i, Object obj) {
        a((bs<T, F>) a((short) i), obj);
    }

    @Override // com.umeng.analytics.pro.bi
    public void write(ch chVar) throws bo {
        c.get(chVar.D()).b().a(chVar, this);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (a() != null) {
            Object b2 = b();
            sb.append(c(a()).a);
            sb.append(":");
            if (b2 instanceof ByteBuffer) {
                bj.a((ByteBuffer) b2, sb);
            } else {
                sb.append(b2.toString());
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.bi
    public final void clear() {
        this.b = null;
        this.a = null;
    }

    /* compiled from: TUnion */
    private static class b implements cq {
        private b() {
        }

        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* compiled from: TUnion */
    private static class a extends cr<bs> {
        private a() {
        }

        /* renamed from: a */
        public void b(ch chVar, bs bsVar) throws bo {
            bsVar.b = null;
            bsVar.a = null;
            chVar.j();
            cc l2 = chVar.l();
            bsVar.a = bsVar.a(chVar, l2);
            if (bsVar.a != null) {
                bsVar.b = (F) bsVar.a(l2.c);
            }
            chVar.m();
            chVar.l();
            chVar.k();
        }

        /* renamed from: b */
        public void a(ch chVar, bs bsVar) throws bo {
            if (bsVar.a() == null || bsVar.b() == null) {
                throw new ci("Cannot write a TUnion with no set value!");
            }
            chVar.a(bsVar.d());
            chVar.a(bsVar.c(bsVar.b));
            bsVar.a(chVar);
            chVar.c();
            chVar.d();
            chVar.b();
        }
    }

    /* compiled from: TUnion */
    private static class d implements cq {
        private d() {
        }

        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* compiled from: TUnion */
    private static class c extends cs<bs> {
        private c() {
        }

        /* renamed from: a */
        public void b(ch chVar, bs bsVar) throws bo {
            bsVar.b = null;
            bsVar.a = null;
            short v = chVar.v();
            bsVar.a = bsVar.a(chVar, v);
            if (bsVar.a != null) {
                bsVar.b = (F) bsVar.a(v);
            }
        }

        /* renamed from: b */
        public void a(ch chVar, bs bsVar) throws bo {
            if (bsVar.a() == null || bsVar.b() == null) {
                throw new ci("Cannot write a TUnion with no set value!");
            }
            chVar.a(bsVar.b.a());
            bsVar.b(chVar);
        }
    }
}
