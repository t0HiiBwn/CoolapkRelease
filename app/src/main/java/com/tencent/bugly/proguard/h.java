package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class h {
    private StringBuilder a;
    private int b = 0;

    private void a(String str) {
        for (int i = 0; i < this.b; i++) {
            this.a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public h(StringBuilder sb, int i) {
        this.a = sb;
        this.b = i;
    }

    public final h a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final h a(byte b2, String str) {
        a(str);
        StringBuilder sb = this.a;
        sb.append((int) b2);
        sb.append('\n');
        return this;
    }

    public final h a(short s, String str) {
        a(str);
        StringBuilder sb = this.a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public final h a(int i, String str) {
        a(str);
        StringBuilder sb = this.a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public final h a(long j, String str) {
        a(str);
        StringBuilder sb = this.a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public final h a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.a.append("null\n");
        } else {
            StringBuilder sb = this.a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    public final h a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            h hVar = new h(this.a, this.b + 1);
            for (byte b2 : bArr) {
                hVar.a(null);
                StringBuilder sb3 = hVar.a;
                sb3.append((int) b2);
                sb3.append('\n');
            }
            a(null);
            StringBuilder sb4 = this.a;
            sb4.append(']');
            sb4.append('\n');
            return this;
        }
    }

    public final <K, V> h a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.a;
            sb2.append(map.size());
            sb2.append(", {\n");
            h hVar = new h(this.a, this.b + 1);
            h hVar2 = new h(this.a, this.b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                hVar.a(null);
                StringBuilder sb3 = hVar.a;
                sb3.append('(');
                sb3.append('\n');
                hVar2.a((h) entry.getKey(), (String) null);
                hVar2.a((h) entry.getValue(), (String) null);
                hVar.a(null);
                StringBuilder sb4 = hVar.a;
                sb4.append(')');
                sb4.append('\n');
            }
            a(null);
            StringBuilder sb5 = this.a;
            sb5.append('}');
            sb5.append('\n');
            return this;
        }
    }

    private <T> h a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            h hVar = new h(this.a, this.b + 1);
            for (T t : tArr) {
                hVar.a((h) t, (String) null);
            }
            a(null);
            StringBuilder sb3 = this.a;
            sb3.append(']');
            sb3.append('\n');
            return this;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: com.tencent.bugly.proguard.h */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> h a(T t, String str) {
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            byte byteValue = t.byteValue();
            a(str);
            StringBuilder sb = this.a;
            sb.append((int) byteValue);
            sb.append('\n');
        } else if (t instanceof Boolean) {
            boolean booleanValue = t.booleanValue();
            a(str);
            StringBuilder sb2 = this.a;
            sb2.append(booleanValue ? 'T' : 'F');
            sb2.append('\n');
        } else if (t instanceof Short) {
            short shortValue = t.shortValue();
            a(str);
            StringBuilder sb3 = this.a;
            sb3.append((int) shortValue);
            sb3.append('\n');
        } else if (t instanceof Integer) {
            int intValue = t.intValue();
            a(str);
            StringBuilder sb4 = this.a;
            sb4.append(intValue);
            sb4.append('\n');
        } else if (t instanceof Long) {
            long longValue = t.longValue();
            a(str);
            StringBuilder sb5 = this.a;
            sb5.append(longValue);
            sb5.append('\n');
        } else if (t instanceof Float) {
            float floatValue = t.floatValue();
            a(str);
            StringBuilder sb6 = this.a;
            sb6.append(floatValue);
            sb6.append('\n');
        } else if (t instanceof Double) {
            double doubleValue = t.doubleValue();
            a(str);
            StringBuilder sb7 = this.a;
            sb7.append(doubleValue);
            sb7.append('\n');
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            T t2 = t;
            if (t2 == null) {
                a(str);
                this.a.append("null\t");
            } else {
                a(t2.toArray(), str);
            }
        } else if (t instanceof k) {
            a((k) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((h) ((boolean[]) t), str);
        } else {
            int i = 0;
            if (t instanceof short[]) {
                short[] sArr = (short[]) t;
                a(str);
                if (sArr == null) {
                    this.a.append("null\n");
                } else if (sArr.length == 0) {
                    StringBuilder sb8 = this.a;
                    sb8.append(sArr.length);
                    sb8.append(", []\n");
                } else {
                    StringBuilder sb9 = this.a;
                    sb9.append(sArr.length);
                    sb9.append(", [\n");
                    h hVar = new h(this.a, this.b + 1);
                    int length = sArr.length;
                    while (i < length) {
                        short s = sArr[i];
                        hVar.a(null);
                        StringBuilder sb10 = hVar.a;
                        sb10.append((int) s);
                        sb10.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb11 = this.a;
                    sb11.append(']');
                    sb11.append('\n');
                }
            } else if (t instanceof int[]) {
                int[] iArr = (int[]) t;
                a(str);
                if (iArr == null) {
                    this.a.append("null\n");
                } else if (iArr.length == 0) {
                    StringBuilder sb12 = this.a;
                    sb12.append(iArr.length);
                    sb12.append(", []\n");
                } else {
                    StringBuilder sb13 = this.a;
                    sb13.append(iArr.length);
                    sb13.append(", [\n");
                    h hVar2 = new h(this.a, this.b + 1);
                    int length2 = iArr.length;
                    while (i < length2) {
                        int i2 = iArr[i];
                        hVar2.a(null);
                        StringBuilder sb14 = hVar2.a;
                        sb14.append(i2);
                        sb14.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb15 = this.a;
                    sb15.append(']');
                    sb15.append('\n');
                }
            } else if (t instanceof long[]) {
                long[] jArr = (long[]) t;
                a(str);
                if (jArr == null) {
                    this.a.append("null\n");
                } else if (jArr.length == 0) {
                    StringBuilder sb16 = this.a;
                    sb16.append(jArr.length);
                    sb16.append(", []\n");
                } else {
                    StringBuilder sb17 = this.a;
                    sb17.append(jArr.length);
                    sb17.append(", [\n");
                    h hVar3 = new h(this.a, this.b + 1);
                    int length3 = jArr.length;
                    while (i < length3) {
                        long j = jArr[i];
                        hVar3.a(null);
                        StringBuilder sb18 = hVar3.a;
                        sb18.append(j);
                        sb18.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb19 = this.a;
                    sb19.append(']');
                    sb19.append('\n');
                }
            } else if (t instanceof float[]) {
                float[] fArr = (float[]) t;
                a(str);
                if (fArr == null) {
                    this.a.append("null\n");
                } else if (fArr.length == 0) {
                    StringBuilder sb20 = this.a;
                    sb20.append(fArr.length);
                    sb20.append(", []\n");
                } else {
                    StringBuilder sb21 = this.a;
                    sb21.append(fArr.length);
                    sb21.append(", [\n");
                    h hVar4 = new h(this.a, this.b + 1);
                    int length4 = fArr.length;
                    while (i < length4) {
                        float f = fArr[i];
                        hVar4.a(null);
                        StringBuilder sb22 = hVar4.a;
                        sb22.append(f);
                        sb22.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb23 = this.a;
                    sb23.append(']');
                    sb23.append('\n');
                }
            } else if (t instanceof double[]) {
                double[] dArr = (double[]) t;
                a(str);
                if (dArr == null) {
                    this.a.append("null\n");
                } else if (dArr.length == 0) {
                    StringBuilder sb24 = this.a;
                    sb24.append(dArr.length);
                    sb24.append(", []\n");
                } else {
                    StringBuilder sb25 = this.a;
                    sb25.append(dArr.length);
                    sb25.append(", [\n");
                    h hVar5 = new h(this.a, this.b + 1);
                    int length5 = dArr.length;
                    while (i < length5) {
                        double d = dArr[i];
                        hVar5.a(null);
                        StringBuilder sb26 = hVar5.a;
                        sb26.append(d);
                        sb26.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb27 = this.a;
                    sb27.append(']');
                    sb27.append('\n');
                }
            } else if (t.getClass().isArray()) {
                a((Object[]) t, str);
            } else {
                throw new b("write object error: unsupport type.");
            }
        }
        return this;
    }

    public final h a(k kVar, String str) {
        a(str);
        StringBuilder sb = this.a;
        sb.append('{');
        sb.append('\n');
        if (kVar == null) {
            StringBuilder sb2 = this.a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            kVar.a(this.a, this.b + 1);
        }
        a(null);
        StringBuilder sb3 = this.a;
        sb3.append('}');
        sb3.append('\n');
        return this;
    }
}
