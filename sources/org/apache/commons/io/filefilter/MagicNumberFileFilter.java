package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

public class MagicNumberFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -547733176983104172L;
    private final long byteOffset;
    private final byte[] magicNumbers;

    public MagicNumberFileFilter(byte[] bArr) {
        this(bArr, 0);
    }

    public MagicNumberFileFilter(String str) {
        this(str, 0);
    }

    public MagicNumberFileFilter(String str, long j) {
        if (str == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            this.magicNumbers = str.getBytes(Charset.defaultCharset());
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }

    public MagicNumberFileFilter(byte[] bArr, long j) {
        if (bArr == null) {
            throw new IllegalArgumentException("The magic number cannot be null");
        } else if (bArr.length == 0) {
            throw new IllegalArgumentException("The magic number must contain at least one byte");
        } else if (j >= 0) {
            byte[] bArr2 = new byte[bArr.length];
            this.magicNumbers = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.byteOffset = j;
        } else {
            throw new IllegalArgumentException("The offset cannot be negative");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        r6.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        throw r2;
     */
    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        if (file != null && file.isFile() && file.canRead()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                byte[] bArr = new byte[this.magicNumbers.length];
                randomAccessFile.seek(this.byteOffset);
                int read = randomAccessFile.read(bArr);
                byte[] bArr2 = this.magicNumbers;
                if (read != bArr2.length) {
                    randomAccessFile.close();
                    return false;
                }
                boolean equals = Arrays.equals(bArr2, bArr);
                randomAccessFile.close();
                return equals;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, java.lang.Object
    public String toString() {
        return super.toString() + "(" + new String(this.magicNumbers, Charset.defaultCharset()) + "," + this.byteOffset + ")";
    }
}
