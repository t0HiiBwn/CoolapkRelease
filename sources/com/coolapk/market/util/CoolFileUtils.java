package com.coolapk.market.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.FileInputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import okhttp3.MediaType;
import org.apache.commons.io.FilenameUtils;

public class CoolFileUtils {
    private static final byte[] PNG_HEADER = {-119, 80, 78, 71, 13, 10, 26, 10};

    public static void grantUriPermission(Context context, Intent intent, Uri uri) {
    }

    public static String createRandomFileName(String str) {
        return new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + "." + str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079 A[SYNTHETIC, Splitter:B:39:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0083 A[SYNTHETIC, Splitter:B:44:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008f A[SYNTHETIC, Splitter:B:51:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A[SYNTHETIC, Splitter:B:56:0x0099] */
    public static String getFileMd5(String str) {
        Throwable th;
        DigestInputStream digestInputStream;
        FileInputStream fileInputStream;
        Exception e;
        Throwable th2;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
            } catch (Exception e2) {
                e = e2;
                digestInputStream = null;
                try {
                    e.printStackTrace();
                    if (digestInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (digestInputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th2 = th4;
                digestInputStream = null;
                th = th2;
                if (digestInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
            }
            try {
                while (digestInputStream.read(new byte[4096]) > 0) {
                }
                byte[] digest = digestInputStream.getMessageDigest().digest();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < digest.length; i++) {
                    sb.append(Character.forDigit((digest[i] & 240) >> 4, 16));
                    sb.append(Character.forDigit(digest[i] & 15, 16));
                }
                String sb2 = sb.toString();
                try {
                    digestInputStream.close();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return sb2;
            } catch (Exception e5) {
                e = e5;
                e.printStackTrace();
                if (digestInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                return null;
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            digestInputStream = null;
            e.printStackTrace();
            if (digestInputStream != null) {
                try {
                    digestInputStream.close();
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e8) {
                    e8.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th5) {
            th2 = th5;
            fileInputStream = null;
            digestInputStream = null;
            th = th2;
            if (digestInputStream != null) {
                try {
                    digestInputStream.close();
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }

    public static String getFileExtension(String str) {
        return getFileExtension(str, "");
    }

    public static String getFileExtension(String str, String str2) {
        String extension = FilenameUtils.getExtension(str);
        return TextUtils.isEmpty(extension) ? str2 : extension;
    }

    public static String getMimeTypeFromExtension(String str) {
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    public static MediaType mediaType(String str) {
        String imageFileType = getImageFileType(str);
        if (imageFileType == null) {
            return MediaType.parse("image/png");
        }
        return MediaType.parse("image/" + imageFileType);
    }

    public static String getImageFileType(String str) {
        String fileType = FileType.getFileType(str);
        if (TextUtils.isEmpty(fileType)) {
            fileType = getFileExtension(str);
        }
        if (TextUtils.isEmpty(fileType)) {
            return null;
        }
        fileType.hashCode();
        char c = 65535;
        switch (fileType.hashCode()) {
            case 97669:
                if (fileType.equals("bmp")) {
                    c = 0;
                    break;
                }
                break;
            case 102340:
                if (fileType.equals("gif")) {
                    c = 1;
                    break;
                }
                break;
            case 105441:
                if (fileType.equals("jpg")) {
                    c = 2;
                    break;
                }
                break;
            case 111145:
                if (fileType.equals("png")) {
                    c = 3;
                    break;
                }
                break;
            case 3268712:
                if (fileType.equals("jpeg")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 3:
                break;
            default:
                return "png";
            case 2:
            case 4:
                fileType = "jpeg";
                break;
        }
        return fileType;
    }

    public static boolean isGifFile(String str) {
        return "gif".equalsIgnoreCase(getFileExtension(str));
    }

    public static String wrap(String str) {
        if (str.startsWith("file://")) {
            return str;
        }
        return "file://" + str;
    }

    public static String unwrap(String str) {
        return str.startsWith("file://") ? str.replaceFirst("file://", "") : str;
    }

    public static File unwrapToFile(Uri uri) {
        return new File(uri.toString().replaceFirst("file://", ""));
    }

    public static void notifyNewMediaFile(Context context, File file) {
        if (context != null && file != null && file.exists()) {
            try {
                Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent.setData(Uri.fromFile(file));
                context.sendBroadcast(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getMimeType(String str) {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        return (fileNameMap == null || TextUtils.isEmpty(str)) ? "file/*" : fileNameMap.getContentTypeFor(str);
    }

    public static boolean isPNGFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[8];
            fileInputStream.read(bArr);
            return Arrays.equals(bArr, PNG_HEADER);
        } catch (Exception unused) {
            return false;
        }
    }
}
