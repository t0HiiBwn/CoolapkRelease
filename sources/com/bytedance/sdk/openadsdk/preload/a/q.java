package com.bytedance.sdk.openadsdk.preload.a;

import com.bytedance.sdk.openadsdk.preload.a.b.a;
import com.bytedance.sdk.openadsdk.preload.a.b.g;
import java.math.BigInteger;

/* compiled from: JsonPrimitive */
public final class q extends l {
    private final Object a;

    public q(Boolean bool) {
        this.a = a.a(bool);
    }

    public q(Number number) {
        this.a = a.a(number);
    }

    public q(String str) {
        this.a = a.a(str);
    }

    public boolean n() {
        return this.a instanceof Boolean;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public boolean f() {
        if (n()) {
            return ((Boolean) this.a).booleanValue();
        }
        return Boolean.parseBoolean(b());
    }

    public boolean o() {
        return this.a instanceof Number;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public Number a() {
        Object obj = this.a;
        return obj instanceof String ? new g((String) this.a) : (Number) obj;
    }

    public boolean p() {
        return this.a instanceof String;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public String b() {
        if (o()) {
            return a().toString();
        }
        if (n()) {
            return ((Boolean) this.a).toString();
        }
        return (String) this.a;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public double c() {
        return o() ? a().doubleValue() : Double.parseDouble(b());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public long d() {
        return o() ? a().longValue() : Long.parseLong(b());
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public int e() {
        return o() ? a().intValue() : Integer.parseInt(b());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = a().longValue();
        } else {
            Object obj = this.a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.a == null) {
            if (qVar.a == null) {
                return true;
            }
            return false;
        } else if (!a(this) || !a(qVar)) {
            Object obj2 = this.a;
            if (!(obj2 instanceof Number) || !(qVar.a instanceof Number)) {
                return obj2.equals(qVar.a);
            }
            double doubleValue = a().doubleValue();
            double doubleValue2 = qVar.a().doubleValue();
            if (doubleValue == doubleValue2) {
                return true;
            }
            if (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2)) {
                return false;
            }
            return true;
        } else if (a().longValue() == qVar.a().longValue()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean a(q qVar) {
        Object obj = qVar.a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
