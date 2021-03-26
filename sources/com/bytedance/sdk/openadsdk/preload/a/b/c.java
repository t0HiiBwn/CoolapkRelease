package com.bytedance.sdk.openadsdk.preload.a.b;

import com.bytedance.sdk.openadsdk.preload.a.b.b.b;
import com.bytedance.sdk.openadsdk.preload.a.c.a;
import com.bytedance.sdk.openadsdk.preload.a.h;
import com.bytedance.sdk.openadsdk.preload.a.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor */
public final class c {
    private final Map<Type, h<?>> a;
    private final b b = b.a();

    public c(Map<Type, h<?>> map) {
        this.a = map;
    }

    public <T> i<T> a(a<T> aVar) {
        final Type b2 = aVar.b();
        Class<? super T> a2 = aVar.a();
        final h<?> hVar = this.a.get(b2);
        if (hVar != null) {
            return new i<T>() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass1 */

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return (T) hVar.a(b2);
                }
            };
        }
        final h<?> hVar2 = this.a.get(a2);
        if (hVar2 != null) {
            return new i<T>() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass7 */

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return (T) hVar2.a(b2);
                }
            };
        }
        i<T> a3 = a(a2);
        if (a3 != null) {
            return a3;
        }
        i<T> a4 = a(b2, a2);
        if (a4 != null) {
            return a4;
        }
        return b(b2, a2);
    }

    private <T> i<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.b.a(declaredConstructor);
            }
            return new i<T>() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass8 */

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (InstantiationException e) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> i<T> a(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass9 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return (T) new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass10 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        Type type = type;
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return (T) EnumSet.noneOf((Class) type2);
                            }
                            throw new m("Invalid EnumSet type: " + type.toString());
                        }
                        throw new m("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass11 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return (T) new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass12 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return (T) new ArrayDeque();
                    }
                };
            }
            return new i<T>() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass13 */

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return (T) new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            return null;
        } else {
            if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass14 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return (T) new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass2 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return (T) new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(cls)) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass3 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return (T) new TreeMap();
                    }
                };
            }
            if (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.a(((ParameterizedType) type).getActualTypeArguments()[0]).a())) {
                return new i<T>() {
                    /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass5 */

                    @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                    public T a() {
                        return (T) new h();
                    }
                };
            }
            return new i<T>() {
                /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass4 */

                @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
                public T a() {
                    return (T) new LinkedHashMap();
                }
            };
        }
    }

    private <T> i<T> b(final Type type, final Class<? super T> cls) {
        return new i<T>() {
            /* class com.bytedance.sdk.openadsdk.preload.a.b.c.AnonymousClass6 */
            private final m d = m.a();

            @Override // com.bytedance.sdk.openadsdk.preload.a.b.i
            public T a() {
                try {
                    return (T) this.d.a(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }

    public String toString() {
        return this.a.toString();
    }
}
