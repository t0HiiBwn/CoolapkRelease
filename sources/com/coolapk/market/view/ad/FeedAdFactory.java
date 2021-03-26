package com.coolapk.market.view.ad;

import android.app.Activity;
import com.coolapk.market.view.ad.tencent.GDTFeedAd;
import com.coolapk.market.view.ad.tencent.GDTFeedAd2;
import com.coolapk.market.view.ad.tencent.GDTFeedSelfDrawAD;
import com.coolapk.market.view.ad.toutiao.TTFeedAd;
import com.coolapk.market.view.ad.toutiao.TTFeedSelfDrawAd;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/ad/FeedAdFactory;", "", "()V", "getFeedAd", "Lcom/coolapk/market/view/ad/FeedAdSource;", "activity", "Landroid/app/Activity;", "name", "", "appId", "posId", "count", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedAdFactory.kt */
public final class FeedAdFactory {
    public static final FeedAdFactory INSTANCE = new FeedAdFactory();

    private FeedAdFactory() {
    }

    public final FeedAdSource getFeedAd(Activity activity, String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "appId");
        Intrinsics.checkNotNullParameter(str3, "posId");
        switch (str.hashCode()) {
            case -264365059:
                if (str.equals("TT_FEED")) {
                    return new TTFeedAd(activity, str2, str3, i);
                }
                break;
            case 1093610357:
                if (str.equals("QQ_FEED2")) {
                    return new GDTFeedAd2(activity, str3, i);
                }
                break;
            case 1268689752:
                if (str.equals("TT_SELF_DRAW")) {
                    return new TTFeedSelfDrawAd(activity, str2, str3, i);
                }
                break;
            case 1282203741:
                if (str.equals("QQ_FEED")) {
                    return new GDTFeedAd(activity, str3, i);
                }
                break;
            case 1977328376:
                if (str.equals("QQ_SELF_DRAW")) {
                    return new GDTFeedSelfDrawAD(activity, str3, i);
                }
                break;
        }
        throw new RuntimeException("Unknown feed ad: " + str);
    }
}
