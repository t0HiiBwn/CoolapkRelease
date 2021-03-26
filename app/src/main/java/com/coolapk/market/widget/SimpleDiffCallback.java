package com.coolapk.market.widget;

import androidx.recyclerview.widget.DiffUtil;
import com.coolapk.market.model.Feed;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\u0014\u0010\u000f\u001a\u00020\b*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/widget/SimpleDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldData", "", "", "newData", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "simpleEquals", "Lcom/coolapk/market/model/Feed;", "o", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SimpleDiffCallback.kt */
public final class SimpleDiffCallback extends DiffUtil.Callback {
    private final List<Object> newData;
    private final List<Object> oldData;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int i, int i2) {
        return true;
    }

    public SimpleDiffCallback(List<? extends Object> list, List<? extends Object> list2) {
        Intrinsics.checkNotNullParameter(list, "oldData");
        Intrinsics.checkNotNullParameter(list2, "newData");
        this.oldData = list;
        this.newData = list2;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int i, int i2) {
        Object orNull = CollectionsKt.getOrNull(this.oldData, i);
        Object orNull2 = CollectionsKt.getOrNull(this.newData, i2);
        if (!(orNull instanceof Feed) || !(orNull2 instanceof Feed)) {
            return Intrinsics.areEqual(orNull, orNull2);
        }
        return simpleEquals((Feed) orNull, (Feed) orNull2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldData.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newData.size();
    }

    private final boolean simpleEquals(Feed feed, Feed feed2) {
        if ((feed.getEntityTypeName() == null ? feed2.getEntityTypeName() == null : Intrinsics.areEqual(feed.getEntityTypeName(), feed2.getEntityTypeName())) && Intrinsics.areEqual(feed.getEntityType(), feed2.getEntityType())) {
            if (feed.getEntityTemplate() == null ? feed2.getEntityTemplate() == null : Intrinsics.areEqual(feed.getEntityTemplate(), feed2.getEntityTemplate())) {
                if (feed.getEntityId() == null ? feed2.getEntityId() == null : Intrinsics.areEqual(feed.getEntityId(), feed2.getEntityId())) {
                    if (feed.getEntityFixed() == null ? feed2.getEntityFixed() == null : Intrinsics.areEqual(feed.getEntityFixed(), feed2.getEntityFixed())) {
                        if (feed.getDescription() == null ? feed2.getDescription() == null : Intrinsics.areEqual(feed.getDescription(), feed2.getDescription())) {
                            if (feed.getSubTitle() == null ? feed2.getSubTitle() == null : Intrinsics.areEqual(feed.getSubTitle(), feed2.getSubTitle())) {
                                if (feed.getExtraData() == null ? feed2.getExtraData() == null : Intrinsics.areEqual(feed.getExtraData(), feed2.getExtraData())) {
                                    if (feed.getDateline() == null ? feed2.getDateline() == null : Intrinsics.areEqual(feed.getDateline(), feed2.getDateline())) {
                                        if (feed.getLastUpdate() == null ? feed2.getLastUpdate() == null : Intrinsics.areEqual(feed.getLastUpdate(), feed2.getLastUpdate())) {
                                            if (feed.getDeprecatedUserAvatar() == null ? feed2.getDeprecatedUserAvatar() == null : Intrinsics.areEqual(feed.getDeprecatedUserAvatar(), feed2.getDeprecatedUserAvatar())) {
                                                if ((feed.getUserInfo() == null ? feed2.getUserInfo() == null : Intrinsics.areEqual(feed.getUserInfo(), feed2.getUserInfo())) && Intrinsics.areEqual(feed.getUid(), feed2.getUid())) {
                                                    if (feed.getDeprecatedUserName() == null ? feed2.getDeprecatedUserName() == null : Intrinsics.areEqual(feed.getDeprecatedUserName(), feed2.getDeprecatedUserName())) {
                                                        if ((feed.getDisplayUserName() == null ? feed2.getDisplayUserName() == null : Intrinsics.areEqual(feed.getDisplayUserName(), feed2.getDisplayUserName())) && Intrinsics.areEqual(feed.getTitle(), feed2.getTitle()) && Intrinsics.areEqual(feed.getId(), feed2.getId())) {
                                                            if ((feed.getLabel() == null ? feed2.getLabel() == null : Intrinsics.areEqual(feed.getLabel(), feed2.getLabel())) && feed.getType() == feed2.getType() && Intrinsics.areEqual(feed.getPic(), feed2.getPic()) && Intrinsics.areEqual(feed.getPicArray(), feed2.getPicArray()) && Intrinsics.areEqual(feed.getInfoHtml(), feed2.getInfoHtml()) && Intrinsics.areEqual(feed.getInfo(), feed2.getInfo()) && feed.getForwardNum() == feed2.getForwardNum() && feed.getShareNum() == feed2.getShareNum() && feed.getLikeNum() == feed2.getLikeNum() && feed.getReplyNum() == feed2.getReplyNum() && feed.getRelatedNum() == feed2.getRelatedNum() && feed.getFavoriteNum() == feed2.getFavoriteNum() && feed.getCommentBlockNum() == feed2.getCommentBlockNum() && feed.getQuestionAnswerNum() == feed2.getQuestionAnswerNum() && feed.getQuestionFollowNum() == feed2.getQuestionFollowNum()) {
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
