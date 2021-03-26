package com.coolapk.market.view.feed.vote;

import androidx.fragment.app.Fragment;
import com.coolapk.market.model.Vote;
import com.coolapk.market.model.VoteOption;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.feed.vote.VoteCommentDataListFragment;
import com.coolapk.market.view.main.DataListViewPagerConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\r"}, d2 = {"com/coolapk/market/view/feed/vote/FeedVoteDetailFragment$initTabAndViewPager$1", "Lcom/coolapk/market/view/main/DataListViewPagerConverter$Callback;", "pageCount", "", "getPageCount", "()I", "tabCount", "getTabCount", "getTitle", "", "index", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedVoteDetailFragment.kt */
public final class FeedVoteDetailFragment$initTabAndViewPager$1 implements DataListViewPagerConverter.Callback {
    final /* synthetic */ List $tabApiList;
    final /* synthetic */ Vote $vote;
    private final int tabCount;
    final /* synthetic */ FeedVoteDetailFragment this$0;

    FeedVoteDetailFragment$initTabAndViewPager$1(FeedVoteDetailFragment feedVoteDetailFragment, List list, Vote vote) {
        this.this$0 = feedVoteDetailFragment;
        this.$tabApiList = list;
        this.$vote = vote;
        this.tabCount = list.size();
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public boolean isTabClickable(int i) {
        return DataListViewPagerConverter.Callback.DefaultImpls.isTabClickable(this, i);
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public void onOpenNewActivity(int i) {
        DataListViewPagerConverter.Callback.DefaultImpls.onOpenNewActivity(this, i);
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public int getTabCount() {
        return this.tabCount;
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public int getPageCount() {
        return this.$tabApiList.size();
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public String getTitle(int i) {
        return (String) ((Pair) this.$tabApiList.get(i)).getFirst();
    }

    @Override // com.coolapk.market.view.main.DataListViewPagerConverter.Callback
    public Fragment onCreateFragment(int i) {
        VoteCommentConfig voteCommentConfig;
        Pair pair = (Pair) this.$tabApiList.get(i);
        if (!(((CharSequence) pair.getSecond()).length() == 0)) {
            return VoteCommentDataListFragment.Companion.newInstance$default(VoteCommentDataListFragment.Companion, (String) pair.getSecond(), null, null, 6, null);
        }
        if (this.$vote.getType() == 0) {
            List<VoteOption> voteOptions = this.$vote.getVoteOptions();
            Intrinsics.checkNotNullExpressionValue(voteOptions, "options");
            List<VoteOption> list = voteOptions;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                arrayList.add(t.getId());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            String[] strArr = (String[]) array;
            VoteOption voteOption = voteOptions.get(0);
            Intrinsics.checkNotNullExpressionValue(voteOption, "options[0]");
            Integer stringToColor = ColorUtils.stringToColor(voteOption.getColor());
            if (stringToColor == null) {
                stringToColor = Integer.valueOf(ResourceUtils.getColorInt(this.this$0.getActivity(), 2131099792));
            }
            Intrinsics.checkNotNullExpressionValue(stringToColor, "ColorUtils.stringToColor…R.color.compare_view_red)");
            int intValue = stringToColor.intValue();
            VoteOption voteOption2 = voteOptions.get(1);
            Intrinsics.checkNotNullExpressionValue(voteOption2, "options[1]");
            Integer stringToColor2 = ColorUtils.stringToColor(voteOption2.getColor());
            if (stringToColor2 == null) {
                stringToColor2 = Integer.valueOf(ResourceUtils.getColorInt(this.this$0.getActivity(), 2131099791));
            }
            Intrinsics.checkNotNullExpressionValue(stringToColor2, "ColorUtils.stringToColor….color.compare_view_blue)");
            int intValue2 = stringToColor2.intValue();
            String id = this.$vote.getId();
            Intrinsics.checkNotNullExpressionValue(id, "vote.id");
            voteCommentConfig = new VoteCommentConfig(id, "", strArr, new int[]{intValue, intValue2});
        } else {
            String id2 = this.$vote.getId();
            Intrinsics.checkNotNullExpressionValue(id2, "vote.id");
            voteCommentConfig = new VoteCommentConfig(id2, "", null, null, 12, null);
        }
        return VoteCommentDetailListFragment.Companion.newInstance(voteCommentConfig);
    }
}
