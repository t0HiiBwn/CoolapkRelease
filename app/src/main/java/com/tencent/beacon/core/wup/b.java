package com.tencent.beacon.core.wup;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: JceOutputStream */
public final class b {
    protected String a;
    private ByteBuffer b;

    public b(int i) {
        this.a = "GBK";
        this.b = ByteBuffer.allocate(i);
    }

    public b() {
        this(128);
    }

    public final ByteBuffer a() {
        return this.b;
    }

    public final byte[] b() {
        byte[] bArr = new byte[this.b.position()];
        System.arraycopy(this.b.array(), 0, bArr, 0, this.b.position());
        return bArr;
    }

    private void a(int i) {
        if (this.b.remaining() < i) {
            try {
                ByteBuffer allocate = ByteBuffer.allocate((this.b.capacity() + i) << 1);
                allocate.put(this.b.array(), 0, this.b.position());
                this.b = allocate;
            } catch (IllegalArgumentException e) {
                throw e;
            }
        }
    }

    private void b(byte b2, int i) {
        if (i < 15) {
            this.b.put((byte) (b2 | (i << 4)));
        } else if (i < 256) {
            this.b.put((byte) (b2 | 240));
            this.b.put((byte) i);
        } else {
            throw new RuntimeException("tag is too large: " + i);
        }
    }

    public final void a(boolean z, int i) {
        a(z ? (byte) 1 : 0, i);
    }

    public final void a(byte b2, int i) {
        a(3);
        if (b2 == 0) {
            b((byte) 12, i);
            return;
        }
        b((byte) 0, i);
        this.b.put(b2);
    }

    public final void a(short s, int i) {
        a(4);
        if (s < -128 || s > 127) {
            b((byte) 1, i);
            this.b.putShort(s);
            return;
        }
        a((byte) s, i);
    }

    public final void a(int i, int i2) {
        a(6);
        if (i < -32768 || i > 32767) {
            b((byte) 2, i2);
            this.b.putInt(i);
            return;
        }
        a((short) i, i2);
    }

    public final void a(long j, int i) {
        a(10);
        if (j < -2147483648L || j > 2147483647L) {
            b((byte) 3, i);
            this.b.putLong(j);
            return;
        }
        a((int) j, i);
    }

    private void a(float f, int i) {
        a(6);
        b((byte) 4, i);
        this.b.putFloat(f);
    }

    private void a(double d, int i) {
        a(10);
        b((byte) 5, i);
        this.b.putDouble(d);
    }

    public final void a(String str, int i) {
        byte[] bArr;
        try {
            bArr = str.getBytes(this.a);
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        a(bArr.length + 10);
        if (bArr.length > 255) {
            b((byte) 7, i);
            this.b.putInt(bArr.length);
            this.b.put(bArr);
            return;
        }
        b((byte) 6, i);
        this.b.put((byte) bArr.length);
        this.b.put(bArr);
    }

    public final <K, V> void a(Map<K, V> map, int i) {
        int i2;
        a(8);
        b((byte) 8, i);
        if (map == null) {
            i2 = 0;
        } else {
            i2 = map.size();
        }
        a(i2, 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a((Object) entry.getKey(), 0);
                a((Object) entry.getValue(), 1);
            }
        }
    }

    public final void a(byte[] bArr, int i) {
        a(bArr.length + 8);
        b((byte) 13, i);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.b.put(bArr);
    }

    public final <T> void a(Collection<T> collection, int i) {
        int i2;
        a(8);
        b((byte) 9, i);
        if (collection == null) {
            i2 = 0;
        } else {
            i2 = collection.size();
        }
        a(i2, 0);
        if (collection != null) {
            for (T t : collection) {
                a((Object) t, 0);
            }
        }
    }

    public final void a(Object obj, int i) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i);
        } else if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i);
        } else if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i);
        } else if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i);
        } else if (obj instanceof Long) {
            a(((Long) obj).longValue(), i);
        } else if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i);
        } else if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i);
        } else if (obj instanceof String) {
            a((String) obj, i);
        } else if (obj instanceof Map) {
            a((Map) obj, i);
        } else if (obj instanceof List) {
            a((Collection) ((List) obj), i);
        } else if (obj instanceof JceStruct) {
            a(2);
            b((byte) 10, i);
            ((JceStruct) obj).writeTo(this);
            a(2);
            b((byte) 11, 0);
        } else if (obj instanceof byte[]) {
            a((byte[]) obj, i);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i);
            a(zArr.length, 0);
            for (boolean z : zArr) {
                a(z, 0);
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i);
            a(sArr.length, 0);
            for (short s : sArr) {
                a(s, 0);
            }
        } else if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i);
            a(iArr.length, 0);
            for (int i2 : iArr) {
                a(i2, 0);
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i);
            a(jArr.length, 0);
            for (long j : jArr) {
                a(j, 0);
            }
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i);
            a(fArr.length, 0);
            for (float f : fArr) {
                a(f, 0);
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i);
            a(dArr.length, 0);
            for (double d : dArr) {
                a(d, 0);
            }
        } else if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
        } else if (obj instanceof Collection) {
            a((Collection) obj, i);
        } else {
            throw new RuntimeException("write object error: unsupport type. " + obj.getClass());
        }
    }

    public final int a(String str) {
        this.a = str;
        return 0;
    }
}
