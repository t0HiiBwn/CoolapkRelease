package com.coolapk.market.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import com.coolapk.market.databinding.ItemHotSearchUserBinding;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.User;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import com.coolapk.market.widget.UserAvatarView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/coolapk/market/viewholder/HotSearchUserViewHolder;", "Lcom/coolapk/market/viewholder/GenericBindHolder;", "Lcom/coolapk/market/databinding/ItemHotSearchUserBinding;", "Lcom/coolapk/market/model/User;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "user", "bindToContent", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: HotSearchUserViewHolder.kt */
public final class HotSearchUserViewHolder extends GenericBindHolder<ItemHotSearchUserBinding, User> {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558776;
    private final EntityListPresenter presenter;
    private User user;

    public final EntityListPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HotSearchUserViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
        Drawable mutate = ResourceUtils.getDrawable(getContext(), 2131231605).mutate();
        mutate.setTint(ResourceUtils.getColorInt(getContext(), 2131100011));
        mutate.setBounds(0, 0, NumberExtendsKt.getDp((Number) 12), NumberExtendsKt.getDp((Number) 12));
        Intrinsics.checkNotNullExpressionValue(mutate, "ResourceUtils.getDrawabl… 12.dp)\n                }");
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{mutate});
        layerDrawable.setLayerInset(0, 0, 0, NumberExtendsKt.getDp((Number) 1), 0);
        layerDrawable.setBounds(0, 0, NumberExtendsKt.getDp((Number) 13), NumberExtendsKt.getDp((Number) 12));
        ((ItemHotSearchUserBinding) getBinding()).subTitleView.setCompoundDrawables(layerDrawable, null, null, null);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/HotSearchUserViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: HotSearchUserViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public void bindToContent(User user2) {
        Intrinsics.checkNotNullParameter(user2, "user");
        this.user = user2;
        ItemHotSearchUserBinding itemHotSearchUserBinding = (ItemHotSearchUserBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemHotSearchUserBinding, "binding");
        itemHotSearchUserBinding.setOnClick(this);
        ItemHotSearchUserBinding itemHotSearchUserBinding2 = (ItemHotSearchUserBinding) getBinding();
        Intrinsics.checkNotNullExpressionValue(itemHotSearchUserBinding2, "binding");
        itemHotSearchUserBinding2.setModel(user2);
        TextView textView = ((ItemHotSearchUserBinding) getBinding()).subTitleView;
        textView.setText(KotlinExtendKt.toDisplayString(user2.getLikeNum()));
        textView.setTextColor(ResourceUtils.getColorInt(textView.getContext(), 2131100011));
        ((ItemHotSearchUserBinding) getBinding()).executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onClick(view);
        int id = view.getId();
        if (id == 2131361886) {
            User user2 = this.user;
            if (user2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            if (user2.getIsFollow() == 0) {
                EntityListPresenter entityListPresenter = this.presenter;
                User user3 = this.user;
                if (user3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("user");
                }
                String uid = user3.getUid();
                Intrinsics.checkNotNullExpressionValue(uid, "user.uid");
                entityListPresenter.followUser(uid);
                return;
            }
            EntityListPresenter entityListPresenter2 = this.presenter;
            User user4 = this.user;
            if (user4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            String uid2 = user4.getUid();
            Intrinsics.checkNotNullExpressionValue(uid2, "user.uid");
            entityListPresenter2.unfollowUser(uid2);
        } else if (id == 2131362200) {
            UserAvatarView userAvatarView = ((ItemHotSearchUserBinding) getBinding()).iconView;
            User user5 = this.user;
            if (user5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            String uid3 = user5.getUid();
            User user6 = this.user;
            if (user6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("user");
            }
            ActionManager.startUserSpaceActivity(userAvatarView, uid3, user6.getUserAvatar());
        }
    }
}
