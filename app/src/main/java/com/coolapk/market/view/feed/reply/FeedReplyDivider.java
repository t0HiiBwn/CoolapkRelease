package com.coolapk.market.view.feed.reply;

import android.content.Context;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyDivider;", "Lcom/coolapk/market/widget/decoration/PaddingDividerItemDecoration;", "dataList", "", "activity", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "getActivity", "()Landroid/content/Context;", "getDataList", "()Ljava/util/List;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyDivider.kt */
public class FeedReplyDivider extends PaddingDividerItemDecoration {
    private final Context activity;
    private final List<?> dataList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedReplyDivider(List<?> list, Context context) {
        super(new FeedReplyDividerCallback(list, context));
        Intrinsics.checkNotNullParameter(list, "dataList");
        Intrinsics.checkNotNullParameter(context, "activity");
        this.dataList = list;
        this.activity = context;
    }

    public final Context getActivity() {
        return this.activity;
    }

    public final List<?> getDataList() {
        return this.dataList;
    }
}
