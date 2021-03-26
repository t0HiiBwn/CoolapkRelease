package com.coolapk.market.view.user;

import android.os.Bundle;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/user/UserFeedListActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Lcom/coolapk/market/view/user/UserFeedListFragment;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserFeedListActivity.kt */
public final class UserFeedListActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_UID = "uid";

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public UserFeedListFragment onCreateFragment() {
        setToolbarTitle("我的动态");
        String stringExtra = getIntent().getStringExtra("uid");
        Intrinsics.checkNotNull(stringExtra);
        Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EXTRA_UID)!!");
        return UserFeedListFragment.Companion.newInstance(stringExtra, 0);
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getBinding().mainContent.addOnInsetChangeListener(new UserFeedListActivity$onCreate$1(this));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/user/UserFeedListActivity$Companion;", "", "()V", "EXTRA_UID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserFeedListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
