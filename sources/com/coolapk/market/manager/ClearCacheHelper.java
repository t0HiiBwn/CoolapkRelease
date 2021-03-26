package com.coolapk.market.manager;

import android.app.Application;
import android.os.Looper;
import com.coolapk.market.AppHolder;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.widget.video.VideoManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AgeFileFilter;
import org.apache.commons.io.filefilter.FalseFileFilter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0007J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\u0006\u0010\u0011\u001a\u00020\bH\u0007R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/manager/ClearCacheHelper;", "", "()V", "CACHE_DIRS", "", "Ljava/io/File;", "[Ljava/io/File;", "CLEAR_TYPE_ALL", "", "CLEAR_TYPE_RECENT", "FEED_IMAGE_DIR", "GLIDE_IMAGE_DIR", "OLD_OKHTTP_IMAGE_DIR", "VIDEO_DIR", "clearAllDiskCache", "", "clearCacheAndGC", "type", "clearDiskCache", "clearDiskCacheTask", "clearMemoryCache", "clearRecentDiskCache", "newClearCacheTask", "Lrx/Observable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ClearCacheHelper.kt */
public final class ClearCacheHelper {
    private static final File[] CACHE_DIRS;
    public static final String CLEAR_TYPE_ALL = "clear_all";
    public static final String CLEAR_TYPE_RECENT = "clear_recent";
    private static final File FEED_IMAGE_DIR;
    private static final File GLIDE_IMAGE_DIR;
    public static final ClearCacheHelper INSTANCE = new ClearCacheHelper();
    private static final File OLD_OKHTTP_IMAGE_DIR = new File(BitmapUtil.getImageCacheDirPath(AppHolder.getApplication()));
    private static final File VIDEO_DIR;

    static {
        File photoCacheDir = GlideApp.getPhotoCacheDir(AppHolder.getApplication());
        GLIDE_IMAGE_DIR = photoCacheDir;
        File file = new File(BitmapUtil.getImageCacheDirPath(AppHolder.getApplication()));
        FEED_IMAGE_DIR = file;
        VideoManager videoManager = VideoManager.INSTANCE;
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        File videoCacheDir = videoManager.getVideoCacheDir(application);
        VIDEO_DIR = videoCacheDir;
        CACHE_DIRS = new File[]{photoCacheDir, file, videoCacheDir};
    }

    private ClearCacheHelper() {
    }

    @JvmStatic
    public static final void clearDiskCacheTask() {
        Observable.just("clear_all").observeOn(Schedulers.io()).doOnNext(ClearCacheHelper$clearDiskCacheTask$1.INSTANCE).map(ClearCacheHelper$clearDiskCacheTask$2.INSTANCE).doOnSubscribe(ClearCacheHelper$clearDiskCacheTask$3.INSTANCE).subscribe((Subscriber) new ClearCacheHelper$clearDiskCacheTask$4());
    }

    @JvmStatic
    public static final void clearCacheAndGC(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        newClearCacheTask(str).subscribe((Subscriber<? super Object>) new ClearCacheHelper$clearCacheAndGC$1());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r4.equals(r2) != false) goto L_0x0025;
     */
    @JvmStatic
    public static final Observable<Object> newClearCacheTask(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        int hashCode = str.hashCode();
        String str2 = "clear_all";
        if (hashCode != -1270583121) {
            if (hashCode == 85085325) {
                str.equals("clear_recent");
            }
        }
        str2 = "clear_recent";
        boolean areEqual = Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
        if (areEqual) {
            INSTANCE.clearMemoryCache();
        }
        Observable just = Observable.just(str2);
        if (!areEqual) {
            just = just.observeOn(AndroidSchedulers.mainThread()).doOnNext(ClearCacheHelper$newClearCacheTask$1.INSTANCE);
        }
        Observable<Object> map = just.observeOn(Schedulers.io()).doOnNext(ClearCacheHelper$newClearCacheTask$2.INSTANCE).map(ClearCacheHelper$newClearCacheTask$3.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(map, "observale.observeOn(Sche… .map { return@map null }");
        return map;
    }

    /* access modifiers changed from: private */
    public final void clearMemoryCache() {
        AppHolder.getContextImageLoader().clearMemoryCache(AppHolder.getApplication());
    }

    /* access modifiers changed from: private */
    public final void clearDiskCache(String str) {
        try {
            int hashCode = str.hashCode();
            if (hashCode != -1270583121) {
                if (hashCode == 85085325) {
                    if (str.equals("clear_recent")) {
                        clearRecentDiskCache();
                    }
                }
            } else if (str.equals("clear_all")) {
                clearAllDiskCache();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void clearAllDiskCache() {
        File[] fileArr = CACHE_DIRS;
        for (File file : fileArr) {
            if (file != null && file.isDirectory() && file.exists()) {
                FileUtils.cleanDirectory(file);
            }
        }
    }

    private final void clearRecentDiskCache() {
        long currentTimeMillis = System.currentTimeMillis() - 86400000;
        File[] fileArr = (File[]) ArraysKt.plus(CACHE_DIRS, OLD_OKHTTP_IMAGE_DIR);
        for (File file : fileArr) {
            if (file != null && file.isDirectory() && file.exists()) {
                for (File file2 : FileUtils.listFiles(file, new AgeFileFilter(currentTimeMillis, true), FalseFileFilter.INSTANCE)) {
                    FileUtils.deleteQuietly(file2);
                }
            }
        }
    }
}
