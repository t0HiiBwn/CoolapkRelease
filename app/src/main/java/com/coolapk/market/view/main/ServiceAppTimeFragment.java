package com.coolapk.market.view.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.databinding.ItemServiceAppTimeBinding;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.HolderItem;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.EntityUtils;
import com.coolapk.market.view.cardlist.EntityListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.SectionedAdapter;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H$J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002¨\u0006\u0014"}, d2 = {"Lcom/coolapk/market/view/main/ServiceAppTimeFragment;", "Lcom/coolapk/market/view/cardlist/EntityListFragment;", "()V", "getTimeDescription", "", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestResponse", "", "isRefresh", "data", "", "Lcom/coolapk/market/model/Entity;", "updateSections", "TimeAdapter", "TimeViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ServiceAppTimeFragment.kt */
public abstract class ServiceAppTimeFragment extends EntityListFragment {
    protected abstract String getTimeDescription(ServiceApp serviceApp);

    @Override // com.coolapk.market.view.cardlist.EntityListFragment, com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        BaseMultiTypeAdapter.register$default(getAdapter$presentation_coolapkAppRelease(), SimpleViewHolderFactor.Companion.withLayoutId(2131558925).suitedEntityType("holder_title").constructor(ServiceAppTimeFragment$onActivityCreated$1.INSTANCE).build(), 0, 2, null);
    }

    /* access modifiers changed from: protected */
    @Override // com.coolapk.market.view.cardlist.EntityListFragment
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        if (list != null) {
            list = updateSections(list);
        }
        return super.onRequestResponse(z, list);
    }

    private final List<Entity> updateSections(List<? extends Entity> list) {
        ServiceApp findFirstApkType;
        ArrayList arrayList = new ArrayList();
        if (getDataList().size() == 0 && (findFirstApkType = EntityUtils.findFirstApkType(list)) != null) {
            arrayList.add(HolderItem.newBuilder().entityType("holder_title").title(getTimeDescription(findFirstApkType)).build());
        }
        int i = 0;
        for (T t : list) {
            if (EntityUtils.isApkType(t.getEntityType())) {
                Objects.requireNonNull(t, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                String timeDescription = getTimeDescription(t);
                if (i == 0) {
                    Parcelable parcelable = null;
                    Parcelable findLastEntity$default = EntityListFragment.findLastEntity$default(this, "apk", false, 2, null);
                    if (findLastEntity$default instanceof ServiceApp) {
                        parcelable = findLastEntity$default;
                    }
                    ServiceApp serviceApp = (ServiceApp) parcelable;
                    if (serviceApp != null && !TextUtils.equals(getTimeDescription(serviceApp), timeDescription)) {
                        arrayList.add(HolderItem.newBuilder().entityType("holder_title").title(timeDescription).build());
                    }
                } else {
                    Entity entity = (Entity) list.get(i - 1);
                    if (EntityUtils.isApkType(entity.getEntityType())) {
                        Objects.requireNonNull(entity, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
                        if (!TextUtils.equals(getTimeDescription((ServiceApp) entity), timeDescription)) {
                            arrayList.add(HolderItem.newBuilder().entityType("holder_title").title(timeDescription).build());
                        }
                    }
                }
            }
            arrayList.add(t);
            i++;
        }
        return arrayList;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/main/ServiceAppTimeFragment$TimeAdapter;", "Lcom/coolapk/market/widget/SectionedAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "(Lcom/coolapk/market/view/main/ServiceAppTimeFragment;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "onBindSectionViewHolder", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "sectionedPosition", "", "onCreateSectionViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ServiceAppTimeFragment.kt */
    private final class TimeAdapter extends SectionedAdapter {
        final /* synthetic */ ServiceAppTimeFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimeAdapter(ServiceAppTimeFragment serviceAppTimeFragment, RecyclerView.Adapter<?> adapter) {
            super(adapter);
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.this$0 = serviceAppTimeFragment;
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public RecyclerView.ViewHolder onCreateSectionViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.this$0.getActivity()).inflate(2131558925, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new TimeViewHolder(inflate);
        }

        @Override // com.coolapk.market.widget.SectionedAdapter
        public void onBindSectionViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            Intrinsics.checkNotNullParameter(viewHolder, "holder");
            ((BindingViewHolder) viewHolder).bindTo(getSection(i).getObject());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/main/ServiceAppTimeFragment$TimeViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindTo", "", "data", "", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ServiceAppTimeFragment.kt */
    private static final class TimeViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558925;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TimeViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Intrinsics.checkNotNullParameter(obj, "data");
            ItemServiceAppTimeBinding itemServiceAppTimeBinding = (ItemServiceAppTimeBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemServiceAppTimeBinding, "binding");
            itemServiceAppTimeBinding.setTime(((HolderItem) obj).getTitle());
            itemServiceAppTimeBinding.executePendingBindings();
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/main/ServiceAppTimeFragment$TimeViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: ServiceAppTimeFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }
}
