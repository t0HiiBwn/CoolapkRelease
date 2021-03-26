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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00014B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\u0018\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J\u0012\u0010)\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010\u000eH\u0016J\u000e\u0010+\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0-2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200H\u0002J \u00101\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020\u000eH\u0002J\u0018\u00102\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u000eH\u0002J\b\u00103\u001a\u00020\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R.\u0010\b\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\rX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/coolapk/market/widget/video/CoolApkDataProvider;", "Lcom/kk/taurus/playerbase/provider/BaseDataProvider;", "useDataSourceCache", "", "useVideoCache", "(ZZ)V", "loadingVideoModelKey", "Ljava/util/concurrent/atomic/AtomicInteger;", "pendingHeader", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "resultDataSource", "Landroid/util/SparseArray;", "Lcom/kk/taurus/playerbase/entity/DataSource;", "subscription", "Lrx/Subscription;", "getUseDataSourceCache", "()Z", "getUseVideoCache", "videoModelArray", "Lcom/coolapk/market/widget/video/VideoModel;", "addToPendingParseList", "", "videoModel", "buildConcatFile", "Ljava/io/File;", "urls", "Lcom/coolapk/market/model/VideoUrls;", "isLive", "callProviderDataSource", "dataSource", "callProviderError", "type", "", "error", "", "cancel", "destroy", "getProxyUrl", "source", "handleSourceData", "oldSource", "invalidVideoModelResult", "loadPlayerUrlObservable", "Lrx/Observable;", "requestParams", "video", "Lcom/coolapk/market/model/Video;", "loadVideoDataSource", "loadVideoModel", "setInvalidateLoadingKey", "VideoLoadMismatchException", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
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

    /* access modifiers changed from: private */
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

    /* access modifiers changed from: private */
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

    /* access modifiers changed from: private */
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

    /* access modifiers changed from: private */
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/widget/video/CoolApkDataProvider$VideoLoadMismatchException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CoolApkDataProvider.kt */
    public static final class VideoLoadMismatchException extends RuntimeException {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public VideoLoadMismatchException(String str) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "message");
        }
    }
}
