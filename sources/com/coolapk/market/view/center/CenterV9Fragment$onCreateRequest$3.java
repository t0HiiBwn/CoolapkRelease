package com.coolapk.market.view.center;

import com.coolapk.market.AppHolder;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.Tips;
import com.coolapk.market.model.UserProfile;
import java.util.ArrayList;
import kotlin.Metadata;
import rx.functions.Func1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a,\u0012\u0004\u0012\u00020\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00030\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "it", "Lcom/coolapk/market/model/UserProfile;", "call"}, k = 3, mv = {1, 4, 2})
/* compiled from: CenterV9Fragment.kt */
final class CenterV9Fragment$onCreateRequest$3<T, R> implements Func1<UserProfile, ArrayList<Entity>> {
    final /* synthetic */ int $updateNum;
    final /* synthetic */ CenterV9Fragment this$0;

    CenterV9Fragment$onCreateRequest$3(CenterV9Fragment centerV9Fragment, int i) {
        this.this$0 = centerV9Fragment;
        this.$updateNum = i;
    }

    public final ArrayList<Entity> call(UserProfile userProfile) {
        ArrayList<Entity> arrayList = new ArrayList<>();
        arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_info").entityFixed(1).build());
        arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_info_num").entityFixed(1).build());
        UserProfile userProfile2 = this.this$0.centerPresenter.getUserProfile();
        Tips tips = userProfile2 != null ? userProfile2.getTips() : null;
        if (tips != null && !this.this$0.ignoreTipSet.contains(tips)) {
            arrayList.add(HolderItem.newBuilder().entityType("accountTipsCard").entityFixed(1).build());
        }
        if (!AppHolder.getAppMetadata().isCommunityMode() && this.$updateNum > 0 && !(this.this$0.disableShowUpgradeAppCard())) {
            arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_updata_manager").entityFixed(1).build());
        }
        arrayList.add(HolderItem.newBuilder().entityType("entity_type_user_menu").entityFixed(1).build());
        return arrayList;
    }
}
