package net.lingala.zip4j.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;

public class Zip4jUtil {
    private static final long DOSTIME_BEFORE_1980 = 2162688;
    private static final int MAX_RAW_READ_FULLY_RETRY_ATTEMPTS = 15;

    public static boolean isStringNotNullAndNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static boolean createDirectoryIfNotExists(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("output path is null");
        } else if (file.exists()) {
            if (file.isDirectory()) {
                return true;
            }
            throw new ZipException("output directory is not valid");
        } else if (file.mkdirs()) {
            return true;
        } else {
            throw new ZipException("Cannot create output directories");
        }
    }

    public static long epochToExtendedDosTime(long j) {
        if (j < 0) {
            return 2162688;
        }
        long epochToDosTime = epochToDosTime(j);
        if (epochToDosTime != 2162688) {
            return epochToDosTime + ((j % 2000) << 32);
        }
        return 2162688;
    }

    private static long epochToDosTime(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        int i = instance.get(1);
        if (i < 1980) {
            return 2162688;
        }
        return (long) ((instance.get(13) >> 1) | ((i - 1980) << 25) | ((instance.get(2) + 1) << 21) | (instance.get(5) << 16) | (instance.get(11) << 11) | (instance.get(12) << 5));
    }

    public static long dosToExtendedEpochTme(long j) {
        return dosToEpochTime(j) + (j >> 32);
    }

    private static long dosToEpochTime(long j) {
        int i = (int) ((j << 1) & 62);
        int i2 = (int) ((j >> 5) & 63);
        int i3 = (int) ((j >> 11) & 31);
        int i4 = (int) ((j >> 16) & 31);
        int i5 = (int) (((j >> 25) & 127) + 1980);
        Calendar instance = Calendar.getInstance();
        instance.set(i5, (int) (((j >> 21) & 15) - 1), i4, i3, i2, i);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static byte[] convertCharArrayToByteArray(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        for (int i = 0; i < cArr.length; i++) {
            bArr[i] = (byte) cArr[i];
        }
        return bArr;
    }

    public static CompressionMethod getCompressionMethod(LocalFileHeader localFileHeader) {
        if (localFileHeader.getCompressionMethod() != CompressionMethod.AES_INTERNAL_ONLY) {
            return localFileHeader.getCompressionMethod();
        }
        if (localFileHeader.getAesExtraDataRecord() != null) {
            return localFileHeader.getAesExtraDataRecord().getCompressionMethod();
        }
        throw new RuntimeException("AesExtraDataRecord not present in local header for aes encrypted data");
    }

    public static int readFully(InputStream inputStream, byte[] bArr) throws IOException {
        int read = inputStream.read(bArr);
        if (read == bArr.length || (read = readUntilBufferIsFull(inputStream, bArr, read)) == bArr.length) {
            return read;
        }
        throw new IOException("Cannot read fully into byte buffer");
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        if (i < 0) {
            throw new IllegalArgumentException("Negative offset");
        } else if (i2 >= 0) {
            int i3 = 0;
            if (i2 == 0) {
                return 0;
            }
            if (i + i2 <= bArr.length) {
                while (i3 != i2) {
                    int read = inputStream.read(bArr, i + i3, i2 - i3);
                    if (read != -1) {
                        i3 += read;
                    } else if (i3 == 0) {
                        return -1;
                    } else {
                        return i3;
                    }
                }
                return i3;
            }
            throw new IllegalArgumentException("Length greater than buffer size");
        } else {
            throw new IllegalArgumentException("Negative length");
        }
    }

    private static int readUntilBufferIsFull(InputStream inputStream, byte[] bArr, int i) throws IOException {
        int length = bArr.length - i;
        int i2 = 1;
        int i3 = 0;
        while (i < bArr.length && i3 != -1 && i2 < 15) {
            i3 = inputStream.read(bArr, i, length);
            if (i3 > 0) {
                i += i3;
                length -= i3;
            }
            i2++;
        }
        return i;
    }
}
