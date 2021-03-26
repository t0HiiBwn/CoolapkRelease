package com.coolapk.market.view.feed.vote;

import android.os.Bundle;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.view.main.DataListFragment;
import com.coolapk.market.widget.decoration.TopItemDecoration;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoteCommentDetailListFragment.kt */
public final class VoteCommentDataListFragment extends DataListFragment {
    public static final Companion Companion = new Companion(null);

    public static final VoteCommentDataListFragment newInstance(String str, String str2, String str3) {
        return Companion.newInstance(str, str2, str3);
    }

    /* compiled from: VoteCommentDetailListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VoteCommentDataListFragment newInstance$default(Companion companion, String str, String str2, String str3, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return companion.newInstance(str, str2, str3);
        }

        public final VoteCommentDataListFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "action");
            VoteCommentDataListFragment voteCommentDataListFragment = new VoteCommentDataListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("URL", str);
            bundle.putString("TITLE", str2);
            bundle.putString("SUBTITLE", str3);
            Unit unit = Unit.INSTANCE;
            voteCommentDataListFragment.setArguments(bundle);
            return voteCommentDataListFragment;
        }
    }

    @Override // com.coolapk.market.view.main.DataListFragment, com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().addItemDecoration(new TopItemDecoration(NumberExtendsKt.getDp((Number) 8), 0, 2, null));
    }
}
