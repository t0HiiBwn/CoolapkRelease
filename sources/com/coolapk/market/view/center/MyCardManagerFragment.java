package com.coolapk.market.view.center;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSimpleTitleBinding;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.CardTitleItem;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.coolapk.market.widget.touchhelper.OnStartDragListener;
import com.coolapk.market.widget.touchhelper.SimpleItemTouchHelperCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 @2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u00020\u0004:\u0002@AB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010&\u001a\u00020'H\u0002J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020'H\u0002J\u0012\u0010,\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J$\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002002\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020'H\u0016J\b\u00103\u001a\u00020)H\u0016J\u001a\u00104\u001a\u00020)2\u0006\u00101\u001a\u00020\u00122\b\u00105\u001a\u0004\u0018\u000106H\u0014J \u00107\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00122\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u0010\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\u0012H\u0014J\u000e\u0010=\u001a\u00020)2\u0006\u0010>\u001a\u00020'J\u0006\u0010?\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u000e¢\u0006\u0002\n\u0000R>\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\r@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0003`\rX\u000e¢\u0006\u0002\n\u0000R'\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010 \u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/coolapk/market/view/center/MyCardManagerFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/Entity;", "Lcom/coolapk/market/widget/touchhelper/OnStartDragListener;", "()V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "dataList", "Landroidx/databinding/ObservableArrayList;", "value", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "invisibleIdList", "setInvisibleIdList", "(Ljava/util/ArrayList;)V", "isEdited", "", "()Z", "setEdited", "(Z)V", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "list", "listCallback", "Lcom/coolapk/market/widget/AdapterListChangedCallback;", "Landroidx/databinding/ObservableList;", "getListCallback", "()Lcom/coolapk/market/widget/AdapterListChangedCallback;", "listCallback$delegate", "Lkotlin/Lazy;", "reset", "getReset", "setReset", "updateUserConfigSub", "Lrx/Subscription;", "visibleIdList", "findTargetPosition", "", "moveItem", "", "fromPosition", "toPosition", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "onDestroyView", "onRequestFailure", "error", "", "onRequestResponse", "result", "onStartDrag", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "shouldShowList", "startDrag", "position", "submitData", "Companion", "TitleViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: MyCardManagerFragment.kt */
public final class MyCardManagerFragment extends NewAsyncListFragment<List<? extends Entity>> implements OnStartDragListener {
    public static final Companion Companion = new Companion(null);
    private static final String TYPE_DIVIDER = "TYPE_DIVIDER";
    private static final String TYPE_TITLE_ADDED = "TYPE_TITLE_ADDED";
    private static final String TYPE_TITLE_NOT_ADDED = "TYPE_TITLE_NOT_ADDED";
    private MultiTypeAdapter adapter;
    private ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private ArrayList<String> invisibleIdList = new ArrayList<>();
    private boolean isEdited;
    private ItemTouchHelper itemTouchHelper;
    private ArrayList<Entity> list = new ArrayList<>();
    private final Lazy listCallback$delegate = LazyKt.lazy(new MyCardManagerFragment$listCallback$2(this));
    private boolean reset;
    private Subscription updateUserConfigSub;
    private ArrayList<String> visibleIdList = new ArrayList<>();

    private final AdapterListChangedCallback<ObservableList<Entity>> getListCallback() {
        return (AdapterListChangedCallback) this.listCallback$delegate.getValue();
    }

    @JvmStatic
    public static final MyCardManagerFragment newInstance() {
        return Companion.newInstance();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
    }

    public static final /* synthetic */ MultiTypeAdapter access$getAdapter$p(MyCardManagerFragment myCardManagerFragment) {
        MultiTypeAdapter multiTypeAdapter = myCardManagerFragment.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return multiTypeAdapter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/center/MyCardManagerFragment$Companion;", "", "()V", "TYPE_DIVIDER", "", "TYPE_TITLE_ADDED", "TYPE_TITLE_NOT_ADDED", "newInstance", "Lcom/coolapk/market/view/center/MyCardManagerFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MyCardManagerFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MyCardManagerFragment newInstance() {
            Bundle bundle = new Bundle();
            MyCardManagerFragment myCardManagerFragment = new MyCardManagerFragment();
            myCardManagerFragment.setArguments(bundle);
            return myCardManagerFragment;
        }
    }

    public final boolean isEdited() {
        return this.isEdited;
    }

    public final void setEdited(boolean z) {
        this.isEdited = z;
    }

    /* access modifiers changed from: private */
    public final void setInvisibleIdList(ArrayList<String> arrayList) {
        this.invisibleIdList = arrayList;
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter.notifyDataSetChanged();
    }

    public final boolean getReset() {
        return this.reset;
    }

    public final void setReset(boolean z) {
        this.reset = z;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipChildren(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView3.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(250);
        }
        RecyclerView recyclerView4 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView4, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator2 = recyclerView4.getItemAnimator();
        if (itemAnimator2 != null) {
            itemAnimator2.setMoveDuration(250);
        }
        RecyclerView recyclerView5 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView5, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator3 = recyclerView5.getItemAnimator();
        if (itemAnimator3 != null) {
            itemAnimator3.setAddDuration(120);
        }
        RecyclerView recyclerView6 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView6, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator4 = recyclerView6.getItemAnimator();
        if (itemAnimator4 != null) {
            itemAnimator4.setRemoveDuration(120);
        }
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.dataList);
        this.adapter = multiTypeAdapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558632).suitedMethod(MyCardManagerFragment$onActivityCreated$1.INSTANCE).constructor(new MyCardManagerFragment$onActivityCreated$2(this)).build(), 0);
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter2.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558932).suitedMethod(MyCardManagerFragment$onActivityCreated$3.INSTANCE).constructor(MyCardManagerFragment$onActivityCreated$4.INSTANCE).build(), 0);
        MultiTypeAdapter multiTypeAdapter3 = this.adapter;
        if (multiTypeAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setAdapter(multiTypeAdapter3);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        this.dataList.addOnListChangedCallback(getListCallback());
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(new SimpleItemTouchHelperCallback(new MyCardManagerFragment$onActivityCreated$callback$1(this)));
        this.itemTouchHelper = itemTouchHelper2;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper2.attachToRecyclerView(getRecyclerView());
        initData();
    }

    /* access modifiers changed from: private */
    public final void moveItem(int i, int i2) {
        synchronized (new Object()) {
            this.dataList.removeOnListChangedCallback(getListCallback());
            Collections.swap(this.dataList, i, i2);
            this.dataList.addOnListChangedCallback(getListCallback());
            Unit unit = Unit.INSTANCE;
        }
        this.isEdited = i != i2;
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter.notifyItemMoved(i, i2);
    }

    /* access modifiers changed from: private */
    public final int findTargetPosition() {
        int i = 0;
        for (Entity entity : this.dataList) {
            if ((entity instanceof HolderItem) && Intrinsics.areEqual(((HolderItem) entity).getEntityType(), "TYPE_TITLE_NOT_ADDED")) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        RxUtils.unsubscribe(this.updateUserConfigSub);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends Entity> list2) {
        if (list2 == null) {
            return true;
        }
        this.dataList.addAll(list2);
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter.notifyDataSetChanged();
        updateContentUI();
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        Observable<R> flatMap = DataManager.getInstance().myPageCardManage().compose(RxUtils.applyIOSchedulers()).flatMap(new MyCardManagerFragment$onCreateRequest$1(this));
        Intrinsics.checkNotNullExpressionValue(flatMap, "DataManager.getInstance(…t(list)\n                }");
        return flatMap;
    }

    public final String submitData() {
        int findTargetPosition = findTargetPosition();
        StringBuilder sb = new StringBuilder();
        sb.append("{\"show\":");
        sb.append("[");
        int i = 0;
        int i2 = 0;
        for (Entity entity : this.dataList) {
            if ((entity instanceof CardTitleItem) && i2 < findTargetPosition) {
                sb.append(((CardTitleItem) entity).getId());
                sb.append(",");
            }
            i2++;
        }
        if (sb.charAt(sb.length() - 1) != '[') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("],\"hide\":[");
        for (Entity entity2 : this.dataList) {
            if ((entity2 instanceof CardTitleItem) && i > findTargetPosition) {
                sb.append(((CardTitleItem) entity2).getId());
                sb.append(",");
            }
            i++;
        }
        if (sb.charAt(sb.length() - 1) != '[') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return !this.dataList.isEmpty();
    }

    @Override // com.coolapk.market.widget.touchhelper.OnStartDragListener
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        ItemTouchHelper itemTouchHelper2 = this.itemTouchHelper;
        if (itemTouchHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        }
        itemTouchHelper2.startDrag(viewHolder);
    }

    public final void startDrag(int i) {
        new MyCardManagerFragment$startDrag$1(this, i).invoke();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/center/MyCardManagerFragment$TitleViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: MyCardManagerFragment.kt */
    private static final class TitleViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558932;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TitleViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/center/MyCardManagerFragment$TitleViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: MyCardManagerFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.HolderItem");
            ItemSimpleTitleBinding itemSimpleTitleBinding = (ItemSimpleTitleBinding) getBinding();
            TextView textView = itemSimpleTitleBinding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setText(((HolderItem) obj).getTitle());
            itemSimpleTitleBinding.executePendingBindings();
        }
    }
}
