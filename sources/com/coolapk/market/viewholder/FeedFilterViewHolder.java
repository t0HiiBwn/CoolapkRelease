package com.coolapk.market.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemFeedFilterBinding;
import com.coolapk.market.databinding.ItemSearchFeedFilterBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.view.search.SuperSearchViewModel;
import com.coolapk.market.widget.CoolFlowLayout;
import group.infotech.drawable.dsl.ShapesKt;
import group.infotech.drawable.dsl.ViewStates;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0003!\"#B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/coolapk/market/viewholder/FeedFilterViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "pageType", "", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/view/search/SuperSearchViewModel;Ljava/lang/String;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "filterBinding", "Lcom/coolapk/market/databinding/ItemSearchFeedFilterBinding;", "kotlin.jvm.PlatformType", "getPageType", "()Ljava/lang/String;", "sortViews", "Ljava/util/ArrayList;", "Landroid/widget/TextView;", "Lkotlin/collections/ArrayList;", "getViewModel", "()Lcom/coolapk/market/view/search/SuperSearchViewModel;", "bindTo", "", "data", "", "onClick", "setSortSelected", "showSortView", "isShow", "", "updateFilterView", "updateSortView", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedFilterViewHolder.kt */
public final class FeedFilterViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558911;
    public static final String SORT_DATELINE = "dateline";
    public static final String SORT_HOT = "hot";
    public static final String SORT_REPLY = "reply";
    private final ItemSearchFeedFilterBinding filterBinding;
    private final String pageType;
    private final ArrayList<TextView> sortViews;
    private final SuperSearchViewModel viewModel;

    public final SuperSearchViewModel getViewModel() {
        return this.viewModel;
    }

    public final String getPageType() {
        return this.pageType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x011a  */
    public FeedFilterViewHolder(View view, SuperSearchViewModel superSearchViewModel, String str, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        List list;
        int hashCode;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        this.viewModel = superSearchViewModel;
        this.pageType = str;
        ItemSearchFeedFilterBinding itemSearchFeedFilterBinding = (ItemSearchFeedFilterBinding) getBinding();
        this.filterBinding = itemSearchFeedFilterBinding;
        boolean z = false;
        ArrayList<TextView> arrayListOf = CollectionsKt.arrayListOf(itemSearchFeedFilterBinding.sortDateline, itemSearchFeedFilterBinding.sortHot, itemSearchFeedFilterBinding.sortReply);
        this.sortViews = arrayListOf;
        for (T t : arrayListOf) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            Companion companion = Companion;
            t.setBackground(companion.createSelectedBackground());
            t.setTextColor(companion.createSelectedTextColor());
            t.setOnClickListener(this);
        }
        String str2 = this.pageType;
        if (str2 != null) {
            int hashCode2 = str2.hashCode();
            if (hashCode2 != 114586) {
                if (hashCode2 == 1382923806 && str2.equals("product_phone")) {
                    list = MapsKt.toList(this.viewModel.getFeedProductTypeMap());
                    CoolFlowLayout coolFlowLayout = this.filterBinding.feedTypeList;
                    Context context = coolFlowLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    coolFlowLayout.setAdapter(new DataAdapter(this, context, list));
                    coolFlowLayout.setHorizontalDividerWidth(NumberExtendsKt.getDp((Number) 8));
                    coolFlowLayout.setVerticalDividerHeight(NumberExtendsKt.getDp((Number) 8));
                    coolFlowLayout.setLayoutMode("FLEX");
                    String str3 = this.pageType;
                    if (str3 == null || ((hashCode = str3.hashCode()) == 96796 ? !str3.equals("apk") : hashCode != 3599307 || !str3.equals("user"))) {
                        z = true;
                    }
                    if (z) {
                        LinearLayout linearLayout = this.filterBinding.feedTypeLayout;
                        Intrinsics.checkNotNullExpressionValue(linearLayout, "filterBinding.feedTypeLayout");
                        ViewExtendsKt.visible(linearLayout);
                        return;
                    }
                    LinearLayout linearLayout2 = this.filterBinding.feedTypeLayout;
                    Intrinsics.checkNotNullExpressionValue(linearLayout2, "filterBinding.feedTypeLayout");
                    ViewExtendsKt.gone(linearLayout2);
                    return;
                }
            } else if (str2.equals("tag")) {
                list = MapsKt.toList(this.viewModel.getFeedTopicTypeMap());
                CoolFlowLayout coolFlowLayout = this.filterBinding.feedTypeList;
                Context context = coolFlowLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                coolFlowLayout.setAdapter(new DataAdapter(this, context, list));
                coolFlowLayout.setHorizontalDividerWidth(NumberExtendsKt.getDp((Number) 8));
                coolFlowLayout.setVerticalDividerHeight(NumberExtendsKt.getDp((Number) 8));
                coolFlowLayout.setLayoutMode("FLEX");
                String str3 = this.pageType;
                z = true;
                if (z) {
                }
            }
        }
        list = MapsKt.toList(this.viewModel.getFeedTypeMap());
        CoolFlowLayout coolFlowLayout = this.filterBinding.feedTypeList;
        Context context = coolFlowLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        coolFlowLayout.setAdapter(new DataAdapter(this, context, list));
        coolFlowLayout.setHorizontalDividerWidth(NumberExtendsKt.getDp((Number) 8));
        coolFlowLayout.setVerticalDividerHeight(NumberExtendsKt.getDp((Number) 8));
        coolFlowLayout.setLayoutMode("FLEX");
        String str3 = this.pageType;
        z = true;
        if (z) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/coolapk/market/viewholder/FeedFilterViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "SORT_DATELINE", "", "SORT_HOT", "SORT_REPLY", "createSelectedBackground", "Landroid/graphics/drawable/StateListDrawable;", "createSelectedTextColor", "Landroid/content/res/ColorStateList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedFilterViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final ColorStateList createSelectedTextColor() {
            return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{-1, AppHolder.getAppTheme().getTextColorPrimary()});
        }

        /* access modifiers changed from: private */
        public final StateListDrawable createSelectedBackground() {
            StateListDrawable stateListDrawable = new StateListDrawable();
            int[] selected = ViewStates.INSTANCE.selected();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            ShapesKt.setSolidColor(gradientDrawable, AppHolder.getAppTheme().getColorAccent());
            stateListDrawable.addState(selected, gradientDrawable);
            int[] iArr = StateSet.WILD_CARD;
            Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setGradientType(0);
            gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            ShapesKt.setSolidColor(gradientDrawable2, AppHolder.getAppTheme().getContentBackgroundColor());
            stateListDrawable.addState(iArr, gradientDrawable2);
            return stateListDrawable;
        }
    }

    public final void showSortView(boolean z) {
        LinearLayout linearLayout = this.filterBinding.sortView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "filterBinding.sortView");
        linearLayout.setVisibility(z ? 0 : 8);
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        updateSortView();
        updateFilterView();
        this.filterBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        switch (view.getId()) {
            case 2131363381:
                this.viewModel.setFeedSort("dateline");
                break;
            case 2131363383:
                this.viewModel.setFeedSort("hot");
                break;
            case 2131363384:
                this.viewModel.setFeedSort("reply");
                break;
        }
        super.onClick(view);
    }

    private final void updateFilterView() {
        this.filterBinding.feedTypeList.setAdapter(this.filterBinding.feedTypeList.getAdapter());
    }

    private final void updateSortView() {
        String feedSort = this.viewModel.getFeedSort();
        int hashCode = feedSort.hashCode();
        if (hashCode != 103501) {
            if (hashCode == 108401386 && feedSort.equals("reply")) {
                TextView textView = this.filterBinding.sortReply;
                Intrinsics.checkNotNullExpressionValue(textView, "filterBinding.sortReply");
                setSortSelected(textView);
                return;
            }
        } else if (feedSort.equals("hot")) {
            TextView textView2 = this.filterBinding.sortHot;
            Intrinsics.checkNotNullExpressionValue(textView2, "filterBinding.sortHot");
            setSortSelected(textView2);
            return;
        }
        TextView textView3 = this.filterBinding.sortDateline;
        Intrinsics.checkNotNullExpressionValue(textView3, "filterBinding.sortDateline");
        setSortSelected(textView3);
    }

    private final void setSortSelected(View view) {
        for (T t : this.sortViews) {
            Intrinsics.checkNotNullExpressionValue(t, "it");
            t.setSelected(t.getId() == view.getId());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001B'\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/viewholder/FeedFilterViewHolder$DataAdapter;", "Landroid/widget/ArrayAdapter;", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "objects", "", "(Lcom/coolapk/market/viewholder/FeedFilterViewHolder;Landroid/content/Context;Ljava/util/List;)V", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedFilterViewHolder.kt */
    public final class DataAdapter extends ArrayAdapter<Pair<? extends String, ? extends String>> {
        final /* synthetic */ FeedFilterViewHolder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataAdapter(FeedFilterViewHolder feedFilterViewHolder, Context context, List<Pair<String, String>> list) {
            super(context, 0, list);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(list, "objects");
            this.this$0 = feedFilterViewHolder;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            DataViewHolder dataViewHolder;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            if (view != null) {
                Object tag = view.getTag(2131363492);
                Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.viewholder.FeedFilterViewHolder.DataViewHolder");
                dataViewHolder = (DataViewHolder) tag;
            } else {
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558699, viewGroup, false);
                ItemSearchFeedFilterBinding itemSearchFeedFilterBinding = this.this$0.filterBinding;
                Intrinsics.checkNotNullExpressionValue(itemSearchFeedFilterBinding, "filterBinding");
                Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
                DataViewHolder dataViewHolder2 = new DataViewHolder(itemSearchFeedFilterBinding, inflate, this.this$0.getViewModel());
                dataViewHolder2.itemView.setTag(2131363492, dataViewHolder2);
                dataViewHolder = dataViewHolder2;
            }
            dataViewHolder.bindTo(getItem(i));
            View view2 = dataViewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "holder.itemView");
            return view2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005H\u0016R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/coolapk/market/viewholder/FeedFilterViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "viewBinding", "Lcom/coolapk/market/databinding/ItemSearchFeedFilterBinding;", "itemView", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "(Lcom/coolapk/market/databinding/ItemSearchFeedFilterBinding;Landroid/view/View;Lcom/coolapk/market/view/search/SuperSearchViewModel;)V", "binding", "Lcom/coolapk/market/databinding/ItemFeedFilterBinding;", "kotlin.jvm.PlatformType", "item", "Lkotlin/Pair;", "", "getViewModel", "()Lcom/coolapk/market/view/search/SuperSearchViewModel;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedFilterViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558699;
        private final ItemFeedFilterBinding binding;
        private Pair<String, String> item;
        private final ItemSearchFeedFilterBinding viewBinding;
        private final SuperSearchViewModel viewModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(ItemSearchFeedFilterBinding itemSearchFeedFilterBinding, View view, SuperSearchViewModel superSearchViewModel) {
            super(view);
            Intrinsics.checkNotNullParameter(itemSearchFeedFilterBinding, "viewBinding");
            Intrinsics.checkNotNullParameter(view, "itemView");
            Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
            this.viewBinding = itemSearchFeedFilterBinding;
            this.viewModel = superSearchViewModel;
            ItemFeedFilterBinding itemFeedFilterBinding = (ItemFeedFilterBinding) getBinding();
            this.binding = itemFeedFilterBinding;
            itemFeedFilterBinding.itemView.setOnClickListener(this);
        }

        public final SuperSearchViewModel getViewModel() {
            return this.viewModel;
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/FeedFilterViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: FeedFilterViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Pair<kotlin.String, kotlin.String>");
            this.item = (Pair) obj;
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            Pair<String, String> pair = this.item;
            if (pair == null) {
                Intrinsics.throwUninitializedPropertyAccessException("item");
            }
            textView.setText(pair.getSecond());
            LinearLayout linearLayout = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            linearLayout.setBackground(FeedFilterViewHolder.Companion.createSelectedBackground());
            LinearLayout linearLayout2 = this.binding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "binding.itemView");
            String feedFeedType = this.viewModel.getFeedFeedType();
            Pair<String, String> pair2 = this.item;
            if (pair2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("item");
            }
            linearLayout2.setSelected(Intrinsics.areEqual(feedFeedType, pair2.getFirst()));
            this.binding.textView.setTextColor(FeedFilterViewHolder.Companion.createSelectedTextColor());
            TextView textView2 = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.textView");
            String feedFeedType2 = this.viewModel.getFeedFeedType();
            Pair<String, String> pair3 = this.item;
            if (pair3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("item");
            }
            textView2.setSelected(Intrinsics.areEqual(feedFeedType2, pair3.getFirst()));
            this.binding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            if (view.getId() == 2131362768) {
                SuperSearchViewModel superSearchViewModel = this.viewModel;
                Pair<String, String> pair = this.item;
                if (pair == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("item");
                }
                superSearchViewModel.setFeedFeedType(pair.getFirst());
                if (Intrinsics.areEqual(this.viewModel.getFeedFeedType(), "ershou")) {
                    LinearLayout linearLayout = this.viewBinding.sortView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.sortView");
                    linearLayout.setVisibility(8);
                    return;
                }
                LinearLayout linearLayout2 = this.viewBinding.sortView;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "viewBinding.sortView");
                if (!linearLayout2.isShown()) {
                    LinearLayout linearLayout3 = this.viewBinding.sortView;
                    Intrinsics.checkNotNullExpressionValue(linearLayout3, "viewBinding.sortView");
                    linearLayout3.setVisibility(0);
                }
            }
        }
    }
}
