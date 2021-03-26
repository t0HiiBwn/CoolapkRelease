package com.coolapk.market.view.feed.vote;

import android.app.Activity;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.Vote;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"com/coolapk/market/view/feed/vote/FeedVoteDetailFragment$onActivityCreated$1", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "bgColor", "", "userItemColor", "modifySheet", "", "data", "", "items", "", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "shouldModify", "", "anchorActivity", "Landroid/app/Activity;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
public final class FeedVoteDetailFragment$onActivityCreated$1 implements SheetGroupModifier {
    private final int bgColor;
    final /* synthetic */ FeedVoteDetailFragment this$0;
    private final int userItemColor;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FeedVoteDetailFragment$onActivityCreated$1(FeedVoteDetailFragment feedVoteDetailFragment) {
        this.this$0 = feedVoteDetailFragment;
        this.bgColor = ResourceUtils.getColorInt(feedVoteDetailFragment.getActivity(), 2131100054);
        this.userItemColor = ResourceUtils.resolveData(feedVoteDetailFragment.getActivity(), 2130969438);
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public boolean shouldModify(Object obj, Activity activity) {
        Intrinsics.checkNotNullParameter(obj, "data");
        return (obj instanceof Feed) && Intrinsics.areEqual(((Feed) obj).getId(), FeedVoteDetailFragment.access$getVoteViewModel$p(this.this$0).getFeed().getId());
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public void modifySheet(Object obj, List<SheetGroup> list) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(list, "items");
        Vote vote = FeedVoteDetailFragment.access$getVoteViewModel$p(this.this$0).getVote();
        if (EntityExtendsKt.isUserVoted(vote) && !FeedVoteDetailFragment.access$getVoteViewModel$p(this.this$0).getUserCommented() && !EntityExtendsKt.isFinished(vote)) {
            boolean isUserHaveModifiedVote = EntityExtendsKt.isUserHaveModifiedVote(FeedVoteDetailFragment.access$getVoteViewModel$p(this.this$0).getVote());
            String str = isUserHaveModifiedVote ? "不可修改" : "修改投票";
            String str2 = isUserHaveModifiedVote ? "已投票" : "";
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t = null;
                    break;
                }
                t = it2.next();
                if (t.getType() == SheetGroupType.FeedUser) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                t2.getItems().add(0, new SheetDataItem(SheetGroupModifier.Action.One, str, SheetDataItem.Companion.createIconBgApplyer(2131231621, this.userItemColor, this.bgColor), new FeedVoteDetailFragment$onActivityCreated$1$modifySheet$$inlined$also$lambda$1(this, str, str2), str2, 0, false, false, 224, null));
            }
        }
    }
}
