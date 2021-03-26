package com.coolapk.market.view.dyhv8.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemDyhIncludBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.dyhv8.DyhViewModel;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import com.coolapk.market.widget.Toast;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001#BS\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0003H\u0016J\u001a\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010\u000eH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhIncludViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemDyhIncludBinding;", "Lcom/coolapk/market/model/DyhModel;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "doneView", "Landroid/widget/TextView;", "map", "Ljava/util/LinkedHashMap;", "", "Lkotlin/collections/LinkedHashMap;", "bindingComponent", "Lcom/coolapk/market/binding/FragmentBindingComponent;", "itemView", "Landroid/view/View;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/widget/TextView;Ljava/util/LinkedHashMap;Lcom/coolapk/market/binding/FragmentBindingComponent;Landroid/view/View;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "getDoneView", "()Landroid/widget/TextView;", "isInclud", "", "mViewModel", "Lcom/coolapk/market/view/dyhv8/DyhViewModel;", "getMap", "()Ljava/util/LinkedHashMap;", "bindToContent", "", "dyhModel", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: DyhIncludViewHolder.kt */
public final class DyhIncludViewHolder extends GenericBindHolder<ItemDyhIncludBinding, DyhModel> implements CompoundButton.OnCheckedChangeListener {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558680;
    private final TextView doneView;
    private boolean isInclud;
    private DyhViewModel mViewModel;
    private final LinkedHashMap<String, DyhModel> map;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DyhIncludViewHolder(TextView textView, LinkedHashMap<String, DyhModel> linkedHashMap, FragmentBindingComponent fragmentBindingComponent, View view, ItemActionHandler itemActionHandler) {
        super(view, fragmentBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.doneView = textView;
        this.map = linkedHashMap;
        this.isInclud = (textView == null && linkedHashMap == null) ? false : true;
    }

    public final TextView getDoneView() {
        return this.doneView;
    }

    public final LinkedHashMap<String, DyhModel> getMap() {
        return this.map;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!UiUtils.isInvalidPosition(getAdapterPosition()) && this.isInclud) {
            LinkedHashMap<String, DyhModel> linkedHashMap = this.map;
            Intrinsics.checkNotNull(linkedHashMap);
            LinkedHashMap<String, DyhModel> linkedHashMap2 = linkedHashMap;
            DyhViewModel dyhViewModel = this.mViewModel;
            Intrinsics.checkNotNull(dyhViewModel);
            DyhModel dyhModel = dyhViewModel.getDyhModel();
            Intrinsics.checkNotNullExpressionValue(dyhModel, "mViewModel!!.dyhModel");
            String id = dyhModel.getId();
            Objects.requireNonNull(linkedHashMap2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            boolean containsKey = linkedHashMap2.containsKey(id);
            DyhViewModel dyhViewModel2 = this.mViewModel;
            Intrinsics.checkNotNull(dyhViewModel2);
            DyhModel dyhModel2 = dyhViewModel2.getDyhModel();
            if (z && !containsKey) {
                LinkedHashMap<String, DyhModel> linkedHashMap3 = this.map;
                if ((linkedHashMap3 != null ? Integer.valueOf(linkedHashMap3.size()) : null).intValue() >= 3) {
                    Intrinsics.checkNotNull(compoundButton);
                    compoundButton.setChecked(false);
                    Toast.show$default(getContext(), "最多可以选择三个看看号", 0, false, 12, null);
                    return;
                }
                Intrinsics.checkNotNull(dyhModel2);
                String id2 = dyhModel2.getId();
                Intrinsics.checkNotNull(id2);
                Intrinsics.checkNotNullExpressionValue(id2, "dyh!!.id!!");
                this.map.put(id2, dyhModel2);
            } else if (!z && containsKey) {
                LinkedHashMap<String, DyhModel> linkedHashMap4 = this.map;
                Intrinsics.checkNotNullExpressionValue(dyhModel2, "dyh");
                String id3 = dyhModel2.getId();
                Objects.requireNonNull(linkedHashMap4, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                TypeIntrinsics.asMutableMap(linkedHashMap4).remove(id3);
            }
            if (!this.map.isEmpty()) {
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

    public void bindToContent(DyhModel dyhModel) {
        Intrinsics.checkNotNullParameter(dyhModel, "dyhModel");
        DyhViewModel dyhViewModel = new DyhViewModel();
        this.mViewModel = dyhViewModel;
        Intrinsics.checkNotNull(dyhViewModel);
        dyhViewModel.setDyhModel(dyhModel);
        ItemDyhIncludBinding itemDyhIncludBinding = (ItemDyhIncludBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDyhIncludBinding, "binding");
        itemDyhIncludBinding.setModel(this.mViewModel);
        ItemDyhIncludBinding itemDyhIncludBinding2 = (ItemDyhIncludBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDyhIncludBinding2, "binding");
        itemDyhIncludBinding2.setClick(this);
        CheckBox checkBox = ((ItemDyhIncludBinding) getBinding()).checkBox;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkBox");
        ItemDyhIncludBinding itemDyhIncludBinding3 = (ItemDyhIncludBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemDyhIncludBinding3, "binding");
        int i = 8;
        itemDyhIncludBinding3.setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 8), false));
        if (this.isInclud) {
            i = 0;
        }
        checkBox.setVisibility(i);
        if (this.isInclud) {
            checkBox.setOnCheckedChangeListener(this);
            LinkedHashMap<String, DyhModel> linkedHashMap = this.map;
            Intrinsics.checkNotNull(linkedHashMap);
            LinkedHashMap<String, DyhModel> linkedHashMap2 = linkedHashMap;
            String id = dyhModel.getId();
            Objects.requireNonNull(linkedHashMap2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            checkBox.setChecked(linkedHashMap2.containsKey(id));
        }
        ((ItemDyhIncludBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131363260) {
            if (this.isInclud) {
                CheckBox checkBox = ((ItemDyhIncludBinding) getBinding()).checkBox;
                Intrinsics.checkNotNullExpressionValue(checkBox, "binding.checkBox");
                checkBox.setChecked(!checkBox.isChecked());
                return;
            }
            Context context = getContext();
            DyhViewModel dyhViewModel = this.mViewModel;
            Intrinsics.checkNotNull(dyhViewModel);
            ActionManager.startDyhDetailActivity(context, dyhViewModel.getDyhModel());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/dyhv8/viewholder/DyhIncludViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: DyhIncludViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
