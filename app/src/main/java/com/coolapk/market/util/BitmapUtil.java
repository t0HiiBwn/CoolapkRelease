package com.coolapk.market.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import com.coolapk.market.model.ImageUrl;
import com.coolapk.market.network.CoolApkRuntimeException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.io.IOUtils;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public class BitmapUtil {
    private static final int BITMAP_MAX_ALLOW_PNG_SIZE = 2097152;
    private static final int BITMAP_MAX_PIXEL = 8294400;
    private static final int BITMAP_MAX_SIZE = 2097152;
    public static final int FLAG_ALLOW_COMPRESS_TO_PNG = 4;
    public static final int FLAG_PNG_IMAGE = 2;
    public static final int FLAG_WALLPAPER = 1;
    public static final String IMAGE_CACHE_DIR = "image_cache";

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int width = !drawable.getBounds().isEmpty() ? drawable.getBounds().width() : drawable.getIntrinsicWidth();
        int height = !drawable.getBounds().isEmpty() ? drawable.getBounds().height() : drawable.getIntrinsicHeight();
        if (width <= 0) {
            width = 1;
        }
        if (height <= 0) {
            height = 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public static void cropImageNew(Context context, Uri uri, File file, int i) throws Exception {
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        OutOfMemoryError e;
        Uri uri2;
        FileOutputStream fileOutputStream2 = 0;
        if (context == null) {
            throw new CoolApkRuntimeException("压缩图片失败，context is null");
        } else if (uri != null) {
            try {
                if ("file".equals(uri.getScheme())) {
                    File unwrapToFile = CoolFileUtils.unwrapToFile(uri);
                    if (isValidBitmapFile(unwrapToFile.getAbsolutePath())) {
                        uri2 = Uri.fromFile(unwrapToFile);
                    } else {
                        throw new CoolApkRuntimeException("压缩图片失败，源文件为空文件");
                    }
                } else {
                    uri2 = uri;
                }
                Context applicationContext = context.getApplicationContext();
                InputStream openInputStream = applicationContext.getContentResolver().openInputStream(uri2);
                if (openInputStream != null) {
                    int available = openInputStream.available();
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    boolean z = true;
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeStream(openInputStream, null, options);
                    IOUtils.closeQuietly(openInputStream);
                    inputStream = applicationContext.getContentResolver().openInputStream(uri2);
                    if (inputStream != null) {
                        boolean z2 = available <= 2097152;
                        if (z2) {
                            i |= 4;
                        }
                        boolean z3 = (i & 1) > 0;
                        if (available >= 2097152 || !z3) {
                            inputStream = compressImageToStream(options, inputStream, i);
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                        } catch (OutOfMemoryError e2) {
                            e = e2;
                            fileOutputStream = null;
                            fileOutputStream2 = inputStream;
                            try {
                                throw new RuntimeException(e);
                            } catch (Throwable th2) {
                                th = th2;
                                inputStream = fileOutputStream2;
                                fileOutputStream2 = fileOutputStream;
                                IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                                IOUtils.closeQuietly(inputStream);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                            IOUtils.closeQuietly(inputStream);
                            throw th;
                        }
                        try {
                            int rotationDegree = getRotationDegree(getPath(applicationContext, uri));
                            if (rotationDegree > 0) {
                                Bitmap rotateBitmap = rotateBitmap(BitmapFactory.decodeStream(inputStream), rotationDegree);
                                if ((i & 2) <= 0 || !rotateBitmap.hasAlpha()) {
                                    z = false;
                                }
                                rotateBitmap.compress((!z || !z2) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            } else {
                                IOUtils.copyLarge(inputStream, fileOutputStream);
                            }
                            if (isValidBitmapFile(file.getAbsolutePath())) {
                                IOUtils.closeQuietly((OutputStream) fileOutputStream);
                                IOUtils.closeQuietly(inputStream);
                                return;
                            }
                            throw new CoolApkRuntimeException("压缩图片失败, 请重试");
                        } catch (OutOfMemoryError e3) {
                            e = e3;
                            fileOutputStream2 = inputStream;
                            throw new RuntimeException(e);
                        } catch (Throwable th4) {
                            th = th4;
                            fileOutputStream2 = fileOutputStream;
                            IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                            IOUtils.closeQuietly(inputStream);
                            throw th;
                        }
                    } else {
                        throw new CoolApkRuntimeException("压缩图片失败，sourceStream is null");
                    }
                } else {
                    throw new CoolApkRuntimeException("压缩图片失败，sourceStream is null");
                }
            } catch (OutOfMemoryError e4) {
                e = e4;
                fileOutputStream = null;
                throw new RuntimeException(e);
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                IOUtils.closeQuietly((OutputStream) fileOutputStream2);
                IOUtils.closeQuietly(inputStream);
                throw th;
            }
        } else {
            throw new CoolApkRuntimeException("压缩图片失败，data is null");
        }
    }

    private static InputStream compressImageToStream(BitmapFactory.Options options, InputStream inputStream, int i) {
        int i2;
        boolean z = false;
        boolean z2 = (i & 1) > 0;
        int i3 = z2 ? 100 : 80;
        int i4 = 8294400;
        calculateInSampleSize(options);
        options.inJustDecodeBounds = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
        IOUtils.closeQuietly(inputStream);
        boolean z3 = options.outWidth * options.outHeight > 8294400;
        if (z3) {
            decodeStream = scaleBitmap(decodeStream, 8294400);
            i2 = 1;
        } else {
            i2 = 0;
        }
        boolean z4 = (i & 4) > 0;
        if (((i & 2) > 0 && decodeStream.hasAlpha()) && z4) {
            z = true;
        }
        Bitmap.CompressFormat compressFormat = z ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decodeStream.compress(compressFormat, i3, byteArrayOutputStream);
        int i5 = 1048576;
        if (z2 || z3 || z) {
            i5 = 2097152;
        }
        while (true) {
            if (byteArrayOutputStream.size() <= i5) {
                break;
            }
            byteArrayOutputStream.reset();
            i3 -= 10;
            if (i3 <= 60) {
                if (i2 >= 2) {
                    decodeStream.compress(compressFormat, i3, byteArrayOutputStream);
                    break;
                }
                i2++;
                i4 /= 2;
                i3 = 80;
                decodeStream = scaleBitmap(decodeStream, i4);
            }
            decodeStream.compress(compressFormat, i3, byteArrayOutputStream);
        }
        System.gc();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        IOUtils.closeQuietly((OutputStream) byteArrayOutputStream);
        return byteArrayInputStream;
    }

    private static void calculateInSampleSize(BitmapFactory.Options options) {
        int i = options.outWidth;
        options.inSampleSize = 1;
        for (int i2 = options.outHeight; i * i2 > 16588800; i2 /= 2) {
            options.inSampleSize *= 2;
            i /= 2;
        }
    }

    public static int getRotationDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return 270;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    private static Bitmap scaleBitmap(Bitmap bitmap, int i) {
        int i2;
        float width = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
        int i3 = 720;
        if (width < 1.0f) {
            int sqrt = (int) Math.sqrt((double) (((float) i) * width));
            if (sqrt >= 720 || bitmap.getWidth() <= 720) {
                i3 = sqrt;
            }
            i2 = (int) (((float) i3) / width);
        } else {
            int sqrt2 = (int) Math.sqrt((double) (((float) i) / width));
            if (sqrt2 >= 720 || bitmap.getHeight() <= 720) {
                i3 = sqrt2;
            }
            i3 = (int) (((float) i3) * width);
            i2 = i3;
        }
        return Bitmap.createScaledBitmap(bitmap, i3, i2, true);
    }

    private static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap makeCircle(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        createBitmap.recycle();
        return createBitmap2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r2.mkdirs() == false) goto L_0x0047;
     */
    public static String getCacheDirPath(Context context) {
        File file;
        Exception e;
        File file2 = null;
        try {
            if (StorageUtils.isExternalStorageWritable()) {
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                file = new File(externalStorageDirectory.getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/cache");
                try {
                    if (!file.exists()) {
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    file2 = file;
                    file2 = context.getCacheDir();
                    return file2.getAbsolutePath();
                }
                file2 = file;
            }
        } catch (Exception e3) {
            file = null;
            e = e3;
            e.printStackTrace();
            file2 = file;
            file2 = context.getCacheDir();
            return file2.getAbsolutePath();
        }
        if (file2 == null && (file2 = context.getExternalCacheDir()) == null) {
            file2 = context.getCacheDir();
        }
        return file2.getAbsolutePath();
    }

    public static String getImageCacheDirPath(Context context) {
        File file = new File(getCacheDirPath(context), "image_cache");
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isFile()) {
            file.delete();
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String generateFileOutputPath(Context context, String str) {
        return new File(getImageCacheDirPath(context), StringUtils.toMd5(str)).getAbsolutePath();
    }

    public static String getPath(Context context, Uri uri) {
        return ImageFilePathUtils.getPath(context, uri);
    }

    public static Bitmap getIconBitmap(Context context, String str) {
        Drawable iconDrawable = getIconDrawable(context, str);
        if (iconDrawable != null) {
            return drawableToBitmap(iconDrawable);
        }
        return null;
    }

    public static Drawable getIconDrawable(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationIcon(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean saveBitmapToFile(File file, Bitmap bitmap, Boolean bool) {
        if (bitmap == null) {
            return false;
        }
        if (file.exists()) {
            if (!bool.booleanValue()) {
                return false;
            }
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Observable<ImageUrl> compressImage(final Context context, String str, final int i) {
        return Observable.just(str).map(new Func1<String, ImageUrl>() {
            /* class com.coolapk.market.util.BitmapUtil.AnonymousClass1 */

            public ImageUrl call(String str) {
                try {
                    String path = Uri.parse(str).getPath();
                    int i = i;
                    if (CoolFileUtils.isGifFile(path)) {
                        return ImageUrl.create(str, str);
                    }
                    if (path.startsWith(BitmapUtil.getCacheDirPath(context))) {
                        return ImageUrl.create(str, str);
                    }
                    String fileMd5 = CoolFileUtils.getFileMd5(path);
                    Context context = context;
                    String generateFileOutputPath = BitmapUtil.generateFileOutputPath(context, path + fileMd5);
                    if (CoolFileUtils.isPNGFile(Uri.parse(str).getPath())) {
                        i |= 2;
                    }
                    BitmapUtil.cropImageNew(context, Uri.parse(str), new File(generateFileOutputPath), i);
                    return ImageUrl.create(str, CoolFileUtils.wrap(generateFileOutputPath));
                } catch (Throwable th) {
                    throw Exceptions.propagate(th);
                }
            }
        });
    }

    public static File createBitmapSavePath() {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file = new File(new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_PICTURES), "CoolMarket");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canRead()) {
            return null;
        }
        return new File(file, ("IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date())) + ".png");
    }

    public static String getImageSize(Context context, String str) {
        InputStream inputStream;
        Uri parse = Uri.parse(str);
        StringBuilder sb = new StringBuilder();
        try {
            inputStream = context.getApplicationContext().getContentResolver().openInputStream(parse);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            inputStream = null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }

    public static Bitmap getBitmapByFile(String str) {
        try {
            return BitmapFactory.decodeFile(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean isValidBitmapFile(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return !(options.mCancel || options.outWidth == -1 || options.outHeight == -1);
    }

    public static boolean isValidBitmapUri(Context context, Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return !(options.mCancel || options.outWidth == -1 || options.outHeight == -1);
    }
}
