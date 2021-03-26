package com.tencent.beacon.core.wup;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: JceInputStream */
public final class a {
    private ByteBuffer a;
    private String b = "GBK";

    /* renamed from: com.tencent.beacon.core.wup.a$a  reason: collision with other inner class name */
    /* compiled from: JceInputStream */
    public static class C0142a {
        public byte a;
        public int b;
    }

    public a() {
    }

    public a(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    public a(byte[] bArr, byte b2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.a = wrap;
        wrap.position(4);
    }

    public final void a(byte[] bArr) {
        this.a = ByteBuffer.wrap(bArr);
    }

    private static int a(C0142a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.a = (byte) (b2 & 15);
        aVar.b = (b2 & 240) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get() & 255;
        return 2;
    }

    private void a(C0142a aVar) {
        a(aVar, this.a);
    }

    private void a(int i) {
        ByteBuffer byteBuffer = this.a;
        byteBuffer.position(byteBuffer.position() + i);
    }

    private boolean b(int i) {
        try {
            C0142a aVar = new C0142a();
            while (true) {
                int a2 = a(aVar, this.a.duplicate());
                if (aVar.a == 11) {
                    return false;
                }
                if (i > aVar.b) {
                    a(a2);
                    a(aVar.a);
                } else if (i == aVar.b) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (RuntimeException | BufferUnderflowException unused) {
            return false;
        }
    }

    private void a() {
        C0142a aVar = new C0142a();
        do {
            a(aVar);
            a(aVar.a);
        } while (aVar.a != 11);
    }

    private void b() {
        C0142a aVar = new C0142a();
        a(aVar);
        a(aVar.a);
    }

    private void a(byte b2) {
        int i = 0;
        switch (b2) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i2 = this.a.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                a(i2);
                return;
            case 7:
                a(this.a.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i < (a2 << 1)) {
                    b();
                    i++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i < a3) {
                    b();
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
                C0142a aVar = new C0142a();
                a(aVar);
                if (aVar.a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new RuntimeException("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) aVar.a));
            default:
                throw new RuntimeException("invalid type.");
        }
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final byte a(byte b2, int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            byte b3 = aVar.a;
            if (b3 == 0) {
                return this.a.get();
            }
            if (b3 == 12) {
                return 0;
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return b2;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final short a(short s, int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
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
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return s;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final int a(int i, int i2, boolean z) {
        if (b(i2)) {
            C0142a aVar = new C0142a();
            a(aVar);
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
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return i;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final long a(long j, int i, boolean z) {
        int i2;
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
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
                throw new RuntimeException("type mismatch.");
            }
            return (long) i2;
        } else if (!z) {
            return j;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private float a(float f, int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 4) {
                return this.a.getFloat();
            }
            if (b2 == 12) {
                return 0.0f;
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private double a(double d, int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
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
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return d;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final String b(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
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
                if (i3 > 104857600 || i3 < 0 || i3 > this.a.capacity()) {
                    throw new RuntimeException("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.a.get(bArr2);
                try {
                    return new String(bArr2, this.b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            } else {
                throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
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
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 8) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    for (int i2 = 0; i2 < a2; i2++) {
                        map.put(a((a) key, 0, true), a((a) value, 1, true));
                    }
                } else {
                    throw new RuntimeException("size invalid: " + a2);
                }
            } else {
                throw new RuntimeException("type mismatch.");
            }
        } else if (z) {
            throw new RuntimeException("require field not exist.");
        }
        return map;
    }

    private boolean[] d(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    boolean[] zArr = new boolean[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        zArr[i2] = a(0, true);
                    }
                    return zArr;
                }
                throw new RuntimeException("size invalid: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    public final byte[] c(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 9) {
                int a2 = a(0, 0, true);
                if (a2 < 0 || a2 > this.a.capacity()) {
                    throw new RuntimeException("size invalid: " + a2);
                }
                byte[] bArr = new byte[a2];
                for (int i2 = 0; i2 < a2; i2++) {
                    bArr[i2] = a(bArr[0], 0, true);
                }
                return bArr;
            } else if (b2 == 13) {
                C0142a aVar2 = new C0142a();
                a(aVar2);
                if (aVar2.a == 0) {
                    int a3 = a(0, 0, true);
                    if (a3 < 0 || a3 > this.a.capacity()) {
                        throw new RuntimeException("invalid size, tag: " + i + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a) + ", size: " + a3);
                    }
                    byte[] bArr2 = new byte[a3];
                    this.a.get(bArr2);
                    return bArr2;
                }
                throw new RuntimeException("type mismatch, tag: " + i + ", type: " + ((int) aVar.a) + ", " + ((int) aVar2.a));
            } else {
                throw new RuntimeException("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private short[] e(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    short[] sArr = new short[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        sArr[i2] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new RuntimeException("size invalid: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private int[] f(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    int[] iArr = new int[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        iArr[i2] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new RuntimeException("size invalid: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private long[] g(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    long[] jArr = new long[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        jArr[i2] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new RuntimeException("size invalid: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private float[] h(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    float[] fArr = new float[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        fArr[i2] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new RuntimeException("size invalid: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private double[] i(int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    double[] dArr = new double[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        dArr[i2] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new RuntimeException("size invalid: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i, boolean z) {
        if (b(i)) {
            C0142a aVar = new C0142a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
                    for (int i2 = 0; i2 < a2; i2++) {
                        tArr[i2] = a((a) t, 0, true);
                    }
                    return tArr;
                }
                throw new RuntimeException("size invalid: " + a2);
            }
            throw new RuntimeException("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    private JceStruct a(JceStruct jceStruct, int i, boolean z) {
        if (b(i)) {
            try {
                JceStruct jceStruct2 = (JceStruct) jceStruct.getClass().newInstance();
                C0142a aVar = new C0142a();
                a(aVar);
                if (aVar.a == 10) {
                    jceStruct2.readFrom(this);
                    a();
                    return jceStruct2;
                }
                throw new RuntimeException("type mismatch.");
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new RuntimeException("require field not exist.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.beacon.core.wup.a */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        }
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
            return b(i, z);
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
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
        } else if (t instanceof JceStruct) {
            return a((JceStruct) t, i, z);
        } else {
            if (!t.getClass().isArray()) {
                throw new RuntimeException("read object error: unsupport type.");
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
                Object[] objArr = (Object[]) t;
                if (!(objArr == null || objArr.length == 0)) {
                    return b(objArr[0], i, z);
                }
                throw new RuntimeException("unable to get type of key and value.");
            }
        }
    }

    public final int a(String str) {
        this.b = str;
        return 0;
    }
}
