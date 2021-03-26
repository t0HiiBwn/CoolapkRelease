package com.coolapk.market.view.feed;

import android.os.Bundle;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.network.Result;
import com.coolapk.market.view.cardlist.CompatFeedListFragment;
import com.coolapk.market.view.feed.FeedContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/feed/AdminFeedFragment;", "Lcom/coolapk/market/view/cardlist/CompatFeedListFragment;", "()V", "isFolded", "", "type", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "AdminFeedContract", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AdminFeedFragment.kt */
public final class AdminFeedFragment extends CompatFeedListFragment {
    public static final Companion Companion = new Companion(null);
    private boolean isFolded;
    private String type;

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.type = requireArguments().getString("type");
        boolean z = requireArguments().getBoolean("isFolded");
        this.isFolded = z;
        setPresenter(new AdminFeedContract(this, this.type, z));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/AdminFeedFragment$AdminFeedContract;", "Lcom/coolapk/market/view/feed/FeedContract$Presenter;", "view", "Lcom/coolapk/market/view/feed/FeedContract$View;", "type", "", "isFolded", "", "(Lcom/coolapk/market/view/feed/FeedContract$View;Ljava/lang/String;Z)V", "onCreateRequest", "Lrx/Observable;", "Lcom/coolapk/market/network/Result;", "", "Lcom/coolapk/market/model/Entity;", "isRefresh", "page", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AdminFeedFragment.kt */
    public static final class AdminFeedContract extends FeedContract.Presenter {
        private final boolean isFolded;
        private final String type;
        private final FeedContract.View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdminFeedContract(FeedContract.View view2, String str, boolean z) {
            super(view2);
            Intrinsics.checkNotNullParameter(view2, "view");
            this.view = view2;
            this.type = str;
            this.isFolded = z;
        }

        @Override // com.coolapk.market.view.feed.FeedContract.Presenter
        public Observable<Result<List<Entity>>> onCreateRequest(boolean z, int i) {
            if (this.isFolded) {
                Observable<Result<List<Entity>>> adminNewestList = DataManager.getInstance().getAdminNewestList(this.type, i, this.view.findFirstItem(), this.view.findLastItem(), 1);
                Intrinsics.checkNotNullExpressionValue(adminNewestList, "DataManager.getInstance(…, view.findLastItem(), 1)");
                return adminNewestList;
            }
            Observable<Result<List<Entity>>> adminNewestList2 = DataManager.getInstance().getAdminNewestList(this.type, i, this.view.findFirstItem(), this.view.findLastItem());
            Intrinsics.checkNotNullExpressionValue(adminNewestList2, "DataManager.getInstance(…m(), view.findLastItem())");
            return adminNewestList2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/feed/AdminFeedFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/feed/AdminFeedFragment;", "type", "", "isFolded", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AdminFeedFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AdminFeedFragment newInstance(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "type");
            Bundle bundle = new Bundle();
            bundle.putString("type", str);
            bundle.putBoolean("isFolded", z);
            AdminFeedFragment adminFeedFragment = new AdminFeedFragment();
            adminFeedFragment.setArguments(bundle);
            return adminFeedFragment;
        }
    }
}
