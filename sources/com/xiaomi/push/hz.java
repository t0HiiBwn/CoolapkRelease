package com.xiaomi.push;

import com.xiaomi.push.ic;

public class hz {
    private final ig a;
    private final ip b;

    public hz() {
        this(new ic.a());
    }

    public hz(ii iiVar) {
        ip ipVar = new ip();
        this.b = ipVar;
        this.a = iiVar.a(ipVar);
    }

    public void a(hu huVar, byte[] bArr) {
        try {
            this.b.a(bArr);
            huVar.a(this.a);
        } finally {
            this.a.x();
        }
    }
}
