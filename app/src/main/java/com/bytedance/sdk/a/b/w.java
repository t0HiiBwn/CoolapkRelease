package com.bytedance.sdk.a.b;

import java.io.IOException;

/* compiled from: Protocol */
public enum w {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    private final String e;

    private w(String str) {
        this.e = str;
    }

    public static w a(String str) throws IOException {
        w wVar = HTTP_1_0;
        if (str.equals(wVar.e)) {
            return wVar;
        }
        w wVar2 = HTTP_1_1;
        if (str.equals(wVar2.e)) {
            return wVar2;
        }
        w wVar3 = HTTP_2;
        if (str.equals(wVar3.e)) {
            return wVar3;
        }
        w wVar4 = SPDY_3;
        if (str.equals(wVar4.e)) {
            return wVar4;
        }
        throw new IOException("Unexpected protocol: " + str);
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.e;
    }
}
