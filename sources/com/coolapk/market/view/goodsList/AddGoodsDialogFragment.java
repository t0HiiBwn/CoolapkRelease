package com.coolapk.market.view.goodsList;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.coolapk.market.databinding.AddGoodsItemDialogBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.imageloader.GlideApp;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.GoodsListItem;
import com.coolapk.market.view.base.BaseDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/coolapk/market/view/goodsList/AddGoodsDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "addedItemId", "", "binding", "Lcom/coolapk/market/databinding/AddGoodsItemDialogBinding;", "feed", "Lcom/coolapk/market/model/Feed;", "feedId", "goodsId", "goodsListItem", "Lcom/coolapk/market/model/GoodsListItem;", "isAddGoods", "", "isEditNote", "logo", "mGoodsListItemViewModel", "Lcom/coolapk/market/view/goodsList/GoodsListItemViewModel;", "note", "title", "bindToData", "", "findItem", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "setViewModel", "viewModel", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AddGoodsDialogFragment.kt */
public final class AddGoodsDialogFragment extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private String addedItemId;
    private AddGoodsItemDialogBinding binding;
    private Feed feed;
    private String feedId;
    private String goodsId;
    private GoodsListItem goodsListItem;
    private boolean isAddGoods;
    private boolean isEditNote;
    private String logo;
    private GoodsListItemViewModel mGoodsListItemViewModel;
    private String note;
    private String title;

    public static final /* synthetic */ AddGoodsItemDialogBinding access$getBinding$p(AddGoodsDialogFragment addGoodsDialogFragment) {
        AddGoodsItemDialogBinding addGoodsItemDialogBinding = addGoodsDialogFragment.binding;
        if (addGoodsItemDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        return addGoodsItemDialogBinding;
    }

    public static final /* synthetic */ GoodsListItemViewModel access$getMGoodsListItemViewModel$p(AddGoodsDialogFragment addGoodsDialogFragment) {
        GoodsListItemViewModel goodsListItemViewModel = addGoodsDialogFragment.mGoodsListItemViewModel;
        if (goodsListItemViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGoodsListItemViewModel");
        }
        return goodsListItemViewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/coolapk/market/view/goodsList/AddGoodsDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/goodsList/AddGoodsDialogFragment;", "feedId", "", "goodsId", "logo", "title", "note", "isEditNote", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AddGoodsDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ AddGoodsDialogFragment newInstance$default(Companion companion, String str, String str2, String str3, String str4, String str5, boolean z, int i, Object obj) {
            if ((i & 16) != 0) {
                str5 = "";
            }
            return companion.newInstance(str, str2, str3, str4, str5, (i & 32) != 0 ? false : z);
        }

        public final AddGoodsDialogFragment newInstance(String str, String str2, String str3, String str4, String str5, boolean z) {
            Intrinsics.checkNotNullParameter(str, "feedId");
            Intrinsics.checkNotNullParameter(str2, "goodsId");
            Intrinsics.checkNotNullParameter(str3, "logo");
            Intrinsics.checkNotNullParameter(str4, "title");
            Intrinsics.checkNotNullParameter(str5, "note");
            Bundle bundle = new Bundle();
            bundle.putString("feedId", str);
            bundle.putString("goodsId", str2);
            bundle.putString("logo", str3);
            bundle.putString("title", str4);
            bundle.putString("note", str5);
            bundle.putBoolean("isEditNote", z);
            AddGoodsDialogFragment addGoodsDialogFragment = new AddGoodsDialogFragment();
            addGoodsDialogFragment.setArguments(bundle);
            return addGoodsDialogFragment;
        }
    }

    public final void setViewModel(GoodsListItemViewModel goodsListItemViewModel) {
        if (goodsListItemViewModel != null) {
            this.mGoodsListItemViewModel = goodsListItemViewModel;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), 2131558437, null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…item_dialog, null, false)");
        AddGoodsItemDialogBinding addGoodsItemDialogBinding = (AddGoodsItemDialogBinding) inflate;
        this.binding = addGoodsItemDialogBinding;
        if (addGoodsItemDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        ProgressBar progressBar = addGoodsItemDialogBinding.loadingView;
        Intrinsics.checkNotNullExpressionValue(progressBar, "binding.loadingView");
        int i = 8;
        progressBar.setVisibility(8);
        this.goodsId = requireArguments().getString("goodsId");
        this.feedId = requireArguments().getString("feedId");
        this.logo = requireArguments().getString("logo");
        this.title = requireArguments().getString("title");
        this.note = requireArguments().getString("note");
        this.isEditNote = requireArguments().getBoolean("isEditNote");
        AddGoodsItemDialogBinding addGoodsItemDialogBinding2 = this.binding;
        if (addGoodsItemDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addGoodsItemDialogBinding2.setDialogTitle("添加好物说明");
        AddGoodsItemDialogBinding addGoodsItemDialogBinding3 = this.binding;
        if (addGoodsItemDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = addGoodsItemDialogBinding3.goodsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.goodsLayout");
        if (this.isAddGoods) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        String str = this.logo;
        Intrinsics.checkNotNull(str);
        String str2 = this.title;
        Intrinsics.checkNotNull(str2);
        String str3 = this.note;
        Intrinsics.checkNotNull(str3);
        bindToData(str, str2, str3);
        AddGoodsItemDialogBinding addGoodsItemDialogBinding4 = this.binding;
        if (addGoodsItemDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = addGoodsItemDialogBinding4.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.setHint("输入点评");
        AddGoodsItemDialogBinding addGoodsItemDialogBinding5 = this.binding;
        if (addGoodsItemDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = addGoodsItemDialogBinding5.okButton;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.okButton");
        ViewExtendsKt.setUtilClickListener(textView, new AddGoodsDialogFragment$onCreateDialog$1(this));
        AddGoodsItemDialogBinding addGoodsItemDialogBinding6 = this.binding;
        if (addGoodsItemDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView2 = addGoodsItemDialogBinding6.cancelButton;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.cancelButton");
        ViewExtendsKt.setUtilClickListener(textView2, new AddGoodsDialogFragment$onCreateDialog$2(this));
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        AddGoodsItemDialogBinding addGoodsItemDialogBinding7 = this.binding;
        if (addGoodsItemDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        AlertDialog create = builder.setView(addGoodsItemDialogBinding7.getRoot()).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(requ…                .create()");
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        return create;
    }

    private final int findItem(String str) {
        ArrayList arrayList;
        List<GoodsListItem> goodsListItem2;
        Feed feed2 = this.feed;
        if (feed2 == null) {
            return -1;
        }
        if (feed2 == null || (goodsListItem2 = feed2.getGoodsListItem()) == null) {
            arrayList = null;
        } else {
            List<GoodsListItem> list = goodsListItem2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                Intrinsics.checkNotNullExpressionValue(t, "it");
                arrayList2.add(t.getProductGoodsId());
            }
            arrayList = arrayList2;
        }
        Intrinsics.checkNotNull(arrayList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (Intrinsics.areEqual((String) arrayList.get(i), str)) {
                return i;
            }
        }
        return -1;
    }

    static /* synthetic */ void bindToData$default(AddGoodsDialogFragment addGoodsDialogFragment, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = "";
        }
        addGoodsDialogFragment.bindToData(str, str2, str3);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.coolapk.market.imageloader.GlideRequest] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private final void bindToData(String str, String str2, String str3) {
        ?? load = GlideApp.with(this).load(str);
        AddGoodsItemDialogBinding addGoodsItemDialogBinding = this.binding;
        if (addGoodsItemDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        load.into(addGoodsItemDialogBinding.logoView);
        AddGoodsItemDialogBinding addGoodsItemDialogBinding2 = this.binding;
        if (addGoodsItemDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addGoodsItemDialogBinding2.setTitle(str2);
        AddGoodsItemDialogBinding addGoodsItemDialogBinding3 = this.binding;
        if (addGoodsItemDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addGoodsItemDialogBinding3.setDialogTitle("添加好物说明");
        AddGoodsItemDialogBinding addGoodsItemDialogBinding4 = this.binding;
        if (addGoodsItemDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText = addGoodsItemDialogBinding4.editText;
        Intrinsics.checkNotNullExpressionValue(editText, "binding.editText");
        editText.setHint("说说你想买的理由或使用体验");
        AddGoodsItemDialogBinding addGoodsItemDialogBinding5 = this.binding;
        if (addGoodsItemDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        LinearLayout linearLayout = addGoodsItemDialogBinding5.goodsLayout;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.goodsLayout");
        boolean z = false;
        linearLayout.setVisibility(0);
        AddGoodsItemDialogBinding addGoodsItemDialogBinding6 = this.binding;
        if (addGoodsItemDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        TextView textView = addGoodsItemDialogBinding6.textView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
        textView.setVisibility(8);
        this.isAddGoods = true;
        AddGoodsItemDialogBinding addGoodsItemDialogBinding7 = this.binding;
        if (addGoodsItemDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        EditText editText2 = addGoodsItemDialogBinding7.editText;
        if (str3.length() == 0) {
            z = true;
        }
        if (z) {
            str3 = "";
        }
        editText2.setText(str3);
        AddGoodsItemDialogBinding addGoodsItemDialogBinding8 = this.binding;
        if (addGoodsItemDialogBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }
        addGoodsItemDialogBinding8.executePendingBindings();
    }
}
