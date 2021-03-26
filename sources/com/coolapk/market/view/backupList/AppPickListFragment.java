package com.coolapk.market.view.backupList;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.decoration.ItemDecorations;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\u0018\u0000 02\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0007H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001f2\u0006\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J \u0010)\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u000e2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0017H\u0016J\u0010\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u000eH\u0002J\b\u0010/\u001a\u00020\u000eH\u0014R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/coolapk/market/view/backupList/AppPickListFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/MobileApp;", "()V", "appMap", "", "", "backupTitle", "dataAdapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "dataList", "Landroidx/databinding/ObservableArrayList;", "isShowSystem", "", "()Z", "setShowSystem", "(Z)V", "menuState", "getJson", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestFailure", "error", "", "onRequestResponse", "result", "onSaveInstanceState", "outState", "onSelectAll", "check", "shouldShowList", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AppPickListFragment.kt */
public final class AppPickListFragment extends NewAsyncListFragment<List<? extends MobileApp>> {
    public static final Companion Companion = new Companion(null);
    private Map<String, String> appMap;
    private String backupTitle;
    private MultiTypeAdapter dataAdapter;
    private final ObservableArrayList<MobileApp> dataList = new ObservableArrayList<>();
    private boolean isShowSystem;
    private boolean menuState = true;

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends MobileApp> list) {
        this.dataList.clear();
        ObservableArrayList<MobileApp> observableArrayList = this.dataList;
        Intrinsics.checkNotNull(list);
        observableArrayList.addAll(list);
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        updateContentUI();
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<MobileApp>> onCreateRequest(boolean z, int i) {
        Observable<List<MobileApp>> list = Observable.fromCallable(AppPickListFragment$onCreateRequest$1.INSTANCE).flatMap(AppPickListFragment$onCreateRequest$2.INSTANCE).filter(new AppPickListFragment$onCreateRequest$3(this)).toList();
        Intrinsics.checkNotNullExpressionValue(list, "Observable.fromCallable …                .toList()");
        return list;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return this.dataList.size() > 0;
    }

    public final boolean isShowSystem() {
        return this.isShowSystem;
    }

    public final void setShowSystem(boolean z) {
        this.isShowSystem = z;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        ArrayList parcelableArrayList;
        super.onActivityCreated(bundle);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.setTitle(getString(2131887348));
        getRecyclerView().addItemDecoration(ItemDecorations.vertical(getActivity()).type(2131558819, 2131231062).last(2131231062).create());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setChangeDuration(0);
        }
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        String string = requireArguments().getString("TITLE_BACKUP");
        Intrinsics.checkNotNull(string);
        this.backupTitle = string;
        this.appMap = new HashMap();
        if (!(bundle == null || (parcelableArrayList = bundle.getParcelableArrayList("apps")) == null)) {
            int size = parcelableArrayList.size();
            for (int i = 0; i < size; i++) {
                MobileApp mobileApp = (MobileApp) parcelableArrayList.get(i);
                Map<String, String> map = this.appMap;
                Intrinsics.checkNotNull(map);
                Intrinsics.checkNotNullExpressionValue(mobileApp, "app");
                String packageName = mobileApp.getPackageName();
                Intrinsics.checkNotNullExpressionValue(packageName, "app.packageName");
                String appName = mobileApp.getAppName();
                Intrinsics.checkNotNullExpressionValue(appName, "app.appName");
                map.put(packageName, appName);
            }
        }
        MultiTypeAdapter multiTypeAdapter = new MultiTypeAdapter(this.dataList);
        this.dataAdapter = multiTypeAdapter;
        setAdapter(multiTypeAdapter);
        MultiTypeAdapter multiTypeAdapter2 = this.dataAdapter;
        Intrinsics.checkNotNull(multiTypeAdapter2);
        multiTypeAdapter2.register(SimpleViewHolderFactor.Companion.withLayoutId(2131558819).suitedMethod(AppPickListFragment$onActivityCreated$1.INSTANCE).constructor(new AppPickListFragment$onActivityCreated$2(this)).build(), 0);
        this.dataList.addOnListChangedCallback(new AdapterListChangedCallback(this.dataAdapter));
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131361966, 100, "全选").setShowAsAction(2);
            menu.add(0, 2131361900, 101, "完成").setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == 2131361900) {
            Intent intent = new Intent();
            intent.putExtra("app_json", getJson());
            String str = this.backupTitle;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backupTitle");
            }
            intent.putExtra("TITLE_BACKUP", str);
            requireActivity().setResult(-1, intent);
            requireActivity().finish();
        } else if (itemId == 2131361966) {
            onSelectAll(this.menuState);
            boolean z = !this.menuState;
            this.menuState = z;
            menuItem.setTitle(z ? 2131886648 : 2131886646);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final String getJson() {
        String json = new Gson().toJson(this.appMap);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(appMap)");
        return json;
    }

    private final void onSelectAll(boolean z) {
        int size = this.dataList.size();
        for (int i = 0; i < size; i++) {
            MobileApp mobileApp = (MobileApp) this.dataList.get(i);
            if (z) {
                Map<String, String> map = this.appMap;
                Intrinsics.checkNotNull(map);
                Intrinsics.checkNotNullExpressionValue(mobileApp, "app");
                if (!map.containsKey(mobileApp.getPackageName()) && !mobileApp.isSystemApp()) {
                    Map<String, String> map2 = this.appMap;
                    Intrinsics.checkNotNull(map2);
                    String packageName = mobileApp.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "app.packageName");
                    String appName = mobileApp.getAppName();
                    Intrinsics.checkNotNullExpressionValue(appName, "app.appName");
                    map2.put(packageName, appName);
                    RecyclerView recyclerView = getRecyclerView();
                    Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (adapter != null) {
                        adapter.notifyItemChanged(i);
                    }
                }
            }
            if (!z) {
                Map<String, String> map3 = this.appMap;
                Intrinsics.checkNotNull(map3);
                Intrinsics.checkNotNullExpressionValue(mobileApp, "app");
                if (map3.containsKey(mobileApp.getPackageName()) && !mobileApp.isSystemApp()) {
                    Map<String, String> map4 = this.appMap;
                    Intrinsics.checkNotNull(map4);
                    map4.remove(mobileApp.getPackageName());
                    RecyclerView recyclerView2 = getRecyclerView();
                    Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
                    RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
                    if (adapter2 != null) {
                        adapter2.notifyItemChanged(i);
                    }
                }
            }
        }
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.BaseFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        if (this.appMap != null) {
            Map<String, String> map = this.appMap;
            Intrinsics.checkNotNull(map);
            ArrayList<String> arrayList = new ArrayList<>(map.size());
            Map<String, String> map2 = this.appMap;
            Intrinsics.checkNotNull(map2);
            arrayList.addAll(map2.keySet());
            bundle.putStringArrayList("apps", arrayList);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/backupList/AppPickListFragment$Companion;", "", "()V", "newInstance", "Lcom/coolapk/market/view/backupList/AppPickListFragment;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AppPickListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppPickListFragment newInstance() {
            Bundle bundle = new Bundle();
            AppPickListFragment appPickListFragment = new AppPickListFragment();
            appPickListFragment.setArguments(bundle);
            return appPickListFragment;
        }
    }
}
