package com.coolapk.market.viewholder;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSearchShFilterBinding;
import com.coolapk.market.view.search.SuperSearchViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondHandFilterViewHolder.kt */
public final class SecondHandFilterViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558916;
    private final ItemSearchShFilterBinding binding;
    private final ArrayList<TextView> filterTextViews;
    private final ArrayList<LinearLayout> filterViews;
    private final String searchType;
    private final SuperSearchViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecondHandFilterViewHolder(View view, String str, SuperSearchViewModel superSearchViewModel, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "searchType");
        Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        this.searchType = str;
        this.viewModel = superSearchViewModel;
        ItemSearchShFilterBinding itemSearchShFilterBinding = (ItemSearchShFilterBinding) getBinding();
        this.binding = itemSearchShFilterBinding;
        this.filterViews = CollectionsKt.arrayListOf(itemSearchShFilterBinding.erShouSortView, itemSearchShFilterBinding.shOtherFilterView);
        ArrayList<TextView> arrayListOf = CollectionsKt.arrayListOf(itemSearchShFilterBinding.erShouSortTextView, itemSearchShFilterBinding.shOtherFilterTextView);
        this.filterTextViews = arrayListOf;
        Iterator<T> it2 = arrayListOf.iterator();
        while (it2.hasNext()) {
            it2.next().setTextColor(createSelectedTextColor());
        }
        Iterator<T> it3 = this.filterViews.iterator();
        while (it3.hasNext()) {
            it3.next().setOnClickListener(this);
        }
    }

    public final String getSearchType() {
        return this.searchType;
    }

    public final SuperSearchViewModel getViewModel() {
        return this.viewModel;
    }

    /* compiled from: SecondHandFilterViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        updateAppSortView();
        updateFilterView();
    }

    public static /* synthetic */ void resetChevronView$default(SecondHandFilterViewHolder secondHandFilterViewHolder, boolean z, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        secondHandFilterViewHolder.resetChevronView(z, i);
    }

    public final void resetChevronView(boolean z, int i) {
        ImageView imageView;
        if (i != 2) {
            imageView = this.binding.shOtherFilterChevronView;
        } else {
            imageView = this.binding.erShouSortChevronView;
        }
        Intrinsics.checkNotNullExpressionValue(imageView, "when (index) {\n         …lterChevronView\n        }");
        imageView.animate().rotation(0.0f).setDuration(z ? 0 : 250).start();
    }

    public final void rotateChevronView(int i) {
        ImageView imageView;
        if (i != 2) {
            imageView = this.binding.shOtherFilterChevronView;
        } else {
            imageView = this.binding.erShouSortChevronView;
        }
        Intrinsics.checkNotNullExpressionValue(imageView, "when (index) {\n         …lterChevronView\n        }");
        imageView.animate().rotation(180.0f).setDuration(250).start();
    }

    public static /* synthetic */ void resetSortChevronView$default(SecondHandFilterViewHolder secondHandFilterViewHolder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        secondHandFilterViewHolder.resetSortChevronView(z);
    }

    public final void resetSortChevronView(boolean z) {
        this.binding.erShouSortChevronView.animate().rotation(0.0f).setDuration(z ? 0 : 250).start();
    }

    public final void rotateSortChevronView() {
        this.binding.erShouSortChevronView.animate().rotation(180.0f).setDuration(250).start();
    }

    public static /* synthetic */ void resetOtherChevronView$default(SecondHandFilterViewHolder secondHandFilterViewHolder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        secondHandFilterViewHolder.resetOtherChevronView(z);
    }

    public final void resetOtherChevronView(boolean z) {
        this.binding.shOtherFilterChevronView.animate().rotation(0.0f).setDuration(z ? 0 : 250).start();
    }

    public final void rotateOtherChevronView() {
        this.binding.shOtherFilterChevronView.animate().rotation(180.0f).setDuration(250).start();
    }

    private final void updateAppSortView() {
        if (Intrinsics.areEqual(this.viewModel.getDealType(), "2")) {
            TextView textView = this.binding.erShouSortTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.erShouSortTextView");
            textView.setText(this.viewModel.getSecondHandChangeSortMap().get(this.viewModel.getSecondHandChangeSort()));
            TextView textView2 = this.binding.erShouSortTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.erShouSortTextView");
            textView2.setSelected(!Intrinsics.areEqual(this.viewModel.getSecondHandChangeSort(), "default"));
            this.binding.erShouSortChevronView.setColorFilter(Intrinsics.areEqual(this.viewModel.getSecondHandChangeSort(), "default") ^ true ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
            return;
        }
        TextView textView3 = this.binding.erShouSortTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.erShouSortTextView");
        textView3.setText(this.viewModel.getSecondHandSortMap().get(this.viewModel.getSecondHandSort()));
        TextView textView4 = this.binding.erShouSortTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.erShouSortTextView");
        textView4.setSelected(!Intrinsics.areEqual(this.viewModel.getSecondHandSort(), "default"));
        this.binding.erShouSortChevronView.setColorFilter(Intrinsics.areEqual(this.viewModel.getSecondHandSort(), "default") ^ true ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
    }

    private final void updateFilterView() {
        if (Intrinsics.areEqual(this.viewModel.getDealType(), "1")) {
            TextView textView = this.binding.shOtherFilterTextView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.shOtherFilterTextView");
            textView.setText(this.viewModel.getOtherMapRemoveLink().get(this.viewModel.getSecondHandFilterInBuy()));
            TextView textView2 = this.binding.shOtherFilterTextView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.shOtherFilterTextView");
            textView2.setSelected(!Intrinsics.areEqual(this.viewModel.getSecondHandFilterInBuy(), "0"));
            this.binding.shOtherFilterChevronView.setColorFilter(Intrinsics.areEqual(this.viewModel.getSecondHandFilterInBuy(), "0") ^ true ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
            return;
        }
        TextView textView3 = this.binding.shOtherFilterTextView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.shOtherFilterTextView");
        textView3.setText(this.viewModel.getOtherMap().get(this.viewModel.getSecondHandOther()));
        TextView textView4 = this.binding.shOtherFilterTextView;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.shOtherFilterTextView");
        textView4.setSelected(!Intrinsics.areEqual(this.viewModel.getSecondHandOther(), "0"));
        this.binding.shOtherFilterChevronView.setColorFilter(Intrinsics.areEqual(this.viewModel.getSecondHandOther(), "0") ^ true ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
    }

    private final ColorStateList createSelectedTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
    }
}
