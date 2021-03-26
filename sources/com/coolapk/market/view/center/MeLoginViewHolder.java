package com.coolapk.market.view.center;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.CenterV9SocialDialogBinding;
import com.coolapk.market.databinding.ItemCenterLoginBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.PrivacyAlertDialog;
import group.infotech.drawable.dsl.ShapesKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/center/MeLoginViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCenterLoginBinding;", "Lcom/coolapk/market/model/HolderItem;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bottomDrawable", "Landroid/graphics/drawable/GradientDrawable;", "topDrawable", "bindToContent", "", "data", "onClick", "view", "showSocialLoginDialog", "isCommunityMode", "", "showSocialLoginHint", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MeLoginViewHolder.kt */
public final class MeLoginViewHolder extends GenericBindHolder<ItemCenterLoginBinding, HolderItem> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558638;
    private final GradientDrawable bottomDrawable;
    private final GradientDrawable topDrawable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MeLoginViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemCenterLoginBinding itemCenterLoginBinding = (ItemCenterLoginBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCenterLoginBinding, "binding");
        itemCenterLoginBinding.setClick(this);
        LinearLayout linearLayout = ((ItemCenterLoginBinding) getBinding()).buttonLoginByPhone;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.buttonLoginByPhone");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ColorStateList.valueOf((int) 4294963676L));
        float dp = (float) NumberExtendsKt.getDp((Number) 21);
        gradientDrawable.setCornerRadii(new float[]{dp, dp, 0.0f, 0.0f, 0.0f, 0.0f, dp, dp});
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        LinearLayout linearLayout2 = ((ItemCenterLoginBinding) getBinding()).buttonLoginByPhone;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.buttonLoginByPhone");
        linearLayout2.setClipToOutline(true);
        LinearLayout linearLayout3 = ((ItemCenterLoginBinding) getBinding()).buttonLoginBySocial;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.buttonLoginBySocial");
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setColor(ColorStateList.valueOf((int) 4293588221L));
        float dp2 = (float) NumberExtendsKt.getDp((Number) 21);
        gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, dp2, dp2, dp2, dp2, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        linearLayout3.setBackground(gradientDrawable2);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setGradientType(0);
        gradientDrawable3.setGradientType(0);
        gradientDrawable3.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable3.setColors(new int[]{AppHolder.getAppTheme().getColorPrimary(), 0});
        Unit unit3 = Unit.INSTANCE;
        this.bottomDrawable = gradientDrawable3;
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setGradientType(0);
        ShapesKt.setSolidColor(gradientDrawable4, AppHolder.getAppTheme().getColorPrimary());
        Unit unit4 = Unit.INSTANCE;
        this.topDrawable = gradientDrawable4;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/MeLoginViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MeLoginViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        if (AppHolder.getAppTheme().isLightColorTheme()) {
            ((ItemCenterLoginBinding) getBinding()).topBgView.setImageDrawable(new ColorDrawable(AppHolder.getAppTheme().getMainBackgroundColor()));
            ((ItemCenterLoginBinding) getBinding()).bottomBgView.setImageDrawable(new ColorDrawable(AppHolder.getAppTheme().getMainBackgroundColor()));
        } else {
            ((ItemCenterLoginBinding) getBinding()).topBgView.setImageDrawable(this.topDrawable);
            ((ItemCenterLoginBinding) getBinding()).bottomBgView.setImageDrawable(this.bottomDrawable);
        }
        ((ItemCenterLoginBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable == null) {
            return;
        }
        if (PrivacyAlertDialog.Companion.shouldShowByIntent()) {
            PrivacyAlertDialog newInstance = PrivacyAlertDialog.Companion.newInstance();
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activityNullable).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            newInstance.show(supportFragmentManager, (String) null);
            return;
        }
        int id = view.getId();
        if (id != 2131362885) {
            switch (id) {
                case 2131362174:
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("点【手机短信登录】");
                    ActionManager.startLoginActivity(activityNullable, "https://account.coolapk.com/auth/login?type=mobile");
                    return;
                case 2131362175:
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("点【QQ登录】");
                    ActionManager.startLoginActivity(activityNullable, "https://account.coolapk.com/auth/loginByOpenId?type=qq");
                    return;
                case 2131362176:
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("点【社交账号登录】");
                    boolean isCommunityMode = AppHolder.getAppMetadata().isCommunityMode();
                    if (isCommunityMode) {
                        showSocialLoginDialog(isCommunityMode);
                        return;
                    } else {
                        showSocialLoginHint(isCommunityMode);
                        return;
                    }
                case 2131362177:
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("点【微信登录】");
                    ActionManager.startLoginActivity(activityNullable, "https://account.coolapk.com/auth/loginByOpenId?type=weixin");
                    return;
                case 2131362178:
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("点【微博登录】");
                    ActionManager.startLoginActivity(activityNullable, "https://account.coolapk.com/auth/loginByOpenId?type=weibo");
                    return;
                case 2131362179:
                    StatisticHelper.Companion.getInstance().recordLoginClickEvent("点【还没有账号？使用手机短信快速注册】");
                    ActionManager.startLoginActivity(activityNullable, "https://account.coolapk.com/auth/login?type=register");
                    return;
                default:
                    return;
            }
        } else {
            StatisticHelper.Companion.getInstance().recordLoginClickEvent("点【立即登录，玩转酷安】");
            ActionManager.startLoginActivity(activityNullable, "https://account.coolapk.com/auth/login?type=coolapk");
        }
    }

    private final void showSocialLoginHint(boolean z) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            Activity activity = activityNullable;
            AlertDialog create = new AlertDialog.Builder(activity).setMessage("由于合作方单方面取消授权，微信QQ登录与注册很可能失败，建议使用手机号或微博登录\n").setTitle("社交帐号登录提示").setPositiveButton("手机号登录", new MeLoginViewHolder$showSocialLoginHint$dialog$1(activityNullable)).setNegativeButton("继续使用社交登录", new MeLoginViewHolder$showSocialLoginHint$dialog$2(this, z)).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        }
    }

    /* access modifiers changed from: private */
    public final void showSocialLoginDialog(boolean z) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity activityNullable = UiUtils.getActivityNullable(context);
        if (activityNullable != null) {
            Activity activity = activityNullable;
            int i = 0;
            CenterV9SocialDialogBinding centerV9SocialDialogBinding = (CenterV9SocialDialogBinding) DataBindingUtil.inflate(LayoutInflater.from(activity), 2131558479, null, false);
            LinearLayout linearLayout = centerV9SocialDialogBinding.buttonLoginByQq;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.buttonLoginByQq");
            linearLayout.setVisibility(z ? 8 : 0);
            LinearLayout linearLayout2 = centerV9SocialDialogBinding.buttonLoginByWechat;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.buttonLoginByWechat");
            linearLayout2.setVisibility(z ? 8 : 0);
            TextView textView = centerV9SocialDialogBinding.tipsView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.tipsView");
            if (z) {
                i = 8;
            }
            textView.setVisibility(i);
            centerV9SocialDialogBinding.executePendingBindings();
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            Intrinsics.checkNotNullExpressionValue(centerV9SocialDialogBinding, "binding");
            AlertDialog create = builder.setView(centerV9SocialDialogBinding.getRoot()).create();
            Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
            FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
            WrapDialogFragmentKt.show(create, supportFragmentManager, null);
            create.setCanceledOnTouchOutside(true);
            create.setCancelable(true);
            centerV9SocialDialogBinding.setClick(new MeLoginViewHolder$showSocialLoginDialog$1(this, create));
        }
    }
}
