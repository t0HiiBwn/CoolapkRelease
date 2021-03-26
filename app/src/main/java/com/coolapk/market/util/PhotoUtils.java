package com.coolapk.market.util;

import android.app.Application;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.bumptech.glide.load.model.GlideUrl;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.LibraryExtentsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.network.Result;
import com.coolapk.market.widget.Toast;
import com.hjq.permissions.XXPermissions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.io.FileUtils;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class PhotoUtils {
    public static boolean isCover(int i, int i2) {
        return ((float) i) / ((float) i2) >= 1.778f;
    }

    public static boolean isRight(int i, int i2) {
        return ((float) i) / ((float) i2) < 1.778f;
    }

    public static File getWebViewSaveCacheFile(String str) {
        return new File(new File(DataManager.getInstance().getDataConfig().getCacheDir(), "webviewCache"), String.format("%08x", Integer.valueOf(str.hashCode())));
    }

    public static Observable<File> saveImageObservable(final GlideUrl glideUrl, String str, boolean z) {
        return LibraryExtentsKt.asObservable(XXPermissions.with(UiUtils.getActivityNullable(AppHolder.getCurrentActivity())).permission("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")).flatMap(new Func1<Boolean, Observable<GlideUrl>>() {
            /* class com.coolapk.market.util.PhotoUtils.AnonymousClass1 */

            public Observable<GlideUrl> call(Boolean bool) {
                return Observable.just(glideUrl);
            }
        }).observeOn(Schedulers.io()).map(new Func1(str, z) {
            /* class com.coolapk.market.util.$$Lambda$PhotoUtils$ofubvN5GIUz4ptul_GvceseaDI */
            public final /* synthetic */ String f$0;
            public final /* synthetic */ boolean f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhotoUtils.lambda$saveImageObservable$0(this.f$0, this.f$1, (GlideUrl) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Action0(z) {
            /* class com.coolapk.market.util.$$Lambda$PhotoUtils$6gKpw311EnVBC2l8KqQ9b8xtTE */
            public final /* synthetic */ boolean f$0;

            {
                this.f$0 = r1;
            }

            @Override // rx.functions.Action0
            public final void call() {
                PhotoUtils.lambda$saveImageObservable$1(this.f$0);
            }
        }).doOnError($$Lambda$PhotoUtils$0ejH2UXvJPXm77PvWOkTKJQz7aY.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    static /* synthetic */ File lambda$saveImageObservable$0(String str, boolean z, GlideUrl glideUrl) {
        if (!glideUrl.toStringUrl().isEmpty()) {
            try {
                File file = (File) GlideApp.with(AppHolder.getApplication()).load((Object) glideUrl).downloadOnly(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
                File genSavePath = str == null ? genSavePath(glideUrl.toStringUrl(), file) : new File(str);
                if (genSavePath.exists()) {
                    CoolFileUtils.notifyNewMediaFile(AppHolder.getApplication(), genSavePath);
                    if (!z) {
                        Toast.show(AppHolder.getApplication(), "文件已存在");
                    }
                    return genSavePath;
                }
                FileUtils.copyFile(file, genSavePath);
                CoolFileUtils.notifyNewMediaFile(AppHolder.getApplication(), genSavePath);
                if (!z) {
                    if (!genSavePath.exists() || genSavePath.length() <= 0) {
                        Toast.show(AppHolder.getApplication(), 2131886929);
                    } else {
                        Toast.show(AppHolder.getApplication(), 2131886931);
                    }
                }
                return genSavePath;
            } catch (Exception e) {
                throw Exceptions.propagate(e);
            }
        } else {
            throw new RuntimeException("当前图片链接为空");
        }
    }

    static /* synthetic */ void lambda$saveImageObservable$1(boolean z) {
        if (!z) {
            Toast.show(AppHolder.getApplication(), 2131886932);
        }
    }

    public static Observable<File> saveImages(final List<GlideUrl> list, String str, boolean z) {
        AtomicInteger atomicInteger = new AtomicInteger();
        return LibraryExtentsKt.asObservable(XXPermissions.with(UiUtils.getActivityNullable(AppHolder.getCurrentActivity())).permission("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE")).flatMap(new Func1<Boolean, Observable<GlideUrl>>() {
            /* class com.coolapk.market.util.PhotoUtils.AnonymousClass2 */

            public Observable<GlideUrl> call(Boolean bool) {
                return Observable.from(list);
            }
        }).observeOn(Schedulers.io()).map(new Func1(str, z, atomicInteger) {
            /* class com.coolapk.market.util.$$Lambda$PhotoUtils$ZkwwmwLKPPSbTSeI9Fx6zdMzhEc */
            public final /* synthetic */ String f$0;
            public final /* synthetic */ boolean f$1;
            public final /* synthetic */ AtomicInteger f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhotoUtils.lambda$saveImages$3(this.f$0, this.f$1, this.f$2, (GlideUrl) obj);
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnCompleted(new Action0(list, atomicInteger, z) {
            /* class com.coolapk.market.util.$$Lambda$PhotoUtils$9qwkw57wu9XUdtKzesaJdB5gd5A */
            public final /* synthetic */ List f$0;
            public final /* synthetic */ AtomicInteger f$1;
            public final /* synthetic */ boolean f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            @Override // rx.functions.Action0
            public final void call() {
                PhotoUtils.lambda$saveImages$4(this.f$0, this.f$1, this.f$2);
            }
        }).doOnSubscribe(new Action0(z) {
            /* class com.coolapk.market.util.$$Lambda$PhotoUtils$LEjnCoaRAnv5kYM1E33lJfGZv6U */
            public final /* synthetic */ boolean f$0;

            {
                this.f$0 = r1;
            }

            @Override // rx.functions.Action0
            public final void call() {
                PhotoUtils.lambda$saveImages$5(this.f$0);
            }
        }).doOnError($$Lambda$PhotoUtils$VpiFpVan0SgQ1r_O8P6EU7owtg8.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    static /* synthetic */ File lambda$saveImages$3(String str, boolean z, AtomicInteger atomicInteger, GlideUrl glideUrl) {
        if (!glideUrl.toStringUrl().isEmpty()) {
            try {
                File file = (File) GlideApp.with(AppHolder.getApplication()).load((Object) glideUrl).downloadOnly(Integer.MIN_VALUE, Integer.MIN_VALUE).get();
                File genSavePath = str == null ? genSavePath(glideUrl.toStringUrl(), file) : new File(str);
                if (genSavePath.exists()) {
                    CoolFileUtils.notifyNewMediaFile(AppHolder.getApplication(), genSavePath);
                    if (!z) {
                        Toast.show(AppHolder.getApplication(), "文件已存在");
                    }
                    return genSavePath;
                }
                FileUtils.copyFile(file, genSavePath);
                CoolFileUtils.notifyNewMediaFile(AppHolder.getApplication(), genSavePath);
                if (!genSavePath.exists() || genSavePath.length() <= 0) {
                    atomicInteger.incrementAndGet();
                }
                return genSavePath;
            } catch (Exception e) {
                throw Exceptions.propagate(e);
            }
        } else {
            throw new RuntimeException("当前图片链接为空");
        }
    }

    static /* synthetic */ void lambda$saveImages$4(List list, AtomicInteger atomicInteger, boolean z) {
        int size = list.size() - atomicInteger.get();
        if (!z) {
            Application application = AppHolder.getApplication();
            Toast.show(application, "保存成功" + size + "张，失败" + atomicInteger + "张");
        }
    }

    static /* synthetic */ void lambda$saveImages$5(boolean z) {
        if (!z) {
            Toast.show(AppHolder.getApplication(), 2131886932);
        }
    }

    public static Observable<List<File>> cacheImages(List<String> list) {
        return Observable.from(list).map(new Func1(list) {
            /* class com.coolapk.market.util.$$Lambda$PhotoUtils$6r9TRhOCNh2c2Y9FqhQ3JRX7nY */
            public final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            @Override // rx.functions.Func1
            public final Object call(Object obj) {
                return PhotoUtils.lambda$cacheImages$7(this.f$0, (String) obj);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    static /* synthetic */ List lambda$cacheImages$7(List list, String str) {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(GlideApp.with(AppHolder.getApplication()).load(str).downloadOnly(Integer.MIN_VALUE, Integer.MIN_VALUE).get());
            }
            return arrayList;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } catch (ExecutionException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static File genSavePath(String str, File file) {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file2 = new File(new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_PICTURES), "CoolMarket");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String md5 = StringUtils.toMd5(str);
        String fileType = FileType.getFileType(file.getPath());
        if (TextUtils.isEmpty(fileType)) {
            fileType = MimeTypeMap.getFileExtensionFromUrl(str);
            if (TextUtils.isEmpty(fileType)) {
                fileType = "png";
            }
        }
        return new File(file2, md5 + "." + fileType);
    }

    public static Observable<File> saveImageObservable(String str, boolean z) {
        return saveImageObservable(new GlideUrl(str), null, z);
    }

    public static Observable<File> saveImageObservable(GlideUrl glideUrl, boolean z) {
        return saveImageObservable(glideUrl, null, z);
    }

    public static void addToSplash(String str, final Context context) {
        DataManager.getInstance().addToSplash(str).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new Subscriber<Result<String>>() {
            /* class com.coolapk.market.util.PhotoUtils.AnonymousClass3 */

            @Override // rx.Observer
            public void onCompleted() {
            }

            @Override // rx.Observer
            public void onError(Throwable th) {
                Toast.error(context, th);
            }

            public void onNext(Result<String> result) {
                if (result.getData() != null) {
                    Toast.show(context, "已推荐为启动页");
                } else {
                    Toast.show(context, result.getMessage());
                }
            }
        });
    }

    public static Uri getImageContentUri(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return FileProvider.getUriForFile(context, AppHolder.getAppMetadata().getAuthority(), new File(str));
        }
        Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    return Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, Integer.toString(query.getInt(query.getColumnIndex("_id"))));
                }
            } finally {
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            }
        }
        if (!str.isEmpty()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (query != null && !query.isClosed()) {
                query.close();
            }
            return insert;
        }
        if (query != null && !query.isClosed()) {
            query.close();
        }
        return null;
    }

    public static File getPathToSave(String str) {
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        File file = new File(new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_PICTURES), "CoolMarket");
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canRead()) {
            return null;
        }
        return new File(file, ("IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date())) + "." + MimeTypeMap.getFileExtensionFromUrl(str));
    }

    public static void setWallpaper(Context context, String str) {
        try {
            if (RomUtils.isEmui()) {
                Uri imageContentUri = getImageContentUri(context, str);
                Intent intent = new Intent("android.intent.action.VIEW");
                ComponentName componentName = new ComponentName("com.android.gallery3d", "com.android.gallery3d.app.Wallpaper");
                intent.setDataAndType(imageContentUri, "image/*");
                intent.putExtra("mimeType", "image/*");
                intent.addFlags(1);
                intent.setComponent(componentName);
                CoolFileUtils.grantUriPermission(context, intent, imageContentUri);
                context.startActivity(intent);
            } else if (RomUtils.isMIUI()) {
                Uri imageContentUri2 = getImageContentUri(context, str);
                Intent intent2 = new Intent("miui.intent.action.START_WALLPAPER_DETAIL");
                ComponentName componentName2 = new ComponentName("com.android.thememanager", "com.android.thememanager.activity.WallpaperDetailActivity");
                intent2.setDataAndType(imageContentUri2, "image/*");
                intent2.putExtra("mimeType", "image/*");
                intent2.addFlags(1);
                intent2.setComponent(componentName2);
                CoolFileUtils.grantUriPermission(context, intent2, imageContentUri2);
                context.startActivity(intent2);
            } else if (RomUtils.isOppo()) {
                Uri imageContentUri3 = getImageContentUri(context, str);
                Intent intent3 = new Intent("android.intent.action.VIEW");
                ComponentName componentName3 = new ComponentName("com.coloros.gallery3d", "com.oppo.gallery3d.app.Wallpaper");
                intent3.setDataAndType(imageContentUri3, "image/*");
                intent3.putExtra("mimeType", "image/*");
                intent3.addFlags(1);
                intent3.setComponent(componentName3);
                CoolFileUtils.grantUriPermission(context, intent3, imageContentUri3);
                context.startActivity(intent3);
            } else {
                Uri imageContentUri4 = getImageContentUri(context, str);
                Intent cropAndSetWallpaperIntent = WallpaperManager.getInstance(context).getCropAndSetWallpaperIntent(imageContentUri4);
                CoolFileUtils.grantUriPermission(context, cropAndSetWallpaperIntent, imageContentUri4);
                context.startActivity(cropAndSetWallpaperIntent);
            }
        } catch (Exception unused) {
            try {
                Uri imageContentUri5 = getImageContentUri(context, str);
                Intent cropAndSetWallpaperIntent2 = WallpaperManager.getInstance(context).getCropAndSetWallpaperIntent(imageContentUri5);
                CoolFileUtils.grantUriPermission(context, cropAndSetWallpaperIntent2, imageContentUri5);
                context.startActivity(cropAndSetWallpaperIntent2);
            } catch (Exception unused2) {
                if (CollectionUtils.safeSize(PackageUtils.getWallpaperApps(context, str)) > 0) {
                    setOrdinaryWallpaper(context, str);
                    return;
                }
                try {
                    WallpaperManager.getInstance(context).setStream(new FileInputStream(str));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setOrdinaryWallpaper(Context context, String str) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 24) {
            uri = FileProvider.getUriForFile(context, AppHolder.getAppMetadata().getAuthority(), new File(str));
        } else {
            uri = Uri.fromFile(new File(str));
        }
        Intent intent = new Intent("android.intent.action.ATTACH_DATA");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("mimeType", "image/*");
        intent.addFlags(1);
        CoolFileUtils.grantUriPermission(context, intent, uri);
        context.startActivity(Intent.createChooser(intent, "设置酷图为壁纸"));
    }

    public static void setLockWallPaper(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("SET_LOCKSCREEN_WALLPAPER", true);
        context.startActivity(intent);
    }

    public static boolean isWallpaperSize(String str) {
        String[] widthAndHeight = StringUtils.getWidthAndHeight(str);
        if (Math.min(Integer.parseInt(widthAndHeight[0]), Integer.parseInt(widthAndHeight[1])) >= 720) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0078 A[SYNTHETIC, Splitter:B:39:0x0078] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0082 A[SYNTHETIC, Splitter:B:44:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008f A[SYNTHETIC, Splitter:B:52:0x008f] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0099 A[SYNTHETIC, Splitter:B:57:0x0099] */
    public static String getFileMD5(File file) {
        Throwable th;
        FileInputStream fileInputStream;
        Exception e;
        DigestInputStream digestInputStream;
        DigestInputStream digestInputStream2 = null;
        if (!file.isFile()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                digestInputStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
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
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return sb2;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        e.printStackTrace();
                        if (digestInputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        digestInputStream2 = digestInputStream;
                        if (digestInputStream2 != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                digestInputStream = null;
                e.printStackTrace();
                if (digestInputStream != null) {
                }
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (digestInputStream2 != null) {
                }
                if (fileInputStream != null) {
                }
                throw th;
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
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            if (digestInputStream2 != null) {
                try {
                    digestInputStream2.close();
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
}
