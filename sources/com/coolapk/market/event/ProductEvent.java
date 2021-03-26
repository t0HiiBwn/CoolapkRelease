package com.coolapk.market.event;

import com.coolapk.market.model.Product;
import com.coolapk.market.model.UserAction;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/event/ProductEvent;", "", "id", "", "type", "result", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getId", "()Ljava/lang/String;", "getResult", "()Ljava/lang/Object;", "getType", "canMatchUpWith", "", "product", "Lcom/coolapk/market/model/Product;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "patch", "patchFollowEvent", "toString", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ProductEvent.kt */
public final class ProductEvent {
    public static final Companion Companion = new Companion(null);
    public static final String EVENT_ADD_MEDIA = "add_media";
    public static final String EVENT_REMOVE_MEDIA = "remove_media";
    public static final String EVENT_TYPE_FOLLOW = "follow_event";
    public static final String EVENT_TYPE_LIKE = "like_event";
    public static final String EVENT_TYPE_WISH = "wish_event";
    private final String id;
    private final Object result;
    private final String type;

    public static /* synthetic */ ProductEvent copy$default(ProductEvent productEvent, String str, String str2, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = productEvent.id;
        }
        if ((i & 2) != 0) {
            str2 = productEvent.type;
        }
        if ((i & 4) != 0) {
            obj = productEvent.result;
        }
        return productEvent.copy(str, str2, obj);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final Object component3() {
        return this.result;
    }

    public final ProductEvent copy(String str, String str2, Object obj) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new ProductEvent(str, str2, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProductEvent)) {
            return false;
        }
        ProductEvent productEvent = (ProductEvent) obj;
        return Intrinsics.areEqual(this.id, productEvent.id) && Intrinsics.areEqual(this.type, productEvent.type) && Intrinsics.areEqual(this.result, productEvent.result);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.type;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj = this.result;
        if (obj != null) {
            i = obj.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ProductEvent(id=" + this.id + ", type=" + this.type + ", result=" + this.result + ")";
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/event/ProductEvent$Companion;", "", "()V", "EVENT_ADD_MEDIA", "", "EVENT_REMOVE_MEDIA", "EVENT_TYPE_FOLLOW", "EVENT_TYPE_LIKE", "EVENT_TYPE_WISH", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ProductEvent.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ProductEvent(String str, String str2, Object obj) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.id = str;
        this.type = str2;
        this.result = obj;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProductEvent(String str, String str2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : obj);
    }

    public final String getId() {
        return this.id;
    }

    public final Object getResult() {
        return this.result;
    }

    public final String getType() {
        return this.type;
    }

    public final boolean canMatchUpWith(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        return Intrinsics.areEqual(this.id, product.getId());
    }

    public final Product patch(Product product) {
        Intrinsics.checkNotNullParameter(product, "product");
        if (canMatchUpWith(product)) {
            String str = this.type;
            return (str.hashCode() == -2057910132 && str.equals("follow_event")) ? patchFollowEvent(product) : product;
        }
        throw new RuntimeException("YOU NEED TO CHECK canMatchUpWith METHOD FIRST");
    }

    private final Product patchFollowEvent(Product product) {
        UserAction userAction = product.getUserAction();
        Intrinsics.checkNotNullExpressionValue(userAction, "product.userAction");
        boolean z = true;
        if (userAction.getFollow() != 1) {
            z = false;
        }
        Object obj = this.result;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
        boolean booleanValue = ((Boolean) obj).booleanValue();
        if (z == booleanValue) {
            return product;
        }
        Product build = product.builder().setUserAction(product.getUserAction().builder().follow(booleanValue ? 1 : 0).build()).setFollowNum(ProductEventKt.handleOnStateChange(product.getFollowNum(), z)).build();
        Intrinsics.checkNotNullExpressionValue(build, "product.builder()\n      …\n                .build()");
        return build;
    }
}
