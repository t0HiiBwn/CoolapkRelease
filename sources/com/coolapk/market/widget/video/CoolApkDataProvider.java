package com.coolapk.market.widget.video;

import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Video;
import com.coolapk.market.model.VideoUrls;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.BundlePool;
import com.kk.taurus.playerbase.provider.BaseDataProvider;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* compiled from: CoolApkDataProvider.kt */
public final class CoolApkDataProvider extends BaseDataProvider {
    private final AtomicInteger loadingVideoModelKey;
    private HashMap<String, String> pendingHeader;
    private final SparseArray<DataSource> resultDataSource;
    private Subscription subscription;
    private final boolean useDataSourceCache;
    private final boolean useVideoCache;
    private final SparseArray<VideoModel> videoModelArray;

    public CoolApkDataProvider() {
        this(false, false, 3, null);
    }

    public final String getProxyUrl(String str, boolean z) {
        return str;
    }

    public CoolApkDataProvider(boolean z, boolean z2) {
        this.useDataSourceCache = z;
        this.useVideoCache = z2;
        this.videoModelArray = new SparseArray<>();
        this.resultDataSource = new SparseArray<>();
        this.loadingVideoModelKey = new AtomicInteger(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CoolApkDataProvider(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2);
    }

    public final boolean getUseDataSourceCache() {
        return this.useDataSourceCache;
    }

    public final boolean getUseVideoCache() {
        return this.useVideoCache;
    }

    public final void addToPendingParseList(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        this.videoModelArray.put(videoModel.getKey(), videoModel);
    }

    public final void invalidVideoModelResult(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        this.resultDataSource.delete(videoModel.getKey());
    }

    @Override // com.kk.taurus.playerbase.provider.IDataProvider
    public void handleSourceData(DataSource dataSource) {
        onProviderDataStart();
        if (dataSource == null) {
            callProviderError(-118, null);
            return;
        }
        this.loadingVideoModelKey.set(VideoModelKt.getVideoModelKey(dataSource));
        LogUtils.d("setInvalidateLoadingKey " + VideoModelKt.getVideoModelKey(dataSource), new Object[0]);
        DataSource dataSource2 = this.resultDataSource.get(VideoModelKt.getVideoModelKey(dataSource));
        if (dataSource2 == null || !this.useDataSourceCache) {
            VideoModel videoModel = this.videoModelArray.get(VideoModelKt.getVideoModelKey(dataSource));
            if (videoModel == null) {
                callProviderError(-118, null);
            } else {
                loadVideoModel(videoModel, dataSource);
            }
        } else {
            dataSource2.setStartPos(dataSource.getStartPos());
            callProviderDataSource(dataSource2);
        }
    }

    private final void loadVideoModel(VideoModel videoModel, DataSource dataSource) {
        if (videoModel.getUrl().length() > 0) {
            DataSource dataSource2 = new DataSource();
            dataSource2.setExtra(videoModel.getHeaderMapClone());
            dataSource2.setTitle(videoModel.getTitle());
            dataSource2.setLive(videoModel.isLive());
            dataSource2.setUri(Uri.parse(getProxyUrl(videoModel.getUrl(), dataSource2.isLive())));
            dataSource2.setStartPos(dataSource.getStartPos());
            dataSource2.setId(dataSource.getId());
            this.resultDataSource.put(VideoModelKt.getVideoModelKey(dataSource), dataSource2);
            callProviderDataSource(dataSource2);
            return;
        }
        Entity relatedEntity = videoModel.getRelatedEntity();
        Video findVideo = relatedEntity != null ? VideoModelKt.findVideo(relatedEntity, videoModel) : null;
        if (findVideo != null) {
            try {
                loadVideoDataSource(videoModel, findVideo, dataSource);
            } catch (Exception e) {
                e.printStackTrace();
                callProviderError(-119, e);
            }
        } else {
            callProviderError(-118, null);
        }
    }

    private final void loadVideoDataSource(VideoModel videoModel, Video video, DataSource dataSource) {
        String str;
        if (videoModel.getTagKey().length() > 0) {
            str = videoModel.getTagKey();
        } else {
            str = VideoModelKt.findDefaultParamsKey(video);
        }
        String str2 = (String) MapsKt.getValue(VideoModelKt.getRequestParamsMap(video), str);
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = loadPlayerUrlObservable(str2, video).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber<? super R>) new CoolApkDataProvider$loadVideoDataSource$2(this, videoModel, dataSource));
    }

    public final void callProviderDataSource(DataSource dataSource) {
        if (VideoModelKt.getVideoModelKey(dataSource) != this.loadingVideoModelKey.get()) {
            AppHolder.getThirdPartUtils().markException(new VideoLoadMismatchException("VideoPlayer invalidate loading key, videoModel is " + this.videoModelArray.get(VideoModelKt.getVideoModelKey(dataSource)) + ", dataSource is " + dataSource));
            callProviderError(-118, null);
            return;
        }
        this.pendingHeader = dataSource.getExtra();
        Bundle obtain = BundlePool.obtain();
        obtain.putSerializable("serializable_data", dataSource);
        onProviderMediaDataSuccess(obtain);
        setInvalidateLoadingKey();
    }

    public final void callProviderError(int i, Throwable th) {
        if (this.loadingVideoModelKey.get() != 0) {
            Bundle bundle = null;
            if (th != null) {
                bundle = BundlePool.obtain();
                bundle.putSerializable("serializable_extra_data", th);
            }
            onProviderError(i, bundle);
            setInvalidateLoadingKey();
        }
    }

    @Override // com.kk.taurus.playerbase.provider.IDataProvider
    public void cancel() {
        setInvalidateLoadingKey();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = null;
    }

    @Override // com.kk.taurus.playerbase.provider.IDataProvider
    public void destroy() {
        cancel();
    }

    private final void setInvalidateLoadingKey() {
        LogUtils.d("setInvalidateLoadingKey 0", new Object[0]);
        this.loadingVideoModelKey.set(0);
    }

    public final File buildConcatFile(VideoUrls videoUrls, boolean z) {
        VideoManager videoManager = VideoManager.INSTANCE;
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        File videoCacheDir = videoManager.getVideoCacheDir(application);
        videoCacheDir.mkdirs();
        File file = new File(videoCacheDir, StringUtils.toMd5(videoUrls.toString()) + ".ffconcat");
        PrintStream printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
        printStream.print("ffconcat version 1.0\n");
        for (int i = 0; i < videoUrls.getUrlList().size(); i++) {
            String str = videoUrls.getUrlList().get(i);
            Intrinsics.checkNotNullExpressionValue(str, "urls.urlList[index]");
            String proxyUrl = getProxyUrl(str, z);
            List<Integer> durationList = videoUrls.getDurationList();
            Intrinsics.checkNotNullExpressionValue(durationList, "urls.durationList");
            Integer num = (Integer) CollectionsKt.getOrNull(durationList, i);
            printStream.print("file " + proxyUrl + '\n');
            if (num != null) {
                printStream.print("duration " + (((float) num.intValue()) / ((float) 1000)) + '\n');
            }
        }
        printStream.flush();
        printStream.close();
        return file;
    }

    private final Observable<DataSource> loadPlayerUrlObservable(String str, Video video) {
        Observable<DataSource> map = Observable.create(new CoolApkDataProvider$loadPlayerUrlObservable$1(str, video)).onErrorResumeNext(new CoolApkDataProvider$loadPlayerUrlObservable$2(str)).map(new CoolApkDataProvider$loadPlayerUrlObservable$3(this, video));
        Intrinsics.checkNotNullExpressionValue(map, "Observable\n             …sedData\n                }");
        return map;
    }

    /* compiled from: CoolApkDataProvider.kt */
    public static final class VideoLoadMismatchException extends RuntimeException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VideoLoadMismatchException(String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "message");
        }
    }
}
