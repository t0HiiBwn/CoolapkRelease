package com.coolapk.market.view.sencondhand;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.extend.ViewExtents2Kt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.ProductParams;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.EntityConvertUtils;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.asynclist.NewAsyncListFragment;
import com.coolapk.market.widget.AdapterListChangedCallback;
import com.coolapk.market.widget.Toast;
import com.coolapk.market.widget.multitype.BaseMultiTypeAdapter;
import com.coolapk.market.widget.multitype.MultiTypeAdapter;
import com.coolapk.market.widget.multitype.SimpleViewHolderFactor;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nJ\u0012\u0010\"\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J$\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020+2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\nH\u0016J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u000200H\u0016J\u001a\u00101\u001a\u00020 2\u0006\u0010,\u001a\u00020\u00192\b\u00102\u001a\u0004\u0018\u000103H\u0014J \u00104\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00192\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u0014\u00106\u001a\u00020 2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u000307H\u0016J\b\u00108\u001a\u00020\u0019H\u0014J\u0006\u00109\u001a\u00020 R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SelectParamsFragment;", "Lcom/coolapk/market/view/base/asynclist/NewAsyncListFragment;", "", "Lcom/coolapk/market/model/Entity;", "()V", "adapter", "Lcom/coolapk/market/widget/multitype/MultiTypeAdapter;", "dataList", "Landroidx/databinding/ObservableArrayList;", "editPosition", "", "getEditPosition", "()I", "setEditPosition", "(I)V", "onListChangeCallback", "Lcom/coolapk/market/widget/AdapterListChangedCallback;", "params", "", "Lcom/coolapk/market/model/ProductParams;", "paramsKey", "", "paramsMap", "Ljava/util/LinkedHashMap;", "showDoneView", "", "textView", "Landroid/widget/TextView;", "getListFormJson", "json", "isDoneBtnClickable", "notifyItem", "", "position", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateRequest", "Lrx/Observable;", "isRefresh", "page", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestFailure", "error", "", "onRequestResponse", "result", "setAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "shouldShowList", "showDoneButton", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SelectParamsFragment.kt */
public final class SelectParamsFragment extends NewAsyncListFragment<List<? extends Entity>> {
    public static final Companion Companion = new Companion(null);
    private static final String DATA_JSON = "{\"data\":[{\"title\":\"\\u989c\\u8272\",\"entityType\":\"deviceParams\",\"key\":\"color\",\"option\":[\"\\u9ed1\\u8272\",\"\\u767d\\u8272\",\"\\u94f6\\u8272\",\"\\u7ea2\\u8272\",\"\\u5176\\u4ed6\"],\"checkBox\":1},{\"title\":\"\\u8fd0\\u884c\\u5185\\u5b58\",\"entityType\":\"deviceParams\",\"key\":\"ram\",\"option\":[\"2G\",\"3G\",\"4G\",\"6G\",\"8G\",\"16G\"],\"checkBox\":1},{\"title\":\"\\u5bb9\\u91cf\",\"entityType\":\"deviceParams\",\"key\":\"rom\",\"option\":[\"16G\",\"32G\",\"64G\",\"128G\",\"256G\",\"512G\",\"1T\",\"\\u5176\\u4ed6\"],\"checkBox\":1},{\"title\":\"\\u6210\\u8272\",\"entityType\":\"deviceParams\",\"key\":\"purity\",\"option\":[\"\\u5168\\u65b0\",\"99\\u65b0\",\"95\\u65b0\",\"9\\u65b0\",\"8\\u65b0\",\"8\\u65b0\\u4ee5\\u4e0b\"],\"checkBox\":1},{\"title\":\"\\u9009\\u586b\\u9879\",\"entityType\":\"deviceParams\",\"key\":\"extra\",\"option\":[\"\\u6709\\u53d1\\u7968\",\"\\u6709\\u914d\\u4ef6\",\"\\u6709\\u5305\\u88c5\",\"\\u6709\\u62c6\\u673a\\u7ef4\\u4fee\",\"\\u529f\\u80fd\\u6709\\u635f\\u574f\"],\"checkBox\":0}]}";
    public static final String ENTITY_TYPE_PARAMS_STRING = "PARAMS_STRING";
    public static final String ENTITY_TYPE_PARAMS_TITLE = "PARAMS_TITLE";
    public static final int REQUEST_CODE = 5678;
    private MultiTypeAdapter adapter;
    private final ObservableArrayList<Entity> dataList = new ObservableArrayList<>();
    private int editPosition = -1;
    private AdapterListChangedCallback<ObservableArrayList<Entity>> onListChangeCallback;
    private List<ProductParams> params = new ArrayList();
    private final List<String> paramsKey = new ArrayList();
    private LinkedHashMap<String, List<ProductParams>> paramsMap = new LinkedHashMap<>();
    private boolean showDoneView;
    private TextView textView;

    @JvmStatic
    public static final SelectParamsFragment newInstance(String str, String str2, String str3) {
        return Companion.newInstance(str, str2, str3);
    }

