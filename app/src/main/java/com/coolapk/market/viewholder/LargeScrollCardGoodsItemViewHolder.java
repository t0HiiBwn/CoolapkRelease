package com.coolapk.market.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemLargeScrollCardGoodsItemBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Goods;
import com.coolapk.market.model.User;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 92\u00020\u0001:\u00019B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u0003H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000e\"\u0004\b(\u0010\u0010R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u000e\"\u0004\b-\u0010\u0010R\u001a\u0010.\u001a\u00020*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/coolapk/market/viewholder/LargeScrollCardGoodsItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "actionBg", "Landroid/graphics/drawable/Drawable;", "actionText", "", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "isFollow", "", "()Z", "setFollow", "(Z)V", "logo", "getLogo", "setLogo", "parentCard", "Lcom/coolapk/market/model/Entity;", "getParentCard", "()Lcom/coolapk/market/model/Entity;", "setParentCard", "(Lcom/coolapk/market/model/Entity;)V", "parentViewHolder", "getParentViewHolder", "()Lcom/coolapk/market/viewholder/BindingViewHolder;", "setParentViewHolder", "(Lcom/coolapk/market/viewholder/BindingViewHolder;)V", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "subTitle", "getSubTitle", "setSubTitle", "subTitleColor", "", "title", "getTitle", "setTitle", "titleLine", "getTitleLine", "()I", "setTitleLine", "(I)V", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LargeScrollCardGoodsItemViewHolder.kt */
public class LargeScrollCardGoodsItemViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558795;
    private Drawable actionBg;
    public String actionText;
    private boolean isFollow;
    public String logo;
    private Entity parentCard;
    private BindingViewHolder parentViewHolder;
    private final EntityListPresenter presenter;
    private String subTitle;
    private int subTitleColor;
    public String title;
    private int titleLine = 1;

    public final EntityListPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LargeScrollCardGoodsItemViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/LargeScrollCardGoodsItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LargeScrollCardGoodsItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final String getLogo() {
        String str = this.logo;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("logo");
        }
        return str;
    }

    public final void setLogo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.logo = str;
    }

    public final String getTitle() {
        String str = this.title;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        }
        return str;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getActionText() {
        String str = this.actionText;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionText");
        }
        return str;
    }

    public final void setActionText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.actionText = str;
    }

    public final int getTitleLine() {
        return this.titleLine;
    }

    public final void setTitleLine(int i) {
        this.titleLine = i;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        this.subTitle = str;
    }

    public final boolean isFollow() {
        return this.isFollow;
    }

    public final void setFollow(boolean z) {
        this.isFollow = z;
    }

    public final Entity getParentCard() {
        return this.parentCard;
    }

    public final void setParentCard(Entity entity) {
        this.parentCard = entity;
    }

    public final BindingViewHolder getParentViewHolder() {
        return this.parentViewHolder;
    }

    public final void setParentViewHolder(BindingViewHolder bindingViewHolder) {
        this.parentViewHolder = bindingViewHolder;
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        boolean z;
        Intrinsics.checkNotNullParameter(obj, "data");
        String str = "";
        if (obj instanceof Goods) {
            Goods goods = (Goods) obj;
            String goodsPic = goods.getGoodsPic();
            if (goodsPic == null) {
                goodsPic = str;
            }
            this.logo = goodsPic;
            String goodsTitle = goods.getGoodsTitle();
            if (goodsTitle != null) {
                str = goodsTitle;
            }
            this.title = str;
            this.subTitle = goods.getPromoTitle();
            this.isFollow = false;
            String buyShowText = goods.getBuyShowText();
            Intrinsics.checkNotNullExpressionValue(buyShowText, "data.buyShowText");
            this.actionText = buyShowText;
            this.titleLine = 2;
            this.actionBg = ShapeUtils.createActionCornerBg(getContext(), ResourceUtils.getColorInt(getContext(), 2131100035));
            this.subTitleColor = ResourceUtils.getColorInt(getContext(), 2131100035);
            z = true;
        } else if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            this.logo = EntityExtendsKt.picOrLogo(entity);
            String title2 = entity.getTitle();
            if (title2 == null) {
                title2 = str;
            }
            this.title = title2;
            this.subTitle = entity.getSubTitle();
            this.isFollow = false;
            this.actionText = str;
            this.titleLine = 2;
            this.subTitleColor = AppHolder.getAppTheme().getTextColorSecondary();
            z = false;
        } else {
            throw new RuntimeException("unable to bind the not-entity-type ");
        }
        ItemLargeScrollCardGoodsItemBinding itemLargeScrollCardGoodsItemBinding = (ItemLargeScrollCardGoodsItemBinding) getBinding();
        itemLargeScrollCardGoodsItemBinding.itemView.setTag(2131362753, obj);
        itemLargeScrollCardGoodsItemBinding.actionView.setTag(2131362753, obj);
        itemLargeScrollCardGoodsItemBinding.subTitleView.setTag(2131362753, obj);
        TextView textView = itemLargeScrollCardGoodsItemBinding.actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setVisibility(z ? 0 : 8);
        TextView textView2 = itemLargeScrollCardGoodsItemBinding.actionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
        textView2.setBackground(this.actionBg);
        itemLargeScrollCardGoodsItemBinding.subTitleView.setTextColor(this.subTitleColor);
        TextView textView3 = itemLargeScrollCardGoodsItemBinding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.subTitleView");
        String str2 = this.subTitle;
        textView3.setVisibility((str2 == null || str2.length() == 0) ^ true ? 0 : 8);
        LargeScrollCardGoodsItemViewHolder largeScrollCardGoodsItemViewHolder = this;
        ViewUtil.clickListener(itemLargeScrollCardGoodsItemBinding.itemView, largeScrollCardGoodsItemViewHolder);
        ViewUtil.clickListener(itemLargeScrollCardGoodsItemBinding.actionView, largeScrollCardGoodsItemViewHolder);
        Intrinsics.checkNotNullExpressionValue(itemLargeScrollCardGoodsItemBinding, "binding");
        itemLargeScrollCardGoodsItemBinding.setModel(this);
        itemLargeScrollCardGoodsItemBinding.setTransformer(new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 8), false, 2, null));
        CardView cardView = itemLargeScrollCardGoodsItemBinding.itemView;
        cardView.setCardBackgroundColor(ColorStateList.valueOf(AppHolder.getAppTheme().getContentBackgroundColor()));
        cardView.setCardElevation(0.0f);
        itemLargeScrollCardGoodsItemBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(2131362753);
        int id = view.getId();
        if (id != 2131361981) {
            if (id != 2131362768) {
                super.onClick(view);
                return;
            }
            int i = null;
            if (tag instanceof Goods) {
                Goods goods = (Goods) tag;
                if (goods.isDirect()) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    ActionManagerCompat.startActivityByUrl(context, goods.getGoodsBuyUrl(), goods.getTitle(), goods.getSubTitle());
                } else {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    ActionManagerCompat.startActivityByUrl(context2, goods.getGoodsUrl(), goods.getTitle(), goods.getSubTitle());
                }
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = getComponent();
                if (!(component instanceof FragmentBindingComponent)) {
                    component = null;
                }
                FragmentBindingComponent fragmentBindingComponent = (FragmentBindingComponent) component;
                Fragment fragment = fragmentBindingComponent != null ? (Fragment) fragmentBindingComponent.getContainer() : null;
                if (!(fragment instanceof BaseFragment)) {
                    fragment = null;
                }
                BaseFragment baseFragment = (BaseFragment) fragment;
                String fixedRecordId = baseFragment != null ? baseFragment.getFixedRecordId() : null;
                Entity entity = (Entity) tag;
                BindingViewHolder bindingViewHolder = this.parentViewHolder;
                if (bindingViewHolder != null) {
                    i = Integer.valueOf(bindingViewHolder.getAdapterPosition());
                }
                if (i == null) {
                    i = -1;
                }
                StatisticHelper.recordEntityEvent$default(instance, fixedRecordId, entity, i.intValue(), this.parentCard, null, 16, null);
            } else if (tag instanceof Entity) {
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "context");
                Entity entity2 = (Entity) tag;
                ActionManagerCompat.startActivityByUrl(context3, entity2.getUrl(), entity2.getTitle(), entity2.getSubTitle());
                StatisticHelper instance2 = StatisticHelper.Companion.getInstance();
                DataBindingComponent component2 = getComponent();
                if (!(component2 instanceof FragmentBindingComponent)) {
                    component2 = null;
                }
                FragmentBindingComponent fragmentBindingComponent2 = (FragmentBindingComponent) component2;
                Fragment fragment2 = fragmentBindingComponent2 != null ? (Fragment) fragmentBindingComponent2.getContainer() : null;
                if (!(fragment2 instanceof BaseFragment)) {
                    fragment2 = null;
                }
                BaseFragment baseFragment2 = (BaseFragment) fragment2;
                String fixedRecordId2 = baseFragment2 != null ? baseFragment2.getFixedRecordId() : null;
                BindingViewHolder bindingViewHolder2 = this.parentViewHolder;
                if (bindingViewHolder2 != null) {
                    i = Integer.valueOf(bindingViewHolder2.getAdapterPosition());
                }
                if (i == null) {
                    i = -1;
                }
                StatisticHelper.recordEntityEvent$default(instance2, fixedRecordId2, entity2, i.intValue(), this.parentCard, null, 16, null);
            }
        } else if (tag instanceof DyhModel) {
            EntityListPresenter entityListPresenter = this.presenter;
            DyhModel dyhModel = (DyhModel) tag;
            String id2 = dyhModel.getId();
            Intrinsics.checkNotNull(id2);
            Intrinsics.checkNotNullExpressionValue(id2, "data.id!!");
            entityListPresenter.followSubscription(id2, dyhModel.isDyhFollowed(), dyhModel.getFollowNum());
        } else if (tag instanceof User) {
            EntityListPresenter entityListPresenter2 = this.presenter;
            String uid = ((User) tag).getUid();
            Intrinsics.checkNotNullExpressionValue(uid, "data.uid");
            entityListPresenter2.followUser(uid);
        } else if (tag instanceof Goods) {
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            Goods goods2 = (Goods) tag;
            ActionManagerCompat.startActivityByUrl(context4, goods2.getGoodsBuyUrl(), goods2.getTitle(), goods2.getSubTitle());
        }
    }
}
