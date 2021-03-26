package com.coolapk.market.viewholder;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSearchHistoryBinding;
import com.coolapk.market.databinding.SearchHistoryBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.search.SuperSearchActivity;
import com.google.android.flexbox.FlexboxLayoutManager;
import group.infotech.drawable.dsl.ShapesKt;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0002R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHistoryViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "dataSet", "", "", "historyLines", "Ljava/util/concurrent/atomic/AtomicInteger;", "showAllHistory", "Ljava/util/concurrent/atomic/AtomicBoolean;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onKeywordClick", "Lkotlin/Function1;", "", "(Landroid/view/View;Ljava/util/List;Ljava/util/concurrent/atomic/AtomicInteger;Ljava/util/concurrent/atomic/AtomicBoolean;Lcom/coolapk/market/viewholder/ItemActionHandler;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/coolapk/market/databinding/SearchHistoryBinding;", "kotlin.jvm.PlatformType", "getDataSet", "()Ljava/util/List;", "layoutManager", "Lcom/google/android/flexbox/FlexboxLayoutManager;", "getOnKeywordClick", "()Lkotlin/jvm/functions/Function1;", "bindTo", "data", "", "updateUI", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SearchHistoryViewHolder.kt */
public final class SearchHistoryViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131559125;
    private final SearchHistoryBinding binding;
    private final List<String> dataSet;
    private final AtomicInteger historyLines;
    private final FlexboxLayoutManager layoutManager;
    private final Function1<String, Unit> onKeywordClick;
    private final AtomicBoolean showAllHistory;

    public final List<String> getDataSet() {
        return this.dataSet;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SearchHistoryViewHolder(View view, List list, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, ItemActionHandler itemActionHandler, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, list, atomicInteger, atomicBoolean, itemActionHandler, (i & 32) != 0 ? null : function1);
    }

    public final Function1<String, Unit> getOnKeywordClick() {
        return this.onKeywordClick;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SearchHistoryViewHolder(View view, List<String> list, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, ItemActionHandler itemActionHandler, Function1<? super String, Unit> function1) {
        super(view, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(list, "dataSet");
        Intrinsics.checkNotNullParameter(atomicInteger, "historyLines");
        Intrinsics.checkNotNullParameter(atomicBoolean, "showAllHistory");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        this.dataSet = list;
        this.historyLines = atomicInteger;
        this.showAllHistory = atomicBoolean;
        this.onKeywordClick = function1;
        SearchHistoryBinding searchHistoryBinding = (SearchHistoryBinding) getBinding();
        this.binding = searchHistoryBinding;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        this.layoutManager = flexboxLayoutManager;
        RecyclerView recyclerView = searchHistoryBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setLayoutManager(flexboxLayoutManager);
        RecyclerView recyclerView2 = searchHistoryBinding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setAdapter(new DataAdapter());
        SearchHistoryViewHolder searchHistoryViewHolder = this;
        searchHistoryBinding.closeView.setOnClickListener(searchHistoryViewHolder);
        searchHistoryBinding.toggleHistoryView.setOnClickListener(searchHistoryViewHolder);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHistoryViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "createBackground", "Landroid/graphics/drawable/GradientDrawable;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHistoryViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final GradientDrawable createBackground() {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            ShapesKt.setSolidColor(gradientDrawable, Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#282828" : "#F5F5F5"));
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            return gradientDrawable;
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        RecyclerView recyclerView = this.binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Intrinsics.checkNotNull(adapter);
        adapter.notifyDataSetChanged();
        this.binding.executePendingBindings();
        TextView textView = this.binding.toggleHistoryTextView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.toggleHistoryTextView");
        textView.setText(this.showAllHistory.get() ? "收起更多搜索历史" : "展开更多搜索历史");
        this.binding.chevronView.animate().rotation(this.showAllHistory.get() ? 180.0f : 0.0f).setDuration(0).start();
        RecyclerView recyclerView2 = this.binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        ViewExtendsKt.onceOnGlobalLayoutListener(recyclerView2, new SearchHistoryViewHolder$bindTo$1(this));
        updateUI();
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        int i = -2;
        if (this.historyLines.get() > 2) {
            LinearLayout linearLayout = this.binding.toggleHistoryView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.toggleHistoryView");
            linearLayout.setVisibility(0);
            RecyclerView recyclerView = this.binding.recyclerView;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (!this.showAllHistory.get()) {
                i = NumberExtendsKt.getDp((Number) 92);
            }
            layoutParams.height = i;
            return;
        }
        LinearLayout linearLayout2 = this.binding.toggleHistoryView;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.toggleHistoryView");
        linearLayout2.setVisibility(8);
        RecyclerView recyclerView2 = this.binding.recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.getLayoutParams().height = -2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHistoryViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/viewholder/SearchHistoryViewHolder$DataViewHolder;", "(Lcom/coolapk/market/viewholder/SearchHistoryViewHolder;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHistoryViewHolder.kt */
    public final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558912, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            ItemActionHandler itemActionHandler = SearchHistoryViewHolder.this.getItemActionHandler();
            Intrinsics.checkNotNullExpressionValue(itemActionHandler, "itemActionHandler");
            return new DataViewHolder(inflate, itemActionHandler, SearchHistoryViewHolder.this.getOnKeywordClick());
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            dataViewHolder.bindTo(SearchHistoryViewHolder.this.getDataSet().get(i));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return SearchHistoryViewHolder.this.getDataSet().size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHistoryViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "onKeywordClick", "Lkotlin/Function1;", "", "", "(Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;Lkotlin/jvm/functions/Function1;)V", "binding", "Lcom/coolapk/market/databinding/ItemSearchHistoryBinding;", "kotlin.jvm.PlatformType", "keyword", "bindTo", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SearchHistoryViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558912;
        private final ItemSearchHistoryBinding binding;
        private String keyword;
        private final Function1<String, Unit> onKeywordClick;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view, ItemActionHandler itemActionHandler, Function1<? super String, Unit> function1) {
            super(view, itemActionHandler);
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
            this.onKeywordClick = function1;
            ItemSearchHistoryBinding itemSearchHistoryBinding = (ItemSearchHistoryBinding) getBinding();
            this.binding = itemSearchHistoryBinding;
            itemSearchHistoryBinding.itemView.setOnClickListener(this);
            itemSearchHistoryBinding.itemView.setOnLongClickListener(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SearchHistoryViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SearchHistoryViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.keyword = (String) obj;
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            String str = this.keyword;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyword");
            }
            textView.setText(str);
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            String str2 = this.keyword;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyword");
            }
            linearLayout.setTag(str2);
            this.binding.executePendingBindings();
            LinearLayout linearLayout2 = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.itemView");
            linearLayout2.setBackground(SearchHistoryViewHolder.Companion.createBackground());
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            if (view.getId() == 2131362768) {
                Function1<String, Unit> function1 = this.onKeywordClick;
                if (function1 != null) {
                    String str = this.keyword;
                    if (str == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("keyword");
                    }
                    function1.invoke(str);
                    return;
                }
                SuperSearchActivity superSearchActivity = (SuperSearchActivity) getContext();
                if (superSearchActivity != null) {
                    String str2 = this.keyword;
                    if (str2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("keyword");
                    }
                    superSearchActivity.inputKeyword(str2);
                }
            }
        }
    }
}
