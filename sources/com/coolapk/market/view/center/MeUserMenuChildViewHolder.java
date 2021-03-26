package com.coolapk.market.view.center;

import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemCenterMoreEntranceChildBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.bubble.DragAndDropHelper;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/center/MeUserMenuChildViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterUserMenuPresenter;)V", "binding", "Lcom/coolapk/market/databinding/ItemCenterMoreEntranceChildBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemCenterMoreEntranceChildBinding;", "getPresenter", "()Lcom/coolapk/market/view/center/CenterUserMenuPresenter;", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeUserMenuViewHolder.kt */
final class MeUserMenuChildViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558646;
    private final ItemCenterMoreEntranceChildBinding binding = ((ItemCenterMoreEntranceChildBinding) getBinding());
    private final CenterUserMenuPresenter presenter;

    public final CenterUserMenuPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeUserMenuChildViewHolder(View view, DataBindingComponent dataBindingComponent, CenterUserMenuPresenter centerUserMenuPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(centerUserMenuPresenter, "presenter");
        this.presenter = centerUserMenuPresenter;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public final ItemCenterMoreEntranceChildBinding getBinding() {
        return this.binding;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.view.center.UserMenu");
        UserMenu userMenu = (UserMenu) obj;
        TextView textView = this.binding.bubbleTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.bubbleTextView");
        this.binding.textView.setText(userMenu.getTitleRes());
        this.binding.imageView.setImageResource(userMenu.getIconRes());
        ImageView imageView = this.binding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
        imageView.setImageTintList(ColorStateList.valueOf(userMenu.getTintColor()));
        if (userMenu.getBubbleTintColor() != 0) {
            textView.setBackgroundTintList(ColorStateList.valueOf(userMenu.getBubbleTintColor()));
        } else {
            textView.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        }
        FrameLayout frameLayout = this.binding.itemView;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.itemView");
        ViewExtendsKt.setUtilClickListener(frameLayout, new MeUserMenuChildViewHolder$bindTo$1(this, userMenu));
        this.binding.executePendingBindings();
        textView.setText(userMenu.getBubbleText());
        textView.setVisibility(userMenu.getShowBubble() ? 0 : 8);
        if (textView.getVisibility() == 8) {
            ViewParent parent = textView.getParent();
            Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).setTouchDelegate(null);
            textView.setOnTouchListener(null);
            return;
        }
        DragAndDropHelper.withTarget(textView).setPaintColor(AppHolder.getAppTheme().getColorAccent()).setDragListener(new MeUserMenuChildViewHolder$bindTo$2(this, userMenu)).apply();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/MeUserMenuChildViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MeUserMenuViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