    @JvmStatic
    public static final SelectParamsFragment newInstance(String str, String str2, ArrayList<String> arrayList, String str3) {
        return Companion.newInstance(str, str2, arrayList, str3);
    }

    public final int getEditPosition() {
        return this.editPosition;
    }

    public final void setEditPosition(int i) {
        this.editPosition = i;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SelectParamsFragment$Companion;", "", "()V", "DATA_JSON", "", "ENTITY_TYPE_PARAMS_STRING", "ENTITY_TYPE_PARAMS_TITLE", "REQUEST_CODE", "", "newInstance", "Lcom/coolapk/market/view/sencondhand/SelectParamsFragment;", "productId", "ershouTypeId", "params", "Ljava/util/ArrayList;", "dealType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SelectParamsFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final SelectParamsFragment newInstance(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(str2, "ershouTypeId");
            Intrinsics.checkNotNullParameter(str3, "dealType");
            Bundle bundle = new Bundle();
            bundle.putString("KEY_PRODUCT_ID", str);
            bundle.putString("KEY_ERSHOU_TYPE_ID", str2);
            bundle.putString("KEY_ERSHOU_DEAL_TYPE", str3);
            SelectParamsFragment selectParamsFragment = new SelectParamsFragment();
            selectParamsFragment.setArguments(bundle);
            return selectParamsFragment;
        }

        @JvmStatic
        public final SelectParamsFragment newInstance(String str, String str2, ArrayList<String> arrayList, String str3) {
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(str2, "ershouTypeId");
            Intrinsics.checkNotNullParameter(arrayList, "params");
            Intrinsics.checkNotNullParameter(str3, "dealType");
            Bundle bundle = new Bundle();
            bundle.putString("KEY_PRODUCT_ID", str);
            bundle.putString("KEY_ERSHOU_TYPE_ID", str2);
            bundle.putString("KEY_ERSHOU_DEAL_TYPE", str3);
            bundle.putStringArrayList("KEY_ERSHOU_PARAMS", arrayList);
            SelectParamsFragment selectParamsFragment = new SelectParamsFragment();
            selectParamsFragment.setArguments(bundle);
            return selectParamsFragment;
        }
    }

