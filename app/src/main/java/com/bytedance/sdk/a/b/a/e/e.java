package com.bytedance.sdk.a.b.a.e;

import com.bytedance.sdk.a.a.f;
import com.bytedance.sdk.a.b.a.c;
import java.io.IOException;

/* compiled from: Http2 */
public final class e {
    static final f a = f.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    static final String[] b = new String[64];
    static final String[] c = new String[256];
    private static final String[] d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = c;
            if (i2 >= strArr.length) {
                break;
            }
            strArr[i2] = c.a("%8s", Integer.toBinaryString(i2)).replace(' ', '0');
            i2++;
        }
        String[] strArr2 = b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i3 = 0; i3 < 1; i3++) {
            int i4 = iArr[i3];
            String[] strArr3 = b;
            strArr3[i4 | 8] = strArr3[i4] + "|PADDED";
        }
        String[] strArr4 = b;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i5 = 0; i5 < 3; i5++) {
            int i6 = iArr2[i5];
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                String[] strArr5 = b;
                int i9 = i8 | i6;
                strArr5[i9] = strArr5[i8] + '|' + strArr5[i6];
                strArr5[i9 | 8] = strArr5[i8] + '|' + strArr5[i6] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = b;
            if (i < strArr6.length) {
                if (strArr6[i] == null) {
                    strArr6[i] = c[i];
                }
                i++;
            } else {
                return;
            }
        }
    }

    private e() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(c.a(str, objArr));
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(c.a(str, objArr));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0026: APUT  (r8v2 java.lang.Object[]), (0 ??[int, short, byte, char]), (r4v1 java.lang.String) */
    static String a(boolean z, int i, int i2, byte b2, byte b3) {
        String[] strArr = d;
        String a2 = b2 < strArr.length ? strArr[b2] : c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = a2;
        objArr[4] = a3;
        return c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (!(b2 == 2 || b2 == 3)) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : c[b3];
            }
            if (!(b2 == 7 || b2 == 8)) {
                String[] strArr = b;
                String str = b3 < strArr.length ? strArr[b3] : c[b3];
                if (b2 == 5 && (b3 & 4) != 0) {
                    return str.replace("HEADERS", "PUSH_PROMISE");
                }
                if (b2 != 0 || (b3 & 32) == 0) {
                    return str;
                }
                return str.replace("PRIORITY", "COMPRESSED");
            }
        }
        return c[b3];
    }
}
