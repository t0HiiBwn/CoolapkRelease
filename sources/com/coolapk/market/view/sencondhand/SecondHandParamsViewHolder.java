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
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecondHandParamsViewHolder.kt */
public final class SecondHandParamsViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558675;
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

    public final List<String> getKeys() {
        return this.keys;
    }

    public final LinkedHashMap<String, List<ProductParams>> getMap() {
        return this.map;
    }

    /* compiled from: SecondHandParamsViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ColorStateList createSelectedTextColor() {
            return new ColorStateList(new int[][]{new int[]{16842913}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
        }

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

    /* compiled from: SecondHandParamsViewHolder.kt */
    public final class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
        private final List<ProductParams> dataSet;

        public DataAdapter() {
            SecondHandParamsViewHolder.this = r1;
            this.dataSet = r1.listParams;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558769, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
            return new DataViewHolder(inflate);
        }

        public void onBindViewHolder(DataViewHolder dataViewHolder, int i) {
            Intrinsics.checkNotNullParameter(dataViewHolder, "holder");
            dataViewHolder.bindTo(this.dataSet.get(i));
            ProductParams productParams = this.dataSet.get(i);
            Integer num = null;
            if (!productParams.isSingleSelect()) {
                for (ProductParams productParams2 : SecondHandParamsViewHolder.this.paramText) {
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
                        for (ProductParams productParams3 : SecondHandParamsViewHolder.this.paramText) {
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
                            if (!SecondHandParamsViewHolder.this.paramText.contains(productParams)) {
                                i = -1;
                            }
                            checkHelper4.setCheckedPostion(i);
                        }
                    }
                }
            }
            CheckHelper checkHelper5 = SecondHandParamsViewHolder.this.getCheckHelper();
            if (checkHelper5 != null) {
                checkHelper5.bindViewHolder(dataViewHolder, 2131363598);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.dataSet.size();
        }
    }

    /* compiled from: SecondHandParamsViewHolder.kt */
    public static final class DataViewHolder extends BindingViewHolder {
        public static final Companion Companion = new Companion(null);
        public static final int LAYOUT_ID = 2131558769;
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
