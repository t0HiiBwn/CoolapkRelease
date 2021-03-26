package com.coolapk.market.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ThemePickDialogBinding;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DisplayUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.ColorPickerView;

public class ColorPickerDialog extends BaseDialogFragment {
    ThemePickDialogBinding binding;
    int initColor;
    ColorPickerView.OnColorChooseListener outerListener;

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        setCancelable(false);
        ThemePickDialogBinding themePickDialogBinding = (ThemePickDialogBinding) DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131559203, null, false);
        this.binding = themePickDialogBinding;
        themePickDialogBinding.iconView.setBackgroundTintList(ColorStateList.valueOf(this.initColor));
        this.binding.colorPickerView.setColor(this.initColor);
        this.binding.colorPickerView.setOnColorChooseListener(new ColorPickerView.OnColorChooseListener() {
            /* class com.coolapk.market.widget.ColorPickerDialog.AnonymousClass1 */

            @Override // com.coolapk.market.widget.ColorPickerView.OnColorChooseListener
            public void onColorChoose(int i) {
                ColorPickerDialog.this.onNewColor(i);
            }
        });
        this.binding.iconView.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.widget.ColorPickerDialog.AnonymousClass2 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Toast.show(ColorPickerDialog.this.getActivity(), ColorUtils.toColorString(ColorPickerDialog.this.initColor));
            }
        });
        builder.setTitle(2131886728).setView(this.binding.getRoot()).setCancelable(false);
        this.binding.okButton.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.widget.ColorPickerDialog.AnonymousClass3 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ColorPickerDialog.this.outerListener.onColorChoose(ColorPickerDialog.this.initColor);
                ColorPickerDialog.this.dismiss();
            }
        });
        this.binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.widget.ColorPickerDialog.AnonymousClass4 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ColorPickerDialog.this.dismiss();
            }
        });
        this.binding.customButton.setOnClickListener(new View.OnClickListener() {
            /* class com.coolapk.market.widget.ColorPickerDialog.AnonymousClass5 */

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EditTextDialog newInstance = EditTextDialog.newInstance();
                newInstance.setDialog(ColorPickerDialog.this);
                newInstance.show(ColorPickerDialog.this.getActivity().getSupportFragmentManager(), (String) null);
            }
        });
        return builder.create();
    }

    public void onNewColor(int i) {
        this.initColor = i;
        Drawable background = this.binding.iconView.getBackground();
        if (background != null) {
            background.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.binding.iconView.setBackground(background);
        }
    }

    public void setOuterListener(ColorPickerView.OnColorChooseListener onColorChooseListener) {
        this.outerListener = onColorChooseListener;
    }

    public void setInitColor(int i) {
        this.initColor = i;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.outerListener = null;
    }

    public static class EditTextDialog extends BaseDialogFragment {
        private ColorPickerDialog mDialog;
        private EditText mEditText;

        public static EditTextDialog newInstance() {
            Bundle bundle = new Bundle();
            EditTextDialog editTextDialog = new EditTextDialog();
            editTextDialog.setArguments(bundle);
            return editTextDialog;
        }

        public void setDialog(ColorPickerDialog colorPickerDialog) {
            this.mDialog = colorPickerDialog;
        }

        @Override // com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onStart() {
            super.onStart();
            try {
                View decorView = getDialog().getWindow().getDecorView();
                int colorAccent = AppHolder.getAppTheme().getColorAccent();
                TintHelper.setTint(this.mEditText, colorAccent, AppHolder.getAppTheme().isDarkTheme());
                this.mEditText.setHighlightColor(colorAccent);
                ((TextView) decorView.findViewById(16908313)).setTextColor(colorAccent);
                ((TextView) decorView.findViewById(16908314)).setTextColor(colorAccent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle bundle) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            this.mEditText = new EditText(getActivity());
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
            int dp2px = DisplayUtils.dp2px(getActivity(), 16.0f);
            LinearLayout linearLayout = new LinearLayout(getActivity());
            linearLayout.setLayoutParams(marginLayoutParams);
            linearLayout.setPadding(dp2px, dp2px, dp2px, dp2px);
            this.mEditText.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -2));
            linearLayout.addView(this.mEditText);
            this.mEditText.setSingleLine();
            this.mEditText.setHint("输入颜色代码 如 #4CAF50");
            builder.setTitle(2131887061).setView(linearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                /* class com.coolapk.market.widget.ColorPickerDialog.EditTextDialog.AnonymousClass1 */

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        EditTextDialog editTextDialog = EditTextDialog.this;
                        int parseStringColor = editTextDialog.parseStringColor(editTextDialog.mEditText.getText().toString());
                        if (EditTextDialog.this.mDialog != null) {
                            EditTextDialog.this.mDialog.onNewColor(parseStringColor);
                        }
                    } catch (Throwable th) {
                        Toast.error(EditTextDialog.this.getActivity(), th);
                    }
                }
            }).setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
            return builder.create();
        }

        /* access modifiers changed from: private */
        public int parseStringColor(String str) throws Throwable {
            String upperCase = str.trim().toUpperCase();
            if (upperCase.startsWith("#")) {
                upperCase = upperCase.substring(1);
            }
            if (upperCase.matches("[0-9A-F]{6,8}")) {
                String substring = upperCase.substring(upperCase.length() - 6, upperCase.length());
                return Color.parseColor("#FF" + substring);
            }
            String[] split = upperCase.split(",");
            if (split.length != 3) {
                split = upperCase.split("，");
            }
            if (split.length == 3) {
                return Color.argb(255, parseStringToInt(split[0].trim()), parseStringToInt(split[1].trim()), parseStringToInt(split[1].trim()));
            }
            throw new IllegalArgumentException("参数不正确");
        }

        private int parseStringToInt(String str) {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0 || parseInt < 256) {
                return parseInt;
            }
            throw new IllegalArgumentException("参数不正确");
        }
    }
}
