package com.coolapk.market.view.feed.reply;

import android.graphics.Rect;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.view.feed.reply.PictureDetailFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/feed/reply/PictureDetailFragment$SinglePictureFeedFragment$onActivityCreated$1", "Lcom/coolapk/market/view/feed/reply/FeedReplyListDividerCallback;", "getOutsideRectColor", "", "rect", "Landroid/graphics/Rect;", "position", "getRectColor", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PictureDetailFragment.kt */
public final class PictureDetailFragment$SinglePictureFeedFragment$onActivityCreated$1 extends FeedReplyListDividerCallback {
    final /* synthetic */ PictureDetailFragment.SinglePictureFeedFragment this$0;

    @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
    public int getOutsideRectColor(Rect rect, int i) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return 0;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PictureDetailFragment$SinglePictureFeedFragment$onActivityCreated$1(PictureDetailFragment.SinglePictureFeedFragment singlePictureFeedFragment, List list) {
        super(list);
        this.this$0 = singlePictureFeedFragment;
    }

    @Override // com.coolapk.market.widget.decoration.CustomizedItemDecoration.SimpleCallback, com.coolapk.market.widget.decoration.CustomizedItemDecoration.Callback
    public int getRectColor(Rect rect, int i) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return ColorUtils.adjustAlpha(super.getRectColor(rect, i), 0.4f);
    }
}
