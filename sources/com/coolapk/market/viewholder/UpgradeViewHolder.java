package com.coolapk.market.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemUpgradeBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.model.DownloadState;
import com.coolapk.market.model.IgnoreInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.expandable.ExpandTextView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*H\u0016R\u0011\u0010\r\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\b8G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u0011\u0010\"\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b#\u0010\u000f¨\u0006,"}, d2 = {"Lcom/coolapk/market/viewholder/UpgradeViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "expandStatus", "Ljava/util/HashMap;", "", "", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Ljava/util/HashMap;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "actionButtonBackground", "getActionButtonBackground", "()Ljava/lang/String;", "actionButtonTextColor", "", "getActionButtonTextColor", "()I", "actionText", "getActionText", "apkSizePainFlags", "getApkSizePainFlags", "description", "getDescription", "isIgnoreTagShow", "()Z", "mobileApp", "Lcom/coolapk/market/model/MobileApp;", "time", "getTime", "upgradeInfo", "Lcom/coolapk/market/model/UpgradeInfo;", "versionInfo", "getVersionInfo", "bindTo", "", "data", "", "onStateEventChanged", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UpgradeViewHolder.kt */
public final class UpgradeViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558972;
    private final HashMap<String, Boolean> expandStatus;
    private MobileApp mobileApp;
    private UpgradeInfo upgradeInfo;

    public static final /* synthetic */ MobileApp access$getMobileApp$p(UpgradeViewHolder upgradeViewHolder) {
        MobileApp mobileApp2 = upgradeViewHolder.mobileApp;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        return mobileApp2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UpgradeViewHolder(View view, DataBindingComponent dataBindingComponent, HashMap<String, Boolean> hashMap, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(hashMap, "expandStatus");
        Intrinsics.checkNotNullParameter(itemActionHandler, "onItemClick");
        this.expandStatus = hashMap;
        ViewUtil.clickListener(view, this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/UpgradeViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UpgradeViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Bindable
    public final String getVersionInfo() {
        StringBuilder sb = new StringBuilder();
        MobileApp mobileApp2 = this.mobileApp;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        sb.append(mobileApp2.getVersionName());
        sb.append(" > ");
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        sb.append(upgradeInfo2.getDisplayVersionName());
        String sb2 = sb.toString();
        MobileApp mobileApp3 = this.mobileApp;
        if (mobileApp3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        String versionName = mobileApp3.getVersionName();
        UpgradeInfo upgradeInfo3 = this.upgradeInfo;
        if (upgradeInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        if (!TextUtils.equals(versionName, upgradeInfo3.getDisplayVersionName())) {
            return sb2;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(" (");
        UpgradeInfo upgradeInfo4 = this.upgradeInfo;
        if (upgradeInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        sb3.append(upgradeInfo4.getVersionCode());
        sb3.append(")");
        return sb3.toString();
    }

    @Bindable
    public final String getTime() {
        Context context = getContext();
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        String timeDescription = DateUtils.getTimeDescription(context, Long.valueOf(upgradeInfo2.getLastUpdate()));
        Intrinsics.checkNotNullExpressionValue(timeDescription, "DateUtils.getTimeDescrip…, upgradeInfo.lastUpdate)");
        return timeDescription;
    }

    @Bindable
    public final String getDescription() {
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        if (TextUtils.isEmpty(upgradeInfo2.getChangeLog())) {
            return getContext().getString(2131886950);
        }
        UpgradeInfo upgradeInfo3 = this.upgradeInfo;
        if (upgradeInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        return upgradeInfo3.getChangeLog();
    }

    @Bindable
    public final int getApkSizePainFlags() {
        ItemUpgradeBinding itemUpgradeBinding = (ItemUpgradeBinding) getBinding();
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        if (!TextUtils.isEmpty(upgradeInfo2.getPatchKey())) {
            TextView textView = itemUpgradeBinding.apkSizeView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.apkSizeView");
            return textView.getPaintFlags() | 16;
        }
        TextView textView2 = itemUpgradeBinding.apkSizeView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.apkSizeView");
        return textView2.getPaintFlags() & -17;
    }

    @Bindable
    public final boolean isIgnoreTagShow() {
        MobileApp mobileApp2 = this.mobileApp;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        if (mobileApp2.getIgnoreInfo() != null) {
            MobileApp mobileApp3 = this.mobileApp;
            if (mobileApp3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
            }
            IgnoreInfo ignoreInfo = mobileApp3.getIgnoreInfo();
            Intrinsics.checkNotNull(ignoreInfo);
            Intrinsics.checkNotNullExpressionValue(ignoreInfo, "mobileApp.ignoreInfo!!");
            if (ignoreInfo.getType() == -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x005a: APUT  
      (r3v1 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x0056: INVOKE  (r4v1 java.lang.String) = (r4v0 com.coolapk.market.model.UpgradeInfo), (0 int) type: VIRTUAL call: com.coolapk.market.model.UpgradeInfo.getDownloadUrlMd5(int):java.lang.String)
     */
    @Bindable
    public final String getActionText() {
        MobileApp mobileApp2 = this.mobileApp;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        if (mobileApp2.getIgnoreInfo() != null) {
            MobileApp mobileApp3 = this.mobileApp;
            if (mobileApp3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
            }
            IgnoreInfo ignoreInfo = mobileApp3.getIgnoreInfo();
            Intrinsics.checkNotNull(ignoreInfo);
            Intrinsics.checkNotNullExpressionValue(ignoreInfo, "mobileApp.ignoreInfo!!");
            if (ignoreInfo.getType() != 0) {
                String string = getContext().getString(2131886697);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.str_cancel_ignore)");
                return string;
            }
        }
        Context context = getContext();
        MobileApp mobileApp4 = this.mobileApp;
        if (mobileApp4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        String packageName = mobileApp4.getPackageName();
        String[] strArr = new String[2];
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[0] = upgradeInfo2.getDownloadUrlMd5(0);
        UpgradeInfo upgradeInfo3 = this.upgradeInfo;
        if (upgradeInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[1] = upgradeInfo3.getDownloadUrlMd5(1);
        String actionText = StateUtils.getActionText(context, packageName, null, strArr);
        Intrinsics.checkNotNullExpressionValue(actionText, "StateUtils.getActionText…DOWNLOAD_URL_TYPE_PATCH))");
        return actionText;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0011: APUT  
      (r0v1 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x000d: INVOKE  (r1v1 java.lang.String) = (r1v0 com.coolapk.market.model.UpgradeInfo), (0 int) type: VIRTUAL call: com.coolapk.market.model.UpgradeInfo.getDownloadUrlMd5(int):java.lang.String)
     */
    @Bindable
    public final String getActionButtonBackground() {
        String[] strArr = new String[2];
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[0] = upgradeInfo2.getDownloadUrlMd5(0);
        UpgradeInfo upgradeInfo3 = this.upgradeInfo;
        if (upgradeInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[1] = upgradeInfo3.getDownloadUrlMd5(1);
        String actionButtonBackground = StateUtils.getActionButtonBackground(StateUtils.findLatestDownloadState(strArr));
        Intrinsics.checkNotNullExpressionValue(actionButtonBackground, "StateUtils.getActionButt…Background(downloadState)");
        return actionButtonBackground;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0011: APUT  
      (r0v1 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x000d: INVOKE  (r1v1 java.lang.String) = (r1v0 com.coolapk.market.model.UpgradeInfo), (0 int) type: VIRTUAL call: com.coolapk.market.model.UpgradeInfo.getDownloadUrlMd5(int):java.lang.String)
     */
    @Bindable
    public final int getActionButtonTextColor() {
        String[] strArr = new String[2];
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[0] = upgradeInfo2.getDownloadUrlMd5(0);
        UpgradeInfo upgradeInfo3 = this.upgradeInfo;
        if (upgradeInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[1] = upgradeInfo3.getDownloadUrlMd5(1);
        return StateUtils.getActionButtonTextColor(StateUtils.findLatestDownloadState(strArr));
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        UpgradeInfo upgradeInfo2 = this.upgradeInfo;
        if (upgradeInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        return StateViewHolder.isEventBelongTo(event, upgradeInfo2);
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0048: APUT  
      (r1v5 java.lang.String[])
      (0 ??[int, short, byte, char])
      (wrap: java.lang.String : 0x0044: INVOKE  (r2v1 java.lang.String) = (r2v0 com.coolapk.market.model.UpgradeInfo), (0 int) type: VIRTUAL call: com.coolapk.market.model.UpgradeInfo.getDownloadUrlMd5(int):java.lang.String)
     */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        MobileApp mobileApp2 = (MobileApp) obj;
        this.mobileApp = mobileApp2;
        if (mobileApp2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        UpgradeInfo upgradeInfo2 = mobileApp2.getUpgradeInfo();
        Intrinsics.checkNotNull(upgradeInfo2);
        this.upgradeInfo = upgradeInfo2;
        ItemUpgradeBinding itemUpgradeBinding = (ItemUpgradeBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemUpgradeBinding, "binding");
        MobileApp mobileApp3 = this.mobileApp;
        if (mobileApp3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        itemUpgradeBinding.setApp(mobileApp3);
        itemUpgradeBinding.setViewHolder(this);
        itemUpgradeBinding.executePendingBindings();
        String[] strArr = new String[2];
        UpgradeInfo upgradeInfo3 = this.upgradeInfo;
        if (upgradeInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[0] = upgradeInfo3.getDownloadUrlMd5(0);
        UpgradeInfo upgradeInfo4 = this.upgradeInfo;
        if (upgradeInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("upgradeInfo");
        }
        strArr[1] = upgradeInfo4.getDownloadUrlMd5(1);
        DownloadState findLatestDownloadState = StateUtils.findLatestDownloadState(strArr);
        ActionButtonFrameLayout actionButtonFrameLayout = itemUpgradeBinding.actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButtonFrameLayout, "binding.actionContainer");
        StateUtils.updateActionProgress(findLatestDownloadState, actionButtonFrameLayout.getBackground());
        itemUpgradeBinding.upgradeInfoView.setMaxCollapsedLines(3);
        itemUpgradeBinding.upgradeInfoView.setText(getDescription());
        ExpandTextView expandTextView = itemUpgradeBinding.upgradeInfoView;
        HashMap<String, Boolean> hashMap = this.expandStatus;
        MobileApp mobileApp4 = this.mobileApp;
        if (mobileApp4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mobileApp");
        }
        expandTextView.setState(Intrinsics.areEqual((Object) hashMap.get(mobileApp4.getPackageName()), (Object) true));
        itemUpgradeBinding.upgradeInfoView.setOnStateChangeListener(new UpgradeViewHolder$bindTo$1(this));
    }
}
