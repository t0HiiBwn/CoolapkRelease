package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.FeedWarningBinding;
import com.coolapk.market.databinding.ItemFeedFollowableHeaderViewBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.binding.BindingExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0014J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u000fH\u0014J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemFeedFollowableHeaderViewBinding;", "Lcom/coolapk/market/model/Feed;", "dataBindingComponent", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "getDataBindingComponent", "()Landroidx/databinding/DataBindingComponent;", "feed", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "setFollowState", "follow", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedFollowableHeaderViewPart.kt */
public final class FeedFollowableHeaderViewPart extends BindingViewPart<ItemFeedFollowableHeaderViewBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558707;
    private final DataBindingComponent dataBindingComponent;
    private Feed feed;
    private final FeedDetailPresenter presenter;

    public final DataBindingComponent getDataBindingComponent() {
        return this.dataBindingComponent;
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    public FeedFollowableHeaderViewPart(DataBindingComponent dataBindingComponent2, FeedDetailPresenter feedDetailPresenter) {
        Intrinsics.checkNotNullParameter(dataBindingComponent2, "dataBindingComponent");
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.dataBindingComponent = dataBindingComponent2;
        this.presenter = feedDetailPresenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedFollowableHeaderViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedFollowableHeaderViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemFeedFollowableHeaderViewBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558707, viewGroup, false, this.dataBindingComponent);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…se, dataBindingComponent)");
        return (ItemFeedFollowableHeaderViewBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        ((ItemFeedFollowableHeaderViewBinding) getBinding()).setClick(this);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "data");
        super.onBindToContent((FeedFollowableHeaderViewPart) feed2);
        this.feed = feed2;
        String uid = feed2.getUid();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        boolean areEqual = Intrinsics.areEqual(uid, loginSession.getUid());
        boolean z = false;
        boolean z2 = areEqual || feed2.getIsAnonymous() == 1;
        TextView textView = ((ItemFeedFollowableHeaderViewBinding) getBinding()).followView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.followView");
        textView.setVisibility(z2 ? 8 : 0);
        UserAction userAction = feed2.getUserAction();
        if (userAction != null && userAction.getFollowAuthor() == 1) {
            z = true;
        }
        setFollowState(z);
        ((ItemFeedFollowableHeaderViewBinding) getBinding()).setModel(feed2);
        ((ItemFeedFollowableHeaderViewBinding) getBinding()).executePendingBindings();
        FeedWarningBinding feedWarningBinding = ((ItemFeedFollowableHeaderViewBinding) getBinding()).alertView;
        Intrinsics.checkNotNullExpressionValue(feedWarningBinding, "binding.alertView");
        Feed feed3 = this.feed;
        BindingExtensionKt.updateInfo(feedWarningBinding, feed3 != null ? feed3.getInnerInfo() : null);
        if (this.presenter.getPreviewMode() || EntityExtendsKt.isLoadFromHistoryApi(feed2)) {
            TextView textView2 = ((ItemFeedFollowableHeaderViewBinding) getBinding()).modifyView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.modifyView");
            textView2.setVisibility(8);
        }
    }

    private final void setFollowState(boolean z) {
        if (z) {
            TextView textView = ((ItemFeedFollowableHeaderViewBinding) getBinding()).followView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.followView");
            textView.setText(getContext().getString(2131886114));
            TextView textView2 = ((ItemFeedFollowableHeaderViewBinding) getBinding()).followView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.followView");
            textView2.setBackgroundTintList(ColorStateList.valueOf(ResourceUtils.getColorInt(getContext(), 2131099916)));
            ((ItemFeedFollowableHeaderViewBinding) getBinding()).followView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099896));
            return;
        }
        TextView textView3 = ((ItemFeedFollowableHeaderViewBinding) getBinding()).followView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.followView");
        textView3.setText(getContext().getString(2131886133));
        TextView textView4 = ((ItemFeedFollowableHeaderViewBinding) getBinding()).followView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.followView");
        textView4.setBackgroundTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        ((ItemFeedFollowableHeaderViewBinding) getBinding()).followView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131099917));
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        Feed feed2 = this.feed;
        if (feed2 != null) {
            int id = view.getId();
            if (id == 2131362590) {
                Activity currentActivity = AppHolder.getCurrentActivity();
                if (currentActivity != null) {
                    Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                    Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                    if (checkLogin.booleanValue()) {
                        UserAction userAction = feed2.getUserAction();
                        boolean z = userAction != null && userAction.getFollowAuthor() == 1;
                        this.presenter.followAuthor(z);
                        setFollowState(!z);
                    }
                }
            } else if (id != 2131362954) {
                if (id != 2131363900) {
                    super.onClick(view);
                } else {
                    ActionManager.startUserSpaceActivity(view, feed2.getUid(), feed2.getUserAvatar());
                }
            } else if (feed2.getIsModified() == 1) {
                ActionManagerCompat actionManagerCompat = ActionManagerCompat.INSTANCE;
                Context context = getContext();
                String id2 = feed2.getId();
                if (id2 == null) {
                    id2 = "";
                }
                actionManagerCompat.startFeedHistoryListActivity(context, id2);
            }
        }
    }
}
