package com.coolapk.market.view.main;

import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppSetting;
import com.coolapk.market.databinding.LayoutPrivacyClauseBinding;
import com.coolapk.market.extend.ExtraExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.LinkTextUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feedv8.FakeStatusBarActivity;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.FixTouchLinkMovementMethod;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0002$%B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0010H\u0014J\b\u0010\u001c\u001a\u00020\u0010H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/coolapk/market/view/main/PermissionsAgreeActivity;", "Lcom/coolapk/market/view/feedv8/FakeStatusBarActivity;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/LayoutPrivacyClauseBinding;", "colorDrawable", "Landroid/graphics/drawable/ColorDrawable;", "dataList", "", "Lcom/coolapk/market/view/main/PermissionsAgreeActivity$PermissionsItem;", "isAnimating", "", "keyList", "", "agree", "", "createRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "finish", "onBackPressed", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onlyView", "saveIntentAndVersion", "intent", "setAnimationValue", "value", "", "startCloseAnimation", "startOpenAnimation", "Companion", "PermissionsItem", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PermissionsAgreeActivity.kt */
public final class PermissionsAgreeActivity extends FakeStatusBarActivity implements View.OnClickListener {
    private static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    private static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    private static final String CAMERA = "android.permission.CAMERA";
    public static final Companion Companion = new Companion(null);
    public static final String DEVICE = "DEVICE";
    public static final String LOCATION = "LOCATION";
    private static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    private static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String STORAGE = "STORAGE";
    public static final String USER_PRIVACY_INTENT_AGREE = "AGREE";
    public static final String USER_PRIVACY_INTENT_VIEW_ONLY = "VIEW_ONLY";
    public static final String USE_CAMERA = "USE_CAMERA";
    private static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";
    private LayoutPrivacyClauseBinding binding;
    private ColorDrawable colorDrawable;
    private final List<PermissionsItem> dataList = new ArrayList();
    private boolean isAnimating;
    private final List<String> keyList;

    @JvmStatic
    public static final boolean shouldShowByFirstInstall() {
        return Companion.shouldShowByFirstInstall();
    }

    @JvmStatic
    public static final boolean shouldShowByIntent() {
        return Companion.shouldShowByIntent();
    }

    @JvmStatic
    public static final boolean shouldShowByVersion() {
        return Companion.shouldShowByVersion();
    }

