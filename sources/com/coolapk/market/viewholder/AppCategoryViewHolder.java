package com.coolapk.market.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemMainCategoryDetailSBinding;
import com.coolapk.market.model.AppCategory;
import com.coolapk.market.util.CircleTransform;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\fB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/AppCategoryViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemMainCategoryDetailSBinding;", "Lcom/coolapk/market/model/AppCategory;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindToContent", "", "category", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppCategoryViewHolder.kt */
public final class AppCategoryViewHolder extends GenericBindHolder<ItemMainCategoryDetailSBinding, AppCategory> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558826;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppCategoryViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(AppCategory appCategory) {
        Intrinsics.checkNotNullParameter(appCategory, "category");
        ItemMainCategoryDetailSBinding itemMainCategoryDetailSBinding = (ItemMainCategoryDetailSBinding) getBinding();
        itemMainCategoryDetailSBinding.leftView.setOnClickListener(new AppCategoryViewHolder$bindToContent$1(this, appCategory));
        Intrinsics.checkNotNullExpressionValue(itemMainCategoryDetailSBinding, "binding");
        itemMainCategoryDetailSBinding.setTransformer(new CircleTransform(false, 0, 3, null));
        itemMainCategoryDetailSBinding.setAppCategory(appCategory);
        itemMainCategoryDetailSBinding.childContainer.removeAllViews();
        for (String str : appCategory.getTagList()) {
            View inflate = LayoutInflater.from(getContext()).inflate(2131558825, (ViewGroup) itemMainCategoryDetailSBinding.childContainer, false);
            View findViewById = inflate.findViewById(2131363551);
            Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(str);
            inflate.setOnClickListener(new AppCategoryViewHolder$bindToContent$2(this, appCategory, str));
            itemMainCategoryDetailSBinding.childContainer.addView(inflate);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/AppCategoryViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppCategoryViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
