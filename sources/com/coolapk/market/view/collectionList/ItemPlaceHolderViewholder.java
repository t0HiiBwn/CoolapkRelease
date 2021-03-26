package com.coolapk.market.view.collectionList;

import android.content.Context;
import android.view.View;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.databinding.ItemPlaceHolderBinding;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.ItemPlaceHolder;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.view.collectionList.AppViewForCollectionItemDialog;
import com.coolapk.market.viewholder.GenericBindHolder;
import com.coolapk.market.viewholder.ItemActionHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/collectionList/ItemPlaceHolderViewholder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemPlaceHolderBinding;", "Lcom/coolapk/market/model/ItemPlaceHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "onItemClick", "Lcom/coolapk/market/viewholder/ItemActionHandler;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/viewholder/ItemActionHandler;)V", "bindToContent", "", "entity", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ItemPlaceHolderViewholder.kt */
public final class ItemPlaceHolderViewholder extends GenericBindHolder<ItemPlaceHolderBinding, ItemPlaceHolder> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558858;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemPlaceHolderViewholder(View view, DataBindingComponent dataBindingComponent, ItemActionHandler itemActionHandler) {
        super(view, dataBindingComponent, itemActionHandler);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
    }

    public void bindToContent(ItemPlaceHolder itemPlaceHolder) {
        Intrinsics.checkNotNullParameter(itemPlaceHolder, "entity");
        ItemPlaceHolderBinding itemPlaceHolderBinding = (ItemPlaceHolderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemPlaceHolderBinding, "binding");
        itemPlaceHolderBinding.setModel(itemPlaceHolder);
        ItemPlaceHolderBinding itemPlaceHolderBinding2 = (ItemPlaceHolderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemPlaceHolderBinding2, "binding");
        itemPlaceHolderBinding2.setClick(this);
        ItemPlaceHolderBinding itemPlaceHolderBinding3 = (ItemPlaceHolderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemPlaceHolderBinding3, "binding");
        itemPlaceHolderBinding3.setTransformer(new CircleTransform(false, 0, 3, null));
        ((ItemPlaceHolderBinding) getBinding()).executePendingBindings();
        ((ItemPlaceHolderBinding) getBinding()).itemView.setOnLongClickListener(new ItemPlaceHolderViewholder$bindToContent$1(this, itemPlaceHolder));
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        Intrinsics.checkNotNull(view);
        int id = view.getId();
        if (id != 2131362095) {
            if (id == 2131362374) {
                ItemPlaceHolderBinding itemPlaceHolderBinding = (ItemPlaceHolderBinding) getBinding();
                Intrinsics.checkNotNullExpressionValue(itemPlaceHolderBinding, "binding");
                ItemPlaceHolder model = itemPlaceHolderBinding.getModel();
                Intrinsics.checkNotNull(model);
                Intrinsics.checkNotNullExpressionValue(model, "binding.model!!");
                if (model.isMe()) {
                    AppViewForCollectionItemDialog.Companion companion = AppViewForCollectionItemDialog.Companion;
                    ItemPlaceHolderBinding itemPlaceHolderBinding2 = (ItemPlaceHolderBinding) getBinding();
                    Intrinsics.checkNotNullExpressionValue(itemPlaceHolderBinding2, "binding");
                    ItemPlaceHolder model2 = itemPlaceHolderBinding2.getModel();
                    Intrinsics.checkNotNull(model2);
                    Intrinsics.checkNotNullExpressionValue(model2, "binding.model!!");
                    AppViewForCollectionItemDialog newInstance = companion.newInstance(model2);
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(context).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context.requireAppCompat…().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                    return;
                }
                return;
            } else if (id != 2131363886) {
                return;
            }
        }
        Context context2 = getContext();
        ItemPlaceHolderBinding itemPlaceHolderBinding3 = (ItemPlaceHolderBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemPlaceHolderBinding3, "binding");
        ItemPlaceHolder model3 = itemPlaceHolderBinding3.getModel();
        Intrinsics.checkNotNull(model3);
        Intrinsics.checkNotNullExpressionValue(model3, "binding.model!!");
        ActionManager.startUserSpaceActivity(context2, model3.getUid());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/view/collectionList/ItemPlaceHolderViewholder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ItemPlaceHolderViewholder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
