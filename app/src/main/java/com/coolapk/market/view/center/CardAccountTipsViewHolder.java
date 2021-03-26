package com.coolapk.market.view.center;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemAccountTipsBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.model.Tips;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\nH\u0002J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/center/CardAccountTipsViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterPresenter;", "ignoreTipSet", "Ljava/util/HashSet;", "Lcom/coolapk/market/model/Tips;", "Lkotlin/collections/HashSet;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterPresenter;Ljava/util/HashSet;)V", "binding", "Lcom/coolapk/market/databinding/ItemAccountTipsBinding;", "kotlin.jvm.PlatformType", "fragment", "Lcom/coolapk/market/view/center/CenterV9Fragment;", "getPresenter", "()Lcom/coolapk/market/view/center/CenterPresenter;", "bindTo", "", "data", "", "hideTips", "tips", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CardAccountTipsViewHolder.kt */
public final class CardAccountTipsViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558572;
    private final ItemAccountTipsBinding binding;
    private CenterV9Fragment fragment;
    private final HashSet<Tips> ignoreTipSet;
    private final CenterPresenter presenter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardAccountTipsViewHolder(View view, DataBindingComponent dataBindingComponent, CenterPresenter centerPresenter, HashSet<Tips> hashSet) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(centerPresenter, "presenter");
        Intrinsics.checkNotNullParameter(hashSet, "ignoreTipSet");
        this.presenter = centerPresenter;
        this.ignoreTipSet = hashSet;
        ItemAccountTipsBinding itemAccountTipsBinding = (ItemAccountTipsBinding) getBinding();
        this.binding = itemAccountTipsBinding;
        Intrinsics.checkNotNullExpressionValue(itemAccountTipsBinding, "binding");
        itemAccountTipsBinding.setClick(this);
        TextView textView = itemAccountTipsBinding.buttonView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.buttonView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), ResourceUtils.getColorInt(getContext(), 2131099688));
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 10));
        Unit unit = Unit.INSTANCE;
        textView.setBackground(gradientDrawable);
        itemAccountTipsBinding.coolapkCardView.setCardBackgroundColor(ColorUtils.adjustAlpha(ResourceUtils.getColorInt(getContext(), 2131099688), 0.1f));
    }

    public final CenterPresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/CardAccountTipsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CardAccountTipsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Tips tips;
        super.onClick(view);
        String str = null;
        Tips tips2 = null;
        str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == 2131362257) {
            UserProfile userProfile = this.presenter.getUserProfile();
            if (userProfile != null) {
                tips2 = userProfile.getTips();
            }
            if (tips2 != null) {
                hideTips(tips2);
            }
        } else if (valueOf != null && valueOf.intValue() == 2131363562) {
            this.presenter.requestForceReloadUserProfile();
            UserProfile userProfile2 = this.presenter.getUserProfile();
            if (!(userProfile2 == null || (tips = userProfile2.getTips()) == null)) {
                str = tips.getUrl();
            }
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl$default(context, str, null, null, 12, null);
            }
        }
    }

    private final void hideTips(Tips tips) {
        this.ignoreTipSet.add(tips);
        CenterV9Fragment centerV9Fragment = this.fragment;
        if (centerV9Fragment != null && (centerV9Fragment instanceof CenterV9Fragment) && centerV9Fragment != null) {
            centerV9Fragment.removeTips();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        DataBindingComponent component = getComponent();
        LifecycleOwner lifecycleOwner = null;
        if (!(component instanceof FragmentBindingComponent)) {
            component = null;
        }
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (lifecycleOwner2 instanceof CenterV9Fragment) {
            lifecycleOwner = lifecycleOwner2;
        }
        this.fragment = (CenterV9Fragment) lifecycleOwner;
        ItemAccountTipsBinding itemAccountTipsBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemAccountTipsBinding, "binding");
        itemAccountTipsBinding.setModel(this.presenter.getUserProfile());
        this.binding.executePendingBindings();
    }
}
