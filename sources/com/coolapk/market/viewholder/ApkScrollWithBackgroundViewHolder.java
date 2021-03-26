package com.coolapk.market.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.databinding.DataBindingComponent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.coolapk.market.databinding.ItemApkScrollWithBackgroundBinding;
import com.coolapk.market.databinding.ItemSpaceBinding;
import com.coolapk.market.databinding.ItemTitleViewBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.viewholder.TitleViewPart;
import com.coolapk.market.widget.LinearEdgeDecoration;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0004)*+,B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020&H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n \u000b*\u0004\u0018\u00010\u00130\u0013X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "binding", "Lcom/coolapk/market/databinding/ItemApkScrollWithBackgroundBinding;", "kotlin.jvm.PlatformType", "card", "Lcom/coolapk/market/model/EntityCard;", "dataList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "holderItem", "Lcom/coolapk/market/model/HolderItem;", "onScrollListener", "Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder$MyOnScrollListener;", "startPadding", "", "viewPart", "Lcom/coolapk/market/viewholder/TitleViewPart;", "bindTo", "", "data", "", "createMaskBackground", "Landroid/graphics/drawable/Drawable;", "onStateEventChanged", "", "event", "Lcom/coolapk/market/event/Event;", "setImageViewOffset", "offset", "", "setMaskViewAlpha", "alpha", "Companion", "MyOnScrollListener", "MySmallScrollCardItemViewHolder", "SpaceViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ApkScrollWithBackgroundViewHolder.kt */
public final class ApkScrollWithBackgroundViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558592;
    private final MultiTypeAdapter adapter;
    private final ItemApkScrollWithBackgroundBinding binding;
    private EntityCard card;
    private final ArrayList<Entity> dataList;
    private final HolderItem holderItem;
    private final MyOnScrollListener onScrollListener;
    private int startPadding = NumberExtendsKt.getDp((Number) 120);
    private final TitleViewPart viewPart;

    public static final /* synthetic */ EntityCard access$getCard$p(ApkScrollWithBackgroundViewHolder apkScrollWithBackgroundViewHolder) {
        EntityCard entityCard = apkScrollWithBackgroundViewHolder.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApkScrollWithBackgroundViewHolder(View view, final DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        ItemApkScrollWithBackgroundBinding itemApkScrollWithBackgroundBinding = (ItemApkScrollWithBackgroundBinding) getBinding();
        this.binding = itemApkScrollWithBackgroundBinding;
        ArrayList<Entity> arrayList = new ArrayList<>();
        this.dataList = arrayList;
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(arrayList);
        this.adapter = multiTypeAdapter;
        this.holderItem = HolderItem.newBuilder().entityType("holder_space").build();
        TitleViewPart.Companion companion = TitleViewPart.Companion;
        RecyclerView recyclerView = itemApkScrollWithBackgroundBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.listView");
        this.viewPart = companion.newInstance(recyclerView, this);
        MyOnScrollListener myOnScrollListener = new MyOnScrollListener();
        this.onScrollListener = myOnScrollListener;
        RecyclerView recyclerView2 = itemApkScrollWithBackgroundBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.listView");
        recyclerView2.setNestedScrollingEnabled(false);
        RecyclerView recyclerView3 = itemApkScrollWithBackgroundBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.listView");
        recyclerView3.setItemAnimator(null);
        RecyclerView recyclerView4 = itemApkScrollWithBackgroundBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "binding.listView");
        recyclerView4.setAdapter(multiTypeAdapter);
        RecyclerView recyclerView5 = itemApkScrollWithBackgroundBinding.listView;
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "binding.listView");
        recyclerView5.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        GravitySnapHelper gravitySnapHelper = new GravitySnapHelper(8388611);
        gravitySnapHelper.setSnapToPadding(true);
        gravitySnapHelper.attachToRecyclerView(itemApkScrollWithBackgroundBinding.listView);
        itemApkScrollWithBackgroundBinding.listView.addOnScrollListener(myOnScrollListener);
        itemApkScrollWithBackgroundBinding.listView.addItemDecoration(new LinearEdgeDecoration(this.startPadding, 0, 0, false, 8, null));
        BaseMultiTypeAdapter.register$default(multiTypeAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558944).suitedClass(HolderItem.class).constructor(AnonymousClass1.INSTANCE).build(), 0, 2, null);
        BaseMultiTypeAdapter.register$default(multiTypeAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558942).suitedClass(ServiceApp.class).constructor(new Function1<View, RecyclerView.ViewHolder>(this) {
            /* class com.coolapk.market.viewholder.ApkScrollWithBackgroundViewHolder.AnonymousClass2 */
            final /* synthetic */ ApkScrollWithBackgroundViewHolder this$0;

            {
                this.this$0 = r1;
            }

            public final RecyclerView.ViewHolder invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                return new MySmallScrollCardItemViewHolder(this.this$0, view, dataBindingComponent);
            }
        }).build(), 0, 2, null);
        int appScreenWidth = ScreenUtils.getAppScreenWidth();
        ImageView imageView = itemApkScrollWithBackgroundBinding.backgroundImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backgroundImageView");
        ImageView imageView2 = imageView;
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = appScreenWidth + NumberExtendsKt.getDp((Number) 20);
            imageView2.setLayoutParams(layoutParams);
            itemApkScrollWithBackgroundBinding.maskView.setImageDrawable(createMaskBackground());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ApkScrollWithBackgroundViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        this.card = (EntityCard) obj;
        this.dataList.clear();
        this.dataList.add(this.holderItem);
        ArrayList<Entity> arrayList = this.dataList;
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        Intrinsics.checkNotNull(entities);
        arrayList.addAll(entities);
        this.adapter.notifyDataSetChanged();
        TitleViewPart titleViewPart = this.viewPart;
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        titleViewPart.bindToContent(entityCard2);
        ItemApkScrollWithBackgroundBinding itemApkScrollWithBackgroundBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemApkScrollWithBackgroundBinding, "binding");
        EntityCard entityCard3 = this.card;
        if (entityCard3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        itemApkScrollWithBackgroundBinding.setCard(entityCard3);
        this.binding.executePendingBindings();
        ((ItemTitleViewBinding) this.viewPart.getBinding()).titleView.setTextColor(-1);
        EntityCard entityCard4 = this.card;
        if (entityCard4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        int dp = NumberExtendsKt.getDp(Integer.valueOf(EntityExtendsKt.getIntExtraData(entityCard4, "cardContainerPaddingLeft", 120)));
        if (this.startPadding != dp) {
            this.startPadding = dp;
            this.binding.listView.removeItemDecorationAt(0);
            this.binding.listView.addItemDecoration(new LinearEdgeDecoration(dp, 0, 0, false, 8, null));
        }
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        boolean z;
        Intrinsics.checkNotNullParameter(event, "event");
        EntityCard entityCard = this.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard.getEntities();
        if (entities != null) {
            List<Entity> list = entities;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    Objects.requireNonNull(next, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                    if (StateViewHolder.isEventBelongTo(event, (ServiceApp) next)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void setMaskViewAlpha(float f) {
        ImageView imageView = this.binding.maskView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.maskView");
        Drawable drawable = imageView.getDrawable();
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) drawable).setColors(new int[]{ColorUtils.setAlphaComponent(-16777216, (int) (((float) 255) * f)), -16777216});
        this.binding.maskView.postInvalidate();
    }

    /* access modifiers changed from: private */
    public final void setImageViewOffset(float f) {
        ImageView imageView = this.binding.backgroundImageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.backgroundImageView");
        imageView.setTranslationX(f);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder$SpaceViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ApkScrollWithBackgroundViewHolder.kt */
    private static final class SpaceViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558944;

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SpaceViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            Space space = ((ItemSpaceBinding) getBinding()).spaceView;
            Intrinsics.checkNotNullExpressionValue(space, "spaceView");
            Space space2 = space;
            ViewGroup.LayoutParams layoutParams = space2.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = NumberExtendsKt.getDp((Number) 0);
                layoutParams.height = NumberExtendsKt.getDp((Number) 0);
                space2.setLayoutParams(layoutParams);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder$SpaceViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ApkScrollWithBackgroundViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder$MySmallScrollCardItemViewHolder;", "Lcom/coolapk/market/viewholder/SmallScrollCardItemViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder;Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "bindTo", "", "data", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ApkScrollWithBackgroundViewHolder.kt */
    private final class MySmallScrollCardItemViewHolder extends SmallScrollCardItemViewHolder {
        final /* synthetic */ ApkScrollWithBackgroundViewHolder this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MySmallScrollCardItemViewHolder(ApkScrollWithBackgroundViewHolder apkScrollWithBackgroundViewHolder, View view, DataBindingComponent dataBindingComponent) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.this$0 = apkScrollWithBackgroundViewHolder;
        }

        @Override // com.coolapk.market.viewholder.SmallScrollCardItemViewHolder, com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            setParentCard(ApkScrollWithBackgroundViewHolder.access$getCard$p(this.this$0));
            setParentViewHolder(this.this$0);
            super.bindTo(obj);
            getBinding().titleView.setTextColor(-1);
            getBinding().infoView.setTextColor(-1);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder$MyOnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "(Lcom/coolapk/market/viewholder/ApkScrollWithBackgroundViewHolder;)V", "maxAlpha", "", "maxDistance", "maxImageOffset", "minAlpha", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ApkScrollWithBackgroundViewHolder.kt */
    private final class MyOnScrollListener extends RecyclerView.OnScrollListener {
        private final float maxAlpha = 0.8f;
        private final float maxDistance = NumberExtendsKt.getDpf((Number) 120);
        private final float maxImageOffset = NumberExtendsKt.getDpf((Number) -20);
        private final float minAlpha = 0.5f;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public MyOnScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i, i2);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition == 0 || findFirstVisibleItemPosition == 1) {
                View childAt = recyclerView.getChildAt(0);
                Intrinsics.checkNotNullExpressionValue(childAt, "recyclerView.getChildAt(0)");
                float clamp = ((float) 1) - MathUtils.clamp(((float) childAt.getLeft()) / this.maxDistance, 0.0f, 1.0f);
                float f = this.maxAlpha;
                ApkScrollWithBackgroundViewHolder.this.setMaskViewAlpha(MathUtils.clamp(clamp * f, this.minAlpha, f));
                ApkScrollWithBackgroundViewHolder.this.setImageViewOffset(clamp * this.maxImageOffset);
                return;
            }
            ApkScrollWithBackgroundViewHolder.this.setMaskViewAlpha(this.maxAlpha);
            ApkScrollWithBackgroundViewHolder.this.setImageViewOffset(this.maxImageOffset);
        }
    }

    private final Drawable createMaskBackground() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{ColorUtils.setAlphaComponent(-16777216, (int) 127.5f), -16777216});
        return gradientDrawable;
    }
}
