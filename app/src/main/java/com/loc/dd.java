package com.loc;

/* compiled from: AmapWifi */
public final class dd {
    public long a;
    public String b;
    public int c = -113;
    public int d;
    public long e;
    public long f = 0;
    public short g;
    public boolean h;

    public dd(boolean z) {
        this.h = z;
    }

    public static long a(String str) {
        long j;
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i = 0;
        long j2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = (long) str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j3 = 97;
                if (charAt < 97 || charAt > 102) {
                    j3 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (!(charAt == 58 || charAt == 124)) {
                            return 0;
                        }
                    }
                }
                j = (charAt - j3) + 10;
            } else {
                j = charAt - 48;
            }
            j2 += j << i;
            i += 4;
        }
        if (i != 48) {
            return 0;
        }
        return j2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        dd ddVar = new dd(this.h);
        ddVar.a = this.a;
        ddVar.b = this.b;
        ddVar.c = this.c;
        ddVar.d = this.d;
        ddVar.e = this.e;
        ddVar.f = this.f;
        ddVar.g = this.g;
        ddVar.h = this.h;
        return ddVar;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.a + ", ssid='" + this.b + "', rssi=" + this.c + ", frequency=" + this.d + ", timestamp=" + this.e + ", lastUpdateUtcMills=" + this.f + ", freshness=" + ((int) this.g) + ", connected=" + this.h + '}';
    }
}
