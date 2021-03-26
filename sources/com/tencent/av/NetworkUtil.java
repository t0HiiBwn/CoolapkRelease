package com.tencent.av;

import com.tencent.imsdk.log.QLog;
import java.nio.ByteBuffer;

public class NetworkUtil {
    private static final String tag = "av.NetworkUtil";

    public static byte[] formReq(long j, int i, int i2, String str, byte[] bArr) {
        short nextInt = (short) TIMAvManager.getInstance().random.nextInt();
        short s = (short) i;
        byte[] bytes = "".getBytes();
        if (str != null) {
            bytes = str.getBytes();
        }
        ByteBuffer allocate = ByteBuffer.allocate(10 + bytes.length + 11 + 4 + bArr.length);
        allocate.putShort(0).putShort(0).putShort(nextInt).putInt(0);
        allocate.putShort(s).putLong(j).put((byte) bytes.length).put(bytes).putInt(i2);
        allocate.put(bArr);
        allocate.flip();
        return allocate.array();
    }

    public static byte[] formReq(long j, int i, int i2, String str, byte[] bArr, byte[] bArr2) {
        short nextInt = (short) TIMAvManager.getInstance().random.nextInt();
        short s = (short) i;
        byte[] bytes = "".getBytes();
        if (str != null) {
            bytes = str.getBytes();
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        ByteBuffer allocate = ByteBuffer.allocate(10 + bytes.length + 11 + 4 + 1 + 4 + 4 + length + length2 + 1);
        allocate.putShort(0).putShort(0).putShort(nextInt).putInt(0);
        allocate.putShort(s).putLong(j).put((byte) bytes.length).put(bytes).putInt(i2);
        allocate.put((byte) 40).putInt(length).putInt(length2).put(bArr).put(bArr2).put((byte) 41);
        allocate.flip();
        return allocate.array();
    }

    public static byte[] parseRsp(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.getShort();
        wrap.getShort();
        wrap.getShort();
        wrap.getInt();
        QLog.d("av.NetworkUtil", "position: " + wrap.position() + "|remaining: " + wrap.remaining());
        wrap.getShort();
        wrap.getInt();
        int i = wrap.getShort();
        if (i > wrap.remaining()) {
            return null;
        }
        wrap.get(new byte[i], 0, i);
        QLog.d("av.NetworkUtil", "position: " + wrap.position() + "|remaining: " + wrap.remaining());
        wrap.get();
        int i2 = wrap.getInt();
        int i3 = wrap.getInt();
        QLog.d("av.NetworkUtil", "headlen:" + i2 + "|bodylen:" + i3);
        if (i2 > wrap.remaining()) {
            return null;
        }
        wrap.get(new byte[i2], 0, i2);
        if (i3 > wrap.remaining()) {
            return null;
        }
        byte[] bArr2 = new byte[i3];
        wrap.get(bArr2, 0, i3);
        return bArr2;
    }
}
