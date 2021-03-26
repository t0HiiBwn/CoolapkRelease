package com.coolapk.market.event;

import com.coolapk.market.model.Entity;
import com.coolapk.market.model.FeedMultiPart;
import com.coolapk.market.model.FeedUIConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/event/OtherPostEvent;", "", "entity", "Lcom/coolapk/market/model/Entity;", "multiPart", "Lcom/coolapk/market/model/FeedMultiPart;", "uiConfig", "Lcom/coolapk/market/model/FeedUIConfig;", "(Lcom/coolapk/market/model/Entity;Lcom/coolapk/market/model/FeedMultiPart;Lcom/coolapk/market/model/FeedUIConfig;)V", "getEntity", "()Lcom/coolapk/market/model/Entity;", "getMultiPart", "()Lcom/coolapk/market/model/FeedMultiPart;", "getUiConfig", "()Lcom/coolapk/market/model/FeedUIConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: OtherPostEvent.kt */
public final class OtherPostEvent {
    private final Entity entity;
    private final FeedMultiPart multiPart;
    private final FeedUIConfig uiConfig;

    public static /* synthetic */ OtherPostEvent copy$default(OtherPostEvent otherPostEvent, Entity entity2, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            entity2 = otherPostEvent.entity;
        }
        if ((i & 2) != 0) {
            feedMultiPart = otherPostEvent.multiPart;
        }
        if ((i & 4) != 0) {
            feedUIConfig = otherPostEvent.uiConfig;
        }
        return otherPostEvent.copy(entity2, feedMultiPart, feedUIConfig);
    }

    public final Entity component1() {
        return this.entity;
    }

    public final FeedMultiPart component2() {
        return this.multiPart;
    }

    public final FeedUIConfig component3() {
        return this.uiConfig;
    }

    public final OtherPostEvent copy(Entity entity2, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(entity2, "entity");
        return new OtherPostEvent(entity2, feedMultiPart, feedUIConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OtherPostEvent)) {
            return false;
        }
        OtherPostEvent otherPostEvent = (OtherPostEvent) obj;
        return Intrinsics.areEqual(this.entity, otherPostEvent.entity) && Intrinsics.areEqual(this.multiPart, otherPostEvent.multiPart) && Intrinsics.areEqual(this.uiConfig, otherPostEvent.uiConfig);
    }

    public int hashCode() {
        Entity entity2 = this.entity;
        int i = 0;
        int hashCode = (entity2 != null ? entity2.hashCode() : 0) * 31;
        FeedMultiPart feedMultiPart = this.multiPart;
        int hashCode2 = (hashCode + (feedMultiPart != null ? feedMultiPart.hashCode() : 0)) * 31;
        FeedUIConfig feedUIConfig = this.uiConfig;
        if (feedUIConfig != null) {
            i = feedUIConfig.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "OtherPostEvent(entity=" + this.entity + ", multiPart=" + this.multiPart + ", uiConfig=" + this.uiConfig + ")";
    }

    public OtherPostEvent(Entity entity2, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig) {
        Intrinsics.checkNotNullParameter(entity2, "entity");
        this.entity = entity2;
        this.multiPart = feedMultiPart;
        this.uiConfig = feedUIConfig;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OtherPostEvent(Entity entity2, FeedMultiPart feedMultiPart, FeedUIConfig feedUIConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(entity2, (i & 2) != 0 ? null : feedMultiPart, (i & 4) != 0 ? null : feedUIConfig);
    }

    public final Entity getEntity() {
        return this.entity;
    }

    public final FeedMultiPart getMultiPart() {
        return this.multiPart;
    }

    public final FeedUIConfig getUiConfig() {
        return this.uiConfig;
    }
}
