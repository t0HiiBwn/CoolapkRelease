package com.ali.auth.third.core.registry.a;

import com.ali.auth.third.core.registry.ServiceRegistration;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class a implements com.ali.auth.third.core.registry.a {
    private Map<Class<?>, List<b>> a = new HashMap();
    private Map<ServiceRegistration, b> b = new HashMap();
    private ReadWriteLock c = new ReentrantReadWriteLock();

    /* renamed from: com.ali.auth.third.core.registry.a.a$a  reason: collision with other inner class name */
    static class C0007a implements ServiceRegistration {
        private final String a = UUID.randomUUID().toString();
        private com.ali.auth.third.core.registry.a b;
        private Map<String, String> c;

        public C0007a(com.ali.auth.third.core.registry.a aVar, Map<String, String> map) {
            this.b = aVar;
            this.c = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.a.equals(((C0007a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            String str = this.a;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        @Override // com.ali.auth.third.core.registry.ServiceRegistration
        public void setProperties(Map<String, String> map) {
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!(entry.getKey() == null || entry.getValue() == null)) {
                        this.c.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        }

        @Override // com.ali.auth.third.core.registry.ServiceRegistration
        public void unregister() {
            this.b.a(this);
        }
    }

    static class b {
        public Class<?>[] a;
        public Object b;
        public Map<String, String> c;

        b() {
        }
    }

    @Override // com.ali.auth.third.core.registry.a
    public ServiceRegistration a(Class<?>[] clsArr, Object obj, Map<String, String> map) {
        if (clsArr == null || clsArr.length == 0 || obj == null) {
            throw new IllegalArgumentException("service types and instance must not be null");
        }
        b bVar = new b();
        bVar.b = obj;
        bVar.a = clsArr;
        bVar.c = Collections.synchronizedMap(new HashMap());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (!(entry.getKey() == null || entry.getValue() == null)) {
                    bVar.c.put(entry.getKey(), entry.getValue());
                }
            }
        }
        this.c.writeLock().lock();
        try {
            for (Class<?> cls : clsArr) {
                List<b> list = this.a.get(cls);
                if (list == null) {
                    list = new ArrayList<>(2);
                    this.a.put(cls, list);
                }
                list.add(bVar);
            }
            C0007a aVar = new C0007a(this, bVar.c);
            this.b.put(aVar, bVar);
            return aVar;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    @Override // com.ali.auth.third.core.registry.a
    public Object a(ServiceRegistration serviceRegistration) {
        if (serviceRegistration == null) {
            return null;
        }
        this.c.writeLock().lock();
        try {
            b remove = this.b.remove(serviceRegistration);
            if (remove == null) {
                return null;
            }
            if (remove.a != null) {
                Class<?>[] clsArr = remove.a;
                for (Class<?> cls : clsArr) {
                    List<b> list = this.a.get(cls);
                    Iterator<b> it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next() == remove) {
                                it2.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    if (list.size() == 0) {
                        this.a.remove(cls);
                    }
                }
            }
            Object obj = remove.b;
            this.c.writeLock().unlock();
            return obj;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[Catch:{ all -> 0x0088 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0063 A[EDGE_INSN: B:37:0x0063->B:23:0x0063 ?: BREAK  , SYNTHETIC] */
    @Override // com.ali.auth.third.core.registry.a
    public <T> T a(Class<T> cls, Map<String, String> map) {
        List<b> list;
        Object obj;
        this.c.readLock().lock();
        try {
            list = this.a.get(cls);
            return null;
        } finally {
            this.c.readLock().unlock();
        }
        if (list != null) {
            if (list.size() != 0) {
                if (map != null) {
                    if (map.size() != 0) {
                        for (b bVar : list) {
                            boolean z = true;
                            Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Map.Entry<String, String> next = it2.next();
                                    String str = bVar.c.get(next.getKey());
                                    if (str == null || !str.equals(next.getValue())) {
                                        break;
                                    }
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                }
                            }
                            z = false;
                            continue;
                            if (z) {
                                obj = bVar.b;
                                T cast = cls.cast(obj);
                                this.c.readLock().unlock();
                                return cast;
                            }
                        }
                    }
                }
                obj = list.get(0).b;
                T cast = cls.cast(obj);
                this.c.readLock().unlock();
                return cast;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[Catch:{ all -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x006c A[SYNTHETIC] */
    @Override // com.ali.auth.third.core.registry.a
    public <T> T[] b(Class<T> cls, Map<String, String> map) {
        List<b> list;
        int i;
        T[] tArr;
        boolean z;
        this.c.readLock().lock();
        try {
            list = this.a.get(cls);
            tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
            return tArr;
        } finally {
            this.c.readLock().unlock();
        }
        if (list != null) {
            if (list.size() != 0) {
                if (map != null) {
                    if (map.size() != 0) {
                        ArrayList arrayList = new ArrayList(list.size());
                        for (b bVar : list) {
                            Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    Map.Entry<String, String> next = it2.next();
                                    String str = bVar.c.get(next.getKey());
                                    if (str == null || !str.equals(next.getValue())) {
                                        break;
                                    }
                                    if (!it2.hasNext()) {
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                                arrayList.add(cls.cast(bVar.b));
                            }
                        }
                        tArr = (T[]) arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, arrayList.size()));
                        return tArr;
                    }
                }
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, list.size()));
                int size = list.size();
                for (i = 0; i < size; i++) {
                    tArr2[i] = cls.cast(list.get(i).b);
                }
                this.c.readLock().unlock();
                return tArr2;
            }
        }
    }
}
