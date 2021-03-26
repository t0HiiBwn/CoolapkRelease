package com.coolapk.market.view.collectionList;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemCollectionSelectBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.model.Collection;
import com.coolapk.market.util.CircleRadiusTransform;
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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001!B{\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n\u0012&\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u001a\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0016R1\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionSelectViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCollectionSelectBinding;", "Lcom/coolapk/market/model/Collection;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "doneView", "Landroid/widget/TextView;", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "cancelMap", "bindingComponent", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "itemView", "Landroid/view/View;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/widget/TextView;Ljava/util/LinkedHashMap;Ljava/util/LinkedHashMap;Lcom/coolapk/market/binding/FragmentBindingComponent;Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "getCancelMap", "()Ljava/util/LinkedHashMap;", "isInclud", "", "getMap", "bindToContent", "", "collection", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionSelectViewHolder.kt */
public final class CollectionSelectViewHolder extends GenericBindHolder<ItemCollectionSelectBinding, Collection> implements CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558662;
    private final LinkedHashMap<String, Collection> cancelMap;
    private final TextView doneView;
    private boolean isInclud;
    private final LinkedHashMap<String, Collection> map;

    public final LinkedHashMap<String, Collection> getMap() {
        return this.map;
    }

    public final LinkedHashMap<String, Collection> getCancelMap() {
        return this.cancelMap;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionSelectViewHolder(TextView textView, LinkedHashMap<String, Collection> linkedHashMap, LinkedHashMap<String, Collection> linkedHashMap2, FragmentBindingComponent fragmentBindingComponent, View view, ItemActionHandler itemActionHandler) {
        super(view, fragmentBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.doneView = textView;
        this.map = linkedHashMap;
        this.cancelMap = linkedHashMap2;
        this.isInclud = (textView == null && linkedHashMap == null) ? false : true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bc, code lost:
        if (r0.isDefaultCollected() != false) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a5  */
    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        boolean z2;
        if (!UiUtils.isInvalidPosition(getAdapterPosition()) && this.isInclud) {
            LinkedHashMap<String, Collection> linkedHashMap = this.map;
            Intrinsics.checkNotNull(linkedHashMap);
            LinkedHashMap<String, Collection> linkedHashMap2 = linkedHashMap;
            ItemCollectionSelectBinding itemCollectionSelectBinding = (ItemCollectionSelectBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding, "binding");
            Collection model = itemCollectionSelectBinding.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            String id = model.getId();
            Objects.requireNonNull(linkedHashMap2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            boolean containsKey = linkedHashMap2.containsKey(id);
            LinkedHashMap<String, Collection> linkedHashMap3 = this.cancelMap;
            Intrinsics.checkNotNull(linkedHashMap3);
            LinkedHashMap<String, Collection> linkedHashMap4 = linkedHashMap3;
            ItemCollectionSelectBinding itemCollectionSelectBinding2 = (ItemCollectionSelectBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding2, "binding");
            Collection model2 = itemCollectionSelectBinding2.getModel();
            Intrinsics.checkNotNull(model2);
            Intrinsics.checkNotNullExpressionValue(model2, "binding.model!!");
            String id2 = model2.getId();
            Objects.requireNonNull(linkedHashMap4, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            boolean containsKey2 = linkedHashMap4.containsKey(id2);
            if (!z || containsKey) {
                if (!z && containsKey) {
                    LinkedHashMap<String, Collection> linkedHashMap5 = this.map;
                    ItemCollectionSelectBinding itemCollectionSelectBinding3 = (ItemCollectionSelectBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding3, "binding");
                    Collection model3 = itemCollectionSelectBinding3.getModel();
                    Intrinsics.checkNotNull(model3);
                    Intrinsics.checkNotNullExpressionValue(model3, "binding.model!!");
                    String id3 = model3.getId();
                    Objects.requireNonNull(linkedHashMap5, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                    TypeIntrinsics.asMutableMap(linkedHashMap5).remove(id3);
                }
            } else if (this.map.size() >= 3) {
                Intrinsics.checkNotNull(compoundButton);
                compoundButton.setChecked(false);
                Toast.show$default(getContext(), "最多可以选择三个收藏单", 0, false, 12, null);
                return;
            } else {
                if (!containsKey2) {
                    ItemCollectionSelectBinding itemCollectionSelectBinding4 = (ItemCollectionSelectBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding4, "binding");
                    Collection model4 = itemCollectionSelectBinding4.getModel();
                    Intrinsics.checkNotNull(model4);
                    if (!model4.isBeCollected()) {
                        z2 = true;
                        if (!z2) {
                            ItemCollectionSelectBinding itemCollectionSelectBinding5 = (ItemCollectionSelectBinding) getBinding();
                            Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding5, "binding");
                            Collection model5 = itemCollectionSelectBinding5.getModel();
                            Intrinsics.checkNotNull(model5);
                            Intrinsics.checkNotNullExpressionValue(model5, "binding.model!!");
                        }
                        ItemCollectionSelectBinding itemCollectionSelectBinding6 = (ItemCollectionSelectBinding) getBinding();
                        Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding6, "binding");
                        Collection model6 = itemCollectionSelectBinding6.getModel();
                        Intrinsics.checkNotNull(model6);
                        Intrinsics.checkNotNullExpressionValue(model6, "binding.model!!");
                        String id4 = model6.getId();
                        Intrinsics.checkNotNull(id4);
                        Intrinsics.checkNotNullExpressionValue(id4, "binding.model!!.id!!");
                        ItemCollectionSelectBinding itemCollectionSelectBinding7 = (ItemCollectionSelectBinding) getBinding();
                        Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding7, "binding");
                        Collection model7 = itemCollectionSelectBinding7.getModel();
                        Intrinsics.checkNotNull(model7);
                        Intrinsics.checkNotNullExpressionValue(model7, "binding.model!!");
                        this.map.put(id4, model7);
                    }
                }
                z2 = false;
                if (!z2) {
                }
                ItemCollectionSelectBinding itemCollectionSelectBinding6 = (ItemCollectionSelectBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding6, "binding");
                Collection model6 = itemCollectionSelectBinding6.getModel();
                Intrinsics.checkNotNull(model6);
                Intrinsics.checkNotNullExpressionValue(model6, "binding.model!!");
                String id4 = model6.getId();
                Intrinsics.checkNotNull(id4);
                Intrinsics.checkNotNullExpressionValue(id4, "binding.model!!.id!!");
                ItemCollectionSelectBinding itemCollectionSelectBinding7 = (ItemCollectionSelectBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding7, "binding");
                Collection model7 = itemCollectionSelectBinding7.getModel();
                Intrinsics.checkNotNull(model7);
                Intrinsics.checkNotNullExpressionValue(model7, "binding.model!!");
                this.map.put(id4, model7);
            }
            if (!z && !containsKey2) {
                ItemCollectionSelectBinding itemCollectionSelectBinding8 = (ItemCollectionSelectBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding8, "binding");
                Collection model8 = itemCollectionSelectBinding8.getModel();
                Intrinsics.checkNotNull(model8);
                if (model8.isBeCollected()) {
                    ItemCollectionSelectBinding itemCollectionSelectBinding9 = (ItemCollectionSelectBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding9, "binding");
                    Collection model9 = itemCollectionSelectBinding9.getModel();
                    Intrinsics.checkNotNull(model9);
                    Intrinsics.checkNotNullExpressionValue(model9, "binding.model!!");
                    String id5 = model9.getId();
                    Intrinsics.checkNotNull(id5);
                    Intrinsics.checkNotNullExpressionValue(id5, "binding.model!!.id!!");
                    ItemCollectionSelectBinding itemCollectionSelectBinding10 = (ItemCollectionSelectBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding10, "binding");
                    Collection model10 = itemCollectionSelectBinding10.getModel();
                    Intrinsics.checkNotNull(model10);
                    Intrinsics.checkNotNullExpressionValue(model10, "binding.model!!");
                    this.cancelMap.put(id5, model10);
                }
            }
            if (z && containsKey2) {
                LinkedHashMap<String, Collection> linkedHashMap6 = this.cancelMap;
                ItemCollectionSelectBinding itemCollectionSelectBinding11 = (ItemCollectionSelectBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding11, "binding");
                Collection model11 = itemCollectionSelectBinding11.getModel();
                Intrinsics.checkNotNull(model11);
                Intrinsics.checkNotNullExpressionValue(model11, "binding.model!!");
                String id6 = model11.getId();
                Objects.requireNonNull(linkedHashMap6, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                TypeIntrinsics.asMutableMap(linkedHashMap6).remove(id6);
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

    public void bindToContent(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        ItemCollectionSelectBinding itemCollectionSelectBinding = (ItemCollectionSelectBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding, "binding");
        itemCollectionSelectBinding.setModel(collection);
        ItemCollectionSelectBinding itemCollectionSelectBinding2 = (ItemCollectionSelectBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding2, "binding");
        itemCollectionSelectBinding2.setClick(this);
        CheckBox checkBox = ((ItemCollectionSelectBinding) getBinding()).selectView;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.selectView");
        ItemCollectionSelectBinding itemCollectionSelectBinding3 = (ItemCollectionSelectBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding3, "binding");
        int i = 8;
        boolean z = false;
        itemCollectionSelectBinding3.setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 8), false));
        if (this.isInclud) {
            i = 0;
        }
        checkBox.setVisibility(i);
        if (this.isInclud) {
            checkBox.setOnCheckedChangeListener(this);
            LinkedHashMap<String, Collection> linkedHashMap = this.map;
            Intrinsics.checkNotNull(linkedHashMap);
            LinkedHashMap<String, Collection> linkedHashMap2 = linkedHashMap;
            ItemCollectionSelectBinding itemCollectionSelectBinding4 = (ItemCollectionSelectBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemCollectionSelectBinding4, "binding");
            Collection model = itemCollectionSelectBinding4.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            String id = model.getId();
            Objects.requireNonNull(linkedHashMap2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            if (linkedHashMap2.containsKey(id) || collection.isBeCollected() || collection.isDefaultCollected()) {
                z = true;
            }
            checkBox.setChecked(z);
        }
        ((ItemCollectionSelectBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131362779) {
            CheckBox checkBox = ((ItemCollectionSelectBinding) getBinding()).selectView;
            Intrinsics.checkNotNullExpressionValue(checkBox, "binding.selectView");
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionSelectViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionSelectViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
