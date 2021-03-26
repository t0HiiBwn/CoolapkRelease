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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: DiscoveryTabConfigDialog.kt */
public final class DiscoveryTabConfigDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);

    public static final DiscoveryTabConfigDialog newInstance() {
        return Companion.newInstance();
    }

    /* compiled from: DiscoveryTabConfigDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DiscoveryTabConfigDialog newInstance() {
            Bundle bundle = new Bundle();
            DiscoveryTabConfigDialog discoveryTabConfigDialog = new DiscoveryTabConfigDialog();
            discoveryTabConfigDialog.setArguments(bundle);
            return discoveryTabConfigDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        LayoutTabConfigBinding layoutTabConfigBinding = (LayoutTabConfigBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559010, null, false);
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
                        layoutTabConfigBinding.radioGroup.check(2131363183);
                        break;
                    }
                    break;
                case -556840286:
                    if (preferencesString.equals("V11_DISCOVERY_SECOND_HAND")) {
                        layoutTabConfigBinding.radioGroup.check(2131363192);
                        break;
                    }
                    break;
                case -484098058:
                    if (preferencesString.equals("V11_FIND_DYH")) {
                        layoutTabConfigBinding.radioGroup.check(2131363182);
                        break;
                    }
                    break;
                case 13821485:
                    if (preferencesString.equals("V11_FIND_GOOD_GOODS_HOME")) {
                        layoutTabConfigBinding.radioGroup.check(2131363189);
                        break;
                    }
                    break;
                case 143133092:
                    if (preferencesString.equals("V11_FIND_COOLPIC")) {
                        layoutTabConfigBinding.radioGroup.check(2131363181);
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

    public final void showTabTitleToast(View view) {
        if (view instanceof TextView) {
            String obj = ((TextView) view).getText().toString();
            FragmentActivity activity = getActivity();
            Toast.show$default(activity, "已将" + obj + "设为默认发现页", 0, true, 4, null);
        }
    }

    public final void putString(String str) {
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        instance.getPreferencesEditor().putString("default_tab_config", str).apply();
    }
}
