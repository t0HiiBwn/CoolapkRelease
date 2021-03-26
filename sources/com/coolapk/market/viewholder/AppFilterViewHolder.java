package com.coolapk.market.viewholder;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSearchAppFilterBinding;
import com.coolapk.market.view.search.SuperSearchViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppFilterViewHolder.kt */
public final class AppFilterViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558912;
    private final ItemSearchAppFilterBinding binding;
    private final ArrayList<TextView> filterTextViews;
    private final ArrayList<LinearLayout> filterViews;
    private final String searchType;
    private final SuperSearchViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppFilterViewHolder(View view, String str, SuperSearchViewModel superSearchViewModel, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "searchType");
        Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        this.searchType = str;
        this.viewModel = superSearchViewModel;
        ItemSearchAppFilterBinding itemSearchAppFilterBinding = (ItemSearchAppFilterBinding) getBinding();
        this.binding = itemSearchAppFilterBinding;
        this.filterViews = CollectionsKt.arrayListOf(itemSearchAppFilterBinding.appCategoryView, itemSearchAppFilterBinding.appSortView);
        ArrayList<TextView> arrayListOf = CollectionsKt.arrayListOf(itemSearchAppFilterBinding.appCategoryTextView, itemSearchAppFilterBinding.appSortTextView);
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

    /* compiled from: AppFilterViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        updateAppCategoryView();
        updateAppSortView();
    }

    public static /* synthetic */ void resetCategoryChevronView$default(AppFilterViewHolder appFilterViewHolder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        appFilterViewHolder.resetCategoryChevronView(z);
    }

    public final void resetCategoryChevronView(boolean z) {
        this.binding.appCategoryChevronView.animate().rotation(0.0f).setDuration(z ? 0 : 250).start();
    }

    public final void rotateCategoryChevronView() {
        this.binding.appCategoryChevronView.animate().rotation(180.0f).setDuration(250).start();
    }

    public static /* synthetic */ void resetSortChevronView$default(AppFilterViewHolder appFilterViewHolder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        appFilterViewHolder.resetSortChevronView(z);
    }

    public final void resetSortChevronView(boolean z) {
        this.binding.appSortChevronView.animate().rotation(0.0f).setDuration(z ? 0 : 250).start();
    }

    public final void rotateSortChevronView() {
        this.binding.appSortChevronView.animate().rotation(180.0f).setDuration(250).start();
    }

    private final void updateAppCategoryView() {
        String str = this.searchType;
        int hashCode = str.hashCode();
        T t = null;
        if (hashCode != 96796) {
            if (hashCode == 3165170 && str.equals("game")) {
                Iterator<T> it2 = this.viewModel.getGameCategoryList().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    if (Intrinsics.areEqual(next.getId(), this.viewModel.getGameCat())) {
                        t = next;
                        break;
                    }
                }
                T t2 = t;
                if (t2 == null) {
                    TextView textView = this.binding.appCategoryTextView;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.appCategoryTextView");
                    textView.setText("全部分类");
                    TextView textView2 = this.binding.appCategoryTextView;
                    Intrinsics.checkNotNullExpressionValue(textView2, "binding.appCategoryTextView");
                    textView2.setSelected(false);
                    this.binding.appCategoryChevronView.setColorFilter(AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
                    return;
                }
                TextView textView3 = this.binding.appCategoryTextView;
                Intrinsics.checkNotNullExpressionValue(textView3, "binding.appCategoryTextView");
                textView3.setText(t2.getTitle());
                TextView textView4 = this.binding.appCategoryTextView;
                Intrinsics.checkNotNullExpressionValue(textView4, "binding.appCategoryTextView");
                textView4.setSelected(true);
                this.binding.appCategoryChevronView.setColorFilter(AppHolder.getAppTheme().getColorAccent(), PorterDuff.Mode.SRC_IN);
            }
        } else if (str.equals("apk")) {
            Iterator<T> it3 = this.viewModel.getAppCategoryList().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                T next2 = it3.next();
                if (Intrinsics.areEqual(next2.getId(), this.viewModel.getAppCat())) {
                    t = next2;
                    break;
                }
            }
            T t3 = t;
            if (t3 == null) {
                TextView textView5 = this.binding.appCategoryTextView;
                Intrinsics.checkNotNullExpressionValue(textView5, "binding.appCategoryTextView");
                textView5.setText("全部分类");
                TextView textView6 = this.binding.appCategoryTextView;
                Intrinsics.checkNotNullExpressionValue(textView6, "binding.appCategoryTextView");
                textView6.setSelected(false);
                this.binding.appCategoryChevronView.setColorFilter(AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
                return;
            }
            TextView textView7 = this.binding.appCategoryTextView;
            Intrinsics.checkNotNullExpressionValue(textView7, "binding.appCategoryTextView");
            textView7.setText(t3.getTitle());
            TextView textView8 = this.binding.appCategoryTextView;
            Intrinsics.checkNotNullExpressionValue(textView8, "binding.appCategoryTextView");
            textView8.setSelected(true);
            this.binding.appCategoryChevronView.setColorFilter(AppHolder.getAppTheme().getColorAccent(), PorterDuff.Mode.SRC_IN);
        }
    }

    private final void updateAppSortView() {
        String str = this.searchType;
        int hashCode = str.hashCode();
        if (hashCode != 96796) {
            if (hashCode == 3165170 && str.equals("game")) {
                TextView textView = this.binding.appSortTextView;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.appSortTextView");
                textView.setText(this.viewModel.getAppSortMap().get(this.viewModel.getGameSort()));
                TextView textView2 = this.binding.appSortTextView;
                Intrinsics.checkNotNullExpressionValue(textView2, "binding.appSortTextView");
                textView2.setSelected(!Intrinsics.areEqual(this.viewModel.getGameSort(), "default"));
                this.binding.appSortChevronView.setColorFilter(Intrinsics.areEqual(this.viewModel.getAppSort(), "default") ^ true ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
            }
        } else if (str.equals("apk")) {
            TextView textView3 = this.binding.appSortTextView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.appSortTextView");
            textView3.setText(this.viewModel.getAppSortMap().get(this.viewModel.getAppSort()));
            TextView textView4 = this.binding.appSortTextView;
            Intrinsics.checkNotNullExpressionValue(textView4, "binding.appSortTextView");
            textView4.setSelected(!Intrinsics.areEqual(this.viewModel.getAppSort(), "default"));
            this.binding.appSortChevronView.setColorFilter(Intrinsics.areEqual(this.viewModel.getAppSort(), "default") ^ true ? AppHolder.getAppTheme().getColorAccent() : AppHolder.getAppTheme().getTextColorPrimary(), PorterDuff.Mode.SRC_IN);
        }
    }

    private final ColorStateList createSelectedTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
    }
}
