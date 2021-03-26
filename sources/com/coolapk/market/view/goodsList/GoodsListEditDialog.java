package com.coolapk.market.view.goodsList;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogGoodsListEditBinding;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.TintHelper;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseDialogFragment;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;

/* compiled from: GoodsListEditDialog.kt */
public final class GoodsListEditDialog extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_FEED_ID = "KEY_FEED_ID";
    private static final String KEY_INTRO = "KEY_INTRO";
    private static final String KEY_TITLE = "KEY_TITLE";
    private Subscription editSubscription;
    private String goodsListDescription;
    private String goodsListTitle;
    private final Lazy id$delegate = LazyKt.lazy(new GoodsListEditDialog$id$2(this));
    private EditText intro;
    private GoodsListDetailViewModel mGoodsListDetailViewModel;
    private EditText titleView;

    @Override // androidx.fragment.app.Fragment
    public final String getId() {
        return (String) this.id$delegate.getValue();
    }

    public static final /* synthetic */ GoodsListDetailViewModel access$getMGoodsListDetailViewModel$p(GoodsListEditDialog goodsListEditDialog) {
        GoodsListDetailViewModel goodsListDetailViewModel = goodsListEditDialog.mGoodsListDetailViewModel;
        if (goodsListDetailViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGoodsListDetailViewModel");
        }
        return goodsListDetailViewModel;
    }

    public final void setViewModel(GoodsListDetailViewModel goodsListDetailViewModel) {
        if (goodsListDetailViewModel != null) {
            this.mGoodsListDetailViewModel = goodsListDetailViewModel;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        super.onDismiss(dialogInterface);
        RxUtils.unsubscribe(this.editSubscription);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558528, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…s_list_edit, null, false)");
        DialogGoodsListEditBinding dialogGoodsListEditBinding = (DialogGoodsListEditBinding) inflate;
        this.titleView = dialogGoodsListEditBinding.titleEditText;
        TextView textView = dialogGoodsListEditBinding.dialogTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.dialogTitleView");
        this.intro = dialogGoodsListEditBinding.introEditText;
        TextInputLayout textInputLayout = dialogGoodsListEditBinding.titleInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout, "binding.titleInputLayout");
        textInputLayout.setHintTextColor(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        TextInputLayout textInputLayout2 = dialogGoodsListEditBinding.introInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout2, "binding.introInputLayout");
        textInputLayout2.setHintTextColor(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        TextView textView2 = dialogGoodsListEditBinding.dialogConfirm;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.dialogConfirm");
        TextView textView3 = dialogGoodsListEditBinding.dialogCancel;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.dialogCancel");
        if (!TextUtils.isEmpty(getId())) {
            GoodsListDetailViewModel goodsListDetailViewModel = this.mGoodsListDetailViewModel;
            if (goodsListDetailViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGoodsListDetailViewModel");
            }
            this.goodsListTitle = goodsListDetailViewModel.getGoodsShowTitle();
            GoodsListDetailViewModel goodsListDetailViewModel2 = this.mGoodsListDetailViewModel;
            if (goodsListDetailViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGoodsListDetailViewModel");
            }
            this.goodsListDescription = goodsListDetailViewModel2.getGoodsShowMessage();
            textView.setText("编辑好物单描述");
            EditText editText = this.titleView;
            Intrinsics.checkNotNull(editText);
            editText.setText(this.goodsListTitle);
            EditText editText2 = this.intro;
            Intrinsics.checkNotNull(editText2);
            editText2.setText(this.goodsListDescription);
            if (!TextUtils.isEmpty(this.goodsListTitle) && !TextUtils.isEmpty(this.goodsListDescription)) {
                EditText editText3 = this.titleView;
                Intrinsics.checkNotNull(editText3);
                String str = this.goodsListTitle;
                Intrinsics.checkNotNull(str);
                editText3.setSelection(str.length());
                EditText editText4 = this.intro;
                Intrinsics.checkNotNull(editText4);
                String str2 = this.goodsListDescription;
                Intrinsics.checkNotNull(str2);
                editText4.setSelection(str2.length());
            }
        }
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        textView2.setTextColor(colorAccent);
        textView3.setTextColor(colorAccent);
        TextInputLayout textInputLayout3 = dialogGoodsListEditBinding.introInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout3, "binding.introInputLayout");
        EditText editText5 = textInputLayout3.getEditText();
        TextInputLayout textInputLayout4 = dialogGoodsListEditBinding.titleInputLayout;
        Intrinsics.checkNotNullExpressionValue(textInputLayout4, "binding.titleInputLayout");
        EditText editText6 = textInputLayout4.getEditText();
        Intrinsics.checkNotNull(editText5);
        TintHelper.setCursorTint(editText5, colorAccent);
        Intrinsics.checkNotNull(editText6);
        TintHelper.setCursorTint(editText6, colorAccent);
        ViewUtil.clickListener(textView2, new GoodsListEditDialog$onCreateDialog$1(this));
        ViewUtil.clickListener(textView3, new GoodsListEditDialog$onCreateDialog$2(this));
        AlertDialog create = new AlertDialog.Builder(requireActivity()).setView(dialogGoodsListEditBinding.getRoot()).setCancelable(true).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        return create;
    }

    /* compiled from: GoodsListEditDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GoodsListEditDialog newInstance(String str, String str2, String str3) {
            Bundle bundle = new Bundle();
            bundle.putString("KEY_FEED_ID", str);
            bundle.putString("KEY_TITLE", str2);
            bundle.putString("KEY_INTRO", str3);
            GoodsListEditDialog goodsListEditDialog = new GoodsListEditDialog();
            goodsListEditDialog.setArguments(bundle);
            return goodsListEditDialog;
        }
    }
}
