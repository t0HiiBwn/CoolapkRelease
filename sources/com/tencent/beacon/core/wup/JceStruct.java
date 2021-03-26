package com.tencent.beacon.core.wup;

import java.io.Serializable;

public abstract class JceStruct implements Serializable {
    public static final byte BYTE = 0;
    public static final byte DOUBLE = 5;
    public static final byte FLOAT = 4;
    public static final byte INT = 2;
    public static final int JCE_MAX_STRING_LENGTH = 104857600;
    public static final byte LIST = 9;
    public static final byte LONG = 3;
    public static final byte MAP = 8;
    public static final byte SHORT = 1;
    public static final byte SIMPLE_LIST = 13;
    public static final byte STRING1 = 6;
    public static final byte STRING4 = 7;
    public static final byte STRUCT_BEGIN = 10;
    public static final byte STRUCT_END = 11;
    public static final byte ZERO_TAG = 12;

    public JceStruct newInit() {
        return null;
    }

    public abstract void readFrom(a aVar);

    public abstract void writeTo(b bVar);

    public byte[] toByteArray() {
        b bVar = new b();
        writeTo(bVar);
        return bVar.b();
    }

    public byte[] toByteArray(String str) {
        b bVar = new b();
        bVar.a = str;
        writeTo(bVar);
        return bVar.b();
    }
}
