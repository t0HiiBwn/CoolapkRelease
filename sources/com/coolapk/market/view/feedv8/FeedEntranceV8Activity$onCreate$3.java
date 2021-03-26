package com.coolapk.market.view.feedv8;

import android.graphics.Color;
import com.coolapk.market.AppMetadataKt;
import com.coolapk.market.manager.UserPermissionChecker;
import com.coolapk.market.view.feedv8.FeedEntranceV8Activity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"createEntranceItems", "", "Lcom/coolapk/market/view/feedv8/FeedEntranceV8Activity$EntranceItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: FeedEntranceV8Activity.kt */
final class FeedEntranceV8Activity$onCreate$3 extends Lambda implements Function0<List<? extends FeedEntranceV8Activity.EntranceItem>> {
    public static final FeedEntranceV8Activity$onCreate$3 INSTANCE = new FeedEntranceV8Activity$onCreate$3();

    FeedEntranceV8Activity$onCreate$3() {
        super(0);
    }

    /* Return type fixed from 'java.util.List<com.coolapk.market.view.feedv8.FeedEntranceV8Activity$EntranceItem>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public final List<? extends FeedEntranceV8Activity.EntranceItem> invoke() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.CoolPic, "酷图", Color.parseColor("#FFA726"), 2131231399, false, 16, null));
        arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.Question, "提问", Color.parseColor("#BE6ACC"), 2131231624, false, 16, null));
        arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.SecondHand, "二手", Color.parseColor("#EC407A"), 2131231546, false, 16, null));
        arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.Scan, "扫一扫", Color.parseColor("#FF6433"), 2131231535, false, 16, null));
        AppMetadataKt.runOnAppMode$default(arrayList, null, FeedEntranceV8Activity$onCreate$3$1$1.INSTANCE, null, new FeedEntranceV8Activity$onCreate$3$1$2(arrayList), 5, null);
        if (UserPermissionChecker.INSTANCE.getCanCreateNewVote()) {
            arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.Vote, "投票", Color.parseColor("#2296F3"), 2131231655, false, 16, null));
        } else {
            arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.Topic, "话题", Color.parseColor("#42A5F5"), 2131231366, false, 16, null));
        }
        arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.Goods, "好物", Color.parseColor("#FA70E1"), 2131231342, true));
        arrayList.add(new FeedEntranceV8Activity.EntranceItem(FeedEntranceV8Activity.EntranceType.GoodsList, "好物单", Color.parseColor("#66BB6A"), 2131231344, true));
        return arrayList;
    }
}
