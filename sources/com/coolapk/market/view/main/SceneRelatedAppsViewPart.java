package com.coolapk.market.view.main;

import android.content.Context;
import android.content.res.ColorStateList;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemSceneRelatedBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.EntityCard;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.node.DynamicNodePageActivity;
import com.coolapk.market.viewholder.SmallScrollCardItemViewHolder;
import com.coolapk.market.viewholder.iview.BindingViewPart;
import com.coolapk.market.widget.ActionButton;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0019\u001a\u001b\u001cB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H\u0014J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u000eH\u0014R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart;", "Lcom/coolapk/market/viewholder/iview/BindingViewPart;", "Lcom/coolapk/market/databinding/ItemSceneRelatedBinding;", "Lcom/coolapk/market/model/Entity;", "component", "Landroidx/databinding/DataBindingComponent;", "isDark", "", "(Landroidx/databinding/DataBindingComponent;Z)V", "adapter", "Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart$AppsAdapter;", "card", "Lcom/coolapk/market/model/EntityCard;", "onBindToContent", "", "data", "onClick", "v", "Landroid/view/View;", "onCreateBinding", "inflater", "Landroid/view/LayoutInflater;", "viewGroup", "Landroid/view/ViewGroup;", "onViewCreated", "AppsAdapter", "Companion", "MyDiffCallback", "MySmallScrollCardItemViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SceneRelatedAppsHelper.kt */
public final class SceneRelatedAppsViewPart extends BindingViewPart<ItemSceneRelatedBinding, Entity> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558903;
    private final AppsAdapter adapter;
    private EntityCard card;
    private final DataBindingComponent component;
    private final boolean isDark;

    public SceneRelatedAppsViewPart(DataBindingComponent dataBindingComponent, boolean z) {
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        this.component = dataBindingComponent;
        this.isDark = z;
        this.adapter = new AppsAdapter();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SceneRelatedAppsViewPart(DataBindingComponent dataBindingComponent, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dataBindingComponent, (i & 2) != 0 ? false : z);
    }

    public static final /* synthetic */ EntityCard access$getCard$p(SceneRelatedAppsViewPart sceneRelatedAppsViewPart) {
        EntityCard entityCard = sceneRelatedAppsViewPart.card;
        if (entityCard == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        return entityCard;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SceneRelatedAppsHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.viewholder.iview.BindingViewPart
    public ItemSceneRelatedBinding onCreateBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131558903, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "DataBindingUtil.inflate(…OUT_ID, viewGroup, false)");
        return (ItemSceneRelatedBinding) inflate;
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart
    protected void onViewCreated() {
        BaseMultiTypeAdapter.register$default(this.adapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558935).suitedClass(ServiceApp.class).constructor(new SceneRelatedAppsViewPart$onViewCreated$1(this)).build(), 0, 2, null);
        RecyclerView recyclerView = ((ItemSceneRelatedBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        recyclerView.setAdapter(this.adapter);
        RecyclerView recyclerView2 = ((ItemSceneRelatedBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.recyclerView");
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView recyclerView3 = ((ItemSceneRelatedBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.recyclerView");
        recyclerView3.setItemAnimator(null);
        if (this.isDark) {
            ((ItemSceneRelatedBinding) getBinding()).itemView.setBackgroundResource(2131100008);
            ((ItemSceneRelatedBinding) getBinding()).titleView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131100147));
            ImageView imageView = ((ItemSceneRelatedBinding) getBinding()).closeView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeView");
            imageView.setImageTintList(ColorStateList.valueOf(ResourceUtils.getColorInt(getContext(), 2131100149)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart$MyDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldData", "", "Lcom/coolapk/market/model/Entity;", "newData", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SceneRelatedAppsHelper.kt */
    private static final class MyDiffCallback extends DiffUtil.Callback {
        private final List<Entity> newData;
        private final List<Entity> oldData;

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areContentsTheSame(int i, int i2) {
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.coolapk.market.model.Entity> */
        /* JADX WARN: Multi-variable type inference failed */
        public MyDiffCallback(List<? extends Entity> list, List<? extends Entity> list2) {
            Intrinsics.checkNotNullParameter(list, "oldData");
            Intrinsics.checkNotNullParameter(list2, "newData");
            this.oldData = list;
            this.newData = list2;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public boolean areItemsTheSame(int i, int i2) {
            return Intrinsics.areEqual(EntityExtendsKt.entityUniqueId(this.oldData.get(i)), EntityExtendsKt.entityUniqueId(this.newData.get(i2)));
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getOldListSize() {
            return this.oldData.size();
        }

        @Override // androidx.recyclerview.widget.DiffUtil.Callback
        public int getNewListSize() {
            return this.newData.size();
        }
    }

    @Override // com.coolapk.market.viewholder.iview.ViewPart, android.view.View.OnClickListener
    public void onClick(View view) {
        ViewParent parent;
        ViewParent parent2;
        Intrinsics.checkNotNullParameter(view, "v");
        if (view.getId() == 2131362257) {
            LinearLayout linearLayout = ((ItemSceneRelatedBinding) getBinding()).itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            ViewParent parent3 = linearLayout.getParent();
            ViewGroup viewGroup = null;
            if (!(parent3 instanceof ViewGroup)) {
                parent3 = null;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent3;
            if (this.isDark) {
                ViewParent parent4 = viewGroup2 != null ? viewGroup2.getParent() : null;
                if (parent4 instanceof ViewGroup) {
                    viewGroup = parent4;
                }
                TransitionManager.beginDelayedTransition((ViewGroup) viewGroup);
            } else {
                ViewParent parent5 = (viewGroup2 == null || (parent = viewGroup2.getParent()) == null || (parent2 = parent.getParent()) == null) ? null : parent2.getParent();
                if (parent5 instanceof ViewGroup) {
                    viewGroup = parent5;
                }
                ViewGroup viewGroup3 = viewGroup;
                if (viewGroup3 != null) {
                    TransitionManager.beginDelayedTransition(viewGroup3);
                }
            }
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0014J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart$MySmallScrollCardItemViewHolder;", "Lcom/coolapk/market/viewholder/SmallScrollCardItemViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "isDark", "", "(Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Z)V", "()Z", "bindTo", "", "data", "", "onBindWithApp", "onClick", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SceneRelatedAppsHelper.kt */
    private final class MySmallScrollCardItemViewHolder extends SmallScrollCardItemViewHolder {
        private final boolean isDark;
        final /* synthetic */ SceneRelatedAppsViewPart this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MySmallScrollCardItemViewHolder(SceneRelatedAppsViewPart sceneRelatedAppsViewPart, View view, DataBindingComponent dataBindingComponent, boolean z) {
            super(view, dataBindingComponent);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
            this.this$0 = sceneRelatedAppsViewPart;
            this.isDark = z;
        }

        public final boolean isDark() {
            return this.isDark;
        }

        @Override // com.coolapk.market.viewholder.SmallScrollCardItemViewHolder, com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            setParentCard(SceneRelatedAppsViewPart.access$getCard$p(this.this$0));
            super.bindTo(obj);
            if (this.isDark) {
                getBinding().titleView.setTextColor(ResourceUtils.getColorInt(getContext(), 2131100147));
                ActionButton.setButtonStyle$default(getBinding().actionContainer, 2, false, 2, null);
            }
        }

        @Override // com.coolapk.market.viewholder.SmallScrollCardItemViewHolder
        protected void onBindWithApp() {
            ServiceApp serviceApp = getServiceApp();
            if (serviceApp != null) {
                ActionButton.bindWithApp$default(getBinding().actionContainer, serviceApp, false, 2, null);
            }
        }

        @Override // com.coolapk.market.viewholder.SmallScrollCardItemViewHolder, com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            int id = view.getId();
            if (id == 2131361886) {
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                if (UiUtils.getActivityNullable(context) instanceof DynamicNodePageActivity) {
                    StatisticHelper.Companion.getInstance().recordSceneRelatedClickAction("详情页_推荐下载_点击下载");
                } else {
                    StatisticHelper.Companion.getInstance().recordSceneRelatedClickAction("列表_推荐下载_点击下载");
                }
            } else if (id != 2131362768) {
                super.onClick(view);
            } else {
                Context context2 = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "view.context");
                if (UiUtils.getActivityNullable(context2) instanceof DynamicNodePageActivity) {
                    StatisticHelper.Companion.getInstance().recordSceneRelatedClickAction("详情页_推荐下载_进详情页");
                } else {
                    StatisticHelper.Companion.getInstance().recordSceneRelatedClickAction("列表_推荐下载_进详情页");
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/main/SceneRelatedAppsViewPart$AppsAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "()V", "dataList", "", "Lcom/coolapk/market/model/Entity;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SceneRelatedAppsHelper.kt */
    private static final class AppsAdapter extends BaseMultiTypeAdapter {
        private List<? extends Entity> dataList;

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.coolapk.market.model.Entity>, java.util.List<com.coolapk.market.model.Entity> */
        public final List<Entity> getDataList() {
            return this.dataList;
        }

        public final void setDataList(List<? extends Entity> list) {
            this.dataList = list;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            List<? extends Entity> list = this.dataList;
            if (list != null) {
                return (Entity) list.get(i);
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends Entity> list = this.dataList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onBindToContent(Entity entity) {
        Intrinsics.checkNotNullParameter(entity, "data");
        EntityCard entityCard = (EntityCard) (!(entity instanceof EntityCard) ? null : entity);
        Intrinsics.checkNotNull(entityCard);
        this.card = entityCard;
        List<Entity> dataList = this.adapter.getDataList();
        if (dataList == null) {
            dataList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(dataList);
        EntityCard entityCard2 = this.card;
        if (entityCard2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("card");
        }
        List<Entity> entities = entityCard2.getEntities();
        if (entities == null) {
            entities = CollectionsKt.emptyList();
        }
        ArrayList arrayList2 = new ArrayList(entities);
        this.adapter.setDataList(arrayList2);
        DiffUtil.calculateDiff(new MyDiffCallback(arrayList, arrayList2)).dispatchUpdatesTo(this.adapter);
        TextView textView = ((ItemSceneRelatedBinding) getBinding()).titleView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
        textView.setText(entity.getTitle());
        ((ItemSceneRelatedBinding) getBinding()).executePendingBindings();
        ImageView imageView = ((ItemSceneRelatedBinding) getBinding()).closeView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.closeView");
        ViewUtil.clickListener(imageView, this);
        Context context = getView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (UiUtils.getActivityNullable(context) instanceof DynamicNodePageActivity) {
            StatisticHelper.Companion.getInstance().recordSceneRelatedClickAction("详情页_cardshow");
        } else {
            StatisticHelper.Companion.getInstance().recordSceneRelatedClickAction("列表_cardshow");
        }
    }
}
