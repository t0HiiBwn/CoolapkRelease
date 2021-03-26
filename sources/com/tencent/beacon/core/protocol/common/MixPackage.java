package com.tencent.beacon.core.protocol.common;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;
import java.util.HashMap;
import java.util.Map;

public final class MixPackage extends JceStruct implements Cloneable {
    static Map<Integer, byte[]> cache_mixMap;
    public Map<Integer, byte[]> mixMap = null;

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void writeTo(b bVar) {
        bVar.a((Map) this.mixMap, 0);
    }

    @Override // com.tencent.beacon.core.wup.JceStruct
    public final void readFrom(a aVar) {
        if (cache_mixMap == null) {
            cache_mixMap = new HashMap();
            byte[] bArr = new byte[1];
            bArr[0] = 0;
            cache_mixMap.put(0, bArr);
        }
        this.mixMap = (Map) aVar.a((a) cache_mixMap, 0, true);
    }
}
