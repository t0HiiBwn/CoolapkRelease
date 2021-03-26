package com.coolapk.market.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.SizeUtils;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogListItemViewBinding;
import com.coolapk.market.databinding.DialogSelectItemBinding;
import com.coolapk.market.databinding.DialogSeletorContainerBinding;
import com.coolapk.market.databinding.SubmitFeedAddMoreItemDialogBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.view.user.UserProfileFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003%&'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bJ2\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u0012J0\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0012JF\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00050\u00122\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000fJ,\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004JB\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u0012J \u0010\u001f\u001a\u00020 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u000f2\b\b\u0002\u0010\"\u001a\u00020\u000bJ\f\u0010#\u001a\u00020\u0005*\u00020$H\u0002¨\u0006("}, d2 = {"Lcom/coolapk/market/util/DialogUtil;", "", "()V", "showBottomSheetDialog", "Lkotlin/Function0;", "", "activity", "Landroid/app/Activity;", "view", "Landroid/view/View;", "drawSystemBar", "", "removeDefaultBg", "showBottomSheetEditDialog", "content", "", "hint", "onDone", "Lkotlin/Function1;", "showBottomSheetListDialog", "itemData", "", "Lcom/coolapk/market/util/DialogUtil$DialogItemData;", "onItemCheck", "showCenterEditTextDialog", "title", "onClick", "subTitle", "showConfigDialog", "showItemSelectDialog", "showConfirm", "showProgressDialog", "Landroid/app/Dialog;", "message", "cancelable", "hackItsWindowsToDrawSystemBar", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "DialogItemData", "ListItemViewHolder", "SelectItemViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DialogUtil.kt */
public final class DialogUtil {
    public static final DialogUtil INSTANCE = new DialogUtil();

    private DialogUtil() {
    }

