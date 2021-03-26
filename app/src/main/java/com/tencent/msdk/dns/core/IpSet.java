package com.tencent.msdk.dns.core;

import java.util.Arrays;

public class IpSet {
    public static final IpSet EMPTY = new IpSet(a.a, a.a);
    public final String[] ips;
    public final String[] v4Ips;
    public final String[] v6Ips;

    public IpSet(String[] strArr, String[] strArr2) {
        if (strArr == null) {
            throw new IllegalArgumentException("v4Ips".concat(" can not be null"));
        } else if (strArr2 != null) {
            this.v4Ips = strArr;
            this.v6Ips = strArr2;
            this.ips = null;
        } else {
            throw new IllegalArgumentException("v6Ips".concat(" can not be null"));
        }
    }

    public IpSet(String[] strArr) {
        if (strArr != null) {
            this.ips = strArr;
            this.v4Ips = null;
            this.v6Ips = null;
            return;
        }
        throw new IllegalArgumentException("ips".concat(" can not be null"));
    }

    public String toString() {
        return "IpSet{v4Ips=" + Arrays.toString(this.v4Ips) + ", v6Ips=" + Arrays.toString(this.v6Ips) + ", ips=" + Arrays.toString(this.ips) + '}';
    }
}
