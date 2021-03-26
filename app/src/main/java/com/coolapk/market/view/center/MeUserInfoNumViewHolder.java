package com.coolapk.market.view.center;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemUserInfoNumBinding;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.Tips;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.viewholder.GenericBindHolder;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/view/center/MeUserInfoNumViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemUserInfoNumBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/center/CenterPresenter;", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeUserInfoNumViewHolder.kt */
public final class MeUserInfoNumViewHolder extends GenericBindHolder<ItemUserInfoNumBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558975;
    private static HashSet<Tips> ignoreTipSet = new HashSet<>();
    private final CenterPresenter presenter;

    public final CenterPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeUserInfoNumViewHolder(View view, DataBindingComponent dataBindingComponent, CenterPresenter centerPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(centerPresenter, "presenter");
        this.presenter = centerPresenter;
        ItemUserInfoNumBinding itemUserInfoNumBinding = (ItemUserInfoNumBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemUserInfoNumBinding, "binding");
        itemUserInfoNumBinding.setClick(this);
        TextView textView = ((ItemUserInfoNumBinding) getBinding()).text1;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.text1");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTypeface(ProductGlobalData.getNumberTypeface(context));
        TextView textView2 = ((ItemUserInfoNumBinding) getBinding()).text2;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.text2");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        textView2.setTypeface(ProductGlobalData.getNumberTypeface(context2));
        TextView textView3 = ((ItemUserInfoNumBinding) getBinding()).text3;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.text3");
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "context");
        textView3.setTypeface(ProductGlobalData.getNumberTypeface(context3));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/center/MeUserInfoNumViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "ignoreTipSet", "Ljava/util/HashSet;", "Lcom/coolapk/market/model/Tips;", "Lkotlin/collections/HashSet;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MeUserInfoNumViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ItemUserInfoNumBinding itemUserInfoNumBinding = (ItemUserInfoNumBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemUserInfoNumBinding, "binding");
        itemUserInfoNumBinding.setModel(this.presenter.getUserProfile());
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getLoginSession();
        ((ItemUserInfoNumBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            DataManager instance = DataManager.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
            LoginSession loginSession = instance.getLoginSession();
            switch (view.getId()) {
                case 2131363154:
                    ItemUserInfoNumBinding itemUserInfoNumBinding = (ItemUserInfoNumBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemUserInfoNumBinding, "binding");
                    ActionManagerCompat.startUserQRCodeActivity(activityNullable, itemUserInfoNumBinding.getModel());
                    return;
                case 2131363882:
                    Activity currentActivity = AppHolder.getCurrentActivity();
                    if (currentActivity != null) {
                        Boolean checkLogin = ActionManager.checkLogin(currentActivity);
                        Intrinsics.checkNotNullExpressionValue(checkLogin, "ActionManager.checkLogin(it)");
                        if (checkLogin.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startFansListActivity(activityNullable, loginSession.getUid(), getContext().getString(2131887255));
                            return;
                        }
                        return;
                    }
                    return;
                case 2131363883:
                    Activity currentActivity2 = AppHolder.getCurrentActivity();
                    if (currentActivity2 != null) {
                        Boolean checkLogin2 = ActionManager.checkLogin(currentActivity2);
                        Intrinsics.checkNotNullExpressionValue(checkLogin2, "ActionManager.checkLogin(it)");
                        if (checkLogin2.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startUserFeedListActivity(activityNullable, loginSession.getUid());
                            return;
                        }
                        return;
                    }
                    return;
                case 2131363885:
                    Activity currentActivity3 = AppHolder.getCurrentActivity();
                    if (currentActivity3 != null) {
                        Boolean checkLogin3 = ActionManager.checkLogin(currentActivity3);
                        Intrinsics.checkNotNullExpressionValue(checkLogin3, "ActionManager.checkLogin(it)");
                        if (checkLogin3.booleanValue()) {
                            Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                            ActionManager.startFriendListActivity(activityNullable, loginSession.getUid(), getContext().getString(2131887260));
                            return;
                        }
                        return;
                    }
                    return;
                case 2131363887:
                    Intrinsics.checkNotNullExpressionValue(loginSession, "session");
                    if (!loginSession.isLogin()) {
                        ActionManager.startLoginActivity(activityNullable);
                        return;
                    } else {
                        ActionManager.startUserSpaceActivity(activityNullable, loginSession.getUid());
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
