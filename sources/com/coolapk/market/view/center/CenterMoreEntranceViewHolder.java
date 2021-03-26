package com.coolapk.market.view.center;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemCenterMoreEntranceBinding;
import com.coolapk.market.extend.ViewExtendsKt;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.widget.SimpleDiffCallback;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002\"#B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0003H\u0016J\u0014\u0010\u0017\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u0019J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0016J\u0016\u0010 \u001a\u00020\u00152\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001fH\u0002J\b\u0010!\u001a\u00020\u0015H\u0002R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreEntranceViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCenterMoreEntranceBinding;", "Lcom/coolapk/market/model/HolderItem;", "Lcom/coolapk/market/view/center/CenterMoreListener;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/center/CenterMorePresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/center/CenterMorePresenter;)V", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/center/CenterMoreEntranceChildViewHolder;", "getPresenter", "()Lcom/coolapk/market/view/center/CenterMorePresenter;", "userMenuList", "Landroidx/databinding/ObservableArrayList;", "Lcom/coolapk/market/view/center/UserMenu;", "bindToContent", "", "data", "doChange", "changeDataListAction", "Lkotlin/Function0;", "onEditModeChange", "isEditMode", "", "onUserMenuListChanged", "menuList", "", "refreshDataList", "setActionViewUI", "Companion", "SimpleCallback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CenterMoreEntranceViewHolder.kt */
public final class CenterMoreEntranceViewHolder extends GenericBindHolder<ItemCenterMoreEntranceBinding, HolderItem> implements CenterMoreListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558639;
    private RecyclerView.Adapter<CenterMoreEntranceChildViewHolder> adapter;
    private final CenterMorePresenter presenter;
    private final ObservableArrayList<UserMenu> userMenuList = new ObservableArrayList<>();

    public final CenterMorePresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CenterMoreEntranceViewHolder(View view, final DataBindingComponent dataBindingComponent, CenterMorePresenter centerMorePresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(centerMorePresenter, "presenter");
        this.presenter = centerMorePresenter;
        InternalRecyclerView internalRecyclerView = ((ItemCenterMoreEntranceBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(internalRecyclerView, "binding.recyclerView");
        internalRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 4));
        this.adapter = new RecyclerView.Adapter<CenterMoreEntranceChildViewHolder>(this) {
            /* class com.coolapk.market.view.center.CenterMoreEntranceViewHolder.AnonymousClass1 */
            final /* synthetic */ CenterMoreEntranceViewHolder this$0;

            {
                this.this$0 = r1;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public CenterMoreEntranceChildViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
                Intrinsics.checkNotNullParameter(viewGroup, "parent");
                View inflate = LayoutInflater.from(this.this$0.getContext()).inflate(2131558640, viewGroup, false);
                Intrinsics.checkNotNullExpressionValue(inflate, "view");
                return new CenterMoreEntranceChildViewHolder(inflate, dataBindingComponent, this.this$0.getPresenter());
            }

            @Override // androidx.recyclerview.widget.RecyclerView.Adapter
            public int getItemCount() {
                return this.this$0.userMenuList.size();
            }

            public void onBindViewHolder(CenterMoreEntranceChildViewHolder centerMoreEntranceChildViewHolder, int i) {
                Intrinsics.checkNotNullParameter(centerMoreEntranceChildViewHolder, "holder");
                centerMoreEntranceChildViewHolder.bindTo(this.this$0.userMenuList.get(i));
            }
        };
        InternalRecyclerView internalRecyclerView2 = ((ItemCenterMoreEntranceBinding) getBinding()).recyclerView;
        Intrinsics.checkNotNullExpressionValue(internalRecyclerView2, "binding.recyclerView");
        internalRecyclerView2.setAdapter(this.adapter);
        ((ItemCenterMoreEntranceBinding) getBinding()).recyclerView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {
            /* class com.coolapk.market.view.center.CenterMoreEntranceViewHolder.AnonymousClass2 */
            final /* synthetic */ CenterMoreEntranceViewHolder this$0;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.this$0 = r1;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                this.this$0.getPresenter().addCenterMoreListener(this.this$0);
                CenterMoreEntranceViewHolder centerMoreEntranceViewHolder = this.this$0;
                centerMoreEntranceViewHolder.refreshDataList(centerMoreEntranceViewHolder.getPresenter().getEditingMenuList());
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                this.this$0.getPresenter().removeCenterMoreListener(this.this$0);
            }
        });
        TextView textView = ((ItemCenterMoreEntranceBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        ViewExtendsKt.setUtilClickListener(textView, new Function1<View, Unit>(this) {
            /* class com.coolapk.market.view.center.CenterMoreEntranceViewHolder.AnonymousClass3 */
            final /* synthetic */ CenterMoreEntranceViewHolder this$0;

            {
                this.this$0 = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke(view);
                return Unit.INSTANCE;
            }

            public final void invoke(View view) {
                Intrinsics.checkNotNullParameter(view, "it");
                if (this.this$0.getPresenter().isEditing()) {
                    this.this$0.getPresenter().requestEditModeFinish(this.this$0.userMenuList);
                } else {
                    this.this$0.getPresenter().requestEditModeStart();
                }
            }
        });
        new ItemTouchHelper(new SimpleCallback()).attachToRecyclerView(((ItemCenterMoreEntranceBinding) getBinding()).recyclerView);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreEntranceViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterMoreEntranceViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(HolderItem holderItem) {
        Intrinsics.checkNotNullParameter(holderItem, "data");
        refreshDataList(this.presenter.getEditingMenuList());
        setActionViewUI();
        ((ItemCenterMoreEntranceBinding) getBinding()).executePendingBindings();
    }

    private final void setActionViewUI() {
        int colorAccent = AppHolder.getAppTheme().getColorAccent();
        TextView textView = ((ItemCenterMoreEntranceBinding) getBinding()).actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setText(this.presenter.isEditing() ? "完成" : "编辑");
        ((ItemCenterMoreEntranceBinding) getBinding()).actionView.setTextColor(colorAccent);
    }

    @Override // com.coolapk.market.view.center.CenterMoreListener
    public void onEditModeChange(boolean z) {
        this.adapter.notifyDataSetChanged();
        setActionViewUI();
    }

    @Override // com.coolapk.market.view.center.CenterMoreListener
    public void onUserMenuListChanged(List<UserMenu> list) {
        Intrinsics.checkNotNullParameter(list, "menuList");
        refreshDataList(list);
    }

    /* access modifiers changed from: private */
    public final void refreshDataList(List<UserMenu> list) {
        doChange(new CenterMoreEntranceViewHolder$refreshDataList$1(this, list));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0016¨\u0006\u0016"}, d2 = {"Lcom/coolapk/market/view/center/CenterMoreEntranceViewHolder$SimpleCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "(Lcom/coolapk/market/view/center/CenterMoreEntranceViewHolder;)V", "clearView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "doMoveAction", "fromPosition", "", "toPosition", "getMovementFlags", "isLongPressDragEnabled", "", "onMove", "target", "onSelectedChanged", "actionState", "onSwiped", "direction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CenterMoreEntranceViewHolder.kt */
    public final class SimpleCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public SimpleCallback() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(viewHolder2, "target");
            doMoveAction(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
            super.onSelectedChanged(viewHolder, i);
            if (viewHolder instanceof CenterMoreEntranceChildViewHolder) {
                ((CenterMoreEntranceChildViewHolder) viewHolder).onDragSelected();
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            super.clearView(recyclerView, viewHolder);
            if (viewHolder instanceof CenterMoreEntranceChildViewHolder) {
                ((CenterMoreEntranceChildViewHolder) viewHolder).onDragClear();
                CenterMoreEntranceViewHolder.this.getPresenter().requestSaveEditingOrder(CenterMoreEntranceViewHolder.this.userMenuList);
            }
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return !((ItemCenterMoreEntranceBinding) CenterMoreEntranceViewHolder.this.getBinding()).recyclerView.isDisallowTouchEvent();
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeMovementFlags(15, 0);
        }

        private final void doMoveAction(int i, int i2) {
            CenterMoreEntranceViewHolder.this.doChange(new CenterMoreEntranceViewHolder$SimpleCallback$doMoveAction$1(this, i, i2));
        }
    }

    public final void doChange(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "changeDataListAction");
        ObservableArrayList<UserMenu> observableArrayList = this.userMenuList;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(observableArrayList);
        function0.invoke();
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new SimpleDiffCallback(arrayList, observableArrayList), true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(S…ldState, dataList), true)");
        calculateDiff.dispatchUpdatesTo(this.adapter);
    }
}
