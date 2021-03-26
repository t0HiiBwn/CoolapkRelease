package com.coolapk.market.viewholder;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemUserHistoryBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.MultiItemDialogFragment;
import com.coolapk.market.view.center.HistoryTimeV9Fragment;
import com.coolapk.market.widget.view.CoolEllipsizeTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u000b\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/coolapk/market/viewholder/UserHistoryViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserHistoryBinding;", "Lcom/coolapk/market/model/UserHistory;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "userHistory", "bindToContent", "", "onClick", "view", "showViewHistoryDialog", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserHistoryViewHolder.kt */
public final class UserHistoryViewHolder extends GenericBindHolder<ItemUserHistoryBinding, UserHistory> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558980;
    private UserHistory userHistory;

    public static final /* synthetic */ UserHistory access$getUserHistory$p(UserHistoryViewHolder userHistoryViewHolder) {
        UserHistory userHistory2 = userHistoryViewHolder.userHistory;
        if (userHistory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userHistory");
        }
        return userHistory2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserHistoryViewHolder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        DataBindingComponent component = getComponent();
        LifecycleOwner lifecycleOwner = null;
        FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) (!(component instanceof FragmentBindingComponent) ? null : component);
        LifecycleOwner lifecycleOwner2 = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
        if (((HistoryTimeV9Fragment) (lifecycleOwner2 instanceof HistoryTimeV9Fragment ? lifecycleOwner2 : lifecycleOwner)) != null) {
            ((ItemUserHistoryBinding) getBinding()).itemView.setOnLongClickListener(new View.OnLongClickListener(this) {
                /* class com.coolapk.market.viewholder.UserHistoryViewHolder.AnonymousClass1 */
                final /* synthetic */ UserHistoryViewHolder this$0;

                {
                    this.this$0 = r1;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    this.this$0.showViewHistoryDialog();
                    return true;
                }
            });
        }
    }

    public void bindToContent(UserHistory userHistory2) {
        Intrinsics.checkNotNullParameter(userHistory2, "userHistory");
        ItemUserHistoryBinding itemUserHistoryBinding = (ItemUserHistoryBinding) getBinding();
        this.userHistory = userHistory2;
        Intrinsics.checkNotNullExpressionValue(itemUserHistoryBinding, "binding");
        itemUserHistoryBinding.setClick(this);
        itemUserHistoryBinding.setUserHistory(userHistory2);
        CoolEllipsizeTextView coolEllipsizeTextView = itemUserHistoryBinding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView, "binding.descriptionView");
        coolEllipsizeTextView.setVisibility(TextUtils.isEmpty(userHistory2.getDescription()) ? 8 : 0);
        String content = userHistory2.getContent();
        if (content == null) {
            content = "";
        }
        SpannableStringBuilder convert = LinkTextUtils.convert(new Regex("[\\n\\r]").replace(content, " "), AppHolder.getAppTheme().getTextColorSecondary(), null);
        CoolEllipsizeTextView coolEllipsizeTextView2 = itemUserHistoryBinding.descriptionView;
        Intrinsics.checkNotNullExpressionValue(coolEllipsizeTextView2, "binding.descriptionView");
        ViewExtendsKt.setMaxLineEllipsize$default(coolEllipsizeTextView2, 1, convert, null, false, 4, null);
        itemUserHistoryBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Context context = getContext();
        UserHistory userHistory2 = this.userHistory;
        if (userHistory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userHistory");
        }
        ActionManager.startActivityByUrl(context, userHistory2.getUrl());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/UserHistoryViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserHistoryViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void showViewHistoryDialog() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            MultiItemDialogFragment initBuilder = MultiItemDialogFragment.Companion.newInstance().setInitBuilder(new UserHistoryViewHolder$showViewHistoryDialog$1(this, activityNullable));
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            initBuilder.show(supportFragmentManager, (String) null);
        }
    }
}
