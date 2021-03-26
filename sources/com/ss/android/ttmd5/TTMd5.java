package com.ss.android.ttmd5;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;
import java.util.Objects;

public class TTMd5 {
    private static final int DEFAULT_SAMPLE_COUNT = 9;
    private static final int DEFAULT_SAMPLE_SIZE = 8192;
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String PROTOCOL = "ttmd5";
    private static final String TAG = "TTMd5";
    private static final int VERSION_MAIN = 1;
    private static final int VERSION_SUB = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CHECK_MD5_STATUS {
        public static final int FILE_NOT_EXIST = 5;
        public static final int GET_FILE_MD5_ERROR = 6;
        public static final int MD5_EMPTY = 2;
        public static final int MD5_MATCH = 0;
        public static final int MD5_NOT_MATCH = 1;
        public static final int TTMD5_TAG_PARSER_ERROR = 4;
        public static final int TTMD5_VERSION_NOT_SUPPORT = 3;
        public static final int UNKNOWN_ERROR = 99;
    }

    public static String ttmd5(File file) {
        return ttmd5(file, 9, 8192);
    }

    public static String ttmd5(File file, int i) {
        return ttmd5(file, i, 8192);
    }

    public static String ttmd5(File file, int i, long j) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return _ttmd5(file, i, j);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static String md5(File file) {
        return ttmd5(file, -1, -1);
    }

    public static String ttmd5(IRandomAccess iRandomAccess) {
        return ttmd5(iRandomAccess, 9, 8192);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i) {
        return ttmd5(iRandomAccess, i, 8192);
    }

