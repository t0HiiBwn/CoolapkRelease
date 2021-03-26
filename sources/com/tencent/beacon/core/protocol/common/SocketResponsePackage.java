package com.tencent.beacon.core.protocol.common;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.HashMap;
import java.util.Map;

public final class SocketResponsePackage extends JceStruct {
    static byte[] cache_body;
    static Map<String, String> cache_header;
    public byte[] body = null;
    public Map<String, String> header = null;
    public String msg = "";
    public int statusCode = 0;

    public SocketResponsePackage() {
    }

    public SocketResponsePackage(int i, Map<String, String> map, byte[] bArr, String str) {
        this.statusCode = i;
        this.header = map;
        this.body = bArr;
        this.msg = str;
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void writeTo(b bVar) {
        bVar.a(this.statusCode, 0);
        bVar.a((Map) this.header, 1);
        bVar.a(this.body, 2);
        String str = this.msg;
        if (str != null) {
            bVar.a(str, 3);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        cache_header = hashMap;
        hashMap.put("", "");
        byte[] bArr = new byte[1];
        cache_body = bArr;
        bArr[0] = 0;
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void readFrom(a aVar) {
        this.statusCode = aVar.a(this.statusCode, 0, true);
        this.header = (Map) aVar.a((a) cache_header, 1, true);
        this.body = aVar.c(2, true);
        this.msg = aVar.b(3, false);
    }
}
