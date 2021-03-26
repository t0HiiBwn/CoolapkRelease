package com.coolapk.market.view.user;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.view.base.TabActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/user/UserFollowAppActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getFragmentItemTag", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "", "()[Ljava/lang/String;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFollowAppActivity.kt */
public final class UserFollowAppActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_UID = "uid";
    private static final int PAGE_APPS = 0;
    private static final int PAGE_APP_FORUMS = 1;
    private static final int PAGE_COLLECTION = 4;
    private static final int PAGE_MOBILE_BA = 5;
    private static final int PAGE_QUESTION = 3;
    private static final int PAGE_TOPIC = 2;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/user/UserFollowAppActivity$Companion;", "", "()V", "EXTRA_UID", "", "PAGE_APPS", "", "PAGE_APP_FORUMS", "PAGE_COLLECTION", "PAGE_MOBILE_BA", "PAGE_QUESTION", "PAGE_TOPIC", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserFollowAppActivity.kt */
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
        getToolbar().setTitle(2131887164);
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        String string = getString(2131887285);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.title_app)");
        String string2 = getString(2131886799);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_discovery_app_forum)");
        String string3 = getString(2131887332);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.title_group_topic)");
        String string4 = getString(2131887088);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.str_title_question)");
        String string5 = getString(2131887079);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(R.string.str_title_collection)");
        String string6 = getString(2131887087);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(R.string.str_title_mobile_bar)");
        return new String[]{string, string2, string3, string4, string5, string6};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        UserFollowAppFragment userFollowAppFragment = null;
        if (i == 0) {
            userFollowAppFragment = UserFollowAppFragment.Companion.newInstance();
        } else if (i == 1) {
            userFollowAppFragment = UserFollowAppForumFragment.Companion.newInstance();
        } else if (i == 2) {
            userFollowAppFragment = UserDataListFragment.Companion.newInstance("#/topic/userFollowTagList?&title=我关注的话题", null, null);
        } else if (i == 3) {
            userFollowAppFragment = UserDataListFragment.Companion.newInstance("#/feed/questionFollowList?&title=我关注的问题", null, null);
        } else if (i == 4) {
            userFollowAppFragment = UserDataListFragment.Companion.newInstance("#/collection/followList?&title=我关注的收藏单", null, null);
        } else if (i == 5) {
            userFollowAppFragment = UserDataListFragment.Companion.newInstance("#/product/followProductList?&title=我关注的数码吧", null, null);
        }
        Intrinsics.checkNotNull(userFollowAppFragment);
        return userFollowAppFragment;
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String getFragmentItemTag(int i) {
        String str = getTabTitles()[i];
        Intrinsics.checkNotNullExpressionValue(str, "tabTitles[position]");
        return str;
    }
}
