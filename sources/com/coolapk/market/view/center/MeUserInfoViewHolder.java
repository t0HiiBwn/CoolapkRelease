package com.coolapk.market.view.center;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemCenterUserInfoBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.RoundProgress;
import com.coolapk.market.widget.UserAvatarView;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0017J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0005H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/center/MeUserInfoViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCenterUserInfoBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/center/CenterPresenter;", "userAvatar", "", "bindToContent", "", "data", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeUserInfoViewHolder.kt */
public final class MeUserInfoViewHolder extends GenericBindHolder<ItemCenterUserInfoBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558643;
    private final CenterPresenter presenter;
    private String userAvatar = "";

    public final CenterPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeUserInfoViewHolder(View view, DataBindingComponent dataBindingComponent, CenterPresenter centerPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(centerPresenter, "presenter");
        this.presenter = centerPresenter;
        ItemCenterUserInfoBinding itemCenterUserInfoBinding = (ItemCenterUserInfoBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCenterUserInfoBinding, "binding");
        itemCenterUserInfoBinding.setClick(this);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/MeUserInfoViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MeUserInfoViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Type inference failed for: r12v8, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('/' char), (r8v2 java.lang.Integer)] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void bindToContent(HolderItem holderItem) {
        int i;
        int i2;
        String str;
        Intrinsics.checkNotNullParameter(holderItem, "data");
        ItemCenterUserInfoBinding itemCenterUserInfoBinding = (ItemCenterUserInfoBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCenterUserInfoBinding, "binding");
        itemCenterUserInfoBinding.setModel(this.presenter.getUserProfile());
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        String userName = loginSession.getUserName();
        ItemCenterUserInfoBinding itemCenterUserInfoBinding2 = (ItemCenterUserInfoBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCenterUserInfoBinding2, "binding");
        UserProfile model = itemCenterUserInfoBinding2.getModel();
        Integer num = null;
        String userName2 = model != null ? model.getUserName() : null;
        if (!Intrinsics.areEqual(userName, userName2)) {
            userName = userName2;
        }
        TextView textView = ((ItemCenterUserInfoBinding) getBinding()).nameView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.nameView");
        textView.setText(userName);
        String userAvatar2 = loginSession.getUserAvatar();
        Intrinsics.checkNotNullExpressionValue(userAvatar2, "session.userAvatar");
        this.userAvatar = userAvatar2;
        GlideApp.with(getContext()).load(this.userAvatar).transform(new CircleTransform(false, 0, 3, null)).into(((ItemCenterUserInfoBinding) getBinding()).userAvatarView);
        UserAvatarView userAvatarView = ((ItemCenterUserInfoBinding) getBinding()).userAvatarView;
        UserProfile userProfile = this.presenter.getUserProfile();
        UserAvatarView.bind$default(userAvatarView, userProfile != null ? userProfile.getVerifyStatusIcon() : null, false, 2, null);
        if (AppHolder.getAppTheme().isLightColorTheme()) {
            i = AppHolder.getAppTheme().getTextColorPrimary();
        } else {
            i = AppHolder.getAppTheme().getMainTextColor();
        }
        ItemCenterUserInfoBinding itemCenterUserInfoBinding3 = (ItemCenterUserInfoBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCenterUserInfoBinding3, "binding");
        UserProfile model2 = itemCenterUserInfoBinding3.getModel();
        Intrinsics.checkNotNull(model2);
        Intrinsics.checkNotNullExpressionValue(model2, "binding.model!!");
        int level = model2.getLevel();
        int colorInt = ResourceUtils.getColorInt(getContext(), level >= 10 ? 2131099902 : level == 9 ? 2131099910 : level == 8 ? 2131099909 : level == 7 ? 2131099908 : level == 6 ? 2131099907 : level == 5 ? 2131099906 : level == 4 ? 2131099905 : level == 3 ? 2131099904 : level == 2 ? 2131099903 : 2131099901);
        if (!AppHolder.getAppTheme().isMatchLevelBarTheme()) {
            colorInt = -1;
        }
        if (AppHolder.getAppTheme().isCustomTheme()) {
            if (AppHolder.getAppTheme().isCustomThemeDarkMode()) {
                colorInt = -1;
            } else {
                colorInt = AppHolder.getAppTheme().getColorAccent();
            }
        }
        if (AppHolder.getAppTheme().isWhiteTheme() || AppHolder.getAppTheme().isLightColorTheme()) {
            i2 = Color.parseColor("#e4e4e4");
        } else {
            i2 = ColorUtils.adjustAlpha(-1, 0.2f);
        }
        UserProfile userProfile2 = this.presenter.getUserProfile();
        String levelTodayMessage = userProfile2 != null ? userProfile2.getLevelTodayMessage() : null;
        String str2 = levelTodayMessage;
        if (!TextUtils.isEmpty(str2)) {
            str = levelTodayMessage;
        } else {
            UserProfile userProfile3 = this.presenter.getUserProfile();
            str = String.valueOf(userProfile3 != null ? Integer.valueOf(userProfile3.getLevelExperience()) : null);
        }
        UserProfile userProfile4 = this.presenter.getUserProfile();
        Integer valueOf = userProfile4 != null ? Integer.valueOf(userProfile4.getNextLevelExperience()) : null;
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        sb.append(valueOf);
        String sb2 = sb.toString();
        ((ItemCenterUserInfoBinding) getBinding()).nameView.setTextColor(i);
        ((ItemCenterUserInfoBinding) getBinding()).curExperience.setTextColor(AppHolder.getAppTheme().getMainTextColor());
        ((ItemCenterUserInfoBinding) getBinding()).allExperience.setTextColor(AppHolder.getAppTheme().getMainTextColor());
        TextView textView2 = ((ItemCenterUserInfoBinding) getBinding()).allExperience;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.allExperience");
        textView2.setText(sb2);
        TextView textView3 = ((ItemCenterUserInfoBinding) getBinding()).curExperience;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.curExperience");
        textView3.setText(str);
        if (!TextUtils.isEmpty(str2)) {
            Observable.timer(2000, TimeUnit.MILLISECONDS).compose(RxUtils.applyIOSchedulers()).subscribe(new MeUserInfoViewHolder$bindToContent$1(this));
        }
        UserProfile userProfile5 = this.presenter.getUserProfile();
        Integer valueOf2 = userProfile5 != null ? Integer.valueOf(userProfile5.getLevelExperience()) : null;
        Intrinsics.checkNotNull(valueOf2);
        float intValue = (float) valueOf2.intValue();
        RoundProgress roundProgress = ((ItemCenterUserInfoBinding) getBinding()).progressBar;
        UserProfile userProfile6 = this.presenter.getUserProfile();
        if (userProfile6 != null) {
            num = Integer.valueOf(userProfile6.getNextLevelExperience());
        }
        Intrinsics.checkNotNull(num);
        roundProgress.setMax((float) num.intValue());
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new MeUserInfoViewHolder$bindToContent$$inlined$apply$lambda$1(this, intValue, levelTodayMessage));
        valueAnimator.setDuration(1200L);
        valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimator.start();
        ((ItemCenterUserInfoBinding) getBinding()).levelBarView.setOnTouchListener(new MeUserInfoViewHolder$bindToContent$3(this));
        ((ItemCenterUserInfoBinding) getBinding()).progressBar.setRadius(NumberExtendsKt.getDp((Number) 5));
        ((ItemCenterUserInfoBinding) getBinding()).progressBar.setProgressColor(colorInt);
        ((ItemCenterUserInfoBinding) getBinding()).levelTextView.setTextColor(colorInt);
        ((ItemCenterUserInfoBinding) getBinding()).progressBar.setProgressBackgroundColor(i2);
        ((ItemCenterUserInfoBinding) getBinding()).executePendingBindings();
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
                    ItemCenterUserInfoBinding itemCenterUserInfoBinding = (ItemCenterUserInfoBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemCenterUserInfoBinding, "binding");
                    ActionManagerCompat.startUserQRCodeActivity(activityNullable, itemCenterUserInfoBinding.getModel());
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
