package com.coolapk.market.view.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.databinding.LayoutImageModeBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.BaseDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/settings/ImageModeDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ImageModeDialog.kt */
public final class ImageModeDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final ImageModeDialog newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/settings/ImageModeDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/ImageModeDialog;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ImageModeDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final ImageModeDialog newInstance() {
            Bundle bundle = new Bundle();
            ImageModeDialog imageModeDialog = new ImageModeDialog();
            imageModeDialog.setArguments(bundle);
            return imageModeDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        LayoutImageModeBinding layoutImageModeBinding = (LayoutImageModeBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558996, null, false);
        TextView textView = layoutImageModeBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText("图片浏览设置");
        layoutImageModeBinding.radioFi.setOnClickListener(new ImageModeDialog$onCreateDialog$1(this, layoutImageModeBinding));
        RadioButton radioButton = layoutImageModeBinding.radioTh;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioTh");
        radioButton.setText("普清");
        RadioButton radioButton2 = layoutImageModeBinding.radioSe;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.radioSe");
        radioButton2.setText("原图");
        RadioButton radioButton3 = layoutImageModeBinding.radioFi;
        Intrinsics.checkNotNullExpressionValue(radioButton3, "binding.radioFi");
        radioButton3.setText("网络自适应");
        layoutImageModeBinding.radioSe.setOnClickListener(new ImageModeDialog$onCreateDialog$2(this, layoutImageModeBinding));
        layoutImageModeBinding.radioTh.setOnClickListener(new ImageModeDialog$onCreateDialog$3(this, layoutImageModeBinding));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "AUTO";
        layoutImageModeBinding.radioGroup.setOnCheckedChangeListener(new ImageModeDialog$onCreateDialog$4(objectRef));
        String preferencesString = DataManager.getInstance().getPreferencesString("photo_view_options", "AUTO");
        if (preferencesString != null) {
            int hashCode = preferencesString.hashCode();
            if (hashCode != -1986416409) {
                if (hashCode != -1843176421) {
                    if (hashCode == 2020783 && preferencesString.equals("AUTO")) {
                        layoutImageModeBinding.radioGroup.check(2131363167);
                    }
                } else if (preferencesString.equals("SOURCE")) {
                    layoutImageModeBinding.radioGroup.check(2131363175);
                }
            } else if (preferencesString.equals("NORMAL")) {
                layoutImageModeBinding.radioGroup.check(2131363178);
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Intrinsics.checkNotNullExpressionValue(layoutImageModeBinding, "binding");
        AlertDialog create = builder.setView(layoutImageModeBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        return create;
    }
}
