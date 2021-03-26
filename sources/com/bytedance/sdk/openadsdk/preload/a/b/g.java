package com.bytedance.sdk.openadsdk.preload.a.b;

import java.math.BigDecimal;

/* compiled from: LazilyParsedNumber */
public final class g extends Number {
    private final String a;

    public g(String str) {
        this.a = str;
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.a);
        } catch (NumberFormatException unused) {
            try {
                return (int) Long.parseLong(this.a);
            } catch (NumberFormatException unused2) {
                return new BigDecimal(this.a).intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.a).longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.a);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        String str = this.a;
        String str2 = ((g) obj).a;
        if (str == str2 || str.equals(str2)) {
            return true;
        }
        return false;
    }
}
