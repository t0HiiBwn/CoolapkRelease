package com.coolapk.market.view.settings;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.ConvertUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.PostButtonSettingBinding;
import com.coolapk.market.event.PostButtonEvent;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.imageloader.GlideRequest;
import com.coolapk.market.imageloader.GlideRequests;
import com.coolapk.market.imageloader.StringSignature;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.util.BitmapUtil;
import com.coolapk.market.util.CoolFileUtils;
import com.coolapk.market.util.LogUtils;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.settings.settingsynch.SettingSynchronized;
import com.coolapk.market.widget.PostButtonView2Kt;
import com.coolapk.market.widget.Toast;
import com.meg7.widget.SvgImageView;
import com.yalantis.ucrop.UCrop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u001d\u001a\u00020\u000e2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0002J\f\u0010 \u001a\u00020\u000e*\u00020!H\u0002J\u0014\u0010\"\u001a\u00020\u000e*\u00020!2\u0006\u0010#\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/settings/PostButtonSettingFragment;", "Lcom/coolapk/market/view/base/BaseFragment;", "()V", "binding", "Lcom/coolapk/market/databinding/PostButtonSettingBinding;", "outputFiles", "Ljava/io/File;", "createIcon", "Landroid/graphics/drawable/StateListDrawable;", "createPostButtonBg", "Landroid/graphics/drawable/Drawable;", "createTextColor", "Landroid/content/res/ColorStateList;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "updateCustomImage", "fromCrop", "", "applyIconColor", "Landroid/widget/ImageView;", "setIcon", "drawableRes", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: PostButtonSettingFragment.kt */
public final class PostButtonSettingFragment extends BaseFragment {
    private PostButtonSettingBinding binding;
    private File outputFiles;

