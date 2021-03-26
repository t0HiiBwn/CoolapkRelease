package com.coolapk.market.download;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DownloadUtils {
    public static final String TEMP_FILE_EXTENSION = "dl";

    public static String[] generateDownloadHeader(String str) {
        long j;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                j = file.length();
                return new String[]{"Range", "bytes=" + j + "-", "Accept-Encoding", "identity"};
            }
        }
        j = 0;
        return new String[]{"Range", "bytes=" + j + "-", "Accept-Encoding", "identity"};
    }

    static String generateFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(str.getBytes());
                byte[] digest = instance.digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < digest.length; i++) {
                    sb.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                    sb.append(Character.forDigit(digest[i] & 15, 16));
                }
                return sb.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return Uri.parse(str).getLastPathSegment();
    }

    static String tryGetFileNameFromUrl(String str, String str2) {
        return !TextUtils.isEmpty(MimeTypeMap.getFileExtensionFromUrl(str)) ? Uri.parse(str).getLastPathSegment() : str2;
    }
}
