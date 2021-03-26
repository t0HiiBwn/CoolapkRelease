package com.sina.weibo.sdk.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;

public class FileUtils {
    private static final String IMAGE_FILE_START = "image/";
    private static final String VIDEO_FILE_START = "video/";

    private static String getPath(Context context, Uri uri) {
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

    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r8 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r8 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        r8.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003f  */
    private static String getDataColumn(Context context, Uri uri, String str, String[] strArr) {
        Throwable th;
        Cursor cursor;
        Exception e;
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
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = null;
            e.printStackTrace();
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
    }

    private static String getMIMEType(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return "*/*";
        }
        String substring = name.substring(lastIndexOf, name.length());
        if (TextUtils.isEmpty(substring) && substring.length() < 2) {
            return "*/*";
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(substring.substring(1, substring.length()).toLowerCase());
    }

    public static boolean isImageFile(Context context, Uri uri) {
        return getMIMEType(new File(getPath(context, uri))).startsWith("image/");
    }

    public static boolean isVideoFile(Context context, Uri uri) {
        return getMIMEType(new File(getPath(context, uri))).startsWith("video/");
    }
}
