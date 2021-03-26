package com.coolapk.market.view.feed.goods;

import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.ContextBindingComponent;
import com.coolapk.market.databinding.FeedBindGoodsMainBinding;
import com.coolapk.market.databinding.ItemBindGoodsChildBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedGoods;
import com.coolapk.market.util.ColorUtils;
import com.coolapk.market.util.DialogUtil;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.DrawSystemBarFrameLayout;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0003H\u0014J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0014J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 J\u0016\u0010!\u001a\u00020\u00122\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00120#H\u0002J \u0010$\u001a\u00020\u00122\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100&2\b\b\u0002\u0010'\u001a\u00020(H\u0002R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/FeedBindGoodsMainBinding;", "Lcom/coolapk/market/model/Feed;", "()V", "adapter", "Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$DataAdapter;", "bindingComponent", "Lcom/coolapk/market/binding/ContextBindingComponent;", "getBindingComponent", "()Lcom/coolapk/market/binding/ContextBindingComponent;", "bindingComponent$delegate", "Lkotlin/Lazy;", "data", "startDataList", "", "Lcom/coolapk/market/model/FeedGoods;", "insertFeedGoods", "", "goods", "onBindToContent", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "showAsBottomSheetDialog", "activity", "Landroid/app/Activity;", "showInViewGroup", "frameLayout", "Lcom/coolapk/market/widget/DrawSystemBarFrameLayout;", "syncGoodsData", "dismissAction", "Lkotlin/Function0;", "updateList", "dataList", "", "moveToEnd", "", "Companion", "DataAdapter", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedBindGoodsViewPart.kt */
public final class FeedBindGoodsViewPart extends BindingViewPart<FeedBindGoodsMainBinding, Feed> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558556;
    private static final FeedBindGoodsViewPart$Companion$diffCallback$1 diffCallback = new FeedBindGoodsViewPart$Companion$diffCallback$1();
    private final DataAdapter adapter = new DataAdapter();
    private final Lazy bindingComponent$delegate = LazyKt.lazy(new FeedBindGoodsViewPart$bindingComponent$2(this));
    private Feed data;
    private final List<FeedGoods> startDataList = new ArrayList();

    /* access modifiers changed from: private */
    public final ContextBindingComponent getBindingComponent() {
        return (ContextBindingComponent) this.bindingComponent$delegate.getValue();
    }

    public static final /* synthetic */ Feed access$getData$p(FeedBindGoodsViewPart feedBindGoodsViewPart) {
        Feed feed = feedBindGoodsViewPart.data;
        if (feed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        return feed;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003*\u0001\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "diffCallback", "com/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$Companion$diffCallback$1", "Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$Companion$diffCallback$1;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedBindGoodsViewPart.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public FeedBindGoodsMainBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558556, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (FeedBindGoodsMainBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        super.onViewCreated();
        int adjustAlpha = ColorUtils.adjustAlpha(AppHolder.getAppTheme().getColorAccent(), 0.1f);
        ((FeedBindGoodsMainBinding) getBinding()).manualGoodsView.setBackgroundColor(adjustAlpha);
        ((FeedBindGoodsMainBinding) getBinding()).searchGoodsView.setBackgroundColor(adjustAlpha);
        LinearLayout linearLayout = ((FeedBindGoodsMainBinding) getBinding()).containerView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.containerView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        ((FeedBindGoodsMainBinding) getBinding()).executePendingBindings();
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Feed feed) {
        Intrinsics.checkNotNullParameter(feed, "data");
        super.onBindToContent((FeedBindGoodsViewPart) feed);
        this.data = feed;
        RecyclerView recyclerView = ((FeedBindGoodsMainBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView2 = ((FeedBindGoodsMainBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView3 = ((FeedBindGoodsMainBinding) getBinding()).recyclerView;
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Application application = AppHolder.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "AppHolder.getApplication()");
        recyclerView3.addItemDecoration(companion.with(application).asSpace().size(NumberExtendsKt.getDp((Number) 16)).build());
        List<FeedGoods> list = this.startDataList;
        List<FeedGoods> includeGoods = feed.getIncludeGoods();
        Intrinsics.checkNotNullExpressionValue(includeGoods, "data.includeGoods");
        list.addAll(includeGoods);
        updateList$default(this, this.startDataList, false, 2, null);
    }

    static /* synthetic */ void updateList$default(FeedBindGoodsViewPart feedBindGoodsViewPart, List list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        feedBindGoodsViewPart.updateList(list, z);
    }

    private final void updateList(List<? extends FeedGoods> list, boolean z) {
        this.adapter.submitList(list, new FeedBindGoodsViewPart$updateList$1(this, z, list));
    }

    @Deprecated(message = "USE IN BOTTOM SHEET DIALOG MODE")
    public final void showAsBottomSheetDialog(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Function0<Unit> showBottomSheetDialog = DialogUtil.INSTANCE.showBottomSheetDialog(activity, getView(), true, true);
        ((FeedBindGoodsMainBinding) getBinding()).actionDone.setOnClickListener(new FeedBindGoodsViewPart$showAsBottomSheetDialog$1(this, showBottomSheetDialog));
        View root = ((FeedBindGoodsMainBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtents2Kt.tryListenWindowsInset(root, new FeedBindGoodsViewPart$showAsBottomSheetDialog$2(this));
        ((FeedBindGoodsMainBinding) getBinding()).searchGoodsView.setOnClickListener(new FeedBindGoodsViewPart$showAsBottomSheetDialog$3(this, showBottomSheetDialog, activity));
    }

    public final void showInViewGroup(DrawSystemBarFrameLayout drawSystemBarFrameLayout) {
        Intrinsics.checkNotNullParameter(drawSystemBarFrameLayout, "frameLayout");
        View root = ((FeedBindGoodsMainBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        ViewExtendsKt.detachFromParent(root);
        drawSystemBarFrameLayout.addView(((FeedBindGoodsMainBinding) getBinding()).getRoot());
        View root2 = ((FeedBindGoodsMainBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        ViewGroup.LayoutParams layoutParams = root2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.coolapk.market.widget.DrawSystemBarFrameLayout.LayoutParams");
        DrawSystemBarFrameLayout.LayoutParams layoutParams2 = (DrawSystemBarFrameLayout.LayoutParams) layoutParams;
        DrawSystemBarFrameLayout.LayoutParams layoutParams3 = layoutParams2;
        layoutParams3.drawNavigationBar = true;
        layoutParams3.gravity = 80;
        root2.setLayoutParams(layoutParams2);
        View root3 = ((FeedBindGoodsMainBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
        ViewExtents2Kt.tryListenWindowsInset(root3, new FeedBindGoodsViewPart$showInViewGroup$2(this));
        View root4 = ((FeedBindGoodsMainBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
        ViewExtendsKt.setTopElevation$default(root4, 0.0f, 1, null);
        ((FeedBindGoodsMainBinding) getBinding()).actionDone.setOnClickListener(new FeedBindGoodsViewPart$showInViewGroup$3(this));
        ((FeedBindGoodsMainBinding) getBinding()).searchGoodsView.setOnClickListener(new FeedBindGoodsViewPart$showInViewGroup$4(this));
        ((FeedBindGoodsMainBinding) getBinding()).manualGoodsView.setOnClickListener(new FeedBindGoodsViewPart$showInViewGroup$5(this));
    }

    /* access modifiers changed from: private */
    public final void insertFeedGoods(FeedGoods feedGoods) {
        List currentList = this.adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        List<FeedGoods> list = currentList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (FeedGoods feedGoods2 : list) {
            Intrinsics.checkNotNullExpressionValue(feedGoods2, "it");
            arrayList.add(feedGoods2.getId());
        }
        if (arrayList.contains(feedGoods.getId())) {
            Toast.show$default(getContext(), "不能重复添加好物", 0, false, 12, null);
            return;
        }
        List currentList2 = this.adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList2, "adapter.currentList");
        updateList(CollectionsKt.plus((Collection<? extends FeedGoods>) CollectionsKt.toMutableList((Collection) currentList2), feedGoods), true);
    }

    /* access modifiers changed from: private */
    public final void syncGoodsData(Function0<Unit> function0) {
        List<FeedGoods> list = this.startDataList;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().getId());
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        List currentList = this.adapter.getCurrentList();
        Intrinsics.checkNotNullExpressionValue(currentList, "adapter.currentList");
        List<FeedGoods> list2 = currentList;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (FeedGoods feedGoods : list2) {
            Intrinsics.checkNotNullExpressionValue(feedGoods, "it");
            arrayList2.add(feedGoods.getId());
        }
        String joinToString$default2 = CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
        if (Intrinsics.areEqual(joinToString$default, joinToString$default2)) {
            if (joinToString$default2.length() == 0) {
                function0.invoke();
                return;
            }
            return;
        }
        DataManager instance = DataManager.getInstance();
        Feed feed = this.data;
        if (feed == null) {
            Intrinsics.throwUninitializedPropertyAccessException("data");
        }
        instance.updateBindGoods(feed.getId(), joinToString$default2).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedBindGoodsViewPart$syncGoodsData$1(this, function0));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewPart$DataAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/coolapk/market/model/FeedGoods;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/coolapk/market/view/feed/goods/FeedBindGoodsViewPart;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: FeedBindGoodsViewPart.kt */
    private final class DataAdapter extends ListAdapter<FeedGoods, RecyclerView.ViewHolder> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
            super(FeedBindGoodsViewPart.diffCallback);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            ItemBindGoodsChildBinding itemBindGoodsChildBinding = (ItemBindGoodsChildBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), 2131558628, viewGroup, false, FeedBindGoodsViewPart.this.getBindingComponent());
            Intrinsics.checkNotNullExpressionValue(itemBindGoodsChildBinding, "binding");
            View root = itemBindGoodsChildBinding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "binding.root");
            return new FeedBindGoodsViewHolder(root, FeedBindGoodsViewPart.this.getBindingComponent());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            FeedBindGoodsViewHolder feedBindGoodsViewHolder = (FeedBindGoodsViewHolder) (!(viewHolder instanceof FeedBindGoodsViewHolder) ? null : viewHolder);
            if (feedBindGoodsViewHolder != null) {
                feedBindGoodsViewHolder.bindTo(getItem(i));
                ImageView imageView = ((ItemBindGoodsChildBinding) feedBindGoodsViewHolder.getBinding()).closeView;
                Intrinsics.checkNotNullExpressionValue(imageView, "it.binding.closeView");
                imageView.setVisibility(0);
                ((ItemBindGoodsChildBinding) feedBindGoodsViewHolder.getBinding()).closeView.setOnClickListener(new FeedBindGoodsViewPart$DataAdapter$onBindViewHolder$$inlined$let$lambda$1(this, i, viewHolder));
            }
        }
    }
}