    public static String ttmd5(IRandomAccess iRandomAccess, int i, long j) {
        if (iRandomAccess == null) {
            return "";
        }
        try {
            return _ttmd5(iRandomAccess, i, j);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int checkMd5(String str, File file) {
        String str2;
        if (str == null || str.length() == 0) {
            return 2;
        }
        if (file == null) {
            return 5;
        }
        try {
            if (!file.exists()) {
                return 5;
            }
            int i = -1;
            long j = -1;
            try {
                TTMd5Args parserTTMd5Args = parserTTMd5Args(str);
                if (parserTTMd5Args != null) {
                    if (parserTTMd5Args.versionMain > 1) {
                        return 3;
                    }
                    i = parserTTMd5Args.sampleCount;
                    j = parserTTMd5Args.sampleSize;
                }
                TTMd5Args tTMd5Args = null;
                try {
                    str2 = _ttmd5(file, i, j);
                } catch (Throwable th) {
                    th.printStackTrace();
                    str2 = null;
                }
                if (str2 == null || str2.length() == 0) {
                    return 6;
                }
                if (parserTTMd5Args == null || (parserTTMd5Args.versionMain == 1 && parserTTMd5Args.versionSub == 1)) {
                    if (str2.equals(str)) {
                        return 0;
                    }
                } else if (parserTTMd5Args.realMd5 != null) {
                    try {
                        tTMd5Args = parserTTMd5Args(str2);
                    } catch (Throwable unused) {
                    }
                    if (tTMd5Args != null && parserTTMd5Args.sampleCount == tTMd5Args.sampleCount && parserTTMd5Args.sampleSize == tTMd5Args.sampleSize && parserTTMd5Args.realMd5.equals(tTMd5Args.realMd5)) {
                        return 0;
                    }
                }
                return 1;
            } catch (Throwable unused2) {
                return 4;
            }
        } catch (Throwable unused3) {
            return 99;
        }
    }

    public static int checkMd5(File file, File file2) {
        if (file == null || file2 == null) {
            return 5;
        }
        try {
            if (!file.exists()) {
                return 5;
            }
            if (!file2.exists()) {
                return 5;
            }
            if (file != file2 && !_ttmd5(file, 9, 8192).equals(_ttmd5(file2, 9, 8192))) {
                return 1;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 99;
        }
    }

    private static String _ttmd5(File file, int i, long j) throws Exception {
        return _ttmd5(new FileRandomAccess(file), i, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040 A[Catch:{ all -> 0x009c, all -> 0x00a0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064 A[Catch:{ all -> 0x009c, all -> 0x00a0 }] */
    private static String _ttmd5(IRandomAccess iRandomAccess, int i, long j) throws Exception {
        long j2;
        String hexString;
        int i2 = i;
        MessageDigest instance = MessageDigest.getInstance("MD5");
        if (instance == null) {
            return "";
        }
        try {
            long length = iRandomAccess.length();
            if (i2 > 0 && j > 0) {
                if (((long) i2) * j <= (8 * length) / 10) {
                    j2 = j;
                    byte[] bArr = new byte[8192];
                    long j3 = 0;
                    updateSample(iRandomAccess, instance, bArr, 0, j2);
                    if (i2 > 2) {
                        int i3 = i2 - 1;
                        long j4 = (length - (((long) i2) * j2)) / ((long) i3);
                        int i4 = 1;
                        while (i4 < i3) {
                            j3 += j2 + j4;
                            updateSample(iRandomAccess, instance, bArr, j3, j2);
                            i4++;
                            i3 = i3;
                        }
                    }
                    if (i2 > 1) {
                        updateSample(iRandomAccess, instance, bArr, length - j2, j2);
                    }
                    hexString = toHexString(instance.digest());
                    if (i2 == 1 || j2 != length) {
                        String str = generateTTMd5Tag(i2, j2) + ";" + hexString;
                        iRandomAccess.close();
                        return str;
                    }
                    try {
                        iRandomAccess.close();
                    } catch (Throwable unused) {
                    }
                    return hexString;
                }
            }
            j2 = length;
            i2 = 1;
            byte[] bArr = new byte[8192];
            long j3 = 0;
            updateSample(iRandomAccess, instance, bArr, 0, j2);
            if (i2 > 2) {
            }
            if (i2 > 1) {
            }
            hexString = toHexString(instance.digest());
            if (i2 == 1) {
            }
            String str = generateTTMd5Tag(i2, j2) + ";" + hexString;
            try {
                iRandomAccess.close();
            } catch (Throwable unused2) {
            }
            return str;
        } catch (Throwable unused3) {
        }
        throw th;
    }

    private static void updateSample(IRandomAccess iRandomAccess, MessageDigest messageDigest, byte[] bArr, long j, long j2) throws IOException {
        iRandomAccess.seek(j, j2);
        long j3 = 0;
        while (j3 < j2) {
            int read = iRandomAccess.read(bArr, 0, (int) Math.min(j2 - j3, (long) bArr.length));
            if (read > 0) {
                messageDigest.update(bArr, 0, read);
                j3 += (long) read;
            } else {
                throw new IOException("updateSample unexpected readCount <= 0, readCount = " + read + ", readTotalCount = " + j3 + ", sampleSize = " + j2);
            }
        }
    }

    private static String toHexString(byte[] bArr) {
        Objects.requireNonNull(bArr, "bytes is null");
        int length = bArr.length;
        int i = length * 2;
        char[] cArr = new char[i];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = bArr[i3 + 0] & 255;
            int i5 = i2 + 1;
            char[] cArr2 = HEX_CHARS;
            cArr[i2] = cArr2[i4 >> 4];
            i2 = i5 + 1;
            cArr[i5] = cArr2[i4 & 15];
        }
        return new String(cArr, 0, i);
    }

    private static String generateTTMd5Tag(int i, long j) {
        return "ttmd5:1:1:" + encryptionNum((long) i) + "g" + encryptionNum(j);
    }

    private static TTMd5Args parserTTMd5Args(String str) throws Exception {
        if (!str.startsWith("ttmd5:")) {
            return null;
        }
        String[] split = str.split(";");
        String[] split2 = split[0].split(":");
        TTMd5Args tTMd5Args = new TTMd5Args();
        tTMd5Args.versionMain = Integer.parseInt(split2[1]);
        if (tTMd5Args.versionMain > 1) {
            return tTMd5Args;
        }
        tTMd5Args.versionSub = Integer.parseInt(split2[2]);
        String[] split3 = split2[3].split("g");
        tTMd5Args.sampleCount = (int) decryptNum(split3[0]);
        tTMd5Args.sampleSize = decryptNum(split3[1]);
        tTMd5Args.realMd5 = split[1];
        return tTMd5Args;
    }

    private static String encryptionNum(long j) {
        return Long.toHexString((j << 4) + 31);
    }

    private static long decryptNum(String str) throws RuntimeException {
        try {
            return (Long.parseLong(str, 16) - 31) >> 4;
        } catch (Throwable unused) {
            throw new RuntimeException("ttmd5 decryptNum error, num = " + str);
        }
    }

    private static class TTMd5Args {
        private String realMd5;
        private int sampleCount;
        private long sampleSize;
        private int versionMain;
        private int versionSub;

        private TTMd5Args() {
        }
    }
}
