package com.bytedance.sdk.openadsdk.preload.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* compiled from: LinkedTreeMap */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean f = true;
    private static final Comparator<Comparable> g = new Comparator<Comparable>() {
        /* class com.bytedance.sdk.openadsdk.preload.a.b.h.AnonymousClass1 */

        /* renamed from: a */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> a;
    d<K, V> b;
    int c;
    int d;
    final d<K, V> e;
    private h<K, V>.a h;
    private h<K, V>.b i;

    public h() {
        this(g);
    }

    public h(Comparator<? super K> comparator) {
        this.c = 0;
        this.d = 0;
        this.e = new d<>();
        this.a = comparator == null ? g : comparator;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        d<K, V> a2 = a((h<K, V>) k, true);
        V v2 = a2.g;
        a2.g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.b = null;
        this.c = 0;
        this.d++;
        d<K, V> dVar = this.e;
        dVar.e = dVar;
        dVar.d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.g;
        }
        return null;
    }

    d<K, V> a(K k, boolean z) {
        int i2;
        d<K, V> dVar;
        d<K, V> dVar2;
        Comparator<? super K> comparator = this.a;
        d<K, V> dVar3 = this.b;
        if (dVar3 != null) {
            K k2 = comparator == g ? k : null;
            while (true) {
                if (k2 != null) {
                    i2 = k2.compareTo(dVar3.f);
                } else {
                    i2 = comparator.compare(k, dVar3.f);
                }
                if (i2 == 0) {
                    return dVar3;
                }
                if (i2 < 0) {
                    dVar2 = dVar3.b;
                } else {
                    dVar2 = dVar3.c;
                }
                if (dVar2 == null) {
                    break;
                }
                dVar3 = dVar2;
            }
        } else {
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.e;
        if (dVar3 != null) {
            dVar = new d<>(dVar3, k, dVar4, dVar4.e);
            if (i2 < 0) {
                dVar3.b = dVar;
            } else {
                dVar3.c = dVar;
            }
            b(dVar3, true);
        } else if (comparator != g || (k instanceof Comparable)) {
            dVar = new d<>(dVar3, k, dVar4, dVar4.e);
            this.b = dVar;
        } else {
            throw new ClassCastException(k.getClass().getName() + " is not Comparable");
        }
        this.c++;
        this.d++;
        return dVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    d<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a((h<K, V>) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> a2 = a(entry.getKey());
        if (a2 != null && a(a2.g, entry.getValue())) {
            return a2;
        }
        return null;
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void a(d<K, V> dVar, boolean z) {
        int i2;
        if (z) {
            dVar.e.d = dVar.d;
            dVar.d.e = dVar.e;
        }
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar.a;
        int i3 = 0;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                a((d) dVar, (d) dVar2);
                dVar.b = null;
            } else if (dVar3 != null) {
                a((d) dVar, (d) dVar3);
                dVar.c = null;
            } else {
                a((d) dVar, (d) null);
            }
            b(dVar4, false);
            this.c--;
            this.d++;
            return;
        }
        d<K, V> b2 = dVar2.h > dVar3.h ? dVar2.b() : dVar3.a();
        a((d) b2, false);
        d<K, V> dVar5 = dVar.b;
        if (dVar5 != null) {
            i2 = dVar5.h;
            b2.b = dVar5;
            dVar5.a = b2;
            dVar.b = null;
        } else {
            i2 = 0;
        }
        d<K, V> dVar6 = dVar.c;
        if (dVar6 != null) {
            i3 = dVar6.h;
            b2.c = dVar6;
            dVar6.a = b2;
            dVar.c = null;
        }
        b2.h = Math.max(i2, i3) + 1;
        a((d) dVar, (d) b2);
    }

    d<K, V> b(Object obj) {
        d<K, V> a2 = a(obj);
        if (a2 != null) {
            a((d) a2, true);
        }
        return a2;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.a;
        dVar.a = null;
        if (dVar2 != null) {
            dVar2.a = dVar3;
        }
        if (dVar3 == null) {
            this.b = dVar2;
        } else if (dVar3.b == dVar) {
            dVar3.b = dVar2;
        } else if (f || dVar3.c == dVar) {
            dVar3.c = dVar2;
        } else {
            throw new AssertionError();
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        while (dVar != null) {
            d<K, V> dVar2 = dVar.b;
            d<K, V> dVar3 = dVar.c;
            int i2 = 0;
            int i3 = dVar2 != null ? dVar2.h : 0;
            int i4 = dVar3 != null ? dVar3.h : 0;
            int i5 = i3 - i4;
            if (i5 == -2) {
                d<K, V> dVar4 = dVar3.b;
                d<K, V> dVar5 = dVar3.c;
                int i6 = dVar5 != null ? dVar5.h : 0;
                if (dVar4 != null) {
                    i2 = dVar4.h;
                }
                int i7 = i2 - i6;
                if (i7 == -1 || (i7 == 0 && !z)) {
                    a((d) dVar);
                } else if (f || i7 == 1) {
                    b((d) dVar3);
                    a((d) dVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i5 == 2) {
                d<K, V> dVar6 = dVar2.b;
                d<K, V> dVar7 = dVar2.c;
                int i8 = dVar7 != null ? dVar7.h : 0;
                if (dVar6 != null) {
                    i2 = dVar6.h;
                }
                int i9 = i2 - i8;
                if (i9 == 1 || (i9 == 0 && !z)) {
                    b((d) dVar);
                } else if (f || i9 == -1) {
                    a((d) dVar2);
                    b((d) dVar);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i5 == 0) {
                dVar.h = i3 + 1;
                if (z) {
                    return;
                }
            } else if (f || i5 == -1 || i5 == 1) {
                dVar.h = Math.max(i3, i4) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            dVar = dVar.a;
        }
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar3.b;
        d<K, V> dVar5 = dVar3.c;
        dVar.c = dVar4;
        if (dVar4 != null) {
            dVar4.a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.b = dVar;
        dVar.a = dVar3;
        int i2 = 0;
        dVar.h = Math.max(dVar2 != null ? dVar2.h : 0, dVar4 != null ? dVar4.h : 0) + 1;
        int i3 = dVar.h;
        if (dVar5 != null) {
            i2 = dVar5.h;
        }
        dVar3.h = Math.max(i3, i2) + 1;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar2.b;
        d<K, V> dVar5 = dVar2.c;
        dVar.b = dVar5;
        if (dVar5 != null) {
            dVar5.a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.c = dVar;
        dVar.a = dVar2;
        int i2 = 0;
        dVar.h = Math.max(dVar3 != null ? dVar3.h : 0, dVar5 != null ? dVar5.h : 0) + 1;
        int i3 = dVar.h;
        if (dVar4 != null) {
            i2 = dVar4.h;
        }
        dVar2.h = Math.max(i3, i2) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.h;
        if (aVar != null) {
            return aVar;
        }
        h<K, V>.a aVar2 = new a();
        this.h = aVar2;
        return aVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.i;
        if (bVar != null) {
            return bVar;
        }
        h<K, V>.b bVar2 = new b();
        this.i = bVar2;
        return bVar2;
    }

    /* compiled from: LinkedTreeMap */
    static final class d<K, V> implements Map.Entry<K, V> {
        d<K, V> a;
        d<K, V> b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        V g;
        int h;

        d() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        d(d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.a = dVar;
            this.f = k;
            this.h = 1;
            this.d = dVar2;
            this.e = dVar3;
            dVar3.d = this;
            dVar2.e = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.g;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.g;
            this.g = v;
            return v2;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.g;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry, java.lang.Object
        public int hashCode() {
            K k = this.f;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.g;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        @Override // java.lang.Object
        public String toString() {
            return ((Object) this.f) + "=" + ((Object) this.g);
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.b; dVar2 != null; dVar2 = dVar2.b) {
                dVar = dVar2;
            }
            return dVar;
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            for (d<K, V> dVar2 = this.c; dVar2 != null; dVar2 = dVar2.c) {
                dVar = dVar2;
            }
            return dVar;
        }
    }

    /* compiled from: LinkedTreeMap */
    private abstract class c<T> implements Iterator<T> {
        d<K, V> b;
        d<K, V> c = null;
        int d;

        c() {
            this.b = h.this.e.d;
            this.d = h.this.d;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b != h.this.e;
        }

        final d<K, V> b() {
            d<K, V> dVar = this.b;
            if (dVar == h.this.e) {
                throw new NoSuchElementException();
            } else if (h.this.d == this.d) {
                this.b = dVar.d;
                this.c = dVar;
                return dVar;
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            d<K, V> dVar = this.c;
            if (dVar != null) {
                h.this.a((d) dVar, true);
                this.c = null;
                this.d = h.this.d;
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: LinkedTreeMap */
    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new h<K, V>.c() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.h.a.AnonymousClass1 */

                {
                    h hVar = h.this;
                }

                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    return b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.a((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            d<K, V> a2;
            if (!(obj instanceof Map.Entry) || (a2 = h.this.a((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.a((d) a2, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }
    }

    /* compiled from: LinkedTreeMap */
    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return new h<K, V>.c() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.h.b.AnonymousClass1 */

                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return b().f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }
    }
}
