package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemRefreshCardBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.EntityRefreshCardHelper;
import com.coolapk.market.widget.DividerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/viewholder/RefreshCardViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemRefreshCardBinding;", "Lcom/coolapk/market/model/Entity;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "refreshCardHelper", "Lcom/coolapk/market/view/cardlist/EntityRefreshCardHelper;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityRefreshCardHelper;)V", "data", "bindToContent", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RefreshCardViewHolder.kt */
public final class RefreshCardViewHolder extends GenericBindHolder<ItemRefreshCardBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558893;
    private Entity data;
    private final EntityRefreshCardHelper refreshCardHelper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RefreshCardViewHolder(View view, DataBindingComponent dataBindingComponent, EntityRefreshCardHelper entityRefreshCardHelper) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityRefreshCardHelper, "refreshCardHelper");
        this.refreshCardHelper = entityRefreshCardHelper;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/RefreshCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: RefreshCardViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.GenericBindHolder
    public void bindToContent(Entity entity) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(entity, "data");
        this.data = entity;
        ItemRefreshCardBinding itemRefreshCardBinding = (ItemRefreshCardBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemRefreshCardBinding, "binding");
        RefreshCardViewHolder refreshCardViewHolder = this;
        itemRefreshCardBinding.setOnClick(refreshCardViewHolder);
        TextView textView = ((ItemRefreshCardBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(entity.getTitle());
        ((ItemRefreshCardBinding) getBinding()).titleView.setTextColor(AppHolder.getAppTheme().getColorAccent());
        ColorDrawable colorDrawable = new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundColor());
        TextView textView2 = ((ItemRefreshCardBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.titleView");
        textView2.setBackground(colorDrawable);
        boolean z = true;
        if (EntityExtendsKt.getIntExtraData(entity, "breakLine", 0) != 1) {
            z = false;
        }
        DividerView dividerView = ((ItemRefreshCardBinding) getBinding()).actionDividerLeft;
        Intrinsics.checkNotNullExpressionValue(dividerView, "binding.actionDividerLeft");
        int i3 = 8;
        dividerView.setVisibility(z ? 0 : 8);
        DividerView dividerView2 = ((ItemRefreshCardBinding) getBinding()).actionDividerRight;
        Intrinsics.checkNotNullExpressionValue(dividerView2, "binding.actionDividerRight");
        if (z) {
            i3 = 0;
        }
        dividerView2.setVisibility(i3);
        boolean isDarkTheme = AppHolder.getAppTheme().isDarkTheme();
        DividerView dividerView3 = ((ItemRefreshCardBinding) getBinding()).actionDividerLeft;
        if (isDarkTheme) {
            i = Color.parseColor("#595959");
        } else {
            i = Color.parseColor("#D9D9D9");
        }
        dividerView3.setColor(i);
        DividerView dividerView4 = ((ItemRefreshCardBinding) getBinding()).actionDividerRight;
        if (isDarkTheme) {
            i2 = Color.parseColor("#595959");
        } else {
            i2 = Color.parseColor("#D9D9D9");
        }
        dividerView4.setColor(i2);
        ((ItemRefreshCardBinding) getBinding()).cardView.setOnClickListener(refreshCardViewHolder);
        ((ItemRefreshCardBinding) getBinding()).executePendingBindings();
        this.refreshCardHelper.removeDismissCallback(entity);
        if (EntityExtendsKt.getIntExtraData(entity, "delayTime", 0) > 0) {
            this.refreshCardHelper.setDismissCallback(entity);
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        if (Intrinsics.areEqual(view, ((ItemRefreshCardBinding) getBinding()).titleView)) {
            Entity entity = this.data;
            if (entity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            String url = entity.getUrl();
            String str = null;
            if (url == null || url.length() == 0) {
                this.refreshCardHelper.requestFragmentScrollToTop();
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                BaseFragment baseFragment = (BaseFragment) fragment;
                if (baseFragment != null) {
                    str = baseFragment.getFixedRecordId();
                }
                Entity entity2 = this.data;
                if (entity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                StatisticHelper.recordEntityEvent$default(instance, str, entity2, getAdapterPosition(), null, "ScrollToTop", 8, null);
                return;
            }
            Entity entity3 = this.data;
            if (entity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("data");
            }
            if (!Intrinsics.areEqual(entity3.getUrl(), "#")) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Entity entity4 = this.data;
                if (entity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                String url2 = entity4.getUrl();
                Entity entity5 = this.data;
                if (entity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                String title = entity5.getTitle();
                Entity entity6 = this.data;
                if (entity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                ActionManagerCompat.startActivityByUrl(context, url2, title, entity6.getSubTitle());
                StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
                DataBindingComponent component2 = getComponent();
                if (!(component2 instanceof FragmentBindingComponent)) {
                    component2 = null;
                }
                FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component2;
                Fragment fragment2 = fragmentBindingComponent2 != null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
                if (!(fragment2 instanceof BaseFragment)) {
                    fragment2 = null;
                }
                BaseFragment baseFragment2 = (BaseFragment) fragment2;
                if (baseFragment2 != null) {
                    str = baseFragment2.getFixedRecordId();
                }
                Entity entity7 = this.data;
                if (entity7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("data");
                }
                StatisticHelper.recordEntityEvent$default(instance2, str, entity7, getAdapterPosition(), null, null, 24, null);
            }
        }
    }
}
