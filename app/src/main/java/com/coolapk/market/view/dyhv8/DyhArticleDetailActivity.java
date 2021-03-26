package com.coolapk.market.view.dyhv8;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.AlphaToolbarActivity;
import com.coolapk.market.view.dyhv8.DyhArticleDetailFragment;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.FastReturnView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0014J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000eH\u0014J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0010H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleDetailActivity;", "Lcom/coolapk/market/view/base/AlphaToolbarActivity;", "()V", "dyhArticle", "Lcom/coolapk/market/model/DyhArticle;", "feedId", "", "rid", "subscription", "Lrx/Subscription;", "loadDyhArticleInfo", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateFragment", "Landroidx/fragment/app/Fragment;", "onDestroy", "onEmptyViewClick", "onSaveInstanceState", "outState", "setupFastReturnView", "fragment", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhArticleDetailActivity.kt */
public final class DyhArticleDetailActivity extends AlphaToolbarActivity {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_ARTICLE = "extra_article";
    private static final String EXTRA_FEED_ID = "extra_feed_id";
    private static final String EXTRA_REPLY_ID = "extra_reply_id";
    private DyhArticle dyhArticle;
    private String feedId;
    private String rid;
    private Subscription subscription;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/view/dyhv8/DyhArticleDetailActivity$Companion;", "", "()V", "EXTRA_ARTICLE", "", "getEXTRA_ARTICLE", "()Ljava/lang/String;", "EXTRA_FEED_ID", "getEXTRA_FEED_ID", "EXTRA_REPLY_ID", "getEXTRA_REPLY_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhArticleDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getEXTRA_ARTICLE() {
            return DyhArticleDetailActivity.EXTRA_ARTICLE;
        }

        public final String getEXTRA_REPLY_ID() {
            return DyhArticleDetailActivity.EXTRA_REPLY_ID;
        }

        public final String getEXTRA_FEED_ID() {
            return DyhArticleDetailActivity.EXTRA_FEED_ID;
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra(EXTRA_FEED_ID);
        if (stringExtra == null) {
            Feed feed = (Feed) getIntent().getParcelableExtra(EXTRA_ARTICLE);
            stringExtra = feed != null ? feed.getId() : null;
        }
        if (stringExtra != null) {
            this.feedId = stringExtra;
            this.rid = getIntent().getStringExtra(EXTRA_REPLY_ID);
            if (bundle != null) {
                this.dyhArticle = (DyhArticle) bundle.getParcelable(EXTRA_ARTICLE);
            }
            super.onCreate(bundle);
            if (this.dyhArticle == null) {
                loadDyhArticleInfo();
                return;
            }
            return;
        }
        throw new RuntimeException("please provide feed or feed id");
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        DyhArticle dyhArticle2 = this.dyhArticle;
        if (dyhArticle2 != null) {
            bundle.putParcelable(EXTRA_ARTICLE, dyhArticle2);
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    protected void setupFastReturnView(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FastReturnView fastReturnView = new FastReturnView(this);
        fastReturnView.setOffset(ConvertUtils.dp2px(40.0f));
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = getBinding().mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        fastReturnView.addTo(drawSystemBarFrameLayout);
        fastReturnView.bindFragment(fragment);
    }

    private final void loadDyhArticleInfo() {
        if (!isLoading()) {
            DataManager instance = DataManager.getInstance();
            String str = this.feedId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedId");
            }
            this.subscription = instance.getDyhArticleDetail(str, this.rid).compose(RxUtils.apiCommonToData()).compose(RxUtils.retryWhenEmitNull()).doOnSubscribe(new DyhArticleDetailActivity$loadDyhArticleInfo$1(this)).subscribe((Subscriber<? super R>) new DyhArticleDetailActivity$loadDyhArticleInfo$2(this));
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public void onEmptyViewClick() {
        loadDyhArticleInfo();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    @Override // com.coolapk.market.view.base.AlphaToolbarActivity
    public Fragment onCreateFragment() {
        if (this.dyhArticle == null) {
            return null;
        }
        DyhArticleDetailFragment.Companion companion = DyhArticleDetailFragment.Companion;
        DyhArticle dyhArticle2 = this.dyhArticle;
        Intrinsics.checkNotNull(dyhArticle2);
        return companion.newInstance(dyhArticle2);
    }
}