    @Override // com.coolapk.market.view.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    public PermissionsAgreeActivity() {
        ArrayList arrayList = new ArrayList();
        this.keyList = arrayList;
        this.colorDrawable = new ColorDrawable(-16777216);
        arrayList.add("STORAGE");
        arrayList.add("USE_CAMERA");
        arrayList.add("LOCATION");
        arrayList.add("DEVICE");
    }

    public static final /* synthetic */ LayoutPrivacyClauseBinding access$getBinding$p(PermissionsAgreeActivity permissionsAgreeActivity) {
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding = permissionsAgreeActivity.binding;
        if (layoutPrivacyClauseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return layoutPrivacyClauseBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0011H\u0007J\b\u0010\u0013\u001a\u00020\u0011H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/main/PermissionsAgreeActivity$Companion;", "", "()V", "ACCESS_COARSE_LOCATION", "", "ACCESS_FINE_LOCATION", "CAMERA", "DEVICE", "LOCATION", "READ_EXTERNAL_STORAGE", "READ_PHONE_STATE", "STORAGE", "USER_PRIVACY_INTENT_AGREE", "USER_PRIVACY_INTENT_VIEW_ONLY", "USE_CAMERA", "WRITE_EXTERNAL_STORAGE", "shouldShowByFirstInstall", "", "shouldShowByIntent", "shouldShowByVersion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PermissionsAgreeActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean shouldShowByFirstInstall() {
            return DataManager.getInstance().getPreferencesString("USER_PRIVACY_INTENT", null) == null;
        }

        @JvmStatic
        public final boolean shouldShowByIntent() {
            return !Intrinsics.areEqual(DataManager.getInstance().getPreferencesString("USER_PRIVACY_INTENT", null), "AGREE");
        }

        @JvmStatic
        public final boolean shouldShowByVersion() {
            AppSetting appSetting = AppHolder.getAppSetting();
            Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
            String optString = appSetting.getConfigJson().optString("UserPrivacy.Version", null);
            String preferencesString = DataManager.getInstance().getPreferencesString("USER_PRIVACY_VERSION", null);
            if (optString != null && !TextUtils.equals(optString, preferencesString)) {
                return true;
            }
            return false;
        }
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        getWindow().requestFeature(1);
        setContentBarAlwaysTranslucent(true);
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, 2131559006, null);
        Intrinsics.checkNotNullExpressionValue(contentView, "DataBindingUtil.setConte…out_privacy_clause, null)");
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding = (LayoutPrivacyClauseBinding) contentView;
        this.binding = layoutPrivacyClauseBinding;
        if (layoutPrivacyClauseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        layoutPrivacyClauseBinding.setClick(this);
        setSlidrEnable(false);
        SpannableStringBuilder convert = LinkTextUtils.convert("以上权限您可随时在系统设置中开启或关闭，我们更新完善了《<a href=\"" + UriUtils.getCoolApkUserAgreementUrl() + "\">用户协议</a>》与《<a href=\"" + UriUtils.getCoolApkUserPrivacyUrl() + "\">隐私政策</a>》，进入app前请仔细阅读，如您不同意该协议，您将进入仅浏览模式，该模式下您将无法登录注册。", AppHolder.getAppTheme().getColorAccent(), null);
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding2 = this.binding;
        if (layoutPrivacyClauseBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = layoutPrivacyClauseBinding2.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText("酷安隐私条款");
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding3 = this.binding;
        if (layoutPrivacyClauseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = layoutPrivacyClauseBinding3.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        textView2.setText("欢迎您使用酷安，使用之前，请您仔细阅读以下权限说明，为提供某些服务，我们需要向您获取以下权限");
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding4 = this.binding;
        if (layoutPrivacyClauseBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView3 = layoutPrivacyClauseBinding4.descriptionView2;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView2");
        textView3.setText(convert);
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding5 = this.binding;
        if (layoutPrivacyClauseBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView4 = layoutPrivacyClauseBinding5.agreeView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.agreeView");
        textView4.setBackground(new ColorDrawable(AppHolder.getAppTheme().getColorAccent()));
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding6 = this.binding;
        if (layoutPrivacyClauseBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView5 = layoutPrivacyClauseBinding6.onlyView;
        Intrinsics.checkNotNullExpressionValue(textView5, "binding.onlyView");
        textView5.setBackground(new ColorDrawable(AppHolder.getAppTheme().getContentBackgroundDividerColor()));
        this.dataList.add(new PermissionsItem("STORAGE", "1.读取/修改手机存储权限", "用于保存或上传图片"));
        this.dataList.add(new PermissionsItem("LOCATION", "2.访问用户位置", "用于个性化广告、分享动态位置、以及二手交易功能"));
        this.dataList.add(new PermissionsItem("USE_CAMERA", "3.访问相机", "使用二维码扫一扫功能"));
        this.dataList.add(new PermissionsItem("DEVICE", "4.读取设备识别码", "用于确定设备的唯一性，参与统计以及账号保护"));
        createRecyclerView();
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding7 = this.binding;
        if (layoutPrivacyClauseBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        layoutPrivacyClauseBinding7.mainContent.setPadding(0, NumberExtendsKt.getDp((Number) 180), 0, 0);
        if (!isFinishing()) {
            float dp = (float) NumberExtendsKt.getDp((Number) 16);
            LayoutPrivacyClauseBinding layoutPrivacyClauseBinding8 = this.binding;
            if (layoutPrivacyClauseBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = layoutPrivacyClauseBinding8.contentView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
            gradientDrawable.setCornerRadii(new float[]{dp, dp, dp, dp, 0.0f, 0.0f, 0.0f, 0.0f});
            Unit unit = Unit.INSTANCE;
            linearLayout.setBackground(gradientDrawable);
            LayoutPrivacyClauseBinding layoutPrivacyClauseBinding9 = this.binding;
            if (layoutPrivacyClauseBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            layoutPrivacyClauseBinding9.executePendingBindings();
        }
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding10 = this.binding;
        if (layoutPrivacyClauseBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = layoutPrivacyClauseBinding10.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.getViewTreeObserver().addOnPreDrawListener(new PermissionsAgreeActivity$onCreate$2(this));
    }

    /* access modifiers changed from: private */
    public final void startOpenAnimation() {
        this.isAnimating = true;
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new PermissionsAgreeActivity$startOpenAnimation$$inlined$apply$lambda$1(this));
        ExtraExtendsKt.doOnEnd(valueAnimator, new PermissionsAgreeActivity$startOpenAnimation$$inlined$apply$lambda$2(this));
        valueAnimator.setDuration(300L);
        valueAnimator.start();
    }

    private final void startCloseAnimation() {
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding = this.binding;
        if (layoutPrivacyClauseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        DrawSystemBarFrameLayout drawSystemBarFrameLayout = layoutPrivacyClauseBinding.mainContent;
        Intrinsics.checkNotNullExpressionValue(drawSystemBarFrameLayout, "binding.mainContent");
        if (drawSystemBarFrameLayout.getLastInsetsRect().bottom > UiUtils.getNavigationBarHeight(getActivity())) {
            finish();
        } else if (!isFinishing()) {
            this.isAnimating = true;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setFloatValues(1.0f, 0.0f);
            valueAnimator.addUpdateListener(new PermissionsAgreeActivity$startCloseAnimation$$inlined$apply$lambda$1(this));
            valueAnimator.setDuration(300L);
            ExtraExtendsKt.doOnEnd(valueAnimator, new PermissionsAgreeActivity$startCloseAnimation$$inlined$apply$lambda$2(this));
            valueAnimator.start();
        }
    }

    /* access modifiers changed from: private */
    public final void setAnimationValue(float f) {
        this.colorDrawable.setAlpha((int) (((float) 66) * f));
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding = this.binding;
        if (layoutPrivacyClauseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = layoutPrivacyClauseBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        root.setBackground(this.colorDrawable);
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding2 = this.binding;
        if (layoutPrivacyClauseBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = layoutPrivacyClauseBinding2.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.contentView");
        float f2 = ((float) 1) - f;
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding3 = this.binding;
        if (layoutPrivacyClauseBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout2 = layoutPrivacyClauseBinding3.contentView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.contentView");
        linearLayout.setTranslationY(f2 * ((float) linearLayout2.getHeight()));
    }

    @Override // com.coolapk.market.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    private final RecyclerView createRecyclerView() {
        LayoutPrivacyClauseBinding layoutPrivacyClauseBinding = this.binding;
        if (layoutPrivacyClauseBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RecyclerView recyclerView = layoutPrivacyClauseBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.listView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new PermissionsAgreeActivity$createRecyclerView$$inlined$apply$lambda$1(this));
        return recyclerView;
    }

    @Override // com.coolapk.market.view.feedv8.FakeStatusBarActivity, com.coolapk.market.view.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        try {
            LayoutPrivacyClauseBinding layoutPrivacyClauseBinding = this.binding;
            if (layoutPrivacyClauseBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            TextView textView = layoutPrivacyClauseBinding.descriptionView2;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.descriptionView2");
            textView.setMovementMethod(FixTouchLinkMovementMethod.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/view/main/PermissionsAgreeActivity$PermissionsItem;", "", "permissionsKey", "", "title", "subTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPermissionsKey", "()Ljava/lang/String;", "getSubTitle", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: PermissionsAgreeActivity.kt */
    public static final class PermissionsItem {
        private final String permissionsKey;
        private final String subTitle;
        private final String title;

        public static /* synthetic */ PermissionsItem copy$default(PermissionsItem permissionsItem, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = permissionsItem.permissionsKey;
            }
            if ((i & 2) != 0) {
                str2 = permissionsItem.title;
            }
            if ((i & 4) != 0) {
                str3 = permissionsItem.subTitle;
            }
            return permissionsItem.copy(str, str2, str3);
        }

        public final String component1() {
            return this.permissionsKey;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.subTitle;
        }

        public final PermissionsItem copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "permissionsKey");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "subTitle");
            return new PermissionsItem(str, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PermissionsItem)) {
                return false;
            }
            PermissionsItem permissionsItem = (PermissionsItem) obj;
            return Intrinsics.areEqual(this.permissionsKey, permissionsItem.permissionsKey) && Intrinsics.areEqual(this.title, permissionsItem.title) && Intrinsics.areEqual(this.subTitle, permissionsItem.subTitle);
        }

        public int hashCode() {
            String str = this.permissionsKey;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.subTitle;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "PermissionsItem(permissionsKey=" + this.permissionsKey + ", title=" + this.title + ", subTitle=" + this.subTitle + ")";
        }

        public PermissionsItem(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "permissionsKey");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "subTitle");
            this.permissionsKey = str;
            this.title = str2;
            this.subTitle = str3;
        }

        public final String getPermissionsKey() {
            return this.permissionsKey;
        }

        public final String getSubTitle() {
            return this.subTitle;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    private final void onlyView() {
        if (!this.isAnimating) {
            saveIntentAndVersion("VIEW_ONLY");
            getActivity().setResult(0);
            startCloseAnimation();
        }
    }

    private final void agree() {
        if (!this.isAnimating) {
            saveIntentAndVersion("AGREE");
            AppHolder.getThirdStatUtils().confirmInit();
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.READ_PHONE_STATE");
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            getActivity().setResult(-1, getIntent().putExtra("list", arrayList));
            startCloseAnimation();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf == null || valueOf.intValue() != 2131362322) {
            if (valueOf == null || valueOf.intValue() != 2131362911) {
                if (valueOf != null && valueOf.intValue() == 2131363056) {
                    onlyView();
                } else if (valueOf != null && valueOf.intValue() == 2131362009) {
                    agree();
                }
            }
        }
    }

    private final void saveIntentAndVersion(String str) {
        AppSetting appSetting = AppHolder.getAppSetting();
        Intrinsics.checkNotNullExpressionValue(appSetting, "AppHolder.getAppSetting()");
        String optString = appSetting.getConfigJson().optString("UserPrivacy.Version", null);
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("USER_PRIVACY_INTENT", str).putString("USER_PRIVACY_VERSION", optString).apply();
    }
}
