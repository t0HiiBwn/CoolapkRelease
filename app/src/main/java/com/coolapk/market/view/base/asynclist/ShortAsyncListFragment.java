package com.coolapk.market.view.base.asynclist;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b&\u0018\u0000 2*\b\b\u0000\u0010\u0001*\u00020\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003:\u00012B\u0005¢\u0006\u0002\u0010\u0005J \u0010\u001b\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001f\u0012\u0004\u0012\u00020\u001c0\u001eJ\u001f\u0010 \u001a\u0002H!\"\u0004\b\u0001\u0010!2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H!0\"¢\u0006\u0002\u0010#J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010'\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0018\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0014J \u0010-\u001a\u00020*2\u0006\u0010)\u001a\u00020*2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004H\u0014J\u0010\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020&H\u0016J\b\u00101\u001a\u00020*H\u0014R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R'\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00170\u00168FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019¨\u00063"}, d2 = {"Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment;", "DATA", "Landroid/os/Parcelable;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "()V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "getAdapter", "()Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "component", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "getComponent", "()Lcom/coolapk/market/binding/FragmentBindingComponent;", "component$delegate", "dataList", "Landroidx/databinding/ObservableArrayList;", "getDataList", "()Landroidx/databinding/ObservableArrayList;", "onListChangeCallback", "Lcom/coolapk/market/widget/AdapterListChangedCallback;", "Landroidx/databinding/ObservableList;", "getOnListChangeCallback", "()Lcom/coolapk/market/widget/AdapterListChangedCallback;", "onListChangeCallback$delegate", "changeDataListAndAutoCalculateDiff", "", "block", "Lkotlin/Function1;", "", "changeDataListWithoutChangeCallback", "T", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onRequestFailure", "isRefresh", "", "error", "", "onRequestResponse", "result", "onSaveInstanceState", "outState", "shouldShowList", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShortAsyncListFragment.kt */
public abstract class ShortAsyncListFragment<DATA extends Parcelable> extends NewAsyncListFragment<List<? extends DATA>> {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_DATA = "DATA";
    private final Lazy adapter$delegate = LazyKt.lazy(new ShortAsyncListFragment$adapter$2(this));
    private final Lazy component$delegate = LazyKt.lazy(new ShortAsyncListFragment$component$2(this));
    private final ObservableArrayList<DATA> dataList = new ObservableArrayList<>();
    private final Lazy onListChangeCallback$delegate = LazyKt.lazy(new ShortAsyncListFragment$onListChangeCallback$2(this));

    public final MultiTypeAdapter getAdapter() {
        return (MultiTypeAdapter) this.adapter$delegate.getValue();
    }

    public final FragmentBindingComponent getComponent() {
        return (FragmentBindingComponent) this.component$delegate.getValue();
    }

    public final AdapterListChangedCallback<ObservableList<DATA>> getOnListChangeCallback() {
        return (AdapterListChangedCallback) this.onListChangeCallback$delegate.getValue();
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    public /* bridge */ /* synthetic */ boolean onRequestResponse(boolean z, Object obj) {
        return onRequestResponse(z, (List) ((List) obj));
    }

    public final ObservableArrayList<DATA> getDataList() {
        return this.dataList;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(KEY_DATA);
            if (parcelableArrayList != null) {
                ArrayList arrayList = parcelableArrayList;
                if (!arrayList.isEmpty()) {
                    this.dataList.addAll(arrayList);
                }
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setLayoutManager(new LinearLayoutManager(getActivity()));
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        this.dataList.addOnListChangedCallback(getOnListChangeCallback());
        setAdapter(getAdapter());
    }

    protected boolean onRequestResponse(boolean z, List<? extends DATA> list) {
        boolean z2 = false;
        if (list != null && !list.isEmpty()) {
            if (z) {
                this.dataList.addAll(0, list);
                if (!UiUtils.canScrollDown(getRecyclerView())) {
                    getRecyclerView().smoothScrollToPosition(0);
                }
            } else {
                this.dataList.addAll(list);
            }
            z2 = true;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList(KEY_DATA, this.dataList);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/base/asynclist/ShortAsyncListFragment$Companion;", "", "()V", "KEY_DATA", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShortAsyncListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void changeDataListAndAutoCalculateDiff(Function1<? super List<DATA>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        changeDataListWithoutChangeCallback(new ShortAsyncListFragment$changeDataListAndAutoCalculateDiff$1(this, function1));
    }

    public final <T> T changeDataListWithoutChangeCallback(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.dataList.removeOnListChangedCallback(getOnListChangeCallback());
        T t = (T) function0.invoke();
        this.dataList.addOnListChangedCallback(getOnListChangeCallback());
        return t;
    }
}
