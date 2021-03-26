package com.coolapk.market.widget.video;

import com.coolapk.market.app.EmptySubscriber;
import com.kk.taurus.playerbase.entity.DataSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"com/coolapk/market/widget/video/CoolApkDataProvider$loadVideoDataSource$2", "Lcom/coolapk/market/app/EmptySubscriber;", "Lcom/kk/taurus/playerbase/entity/DataSource;", "onError", "", "e", "", "onNext", "dataSource", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CoolApkDataProvider.kt */
public final class CoolApkDataProvider$loadVideoDataSource$2 extends EmptySubscriber<DataSource> {
    final /* synthetic */ DataSource $oldSource;
    final /* synthetic */ VideoModel $videoModel;
    final /* synthetic */ CoolApkDataProvider this$0;

    CoolApkDataProvider$loadVideoDataSource$2(CoolApkDataProvider coolApkDataProvider, VideoModel videoModel, DataSource dataSource) {
        this.this$0 = coolApkDataProvider;
        this.$videoModel = videoModel;
        this.$oldSource = dataSource;
    }

    @Override // com.coolapk.market.app.EmptySubscriber, rx.Observer
    public void onError(Throwable th) {
        super.onError(th);
        this.this$0.callProviderError(-119, th);
    }

    public void onNext(DataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        super.onNext((CoolApkDataProvider$loadVideoDataSource$2) dataSource);
        dataSource.setId((long) this.$videoModel.getKey());
        dataSource.setStartPos(this.$oldSource.getStartPos());
        dataSource.setTitle(this.$videoModel.getTitle());
        this.this$0.resultDataSource.put(VideoModelKt.getVideoModelKey(this.$oldSource), dataSource);
        this.this$0.callProviderDataSource(dataSource);
    }
}
