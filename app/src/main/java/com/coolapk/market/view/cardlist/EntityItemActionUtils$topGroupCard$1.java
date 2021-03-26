package com.coolapk.market.view.cardlist;

import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.TopCard;
import com.coolapk.market.model.TopGroupCard;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.viewholder.ItemActionHandler;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/coolapk/market/view/cardlist/EntityItemActionUtils$topGroupCard$1", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onItemClick", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityItemActionUtils.kt */
public final class EntityItemActionUtils$topGroupCard$1 extends ItemActionHandler {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ EntityListFragment $fragment;

    EntityItemActionUtils$topGroupCard$1(EntityListFragment entityListFragment, FragmentActivity fragmentActivity) {
        this.$fragment = entityListFragment;
        this.$activity = fragmentActivity;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x01be: APUT  (r2v5 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r12v13 java.lang.String) */
    @Override // com.coolapk.market.viewholder.ItemActionHandler
    public void onItemClick(RecyclerView.ViewHolder viewHolder, View view) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(view, "view");
        if (viewHolder.getAdapterPosition() != -1) {
            Parcelable parcelable = this.$fragment.getDataList().get(this.$fragment.getDataIndex(viewHolder.getAdapterPosition()));
            int id = view.getId();
            if (id == 2131361876) {
                Object tag = view.getTag();
                Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.Int");
                int intValue = ((Integer) tag).intValue();
                Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.TopGroupCard");
                List<TopCard> entities = ((TopGroupCard) parcelable).getEntities();
                Intrinsics.checkNotNull(entities);
                TopCard topCard = entities.get(2);
                Intrinsics.checkNotNullExpressionValue(topCard, "(entity as TopGroupCard).entities!![2]");
                List<ServiceApp> entities2 = topCard.getEntities();
                Intrinsics.checkNotNull(entities2);
                ServiceApp serviceApp = entities2.get(intValue);
                UpgradeInfo upgradeInfo = null;
                DataManager instance = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(serviceApp, "serviceApp");
                MobileApp mobileAppExistFast = instance.getMobileAppExistFast(serviceApp.getPackageName());
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
            } else if (id != 2131362768) {
                switch (id) {
                    case 2131362781:
                        Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.TopGroupCard");
                        List<TopCard> entities3 = ((TopGroupCard) parcelable).getEntities();
                        Intrinsics.checkNotNull(entities3);
                        TopCard topCard2 = entities3.get(0);
                        Intrinsics.checkNotNullExpressionValue(topCard2, "topCard");
                        ActionManagerCompat.startActivityByUrl(this.$activity, topCard2.getSubUrl(), topCard2.getTitle(), topCard2.getSubTitle());
                        return;
                    case 2131362782:
                        Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.TopGroupCard");
                        List<TopCard> entities4 = ((TopGroupCard) parcelable).getEntities();
                        Intrinsics.checkNotNull(entities4);
                        TopCard topCard3 = entities4.get(1);
                        Intrinsics.checkNotNullExpressionValue(topCard3, "topCard");
                        ActionManagerCompat.startActivityByUrl(this.$activity, topCard3.getSubUrl(), topCard3.getTitle(), topCard3.getSubTitle());
                        return;
                    case 2131362783:
                        Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.TopGroupCard");
                        List<TopCard> entities5 = ((TopGroupCard) parcelable).getEntities();
                        Intrinsics.checkNotNull(entities5);
                        TopCard topCard4 = entities5.get(0);
                        Intrinsics.checkNotNullExpressionValue(topCard4, "topCard");
                        ActionManagerCompat.startActivityByUrl(this.$activity, topCard4.getUrl(), topCard4.getTitle(), topCard4.getSubTitle());
                        return;
                    case 2131362784:
                        Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.TopGroupCard");
                        List<TopCard> entities6 = ((TopGroupCard) parcelable).getEntities();
                        Intrinsics.checkNotNull(entities6);
                        TopCard topCard5 = entities6.get(1);
                        Intrinsics.checkNotNullExpressionValue(topCard5, "topCard");
                        ActionManagerCompat.startActivityByUrl(this.$activity, topCard5.getUrl(), topCard5.getTitle(), topCard5.getSubTitle());
                        return;
                    default:
                        return;
                }
            } else {
                Object tag2 = view.getTag();
                Objects.requireNonNull(tag2, "null cannot be cast to non-null type kotlin.Int");
                int intValue2 = ((Integer) tag2).intValue();
                Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coolapk.market.model.TopGroupCard");
                List<TopCard> entities7 = ((TopGroupCard) parcelable).getEntities();
                Intrinsics.checkNotNull(entities7);
                TopCard topCard6 = entities7.get(2);
                Intrinsics.checkNotNullExpressionValue(topCard6, "(entity as TopGroupCard).entities!![2]");
                List<ServiceApp> entities8 = topCard6.getEntities();
                Intrinsics.checkNotNull(entities8);
                ServiceApp serviceApp2 = entities8.get(intValue2);
                View findViewById = view.findViewById(2131362672);
                Intrinsics.checkNotNullExpressionValue(serviceApp2, "serviceApp");
                ActionManager.startAppViewActivity(this.$activity, findViewById, serviceApp2.getPackageName(), serviceApp2.getLogo(), serviceApp2.getAppName(), serviceApp2.getExtraAnalysisData(), serviceApp2.getRequestContext(), serviceApp2.getExtraFromApi());
            }
        }
    }
}
