package com.coolapk.market.view.theme;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.AppTheme;
import com.coolapk.market.databinding.CustomThemeBinding;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.ColorPickerDialog;
import com.coolapk.market.widget.ColorPickerView;
import com.coolapk.market.widget.Toast;
import rx.functions.Action4;

public class CustomThemeFragment extends BaseDialogFragment {
    private AppTheme appTheme;
    private CustomThemeBinding binding;
    private int colorAccent;
    private int colorPrimary;
    private boolean darkMode;
    private Action4<Integer, Integer, Boolean, View> resultListener;

    @Override // com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public void setInitValue(Integer num, Integer num2, boolean z) {
        this.colorAccent = num2.intValue();
        this.colorPrimary = num.intValue();
        this.darkMode = z;
    }

    public void setResultListener(Action4<Integer, Integer, Boolean, View> action4) {
        this.resultListener = action4;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        CustomThemeBinding customThemeBinding = (CustomThemeBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558496, null, false);
        this.binding = customThemeBinding;
        builder.setView(customThemeBinding.getRoot());
        builder.setCancelable(false);
        this.appTheme = AppHolder.getAppTheme();
        TintHelper.setTint(this.binding.checkBox1, this.appTheme.getColorAccent(), this.appTheme.isDarkTheme());
        TintHelper.setTint(this.binding.checkBox2, this.appTheme.getColorAccent(), this.appTheme.isDarkTheme());
        if (this.darkMode) {
            this.binding.checkBox1.setChecked(true);
        } else {
            this.binding.checkBox2.setChecked(true);
        }
        this.binding.checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass1 */

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (CustomThemeFragment.this.binding.checkBox2.isChecked() == z) {
                    CustomThemeFragment.this.binding.checkBox2.setChecked(!z);
                }
                CustomThemeFragment.this.darkMode = true;
            }
        });
        this.binding.checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass2 */

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (CustomThemeFragment.this.binding.checkBox1.isChecked() == z) {
                    CustomThemeFragment.this.binding.checkBox1.setChecked(!z);
                }
                CustomThemeFragment.this.darkMode = false;
            }
        });
        this.binding.actionCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomThemeFragment.this.dismiss();
            }
        });
        this.binding.actionNext.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomThemeFragment.this.dismiss();
                CustomThemeFragment.this.resultListener.call(Integer.valueOf(CustomThemeFragment.this.colorPrimary), Integer.valueOf(CustomThemeFragment.this.colorAccent), Boolean.valueOf(CustomThemeFragment.this.darkMode), view);
            }
        });
        UiUtils.tintBackground(this.binding.colorView1, this.colorPrimary);
        this.binding.colorView1.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass5 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
                colorPickerDialog.setInitColor(CustomThemeFragment.this.colorPrimary);
                colorPickerDialog.setOuterListener(new ColorPickerView.OnColorChooseListener() {
                    /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass5.AnonymousClass1 */

                    @Override // com.coolapk.market.widget.ColorPickerView.OnColorChooseListener
                    public void onColorChoose(int i) {
                        CustomThemeFragment.this.colorPrimary = i;
                        UiUtils.tintBackground(CustomThemeFragment.this.binding.colorView1, i);
                    }
                });
                colorPickerDialog.show(CustomThemeFragment.this.getChildFragmentManager(), (String) null);
            }
        });
        this.binding.colorView1.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass6 */

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                Toast.show(CustomThemeFragment.this.getActivity(), ColorUtils.toColorString(CustomThemeFragment.this.colorPrimary));
                return true;
            }
        });
        UiUtils.tintBackground(this.binding.colorView2, this.colorAccent);
        this.binding.colorView2.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass7 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ColorPickerDialog colorPickerDialog = new ColorPickerDialog();
                colorPickerDialog.setInitColor(CustomThemeFragment.this.colorAccent);
                colorPickerDialog.setOuterListener(new ColorPickerView.OnColorChooseListener() {
                    /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass7.AnonymousClass1 */

                    @Override // com.coolapk.market.widget.ColorPickerView.OnColorChooseListener
                    public void onColorChoose(int i) {
                        CustomThemeFragment.this.colorAccent = i;
                        UiUtils.tintBackground(CustomThemeFragment.this.binding.colorView2, i);
                    }
                });
                colorPickerDialog.show(CustomThemeFragment.this.getChildFragmentManager(), (String) null);
            }
        });
        this.binding.colorView2.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.coolapk.market.view.theme.CustomThemeFragment.AnonymousClass8 */

            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                Toast.show(CustomThemeFragment.this.getActivity(), ColorUtils.toColorString(CustomThemeFragment.this.colorAccent));
                return true;
            }
        });
        return builder.create();
    }
}
