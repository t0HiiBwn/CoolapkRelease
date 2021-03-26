package com.coolapk.market.view.sencondhand;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogSecondHandPriceBinding;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.coolapk.market.widget.Toast;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0017J\u0014\u0010\u0018\u001a\u00020\u00112\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J \u0010\u0019\u001a\u00020\u00112\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/coolapk/market/view/sencondhand/EditSecondHandPriceDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/coolapk/market/databinding/DialogSecondHandPriceBinding;", "cancelListener", "Lrx/functions/Action1;", "", "listener", "Lkotlin/Pair;", "", "", "priceType", "getFocusedEditText", "Landroid/widget/EditText;", "onClick", "", "v", "Landroid/view/View;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setCancelListener", "setListener", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EditSecondHandPriceDialogFragment.kt */
public final class EditSecondHandPriceDialogFragment extends BaseDialogFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String EXTRA_CONTENT = "extra_content";
    public static final String EXTRA_RISE_PRICE_TYPE = "extra_rise_price_type";
    public static final String EXTRA_TITLE = "extra_TITLE";
    public static final String EXTRA_TYPE = "extra_type";
    private DialogSecondHandPriceBinding binding;
    private Action1<Boolean> cancelListener;
    private Action1<Pair<Integer, String>> listener;
    private int priceType;

    public static final /* synthetic */ DialogSecondHandPriceBinding access$getBinding$p(EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment) {
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding = editSecondHandPriceDialogFragment.binding;
        if (dialogSecondHandPriceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return dialogSecondHandPriceBinding;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/sencondhand/EditSecondHandPriceDialogFragment$Companion;", "", "()V", "EXTRA_CONTENT", "", "EXTRA_RISE_PRICE_TYPE", "EXTRA_TITLE", "EXTRA_TYPE", "newInstance", "Lcom/coolapk/market/view/sencondhand/EditSecondHandPriceDialogFragment;", "title", "content", "type", "", "risePriceType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: EditSecondHandPriceDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EditSecondHandPriceDialogFragment newInstance(String str, String str2, int i, int i2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "content");
            EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment = new EditSecondHandPriceDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_TITLE", str);
            bundle.putString("extra_content", str2);
            bundle.putInt("extra_rise_price_type", i2);
            bundle.putInt("extra_type", i);
            Unit unit = Unit.INSTANCE;
            editSecondHandPriceDialogFragment.setArguments(bundle);
            return editSecondHandPriceDialogFragment;
        }
    }

    public final void setListener(Action1<Pair<Integer, String>> action1) {
        Intrinsics.checkNotNullParameter(action1, "listener");
        this.listener = action1;
    }

    public final void setCancelListener(Action1<Boolean> action1) {
        Intrinsics.checkNotNullParameter(action1, "listener");
        this.cancelListener = action1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        String string = requireArguments().getString("extra_TITLE");
        int i = requireArguments().getInt("extra_type");
        String string2 = requireArguments().getString("extra_content");
        int i2 = requireArguments().getInt("extra_rise_price_type");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558534, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…_hand_price, null, false)");
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding = (DialogSecondHandPriceBinding) inflate;
        this.binding = dialogSecondHandPriceBinding;
        if (dialogSecondHandPriceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditSecondHandPriceDialogFragment editSecondHandPriceDialogFragment = this;
        dialogSecondHandPriceBinding.cacelView.setOnClickListener(editSecondHandPriceDialogFragment);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding2 = this.binding;
        if (dialogSecondHandPriceBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding2.submitView.setOnClickListener(editSecondHandPriceDialogFragment);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding3 = this.binding;
        if (dialogSecondHandPriceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = dialogSecondHandPriceBinding3.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.setHint(i == 1 ? "输入收购价格" : "输入出售价格");
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding4 = this.binding;
        if (dialogSecondHandPriceBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        RadioButton radioButton = dialogSecondHandPriceBinding4.normalPriceBtn;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.normalPriceBtn");
        radioButton.setText(i == 1 ? "出价" : "定价");
        this.priceType = i2;
        if (i == 0 || i == 1) {
            String str = string2;
            if (!TextUtils.isEmpty(str) && i2 == 0) {
                DialogSecondHandPriceBinding dialogSecondHandPriceBinding5 = this.binding;
                if (dialogSecondHandPriceBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                dialogSecondHandPriceBinding5.editText.setText(str);
                DialogSecondHandPriceBinding dialogSecondHandPriceBinding6 = this.binding;
                if (dialogSecondHandPriceBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                RadioButton radioButton2 = dialogSecondHandPriceBinding6.normalPriceBtn;
                Intrinsics.checkNotNullExpressionValue(radioButton2, "binding.normalPriceBtn");
                radioButton2.setChecked(true);
            }
            if (this.priceType == 3) {
                DialogSecondHandPriceBinding dialogSecondHandPriceBinding7 = this.binding;
                if (dialogSecondHandPriceBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                RadioButton radioButton3 = dialogSecondHandPriceBinding7.dealTypeBtn;
                Intrinsics.checkNotNullExpressionValue(radioButton3, "binding.dealTypeBtn");
                radioButton3.setChecked(true);
            }
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding8 = this.binding;
            if (dialogSecondHandPriceBinding8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout = dialogSecondHandPriceBinding8.normalPriceView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.normalPriceView");
            linearLayout.setVisibility(0);
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding9 = this.binding;
            if (dialogSecondHandPriceBinding9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout2 = dialogSecondHandPriceBinding9.moneyMeLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.moneyMeLayout");
            linearLayout2.setVisibility(8);
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding10 = this.binding;
            if (dialogSecondHandPriceBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout3 = dialogSecondHandPriceBinding10.moneyYouLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout3, "binding.moneyYouLayout");
            linearLayout3.setVisibility(8);
        } else {
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding11 = this.binding;
            if (dialogSecondHandPriceBinding11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText2 = dialogSecondHandPriceBinding11.moneyMe;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.moneyMe");
            editText2.setHint("卖家补多少差价");
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding12 = this.binding;
            if (dialogSecondHandPriceBinding12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText3 = dialogSecondHandPriceBinding12.moneyYou;
            Intrinsics.checkNotNullExpressionValue(editText3, "binding.moneyYou");
            editText3.setHint("买家补多少差价");
            String str2 = string2;
            if (!TextUtils.isEmpty(str2)) {
                if (i2 == 1) {
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding13 = this.binding;
                    if (dialogSecondHandPriceBinding13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    dialogSecondHandPriceBinding13.moneyMe.setText(str2);
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding14 = this.binding;
                    if (dialogSecondHandPriceBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    RadioButton radioButton4 = dialogSecondHandPriceBinding14.moneyMeBtn;
                    Intrinsics.checkNotNullExpressionValue(radioButton4, "binding.moneyMeBtn");
                    radioButton4.setChecked(true);
                } else if (i2 != 2) {
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding15 = this.binding;
                    if (dialogSecondHandPriceBinding15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    RadioButton radioButton5 = dialogSecondHandPriceBinding15.dealTypeBtn;
                    Intrinsics.checkNotNullExpressionValue(radioButton5, "binding.dealTypeBtn");
                    radioButton5.setChecked(true);
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding16 = this.binding;
                    if (dialogSecondHandPriceBinding16 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    RadioButton radioButton6 = dialogSecondHandPriceBinding16.moneyMeBtn;
                    Intrinsics.checkNotNullExpressionValue(radioButton6, "binding.moneyMeBtn");
                    radioButton6.setChecked(false);
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding17 = this.binding;
                    if (dialogSecondHandPriceBinding17 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    RadioButton radioButton7 = dialogSecondHandPriceBinding17.moneyYouBtn;
                    Intrinsics.checkNotNullExpressionValue(radioButton7, "binding.moneyYouBtn");
                    radioButton7.setChecked(false);
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding18 = this.binding;
                    if (dialogSecondHandPriceBinding18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    dialogSecondHandPriceBinding18.moneyYou.setText("");
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding19 = this.binding;
                    if (dialogSecondHandPriceBinding19 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    dialogSecondHandPriceBinding19.moneyMe.setText("");
                } else {
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding20 = this.binding;
                    if (dialogSecondHandPriceBinding20 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    dialogSecondHandPriceBinding20.moneyYou.setText(str2);
                    DialogSecondHandPriceBinding dialogSecondHandPriceBinding21 = this.binding;
                    if (dialogSecondHandPriceBinding21 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                    }
                    RadioButton radioButton8 = dialogSecondHandPriceBinding21.moneyYouBtn;
                    Intrinsics.checkNotNullExpressionValue(radioButton8, "binding.moneyYouBtn");
                    radioButton8.setChecked(true);
                }
            }
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding22 = this.binding;
            if (dialogSecondHandPriceBinding22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout4 = dialogSecondHandPriceBinding22.normalPriceView;
            Intrinsics.checkNotNullExpressionValue(linearLayout4, "binding.normalPriceView");
            linearLayout4.setVisibility(8);
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding23 = this.binding;
            if (dialogSecondHandPriceBinding23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout5 = dialogSecondHandPriceBinding23.moneyMeLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout5, "binding.moneyMeLayout");
            linearLayout5.setVisibility(0);
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding24 = this.binding;
            if (dialogSecondHandPriceBinding24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            LinearLayout linearLayout6 = dialogSecondHandPriceBinding24.moneyYouLayout;
            Intrinsics.checkNotNullExpressionValue(linearLayout6, "binding.moneyYouLayout");
            linearLayout6.setVisibility(0);
        }
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding25 = this.binding;
        if (dialogSecondHandPriceBinding25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText4 = dialogSecondHandPriceBinding25.editText;
        Intrinsics.checkNotNullExpressionValue(editText4, "binding.editText");
        editText4.setInputType(8194);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding26 = this.binding;
        if (dialogSecondHandPriceBinding26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText5 = dialogSecondHandPriceBinding26.moneyYou;
        Intrinsics.checkNotNullExpressionValue(editText5, "binding.moneyYou");
        editText5.setInputType(8194);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding27 = this.binding;
        if (dialogSecondHandPriceBinding27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText6 = dialogSecondHandPriceBinding27.moneyMe;
        Intrinsics.checkNotNullExpressionValue(editText6, "binding.moneyMe");
        editText6.setInputType(8194);
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        boolean isDarkTheme = AppHolder.getAppTheme().isDarkTheme();
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding28 = this.binding;
        if (dialogSecondHandPriceBinding28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(dialogSecondHandPriceBinding28.moneyYouBtn, colorAccent, isDarkTheme);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding29 = this.binding;
        if (dialogSecondHandPriceBinding29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(dialogSecondHandPriceBinding29.moneyMeBtn, colorAccent, isDarkTheme);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding30 = this.binding;
        if (dialogSecondHandPriceBinding30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(dialogSecondHandPriceBinding30.dealTypeBtn, colorAccent, isDarkTheme);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding31 = this.binding;
        if (dialogSecondHandPriceBinding31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TintHelper.setTint(dialogSecondHandPriceBinding31.normalPriceBtn, colorAccent, isDarkTheme);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding32 = this.binding;
        if (dialogSecondHandPriceBinding32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding32.moneyMe.setOnFocusChangeListener(EditSecondHandPriceDialogFragment$onCreateDialog$1.INSTANCE);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding33 = this.binding;
        if (dialogSecondHandPriceBinding33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding33.moneyYou.setOnFocusChangeListener(EditSecondHandPriceDialogFragment$onCreateDialog$2.INSTANCE);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding34 = this.binding;
        if (dialogSecondHandPriceBinding34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding34.editText.setOnFocusChangeListener(new EditSecondHandPriceDialogFragment$onCreateDialog$3(this));
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding35 = this.binding;
        if (dialogSecondHandPriceBinding35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding35.dealTypeBtn.setOnCheckedChangeListener(new EditSecondHandPriceDialogFragment$onCreateDialog$4(this, i));
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding36 = this.binding;
        if (dialogSecondHandPriceBinding36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding36.moneyMeBtn.setOnCheckedChangeListener(new EditSecondHandPriceDialogFragment$onCreateDialog$5(this));
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding37 = this.binding;
        if (dialogSecondHandPriceBinding37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding37.moneyMe.setOnTouchListener(new EditSecondHandPriceDialogFragment$onCreateDialog$6(this));
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding38 = this.binding;
        if (dialogSecondHandPriceBinding38 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding38.moneyYou.setOnTouchListener(new EditSecondHandPriceDialogFragment$onCreateDialog$7(this));
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding39 = this.binding;
        if (dialogSecondHandPriceBinding39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding39.editText.setOnTouchListener(new EditSecondHandPriceDialogFragment$onCreateDialog$8(this));
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding40 = this.binding;
        if (dialogSecondHandPriceBinding40 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding40.moneyYouBtn.setOnCheckedChangeListener(new EditSecondHandPriceDialogFragment$onCreateDialog$9(this));
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding41 = this.binding;
        if (dialogSecondHandPriceBinding41 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        dialogSecondHandPriceBinding41.normalPriceBtn.setOnCheckedChangeListener(new EditSecondHandPriceDialogFragment$onCreateDialog$10(this));
        AlertDialog.Builder title = new AlertDialog.Builder(requireActivity()).setTitle(string);
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding42 = this.binding;
        if (dialogSecondHandPriceBinding42 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = title.setView(dialogSecondHandPriceBinding42.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "androidx.appcompat.app.A…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    /* access modifiers changed from: private */
    public final EditText getFocusedEditText() {
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding = this.binding;
        if (dialogSecondHandPriceBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = dialogSecondHandPriceBinding.moneyMe;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.moneyMe");
        if (editText.isFocused()) {
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding2 = this.binding;
            if (dialogSecondHandPriceBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText2 = dialogSecondHandPriceBinding2.moneyMe;
            Intrinsics.checkNotNullExpressionValue(editText2, "binding.moneyMe");
            return editText2;
        }
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding3 = this.binding;
        if (dialogSecondHandPriceBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText3 = dialogSecondHandPriceBinding3.moneyYou;
        Intrinsics.checkNotNullExpressionValue(editText3, "binding.moneyYou");
        if (editText3.isFocused()) {
            DialogSecondHandPriceBinding dialogSecondHandPriceBinding4 = this.binding;
            if (dialogSecondHandPriceBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            }
            EditText editText4 = dialogSecondHandPriceBinding4.moneyYou;
            Intrinsics.checkNotNullExpressionValue(editText4, "binding.moneyYou");
            return editText4;
        }
        DialogSecondHandPriceBinding dialogSecondHandPriceBinding5 = this.binding;
        if (dialogSecondHandPriceBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText5 = dialogSecondHandPriceBinding5.editText;
        Intrinsics.checkNotNullExpressionValue(editText5, "binding.editText");
        return editText5;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id == 2131362193) {
            UiUtils.closeKeyboard(getFocusedEditText());
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.dismiss();
            }
            Action1<Boolean> action1 = this.cancelListener;
            if (action1 != null && action1 != null) {
                action1.call(false);
            }
        } else if (id == 2131363457 && this.listener != null) {
            UiUtils.closeKeyboard(getFocusedEditText());
            int i = this.priceType;
            if (i == 1) {
                DialogSecondHandPriceBinding dialogSecondHandPriceBinding = this.binding;
                if (dialogSecondHandPriceBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                EditText editText = dialogSecondHandPriceBinding.moneyMe;
                Intrinsics.checkNotNullExpressionValue(editText, "binding.moneyMe");
                str = editText.getText().toString();
            } else if (i == 2) {
                DialogSecondHandPriceBinding dialogSecondHandPriceBinding2 = this.binding;
                if (dialogSecondHandPriceBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                EditText editText2 = dialogSecondHandPriceBinding2.moneyYou;
                Intrinsics.checkNotNullExpressionValue(editText2, "binding.moneyYou");
                str = editText2.getText().toString();
            } else if (i != 3) {
                DialogSecondHandPriceBinding dialogSecondHandPriceBinding3 = this.binding;
                if (dialogSecondHandPriceBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                }
                EditText editText3 = dialogSecondHandPriceBinding3.editText;
                Intrinsics.checkNotNullExpressionValue(editText3, "binding.editText");
                str = editText3.getText().toString();
            } else {
                str = "价格面议";
            }
            if (TextUtils.isEmpty(str)) {
                Toast.show$default(getActivity(), "您还没有输入内容", 0, false, 12, null);
                return;
            }
            Action1<Pair<Integer, String>> action12 = this.listener;
            if (action12 != null) {
                action12.call(new Pair<>(Integer.valueOf(this.priceType), str));
            }
        }
    }
}
