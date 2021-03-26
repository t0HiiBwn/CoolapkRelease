package com.coolapk.market.view.userv9;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.coolapk.market.databinding.UserQrcodeBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.local.DataConfig;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.UserProfile;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.AlphableToolbar;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.widget.UserAvatarView;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/userv9/UserQRCodeFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/UserQrcodeBinding;", "buildQRCodeUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "uid", "", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "saveToTempPath", "Ljava/io/File;", "setupView", "userProfile", "Lcom/coolapk/market/model/UserProfile;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: UserQRCodeFragment.kt */
public final class UserQRCodeFragment extends BaseFragment {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_EXTRA_PROFILE = "PROFILE";
    private UserQrcodeBinding binding;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/userv9/UserQRCodeFragment$Companion;", "", "()V", "KEY_EXTRA_PROFILE", "", "newInstance", "Lcom/coolapk/market/view/userv9/UserQRCodeFragment;", "userProfile", "Lcom/coolapk/market/model/UserProfile;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: UserQRCodeFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserQRCodeFragment newInstance(UserProfile userProfile) {
            Intrinsics.checkNotNullParameter(userProfile, "userProfile");
            UserQRCodeFragment userQRCodeFragment = new UserQRCodeFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("PROFILE", userProfile);
            Unit unit = Unit.INSTANCE;
            userQRCodeFragment.setArguments(bundle);
            return userQRCodeFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559294, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…qrcode, container, false)");
        UserQrcodeBinding userQrcodeBinding = (UserQrcodeBinding) inflate;
        this.binding = userQrcodeBinding;
        if (userQrcodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return userQrcodeBinding.getRoot();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.setRequestedOrientation(1);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof AlphableToolbar)) {
            activity = null;
        }
        AlphableToolbar alphableToolbar = (AlphableToolbar) activity;
        if (alphableToolbar != null) {
            alphableToolbar.setToolbarAlpha(0.0f);
        }
        UserProfile userProfile = (UserProfile) requireArguments().getParcelable("PROFILE");
        if (userProfile != null) {
            setupView(userProfile);
            return;
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        DialogUtil dialogUtil = DialogUtil.INSTANCE;
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity()");
        Dialog showProgressDialog$default = DialogUtil.showProgressDialog$default(dialogUtil, requireActivity2, "正在处理, 请稍等...", false, 4, null);
        DataManager instance2 = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        instance2.getUserProfile(loginSession.getUid()).compose(RxUtils.apiCommonToData()).doOnUnsubscribe(new UserQRCodeFragment$onActivityCreated$1(showProgressDialog$default)).subscribe((Subscriber<? super R>) new UserQRCodeFragment$onActivityCreated$2(this));
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARN: Type inference failed for: r11v3, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final void setupView(UserProfile userProfile) {
        String str;
        String str2;
        String str3;
        UserQrcodeBinding userQrcodeBinding = this.binding;
        if (userQrcodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = userQrcodeBinding.logoView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.logoView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(NumberExtendsKt.getDp((Number) 2), -1);
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 8));
        Unit unit = Unit.INSTANCE;
        ViewExtendsKt.setCompatForeground(imageView, gradientDrawable);
        UserQrcodeBinding userQrcodeBinding2 = this.binding;
        if (userQrcodeBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = userQrcodeBinding2.userNameView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.userNameView");
        textView.setText(userProfile.getUserName());
        int fansNum = userProfile.getFansNum();
        if (fansNum >= 10000) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            str = String.format("%.1fW", Arrays.copyOf(new Object[]{Float.valueOf(((float) fansNum) / ((float) 10000))}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "java.lang.String.format(format, *args)");
        } else {
            str = String.valueOf(fansNum);
        }
        int followNum = userProfile.getFollowNum();
        if (followNum >= 10000) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            str2 = String.format("%.1fW", Arrays.copyOf(new Object[]{Float.valueOf(((float) followNum) / ((float) 10000))}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "java.lang.String.format(format, *args)");
        } else {
            str2 = String.valueOf(followNum);
        }
        if (userProfile.getLevel() > 0) {
            str3 = "LV." + userProfile.getLevel();
        } else {
            str3 = "";
        }
        UserQrcodeBinding userQrcodeBinding3 = this.binding;
        if (userQrcodeBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = userQrcodeBinding3.descriptionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
        textView2.setText(str2 + "关注 " + str + "粉丝 " + str3);
        UserQRCodeFragment userQRCodeFragment = this;
        GlideRequest transform = GlideApp.with(userQRCodeFragment).load(userProfile.getUserAvatar()).placeholder(2131231162).transform((Transformation<Bitmap>) new CircleTransform(false, 0, 3, null));
        UserQrcodeBinding userQrcodeBinding4 = this.binding;
        if (userQrcodeBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        transform.into(userQrcodeBinding4.userAvatarView);
        UserQrcodeBinding userQrcodeBinding5 = this.binding;
        if (userQrcodeBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        UserAvatarView.bind$default(userQrcodeBinding5.userAvatarView, userProfile.getVerifyStatusIcon(), false, 2, null);
        GlideRequests with = GlideApp.with(userQRCodeFragment);
        String uid = userProfile.getUid();
        Intrinsics.checkNotNullExpressionValue(uid, "userProfile.uid");
        GlideRequest override = with.load((Object) buildQRCodeUrl(uid)).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).override(Integer.MIN_VALUE, Integer.MIN_VALUE);
        UserQrcodeBinding userQrcodeBinding6 = this.binding;
        if (userQrcodeBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        override.into(userQrcodeBinding6.qrCodeView);
        UserQrcodeBinding userQrcodeBinding7 = this.binding;
        if (userQrcodeBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userQrcodeBinding7.actionQrScan.setOnClickListener(new UserQRCodeFragment$setupView$2(this));
        UserQrcodeBinding userQrcodeBinding8 = this.binding;
        if (userQrcodeBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userQrcodeBinding8.actionShare.setOnClickListener(new UserQRCodeFragment$setupView$3(this));
        UserQrcodeBinding userQrcodeBinding9 = this.binding;
        if (userQrcodeBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        userQrcodeBinding9.actionSave.setOnClickListener(new UserQRCodeFragment$setupView$4(this));
    }

    private final GlideUrl buildQRCodeUrl(String str) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        DataConfig dataConfig = instance.getDataConfig();
        Intrinsics.checkNotNullExpressionValue(dataConfig, "dataConfig");
        String uri = Uri.parse(dataConfig.getApiEndpoint()).buildUpon().appendEncodedPath("user/qrImage").appendQueryParameter("uid", str).build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Uri.parse(dataConfig.api…      .build().toString()");
        LazyHeaders.Builder createGlideCoolApkHeader = KotlinExtendKt.createGlideCoolApkHeader();
        KotlinExtendKt.appendCoolApkCookies(createGlideCoolApkHeader);
        return new GlideUrl(uri, createGlideCoolApkHeader.build());
    }

    /* access modifiers changed from: private */
    public final File saveToTempPath() {
        String generateFileOutputPath = BitmapUtil.generateFileOutputPath(getActivity(), String.valueOf(System.currentTimeMillis()));
        UserQrcodeBinding userQrcodeBinding = this.binding;
        if (userQrcodeBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        Bitmap takeSnapshot = UiUtils.takeSnapshot(userQrcodeBinding.qrViewContainer);
        File file = new File(generateFileOutputPath);
        BitmapUtil.saveBitmapToFile(file, takeSnapshot, true);
        return file;
    }
}
