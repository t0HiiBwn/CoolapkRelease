package com.coolapk.market.view.center;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemCenterMoreEntranceChildBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreEntranceChildViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterMorePresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterMorePresenter;)V", "binding", "Lcom/coolapk/market/databinding/ItemCenterMoreEntranceChildBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemCenterMoreEntranceChildBinding;", "isInDragState", "", "()Z", "setInDragState", "(Z)V", "getPresenter", "()Lcom/coolapk/market/view/center/CenterMorePresenter;", "bindTo", "", "data", "", "onDragClear", "onDragSelected", "setBubbleUI", "userMenu", "Lcom/coolapk/market/view/center/UserMenu;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterMoreEntranceViewHolder.kt */
final class CenterMoreEntranceChildViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558640;
    private final ItemCenterMoreEntranceChildBinding binding = ((ItemCenterMoreEntranceChildBinding) getBinding());
    private boolean isInDragState;
    private final CenterMorePresenter presenter;

    public final CenterMorePresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CenterMoreEntranceChildViewHolder(View view, DataBindingComponent dataBindingComponent, CenterMorePresenter centerMorePresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(centerMorePresenter, "presenter");
        this.presenter = centerMorePresenter;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final ItemCenterMoreEntranceChildBinding getBinding() {
        return this.binding;
    }

    public final boolean isInDragState() {
        return this.isInDragState;
    }

    public final void setInDragState(boolean z) {
        this.isInDragState = z;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.center.UserMenu");
        UserMenu userMenu = (UserMenu) obj;
        this.binding.textView.setText(userMenu.getTitleRes());
        this.binding.imageView.setImageResource(userMenu.getIconRes());
        ImageView imageView = this.binding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
        imageView.setImageTintList(ColorStateList.valueOf(userMenu.getTintColor()));
        int i = 8;
        if (this.presenter.isEditing()) {
            FrameLayout frameLayout = this.binding.deleteView;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.deleteView");
            if (userMenu.getDeletable()) {
                i = 0;
            }
            frameLayout.setVisibility(i);
            FrameLayout frameLayout2 = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.itemView");
            ViewExtendsKt.setUtilClickListener(frameLayout2, new CenterMoreEntranceChildViewHolder$bindTo$1(this, userMenu));
        } else {
            FrameLayout frameLayout3 = this.binding.deleteView;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.deleteView");
            frameLayout3.setVisibility(8);
            FrameLayout frameLayout4 = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.itemView");
            ViewExtendsKt.setUtilClickListener(frameLayout4, new CenterMoreEntranceChildViewHolder$bindTo$2(this, userMenu));
            this.binding.itemView.setOnLongClickListener(new CenterMoreEntranceChildViewHolder$bindTo$3(this));
        }
        this.binding.executePendingBindings();
        setBubbleUI(userMenu);
    }

    private final void setBubbleUI(UserMenu userMenu) {
        TextView textView = this.binding.bubbleTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.bubbleTextView");
        textView.setText(userMenu.getBubbleText());
        textView.setVisibility((!userMenu.getShowBubble() || this.presenter.isEditing()) ? 8 : 0);
        if (textView.getVisibility() != 8) {
            DragAndDropHelper.withTarget(textView).setPaintColor(AppHolder.getAppTheme().getColorAccent()).setDragListener(new CenterMoreEntranceChildViewHolder$setBubbleUI$1(this, userMenu)).apply();
        }
    }

    public final void onDragSelected() {
        this.isInDragState = true;
        this.binding.itemView.animate().scaleX(1.1f).scaleY(1.1f).z((float) NumberExtendsKt.getDp((Number) 8)).start();
    }

    public final void onDragClear() {
        this.isInDragState = false;
        this.binding.itemView.animate().scaleX(1.0f).scaleY(1.0f).z(0.0f).start();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreEntranceChildViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterMoreEntranceViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
