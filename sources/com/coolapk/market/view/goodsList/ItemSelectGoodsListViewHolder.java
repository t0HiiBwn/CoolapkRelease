package com.coolapk.market.view.goodsList;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemAddToGoodsListBinding;
import com.coolapk.market.model.FunThings;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001 B{\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n\u0012&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u001a\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0016R.\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemSelectGoodsListViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemAddToGoodsListBinding;", "Lcom/coolapk/market/model/FunThings;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "doneView", "Landroid/widget/TextView;", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "cancelMap", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/widget/TextView;Ljava/util/LinkedHashMap;Ljava/util/LinkedHashMap;Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "goodsList", "getMap", "()Ljava/util/LinkedHashMap;", "bindToContent", "", "entity", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemSelectGoodsListViewHolder.kt */
public final class ItemSelectGoodsListViewHolder extends GenericBindHolder<ItemAddToGoodsListBinding, FunThings> implements CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558576;
    private final LinkedHashMap<String, FunThings> cancelMap;
    private final TextView doneView;
    private FunThings goodsList;
    private final LinkedHashMap<String, FunThings> map;

    public final LinkedHashMap<String, FunThings> getMap() {
        return this.map;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemSelectGoodsListViewHolder(TextView textView, LinkedHashMap<String, FunThings> linkedHashMap, LinkedHashMap<String, FunThings> linkedHashMap2, View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.doneView = textView;
        this.map = linkedHashMap;
        this.cancelMap = linkedHashMap2;
    }

    public void bindToContent(FunThings funThings) {
        Intrinsics.checkNotNullParameter(funThings, "entity");
        this.goodsList = funThings;
        ItemAddToGoodsListBinding itemAddToGoodsListBinding = (ItemAddToGoodsListBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAddToGoodsListBinding, "binding");
        itemAddToGoodsListBinding.setModel(funThings);
        ItemAddToGoodsListBinding itemAddToGoodsListBinding2 = (ItemAddToGoodsListBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemAddToGoodsListBinding2, "binding");
        itemAddToGoodsListBinding2.setClick(this);
        ((ItemAddToGoodsListBinding) getBinding()).checkView.setOnCheckedChangeListener(this);
        CheckBox checkBox = ((ItemAddToGoodsListBinding) getBinding()).checkView;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkView");
        LinkedHashMap<String, FunThings> linkedHashMap = this.map;
        Intrinsics.checkNotNull(linkedHashMap);
        LinkedHashMap<String, FunThings> linkedHashMap2 = linkedHashMap;
        String id = funThings.getId();
        Objects.requireNonNull(linkedHashMap2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        checkBox.setChecked(linkedHashMap2.containsKey(id) || funThings.isAdded());
        ((ItemAddToGoodsListBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131362200) {
            CheckBox checkBox = ((ItemAddToGoodsListBinding) getBinding()).checkView;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkView");
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/goodsList/ItemSelectGoodsListViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemSelectGoodsListViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0099  */
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2;
        if (!UiUtils.isInvalidPosition(getAdapterPosition())) {
            LinkedHashMap<String, FunThings> linkedHashMap = this.map;
            Intrinsics.checkNotNull(linkedHashMap);
            LinkedHashMap<String, FunThings> linkedHashMap2 = linkedHashMap;
            ItemAddToGoodsListBinding itemAddToGoodsListBinding = (ItemAddToGoodsListBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemAddToGoodsListBinding, "binding");
            FunThings model = itemAddToGoodsListBinding.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            String id = model.getId();
            Objects.requireNonNull(linkedHashMap2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            boolean containsKey = linkedHashMap2.containsKey(id);
            LinkedHashMap<String, FunThings> linkedHashMap3 = this.cancelMap;
            Intrinsics.checkNotNull(linkedHashMap3);
            LinkedHashMap<String, FunThings> linkedHashMap4 = linkedHashMap3;
            ItemAddToGoodsListBinding itemAddToGoodsListBinding2 = (ItemAddToGoodsListBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemAddToGoodsListBinding2, "binding");
            FunThings model2 = itemAddToGoodsListBinding2.getModel();
            Intrinsics.checkNotNull(model2);
            Intrinsics.checkNotNullExpressionValue(model2, "binding.model!!");
            String id2 = model2.getId();
            Objects.requireNonNull(linkedHashMap4, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            boolean containsKey2 = linkedHashMap4.containsKey(id2);
            if (!z || containsKey) {
                if (!z && containsKey) {
                    LinkedHashMap<String, FunThings> linkedHashMap5 = this.map;
                    FunThings funThings = this.goodsList;
                    if (funThings == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                    }
                    String id3 = funThings.getId();
                    Objects.requireNonNull(linkedHashMap5, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                    TypeIntrinsics.asMutableMap(linkedHashMap5).remove(id3);
                }
            } else if (this.map.size() >= 3) {
                Intrinsics.checkNotNull(compoundButton);
                compoundButton.setChecked(false);
                Toast.show$default(getContext(), "最多可以选择三个好物单", 0, false, 12, null);
                return;
            } else {
                if (!containsKey2) {
                    FunThings funThings2 = this.goodsList;
                    if (funThings2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                    }
                    if (!funThings2.isAdded()) {
                        z2 = true;
                        if (z2) {
                            LinkedHashMap<String, FunThings> linkedHashMap6 = this.map;
                            FunThings funThings3 = this.goodsList;
                            if (funThings3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                            }
                            String id4 = funThings3.getId();
                            Intrinsics.checkNotNull(id4);
                            Intrinsics.checkNotNullExpressionValue(id4, "goodsList.id!!");
                            FunThings funThings4 = this.goodsList;
                            if (funThings4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                            }
                            linkedHashMap6.put(id4, funThings4);
                        }
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
            if (!z && !containsKey2) {
                FunThings funThings5 = this.goodsList;
                if (funThings5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                }
                if (funThings5.isAdded()) {
                    LinkedHashMap<String, FunThings> linkedHashMap7 = this.cancelMap;
                    FunThings funThings6 = this.goodsList;
                    if (funThings6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                    }
                    String id5 = funThings6.getId();
                    Intrinsics.checkNotNull(id5);
                    Intrinsics.checkNotNullExpressionValue(id5, "goodsList.id!!");
                    FunThings funThings7 = this.goodsList;
                    if (funThings7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                    }
                    linkedHashMap7.put(id5, funThings7);
                }
            }
            if (z && containsKey2) {
                LinkedHashMap<String, FunThings> linkedHashMap8 = this.cancelMap;
                FunThings funThings8 = this.goodsList;
                if (funThings8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("goodsList");
                }
                String id6 = funThings8.getId();
                Objects.requireNonNull(linkedHashMap8, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                TypeIntrinsics.asMutableMap(linkedHashMap8).remove(id6);
            }
            if ((!this.map.isEmpty()) || (!this.cancelMap.isEmpty())) {
                TextView textView = this.doneView;
                Intrinsics.checkNotNull(textView);
                textView.setTextColor(AppHolder.getAppTheme().getColorAccent());
                this.doneView.setEnabled(true);
                return;
            }
            TextView textView2 = this.doneView;
            Intrinsics.checkNotNull(textView2);
            textView2.setTextColor(AppHolder.getAppTheme().getTextColorSecondary());
            this.doneView.setEnabled(false);
        }
    }
}
