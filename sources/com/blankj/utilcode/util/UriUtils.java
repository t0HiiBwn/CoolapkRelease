package com.blankj.utilcode.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Uri res2Uri(String str) {
        return Uri.parse("android.resource://" + Utils.getApp().getPackageName() + "/" + str);
    }

    public static Uri file2Uri(File file) {
        if (!UtilsBridge.isFileExists(file)) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(Utils.getApp(), Utils.getApp().getPackageName() + ".utilcode.provider", file);
    }

    public static File uri2File(Uri uri) {
        if (uri == null) {
            return null;
        }
        File uri2FileReal = uri2FileReal(uri);
        if (uri2FileReal != null) {
            return uri2FileReal;
        }
        return copyUri2Cache(uri);
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x0245 A[Catch:{ Exception -> 0x029a }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0246 A[Catch:{ Exception -> 0x029a }] */
    private static File uri2FileReal(Uri uri) {
        Uri uri2;
        boolean z;
        File file;
        Log.d("UriUtils", uri.toString());
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (Build.VERSION.SDK_INT >= 24 && path != null) {
            String[] strArr = {"/external/", "/external_path/"};
            for (int i = 0; i < 2; i++) {
                String str = strArr[i];
                if (path.startsWith(str)) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace(str, "/"));
                    if (file2.exists()) {
                        Log.d("UriUtils", uri.toString() + " -> " + str);
                        return file2;
                    }
                }
            }
            if (path.startsWith("/files_path/")) {
                file = new File(Utils.getApp().getFilesDir().getAbsolutePath() + path.replace("/files_path/", "/"));
            } else if (path.startsWith("/cache_path/")) {
                file = new File(Utils.getApp().getCacheDir().getAbsolutePath() + path.replace("/cache_path/", "/"));
            } else if (path.startsWith("/external_files_path/")) {
                file = new File(Utils.getApp().getExternalFilesDir(null).getAbsolutePath() + path.replace("/external_files_path/", "/"));
            } else if (path.startsWith("/external_cache_path/")) {
                file = new File(Utils.getApp().getExternalCacheDir().getAbsolutePath() + path.replace("/external_cache_path/", "/"));
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                Log.d("UriUtils", uri.toString() + " -> " + path);
                return file;
            }
        }
        if ("file".equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 0");
            return null;
        } else if (Build.VERSION.SDK_INT < 19 || !DocumentsContract.isDocumentUri(Utils.getApp(), uri)) {
            if ("content".equals(scheme)) {
                return getFileFromUri(uri, "2");
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 3");
            return null;
        } else if ("com.android.externalstorage.documents".equals(authority)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(":");
            String str2 = split[0];
            if ("primary".equalsIgnoreCase(str2)) {
                return new File(Environment.getExternalStorageDirectory() + "/" + split[1]);
            }
            StorageManager storageManager = (StorageManager) Utils.getApp().getSystemService("storage");
            try {
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                Method method2 = cls.getMethod("getUuid", new Class[0]);
                Method method3 = cls.getMethod("getState", new Class[0]);
                Method method4 = cls.getMethod("getPath", new Class[0]);
                Method method5 = cls.getMethod("isPrimary", new Class[0]);
                Method method6 = cls.getMethod("isEmulated", new Class[0]);
                Object invoke = method.invoke(storageManager, new Object[0]);
                int length = Array.getLength(invoke);
                int i2 = 0;
                while (i2 < length) {
                    Object obj = Array.get(invoke, i2);
                    if (!"mounted".equals(method3.invoke(obj, new Object[0]))) {
                        if (!"mounted_ro".equals(method3.invoke(obj, new Object[0]))) {
                            z = false;
                            if (!z) {
                                if (!((Boolean) method5.invoke(obj, new Object[0])).booleanValue() || !((Boolean) method6.invoke(obj, new Object[0])).booleanValue()) {
                                    String str3 = (String) method2.invoke(obj, new Object[0]);
                                    if (str3 != null && str3.equals(str2)) {
                                        return new File(method4.invoke(obj, new Object[0]) + "/" + split[1]);
                                    }
                                }
                            }
                            i2++;
                            invoke = invoke;
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    i2++;
                    invoke = invoke;
                }
            } catch (Exception e) {
                Log.d("UriUtils", uri.toString() + " parse failed. " + e.toString() + " -> 1_0");
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 1_0");
            return null;
        } else if ("com.android.providers.downloads.documents".equals(authority)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if (TextUtils.isEmpty(documentId)) {
                Log.d("UriUtils", uri.toString() + " parse failed(id is null). -> 1_1");
                return null;
            } else if (documentId.startsWith("raw:")) {
                return new File(documentId.substring(4));
            } else {
                if (documentId.startsWith("msf:")) {
                    documentId = documentId.split(":")[1];
                }
                try {
                    long parseLong = Long.parseLong(documentId);
                    String[] strArr2 = {"content://downloads/public_downloads", "content://downloads/all_downloads", "content://downloads/my_downloads"};
                    for (int i3 = 0; i3 < 3; i3++) {
                        try {
                            File fileFromUri = getFileFromUri(ContentUris.withAppendedId(Uri.parse(strArr2[i3]), parseLong), "1_1");
                            if (fileFromUri != null) {
                                return fileFromUri;
                            }
                        } catch (Exception unused) {
                        }
                    }
                    Log.d("UriUtils", uri.toString() + " parse failed. -> 1_1");
                    return null;
                } catch (Exception unused2) {
                    return null;
                }
            }
        } else if ("com.android.providers.media.documents".equals(authority)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
            String str4 = split2[0];
            if ("image".equals(str4)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str4)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str4)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            } else {
                Log.d("UriUtils", uri.toString() + " parse failed. -> 1_2");
                return null;
            }
            return getFileFromUri(uri2, "_id=?", new String[]{split2[1]}, "1_2");
        } else if ("content".equals(scheme)) {
            return getFileFromUri(uri, "1_3");
        } else {
            Log.d("UriUtils", uri.toString() + " parse failed. -> 1_4");
            return null;
        }
    }

    private static File getFileFromUri(Uri uri, String str) {
        return getFileFromUri(uri, null, null, str);
    }

    private static File getFileFromUri(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor query = Utils.getApp().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        if (query == null) {
            Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + str2);
            return null;
        }
        try {
            if (query.moveToFirst()) {
                int columnIndex = query.getColumnIndex("_data");
                if (columnIndex > -1) {
                    return new File(query.getString(columnIndex));
                }
                Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + str2);
                query.close();
                return null;
            }
            Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + str2);
            query.close();
            return null;
        } catch (Exception unused) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + str2);
            return null;
        } finally {
            query.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056 A[SYNTHETIC, Splitter:B:19:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[SYNTHETIC, Splitter:B:26:0x0062] */
    private static File copyUri2Cache(Uri uri) {
        InputStream inputStream;
        Throwable th;
        FileNotFoundException e;
        Log.d("UriUtils", "copyUri2Cache() called");
        try {
            inputStream = Utils.getApp().getContentResolver().openInputStream(uri);
            try {
                File file = new File(Utils.getApp().getCacheDir(), "" + System.currentTimeMillis());
                UtilsBridge.writeFileFromIS(file.getAbsolutePath(), inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return file;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (inputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            inputStream = null;
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0040 A[SYNTHETIC, Splitter:B:28:0x0040] */
    public static byte[] uri2Bytes(Uri uri) {
        InputStream inputStream;
        Throwable th;
        FileNotFoundException e;
        if (uri == null) {
            return null;
        }
        try {
            inputStream = Utils.getApp().getContentResolver().openInputStream(uri);
            try {
                byte[] inputStream2Bytes = UtilsBridge.inputStream2Bytes(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return inputStream2Bytes;
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    Log.d("UriUtils", "uri to bytes failed.");
                    if (inputStream != null) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            inputStream = null;
            e.printStackTrace();
            Log.d("UriUtils", "uri to bytes failed.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            throw th;
        }
    }
}
