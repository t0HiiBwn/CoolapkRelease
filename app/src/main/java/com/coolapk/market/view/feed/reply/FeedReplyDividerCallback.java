package com.coolapk.market.view.feed.reply;

import android.content.Context;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.widget.decoration.PaddingDividerItemDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyDividerCallback;", "Lcom/coolapk/market/widget/decoration/PaddingDividerItemDecoration$SimpleCallBack;", "dataList", "", "activity", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "getActivity", "()Landroid/content/Context;", "getDataList", "()Ljava/util/List;", "getDividerHeight", "", "position", "getItemCount", "getPaddingLeft", "getPaddingRight", "hasPadding", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyDivider.kt */
public class FeedReplyDividerCallback extends PaddingDividerItemDecoration.SimpleCallBack {
    private final Context activity;
    private final List<?> dataList;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedReplyDividerCallback(List<?> list, Context context) {
        super(context);
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

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getPaddingLeft() {
        return this.m16dp;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getPaddingRight() {
        return this.m16dp;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getItemCount() {
        return this.dataList.size();
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public boolean hasPadding(int i) {
        Object orNull = CollectionsKt.getOrNull(this.dataList, i);
        Entity entity = null;
        if (!(orNull instanceof Entity)) {
            orNull = null;
        }
        Entity entity2 = (Entity) orNull;
        if (entity2 != null) {
            if (entity2 instanceof FeedReply) {
                Object orNull2 = CollectionsKt.getOrNull(this.dataList, i - 1);
                if (orNull2 instanceof Entity) {
                    entity = orNull2;
                }
                Entity entity3 = (Entity) entity;
                if (entity3 != null) {
                    return !Intrinsics.areEqual(entity3.getEntityType(), "SMALL_CURRENT_TITLE");
                }
                return false;
            }
            Object orNull3 = CollectionsKt.getOrNull(this.dataList, i + 1);
            if (orNull3 instanceof Entity) {
                entity = orNull3;
            }
            Entity entity4 = entity;
            if (entity4 != null) {
                return Intrinsics.areEqual(entity4.getEntityType(), "ENTITY_TYPE_SHARE_ACTION");
            }
        }
        return false;
    }

    @Override // com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.SimpleCallBack, com.coolapk.market.widget.decoration.PaddingDividerItemDecoration.CallBack
    public int getDividerHeight(int i) {
        Object orNull = CollectionsKt.getOrNull(this.dataList, i);
        Entity entity = null;
        if (!(orNull instanceof Entity)) {
            orNull = null;
        }
        Entity entity2 = (Entity) orNull;
        if (entity2 != null) {
            Object orNull2 = CollectionsKt.getOrNull(this.dataList, i + 1);
            if (orNull2 instanceof Entity) {
                entity = orNull2;
            }
            Entity entity3 = entity;
            if (entity3 != null) {
                if (Intrinsics.areEqual(entity2.getEntityType(), "user") && Intrinsics.areEqual(entity3.getEntityType(), "user")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "forwardFeed") && Intrinsics.areEqual(entity3.getEntityType(), "forwardFeed")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "COMMENT_COUNT")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity3.getEntityType(), "COMMENT_COUNT")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity3.getEntityType(), "SMALL_HOT_TITLE")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity3.getEntityType(), "SMALL_CURRENT_TITLE")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity3.getEntityType(), "SMALL_NEWEST_TITLE")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "SMALL_HOT_TITLE")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "SMALL_CURRENT_TITLE")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "SMALL_NEWEST_TITLE")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "REPLY_HOT_ACTION")) {
                    return this.m8dp;
                }
                if (Intrinsics.areEqual(entity3.getEntityType(), "REPLY_HOT_ACTION")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity3.getEntityType(), "ENTITY_TYPE_SHARE_ACTION")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "holder_title")) {
                    return this.m1dp;
                }
                if (Intrinsics.areEqual(entity2.getEntityType(), "feed_reply")) {
                    return this.m1dp;
                }
                if (!Intrinsics.areEqual(entity2.getEntityType(), "ARTICLE_FEED_TOP") && Intrinsics.areEqual(entity2.getEntityType(), "ARTICLE_ANSWER_TOP")) {
                }
            }
        }
        return 0;
    }
}
