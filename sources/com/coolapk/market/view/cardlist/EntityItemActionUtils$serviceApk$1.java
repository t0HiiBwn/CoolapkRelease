package com.coolapk.market.view.cardlist;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ServiceAppBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.ViewHolderExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.view.collectionList.AppViewForCollectionItemDialog;
import com.coolapk.market.view.feed.CancelFollowItemDialog;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/coolapk/market/view/cardlist/EntityItemActionUtils$serviceApk$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onItemLongClick", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityItemActionUtils.kt */
public final class EntityItemActionUtils$serviceApk$1 extends ItemActionHandler {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ EntityListFragment $fragment;

    EntityItemActionUtils$serviceApk$1(FragmentActivity fragmentActivity, EntityListFragment entityListFragment) {
        this.$activity = fragmentActivity;
        this.$fragment = entityListFragment;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x00c7: APUT  (r4v4 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v6 java.lang.String) */
    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        ServiceApp serviceApp = (ServiceApp) view.getTag(2131362764);
        if (serviceApp == null) {
            LogUtils.w("Item data is null", new Object[0]);
            return;
        }
        int id = view.getId();
        if (id == 2131361887) {
            String str = null;
            UpgradeInfo upgradeInfo = null;
            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
            if (mobileAppExistFast != null) {
                upgradeInfo = mobileAppExistFast.getUpgradeInfo();
            }
            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
            String[] strArr = new String[4];
            strArr[0] = serviceApp.getDownloadUrlMd5(0);
            strArr[1] = serviceApp.getDownloadUrlMd5(2);
            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
            if (upgradeInfo != null) {
                str = upgradeInfo.getDownloadUrlMd5(1);
            }
            strArr[3] = str;
            StateUtils.handleClick(this.$activity, targetUrl.downloadKeys(strArr).build(), view);
        } else if (id == 2131362329 || id == 2131362779) {
            BindingViewHolder bindingViewHolder = (BindingViewHolder) viewHolder;
            ImageView imageView = ((ServiceAppBinding) bindingViewHolder.getBinding()).iconView;
            Intrinsics.checkNotNullExpressionValue(imageView, "((holder as BindingViewH…ceAppBinding>()).iconView");
            ActionManager.startAppViewActivity(this.$activity, imageView, serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
            StatisticHelper.recordEntityEvent$default(StatisticHelper.Companion.getInstance(), this.$fragment.getFixedRecordId(), serviceApp, bindingViewHolder.getAdapterPosition(), ViewHolderExtendsKt.findParentEntity(bindingViewHolder), null, 16, null);
        }
    }

    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public boolean onItemLongClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        ServiceApp serviceApp = (ServiceApp) view.getTag(2131362764);
        if (serviceApp == null) {
            LogUtils.w("Item data is null", new Object[0]);
            return false;
        } else if (view.getId() != 2131362779) {
            return super.onItemLongClick(viewHolder, view);
        } else {
            ServiceApp serviceApp2 = serviceApp;
            if (EntityExtendsKt.getIntExtraData(serviceApp2, "showCancelFollowMenu", 0) == 1) {
                CancelFollowItemDialog newInstance = CancelFollowItemDialog.Companion.newInstance(serviceApp2);
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.$activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
                return true;
            }
            Activity currentActivity = AppHolder.getCurrentActivity();
            Intrinsics.checkNotNull(currentActivity);
            Intrinsics.checkNotNullExpressionValue(currentActivity, "AppHolder.getCurrentActivity()!!");
            String localClassName = currentActivity.getLocalClassName();
            Intrinsics.checkNotNullExpressionValue(localClassName, "AppHolder.getCurrentActivity()!!.localClassName");
            Objects.requireNonNull(localClassName, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = localClassName.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "collectiondetail", false, 2, (Object) null)) {
                return false;
            }
            AppViewForCollectionItemDialog newInstance2 = AppViewForCollectionItemDialog.Companion.newInstance(serviceApp);
            FragmentManager childFragmentManager = this.$fragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
            newInstance2.show(childFragmentManager, (String) null);
            return true;
        }
    }
}
