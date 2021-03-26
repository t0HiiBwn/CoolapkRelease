package com.coolapk.market.view.feedv8.draft;

import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/coolapk/market/view/feedv8/draft/RoughDraft;", "", "id", "", "createTime", "", "multiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "uiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "(Ljava/lang/String;JLcom/coolapk/market/model/FeedMultiPart;Lcom/coolapk/market/model/FeedUIConfig;)V", "backupId", "getBackupId", "()Ljava/lang/String;", "getCreateTime", "()J", "getId", "getMultiPart", "()Lcom/coolapk/market/model/FeedMultiPart;", "sourceId", "getSourceId", "getUiConfig", "()Lcom/coolapk/market/model/FeedUIConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RoughDraftHelper.kt */
public final class RoughDraft {
    public static final Companion Companion = new Companion(null);
    private final long createTime;
    private final String id;
    private final FeedMultiPart multiPart;
    private final FeedUIConfig uiConfig;

    public static /* synthetic */ RoughDraft copy$default(RoughDraft roughDraft, String str, long j, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            str = roughDraft.id;
        }
        if ((i & 2) != 0) {
            j = roughDraft.createTime;
        }
        if ((i & 4) != 0) {
            feedMultiPart = roughDraft.multiPart;
        }
        if ((i & 8) != 0) {
            feedUIConfig = roughDraft.uiConfig;
        }
        return roughDraft.copy(str, j, feedMultiPart, feedUIConfig);
    }

    public final String component1() {
        return this.id;
    }

    public final long component2() {
        return this.createTime;
    }

    public final FeedMultiPart component3() {
        return this.multiPart;
    }

    public final FeedUIConfig component4() {
        return this.uiConfig;
    }

    public final RoughDraft copy(String str, long j, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(feedMultiPart, "multiPart");
        Intrinsics.checkNotNullParameter(feedUIConfig, "uiConfig");
        return new RoughDraft(str, j, feedMultiPart, feedUIConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RoughDraft)) {
            return false;
        }
        RoughDraft roughDraft = (RoughDraft) obj;
        return Intrinsics.areEqual(this.id, roughDraft.id) && this.createTime == roughDraft.createTime && Intrinsics.areEqual(this.multiPart, roughDraft.multiPart) && Intrinsics.areEqual(this.uiConfig, roughDraft.uiConfig);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.createTime)) * 31;
        FeedMultiPart feedMultiPart = this.multiPart;
        int hashCode2 = (hashCode + (feedMultiPart != null ? feedMultiPart.hashCode() : 0)) * 31;
        FeedUIConfig feedUIConfig = this.uiConfig;
        if (feedUIConfig != null) {
            i = feedUIConfig.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "RoughDraft(id=" + this.id + ", createTime=" + this.createTime + ", multiPart=" + this.multiPart + ", uiConfig=" + this.uiConfig + ")";
    }

    private RoughDraft(String str, long j, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig) {
        this.id = str;
        this.createTime = j;
        this.multiPart = feedMultiPart;
        this.uiConfig = feedUIConfig;
    }

    public /* synthetic */ RoughDraft(String str, long j, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, feedMultiPart, feedUIConfig);
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.id;
    }

    public final FeedMultiPart getMultiPart() {
        return this.multiPart;
    }

    public final FeedUIConfig getUiConfig() {
        return this.uiConfig;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feedv8/draft/RoughDraft$Companion;", "", "()V", "create", "Lcom/coolapk/market/view/feedv8/draft/RoughDraft;", "id", "", "multiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "uiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "createTime", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RoughDraftHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RoughDraft create$default(Companion companion, String str, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig, long j, int i, Object obj) {
            if ((i & 8) != 0) {
                j = System.currentTimeMillis();
            }
            return companion.create(str, feedMultiPart, feedUIConfig, j);
        }

        public final RoughDraft create(String str, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig, long j) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(feedMultiPart, "multiPart");
            Intrinsics.checkNotNullParameter(feedUIConfig, "uiConfig");
            return new RoughDraft(str, j, feedMultiPart, feedUIConfig, null);
        }
    }

    public final String getBackupId() {
        return this.id + "_1";
    }

    public final String getSourceId() {
        if (!StringsKt.endsWith$default(this.id, "_1", false, 2, (Object) null)) {
            return this.id;
        }
        String str = this.id;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, str.length() - 2);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }
}
