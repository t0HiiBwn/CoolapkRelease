package com.tencent.beacon.core.wup;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: PacketUtil */
public final class c {
    private static HashMap<String, byte[]> e;
    public final RequestPacket a = new RequestPacket();
    private HashMap<String, byte[]> b = new HashMap<>();
    private a c = new a();
    private String d = "GBK";

    public final <T> void a(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        } else if (!(t instanceof Set)) {
            b bVar = new b();
            bVar.a(this.d);
            bVar.a((Object) t, 0);
            this.b.put(str, a(bVar.a()));
        } else {
            throw new IllegalArgumentException("can not support Set");
        }
    }

    public final byte[] a() {
        b bVar = new b(0);
        bVar.a(this.d);
        bVar.a((Map) this.b, 0);
        this.a.iVersion = 3;
        this.a.sBuffer = a(bVar.a());
        b bVar2 = new b(0);
        bVar2.a(this.d);
        this.a.writeTo(bVar2);
        byte[] a2 = a(bVar2.a());
        int length = a2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a2).flip();
        return allocate.array();
    }

    public final void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                a aVar = new a(bArr, (byte) 0);
                aVar.a(this.d);
                this.a.readFrom(aVar);
                a aVar2 = new a(this.a.sBuffer);
                aVar2.a(this.d);
                if (e == null) {
                    HashMap<String, byte[]> hashMap = new HashMap<>();
                    e = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.b = aVar2.a((Map) e, 0, false);
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } else {
            throw new IllegalArgumentException("decode package must include size head");
        }
    }

    public final <T> T b(String str, T t) throws Exception {
        if (!this.b.containsKey(str)) {
            return null;
        }
        try {
            this.c.a(this.b.get(str));
            this.c.a(this.d);
            return (T) this.c.a((a) t, 0, true);
        } catch (Exception e2) {
            throw new Exception(e2);
        }
    }

    private static byte[] a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
