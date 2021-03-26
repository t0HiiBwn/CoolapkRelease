package com.coolapk.market.view.live;

import android.animation.ArgbEvaluator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentTransaction;
import com.blankj.utilcode.util.ScreenUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.LiveReplyListBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Live;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.BaseActivity;
import com.coolapk.market.view.live.RelativeMessageListFragment;
import com.coolapk.market.widget.view.SlideUpView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/live/LiveReplyListActivity;", "Lcom/coolapk/market/view/base/BaseActivity;", "Lcom/coolapk/market/view/live/LiveReplyContext;", "()V", "binding", "Lcom/coolapk/market/databinding/LiveReplyListBinding;", "evaluator", "Landroid/animation/ArgbEvaluator;", "live", "Lcom/coolapk/market/model/Live;", "getLive", "()Lcom/coolapk/market/model/Live;", "live$delegate", "Lkotlin/Lazy;", "unreadNum", "", "getUnreadNum", "()I", "unreadNum$delegate", "finish", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onLiveMessageClick", "liveMessage", "Lcom/coolapk/market/model/LiveMessage;", "onLiveMessageLongClick", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LiveReplyListActivity.kt */
public final class LiveReplyListActivity extends BaseActivity implements LiveReplyContext {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_LIVE = "LIVE";
    public static final String KEY_UNREAD_NUM = "UNREAD_NUM";
    private LiveReplyListBinding binding;
    private final ArgbEvaluator evaluator = new ArgbEvaluator();
    private final Lazy live$delegate = LazyKt.lazy(new LiveReplyListActivity$live$2(this));
    private final Lazy unreadNum$delegate = LazyKt.lazy(new LiveReplyListActivity$unreadNum$2(this));

    private final Live getLive() {
        return (Live) this.live$delegate.getValue();
    }

    private final int getUnreadNum() {
        return ((Number) this.unreadNum$delegate.getValue()).intValue();
    }

    @Override // com.coolapk.market.view.live.LiveReplyContext
    public void onLiveMessageLongClick(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
    }

    public static final /* synthetic */ LiveReplyListBinding access$getBinding$p(LiveReplyListActivity liveReplyListActivity) {
        LiveReplyListBinding liveReplyListBinding = liveReplyListActivity.binding;
        if (liveReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return liveReplyListBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/live/LiveReplyListActivity$Companion;", "", "()V", "KEY_LIVE", "", "KEY_UNREAD_NUM", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LiveReplyListActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559012);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…R.layout.live_reply_list)");
        LiveReplyListBinding liveReplyListBinding = (LiveReplyListBinding) contentView;
        this.binding = liveReplyListBinding;
        if (liveReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        setSupportActionBar(liveReplyListBinding.toolbar);
        String str = "与我相关";
        if (getUnreadNum() > 0) {
            str = str + (char) 65288 + getUnreadNum() + (char) 65289;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(str);
        }
        Drawable drawable = ResourceUtils.getDrawable(this, 2131231200);
        drawable.setTint(AppHolder.getAppTheme().getTextColorPrimary());
        LiveReplyListBinding liveReplyListBinding2 = this.binding;
        if (liveReplyListBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Toolbar toolbar = liveReplyListBinding2.toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "binding.toolbar");
        toolbar.setNavigationIcon(drawable);
        float screenHeight = ((float) ScreenUtils.getScreenHeight()) * 0.4f;
        LiveReplyListBinding liveReplyListBinding3 = this.binding;
        if (liveReplyListBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        SlideUpView slideUpView = liveReplyListBinding3.slideUpView;
        Intrinsics.checkNotNullExpressionValue(slideUpView, "binding.slideUpView");
        slideUpView.setClickable(true);
        LiveReplyListBinding liveReplyListBinding4 = this.binding;
        if (liveReplyListBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveReplyListBinding4.slideUpView.setInitTranslationY(screenHeight);
        LiveReplyListBinding liveReplyListBinding5 = this.binding;
        if (liveReplyListBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveReplyListBinding5.slideUpView.setCallback(new LiveReplyListActivity$onCreate$1(this));
        LiveReplyListBinding liveReplyListBinding6 = this.binding;
        if (liveReplyListBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveReplyListBinding6.mainContent.setOnClickListener(new LiveReplyListActivity$onCreate$2(this));
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            RelativeMessageListFragment.Companion companion = RelativeMessageListFragment.Companion;
            Live live = getLive();
            Intrinsics.checkNotNullExpressionValue(live, "live");
            beginTransaction.add(2131362307, companion.newInstance(live)).commit();
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        LiveReplyListBinding liveReplyListBinding = this.binding;
        if (liveReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveReplyListBinding.slideUpView.dismissView();
        return true;
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        LiveReplyListBinding liveReplyListBinding = this.binding;
        if (liveReplyListBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        liveReplyListBinding.slideUpView.dismissView();
    }

    @Override // com.coolapk.market.view.live.LiveReplyContext
    public void onLiveMessageClick(LiveMessage liveMessage) {
        Intrinsics.checkNotNullParameter(liveMessage, "liveMessage");
        Live live = getLive();
        Intrinsics.checkNotNullExpressionValue(live, "live");
        String id = live.getId();
        LiveUtils liveUtils = LiveUtils.INSTANCE;
        Live live2 = getLive();
        Intrinsics.checkNotNullExpressionValue(live2, "live");
        ActionManager.startLivePostMessageActivity(getActivity(), "live_discuss", id, liveMessage, liveUtils.currentUserIsPresenter(live2));
    }
}
