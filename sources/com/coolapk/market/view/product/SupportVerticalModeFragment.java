package com.coolapk.market.view.product;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.model.Entity;
import com.coolapk.market.view.cardlist.EntityListFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\u0010\u001a\u00020\u0005H&J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J \u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\rH\u0014J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0004J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/coolapk/market/view/product/SupportVerticalModeFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "Lcom/coolapk/market/view/product/ISupportDisplayVerticalModeFragment;", "()V", "isDisplayInVerticalMode", "", "loadedDataList", "Ljava/util/ArrayList;", "Lcom/coolapk/market/model/Entity;", "Lkotlin/collections/ArrayList;", "getLoadedDataList", "()Ljava/util/ArrayList;", "convertToBrandProductData", "", "Landroid/os/Parcelable;", "data", "verticalModel", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onRequestResponse", "isRefresh", "onSaveInstanceState", "outState", "requestLoadedDataListChanged", "setDisplayInVerticalMode", "isVertical", "force", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SupportVerticalModeFragment.kt */
public abstract class SupportVerticalModeFragment extends EntityListFragment implements ISupportDisplayVerticalModeFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_DATA_LIST = "EXTRA_DATA_LIST";
    private static final String EXTRA_VERTICAL_MODEL = "EXTRA_VERTICAL_MODE";
    private boolean isDisplayInVerticalMode;
    private final ArrayList<Entity> loadedDataList = new ArrayList<>();

    public abstract List<Parcelable> convertToBrandProductData(List<? extends Entity> list, boolean z);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/coolapk/market/view/product/SupportVerticalModeFragment$Companion;", "", "()V", "EXTRA_DATA_LIST", "", "EXTRA_VERTICAL_MODEL", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SupportVerticalModeFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    protected final ArrayList<Entity> getLoadedDataList() {
        return this.loadedDataList;
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.isDisplayInVerticalMode = bundle.getBoolean("EXTRA_VERTICAL_MODE", this.isDisplayInVerticalMode);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("EXTRA_DATA_LIST");
            if (parcelableArrayList != null) {
                this.loadedDataList.addAll(parcelableArrayList);
            }
        }
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("EXTRA_VERTICAL_MODE", this.isDisplayInVerticalMode);
        bundle.putParcelableArrayList("EXTRA_DATA_LIST", this.loadedDataList);
    }

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getMainBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        ViewExtents2Kt.tryListenWindowsInset(recyclerView, new SupportVerticalModeFragment$onActivityCreated$1(this));
        initData();
    }

    protected final void requestLoadedDataListChanged() {
        changeDataListAndAutoCalculateDiff(new SupportVerticalModeFragment$requestLoadedDataListChanged$1(this));
    }

    @Override // com.coolapk.market.view.product.ISupportDisplayVerticalModeFragment
    public void setDisplayInVerticalMode(boolean z, boolean z2) {
        if (this.isDisplayInVerticalMode != z || z2) {
            this.isDisplayInVerticalMode = z;
            if (!this.loadedDataList.isEmpty()) {
                requestLoadedDataListChanged();
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        changeDataListAndAutoCalculateDiff(new SupportVerticalModeFragment$onRequestResponse$1(this, z, list, booleanRef));
        return booleanRef.element;
    }
}
