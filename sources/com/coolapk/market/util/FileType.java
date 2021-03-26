package com.coolapk.market.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import org.apache.commons.io.IOUtils;

public class FileType {
    private static final HashMap<String, String> mFileTypes;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        mFileTypes = hashMap;
        hashMap.put("ffd8ff", "jpg");
        hashMap.put("89504e47", "png");
        hashMap.put("474946", "gif");
        hashMap.put("49492a00", "tif");
        hashMap.put("424d", "bmp");
    }

    public static String getFileType(String str) {
        String fileHeader = getFileHeader(str);
        if (fileHeader == null) {
            return null;
        }
        String lowerCase = fileHeader.toLowerCase();
        for (String str2 : mFileTypes.keySet()) {
            if (lowerCase.startsWith(str2)) {
                return mFileTypes.get(str2);
            }
        }
        return null;
    }

    private static String getFileHeader(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        String str2 = null;
        str2 = null;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[8];
                IOUtils.read(fileInputStream, bArr);
                str2 = bytesToHexString(bArr);
            } catch (Exception unused) {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                IOUtils.closeQuietly((InputStream) fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            IOUtils.closeQuietly((InputStream) fileInputStream2);
            throw th;
        }
        IOUtils.closeQuietly((InputStream) fileInputStream);
        return str2;
    }

    private static String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return sb.toString();
    }
}
