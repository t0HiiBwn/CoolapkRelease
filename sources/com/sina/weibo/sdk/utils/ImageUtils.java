package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.media.MediaMetadataRetriever;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageUtils {
    private static void revitionImageSizeHD(String str, int i, int i2) throws IOException {
        Bitmap createBitmap;
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        } else if (!isFileExisted(str)) {
            if (str == null) {
                str = "null";
            }
            throw new FileNotFoundException(str);
        } else if (BitmapHelper.verifyBitmap(str)) {
            int i3 = i * 2;
            FileInputStream fileInputStream = new FileInputStream(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i4 = 0;
            while (true) {
                if ((options.outWidth >> i4) <= i3 && (options.outHeight >> i4) <= i3) {
                    break;
                }
                i4++;
            }
            options.inSampleSize = (int) Math.pow(2.0d, (double) i4);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile != null) {
                deleteDependon(str);
                makesureFileExist(str);
                float width = ((float) i) / ((float) (safeDecodeBimtapFile.getWidth() > safeDecodeBimtapFile.getHeight() ? safeDecodeBimtapFile.getWidth() : safeDecodeBimtapFile.getHeight()));
                if (width < 1.0f) {
                    while (true) {
                        try {
                            createBitmap = Bitmap.createBitmap((int) (((float) safeDecodeBimtapFile.getWidth()) * width), (int) (((float) safeDecodeBimtapFile.getHeight()) * width), Bitmap.Config.ARGB_8888);
                            break;
                        } catch (OutOfMemoryError unused) {
                            System.gc();
                            width = (float) (((double) width) * 0.8d);
                        }
                    }
                    if (createBitmap == null) {
                        safeDecodeBimtapFile.recycle();
                    }
                    Canvas canvas = new Canvas(createBitmap);
                    Matrix matrix = new Matrix();
                    matrix.setScale(width, width);
                    canvas.drawBitmap(safeDecodeBimtapFile, matrix, new Paint());
                    safeDecodeBimtapFile.recycle();
                    safeDecodeBimtapFile = createBitmap;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                if (options.outMimeType == null || !options.outMimeType.contains("png")) {
                    safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                } else {
                    safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
                }
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                safeDecodeBimtapFile.recycle();
                return;
            }
            throw new IOException("Bitmap decode error!");
        } else {
            throw new IOException("");
        }
    }

    private static void revitionImageSize(String str, int i, int i2) throws IOException {
        if (i <= 0) {
            throw new IllegalArgumentException("size must be greater than 0!");
        } else if (!isFileExisted(str)) {
            if (str == null) {
                str = "null";
            }
            throw new FileNotFoundException(str);
        } else if (BitmapHelper.verifyBitmap(str)) {
            FileInputStream fileInputStream = new FileInputStream(str);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(fileInputStream, null, options);
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int i3 = 0;
            while (true) {
                if ((options.outWidth >> i3) <= i && (options.outHeight >> i3) <= i) {
                    break;
                }
                i3++;
            }
            options.inSampleSize = (int) Math.pow(2.0d, (double) i3);
            options.inJustDecodeBounds = false;
            Bitmap safeDecodeBimtapFile = safeDecodeBimtapFile(str, options);
            if (safeDecodeBimtapFile != null) {
                deleteDependon(str);
                makesureFileExist(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                if (options.outMimeType == null || !options.outMimeType.contains("png")) {
                    safeDecodeBimtapFile.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                } else {
                    safeDecodeBimtapFile.compress(Bitmap.CompressFormat.PNG, i2, fileOutputStream);
                }
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                safeDecodeBimtapFile.recycle();
                return;
            }
            throw new IOException("Bitmap decode error!");
        } else {
            throw new IOException("");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r5 = r4;
        r4 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:6:0x0013] */
    private static Bitmap safeDecodeBimtapFile(String str, BitmapFactory.Options options) {
        BitmapFactory.Options options2;
        FileInputStream fileInputStream;
        if (options == null) {
            options2 = new BitmapFactory.Options();
            options2.inSampleSize = 1;
        } else {
            options2 = options;
        }
        int i = 0;
        Bitmap bitmap = null;
        FileInputStream fileInputStream2 = null;
        while (true) {
            if (i >= 5) {
                break;
            }
            try {
                fileInputStream = new FileInputStream(str);
                bitmap = BitmapFactory.decodeStream(fileInputStream, null, options);
                try {
                    fileInputStream.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (OutOfMemoryError e2) {
                OutOfMemoryError e3 = e2;
                e3.printStackTrace();
                options2.inSampleSize *= 2;
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                i++;
                fileInputStream2 = fileInputStream;
            } catch (FileNotFoundException unused) {
            }
            i++;
            fileInputStream2 = fileInputStream;
        }
        return bitmap;
    }

    private static void delete(File file) {
        if (file != null && file.exists() && !file.delete()) {
            throw new RuntimeException(file.getAbsolutePath() + " doesn't be deleted!");
        }
    }

    private static boolean deleteDependon(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        int i = 1;
        while (!z && i <= 5 && file.isFile() && file.exists()) {
            z = file.delete();
            if (!z) {
                i++;
            }
        }
        return z;
    }

    private static boolean isFileExisted(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            return true;
        }
        return false;
    }

    private static boolean isParentExist(File file) {
        File parentFile;
        if (file == null || (parentFile = file.getParentFile()) == null || parentFile.exists()) {
            return false;
        }
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        return false;
    }

    public static long getVideoDuring(String str) {
        if (!new File(str).exists()) {
            return 0;
        }
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            return Long.parseLong(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception unused) {
            return 0;
        }
    }

    private static void makesureFileExist(String str) {
        if (str != null) {
            File file = new File(str);
            if (!file.exists() && isParentExist(file)) {
                if (file.exists()) {
                    delete(file);
                }
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
