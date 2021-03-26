package com.coolapk.market.widget.video;

import android.os.Parcelable;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.ProductMedia;
import com.coolapk.market.model.Video;
import com.kk.taurus.playerbase.entity.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0005\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\t\u001a\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\r\u001a\f\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00020\u000e\u001a\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013*\u00020\u0005\u001a\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\u0015\u001a\u00020\f*\u00020\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u0003\u001a\u0012\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010*\u0004\u0018\u00010\u0003\u001a\n\u0010\u0019\u001a\u00020\u0016*\u00020\u0001\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\t\u001a\u0019\u0010\u001a\u001a\u00020\u0001*\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001b\u001a\n\u0010\u001a\u001a\u00020\u0001*\u00020\u000e\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0005\u001a!\u0010\u001d\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"randomViewModel", "Lcom/coolapk/market/widget/video/VideoModel;", "seed", "", "findDefaultParamsKey", "Lcom/coolapk/market/model/Video;", "findVideo", "Lcom/coolapk/market/model/Entity;", "videoModel", "Lcom/coolapk/market/model/Feed;", "Lcom/coolapk/market/model/Live;", "liveStatus", "", "(Lcom/coolapk/market/model/Live;Ljava/lang/Integer;)Lcom/coolapk/market/model/Video;", "Lcom/coolapk/market/model/ProductMedia;", "findVideoList", "", "(Lcom/coolapk/market/model/Live;Ljava/lang/Integer;)Ljava/util/List;", "getRequestParamsMap", "", "getVideoList", "getVideoModelKey", "Lcom/kk/taurus/playerbase/entity/DataSource;", "parseJsonAsVideo", "parseJsonAsVideoList", "toDataSource", "toVideoModel", "(Lcom/coolapk/market/model/Live;Ljava/lang/Integer;)Lcom/coolapk/market/widget/video/VideoModel;", "toViewModel", "videoToVideoModel", "video", "(Lcom/coolapk/market/model/Live;Lcom/coolapk/market/model/Video;Ljava/lang/Integer;)Lcom/coolapk/market/widget/video/VideoModel;", "presentation_coolapkAppRelease"}, k = 2, mv = {1, 4, 2})
/* compiled from: VideoModel.kt */
public final class VideoModelKt {
    public static final int getVideoModelKey(DataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "$this$getVideoModelKey");
        return (int) dataSource.getId();
    }

    public static final DataSource toDataSource(VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(videoModel, "$this$toDataSource");
        DataSource dataSource = new DataSource();
        dataSource.setId((long) videoModel.hashCode());
        return dataSource;
    }

    public static final List<Video> findVideoList(Live live, Integer num) {
        Intrinsics.checkNotNullParameter(live, "$this$findVideoList");
        if (num != null && num.intValue() == 1) {
            return parseJsonAsVideoList(live.getVideoLiveInfo());
        }
        if (num != null && num.intValue() == -1) {
            return parseJsonAsVideoList(live.getVideoPlaybackUInfo());
        }
        return CollectionsKt.emptyList();
    }

    public static final Video findVideo(Live live, Integer num) {
        Intrinsics.checkNotNullParameter(live, "$this$findVideo");
        return (Video) CollectionsKt.firstOrNull((List<? extends Object>) findVideoList(live, num));
    }

    public static final List<Video> getVideoList(Live live, int i) {
        Intrinsics.checkNotNullParameter(live, "$this$getVideoList");
        return findVideoList(live, Integer.valueOf(i));
    }

    public static final Map<String, String> getRequestParamsMap(Video video) {
        Intrinsics.checkNotNullParameter(video, "$this$getRequestParamsMap");
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(video.getRequestParams());
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static final String findDefaultParamsKey(Video video) {
        String str;
        Intrinsics.checkNotNullParameter(video, "$this$findDefaultParamsKey");
        try {
            JSONObject jSONObject = new JSONObject(video.getRequestParams());
            ArrayList arrayList = new ArrayList();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Intrinsics.checkNotNullExpressionValue(next, "next()");
                arrayList.add(next);
            }
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            if (!appSetting.isWifiAvailable()) {
                str = (String) CollectionsKt.last((List<? extends Object>) arrayList);
            } else {
                int size = arrayList.size();
                if (1 <= size) {
                    if (2 >= size) {
                        str = (String) arrayList.get(arrayList.size() - 1);
                    }
                }
                if (arrayList.size() == 3) {
                    str = (String) arrayList.get(1);
                } else if (arrayList.size() < 4) {
                    return "";
                } else {
                    str = (String) arrayList.get(arrayList.size() - 3);
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static final Video findVideo(Entity entity, VideoModel videoModel) {
        Intrinsics.checkNotNullParameter(entity, "$this$findVideo");
        Intrinsics.checkNotNullParameter(videoModel, "videoModel");
        Parcelable parcelable = null;
        if (entity instanceof Video) {
            return (Video) entity;
        }
        if (entity instanceof Feed) {
            return findVideo((Feed) entity);
        }
        if (entity instanceof EntityCard) {
            List<Entity> entities = ((EntityCard) entity).getEntities();
            Parcelable parcelable2 = entities != null ? (Entity) CollectionsKt.firstOrNull((List<? extends Object>) entities) : null;
            if (parcelable2 instanceof Video) {
                parcelable = parcelable2;
            }
            return (Video) parcelable;
        } else if (entity instanceof Live) {
            return findVideo((Live) entity, Integer.valueOf(videoModel.getLiveStatus()));
        } else {
            return parseJsonAsVideo(EntityExtendsKt.getStringExtraDataOrNull(entity, "videoParams"));
        }
    }

    public static final Video findVideo(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$findVideo");
        String mediaInfo = feed.getMediaInfo();
        if (mediaInfo == null) {
            return null;
        }
        if (mediaInfo.length() == 0) {
            return null;
        }
        return parseJsonAsVideo(mediaInfo);
    }

    public static final Video findVideo(ProductMedia productMedia) {
        Intrinsics.checkNotNullParameter(productMedia, "$this$findVideo");
        String mediaInfo = productMedia.getMediaInfo();
        if (mediaInfo == null) {
            return null;
        }
        if (mediaInfo.length() == 0) {
            return null;
        }
        return parseJsonAsVideo(mediaInfo);
    }

    public static final VideoModel toViewModel(Video video) {
        String str;
        Intrinsics.checkNotNullParameter(video, "$this$toViewModel");
        String name = video.getName();
        String str2 = name != null ? name : "";
        boolean isLive = video.getIsLive();
        String cover = video.getCover();
        if (cover != null) {
            str = cover;
        } else {
            str = "";
        }
        return new VideoModel(null, str2, str, null, video.getDuration(), isLive ? 1 : 0, true, video.isRedirectSource(), null, video, null, 1289, null);
    }

    public static final VideoModel toVideoModel(ProductMedia productMedia) {
        Intrinsics.checkNotNullParameter(productMedia, "$this$toVideoModel");
        Video findVideo = findVideo(productMedia);
        if (findVideo == null) {
            return VideoModel.Companion.getNO_VIDEO();
        }
        VideoModel viewModel = toViewModel(findVideo);
        Video video = findVideo;
        String url = productMedia.getUrl();
        if (url == null) {
            url = "";
        }
        return VideoModel.copy$default(viewModel, null, null, null, url, 0, 0, false, false, null, video, null, 1527, null);
    }

    public static final VideoModel toVideoModel(Live live, Integer num) {
        Intrinsics.checkNotNullParameter(live, "$this$toVideoModel");
        Video findVideo = findVideo(live, num);
        if (findVideo != null) {
            return videoToVideoModel(live, findVideo, num);
        }
        return VideoModel.Companion.getNO_VIDEO();
    }

    public static final VideoModel videoToVideoModel(Live live, Video video, Integer num) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(live, "$this$videoToVideoModel");
        Intrinsics.checkNotNullParameter(video, "video");
        String picUrl = live.getPicUrl();
        String str4 = (!(picUrl == null || picUrl.length() == 0) ? (str3 = live.getPicUrl()) == null : (str3 = video.getCover()) == null) ? "" : str3;
        if (num != null && num.intValue() == 1) {
            str = live.getVideoLiveUrl();
        } else if (num != null && num.intValue() == -1) {
            str = live.getVideoPlaybackUrl();
        } else {
            str = live.getUrl();
        }
        VideoModel viewModel = toViewModel(video);
        Live live2 = live;
        int intValue = num != null ? num.intValue() : 0;
        if (str != null) {
            str2 = str;
        } else {
            str2 = "";
        }
        return VideoModel.copy$default(viewModel, null, null, str4, str2, 0, intValue, false, false, null, live2, null, 1491, null);
    }

    public static final VideoModel toVideoModel(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "$this$toVideoModel");
        Video findVideo = findVideo(feed);
        if (findVideo == null) {
            return VideoModel.Companion.getNO_VIDEO();
        }
        VideoModel viewModel = toViewModel(findVideo);
        Feed feed2 = feed;
        String mediaUrl = feed.getMediaUrl();
        if (mediaUrl == null) {
            mediaUrl = "";
        }
        return VideoModel.copy$default(viewModel, null, null, null, mediaUrl, 0, 0, false, false, null, feed2, null, 1527, null);
    }

    public static final Video parseJsonAsVideo(String str) {
        Entity parseJsonToEntity = DataManager.getInstance().parseJsonToEntity(str, "video");
        if (!(parseJsonToEntity instanceof Video)) {
            parseJsonToEntity = null;
        }
        return (Video) parseJsonToEntity;
    }

    public static final List<Video> parseJsonAsVideoList(String str) {
        List<Video> parseJsonArrayToEntity = DataManager.getInstance().parseJsonArrayToEntity(str, "video");
        Intrinsics.checkNotNullExpressionValue(parseJsonArrayToEntity, "DataManager.getInstance(…yUtils.ENTITY_TYPE_VIDEO)");
        return parseJsonArrayToEntity;
    }

    public static final VideoModel randomViewModel(String str) {
        Intrinsics.checkNotNullParameter(str, "seed");
        if (str.hashCode() == 3322092 && str.equals("live")) {
            Video parseJsonAsVideo = parseJsonAsVideo("{\"name\":\"MacBook Air\\u5b98\\u65b9\\u5ba3\\u4f20\\u89c6\\u9891\\uff1a\\u8fd9\\u6b21\\u7ec8\\u4e8e\\u7b97\\u662f\\u4e00\\u53f0\\u80fd\\u7528\\u7684MacBook Air\\u3002\",\"artistName\":\"\\u6211\\u7684\\u80a5\\u7682\\u53bb\\u54ea\\u513f\\u4e86\",\"cover\":\"https:\\/\\/wx1.sinaimg.cn\\/large\\/87fc3b5egy1fwqoifr5h6j20ru0fowff.jpg\",\"duration\":148375,\"mediaType\":\"video\",\"isLive\":false,\"requestParams\":\"{\\u0022\\\\u666e\\\\u901a\\u0022:{\\u0022fromType\\u0022:\\u0022weiboDirect\\u0022,\\u00220\\u0022:\\u0022https:\\\\\\/\\\\\\/m.weibo.cn\\\\\\/2281454430\\\\\\/4300968663444536\\u0022}}\",\"identify\":\"c607899de50b80ee1cd1a6d2c3d4fb35\",\"source\":4}");
            VideoModel viewModel = parseJsonAsVideo != null ? toViewModel(parseJsonAsVideo) : null;
            if (viewModel != null) {
                return viewModel;
            }
        }
        int parseInt = Integer.parseInt(String.valueOf(StringsKt.last(str))) % 6;
        if (parseInt < 2) {
            return new VideoModel("http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8", "HKS电视台", "http://image.coolapk.com/feed/2018/0527/444749_1527417543_669@1181x531.jpg", null, 0, 0, false, false, null, null, null, 2040, null);
        }
        if (parseInt < 4) {
            return new VideoModel("https://mov.bn.netease.com/open-movie/nos/mp4/2016/06/22/SBP8G92E3_hd.mp4", "你欠缺的也许并不是能力", "http://open-image.nosdn.127.net/image/snapshot_movie/2016/11/b/a/c36e048e284c459686133e66a79e2eba.jpg", null, 0, 0, false, false, null, null, null, 2040, null);
        }
        if (parseInt < 6) {
            return new VideoModel("https://mov.bn.netease.com/open-movie/nos/mp4/2017/05/31/SCKR8V6E9_hd.mp4", "不耐烦的中国人?", "http://open-image.nosdn.127.net/image/snapshot_movie/2016/11/e/9/ac655948c705413b8a63a7aaefd4cde9.jpg", null, 0, 0, false, false, null, null, null, 2040, null);
        }
        if (parseInt < 3) {
            return new VideoModel("http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4", null, null, null, 0, 0, false, false, null, null, null, 2046, null);
        }
        if (parseInt < 4) {
            return new VideoModel("rtmp://live.hkstv.hk.lxdns.com/live/hks", null, null, null, 0, 0, false, false, null, null, null, 2046, null);
        }
        return VideoModel.Companion.getNO_VIDEO();
    }
}
