package com.coolapk.market.view.cardlist;

import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.GridCard;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.TabGroupCard;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/cardlist/EntityItemActionUtils$tabGroupCard$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityItemActionUtils.kt */
public final class EntityItemActionUtils$tabGroupCard$1 extends ItemActionHandler {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ EntityListFragment $fragment;

    EntityItemActionUtils$tabGroupCard$1(EntityListFragment entityListFragment, FragmentActivity fragmentActivity) {
        this.$fragment = entityListFragment;
        this.$activity = fragmentActivity;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0155: APUT  (r2v6 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r14v11 java.lang.String) */
    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (viewHolder.getAdapterPosition() != -1) {
            Parcelable parcelable = this.$fragment.getDataList().get(this.$fragment.getDataIndex(viewHolder.getAdapterPosition()));
            Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.TabGroupCard");
            int preferencesInt = DataManager.getInstance().getPreferencesInt("TAB_GROUP_CARD_INDEX", 0);
            List<GridCard> entities = ((TabGroupCard) parcelable).getEntities();
            Intrinsics.checkNotNull(entities);
            GridCard gridCard = entities.get(preferencesInt);
            switch (view.getId()) {
                case 2131362970:
                    Intrinsics.checkNotNullExpressionValue(gridCard, "gridCard");
                    ActionManagerCompat.startActivityByUrl(this.$activity, gridCard.getUrl(), gridCard.getTitle(), gridCard.getSubTitle());
                    return;
                case 2131363483:
                    DataManager instance = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
                    instance.getPreferencesEditor().putInt("TAB_GROUP_CARD_INDEX", 0);
                    this.$fragment.getAdapter$presentation_coolapkAppRelease().notifyItemChanged(viewHolder.getAdapterPosition());
                    return;
                case 2131363484:
                    DataManager instance2 = DataManager.getInstance();
                    Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                    instance2.getPreferencesEditor().putInt("TAB_GROUP_CARD_INDEX", 1);
                    this.$fragment.getAdapter$presentation_coolapkAppRelease().notifyItemChanged(viewHolder.getAdapterPosition());
                    return;
                default:
                    Object tag = view.getTag();
                    Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) tag).intValue();
                    Intrinsics.checkNotNullExpressionValue(gridCard, "gridCard");
                    List<ServiceApp> entities2 = gridCard.getEntities();
                    Intrinsics.checkNotNull(entities2);
                    ServiceApp serviceApp = entities2.get(intValue);
                    int id = view.getId();
                    if (id == 2131361876) {
                        UpgradeInfo upgradeInfo = null;
                        DataManager instance3 = DataManager.getInstance();
                        Intrinsics.checkNotNullExpressionValue(serviceApp, "serviceApp");
                        MobileApp mobileAppExistFast = instance3.getMobileAppExistFast(serviceApp.getPackageName());
                        if (mobileAppExistFast != null) {
                            upgradeInfo = mobileAppExistFast.getUpgradeInfo();
                        }
                        ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
                        String[] strArr = new String[4];
                        strArr[0] = serviceApp.getDownloadUrlMd5(0);
                        strArr[1] = serviceApp.getDownloadUrlMd5(2);
                        strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
                        strArr[3] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(1) : null;
                        StateUtils.handleClick(this.$activity, targetUrl.downloadKeys(strArr).build(), null);
                        return;
                    } else if (id == 2131362768) {
                        View findViewById = view.findViewById(2131362672);
                        Intrinsics.checkNotNullExpressionValue(serviceApp, "serviceApp");
                        ActionManager.startAppViewActivity(this.$activity, findViewById, serviceApp.getPackageName(), serviceApp.getLogo(), serviceApp.getAppName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi());
                        ActionManagerCompat.startActivityByUrl(this.$activity, gridCard.getUrl(), gridCard.getTitle(), gridCard.getSubTitle());
                        return;
                    } else {
                        return;
                    }
            }
        }
    }
}
