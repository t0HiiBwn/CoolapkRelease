package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TokenContents {
    private final byte[] mContents;
    private List<byte[]> mFingerprints;
    private String mPackageName;

    static TokenContents deserialize(byte[] bArr) {
        return new TokenContents(bArr);
    }

    private TokenContents(byte[] bArr) {
        this.mContents = bArr;
    }

    static TokenContents create(String str, List<byte[]> list) throws IOException {
        return new TokenContents(createToken(str, list), str, list);
    }

    private TokenContents(byte[] bArr, String str, List<byte[]> list) {
        this.mContents = bArr;
        this.mPackageName = str;
        this.mFingerprints = new ArrayList(list.size());
        for (byte[] bArr2 : list) {
            this.mFingerprints.add(Arrays.copyOf(bArr2, bArr2.length));
        }
    }

    public String getPackageName() throws IOException {
        parseIfNeeded();
        String str = this.mPackageName;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException();
    }

    public int getFingerprintCount() throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list != null) {
            return list.size();
        }
        throw new IllegalStateException();
    }

    public byte[] getFingerprint(int i) throws IOException {
        parseIfNeeded();
        List<byte[]> list = this.mFingerprints;
        if (list != null) {
            return Arrays.copyOf(list.get(i), this.mFingerprints.get(i).length);
        }
        throw new IllegalStateException();
    }

    public byte[] serialize() {
        byte[] bArr = this.mContents;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.mContents, ((TokenContents) obj).mContents);
    }

    public int hashCode() {
        return Arrays.hashCode(this.mContents);
    }

    private static byte[] createToken(String str, List<byte[]> list) throws IOException {
        Collections.sort(list, $$Lambda$TokenContents$Q7kOl2yBde7CmQs5Ktpiz56Nr70.INSTANCE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        for (byte[] bArr : list) {
            dataOutputStream.writeInt(bArr.length);
            dataOutputStream.write(bArr);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* access modifiers changed from: private */
    public static int compareByteArrays(byte[] bArr, byte[] bArr2) {
        int i;
        int i2;
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        int i3 = 0;
        while (true) {
            if (i3 < Math.min(bArr.length, bArr2.length)) {
                if (bArr[i3] != bArr2[i3]) {
                    i2 = bArr[i3];
                    i = bArr2[i3];
                    break;
                }
                i3++;
            } else if (bArr.length == bArr2.length) {
                return 0;
            } else {
                i2 = bArr.length;
                i = bArr2.length;
            }
        }
        return i2 - i;
    }

    private void parseIfNeeded() throws IOException {
        if (this.mPackageName == null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.mContents));
            this.mPackageName = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            this.mFingerprints = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                int readInt2 = dataInputStream.readInt();
                byte[] bArr = new byte[readInt2];
                if (dataInputStream.read(bArr) == readInt2) {
                    this.mFingerprints.add(bArr);
                } else {
                    throw new IllegalStateException("Could not read fingerprint");
                }
            }
        }
    }
}
