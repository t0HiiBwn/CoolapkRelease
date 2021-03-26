package com.coolapk.market.view.backupList;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.ItemLocalAppBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.viewholder.StateViewHolder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018H\u0016J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/coolapk/market/view/backupList/AppViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "appMap", "", "", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;Ljava/util/Map;)V", "app", "Lcom/coolapk/market/model/MobileApp;", "getAppMap", "()Ljava/util/Map;", "setAppMap", "(Ljava/util/Map;)V", "binding", "Lcom/coolapk/market/databinding/ItemLocalAppBinding;", "checkBox", "Landroid/widget/CheckBox;", "hasTarget", "", "isCheck", "target", "bindTo", "", "data", "", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "onStateEventChanged", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppViewHolder.kt */
public final class AppViewHolder extends StateViewHolder implements CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558819;
    private MobileApp app;
    private Map<String, String> appMap;
    private ItemLocalAppBinding binding;
    private CheckBox checkBox;
    private boolean hasTarget;
    private boolean isCheck;
    private String target;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler, Map<String, String> map) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(map, "appMap");
        this.appMap = map;
    }

    public static final /* synthetic */ ItemLocalAppBinding access$getBinding$p(AppViewHolder appViewHolder) {
        ItemLocalAppBinding itemLocalAppBinding = appViewHolder.binding;
        if (itemLocalAppBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return itemLocalAppBinding;
    }

    public static final /* synthetic */ CheckBox access$getCheckBox$p(AppViewHolder appViewHolder) {
        CheckBox checkBox2 = appViewHolder.checkBox;
        if (checkBox2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        }
        return checkBox2;
    }

    public final Map<String, String> getAppMap() {
        return this.appMap;
    }

    public final void setAppMap(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.appMap = map;
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return StateViewHolder.isEventBelongTo(event, this.app);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        this.app = (MobileApp) obj;
        ViewDataBinding binding2 = getBinding();
        Intrinsics.checkNotNullExpressionValue(binding2, "getBinding()");
        ItemLocalAppBinding itemLocalAppBinding = (ItemLocalAppBinding) binding2;
        this.binding = itemLocalAppBinding;
        if (itemLocalAppBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        CheckBox checkBox2 = itemLocalAppBinding.mobileAppCheckView;
        Intrinsics.checkNotNullExpressionValue(checkBox2, "binding.mobileAppCheckView");
        this.checkBox = checkBox2;
        Map<String, String> map = this.appMap;
        MobileApp mobileApp = this.app;
        Intrinsics.checkNotNull(mobileApp);
        this.isCheck = map.containsKey(mobileApp.getPackageName());
        CheckBox checkBox3 = this.checkBox;
        if (checkBox3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        }
        checkBox3.setChecked(this.isCheck);
        CheckBox checkBox4 = this.checkBox;
        if (checkBox4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
        }
        checkBox4.setOnCheckedChangeListener(this);
        ItemLocalAppBinding itemLocalAppBinding2 = this.binding;
        if (itemLocalAppBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLocalAppBinding2.setViewHolder(this);
        ItemLocalAppBinding itemLocalAppBinding3 = this.binding;
        if (itemLocalAppBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLocalAppBinding3.setApp(this.app);
        ItemLocalAppBinding itemLocalAppBinding4 = this.binding;
        if (itemLocalAppBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ViewUtil.clickListener(itemLocalAppBinding4.contentView, new AppViewHolder$bindTo$1(this));
        ItemLocalAppBinding itemLocalAppBinding5 = this.binding;
        if (itemLocalAppBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        itemLocalAppBinding5.executePendingBindings();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "buttonView");
        this.isCheck = z;
        if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
            MobileApp mobileApp = this.app;
            Intrinsics.checkNotNull(mobileApp);
            String packageName = mobileApp.getPackageName();
            this.target = packageName;
            Map<String, String> map = this.appMap;
            Intrinsics.checkNotNull(packageName);
            boolean containsKey = map.containsKey(packageName);
            this.hasTarget = containsKey;
            if (z && !containsKey) {
                Map<String, String> map2 = this.appMap;
                MobileApp mobileApp2 = this.app;
                Intrinsics.checkNotNull(mobileApp2);
                String packageName2 = mobileApp2.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName2, "app!!.packageName");
                MobileApp mobileApp3 = this.app;
                Intrinsics.checkNotNull(mobileApp3);
                String appName = mobileApp3.getAppName();
                Intrinsics.checkNotNullExpressionValue(appName, "app!!.appName");
                map2.put(packageName2, appName);
            } else if (!z && containsKey) {
                Map<String, String> map3 = this.appMap;
                MobileApp mobileApp4 = this.app;
                Intrinsics.checkNotNull(mobileApp4);
                map3.remove(mobileApp4.getPackageName());
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/backupList/AppViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
