package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class i {
    private ByteBuffer a;
    private String b = "GBK";

    /* compiled from: BUGLY */
    public static class a {
        public byte a;
        public int b;
    }

    public i() {
    }

    public i(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    public i(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.a = wrap;
        wrap.position(4);
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.a = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.a = (byte) (b2 & 15);
        aVar.b = (b2 & 240) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
        return 2;
    }

    private boolean a(int i) {
        try {
            a aVar = new a();
            while (true) {
                int a2 = a(aVar, this.a.duplicate());
                if (i <= aVar.b) {
                    break;
                } else if (aVar.a == 11) {
                    break;
                } else {
                    ByteBuffer byteBuffer = this.a;
                    byteBuffer.position(byteBuffer.position() + a2);
                    a(aVar.a);
                }
            }
            if (i == aVar.b) {
                return true;
            }
            return false;
        } catch (g | BufferUnderflowException unused) {
        }
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar, this.a);
            a(aVar.a);
        } while (aVar.a != 11);
    }

    private void a(byte b2) {
        int i = 0;
        switch (b2) {
            case 0:
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i2 = this.a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                ByteBuffer byteBuffer7 = this.a;
                byteBuffer7.position(byteBuffer7.position() + i2);
                return;
            case 7:
                int i3 = this.a.getInt();
                ByteBuffer byteBuffer8 = this.a;
                byteBuffer8.position(byteBuffer8.position() + i3);
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i < (a2 << 1)) {
                    a aVar = new a();
                    a(aVar, this.a);
                    a(aVar.a);
                    i++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i < a3) {
                    a aVar2 = new a();
                    a(aVar2, this.a);
                    a(aVar2.a);
                    i++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar3 = new a();
                a(aVar3, this.a);
                if (aVar3.a == 0) {
                    int a4 = a(0, 0, true);
                    ByteBuffer byteBuffer9 = this.a;
                    byteBuffer9.position(byteBuffer9.position() + a4);
                    return;
                }
                throw new g("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) aVar3.a));
            default:
                throw new g("invalid type.");
        }
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final byte a(byte b2, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b3 = aVar.a;
            if (b3 == 0) {
                return this.a.get();
            }
            if (b3 == 12) {
                return 0;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return b2;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final short a(short s, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b2 = aVar.a;
            if (b2 == 0) {
                return (short) this.a.get();
            }
            if (b2 == 1) {
                return this.a.getShort();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return s;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final int a(int i, int i2, boolean z) {
        if (a(i2)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b2 = aVar.a;
            if (b2 == 0) {
                return this.a.get();
            }
            if (b2 == 1) {
                return this.a.getShort();
            }
            if (b2 == 2) {
                return this.a.getInt();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return i;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final long a(long j, int i, boolean z) {
        int i2;
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b2 = aVar.a;
            if (b2 == 0) {
                i2 = this.a.get();
            } else if (b2 == 1) {
                i2 = this.a.getShort();
            } else if (b2 == 2) {
                i2 = this.a.getInt();
            } else if (b2 == 3) {
                return this.a.getLong();
            } else {
                if (b2 == 12) {
                    return 0;
                }
                throw new g("type mismatch.");
            }
            return (long) i2;
        } else if (!z) {
            return j;
        } else {
            throw new g("require field not exist.");
        }
    }

    private float a(float f, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b2 = aVar.a;
            if (b2 == 4) {
                return this.a.getFloat();
            }
            if (b2 == 12) {
                return 0.0f;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new g("require field not exist.");
        }
    }

    private double a(double d, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b2 = aVar.a;
            if (b2 == 4) {
                return (double) this.a.getFloat();
            }
            if (b2 == 5) {
                return this.a.getDouble();
            }
            if (b2 == 12) {
                return 0.0d;
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return d;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final String b(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b2 = aVar.a;
            if (b2 == 6) {
                int i2 = this.a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.a.get(bArr);
                try {
                    return new String(bArr, this.b);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            } else if (b2 == 7) {
                int i3 = this.a.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new g("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.a.get(bArr2);
                try {
                    return new String(bArr2, this.b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            } else {
                throw new g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.Map<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 8) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    for (int i2 = 0; i2 < a2; i2++) {
                        map.put(a((i) key, 0, true), a((i) value, 1, true));
                    }
                } else {
                    throw new g("size invalid: " + a2);
                }
            } else {
                throw new g("type mismatch.");
            }
        } else if (z) {
            throw new g("require field not exist.");
        }
        return map;
    }

    private boolean[] d(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    boolean[] zArr = new boolean[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        zArr[i2] = a((byte) 0, 0, true) != 0;
                    }
                    return zArr;
                }
                throw new g("size invalid: " + a2);
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final byte[] c(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            byte b2 = aVar.a;
            if (b2 == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    byte[] bArr = new byte[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        bArr[i2] = a(bArr[0], 0, true);
                    }
                    return bArr;
                }
                throw new g("size invalid: " + a2);
            } else if (b2 == 13) {
                a aVar2 = new a();
                a(aVar2, this.a);
                if (aVar2.a == 0) {
                    int a3 = a(0, 0, true);
                    if (a3 >= 0) {
                        byte[] bArr2 = new byte[a3];
                        this.a.get(bArr2);
                        return bArr2;
                    }
                    throw new g("invalid size, tag: " + i + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a) + ", size: " + a3);
                }
                throw new g("type mismatch, tag: " + i + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a));
            } else {
                throw new g("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private short[] e(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    short[] sArr = new short[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        sArr[i2] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new g("size invalid: " + a2);
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private int[] f(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    int[] iArr = new int[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        iArr[i2] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new g("size invalid: " + a2);
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private long[] g(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    long[] jArr = new long[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        jArr[i2] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new g("size invalid: " + a2);
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private float[] h(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    float[] fArr = new float[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        fArr[i2] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new g("size invalid: " + a2);
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private double[] i(int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    double[] dArr = new double[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        dArr[i2] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new g("size invalid: " + a2);
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    private <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i, z);
        }
        throw new g("unable to get type of key and value.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i, boolean z) {
        if (a(i)) {
            a aVar = new a();
            a(aVar, this.a);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
                    for (int i2 = 0; i2 < a2; i2++) {
                        tArr[i2] = a((i) t, 0, true);
                    }
                    return tArr;
                }
                throw new g("size invalid: " + a2);
            }
            throw new g("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    public final k a(k kVar, int i, boolean z) {
        if (a(i)) {
            try {
                k kVar2 = (k) kVar.getClass().newInstance();
                a aVar = new a();
                a(aVar, this.a);
                if (aVar.a == 10) {
                    kVar2.a(this);
                    a();
                    return kVar2;
                }
                throw new g("type mismatch.");
            } catch (Exception e) {
                throw new g(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new g("require field not exist.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.bugly.proguard.i */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i, boolean z) {
        boolean z2 = false;
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            if (a((byte) 0, i, z) != 0) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        } else if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        } else {
            if (t instanceof Integer) {
                return Integer.valueOf(a(0, i, z));
            }
            if (t instanceof Long) {
                return Long.valueOf(a(0L, i, z));
            }
            if (t instanceof Float) {
                return Float.valueOf(a(0.0f, i, z));
            }
            if (t instanceof Double) {
                return Double.valueOf(a(0.0d, i, z));
            }
            if (t instanceof String) {
                return String.valueOf(b(i, z));
            }
            if (t instanceof Map) {
                return (HashMap) a(new HashMap(), t, i, z);
            } else if (t instanceof List) {
                T t2 = t;
                if (t2 == null || t2.isEmpty()) {
                    return new ArrayList();
                }
                Object[] b2 = b(t2.get(0), i, z);
                if (b2 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (Object obj : b2) {
                    arrayList.add(obj);
                }
                return arrayList;
            } else if (t instanceof k) {
                return a((k) t, i, z);
            } else {
                if (!t.getClass().isArray()) {
                    throw new g("read object error: unsupport type.");
                } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
                    return c(i, z);
                } else {
                    if (t instanceof boolean[]) {
                        return d(i, z);
                    }
                    if (t instanceof short[]) {
                        return e(i, z);
                    }
                    if (t instanceof int[]) {
                        return f(i, z);
                    }
                    if (t instanceof long[]) {
                        return g(i, z);
                    }
                    if (t instanceof float[]) {
                        return h(i, z);
                    }
                    if (t instanceof double[]) {
                        return i(i, z);
                    }
                    return a((Object[]) t, i, z);
                }
            }
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
