package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.UserToolbarBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.UserAction;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeExtends;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0014J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\nH\u0014J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedToolbarViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/UserToolbarBinding;", "Lcom/coolapk/market/model/Feed;", "presenter", "Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "(Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/feed/reply/FeedDetailPresenter;", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "setFollowState", "isFollowing", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedToolbarViewPart.kt */
public final class FeedToolbarViewPart extends BindingViewPart<UserToolbarBinding, Feed> {
    private final FeedDetailPresenter presenter;

    public FeedToolbarViewPart(FeedDetailPresenter feedDetailPresenter) {
        Intrinsics.checkNotNullParameter(feedDetailPresenter, "presenter");
        this.presenter = feedDetailPresenter;
    }

    public final FeedDetailPresenter getPresenter() {
        return this.presenter;
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public UserToolbarBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559286, viewGroup, false, new ContextBindingComponent(layoutInflater.getContext()));
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…ponent(inflater.context))");
        return (UserToolbarBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        int tabIndicatorColor = AppHolder.getAppTheme().getTabIndicatorColor(getContext());
        TextView textView = ((UserToolbarBinding) getBinding()).toolbarActionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.toolbarActionView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 1), tabIndicatorColor);
        gradientDrawable.setColor(ColorStateList.valueOf(0));
        gradientDrawable.setCornerRadius(NumberExtendsKt.getDpf((Number) 14));
        Unit unit = Unit.INSTANCE;
        textView.setBackground(gradientDrawable);
        ((UserToolbarBinding) getBinding()).toolbarActionView.setTextColor(tabIndicatorColor);
        ((UserToolbarBinding) getBinding()).toolbarUserAvatarView.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        super.onBindToContent((FeedToolbarViewPart) feed);
        ((UserToolbarBinding) getBinding()).setClick(this);
        ((UserToolbarBinding) getBinding()).setUserAvatar(feed.getUserAvatar());
        ((UserToolbarBinding) getBinding()).setUserName(feed.getUserName());
        UserToolbarBinding userToolbarBinding = (UserToolbarBinding) getBinding();
        UserInfo userInfo = feed.getUserInfo();
        userToolbarBinding.setUserVerifyStatusIcon(userInfo != null ? userInfo.getVerifyStatusIcon() : null);
        ((UserToolbarBinding) getBinding()).toolbarNameView.setTextColor(AppHolder.getAppTheme().getMainTextColor());
        UserAction userAction = this.presenter.getFeed().getUserAction();
        boolean z = true;
        if (userAction == null || userAction.getFollowAuthor() != 1) {
            z = false;
        }
        setFollowState(z);
        ((UserToolbarBinding) getBinding()).executePendingBindings();
    }

    private final void setFollowState(boolean z) {
        TextView textView = ((UserToolbarBinding) getBinding()).toolbarActionView;
        textView.setText(textView.getContext().getString(z ? 2131886114 : 2131886133));
        if (!AppHolder.getAppTheme().isLightColorTheme()) {
            ShapeExtends shapeExtends = ShapeExtends.INSTANCE;
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            textView.setBackground(shapeExtends.createNodeCapsuleActionBackground(context, (float) NumberExtendsKt.getDp((Number) 14)));
            ShapeExtends shapeExtends2 = ShapeExtends.INSTANCE;
            Context context2 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            textView.setTextColor(shapeExtends2.createNodeActionTextColors(context2));
            textView.setSelected(z);
        } else if (z) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ColorStateList.valueOf(ResourceUtils.getColorInt(textView.getContext(), 2131099911)));
            gradientDrawable.setCornerRadius(NumberExtendsKt.getDpf((Number) 14));
            Unit unit = Unit.INSTANCE;
            textView.setBackground(gradientDrawable);
            textView.setTextColor(ResourceUtils.getColorInt(textView.getContext(), 2131099891));
        } else {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setColor(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
            gradientDrawable2.setCornerRadius(NumberExtendsKt.getDpf((Number) 14));
            Unit unit2 = Unit.INSTANCE;
            textView.setBackground(gradientDrawable2);
            textView.setTextColor(ResourceUtils.getColorInt(textView.getContext(), 2131099912));
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        int id = view.getId();
        if (id == 2131363590) {
            Activity currentActivity = AppHolder.getCurrentActivity();
            if (currentActivity != null) {
                Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                if (checkLogin.booleanValue()) {
                    UserAction userAction = this.presenter.getFeed().getUserAction();
                    boolean z = userAction != null && userAction.getFollowAuthor() == 1;
                    this.presenter.followAuthor(z);
                    setFollowState(!z);
                }
            }
        } else if (id == 2131363599) {
            ActionManager.startUserSpaceActivity(getContext(), this.presenter.getFeed().getUid());
        }
    }
}
