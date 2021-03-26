package com.coolapk.market.view.collectionList;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.databinding.ItemCollectionBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.Collection;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionItemViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemCollectionBinding;", "Lcom/coolapk/market/model/Collection;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: CollectionItemViewholder.kt */
public final class CollectionItemViewholder extends GenericBindHolder<ItemCollectionBinding, Collection> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558659;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CollectionItemViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0049, code lost:
        if (r0 == false) goto L_0x0050;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0079  */
    public void bindToContent(Collection collection) {
        boolean z;
        Intrinsics.checkNotNullParameter(collection, "entity");
        ItemCollectionBinding itemCollectionBinding = (ItemCollectionBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCollectionBinding, "binding");
        itemCollectionBinding.setModel(collection);
        ItemCollectionBinding itemCollectionBinding2 = (ItemCollectionBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemCollectionBinding2, "binding");
        itemCollectionBinding2.setClick(this);
        Activity currentActivity = AppHolder.getCurrentActivity();
        int i = 0;
        if (currentActivity != null) {
            try {
                Fragment findFragmentById = ContextExtendsKt.requireAppCompatActivity(currentActivity).getSupportFragmentManager().findFragmentById(2131363614);
                boolean z2 = currentActivity instanceof CollectionSelectActivity;
                z = true;
                if (!(findFragmentById != null && (findFragmentById instanceof CollectionListFragment))) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            TextView textView = ((ItemCollectionBinding) getBinding()).statusView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.statusView");
            textView.setVisibility(!z ? 0 : 8);
            ImageView imageView = ((ItemCollectionBinding) getBinding()).imgView;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.imgView");
            if (!z) {
                i = 8;
            }
            imageView.setVisibility(i);
            ((ItemCollectionBinding) getBinding()).executePendingBindings();
            ((ItemCollectionBinding) getBinding()).itemView.setOnLongClickListener(new CollectionItemViewholder$bindToContent$1(this, collection));
        }
        z = false;
        TextView textView = ((ItemCollectionBinding) getBinding()).statusView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.statusView");
        textView.setVisibility(!z ? 0 : 8);
        ImageView imageView = ((ItemCollectionBinding) getBinding()).imgView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.imgView");
        if (!z) {
        }
        imageView.setVisibility(i);
        ((ItemCollectionBinding) getBinding()).executePendingBindings();
        ((ItemCollectionBinding) getBinding()).itemView.setOnLongClickListener(new CollectionItemViewholder$bindToContent$1(this, collection));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        if (view.getId() == 2131362779) {
            Context context = getContext();
            ItemCollectionBinding itemCollectionBinding = (ItemCollectionBinding) getBinding();
            Intrinsics.checkNotNullExpressionValue(itemCollectionBinding, "binding");
            Collection model = itemCollectionBinding.getModel();
            Intrinsics.checkNotNull(model);
            Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
            ActionManager.startCollectionDetailActivity(context, model.getId());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/collectionList/CollectionItemViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: CollectionItemViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
