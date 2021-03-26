package com.coolapk.market.view.base;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.DialogItemTextViewBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.util.DisplayUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000bH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u001a\u001a\u00020\u00002\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bJ\"\u0010\u001b\u001a\u00020\u000b2\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\bH\u0004R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "Lcom/coolapk/market/view/base/BaseDialogFragment;", "()V", "adapter", "Lcom/coolapk/market/view/base/MultiItemDialogFragment$ItemListAdapter;", "adapterLayout", "Landroid/widget/ListView;", "builder", "Lkotlin/Function1;", "", "Lcom/coolapk/market/view/base/ActionItem;", "", "dataList", "hideTitle", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "setInitBuilder", "updateDataList", "callback", "Companion", "ItemListAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MultiItemDialogFragment.kt */
public class MultiItemDialogFragment extends BaseDialogFragment {
    public static final Companion Companion = new Companion(null);
    private ItemListAdapter adapter;
    private ListView adapterLayout;
    private Function1<? super List<ActionItem>, Unit> builder;
    private final List<ActionItem> dataList = new ArrayList();

    public static final /* synthetic */ ItemListAdapter access$getAdapter$p(MultiItemDialogFragment multiItemDialogFragment) {
        ItemListAdapter itemListAdapter = multiItemDialogFragment.adapter;
        if (itemListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return itemListAdapter;
    }

    public static final /* synthetic */ ListView access$getAdapterLayout$p(MultiItemDialogFragment multiItemDialogFragment) {
        ListView listView = multiItemDialogFragment.adapterLayout;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        return listView;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/base/MultiItemDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/base/MultiItemDialogFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MultiItemDialogFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiItemDialogFragment newInstance() {
            return new MultiItemDialogFragment();
        }
    }

    public final MultiItemDialogFragment setInitBuilder(Function1<? super List<ActionItem>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builder");
        this.builder = function1;
        return this;
    }

    @Override // com.coolapk.market.view.base.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            Intrinsics.checkNotNullExpressionValue(window, "dialog?.window ?: return");
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (((float) DisplayUtils.getDecorMinSideLength(getActivity())) * 0.75f);
            window.setAttributes(attributes);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ListView listView = new ListView(getActivity(), null);
        this.adapterLayout = listView;
        if (listView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        listView.setDivider(null);
        ListView listView2 = this.adapterLayout;
        if (listView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        listView2.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        ListView listView3 = this.adapterLayout;
        if (listView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        listView3.setPadding(0, NumberExtendsKt.getDp((Number) 4), 0, NumberExtendsKt.getDp((Number) 4));
        ListView listView4 = this.adapterLayout;
        if (listView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        listView4.setClipToPadding(false);
        ListView listView5 = this.adapterLayout;
        if (listView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        listView5.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.adapter = new ItemListAdapter(this, requireActivity, this.dataList);
        ListView listView6 = this.adapterLayout;
        if (listView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        ItemListAdapter itemListAdapter = this.adapter;
        if (itemListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        listView6.setAdapter((ListAdapter) itemListAdapter);
        ListView listView7 = this.adapterLayout;
        if (listView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterLayout");
        }
        return listView7;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        hideTitle();
    }

    protected void hideTitle() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Function1<? super List<ActionItem>, Unit> function1 = this.builder;
        if (function1 != null) {
            updateDataList(function1);
        }
    }

    protected final void updateDataList(Function1<? super List<ActionItem>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        function1.invoke(this.dataList);
        ItemListAdapter itemListAdapter = this.adapter;
        if (itemListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        itemListAdapter.notifyDataSetChanged();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u001d\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/base/MultiItemDialogFragment$ItemListAdapter;", "Landroid/widget/ArrayAdapter;", "Lcom/coolapk/market/view/base/ActionItem;", "context", "Landroid/content/Context;", "objects", "", "(Lcom/coolapk/market/view/base/MultiItemDialogFragment;Landroid/content/Context;Ljava/util/List;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MultiItemDialogFragment.kt */
    private final class ItemListAdapter extends ArrayAdapter<ActionItem> {
        final /* synthetic */ MultiItemDialogFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ItemListAdapter(MultiItemDialogFragment multiItemDialogFragment, Context context, List<? extends ActionItem> list) {
            super(context, 0, list);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "objects");
            this.this$0 = multiItemDialogFragment;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            DialogItemTextViewBinding dialogItemTextViewBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            int i2 = 0;
            if (view != null) {
                Object tag = view.getTag(2131363510);
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.databinding.DialogItemTextViewBinding");
                dialogItemTextViewBinding = (DialogItemTextViewBinding) tag;
            } else {
                dialogItemTextViewBinding = DialogItemTextViewBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(dialogItemTextViewBinding, "DialogItemTextViewBindin….context), parent, false)");
                view = dialogItemTextViewBinding.getRoot();
                view.setTag(2131363510, dialogItemTextViewBinding);
            }
            ActionItem actionItem = (ActionItem) getItem(i);
            TextView textView = dialogItemTextViewBinding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            Intrinsics.checkNotNull(actionItem);
            textView.setText(actionItem.getTitle());
            ImageView imageView = dialogItemTextViewBinding.imageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imageView");
            if (!(actionItem instanceof MultiActionItem)) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
            dialogItemTextViewBinding.getRoot().setOnClickListener(new MultiItemDialogFragment$ItemListAdapter$getView$1(this, actionItem));
            return view;
        }
    }
}
