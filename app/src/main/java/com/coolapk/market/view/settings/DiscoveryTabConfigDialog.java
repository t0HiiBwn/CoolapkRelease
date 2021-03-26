package com.coolapk.market.view.settings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.databinding.LayoutTabConfigBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0002¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/settings/DiscoveryTabConfigDialog;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "putString", "", "value", "", "showTabTitleToast", "view", "Landroid/view/View;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DiscoveryTabConfigDialog.kt */
public final class DiscoveryTabConfigDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final DiscoveryTabConfigDialog newInstance() {
        return Companion.newInstance();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/settings/DiscoveryTabConfigDialog$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/settings/DiscoveryTabConfigDialog;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DiscoveryTabConfigDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final DiscoveryTabConfigDialog newInstance() {
            Bundle bundle = new Bundle();
            DiscoveryTabConfigDialog discoveryTabConfigDialog = new DiscoveryTabConfigDialog();
            discoveryTabConfigDialog.setArguments(bundle);
            return discoveryTabConfigDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        LayoutTabConfigBinding layoutTabConfigBinding = (LayoutTabConfigBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559003, null, false);
        TextView textView = layoutTabConfigBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText("默认发现页");
        RadioButton radioButton = layoutTabConfigBinding.radioTh;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.radioTh");
        radioButton.setText("二手");
        RadioButton radioButton2 = layoutTabConfigBinding.radioFo;
        Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.radioFo");
        radioButton2.setText("酷品");
        RadioButton radioButton3 = layoutTabConfigBinding.radioFi;
        Intrinsics.checkNotNullExpressionValue(radioButton3, "binding.radioFi");
        radioButton3.setText("酷图");
        RadioButton radioButton4 = layoutTabConfigBinding.radioSe;
        Intrinsics.checkNotNullExpressionValue(radioButton4, "binding.radioSe");
        radioButton4.setText("好物");
        RadioButton radioButton5 = layoutTabConfigBinding.radioFiv;
        Intrinsics.checkNotNullExpressionValue(radioButton5, "binding.radioFiv");
        radioButton5.setText("看看号");
        layoutTabConfigBinding.radioFi.setOnClickListener(new DiscoveryTabConfigDialog$onCreateDialog$1(this, layoutTabConfigBinding));
        layoutTabConfigBinding.radioSe.setOnClickListener(new DiscoveryTabConfigDialog$onCreateDialog$2(this, layoutTabConfigBinding));
        layoutTabConfigBinding.radioTh.setOnClickListener(new DiscoveryTabConfigDialog$onCreateDialog$3(this, layoutTabConfigBinding));
        layoutTabConfigBinding.radioFo.setOnClickListener(new DiscoveryTabConfigDialog$onCreateDialog$4(this, layoutTabConfigBinding));
        layoutTabConfigBinding.radioFiv.setOnClickListener(new DiscoveryTabConfigDialog$onCreateDialog$5(this, layoutTabConfigBinding));
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "V11_FIND_GOOD_GOODS_HOME";
        layoutTabConfigBinding.radioGroup.setOnCheckedChangeListener(new DiscoveryTabConfigDialog$onCreateDialog$6(this, objectRef));
        String preferencesString = DataManager.getInstance().getPreferencesString("default_tab_config", "V11_FIND_GOOD_GOODS_HOME");
        if (preferencesString != null) {
            switch (preferencesString.hashCode()) {
                case -1359284199:
                    if (preferencesString.equals("V11_FIND_GOODS")) {
                        layoutTabConfigBinding.radioGroup.check(2131363169);
                        break;
                    }
                    break;
                case -556840286:
                    if (preferencesString.equals("V11_DISCOVERY_SECOND_HAND")) {
                        layoutTabConfigBinding.radioGroup.check(2131363178);
                        break;
                    }
                    break;
                case -484098058:
                    if (preferencesString.equals("V11_FIND_DYH")) {
                        layoutTabConfigBinding.radioGroup.check(2131363168);
                        break;
                    }
                    break;
                case 13821485:
                    if (preferencesString.equals("V11_FIND_GOOD_GOODS_HOME")) {
                        layoutTabConfigBinding.radioGroup.check(2131363175);
                        break;
                    }
                    break;
                case 143133092:
                    if (preferencesString.equals("V11_FIND_COOLPIC")) {
                        layoutTabConfigBinding.radioGroup.check(2131363167);
                        break;
                    }
                    break;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        Intrinsics.checkNotNullExpressionValue(layoutTabConfigBinding, "binding");
        AlertDialog create = builder.setView(layoutTabConfigBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        return create;
    }

    /* access modifiers changed from: private */
    public final void showTabTitleToast(View view) {
        if (view instanceof TextView) {
            String obj = ((TextView) view).getText().toString();
            FragmentActivity activity = getActivity();
            Toast.show$default(activity, "已将" + obj + "设为默认发现页", 0, true, 4, null);
        }
    }

    /* access modifiers changed from: private */
    public final void putString(String str) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("default_tab_config", str).apply();
    }
}
