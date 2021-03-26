package com.coolapk.market.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemUserBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.User;
import com.coolapk.market.util.DateUtils;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.widget.ActionButtonFrameLayout;
import com.coolapk.market.widget.UserAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/viewholder/SearchUserViewHolder;", "Lcom/coolapk/market/viewholder/UserViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "user", "Lcom/coolapk/market/model/User;", "bindToContent", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchUserViewHolder.kt */
public final class SearchUserViewHolder extends UserViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558967;
    private final EntityListPresenter presenter;
    private User user;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchUserViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
    }

    public final EntityListPresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchUserViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchUserViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.UserViewHolder
    public void bindToContent(User user2) {
        Intrinsics.checkNotNullParameter(user2, "user");
        this.user = user2;
        super.bindToContent(user2);
        ActionButtonFrameLayout actionButtonFrameLayout = ((ItemUserBinding) getBinding()).actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButtonFrameLayout, "binding.actionContainer");
        actionButtonFrameLayout.setStateListAnimator(null);
        ((ItemUserBinding) getBinding()).actionContainer.setOnClickListener(this);
        ActionButtonFrameLayout actionButtonFrameLayout2 = ((ItemUserBinding) getBinding()).actionContainer;
        Intrinsics.checkNotNullExpressionValue(actionButtonFrameLayout2, "binding.actionContainer");
        int i = 8;
        actionButtonFrameLayout2.setVisibility(user2.getIsFollow() != -1 ? 0 : 8);
        ((ItemUserBinding) getBinding()).actionButton.setTextColor(AppHolder.getAppTheme().getColorAccent());
        if (DateUtils.getSomeDateTime() < user2.getLoginTime()) {
            TextView textView = ((ItemUserBinding) getBinding()).loginTimeView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.loginTimeView");
            textView.setText(DateUtils.getTimeDescription(getContext(), Long.valueOf(user2.getLoginTime())) + "活跃");
            TextView textView2 = ((ItemUserBinding) getBinding()).loginTimeView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.loginTimeView");
            textView2.setVisibility(0);
        } else {
            TextView textView3 = ((ItemUserBinding) getBinding()).loginTimeView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.loginTimeView");
            textView3.setVisibility(8);
        }
        LinearLayout linearLayout = ((ItemUserBinding) getBinding()).detailContainerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.detailContainerView");
        String subTitle = user2.getSubTitle();
        boolean z = true;
        linearLayout.setVisibility(subTitle == null || subTitle.length() == 0 ? 0 : 8);
        TextView textView4 = ((ItemUserBinding) getBinding()).subtitleView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.subtitleView");
        String subTitle2 = user2.getSubTitle();
        if (!(subTitle2 == null || subTitle2.length() == 0)) {
            z = false;
        }
        textView4.setVisibility(z ? 8 : 0);
        TextView textView5 = ((ItemUserBinding) getBinding()).introduceView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.introduceView");
        if (!TextUtils.isEmpty(user2.getBio())) {
            i = 0;
        }
        textView5.setVisibility(i);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        int id = view.getId();
        if (id == 2131361886) {
            User user2 = this.user;
            if (user2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            if (user2.getIsFollow() == 0) {
                EntityListPresenter entityListPresenter = this.presenter;
                User user3 = this.user;
                if (user3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                }
                String uid = user3.getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "user.uid");
                entityListPresenter.followUser(uid);
                return;
            }
            EntityListPresenter entityListPresenter2 = this.presenter;
            User user4 = this.user;
            if (user4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            String uid2 = user4.getUid();
            Intrinsics.checkNotNullExpressionValue(uid2, "user.uid");
            entityListPresenter2.unfollowUser(uid2);
        } else if (id == 2131362200) {
            UserAvatarView userAvatarView = ((ItemUserBinding) getBinding()).iconView;
            User user5 = this.user;
            if (user5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            String uid3 = user5.getUid();
            User user6 = this.user;
            if (user6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            ActionManager.startUserSpaceActivity(userAvatarView, uid3, user6.getUserAvatar());
        }
    }
}
