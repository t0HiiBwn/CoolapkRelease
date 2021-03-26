package com.coolapk.market.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemPermissionsBinding;
import com.coolapk.market.view.main.PermissionsAgreeActivity;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/PermissionsItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "keys", "", "", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Ljava/util/List;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemPermissionsBinding;", "kotlin.jvm.PlatformType", "item", "Lcom/coolapk/market/view/main/PermissionsAgreeActivity$PermissionsItem;", "getKeys", "()Ljava/util/List;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PermissionsItemViewHolder.kt */
public final class PermissionsItemViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558849;
    private final ItemPermissionsBinding binding = ((ItemPermissionsBinding) getBinding());
    private PermissionsAgreeActivity.PermissionsItem item;
    private final List<String> keys;

    public final List<String> getKeys() {
        return this.keys;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PermissionsItemViewHolder(List<String> list, View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent);
        Intrinsics.checkNotNullParameter(list, "keys");
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.keys = list;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/PermissionsItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PermissionsItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        ItemPermissionsBinding itemPermissionsBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemPermissionsBinding, "binding");
        itemPermissionsBinding.setClick(this);
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.main.PermissionsAgreeActivity.PermissionsItem");
        PermissionsAgreeActivity.PermissionsItem permissionsItem = (PermissionsAgreeActivity.PermissionsItem) obj;
        this.item = permissionsItem;
        List<String> list = this.keys;
        if (permissionsItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("item");
        }
        if (list.contains(permissionsItem.getPermissionsKey())) {
            ImageView imageView = this.binding.selectView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.selectView");
            imageView.setVisibility(0);
        } else {
            ImageView imageView2 = this.binding.selectView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.selectView");
            imageView2.setVisibility(8);
        }
        TextView textView = this.binding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        PermissionsAgreeActivity.PermissionsItem permissionsItem2 = this.item;
        if (permissionsItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("item");
        }
        textView.setText(permissionsItem2.getTitle());
        TextView textView2 = this.binding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        PermissionsAgreeActivity.PermissionsItem permissionsItem3 = this.item;
        if (permissionsItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("item");
        }
        textView2.setText(permissionsItem3.getSubTitle());
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131362768) {
            List<String> list = this.keys;
            PermissionsAgreeActivity.PermissionsItem permissionsItem = this.item;
            if (permissionsItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("item");
            }
            if (list.contains(permissionsItem.getPermissionsKey())) {
                List<String> list2 = this.keys;
                PermissionsAgreeActivity.PermissionsItem permissionsItem2 = this.item;
                if (permissionsItem2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("item");
                }
                list2.remove(permissionsItem2.getPermissionsKey());
                ImageView imageView = this.binding.selectView;
                Intrinsics.checkNotNullExpressionValue(imageView, "binding.selectView");
                imageView.setVisibility(8);
                return;
            }
            List<String> list3 = this.keys;
            PermissionsAgreeActivity.PermissionsItem permissionsItem3 = this.item;
            if (permissionsItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("item");
            }
            list3.add(permissionsItem3.getPermissionsKey());
            ImageView imageView2 = this.binding.selectView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.selectView");
            imageView2.setVisibility(0);
        }
    }
}
