package com.tencent.beacon.core.protocol.common;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.HashMap;
import java.util.Map;

public final class SocketRequestPackage extends JceStruct {
    static byte[] cache_body;
    static Map<String, String> cache_header;
    public byte[] body = null;
    public Map<String, String> header = null;

    public SocketRequestPackage() {
    }

    public SocketRequestPackage(Map<String, String> map, byte[] bArr) {
        this.header = map;
        this.body = bArr;
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void writeTo(b bVar) {
        bVar.a((Map) this.header, 0);
        bVar.a(this.body, 1);
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
        this.header = (Map) aVar.a((a) cache_header, 0, true);
        this.body = aVar.c(1, true);
    }
}
