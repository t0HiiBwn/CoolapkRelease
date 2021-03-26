package com.coolapk.market.view.live;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.coolapk.market.view.base.TabActivity;
import com.coolapk.market.view.live.BannedUserListFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0013\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013H\u0014¢\u0006\u0002\u0010\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/live/BannedUserTabActivity;", "Lcom/coolapk/market/view/base/TabActivity;", "()V", "liveId", "", "getLiveId", "()Ljava/lang/String;", "liveId$delegate", "Lkotlin/Lazy;", "getFragmentItem", "Landroidx/fragment/app/Fragment;", "position", "", "getTabStyle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateTabs", "", "()[Ljava/lang/String;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: BannedUserTabActivity.kt */
public final class BannedUserTabActivity extends TabActivity {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LIVE_ID = "LIVE_ID";
    private final Lazy liveId$delegate = LazyKt.lazy(new BannedUserTabActivity$liveId$2(this));

    private final String getLiveId() {
        return (String) this.liveId$delegate.getValue();
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected int getTabStyle() {
        return 1;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/live/BannedUserTabActivity$Companion;", "", "()V", "KEY_LIVE_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: BannedUserTabActivity.kt */
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
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected String[] onCreateTabs() {
        return new String[]{"禁言用户", "禁止发图用户"};
    }

    @Override // com.coolapk.market.view.base.TabActivity
    protected Fragment getFragmentItem(int i) {
        if (i == 0) {
            BannedUserListFragment.Companion companion = BannedUserListFragment.Companion;
            String liveId = getLiveId();
            Intrinsics.checkNotNullExpressionValue(liveId, "liveId");
            return companion.newInstance(liveId, 1);
        } else if (i != 1) {
            return null;
        } else {
            BannedUserListFragment.Companion companion2 = BannedUserListFragment.Companion;
            String liveId2 = getLiveId();
            Intrinsics.checkNotNullExpressionValue(liveId2, "liveId");
            return companion2.newInstance(liveId2, 2);
        }
    }
}
