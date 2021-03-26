package com.coolapk.market.view.feed;

import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.app.TranslucentActivity;
import com.coolapk.market.databinding.FeedReplyDetailBinding;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.ThemeUtils;
import com.coolapk.market.view.feed.FeedReplyDetailHeaderFragment;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.view.SlideUpView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0014J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u0007H\u0014J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Lcom/coolapk/market/app/TranslucentActivity;", "()V", "binding", "Lcom/coolapk/market/databinding/FeedReplyDetailBinding;", "initSearchMenu", "", "isNavigationBarTranslucent", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSetStatusBarColor", "setupFragment", "setupSlideView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyDetailActivity.kt */
public final class FeedReplyDetailActivity extends FakeStatusBarActivity implements TranslucentActivity {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_FEED_REPLY = "extra_feed_reply";
    public static final String EXTRA_FEED_REPLY_ID = "extra_feed_reply";
    private FeedReplyDetailBinding binding;

    @Override // com.coolapk.market.view.base.BaseActivity
    protected void initSearchMenu() {
    }

    @Override // com.coolapk.market.app.TranslucentActivity
    public boolean isNavigationBarTranslucent() {
        return true;
    }

    public static final /* synthetic */ FeedReplyDetailBinding access$getBinding$p(FeedReplyDetailActivity feedReplyDetailActivity) {
        FeedReplyDetailBinding feedReplyDetailBinding = feedReplyDetailActivity.binding;
        if (feedReplyDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return feedReplyDetailBinding;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(getActivity(), 2131558563);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…layout.feed_reply_detail)");
        this.binding = (FeedReplyDetailBinding) contentView;
        setupSlideView();
        setupFragment();
    }

    private final void setupSlideView() {
        FeedReplyDetailBinding feedReplyDetailBinding = this.binding;
        if (feedReplyDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailBinding.mainContent.setOnClickListener(new FeedReplyDetailActivity$setupSlideView$1(this));
        FeedReplyDetailBinding feedReplyDetailBinding2 = this.binding;
        if (feedReplyDetailBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = feedReplyDetailBinding2.slideUpView;
        Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.slideUpView");
        slideUpView.setClickable(true);
        FeedReplyDetailBinding feedReplyDetailBinding3 = this.binding;
        if (feedReplyDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailBinding3.slideUpView.setInitTranslationY((float) DisplayUtils.dp2px(getActivity(), 240.0f));
        FeedReplyDetailBinding feedReplyDetailBinding4 = this.binding;
        if (feedReplyDetailBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailBinding4.slideUpView.setCallback(new FeedReplyDetailActivity$setupSlideView$2(this));
    }

    private final void setupFragment() {
        FeedReplyDetailFragment feedReplyDetailFragment;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        Fragment findFragmentById = supportFragmentManager.findFragmentById(2131363614);
        if (!(findFragmentById instanceof FeedReplyDetailFragment)) {
            findFragmentById = null;
        }
        if (((FeedReplyDetailFragment) findFragmentById) == null) {
            FeedReply feedReply = (FeedReply) getIntent().getParcelableExtra("extra_feed_reply");
            if (feedReply != null) {
                feedReplyDetailFragment = FeedReplyDetailHeaderFragment.Companion.newInstance(feedReply);
            } else {
                FeedReplyDetailHeaderFragment.Companion companion = FeedReplyDetailHeaderFragment.Companion;
                String stringExtra = getIntent().getStringExtra("extra_feed_reply");
                Intrinsics.checkNotNull(stringExtra);
                Intrinsics.checkNotNullExpressionValue(stringExtra, "intent.getStringExtra(EXTRA_FEED_REPLY_ID)!!");
                feedReplyDetailFragment = companion.newInstance(stringExtra);
            }
            supportFragmentManager.beginTransaction().add(2131363614, feedReplyDetailFragment).commit();
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity
    protected void onSetStatusBarColor() {
        super.onSetStatusBarColor();
        ThemeUtils.setTranslucentStatusBar(getActivity());
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        FeedReplyDetailBinding feedReplyDetailBinding = this.binding;
        if (feedReplyDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        feedReplyDetailBinding.slideUpView.dismissView();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/feed/FeedReplyDetailActivity$Companion;", "", "()V", "EXTRA_FEED_REPLY", "", "EXTRA_FEED_REPLY_ID", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedReplyDetailActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
