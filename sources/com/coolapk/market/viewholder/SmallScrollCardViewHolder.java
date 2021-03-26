package com.coolapk.market.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.view.cardlist.divider.ViewMarginData;
import com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/coolapk/market/viewholder/SmallScrollCardViewHolder;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "itemView", "Landroid/view/View;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "SmallScrollCardViewHolderCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SmallScrollCardViewHolder.kt */
public final class SmallScrollCardViewHolder extends TitleRecycleViewCardViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallScrollCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null, new SmallScrollCardViewHolderCallback(dataBindingComponent));
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/viewholder/SmallScrollCardViewHolder$SmallScrollCardViewHolderCallback;", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder$Callback;", "bindingComponent", "Landroidx/databinding/DataBindingComponent;", "(Landroidx/databinding/DataBindingComponent;)V", "getBindingComponent", "()Landroidx/databinding/DataBindingComponent;", "hasPic", "", "lightTheme", "getLightTheme", "()Z", "setLightTheme", "(Z)V", "onBindTo", "", "holder", "Lcom/coolapk/market/viewholder/TitleRecycleViewCardViewHolder;", "data", "", "onCreateViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onInit", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SmallScrollCardViewHolder.kt */
    public static final class SmallScrollCardViewHolderCallback extends TitleRecycleViewCardViewHolder.Callback {
        private final DataBindingComponent bindingComponent;
        private boolean hasPic;
        private boolean lightTheme;

        public SmallScrollCardViewHolderCallback(DataBindingComponent dataBindingComponent) {
            Intrinsics.checkNotNullParameter(dataBindingComponent, "bindingComponent");
            this.bindingComponent = dataBindingComponent;
        }

        public final DataBindingComponent getBindingComponent() {
            return this.bindingComponent;
        }

        public final boolean getLightTheme() {
            return this.lightTheme;
        }

        public final void setLightTheme(boolean z) {
            this.lightTheme = z;
        }

        @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
        public void onInit(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder) {
            Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
            titleRecycleViewCardViewHolder.getRecyclerView().setClipToPadding(false);
            titleRecycleViewCardViewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(titleRecycleViewCardViewHolder.getContext(), 0, false));
            RecyclerView recyclerView = titleRecycleViewCardViewHolder.getRecyclerView();
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
            marginLayoutParams2.topMargin = NumberExtendsKt.getDp((Number) 6);
            marginLayoutParams2.bottomMargin = NumberExtendsKt.getDp((Number) 6);
            recyclerView.setLayoutParams(marginLayoutParams);
            RecyclerView recyclerView2 = titleRecycleViewCardViewHolder.getRecyclerView();
            recyclerView2.setPadding(ViewMarginData.Companion.getDEFAULT_SIZE(), recyclerView2.getPaddingTop(), ViewMarginData.Companion.getDEFAULT_SIZE(), recyclerView2.getPaddingBottom());
        }

        @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
        public BindingViewHolder onCreateViewHolder(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558942, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            DataBindingComponent component = titleRecycleViewCardViewHolder.getComponent();
            Intrinsics.checkNotNullExpressionValue(component, "holder.component");
            return new SmallScrollCardViewHolder$SmallScrollCardViewHolderCallback$onCreateViewHolder$1(this, titleRecycleViewCardViewHolder, inflate, inflate, component);
        }

        @Override // com.coolapk.market.viewholder.TitleRecycleViewCardViewHolder.Callback
        public void onBindTo(TitleRecycleViewCardViewHolder titleRecycleViewCardViewHolder, Object obj) {
            Intrinsics.checkNotNullParameter(titleRecycleViewCardViewHolder, "holder");
            Intrinsics.checkNotNullParameter(obj, "data");
            EntityCard entityCard = (EntityCard) obj;
            this.hasPic = !TextUtils.isEmpty(entityCard.getPic());
            super.onBindTo(titleRecycleViewCardViewHolder, obj);
            RecyclerView.LayoutManager layoutManager = titleRecycleViewCardViewHolder.getRecyclerView().getLayoutManager();
            if (!(layoutManager instanceof LinearLayoutManager)) {
                layoutManager = null;
            }
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager != null) {
                linearLayoutManager.setInitialPrefetchItemCount(4);
            }
            if (this.lightTheme || this.hasPic) {
                ((ItemTitleViewBinding) titleRecycleViewCardViewHolder.getViewPart().getBinding()).titleView.setTextColor(-1);
                titleRecycleViewCardViewHolder.getBackgroundImageView().setVisibility(0);
                DataBindingComponent dataBindingComponent = this.bindingComponent;
                if (dataBindingComponent instanceof FragmentBindingComponent) {
                    AppHolder.getFragmentImageLoader().displayImage((Fragment) ((FragmentBindingComponent) dataBindingComponent).getContainer(), entityCard.getPic(), titleRecycleViewCardViewHolder.getBackgroundImageView());
                } else if (dataBindingComponent instanceof ContextBindingComponent) {
                    AppHolder.getContextImageLoader().displayImage((Context) ((ContextBindingComponent) dataBindingComponent).getContainer(), entityCard.getPic(), titleRecycleViewCardViewHolder.getBackgroundImageView());
                }
            } else {
                ((ItemTitleViewBinding) titleRecycleViewCardViewHolder.getViewPart().getBinding()).titleView.setTextColor(AppHolder.getAppTheme().getTextColorPrimary());
                titleRecycleViewCardViewHolder.getBackgroundImageView().setVisibility(8);
            }
        }
    }
}
