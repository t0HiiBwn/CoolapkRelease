package com.coolapk.market.widget.video;

import android.net.Uri;
import com.coolapk.market.model.Video;
import com.coolapk.market.model.VideoUrls;
import com.kk.taurus.playerbase.entity.DataSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/kk/taurus/playerbase/entity/DataSource;", "kotlin.jvm.PlatformType", "videoUrls", "Lcom/coolapk/market/model/VideoUrls;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CoolApkDataProvider.kt */
final class CoolApkDataProvider$loadPlayerUrlObservable$3<T, R> implements Func1<VideoUrls, DataSource> {
    final /* synthetic */ Video $video;
    final /* synthetic */ CoolApkDataProvider this$0;

    CoolApkDataProvider$loadPlayerUrlObservable$3(CoolApkDataProvider coolApkDataProvider, Video video) {
        this.this$0 = coolApkDataProvider;
        this.$video = video;
    }

    public final DataSource call(VideoUrls videoUrls) {
        HashMap<String, String> hashMap = new HashMap<>();
        String playHeaders = this.$video.getPlayHeaders();
        if (!(playHeaders == null || playHeaders.length() == 0)) {
            JSONObject jSONObject = new JSONObject(this.$video.getPlayHeaders());
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "headerJson.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        }
        DataSource dataSource = new DataSource();
        dataSource.setExtra(hashMap);
        dataSource.setLive(this.$video.getIsLive());
        Intrinsics.checkNotNullExpressionValue(videoUrls, "videoUrls");
        List<String> urlList = videoUrls.getUrlList();
        Intrinsics.checkNotNullExpressionValue(urlList, "videoUrls.urlList");
        if (CollectionsKt.firstOrNull((List<? extends Object>) urlList) != null) {
            if (videoUrls.getUrlList().size() == 1) {
                dataSource.setUri(Uri.parse(CoolApkDataProvider.access$getProxyUrl(this.this$0, videoUrls.getUrlList().get(0).toString(), this.$video.getIsLive())));
            } else {
                dataSource.setUri(Uri.fromFile(CoolApkDataProvider.access$buildConcatFile(this.this$0, videoUrls, this.$video.getIsLive())));
            }
            return dataSource;
        }
        RuntimeException propagate = Exceptions.propagate(new NullPointerException("Not url found"));
        Intrinsics.checkNotNullExpressionValue(propagate, "Exceptions.propagate(Nul…ception(\"Not url found\"))");
        throw propagate;
    }
}
