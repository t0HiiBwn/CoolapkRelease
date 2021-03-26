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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CenterMoreEntranceViewHolder.kt */
public final class CenterMoreEntranceViewHolder extends GenericBindHolder<ItemCenterMoreEntranceBinding, HolderItem> implements CenterMoreListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558645;
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
                View inflate = LayoutInflater.from(this.this$0.getContext()).inflate(2131558646, viewGroup, false);
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

    public final void refreshDataList(List<UserMenu> list) {
        doChange(new CenterMoreEntranceViewHolder$refreshDataList$1(this, list));
    }

    /* compiled from: CenterMoreEntranceViewHolder.kt */
    public final class SimpleCallback extends ItemTouchHelper.Callback {
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        }

        public SimpleCallback() {
            CenterMoreEntranceViewHolder.this = r1;
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
