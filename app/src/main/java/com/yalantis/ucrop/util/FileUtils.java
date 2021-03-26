package com.yalantis.ucrop.util;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Locale;

public class FileUtils {
    static final String TAG = "FileUtils";

    private FileUtils() {
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r8 != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        IllegalArgumentException e;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return string;
                    }
                } catch (IllegalArgumentException e2) {
                    e = e2;
                    try {
                        Log.i("FileUtils", String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", e.getMessage()));
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (IllegalArgumentException e3) {
            e = e3;
            cursor = null;
            Log.i("FileUtils", String.format(Locale.getDefault(), "getDataColumn: _data - [%s]", e.getMessage()));
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn(context, uri, null, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
        } else {
            if (isMediaDocument(uri)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str = split2[0];
                if ("image".equals(str)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(str)) {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    public static void copyFile(String str, String str2) throws IOException {
        Throwable th;
        FileChannel fileChannel;
        if (!str.equalsIgnoreCase(str2)) {
            FileChannel fileChannel2 = null;
            try {
                FileChannel channel = new FileInputStream(new File(str)).getChannel();
                try {
                    fileChannel2 = new FileOutputStream(new File(str2)).getChannel();
                    channel.transferTo(0, channel.size(), fileChannel2);
                    channel.close();
                    if (channel != null) {
                        channel.close();
                    }
                    if (fileChannel2 != null) {
                        fileChannel2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel2 = channel;
                    fileChannel = fileChannel2;
                    if (fileChannel2 != null) {
                    }
                    if (fileChannel != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        }
    }
}