    public final void showConfigDialog(Activity activity, String str, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        ConfirmDialog newInstance = ConfirmDialog.newInstance(str, str2);
        newInstance.setOnOkRunnable(new DialogUtil$showConfigDialog$1(function0));
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    public static /* synthetic */ Dialog showProgressDialog$default(DialogUtil dialogUtil, Activity activity, String str, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return dialogUtil.showProgressDialog(activity, str, z);
    }

    public final Dialog showProgressDialog(Activity activity, String str, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "message");
        ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setCancelable(z);
        progressDialog.setProgressStyle(0);
        progressDialog.setCanceledOnTouchOutside(z);
        progressDialog.setMessage(str);
        try {
            progressDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progressDialog;
    }

    public static /* synthetic */ void showCenterEditTextDialog$default(DialogUtil dialogUtil, Activity activity, String str, String str2, String str3, Function1 function1, String str4, int i, Object obj) {
        if ((i & 32) != 0) {
            str4 = null;
        }
        dialogUtil.showCenterEditTextDialog(activity, str, str2, str3, function1, str4);
    }

    public final void showCenterEditTextDialog(Activity activity, String str, String str2, String str3, Function1<? super String, Unit> function1, String str4) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "hint");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        Activity activity2 = activity;
        int i = 0;
        SubmitFeedAddMoreItemDialogBinding submitFeedAddMoreItemDialogBinding = (SubmitFeedAddMoreItemDialogBinding) DataBindingUtil.inflate(LayoutInflater.from(activity2), 2131559147, null, false);
        AlertDialog.Builder title = new AlertDialog.Builder(activity2).setTitle(str);
        Intrinsics.checkNotNullExpressionValue(submitFeedAddMoreItemDialogBinding, "binding");
        AlertDialog create = title.setView(submitFeedAddMoreItemDialogBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        submitFeedAddMoreItemDialogBinding.editText.setText(str2);
        EditText editText = submitFeedAddMoreItemDialogBinding.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.setHint(str3);
        TextView textView = submitFeedAddMoreItemDialogBinding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subTitleView");
        TextView textView2 = textView;
        String str5 = str4;
        if (str5 == null || str5.length() == 0) {
            i = 8;
        }
        textView2.setVisibility(i);
        TextView textView3 = submitFeedAddMoreItemDialogBinding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.subTitleView");
        textView3.setText(str5);
        ViewUtil.clickListener(submitFeedAddMoreItemDialogBinding.cancelButton, new DialogUtil$showCenterEditTextDialog$1(create));
        ViewUtil.clickListener(submitFeedAddMoreItemDialogBinding.okButton, new DialogUtil$showCenterEditTextDialog$2(create, submitFeedAddMoreItemDialogBinding, function1));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ8\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/util/DialogUtil$DialogItemData;", "", "type", "", "title", "description", "isChecked", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getDescription", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTitle", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/coolapk/market/util/DialogUtil$DialogItemData;", "equals", "other", "hashCode", "", "toString", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DialogUtil.kt */
    public static final class DialogItemData {
        private final String description;
        private final Boolean isChecked;
        private final String title;
        private final String type;

        public static /* synthetic */ DialogItemData copy$default(DialogItemData dialogItemData, String str, String str2, String str3, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = dialogItemData.type;
            }
            if ((i & 2) != 0) {
                str2 = dialogItemData.title;
            }
            if ((i & 4) != 0) {
                str3 = dialogItemData.description;
            }
            if ((i & 8) != 0) {
                bool = dialogItemData.isChecked;
            }
            return dialogItemData.copy(str, str2, str3, bool);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.title;
        }

        public final String component3() {
            return this.description;
        }

        public final Boolean component4() {
            return this.isChecked;
        }

        public final DialogItemData copy(String str, String str2, String str3, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "description");
            return new DialogItemData(str, str2, str3, bool);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DialogItemData)) {
                return false;
            }
            DialogItemData dialogItemData = (DialogItemData) obj;
            return Intrinsics.areEqual(this.type, dialogItemData.type) && Intrinsics.areEqual(this.title, dialogItemData.title) && Intrinsics.areEqual(this.description, dialogItemData.description) && Intrinsics.areEqual(this.isChecked, dialogItemData.isChecked);
        }

        public int hashCode() {
            String str = this.type;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.title;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Boolean bool = this.isChecked;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "DialogItemData(type=" + this.type + ", title=" + this.title + ", description=" + this.description + ", isChecked=" + this.isChecked + ")";
        }

        public DialogItemData(String str, String str2, String str3, Boolean bool) {
            Intrinsics.checkNotNullParameter(str, "type");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, "description");
            this.type = str;
            this.title = str2;
            this.description = str3;
            this.isChecked = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DialogItemData(String str, String str2, String str3, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? false : bool);
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public final Boolean isChecked() {
            return this.isChecked;
        }
    }

    public final void showBottomSheetListDialog(Activity activity, List<DialogItemData> list, Function1<? super DialogItemData, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(list, "itemData");
        Intrinsics.checkNotNullParameter(function1, "onItemCheck");
        Activity activity2 = activity;
        RecyclerView recyclerView = new RecyclerView(activity2);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity2));
        recyclerView.addItemDecoration(((HorizontalDividerItemDecoration.Builder) ((HorizontalDividerItemDecoration.Builder) new HorizontalDividerItemDecoration.Builder(activity2).color(AppHolder.getAppTheme().getContentBackgroundDividerColor())).size(SizeUtils.dp2px(0.5f))).build());
        recyclerView.setAdapter(new DialogUtil$showBottomSheetListDialog$1(list, function1, showBottomSheetDialog$default(this, activity, recyclerView, true, false, 8, null)));
    }

    public static /* synthetic */ Function0 showBottomSheetDialog$default(DialogUtil dialogUtil, Activity activity, View view, boolean z, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            z2 = false;
        }
        return dialogUtil.showBottomSheetDialog(activity, view, z, z2);
    }

    public final Function0<Unit> showBottomSheetDialog(Activity activity, View view, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
        view.post(new DialogUtil$showBottomSheetDialog$1(view, bottomSheetDialog, activity));
        if (z) {
            hackItsWindowsToDrawSystemBar(bottomSheetDialog);
        }
        if (z2) {
            view.post(new DialogUtil$showBottomSheetDialog$2(view));
        }
        return new DialogUtil$showBottomSheetDialog$3(bottomSheetDialog);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/util/DialogUtil$ListItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DialogUtil.kt */
    private static final class ListItemViewHolder extends BindingViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ListItemViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            GradientDrawable gradientDrawable;
            DialogListItemViewBinding dialogListItemViewBinding = (DialogListItemViewBinding) getBinding();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.util.DialogUtil.DialogItemData");
            DialogItemData dialogItemData = (DialogItemData) obj;
            TextView textView = dialogListItemViewBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(dialogItemData.getTitle());
            TextView textView2 = dialogListItemViewBinding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.descriptionView");
            textView2.setText(dialogItemData.getDescription());
            TextView textView3 = dialogListItemViewBinding.descriptionView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.descriptionView");
            int i = 8;
            textView3.setVisibility(dialogItemData.getDescription().length() == 0 ? 8 : 0);
            ImageView imageView = dialogListItemViewBinding.checkView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.checkView");
            ImageView imageView2 = imageView;
            if (!(dialogItemData.isChecked() == null)) {
                i = 0;
            }
            imageView2.setVisibility(i);
            if (dialogItemData.isChecked() != null) {
                if (dialogItemData.isChecked().booleanValue()) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(1);
                    gradientDrawable2.setColor(AppHolder.getAppTheme().getColorAccent());
                    Unit unit = Unit.INSTANCE;
                    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gradientDrawable2, ResourceUtils.getDrawable(getContext(), 2131231256)});
                    layerDrawable.setLayerInset(1, NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4));
                    gradientDrawable = layerDrawable;
                } else {
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setShape(1);
                    gradientDrawable3.setStroke(NumberExtendsKt.getDp((Number) 1), (int) 4290624957L);
                    gradientDrawable = gradientDrawable3;
                }
                dialogListItemViewBinding.checkView.setImageDrawable(gradientDrawable);
            }
        }
    }

    public final void showBottomSheetEditDialog(Activity activity, String str, String str2, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "content");
        Intrinsics.checkNotNullParameter(str2, "hint");
        Intrinsics.checkNotNullParameter(function1, "onDone");
        UserProfileFragment.BottomEditTextDialog newInstance = UserProfileFragment.BottomEditTextDialog.newInstance(str, str2, "");
        newInstance.setListener(new DialogUtil$showBottomSheetEditDialog$$inlined$apply$lambda$1(newInstance, function1, activity));
        newInstance.show(ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager(), (String) null);
    }

    public static /* synthetic */ void showItemSelectDialog$default(DialogUtil dialogUtil, Activity activity, String str, List list, boolean z, Function1 function1, int i, Object obj) {
        dialogUtil.showItemSelectDialog(activity, str, list, (i & 8) != 0 ? true : z, function1);
    }

    public final void showItemSelectDialog(Activity activity, String str, List<DialogItemData> list, boolean z, Function1<? super DialogItemData, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "itemData");
        Intrinsics.checkNotNullParameter(function1, "onItemCheck");
        Activity activity2 = activity;
        DialogSeletorContainerBinding dialogSeletorContainerBinding = (DialogSeletorContainerBinding) DataBindingUtil.inflate(LayoutInflater.from(activity2), 2131558536, null, false);
        if (!z) {
            LinearLayout linearLayout = dialogSeletorContainerBinding.actionContainer;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.actionContainer");
            linearLayout.setVisibility(8);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity2);
        Intrinsics.checkNotNullExpressionValue(dialogSeletorContainerBinding, "binding");
        AlertDialog create = builder.setView(dialogSeletorContainerBinding.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity2).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
        TextView textView = dialogSeletorContainerBinding.titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(str);
        ViewUtil.clickListener(dialogSeletorContainerBinding.cancelButton, new DialogUtil$showItemSelectDialog$1(create));
        Window window = create.getWindow();
        if (window != null) {
            Intrinsics.checkNotNullExpressionValue(window, "dialog.window ?: return");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((float) DisplayUtils.getDecorMinSideLength(activity2)) * 0.75f);
            window.setAttributes(attributes);
            RecyclerView recyclerView = dialogSeletorContainerBinding.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(activity2));
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = (T) CollectionsKt.toMutableList((Collection) list);
            recyclerView.setAdapter(new DialogUtil$showItemSelectDialog$2(list, objectRef, activity, recyclerView, z, create, function1));
            ViewUtil.clickListener(dialogSeletorContainerBinding.okButton, new DialogUtil$showItemSelectDialog$3(create, objectRef, function1));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/coolapk/market/util/DialogUtil$SelectItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DialogUtil.kt */
    private static final class SelectItemViewHolder extends BindingViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SelectItemViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            GradientDrawable gradientDrawable;
            DialogSelectItemBinding dialogSelectItemBinding = (DialogSelectItemBinding) getBinding();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.util.DialogUtil.DialogItemData");
            DialogItemData dialogItemData = (DialogItemData) obj;
            TextView textView = dialogSelectItemBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(dialogItemData.getTitle());
            ImageView imageView = dialogSelectItemBinding.checkView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.checkView");
            imageView.setVisibility(dialogItemData.isChecked() == null ? 8 : 0);
            if (dialogItemData.isChecked() != null) {
                if (dialogItemData.isChecked().booleanValue()) {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    gradientDrawable2.setShape(1);
                    gradientDrawable2.setStroke(NumberExtendsKt.getDp((Number) 2), AppHolder.getAppTheme().getColorAccent());
                    Unit unit = Unit.INSTANCE;
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setShape(1);
                    gradientDrawable3.setColor(AppHolder.getAppTheme().getColorAccent());
                    Unit unit2 = Unit.INSTANCE;
                    LayerDrawable layerDrawable = new LayerDrawable(new GradientDrawable[]{gradientDrawable2, gradientDrawable3});
                    layerDrawable.setLayerInset(1, NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4), NumberExtendsKt.getDp((Number) 4));
                    gradientDrawable = layerDrawable;
                } else {
                    GradientDrawable gradientDrawable4 = new GradientDrawable();
                    gradientDrawable4.setShape(1);
                    gradientDrawable4.setStroke(NumberExtendsKt.getDp((Number) 2), (int) 4290624957L);
                    gradientDrawable = gradientDrawable4;
                }
                dialogSelectItemBinding.checkView.setImageDrawable(gradientDrawable);
            }
        }
    }

    private final void hackItsWindowsToDrawSystemBar(BottomSheetDialog bottomSheetDialog) {
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            Intrinsics.checkNotNullExpressionValue(window, "window ?: return");
            window.addFlags(Integer.MIN_VALUE);
            window.addFlags(134217728);
            View decorView = window.getDecorView();
            Objects.requireNonNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) UiUtils.findFirstChildViewByType((ViewGroup) decorView, CoordinatorLayout.class);
            if (coordinatorLayout != null) {
                ViewParent parent = coordinatorLayout.getParent();
                Objects.requireNonNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
                ViewExtendsKt.detachFromParent(coordinatorLayout2);
                ViewUtil.replaceView((ViewGroup) parent, coordinatorLayout2);
            }
        }
    }
}