    private final List<Entity> getListFormJson(String str) {
        JsonElement parse = new JsonParser().parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "JsonParser().parse(json)");
        JsonElement jsonElement = parse.getAsJsonObject().get("data");
        List<Entity> list = null;
        if (jsonElement == null) {
            return list;
        }
        JsonArray asJsonArray = jsonElement.getAsJsonArray();
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        return EntityConvertUtils.handleType(instance.getGson(), asJsonArray);
    }

    public final void notifyItem(int i) {
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        multiTypeAdapter.notifyItemChanged(i);
    }

    public final boolean isDoneBtnClickable() {
        if (this.paramsMap.isEmpty()) {
            return false;
        }
        Iterator<T> it2 = this.paramsKey.iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (this.paramsMap.containsKey(it2.next())) {
                i++;
            }
        }
        if (i == this.paramsKey.size()) {
            return true;
        }
        return false;
    }

    public final void showDoneButton() {
        int i;
        int i2;
        if (this.paramsMap.isEmpty()) {
            TextView textView2 = this.textView;
            if (textView2 != null) {
                if (textView2 != null) {
                    textView2.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
                }
                TextView textView3 = this.textView;
                if (textView3 != null) {
                    textView3.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                }
            }
        } else if (this.textView != null) {
            if (isDoneBtnClickable()) {
                TextView textView4 = this.textView;
                if (textView4 != null) {
                    textView4.setBackgroundColor(AppHolder.getAppTheme().getColorAccent());
                }
                TextView textView5 = this.textView;
                if (textView5 != null) {
                    textView5.setTextColor(AppHolder.getAppTheme().getContentBackgroundColor());
                }
            } else {
                TextView textView6 = this.textView;
                if (textView6 != null) {
                    textView6.setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundDividerColor());
                }
                TextView textView7 = this.textView;
                if (textView7 != null) {
                    textView7.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
                }
            }
        }
        if (!this.showDoneView) {
            View view = getView();
            FrameLayout frameLayout = null;
            if (view != null) {
                if (!(view instanceof FrameLayout)) {
                    view = null;
                }
                frameLayout = (FrameLayout) view;
            }
            if (frameLayout != null) {
                TextView textView8 = new TextView(getActivity());
                textView8.setText("选好了");
                textView8.setGravity(17);
                ViewExtents2Kt.tryListenWindowsInset(frameLayout, new SelectParamsFragment$showDoneButton$$inlined$apply$lambda$1(this, frameLayout));
                textView8.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                textView8.setTextSize(14.0f);
                if (this.paramsMap.isEmpty()) {
                    i = AppHolder.getAppTheme().getContentBackgroundDividerColor();
                } else {
                    i = AppHolder.getAppTheme().getColorAccent();
                }
                if (this.paramsMap.isEmpty()) {
                    i2 = AppHolder.getAppTheme().getTextColorSecondary();
                } else {
                    i2 = AppHolder.getAppTheme().getContentBackgroundColor();
                }
                textView8.setBackgroundColor(i);
                textView8.setTextColor(i2);
                textView8.setOnClickListener(new SelectParamsFragment$showDoneButton$$inlined$apply$lambda$2(this, frameLayout));
                Unit unit = Unit.INSTANCE;
                this.textView = textView8;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                Unit unit2 = Unit.INSTANCE;
                frameLayout.addView(textView8, layoutParams);
                this.showDoneView = !this.showDoneView;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(menuInflater, "inflater");
        super.onCreateOptionsMenu(menu, menuInflater);
        if (isAdded()) {
            menu.add(0, 2131361901, 0, "跳过").setShowAsAction(2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() != 2131361901) {
            return super.onOptionsItemSelected(menuItem);
        }
        requireActivity().setResult(-1, new Intent().putExtra("json", ""));
        requireActivity().finish();
        return true;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment, com.coolapk.market.view.base.refresh.RefreshRecyclerFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
        setRefreshEnable(false);
        setLoadMoreEnable(false);
        showDoneButton();
        getRecyclerView().setBackgroundColor(AppHolder.getAppTheme().getContentBackgroundColor());
        RecyclerView recyclerView = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView, "recyclerView");
        recyclerView.setClipChildren(false);
        RecyclerView recyclerView2 = getRecyclerView();
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "recyclerView");
        recyclerView2.setClipToPadding(false);
        getRecyclerView().setPadding(0, 0, 0, NumberExtendsKt.getDp((Number) 60));
        setLayoutManager(new LinearLayoutManager(getActivity()));
        this.adapter = new MultiTypeAdapter(this.dataList);
        ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("KEY_ERSHOU_PARAMS");
        if (parcelableArrayList != null) {
            this.params.addAll(parcelableArrayList);
        }
        MultiTypeAdapter multiTypeAdapter = this.adapter;
        if (multiTypeAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        BaseMultiTypeAdapter.register$default(multiTypeAdapter, SimpleViewHolderFactor.Companion.withLayoutId(2131558669).suitedMethod(SelectParamsFragment$onActivityCreated$1.INSTANCE).constructor(new SelectParamsFragment$onActivityCreated$2(this)).build(), 0, 2, null);
        setHasOptionsMenu(true);
        MultiTypeAdapter multiTypeAdapter2 = this.adapter;
        if (multiTypeAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        setAdapter(multiTypeAdapter2);
        if (getUserVisibleHint()) {
            initData();
        }
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    public void setAdapter(RecyclerView.Adapter<?> adapter2) {
        Intrinsics.checkNotNullParameter(adapter2, "adapter");
        super.setAdapter(adapter2);
        AdapterListChangedCallback<ObservableArrayList<Entity>> adapterListChangedCallback = this.onListChangeCallback;
        if (adapterListChangedCallback != null) {
            this.dataList.removeOnListChangedCallback(adapterListChangedCallback);
            this.onListChangeCallback = null;
        }
        AdapterListChangedCallback<ObservableArrayList<Entity>> adapterListChangedCallback2 = new AdapterListChangedCallback<>(adapter2);
        this.onListChangeCallback = adapterListChangedCallback2;
        this.dataList.addOnListChangedCallback(adapterListChangedCallback2);
    }

    /* access modifiers changed from: protected */
    public boolean onRequestResponse(boolean z, List<? extends Entity> list) {
        boolean z2;
        List<? extends Entity> list2 = list;
        if (!CollectionUtils.isEmpty(list2)) {
            ObservableArrayList<Entity> observableArrayList = this.dataList;
            Intrinsics.checkNotNull(list);
            observableArrayList.addAll(list2);
            z2 = true;
        } else {
            z2 = false;
        }
        updateContentUI();
        return z2;
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListFragment
    protected void onRequestFailure(boolean z, Throwable th) {
        Toast.error(getActivity(), th);
    }

    @Override // com.coolapk.market.view.base.asynclist.NewAsyncListContract.View
    public Observable<List<Entity>> onCreateRequest(boolean z, int i) {
        String string = requireArguments().getString("KEY_PRODUCT_ID");
        String string2 = requireArguments().getString("KEY_ERSHOU_TYPE_ID");
        String string3 = requireArguments().getString("KEY_ERSHOU_DEAL_TYPE");
        if (Intrinsics.areEqual("104", string2)) {
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("paramsList", new ArrayList<>());
            intent.putExtra("json", "");
            requireActivity().setResult(-1, intent);
            requireActivity().finish();
            Observable<List<Entity>> empty = Observable.empty();
            Intrinsics.checkNotNullExpressionValue(empty, "Observable.empty()");
            return empty;
        }
        Observable<R> compose = DataManager.getInstance().getProductConfig(string, string3, string2).compose(RxUtils.apiCommonToData());
        Intrinsics.checkNotNullExpressionValue(compose, "DataManager.getInstance(…xUtils.apiCommonToData())");
        return compose;
    }

    @Override // com.coolapk.market.view.base.refresh.RefreshRecyclerFragment
    protected boolean shouldShowList() {
        return isDataLoaded();
    }
}
