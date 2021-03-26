package com.coolapk.market.view.feed.reply;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FilterArgs;", "", "blockStatus", "", "listType", "", "fromAuthor", "textId", "(Ljava/lang/String;IILjava/lang/String;II)V", "getBlockStatus", "()I", "getFromAuthor", "getListType", "()Ljava/lang/String;", "getTextId", "validId", "FILTER_BY_RECENT_REPLY", "FILTER_BY_DATELINE_DESC", "FILTER_BY_POPULAR", "FILTER_BY_AUTHOR", "FILTER_BY_BLOCK_STATUS", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyViewModel.kt */
public enum FilterArgs {
    FILTER_BY_RECENT_REPLY(0, "lastupdate_desc", 0, 2131886922, 5, null),
    FILTER_BY_DATELINE_DESC(0, "dateline_desc", 0, 2131886918, 5, null),
    FILTER_BY_POPULAR(0, "popular", 0, 2131886921, 5, null),
    FILTER_BY_AUTHOR(0, null, 1, 2131886917, 3, null),
    FILTER_BY_BLOCK_STATUS(1, null, 0, 2131887022, 6, null);
    
    private final int blockStatus;
    private final int fromAuthor;
    private final String listType;
    private final int textId;

    private FilterArgs(int i, String str, int i2, int i3) {
        this.blockStatus = i;
        this.listType = str;
        this.fromAuthor = i2;
        this.textId = i3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ FilterArgs(int i, String str, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i2, i3);
    }

    public final int getBlockStatus() {
        return this.blockStatus;
    }

    public final int getFromAuthor() {
        return this.fromAuthor;
    }

    public final String getListType() {
        return this.listType;
    }

    public final int getTextId() {
        return this.textId;
    }

    public final int validId() {
        return ordinal() + 100;
    }
}
