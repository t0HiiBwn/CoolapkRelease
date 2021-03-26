package com.coolapk.market.view.cardlist;

import android.content.DialogInterface;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemUpgradeCardBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.base.SimpleDialog;
import com.coolapk.market.viewholder.StateViewHolder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX.¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/view/cardlist/UpgradeCardViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "apps", "", "Lcom/coolapk/market/model/MobileApp;", "binding", "Lcom/coolapk/market/databinding/ItemUpgradeCardBinding;", "kotlin.jvm.PlatformType", "bindTo", "", "data", "", "onClick", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MainV8ListFragment.kt */
public final class UpgradeCardViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558966;
    private List<? extends MobileApp> apps;
    private final ItemUpgradeCardBinding binding = ((ItemUpgradeCardBinding) getBinding());

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpgradeCardViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/cardlist/UpgradeCardViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MainV8ListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: com.coolapk.market.databinding.ItemUpgradeCardBinding */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        List<MobileApp> mobileAppUpgradeListFast = DataManager.getInstance().getMobileAppUpgradeListFast(false);
        Intrinsics.checkNotNullExpressionValue(mobileAppUpgradeListFast, "it");
        if (mobileAppUpgradeListFast.size() > 1) {
            CollectionsKt.sortWith(mobileAppUpgradeListFast, new UpgradeCardViewHolder$$special$$inlined$sortByDescending$1());
        }
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(mobileAppUpgradeListFast, "DataManager.getInstance(…!!.lastUpdate }\n        }");
        this.apps = mobileAppUpgradeListFast;
        ItemUpgradeCardBinding itemUpgradeCardBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemUpgradeCardBinding, "binding");
        List<? extends MobileApp> list = this.apps;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apps");
        }
        itemUpgradeCardBinding.setApps(list);
        ItemUpgradeCardBinding itemUpgradeCardBinding2 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemUpgradeCardBinding2, "binding");
        itemUpgradeCardBinding2.setClick(this);
        this.binding.executePendingBindings();
        List<? extends MobileApp> list2 = this.apps;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apps");
        }
        if (list2.isEmpty()) {
            try {
                this.itemView.post(new UpgradeCardViewHolder$bindTo$2(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        List<? extends MobileApp> list = this.apps;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("apps");
        }
        List<? extends MobileApp> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = list2.iterator();
        while (it2.hasNext()) {
            if (StateViewHolder.isEventBelongTo(event, (MobileApp) it2.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != 2131361876) {
            if (id == 2131362374) {
                DataBindingComponent component = getComponent();
                if (component instanceof FragmentBindingComponent) {
                    Fragment fragment = (Fragment) ((FragmentBindingComponent) component).getContainer();
                    Objects.requireNonNull(fragment, "null cannot be cast to non-null type com.coolapk.market.view.cardlist.MainV8ListFragment");
                    MainV8ListFragment mainV8ListFragment = (MainV8ListFragment) fragment;
                    SimpleDialog newInstance = SimpleDialog.newInstance();
                    newInstance.setMessage("不想显示应用更新提醒卡片么？本卡片只会在酷安刚刚启动的时候显示");
                    newInstance.setPositiveButton("本次不显示", new UpgradeCardViewHolder$onClick$$inlined$apply$lambda$1(mainV8ListFragment));
                    newInstance.setNegativeButton("取消", (DialogInterface.OnClickListener) null);
                    newInstance.setNeutralButton("不再显示", new UpgradeCardViewHolder$onClick$$inlined$apply$lambda$2(mainV8ListFragment));
                    FragmentManager childFragmentManager = mainV8ListFragment.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                    newInstance.show(childFragmentManager, (String) null);
                    return;
                }
                return;
            } else if (id != 2131362768) {
                return;
            }
        }
        ActionManager.startAppManagerActivity(getContext(), 1);
    }
}
