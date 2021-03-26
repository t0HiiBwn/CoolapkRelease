package com.coolapk.market.view.sencondhand;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemDeviceParamsBinding;
import com.coolapk.market.databinding.ItemGoodsParamsBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.DeviceParams;
import com.coolapk.market.model.ProductParams;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.BindingViewHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.recyclerviewdivider.RecyclerViewDivider;
import group.infotech.drawable.dsl.ShapesKt;
import group.infotech.drawable.dsl.ViewStates;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0003%&'Bg\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00122\u0010\u0007\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\bj\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u0001`\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R=\u0010\u0007\u001a.\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\bj\u0016\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandParamsViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "paramText", "", "Lcom/coolapk/market/model/ProductParams;", "keys", "", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "view", "Landroid/view/View;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Ljava/util/List;Ljava/util/List;Ljava/util/LinkedHashMap;Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ItemDeviceParamsBinding;", "kotlin.jvm.PlatformType", "checkHelper", "Lcom/coolapk/market/view/sencondhand/CheckHelper;", "getCheckHelper", "()Lcom/coolapk/market/view/sencondhand/CheckHelper;", "setCheckHelper", "(Lcom/coolapk/market/view/sencondhand/CheckHelper;)V", "getKeys", "()Ljava/util/List;", "list", "listParams", "getMap", "()Ljava/util/LinkedHashMap;", "options", "bindTo", "", "data", "", "onClick", "Companion", "DataAdapter", "DataViewHolder", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SecondHandParamsViewHolder.kt */
public final class SecondHandParamsViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558669;
    private final ItemDeviceParamsBinding binding;
    private CheckHelper checkHelper;
    private final List<String> keys;
    private final List<String> list = new ArrayList();
    private final List<ProductParams> listParams = new ArrayList();
    private final LinkedHashMap<String, List<ProductParams>> map;
    private final List<ProductParams> options = new ArrayList();
    private final List<ProductParams> paramText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecondHandParamsViewHolder(List<ProductParams> list2, List<String> list3, LinkedHashMap<String, List<ProductParams>> linkedHashMap, View view, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        Intrinsics.checkNotNullParameter(list2, "paramText");
        Intrinsics.checkNotNullParameter(list3, "keys");
        Intrinsics.checkNotNullParameter(view, "view");
        this.paramText = list2;
        this.keys = list3;
        this.map = linkedHashMap;
        ItemDeviceParamsBinding itemDeviceParamsBinding = (ItemDeviceParamsBinding) getBinding();
        this.binding = itemDeviceParamsBinding;
        RecyclerView recyclerView = itemDeviceParamsBinding.paramsList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.paramsList");
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        RecyclerView recyclerView2 = itemDeviceParamsBinding.paramsList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.paramsList");
        recyclerView2.setAdapter(new DataAdapter());
        RecyclerViewDivider.Companion companion = RecyclerViewDivider.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        RecyclerViewDivider build = companion.with(context).size(NumberExtendsKt.getDp((Number) 8)).asSpace().hideLastDivider().build();
        RecyclerView recyclerView3 = itemDeviceParamsBinding.paramsList;
        Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.paramsList");
        build.addTo(recyclerView3);
    }

    public static final /* synthetic */ List access$getOptions$p(SecondHandParamsViewHolder secondHandParamsViewHolder) {
        return secondHandParamsViewHolder.options;
    }

    public static final /* synthetic */ List access$getParamText$p(SecondHandParamsViewHolder secondHandParamsViewHolder) {
        return secondHandParamsViewHolder.paramText;
    }

    public final List<String> getKeys() {
        return this.keys;
    }

    public final LinkedHashMap<String, List<ProductParams>> getMap() {
        return this.map;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandParamsViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "createSelectedBackground", "Landroid/graphics/drawable/StateListDrawable;", "createSelectedTextColor", "Landroid/content/res/ColorStateList;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandParamsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final ColorStateList createSelectedTextColor() {
            return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
        }

        /* access modifiers changed from: private */
        public final StateListDrawable createSelectedBackground() {
            StateListDrawable stateListDrawable = new StateListDrawable();
            int[] selected = ViewStates.INSTANCE.selected();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            ShapesKt.setSolidColor(gradientDrawable, ColorUtils.setAlphaComponent(AppHolder.getAppTheme().getColorAccent(), 26));
            stateListDrawable.addState(selected, gradientDrawable);
            int[] iArr = StateSet.WILD_CARD;
            Intrinsics.checkExpressionValueIsNotNull(iArr, "StateSet.WILD_CARD");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setGradientType(0);
            gradientDrawable2.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            ShapesKt.setSolidColor(gradientDrawable2, Color.parseColor(AppHolder.getAppTheme().isDarkTheme() ? "#282828" : "#F5F5F5"));
            stateListDrawable.addState(iArr, gradientDrawable2);
            return stateListDrawable;
        }
    }

    public final CheckHelper getCheckHelper() {
        return this.checkHelper;
    }

    public final void setCheckHelper(CheckHelper checkHelper2) {
        this.checkHelper = checkHelper2;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        boolean z;
        if (!(obj instanceof DeviceParams)) {
            obj = null;
        }
        DeviceParams deviceParams = (DeviceParams) obj;
        if (deviceParams != null) {
            List<String> option = deviceParams.getOption();
            Intrinsics.checkNotNull(option);
            int size = option.size();
            for (int i = 0; i < size; i++) {
                List<String> option2 = deviceParams.getOption();
                Intrinsics.checkNotNull(option2);
                String str = option2.get(i);
                if (true ^ this.paramText.isEmpty()) {
                    List<ProductParams> list2 = this.paramText;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(it2.next().getTitle());
                    }
                    z = arrayList.contains(str);
                } else {
                    z = false;
                }
                List<ProductParams> list3 = this.listParams;
                String key = deviceParams.getKey();
                int checkBox = deviceParams.getCheckBox();
                int i2 = z ? 1 : 0;
                int i3 = z ? 1 : 0;
                int i4 = z ? 1 : 0;
                ProductParams create = ProductParams.create(str, i2, key, checkBox);
                Intrinsics.checkNotNullExpressionValue(create, "ProductParams.create(par…y, deviceParams.checkBox)");
                list3.add(create);
            }
            List<String> list4 = this.list;
            List<String> option3 = deviceParams.getOption();
            Intrinsics.checkNotNull(option3);
            Intrinsics.checkNotNullExpressionValue(option3, "deviceParams.option!!");
            list4.addAll(option3);
            if (deviceParams.getCheckBox() == 1) {
                List<String> list5 = this.keys;
                String key2 = deviceParams.getKey();
                Intrinsics.checkNotNull(key2);
                Intrinsics.checkNotNullExpressionValue(key2, "deviceParams.key!!");
                list5.add(key2);
            }
            TextView textView = this.binding.paramsTitle;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.paramsTitle");
            textView.setText(deviceParams.getTitle());
            RecyclerView recyclerView = this.binding.paramsList;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.paramsList");
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            Intrinsics.checkNotNull(adapter);
            adapter.notifyDataSetChanged();
            if (deviceParams.getCheckBox() == 0) {
                RecyclerView recyclerView2 = this.binding.paramsList;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.paramsList");
                MultiCheckHelper multiCheckHelper = new MultiCheckHelper(recyclerView2);
                multiCheckHelper.setHandleStateChange(new SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$1(multiCheckHelper, this));
                Unit unit = Unit.INSTANCE;
                this.checkHelper = multiCheckHelper;
            } else {
                RecyclerView recyclerView3 = this.binding.paramsList;
                Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.paramsList");
                SingleCheckHelper singleCheckHelper = new SingleCheckHelper(recyclerView3);
                singleCheckHelper.setHandleStateChange(new SecondHandParamsViewHolder$bindTo$$inlined$apply$lambda$2(singleCheckHelper, this, deviceParams));
                Unit unit2 = Unit.INSTANCE;
                this.checkHelper = singleCheckHelper;
            }
            this.binding.executePendingBindings();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandParamsViewHolder$DataAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/coolapk/market/view/sencondhand/SecondHandParamsViewHolder$DataViewHolder;", "(Lcom/coolapk/market/view/sencondhand/SecondHandParamsViewHolder;)V", "dataSet", "", "Lcom/coolapk/market/model/ProductParams;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandParamsViewHolder.kt */
    public final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        private final List<ProductParams> dataSet;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public DataAdapter() {
            this.dataSet = SecondHandParamsViewHolder.this.listParams;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558762, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate);
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            dataViewHolder.bindTo(this.dataSet.get(i));
            ProductParams productParams = this.dataSet.get(i);
            Integer num = null;
            if (!productParams.isSingleSelect()) {
                for (ProductParams productParams2 : SecondHandParamsViewHolder.access$getParamText$p(SecondHandParamsViewHolder.this)) {
                    if (Intrinsics.areEqual(productParams2.getTitle(), productParams.getTitle())) {
                        CheckHelper checkHelper = SecondHandParamsViewHolder.this.getCheckHelper();
                        SparseIntArray checkedArrays = checkHelper != null ? checkHelper.getCheckedArrays() : null;
                        Intrinsics.checkNotNull(checkedArrays);
                        checkedArrays.put(i, 1);
                    }
                }
            } else {
                CheckHelper checkHelper2 = SecondHandParamsViewHolder.this.getCheckHelper();
                if (checkHelper2 != null) {
                    num = Integer.valueOf(checkHelper2.getCheckedPostion());
                }
                Intrinsics.checkNotNull(num);
                if (num.intValue() < 0) {
                    if (productParams.isOther()) {
                        for (ProductParams productParams3 : SecondHandParamsViewHolder.access$getParamText$p(SecondHandParamsViewHolder.this)) {
                            if (Intrinsics.areEqual(productParams3.getKey(), productParams.getKey())) {
                                CheckHelper checkHelper3 = SecondHandParamsViewHolder.this.getCheckHelper();
                                if (checkHelper3 != null) {
                                    checkHelper3.setCheckedPostion(i);
                                }
                                dataViewHolder.bindTo(productParams3);
                            }
                        }
                    } else {
                        CheckHelper checkHelper4 = SecondHandParamsViewHolder.this.getCheckHelper();
                        if (checkHelper4 != null) {
                            if (!SecondHandParamsViewHolder.access$getParamText$p(SecondHandParamsViewHolder.this).contains(productParams)) {
                                i = -1;
                            }
                            checkHelper4.setCheckedPostion(i);
                        }
                    }
                }
            }
            CheckHelper checkHelper5 = SecondHandParamsViewHolder.this.getCheckHelper();
            if (checkHelper5 != null) {
                checkHelper5.bindViewHolder(dataViewHolder, 2131363576);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataSet.size();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0006\u0010\u0019\u001a\u00020\u0012J\b\u0010\u001a\u001a\u00020\u0014H\u0002Jb\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\t2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e22\u0010\u001f\u001a.\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120!\u0018\u00010 j\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120!\u0018\u0001`\"2\u0006\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020\u0010R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandParamsViewHolder$DataViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/coolapk/market/databinding/ItemGoodsParamsBinding;", "kotlin.jvm.PlatformType", "inOther", "", "getInOther", "()Z", "setInOther", "(Z)V", "item", "Lkotlin/Pair;", "", "productParams", "Lcom/coolapk/market/model/ProductParams;", "bindTo", "", "data", "", "onClick", "view", "paramText", "showDoneButton", "stateChange", "checked", "options", "", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "type", "", "otherOption", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SecondHandParamsViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558762;
        private final ItemGoodsParamsBinding binding;
        private boolean inOther;
        private Pair<String, String> item;
        private ProductParams productParams;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DataViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            ItemGoodsParamsBinding itemGoodsParamsBinding = (ItemGoodsParamsBinding) getBinding();
            this.binding = itemGoodsParamsBinding;
            Intrinsics.checkNotNullExpressionValue(itemGoodsParamsBinding, "binding");
            itemGoodsParamsBinding.setClick(this);
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/sencondhand/SecondHandParamsViewHolder$DataViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
        /* compiled from: SecondHandParamsViewHolder.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public final boolean getInOther() {
            return this.inOther;
        }

        public final void setInOther(boolean z) {
            this.inOther = z;
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder
        public void bindTo(Object obj) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.coolapk.market.model.ProductParams");
            this.productParams = (ProductParams) obj;
            CheckedTextView checkedTextView = this.binding.titleParamsView;
            Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.titleParamsView");
            ProductParams productParams2 = this.productParams;
            if (productParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productParams");
            }
            checkedTextView.setText(productParams2.getShowText());
            CheckedTextView checkedTextView2 = this.binding.titleParamsView;
            Intrinsics.checkNotNullExpressionValue(checkedTextView2, "binding.titleParamsView");
            ProductParams productParams3 = this.productParams;
            if (productParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productParams");
            }
            checkedTextView2.setChecked(productParams3.isChecked());
            CheckedTextView checkedTextView3 = this.binding.titleParamsView;
            Intrinsics.checkNotNullExpressionValue(checkedTextView3, "binding.titleParamsView");
            checkedTextView3.setBackground(SecondHandParamsViewHolder.Companion.createSelectedBackground());
            this.binding.titleParamsView.setTextColor(SecondHandParamsViewHolder.Companion.createSelectedTextColor());
            this.binding.executePendingBindings();
        }

        public final ProductParams paramText() {
            ProductParams productParams2 = this.productParams;
            if (productParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productParams");
            }
            return productParams2;
        }

        public static /* synthetic */ void stateChange$default(DataViewHolder dataViewHolder, boolean z, List list, LinkedHashMap linkedHashMap, int i, String str, int i2, Object obj) {
            if ((i2 & 16) != 0) {
                str = "";
            }
            dataViewHolder.stateChange(z, list, linkedHashMap, i, str);
        }

        public final void stateChange(boolean z, List<ProductParams> list, LinkedHashMap<String, List<ProductParams>> linkedHashMap, int i, String str) {
            Intrinsics.checkNotNullParameter(list, "options");
            Intrinsics.checkNotNullParameter(str, "otherOption");
            ProductParams productParams2 = this.productParams;
            if (productParams2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productParams");
            }
            this.inOther = productParams2.getItemType() == 1;
            ProductParams productParams3 = this.productParams;
            if (productParams3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productParams");
            }
            ProductParams.Builder newBuilder = ProductParams.newBuilder(productParams3);
            newBuilder.setItemState(z ? 1 : 0);
            String str2 = str;
            if ((str2.length() > 0) && this.inOther) {
                newBuilder.setTitle(str);
            }
            ProductParams build = newBuilder.build();
            CheckedTextView checkedTextView = this.binding.titleParamsView;
            Intrinsics.checkNotNullExpressionValue(checkedTextView, "binding.titleParamsView");
            checkedTextView.setSelected(z);
            if (z) {
                Intrinsics.checkNotNullExpressionValue(build, "newProductParams");
                if (build.isOther() && !TextUtils.isEmpty(str2)) {
                    list.clear();
                }
                list.add(build);
                CheckedTextView checkedTextView2 = this.binding.titleParamsView;
                Intrinsics.checkNotNullExpressionValue(checkedTextView2, "binding.titleParamsView");
                checkedTextView2.setText(build.getShowText());
            } else {
                if (i == 2 || i == 1) {
                    Intrinsics.checkNotNullExpressionValue(build, "newProductParams");
                    if (!build.isSingleSelect()) {
                        for (int size = list.size() - 1; size >= 0; size--) {
                            if (Intrinsics.areEqual(list.get(size).getTitle(), build.getTitle())) {
                                list.remove(size);
                            }
                        }
                    } else if (!list.isEmpty()) {
                        list.remove(0);
                    }
                }
                Intrinsics.checkNotNullExpressionValue(build, "newProductParams");
                if (build.isOther()) {
                    build = ProductParams.newBuilder(build).setTitle("").build();
                }
                CheckedTextView checkedTextView3 = this.binding.titleParamsView;
                Intrinsics.checkNotNullExpressionValue(checkedTextView3, "binding.titleParamsView");
                Intrinsics.checkNotNullExpressionValue(build, "newProductParams");
                checkedTextView3.setText(build.getShowText());
            }
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                String title = t.getTitle();
                if (title == null || title.length() == 0) {
                    arrayList.add(t);
                }
            }
            if (!list.isEmpty()) {
                Intrinsics.checkNotNull(linkedHashMap);
                String key = build.getKey();
                Intrinsics.checkNotNull(key);
                Intrinsics.checkNotNullExpressionValue(key, "newProductParams.key!!");
                linkedHashMap.put(key, list);
            } else {
                Intrinsics.checkNotNull(linkedHashMap);
                String key2 = build.getKey();
                Intrinsics.checkNotNull(key2);
                linkedHashMap.remove(key2);
            }
            showDoneButton();
            this.binding.executePendingBindings();
        }

        private final void showDoneButton() {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Activity activityNullable = UiUtils.getActivityNullable(context);
            if (activityNullable instanceof SelectParamsActivity) {
                Fragment fragment = ((SelectParamsActivity) activityNullable).getFragment();
                if (fragment instanceof SelectParamsFragment) {
                    ((SelectParamsFragment) fragment).showDoneButton();
                }
            }
        }

        @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
        public void onClick(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            super.onClick(view);
            view.getId();
        }
    }
}
