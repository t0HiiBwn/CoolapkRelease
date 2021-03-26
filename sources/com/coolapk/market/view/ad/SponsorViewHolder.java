package com.coolapk.market.view.ad;

import android.view.View;
import com.coolapk.market.databinding.ItemSponsorBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.ad.EntityAdHelper;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.widget.view.ADFrameLayout;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0002R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/ad/SponsorViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "Lcom/coolapk/market/view/ad/EntityAdHelper$AdViewHolderCallback;", "view", "Landroid/view/View;", "entityAdHelper", "Lcom/coolapk/market/view/ad/EntityAdHelper;", "(Landroid/view/View;Lcom/coolapk/market/view/ad/EntityAdHelper;)V", "binding", "Lcom/coolapk/market/databinding/ItemSponsorBinding;", "kotlin.jvm.PlatformType", "data", "Lcom/coolapk/market/model/Entity;", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "", "getPositionInDataList", "", "onAdBan", "adInfo", "Lcom/coolapk/market/view/ad/AdInfo;", "onAdClose", "onAdLoadSuccess", "setInitRatio", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SponsorViewHolder.kt */
public final class SponsorViewHolder extends BindingViewHolder implements EntityAdHelper.AdViewHolderCallback {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558945;
    private final ItemSponsorBinding binding;
    private Entity data;
    private final EntityAdHelper entityAdHelper;
    private final TitleViewPart viewPart;

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdLoadFail() {
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdLoadFail(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SponsorViewHolder(View view, EntityAdHelper entityAdHelper2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(entityAdHelper2, "entityAdHelper");
        this.entityAdHelper = entityAdHelper2;
        ItemSponsorBinding itemSponsorBinding = (ItemSponsorBinding) getBinding();
        this.binding = itemSponsorBinding;
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        ADFrameLayout aDFrameLayout = itemSponsorBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(aDFrameLayout, "binding.itemView");
        this.viewPart = companion.newInstance(aDFrameLayout, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/ad/SponsorViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SponsorViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        Entity entity = (Entity) obj;
        this.data = entity;
        this.viewPart.bindToContent(obj);
        setInitRatio();
        this.entityAdHelper.requestLoadAd(entity, this);
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdLoadSuccess() {
        EntityAdHelper entityAdHelper2 = this.entityAdHelper;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        FeedAdSource findFeedAdSource = entityAdHelper2.findFeedAdSource(EntityExtendsKt.entityUniqueId(entity));
        if (findFeedAdSource != null) {
            Object firstData = findFeedAdSource.firstData();
            if (firstData != null) {
                ADFrameLayout aDFrameLayout = this.binding.itemView;
                Intrinsics.checkNotNullExpressionValue(aDFrameLayout, "binding.itemView");
                findFeedAdSource.render(aDFrameLayout, firstData);
                return;
            }
            ADFrameLayout aDFrameLayout2 = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(aDFrameLayout2, "binding.itemView");
            if (aDFrameLayout2.getChildCount() > 0) {
                this.binding.itemView.removeAllViews();
            }
        }
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdClose() {
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdClose(this);
        EntityAdHelper entityAdHelper2 = this.entityAdHelper;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        entityAdHelper2.requestCloseAd(EntityExtendsKt.entityUniqueId(entity), getAdapterPosition());
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public void onAdBan(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        EntityAdHelper.AdViewHolderCallback.DefaultImpls.onAdBan(this, adInfo);
        EntityAdHelper entityAdHelper2 = this.entityAdHelper;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        entityAdHelper2.requestCloseAd(EntityExtendsKt.entityUniqueId(entity), getAdapterPosition());
    }

    @Override // com.coolapk.market.view.ad.EntityAdHelper.AdViewHolderCallback
    public int getPositionInDataList() {
        return getAdapterPosition();
    }

    private final void setInitRatio() {
        String str;
        Entity entity = this.data;
        if (entity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        JSONObject jsonExtraData = EntityExtendsKt.getJsonExtraData(entity);
        if (jsonExtraData == null || (str = jsonExtraData.optString("sponsorType")) == null) {
            str = "";
        }
        String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{"|"}, false, 0, 6, (Object) null), 3);
        if (str2 == null) {
            str2 = "0";
        }
        float parseFloat = Float.parseFloat(str2);
        if (parseFloat != this.binding.itemView.getMinAspectRatio()) {
            this.binding.itemView.removeAllViews();
            this.binding.itemView.setMinAspectRatio(parseFloat);
            this.binding.itemView.requestLayout();
        }
    }
}
