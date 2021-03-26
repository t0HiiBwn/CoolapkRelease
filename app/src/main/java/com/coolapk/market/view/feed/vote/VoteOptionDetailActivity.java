package com.coolapk.market.view.feed.vote;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.coolapk.market.view.base.TabActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0014¢\u0006\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteOptionDetailActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getFragmentItemTag", "", "getTabStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "", "()[Ljava/lang/String;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: VoteOptionDetailActivity.kt */
public final class VoteOptionDetailActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_VOTE_COMMENT_CONFIG = "vote_comment_config";
    private static final int PAGE_VOTER = 0;
    private static final int PAGE_VOTE_COMMENT = 1;

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/feed/vote/VoteOptionDetailActivity$Companion;", "", "()V", "EXTRA_VOTE_COMMENT_CONFIG", "", "PAGE_VOTER", "", "PAGE_VOTE_COMMENT", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: VoteOptionDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.TabActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar = getToolbar();
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        toolbar.setTitle("该选项投票统计");
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"投票者", "观点"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        Parcelable parcelableExtra = getIntent().getParcelableExtra("vote_comment_config");
        Intrinsics.checkNotNull(parcelableExtra);
        Intrinsics.checkNotNullExpressionValue(parcelableExtra, "intent.getParcelableExtr…RA_VOTE_COMMENT_CONFIG)!!");
        VoteCommentConfig voteCommentConfig = (VoteCommentConfig) parcelableExtra;
        if (i == 0) {
            return VoteUserListFragment.Companion.newInstance(voteCommentConfig.getFid(), voteCommentConfig.getOptionId());
        }
        if (i != 1) {
            return null;
        }
        return VoteCommentListFragment.Companion.newInstance(voteCommentConfig);
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        return getTabTitles()[i];
    }
}