    public static final /* synthetic */ PostButtonSettingBinding access$getBinding$p(PostButtonSettingFragment postButtonSettingFragment) {
        PostButtonSettingBinding postButtonSettingBinding = postButtonSettingFragment.binding;
        if (postButtonSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return postButtonSettingBinding;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131559096, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…etting, container, false)");
        PostButtonSettingBinding postButtonSettingBinding = (PostButtonSettingBinding) inflate;
        this.binding = postButtonSettingBinding;
        if (postButtonSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        View root = postButtonSettingBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final Drawable createPostButtonBg() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        return PostButtonView2Kt.createSvgIconCompat(requireActivity, 2131231505, AppHolder.getAppTheme().getColorAccent());
    }

    private final void applyIconColor(ImageView imageView) {
        ColorStateList valueOf = ColorStateList.valueOf(-16776961);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(Color.BLUE)");
        ImageViewCompat.setImageTintList(imageView, valueOf);
    }

    private final void setIcon(ImageView imageView, int i) {
        Drawable drawable = ContextCompat.getDrawable(requireActivity(), i);
        Intrinsics.checkNotNull(drawable);
        Intrinsics.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…ctivity(), drawableRes)!!");
        DrawableCompat.wrap(drawable).mutate();
        DrawableCompat.setTint(drawable, -1);
        imageView.setImageDrawable(drawable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.outputFiles = new File(BitmapUtil.generateFileOutputPath(getActivity(), "post_button_custom"));
        float dp2px = (float) ConvertUtils.dp2px(0.0f);
        PostButtonSettingBinding postButtonSettingBinding = this.binding;
        if (postButtonSettingBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView = postButtonSettingBinding.plusBackgroundView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.plusBackgroundView");
        imageView.setBackground(createPostButtonBg());
        PostButtonSettingBinding postButtonSettingBinding2 = this.binding;
        if (postButtonSettingBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView2 = postButtonSettingBinding2.airplaneBackgroundView;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.airplaneBackgroundView");
        imageView2.setBackground(createPostButtonBg());
        PostButtonSettingBinding postButtonSettingBinding3 = this.binding;
        if (postButtonSettingBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView3 = postButtonSettingBinding3.coolapkBackgroundView;
        Intrinsics.checkNotNullExpressionValue(imageView3, "binding.coolapkBackgroundView");
        imageView3.setBackground(createPostButtonBg());
        PostButtonSettingBinding postButtonSettingBinding4 = this.binding;
        if (postButtonSettingBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView4 = postButtonSettingBinding4.customButtonImagePlaceholder;
        Intrinsics.checkNotNullExpressionValue(imageView4, "binding.customButtonImagePlaceholder");
        imageView4.setBackground(createPostButtonBg());
        PostButtonSettingBinding postButtonSettingBinding5 = this.binding;
        if (postButtonSettingBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView5 = postButtonSettingBinding5.plusBackgroundView;
        Intrinsics.checkNotNullExpressionValue(imageView5, "binding.plusBackgroundView");
        setIcon(imageView5, 2131231500);
        PostButtonSettingBinding postButtonSettingBinding6 = this.binding;
        if (postButtonSettingBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView6 = postButtonSettingBinding6.airplaneBackgroundView;
        Intrinsics.checkNotNullExpressionValue(imageView6, "binding.airplaneBackgroundView");
        setIcon(imageView6, 2131231495);
        PostButtonSettingBinding postButtonSettingBinding7 = this.binding;
        if (postButtonSettingBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView7 = postButtonSettingBinding7.coolapkBackgroundView;
        Intrinsics.checkNotNullExpressionValue(imageView7, "binding.coolapkBackgroundView");
        setIcon(imageView7, 2131231421);
        PostButtonSettingBinding postButtonSettingBinding8 = this.binding;
        if (postButtonSettingBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ImageView imageView8 = postButtonSettingBinding8.customButtonImagePlaceholder;
        Intrinsics.checkNotNullExpressionValue(imageView8, "binding.customButtonImagePlaceholder");
        setIcon(imageView8, 2131231489);
        PostButtonSettingBinding postButtonSettingBinding9 = this.binding;
        if (postButtonSettingBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding9.radioPlus.setTextColor(createTextColor());
        PostButtonSettingBinding postButtonSettingBinding10 = this.binding;
        if (postButtonSettingBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding10.radioAirplane.setTextColor(createTextColor());
        PostButtonSettingBinding postButtonSettingBinding11 = this.binding;
        if (postButtonSettingBinding11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding11.radioCoolapk.setTextColor(createTextColor());
        PostButtonSettingBinding postButtonSettingBinding12 = this.binding;
        if (postButtonSettingBinding12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding12.radioCustom.setTextColor(createTextColor());
        PostButtonSettingBinding postButtonSettingBinding13 = this.binding;
        if (postButtonSettingBinding13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton = postButtonSettingBinding13.radioPlus;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioPlus");
        radioButton.setClickable(false);
        PostButtonSettingBinding postButtonSettingBinding14 = this.binding;
        if (postButtonSettingBinding14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton2 = postButtonSettingBinding14.radioAirplane;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.radioAirplane");
        radioButton2.setClickable(false);
        PostButtonSettingBinding postButtonSettingBinding15 = this.binding;
        if (postButtonSettingBinding15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton3 = postButtonSettingBinding15.radioCoolapk;
        Intrinsics.checkNotNullExpressionValue(radioButton3, "binding.radioCoolapk");
        radioButton3.setClickable(false);
        PostButtonSettingBinding postButtonSettingBinding16 = this.binding;
        if (postButtonSettingBinding16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton4 = postButtonSettingBinding16.radioCustom;
        Intrinsics.checkNotNullExpressionValue(radioButton4, "binding.radioCustom");
        radioButton4.setClickable(false);
        PostButtonSettingBinding postButtonSettingBinding17 = this.binding;
        if (postButtonSettingBinding17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton5 = postButtonSettingBinding17.radioPlus;
        Intrinsics.checkNotNullExpressionValue(radioButton5, "binding.radioPlus");
        Drawable drawable = null;
        radioButton5.setBackground(drawable);
        PostButtonSettingBinding postButtonSettingBinding18 = this.binding;
        if (postButtonSettingBinding18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton6 = postButtonSettingBinding18.radioAirplane;
        Intrinsics.checkNotNullExpressionValue(radioButton6, "binding.radioAirplane");
        radioButton6.setBackground(drawable);
        PostButtonSettingBinding postButtonSettingBinding19 = this.binding;
        if (postButtonSettingBinding19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton7 = postButtonSettingBinding19.radioCoolapk;
        Intrinsics.checkNotNullExpressionValue(radioButton7, "binding.radioCoolapk");
        radioButton7.setBackground(drawable);
        PostButtonSettingBinding postButtonSettingBinding20 = this.binding;
        if (postButtonSettingBinding20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton8 = postButtonSettingBinding20.radioCustom;
        Intrinsics.checkNotNullExpressionValue(radioButton8, "binding.radioCustom");
        radioButton8.setBackground(drawable);
        PostButtonSettingBinding postButtonSettingBinding21 = this.binding;
        if (postButtonSettingBinding21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding21.radioGroup.setOnCheckedChangeListener(new PostButtonSettingFragment$onActivityCreated$1(this, dp2px));
        PostButtonSettingBinding postButtonSettingBinding22 = this.binding;
        if (postButtonSettingBinding22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding22.plusLayout.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$2(this));
        PostButtonSettingBinding postButtonSettingBinding23 = this.binding;
        if (postButtonSettingBinding23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding23.airplaneLayout.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$3(this));
        PostButtonSettingBinding postButtonSettingBinding24 = this.binding;
        if (postButtonSettingBinding24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding24.coolapkLayout.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$4(this));
        PostButtonSettingBinding postButtonSettingBinding25 = this.binding;
        if (postButtonSettingBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding25.customLayout.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$5(this));
        String preferencesString = DataManager.getInstance().getPreferencesString("POST_BUTTON_SETTING_KEY", "PLUS");
        if (preferencesString != null) {
            switch (preferencesString.hashCode()) {
                case 2459034:
                    if (preferencesString.equals("PLUS")) {
                        PostButtonSettingBinding postButtonSettingBinding26 = this.binding;
                        if (postButtonSettingBinding26 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding26.radioGroup.check(2131363188);
                        break;
                    }
                    break;
                case 105615186:
                    if (preferencesString.equals("AIRPLANE")) {
                        PostButtonSettingBinding postButtonSettingBinding27 = this.binding;
                        if (postButtonSettingBinding27 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding27.radioGroup.check(2131363176);
                        break;
                    }
                    break;
                case 1670194707:
                    if (preferencesString.equals("COOLAPK")) {
                        PostButtonSettingBinding postButtonSettingBinding28 = this.binding;
                        if (postButtonSettingBinding28 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding28.radioGroup.check(2131363178);
                        break;
                    }
                    break;
                case 1999208305:
                    if (preferencesString.equals("CUSTOM")) {
                        PostButtonSettingBinding postButtonSettingBinding29 = this.binding;
                        if (postButtonSettingBinding29 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding29.radioGroup.check(2131363179);
                        break;
                    }
                    break;
            }
        }
        updateCustomImage$default(this, false, 1, null);
        PostButtonSettingBinding postButtonSettingBinding30 = this.binding;
        if (postButtonSettingBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton9 = postButtonSettingBinding30.radioAppManager;
        Intrinsics.checkNotNullExpressionValue(radioButton9, "binding.radioAppManager");
        radioButton9.setButtonDrawable(createIcon());
        PostButtonSettingBinding postButtonSettingBinding31 = this.binding;
        if (postButtonSettingBinding31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton10 = postButtonSettingBinding31.radioSearch;
        Intrinsics.checkNotNullExpressionValue(radioButton10, "binding.radioSearch");
        radioButton10.setButtonDrawable(createIcon());
        PostButtonSettingBinding postButtonSettingBinding32 = this.binding;
        if (postButtonSettingBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton11 = postButtonSettingBinding32.radioNotification;
        Intrinsics.checkNotNullExpressionValue(radioButton11, "binding.radioNotification");
        radioButton11.setButtonDrawable(createIcon());
        PostButtonSettingBinding postButtonSettingBinding33 = this.binding;
        if (postButtonSettingBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton12 = postButtonSettingBinding33.radioEmpty;
        Intrinsics.checkNotNullExpressionValue(radioButton12, "binding.radioEmpty");
        radioButton12.setButtonDrawable(createIcon());
        PostButtonSettingBinding postButtonSettingBinding34 = this.binding;
        if (postButtonSettingBinding34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton13 = postButtonSettingBinding34.radioAppManager;
        Intrinsics.checkNotNullExpressionValue(radioButton13, "binding.radioAppManager");
        radioButton13.setBackground(drawable);
        PostButtonSettingBinding postButtonSettingBinding35 = this.binding;
        if (postButtonSettingBinding35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton14 = postButtonSettingBinding35.radioSearch;
        Intrinsics.checkNotNullExpressionValue(radioButton14, "binding.radioSearch");
        radioButton14.setBackground(drawable);
        PostButtonSettingBinding postButtonSettingBinding36 = this.binding;
        if (postButtonSettingBinding36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton15 = postButtonSettingBinding36.radioNotification;
        Intrinsics.checkNotNullExpressionValue(radioButton15, "binding.radioNotification");
        radioButton15.setBackground(drawable);
        PostButtonSettingBinding postButtonSettingBinding37 = this.binding;
        if (postButtonSettingBinding37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton16 = postButtonSettingBinding37.radioEmpty;
        Intrinsics.checkNotNullExpressionValue(radioButton16, "binding.radioEmpty");
        radioButton16.setBackground(drawable);
        String preferencesString2 = DataManager.getInstance().getPreferencesString("POST_BUTTON_SETTING_LONG_CLICK_KEY", "SEARCH");
        PostButtonSettingBinding postButtonSettingBinding38 = this.binding;
        if (postButtonSettingBinding38 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding38.longClickAppManager.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$6(this));
        PostButtonSettingBinding postButtonSettingBinding39 = this.binding;
        if (postButtonSettingBinding39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding39.longClickSearch.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$7(this));
        PostButtonSettingBinding postButtonSettingBinding40 = this.binding;
        if (postButtonSettingBinding40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding40.longClickNotification.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$8(this));
        PostButtonSettingBinding postButtonSettingBinding41 = this.binding;
        if (postButtonSettingBinding41 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        postButtonSettingBinding41.longClickEmpty.setOnClickListener(new PostButtonSettingFragment$onActivityCreated$9(this));
        if (preferencesString2 != null) {
            switch (preferencesString2.hashCode()) {
                case -1853007448:
                    if (preferencesString2.equals("SEARCH")) {
                        PostButtonSettingBinding postButtonSettingBinding42 = this.binding;
                        if (postButtonSettingBinding42 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding42.radioGroupLongClick.check(2131363190);
                        return;
                    }
                    return;
                case -1382453013:
                    if (preferencesString2.equals("NOTIFICATION")) {
                        PostButtonSettingBinding postButtonSettingBinding43 = this.binding;
                        if (postButtonSettingBinding43 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding43.radioGroupLongClick.check(2131363187);
                        return;
                    }
                    return;
                case 66096429:
                    if (preferencesString2.equals("EMPTY")) {
                        PostButtonSettingBinding postButtonSettingBinding44 = this.binding;
                        if (postButtonSettingBinding44 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding44.radioGroupLongClick.check(2131363180);
                        return;
                    }
                    return;
                case 1670098767:
                    if (preferencesString2.equals("APP_MANAGER")) {
                        PostButtonSettingBinding postButtonSettingBinding45 = this.binding;
                        if (postButtonSettingBinding45 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                        }
                        postButtonSettingBinding45.radioGroupLongClick.check(2131363177);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final ColorStateList createTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
    }

    private final StateListDrawable createIcon() {
        Drawable drawable = ResourceUtils.getDrawable(getActivity(), 2131231519);
        DrawableCompat.setTint(drawable, AppHolder.getAppTheme().getColorAccent());
        Drawable drawable2 = ResourceUtils.getDrawable(getActivity(), 2131231517);
        DrawableCompat.setTint(drawable2, AppHolder.getAppTheme().getColorAccent());
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, drawable);
        stateListDrawable.addState(new int[]{-16842912}, drawable2);
        stateListDrawable.addState(new int[0], drawable2);
        return stateListDrawable;
    }

    static /* synthetic */ void updateCustomImage$default(PostButtonSettingFragment postButtonSettingFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        postButtonSettingFragment.updateCustomImage(z);
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f4 A[SYNTHETIC, Splitter:B:54:0x00f4] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void updateCustomImage(boolean z) {
        FileInputStream fileInputStream;
        Throwable th;
        Exception e;
        File file = this.outputFiles;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
        }
        if (file.exists()) {
            PostButtonSettingBinding postButtonSettingBinding = this.binding;
            if (postButtonSettingBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SvgImageView svgImageView = postButtonSettingBinding.customButtonImage;
            Intrinsics.checkNotNullExpressionValue(svgImageView, "binding.customButtonImage");
            svgImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            GlideRequests with = GlideApp.with(this);
            File file2 = this.outputFiles;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
            }
            ?? load = with.load(CoolFileUtils.wrap(file2.getPath()));
            File file3 = this.outputFiles;
            if (file3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
            }
            GlideRequest signature = load.signature(new StringSignature(String.valueOf(file3.lastModified())));
            PostButtonSettingBinding postButtonSettingBinding2 = this.binding;
            if (postButtonSettingBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            signature.into(postButtonSettingBinding2.customButtonImage);
            PostButtonSettingBinding postButtonSettingBinding3 = this.binding;
            if (postButtonSettingBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView = postButtonSettingBinding3.customButtonImagePlaceholder;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.customButtonImagePlaceholder");
            imageView.setVisibility(8);
            PostButtonSettingBinding postButtonSettingBinding4 = this.binding;
            if (postButtonSettingBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SvgImageView svgImageView2 = postButtonSettingBinding4.customButtonImage;
            Intrinsics.checkNotNullExpressionValue(svgImageView2, "binding.customButtonImage");
            svgImageView2.setVisibility(0);
            if (z) {
                File file4 = this.outputFiles;
                if (file4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
                }
                if (!TextUtils.isEmpty(file4.getPath())) {
                    InputStream inputStream = null;
                    try {
                        File file5 = this.outputFiles;
                        if (file5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
                        }
                        FileInputStream fileInputStream2 = new FileInputStream(file5.getPath());
                        try {
                            byte[] bArr = new byte[fileInputStream2.available()];
                            fileInputStream2.read(bArr);
                            String encodeToString = Base64.encodeToString(bArr, 2);
                            SettingSynchronized settingSynchronized = SettingSynchronized.INSTANCE;
                            Intrinsics.checkNotNullExpressionValue(encodeToString, "result");
                            settingSynchronized.upLoadPostButton(encodeToString);
                            try {
                                fileInputStream2.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            inputStream = fileInputStream2;
                            try {
                                e.printStackTrace();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                EventBus.getDefault().post(new PostButtonEvent());
                            } catch (Throwable th2) {
                                th = th2;
                                fileInputStream = inputStream;
                                if (fileInputStream != null) {
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        if (inputStream != null) {
                        }
                        EventBus.getDefault().post(new PostButtonEvent());
                    }
                } else {
                    return;
                }
            }
        } else {
            PostButtonSettingBinding postButtonSettingBinding5 = this.binding;
            if (postButtonSettingBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SvgImageView svgImageView3 = postButtonSettingBinding5.customButtonImage;
            Intrinsics.checkNotNullExpressionValue(svgImageView3, "binding.customButtonImage");
            svgImageView3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            PostButtonSettingBinding postButtonSettingBinding6 = this.binding;
            if (postButtonSettingBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            postButtonSettingBinding6.customButtonImage.setImageDrawable(null);
            PostButtonSettingBinding postButtonSettingBinding7 = this.binding;
            if (postButtonSettingBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            SvgImageView svgImageView4 = postButtonSettingBinding7.customButtonImage;
            Intrinsics.checkNotNullExpressionValue(svgImageView4, "binding.customButtonImage");
            svgImageView4.setVisibility(8);
            PostButtonSettingBinding postButtonSettingBinding8 = this.binding;
            if (postButtonSettingBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            ImageView imageView2 = postButtonSettingBinding8.customButtonImagePlaceholder;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.customButtonImagePlaceholder");
            imageView2.setVisibility(0);
        }
        EventBus.getDefault().post(new PostButtonEvent());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 69) {
            if (i == 3925 && intent != null) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PICKED_PHOTO_PATHS");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    Toast.show$default(getActivity(), getString(2131886996), 0, false, 12, null);
                    return;
                }
                LogUtils.d("选择图片：" + CoolFileUtils.wrap(stringArrayListExtra.get(0)), new Object[0]);
                AppTheme appTheme = AppHolder.getAppTheme();
                UCrop.Options options = new UCrop.Options();
                options.setActiveWidgetColor(appTheme.getColorAccent());
                options.setStatusBarColor(appTheme.isLightColorTheme() ? appTheme.getColorPrimaryDark() : appTheme.getColorPrimary());
                options.setToolbarColor(appTheme.getColorPrimary());
                options.setToolbarWidgetColor(appTheme.getMainTextColor());
                options.setCompressionFormat(Bitmap.CompressFormat.JPEG);
                Uri fromFile = Uri.fromFile(new File(stringArrayListExtra.get(0)));
                File file = this.outputFiles;
                if (file == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("outputFiles");
                }
                UCrop.of(fromFile, Uri.fromFile(file)).withAspectRatio(1.0f, 1.0f).withMaxResultSize(184, 184).withOptions(options).start(requireActivity(), this);
            }
        } else if (i2 == -1 && intent != null) {
            updateCustomImage(true);
        }
    }
}
