package com.coolapk.market.widget.multitype;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseMultiTypeAdapter.kt */
public abstract class BaseMultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final Companion Companion = new Companion(null);
    public static final int PRIORITY_HIGH = 0;
    public static final int PRIORITY_MAX = -1;
    public static final int PRIORITY_NORMAL = 1;
    private final List<ViewHolderFactor> highPriorityList = new ArrayList();
    private BindDataInterceptor interceptor;
    private final SparseArray<ViewHolderFactor> itemViewTypeMap = new SparseArray<>();
    private ViewHolderFactor matchAllFactor;
    private final List<ViewHolderFactor> maxPriorityList = new ArrayList();
    private final List<ViewHolderFactor> normalPendingList = new ArrayList();
    private final List<ViewHolderFactor> normalPriorityList = new ArrayList();
    private final SparseArray<RecyclerView.ViewHolder> prebindViewHolder = new SparseArray<>();

    public abstract Object getItem(int i);

    public final void register(ViewHolderFactor viewHolderFactor) {
        register$default(this, viewHolderFactor, 0, 2, null);
    }

    public static /* synthetic */ void register$default(BaseMultiTypeAdapter baseMultiTypeAdapter, ViewHolderFactor viewHolderFactor, int i, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                i = 1;
            }
            baseMultiTypeAdapter.register(viewHolderFactor, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    public final void register(ViewHolderFactor viewHolderFactor, int i) {
        Intrinsics.checkNotNullParameter(viewHolderFactor, "factor");
        int i2 = 0;
        if (this.itemViewTypeMap.indexOfKey(viewHolderFactor.getItemViewType()) >= 0) {
            ViewHolderFactor viewHolderFactor2 = this.itemViewTypeMap.get(viewHolderFactor.getItemViewType());
            int i3 = this.maxPriorityList.contains(viewHolderFactor2) ? -1 : 1;
            if (!this.highPriorityList.contains(viewHolderFactor2)) {
                i2 = i3;
            }
            if (i2 < i) {
                throw new RuntimeException("ViewHolderFactor 权限问题, 请检查!!!");
            }
        }
        if (i == -1) {
            this.maxPriorityList.add(viewHolderFactor);
        } else if (i == 0) {
            this.highPriorityList.add(viewHolderFactor);
        } else if (i == 1) {
            this.normalPendingList.add(viewHolderFactor);
        }
        this.itemViewTypeMap.put(viewHolderFactor.getItemViewType(), viewHolderFactor);
    }

    public final void setMatchAllFactor(ViewHolderFactor viewHolderFactor) {
        Intrinsics.checkNotNullParameter(viewHolderFactor, "factor");
        this.matchAllFactor = viewHolderFactor;
        this.itemViewTypeMap.put(viewHolderFactor.getItemViewType(), viewHolderFactor);
    }

    public final void setInterceptor(BindDataInterceptor bindDataInterceptor) {
        Intrinsics.checkNotNullParameter(bindDataInterceptor, "interceptor");
        this.interceptor = bindDataInterceptor;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (this.prebindViewHolder.indexOfKey(i) >= 0) {
            RecyclerView.ViewHolder viewHolder = this.prebindViewHolder.get(i);
            this.prebindViewHolder.remove(i);
            Intrinsics.checkNotNullExpressionValue(viewHolder, "viewHolder");
            return viewHolder;
        }
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(parent.context)");
        return this.itemViewTypeMap.get(i).onCreateViewHolder(from, viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        onBindViewHolder(viewHolder, getItem(i));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Object obj) {
        BindDataInterceptor bindDataInterceptor;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        this.itemViewTypeMap.get(viewHolder.getItemViewType()).onBindViewHolder(viewHolder, obj);
        if (viewHolder.getAdapterPosition() >= 0 && (bindDataInterceptor = this.interceptor) != null) {
            bindDataInterceptor.onBindData(viewHolder, obj);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewAttachedToWindow(viewHolder);
        BindDataInterceptor bindDataInterceptor = this.interceptor;
        if (bindDataInterceptor != null) {
            bindDataInterceptor.onViewAttachedToWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.onViewDetachedFromWindow(viewHolder);
        BindDataInterceptor bindDataInterceptor = this.interceptor;
        if (bindDataInterceptor != null) {
            bindDataInterceptor.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return getItemViewType(getItem(i));
    }

    public final int getItemViewType(Object obj) {
        for (T t : this.maxPriorityList) {
            if (t.isSuitedToViewHolder(obj)) {
                return t.getItemViewType();
            }
        }
        for (T t2 : this.highPriorityList) {
            if (t2.isSuitedToViewHolder(obj)) {
                return t2.getItemViewType();
            }
        }
        for (T t3 : this.normalPriorityList) {
            if (t3.isSuitedToViewHolder(obj)) {
                return t3.getItemViewType();
            }
        }
        for (T t4 : this.normalPendingList) {
            if (t4.isSuitedToViewHolder(obj)) {
                this.normalPriorityList.add(t4);
                this.normalPendingList.remove(t4);
                return t4.getItemViewType();
            }
        }
        ViewHolderFactor viewHolderFactor = this.matchAllFactor;
        if (viewHolderFactor != null) {
            return viewHolderFactor.getItemViewType();
        }
        throw new RuntimeException("can't find the view type for " + obj);
    }

    public final void prebindViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        int itemViewType = getItemViewType(getItem(i));
        if (this.prebindViewHolder.indexOfKey(itemViewType) < 0) {
            RecyclerView.ViewHolder createViewHolder = createViewHolder(viewGroup, itemViewType);
            Intrinsics.checkNotNullExpressionValue(createViewHolder, "createViewHolder(parent, itemViewType)");
            bindViewHolder(createViewHolder, i);
            this.prebindViewHolder.put(itemViewType, createViewHolder);
        }
    }

    /* compiled from: BaseMultiTypeAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
