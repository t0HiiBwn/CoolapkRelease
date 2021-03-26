package com.xiaomi.push;

import com.xiaomi.a.a.a.a;

public class cd implements a {
    private a a = null;
    private a b = null;

    public cd(a aVar, a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.xiaomi.a.a.a.a
    public void a(String str) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(str);
        }
        a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(str);
        }
    }

    @Override // com.xiaomi.a.a.a.a
    public void a(String str, Throwable th) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, th);
        }
        a aVar2 = this.b;
        if (aVar2 != null) {
            aVar2.a(str, th);
        }
    }
}
