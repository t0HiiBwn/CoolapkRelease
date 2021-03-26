package com.coolapk.market.viewholder;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.selection.ItemDetailsLookup;
import androidx.recyclerview.selection.SelectionTracker;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemMobileAppBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UninstallState;
import com.coolapk.market.util.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/viewholder/MobileAppViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "tracker", "Landroidx/recyclerview/selection/SelectionTracker;", "", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Landroidx/recyclerview/selection/SelectionTracker;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "actionText", "", "getActionText", "()Ljava/lang/String;", "mobileApp", "Lcom/coolapk/market/model/MobileApp;", "bindTo", "", "data", "", "getBackground", "Landroid/graphics/drawable/StateListDrawable;", "getItemDetails", "Landroidx/recyclerview/selection/ItemDetailsLookup$ItemDetails;", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MobileAppViewHolder.kt */
public final class MobileAppViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558829;
    private MobileApp mobileApp;
    private final SelectionTracker<Long> tracker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MobileAppViewHolder(View view, DataBindingComponent dataBindingComponent, SelectionTracker<Long> selectionTracker, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(selectionTracker, "tracker");
        Intrinsics.checkNotNullParameter(itemActionHandler, "onItemClick");
        this.tracker = selectionTracker;
        ViewUtil.clickListener(view, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/MobileAppViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MobileAppViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Bindable
    public final String getActionText() {
        DataManager instance = DataManager.getInstance();
        MobileApp mobileApp2 = this.mobileApp;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        UninstallState uninstallState = instance.getUninstallState(mobileApp2.getPackageName());
        if (uninstallState != null) {
            int state = uninstallState.getState();
            if (state == 1) {
                String string = getContext().getString(2131887050);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.str_uninstall_wait)");
                return string;
            } else if (state == 2) {
                String string2 = getContext().getString(2131887049);
                Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…r_uninstall_uninstalling)");
                return string2;
            }
        }
        String string3 = getContext().getString(2131886154);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.action_uninstall)");
        return string3;
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        MobileApp mobileApp2 = this.mobileApp;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        return StateViewHolder.isEventBelongTo(event, mobileApp2);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        this.mobileApp = (MobileApp) obj;
        ItemMobileAppBinding itemMobileAppBinding = (ItemMobileAppBinding) getBinding();
        LinearLayout linearLayout = itemMobileAppBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        linearLayout.setBackground(getBackground());
        Intrinsics.checkNotNullExpressionValue(itemMobileAppBinding, "binding");
        itemMobileAppBinding.setViewHolder(this);
        MobileApp mobileApp2 = this.mobileApp;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        itemMobileAppBinding.setApp(mobileApp2);
        itemMobileAppBinding.executePendingBindings();
        LinearLayout linearLayout2 = itemMobileAppBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.itemView");
        SelectionTracker<Long> selectionTracker = this.tracker;
        MobileApp mobileApp3 = this.mobileApp;
        if (mobileApp3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        linearLayout2.setActivated(selectionTracker.isSelected(Long.valueOf(mobileApp3.getDbId())));
    }

    public final ItemDetailsLookup.ItemDetails<Long> getItemDetails() {
        return new MobileAppViewHolder$getItemDetails$1(this);
    }

    private final StateListDrawable getBackground() {
        ColorDrawable colorDrawable = new ColorDrawable(AppHolder.getAppTheme().getColorControlActivated());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16843518}, colorDrawable);
        stateListDrawable.addState(StateSet.WILD_CARD, null);
        return stateListDrawable;
    }
}
