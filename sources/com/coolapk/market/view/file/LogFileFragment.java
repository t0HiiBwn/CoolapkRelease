package com.coolapk.market.view.file;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemLogFileBinding;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import java.io.File;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J \u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/coolapk/market/view/file/LogFileFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Ljava/io/File;", "()V", "adapter", "Lcom/coolapk/market/view/file/LogFileFragment$DataAdapter;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "", "page", "", "onRequestFailure", "error", "", "onRequestResponse", "result", "shouldShowList", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LogFileFragment.kt */
public final class LogFileFragment extends NewAsyncListFragment<List<? extends File>> {
    private final DataAdapter adapter = new DataAdapter();

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        List<File> dataList = this.adapter.getDataList();
        return dataList != null && (dataList.isEmpty() ^ true);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        setEmptyData(getString(2131886764), 0);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView2.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator);
        Intrinsics.checkNotNullExpressionValue(itemAnimator, "recyclerView.itemAnimator!!");
        itemAnimator.setChangeDuration(0);
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView3 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "recyclerView");
        recyclerView3.setAdapter(this.adapter);
        BaseMultiTypeAdapter.register$default(this.adapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558814).constructor(LogFileFragment$onActivityCreated$1.INSTANCE).suitedMethod(LogFileFragment$onActivityCreated$2.INSTANCE).build(), 0, 2, null);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<File>> onCreateRequest(boolean z, int i) {
        File externalFilesDir = requireActivity().getExternalFilesDir("log");
        if (externalFilesDir != null) {
            Observable<List<File>> map = Observable.just(externalFilesDir).map(new LogFileFragment$onCreateRequest$1(externalFilesDir));
            Intrinsics.checkNotNullExpressionValue(map, "Observable.just(dir)\n   …())\n                    }");
            return map;
        }
        Observable<List<File>> empty = Observable.empty();
        Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
        return empty;
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends File> list) {
        this.adapter.setDataList(list);
        this.adapter.notifyDataSetChanged();
        updateContentUI();
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/file/LogFileFragment$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemLogFileBinding;", "kotlin.jvm.PlatformType", "file", "Ljava/io/File;", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LogFileFragment.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558814;
        private final ItemLogFileBinding binding;
        private File file;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemLogFileBinding itemLogFileBinding = (ItemLogFileBinding) getBinding();
            this.binding = itemLogFileBinding;
            Intrinsics.checkNotNullExpressionValue(itemLogFileBinding, "binding");
            itemLogFileBinding.getRoot().setOnClickListener(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/file/LogFileFragment$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: LogFileFragment.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.io.File");
            this.file = (File) obj;
            TextView textView = this.binding.textView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.textView");
            File file2 = this.file;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("file");
            }
            textView.setText(file2.getName());
            this.binding.executePendingBindings();
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            Context context = view.getContext();
            File file2 = this.file;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("file");
            }
            ActionManager.sendLogFile(context, file2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/file/LogFileFragment$DataAdapter;", "Lcom/coolapk/market/widget/multitype/BaseMultiTypeAdapter;", "()V", "dataList", "", "Ljava/io/File;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "getItem", "", "position", "", "getItemCount", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LogFileFragment.kt */
    private static final class DataAdapter extends BaseMultiTypeAdapter {
        private List<? extends File> dataList;

        /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends java.io.File>, java.util.List<java.io.File> */
        public final List<File> getDataList() {
            return this.dataList;
        }

        public final void setDataList(List<? extends File> list) {
            this.dataList = list;
        }

        @Override // com.coolapk.market.widget.multitype.BaseMultiTypeAdapter
        public Object getItem(int i) {
            List<? extends File> list = this.dataList;
            if (list != null) {
                return (File) list.get(i);
            }
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<? extends File> list = this.dataList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }
}
