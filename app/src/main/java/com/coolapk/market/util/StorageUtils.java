package com.coolapk.market.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StorageUtils {
    public static Uri save(Context context, File file, Bitmap bitmap) throws IOException {
        if (bitmap == null) {
            return null;
        }
        if (file.exists()) {
            file.delete();
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        } else if (!parentFile.isDirectory()) {
            parentFile.delete();
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
        fileOutputStream.flush();
        fileOutputStream.close();
        return Uri.fromFile(file);
    }

    public static boolean isExternalStorageWritable() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        return "mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState);
    }

    public static Uri saveToCache(Context context, Bitmap bitmap) throws IOException {
        Context applicationContext = context.getApplicationContext();
        File externalCacheDir = applicationContext.getExternalCacheDir();
        if (externalCacheDir == null || !externalCacheDir.canWrite()) {
            externalCacheDir = applicationContext.getCacheDir();
        }
        File file = new File(externalCacheDir, "CM_" + CoolFileUtils.createRandomFileName("jpg"));
        if (file.exists()) {
            file.delete();
        }
        return save(applicationContext, file, bitmap);
    }
}
