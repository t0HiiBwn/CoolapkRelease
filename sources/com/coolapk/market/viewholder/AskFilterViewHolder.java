package com.coolapk.market.viewholder;

import android.content.res.ColorStateList;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemSearchAskFilterBinding;
import com.coolapk.market.view.search.SuperSearchViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/coolapk/market/viewholder/AskFilterViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "viewModel", "Lcom/coolapk/market/view/search/SuperSearchViewModel;", "itemActionHandler", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Lcom/coolapk/market/view/search/SuperSearchViewModel;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "binding", "Lcom/coolapk/market/databinding/ItemSearchAskFilterBinding;", "kotlin.jvm.PlatformType", "feedTypeViews", "Ljava/util/ArrayList;", "Landroid/widget/RadioButton;", "Lkotlin/collections/ArrayList;", "onChecked", "Landroid/widget/RadioGroup$OnCheckedChangeListener;", "getViewModel", "()Lcom/coolapk/market/view/search/SuperSearchViewModel;", "bindTo", "", "data", "", "createSelectedTextColor", "Landroid/content/res/ColorStateList;", "updateFeedTypeView", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: AskFilterViewHolder.kt */
public final class AskFilterViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558913;
    private final ItemSearchAskFilterBinding binding;
    private final ArrayList<RadioButton> feedTypeViews;
    private final RadioGroup.OnCheckedChangeListener onChecked = new AskFilterViewHolder$onChecked$1(this);
    private final SuperSearchViewModel viewModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AskFilterViewHolder(View view, SuperSearchViewModel superSearchViewModel, ItemActionHandler itemActionHandler) {
        super(view, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(superSearchViewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        this.viewModel = superSearchViewModel;
        ItemSearchAskFilterBinding itemSearchAskFilterBinding = (ItemSearchAskFilterBinding) getBinding();
        this.binding = itemSearchAskFilterBinding;
        ArrayList<RadioButton> arrayListOf = CollectionsKt.arrayListOf(itemSearchAskFilterBinding.feedTypeAll, itemSearchAskFilterBinding.feedTypeAnswer, itemSearchAskFilterBinding.feedTypeQuestion);
        this.feedTypeViews = arrayListOf;
        Iterator<T> it2 = arrayListOf.iterator();
        while (it2.hasNext()) {
            it2.next().setTextColor(createSelectedTextColor());
        }
    }

    public final SuperSearchViewModel getViewModel() {
        return this.viewModel;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/AskFilterViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: AskFilterViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        this.binding.radioGroup.setOnCheckedChangeListener(null);
        updateFeedTypeView();
        this.binding.radioGroup.setOnCheckedChangeListener(this.onChecked);
    }

    private final void updateFeedTypeView() {
        String askFeedType = this.viewModel.getAskFeedType();
        int hashCode = askFeedType.hashCode();
        if (hashCode != -1412808770) {
            if (hashCode == -1165870106 && askFeedType.equals("question")) {
                this.binding.radioGroup.check(2131362552);
                return;
            }
        } else if (askFeedType.equals("answer")) {
            this.binding.radioGroup.check(2131362546);
            return;
        }
        this.binding.radioGroup.check(2131362545);
    }

    private final ColorStateList createSelectedTextColor() {
        return new ColorStateList(new int[][]{new int[]{16842912}, new int[0]}, new int[]{AppHolder.getAppTheme().getColorAccent(), AppHolder.getAppTheme().getTextColorPrimary()});
    }
}
