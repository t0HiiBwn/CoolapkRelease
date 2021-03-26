package com.coolapk.market.viewholder;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.app.OnBitmapTransformListener;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemLargeScrollCardItemBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.extend.NumberExtendsKt;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Goods;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.CircleRadiusTransform;
import com.coolapk.market.util.CircleTransform;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u0000 H2\u00020\u0001:\u0001HB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020\u0003H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\u001a\u00106\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0012\"\u0004\bA\u0010\u0014¨\u0006I"}, d2 = {"Lcom/coolapk/market/viewholder/LargeScrollCardItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "itemView", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "actionBg", "Landroid/graphics/drawable/Drawable;", "getActionBg", "()Landroid/graphics/drawable/Drawable;", "setActionBg", "(Landroid/graphics/drawable/Drawable;)V", "actionText", "", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "isFollow", "", "()Z", "setFollow", "(Z)V", "logo", "getLogo", "setLogo", "parentCard", "Lcom/coolapk/market/model/Entity;", "getParentCard", "()Lcom/coolapk/market/model/Entity;", "setParentCard", "(Lcom/coolapk/market/model/Entity;)V", "parentViewHolder", "getParentViewHolder", "()Lcom/coolapk/market/viewholder/BindingViewHolder;", "setParentViewHolder", "(Lcom/coolapk/market/viewholder/BindingViewHolder;)V", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "subTitle", "getSubTitle", "setSubTitle", "subTitleColor", "", "getSubTitleColor", "()I", "setSubTitleColor", "(I)V", "title", "getTitle", "setTitle", "titleLine", "getTitleLine", "setTitleLine", "transformer", "Lcom/coolapk/market/app/OnBitmapTransformListener;", "getTransformer", "()Lcom/coolapk/market/app/OnBitmapTransformListener;", "setTransformer", "(Lcom/coolapk/market/app/OnBitmapTransformListener;)V", "verifyStatusIcon", "getVerifyStatusIcon", "setVerifyStatusIcon", "bindTo", "", "data", "", "onClick", "view", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LargeScrollCardItemViewHolder.kt */
public class LargeScrollCardItemViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558796;
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
    private OnBitmapTransformListener transformer;
    private String verifyStatusIcon = "";

    public final EntityListPresenter getPresenter() {
        return this.presenter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LargeScrollCardItemViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "itemView");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/LargeScrollCardItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LargeScrollCardItemViewHolder.kt */
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

    public final OnBitmapTransformListener getTransformer() {
        return this.transformer;
    }

    public final void setTransformer(OnBitmapTransformListener onBitmapTransformListener) {
        this.transformer = onBitmapTransformListener;
    }

    public final Drawable getActionBg() {
        return this.actionBg;
    }

    public final void setActionBg(Drawable drawable) {
        this.actionBg = drawable;
    }

    public final int getSubTitleColor() {
        return this.subTitleColor;
    }

    public final void setSubTitleColor(int i) {
        this.subTitleColor = i;
    }

    public final String getVerifyStatusIcon() {
        return this.verifyStatusIcon;
    }

    public final void setVerifyStatusIcon(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.verifyStatusIcon = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x020b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x023b  */
    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        boolean z;
        String str;
        String str2;
        String str3;
        String verifyStatusIcon2;
        Intrinsics.checkNotNullParameter(obj, "data");
        int i = 8;
        String str4 = "";
        if (obj instanceof DyhModel) {
            DyhModel dyhModel = (DyhModel) obj;
            String logo2 = dyhModel.getLogo();
            if (logo2 == null) {
                logo2 = str4;
            }
            this.logo = logo2;
            String title2 = dyhModel.getTitle();
            if (title2 == null) {
                title2 = str4;
            }
            this.title = title2;
            this.subTitle = dyhModel.getFollowNum() + "人订阅";
            boolean isDyhFollowed = dyhModel.isDyhFollowed();
            this.isFollow = isDyhFollowed;
            this.actionText = isDyhFollowed ? "已订阅" : "订阅";
            this.titleLine = 2;
            this.transformer = new CircleTransform(false, 0, 3, null);
            this.actionBg = this.isFollow ? ShapeUtils.createDyhFollowedRevealBg(getContext()) : ShapeUtils.createDyhUnFollowedRevealBg(getContext());
            this.subTitleColor = AppHolder.getAppTheme().getTextColorSecondary();
            this.verifyStatusIcon = str4;
        } else if (obj instanceof User) {
            User user = (User) obj;
            String userAvatar = user.getUserAvatar();
            if (userAvatar == null) {
                userAvatar = str4;
            }
            this.logo = userAvatar;
            String userName = user.getUserName();
            if (userName == null) {
                userName = str4;
            }
            this.title = userName;
            this.subTitle = user.getSubTitle();
            boolean z2 = user.getIsFollow() == 1;
            this.isFollow = z2;
            if (z2) {
                str3 = getContext().getString(2131886114);
                str2 = "context.getString(R.string.action_already_follow)";
            } else {
                str3 = getContext().getString(2131886134);
                str2 = "context.getString(R.stri…action_follow_him_or_her)";
            }
            Intrinsics.checkNotNullExpressionValue(str3, str2);
            this.actionText = str3;
            this.titleLine = 1;
            this.actionBg = this.isFollow ? ShapeUtils.createDyhFollowedRevealBg(getContext()) : ShapeUtils.createDyhUnFollowedRevealBg(getContext());
            this.transformer = new CircleTransform(false, 0, 3, null);
            this.subTitleColor = AppHolder.getAppTheme().getTextColorSecondary();
            UserInfo userInfo = user.getUserInfo();
            if (!(userInfo == null || (verifyStatusIcon2 = userInfo.getVerifyStatusIcon()) == null)) {
                str4 = verifyStatusIcon2;
            }
            this.verifyStatusIcon = str4;
        } else if (obj instanceof Goods) {
            Goods goods = (Goods) obj;
            String goodsPic = goods.getGoodsPic();
            if (goodsPic == null) {
                goodsPic = str4;
            }
            this.logo = goodsPic;
            String goodsTitle = goods.getGoodsTitle();
            if (goodsTitle == null) {
                goodsTitle = str4;
            }
            this.title = goodsTitle;
            this.subTitle = goods.getPromoTitle();
            this.isFollow = false;
            this.actionText = "立即购买";
            this.titleLine = 2;
            this.actionBg = ShapeUtils.createActionCornerBg(getContext(), ResourceUtils.getColorInt(getContext(), 2131100035));
            this.transformer = new CircleRadiusTransform(NumberExtendsKt.getDpf((Number) 8), false, 2, null);
            this.subTitleColor = ResourceUtils.getColorInt(getContext(), 2131100035);
            this.verifyStatusIcon = str4;
        } else if (obj instanceof Entity) {
            Entity entity = (Entity) obj;
            this.logo = EntityExtendsKt.picOrLogo(entity);
            String title3 = entity.getTitle();
            if (title3 == null) {
                title3 = str4;
            }
            this.title = title3;
            this.subTitle = entity.getSubTitle();
            this.isFollow = false;
            this.actionText = str4;
            this.titleLine = 2;
            this.transformer = new CircleTransform(false, 0, 3, null);
            this.subTitleColor = AppHolder.getAppTheme().getTextColorSecondary();
            this.verifyStatusIcon = str4;
            z = false;
            ItemLargeScrollCardItemBinding itemLargeScrollCardItemBinding = (ItemLargeScrollCardItemBinding) getBinding();
            LinearLayout linearLayout = itemLargeScrollCardItemBinding.itemView;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setStroke(NumberExtendsKt.getDp(Double.valueOf(0.5d)), AppHolder.getAppTheme().getCurrencyColorDivider());
            gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
            gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
            Unit unit = Unit.INSTANCE;
            linearLayout.setBackground(gradientDrawable);
            itemLargeScrollCardItemBinding.itemView.setTag(2131362753, obj);
            itemLargeScrollCardItemBinding.actionView.setTag(2131362753, obj);
            itemLargeScrollCardItemBinding.subTitleView.setTag(2131362753, obj);
            TextView textView = itemLargeScrollCardItemBinding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
            textView.setVisibility(!z ? 0 : 8);
            TextView textView2 = itemLargeScrollCardItemBinding.actionView;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
            textView2.setBackground(this.actionBg);
            itemLargeScrollCardItemBinding.subTitleView.setTextColor(this.subTitleColor);
            TextView textView3 = itemLargeScrollCardItemBinding.subTitleView;
            Intrinsics.checkNotNullExpressionValue(textView3, "binding.subTitleView");
            str = this.subTitle;
            if (!(str != null || str.length() == 0)) {
                i = 0;
            }
            textView3.setVisibility(i);
            LargeScrollCardItemViewHolder largeScrollCardItemViewHolder = this;
            ViewUtil.clickListener(itemLargeScrollCardItemBinding.itemView, largeScrollCardItemViewHolder);
            ViewUtil.clickListener(itemLargeScrollCardItemBinding.actionView, largeScrollCardItemViewHolder);
            Intrinsics.checkNotNullExpressionValue(itemLargeScrollCardItemBinding, "binding");
            itemLargeScrollCardItemBinding.setModel(this);
            itemLargeScrollCardItemBinding.setTransformer(this.transformer);
            itemLargeScrollCardItemBinding.executePendingBindings();
        } else {
            throw new RuntimeException("unable to bind the not-entity-type ");
        }
        z = true;
        ItemLargeScrollCardItemBinding itemLargeScrollCardItemBinding = (ItemLargeScrollCardItemBinding) getBinding();
        LinearLayout linearLayout = itemLargeScrollCardItemBinding.itemView;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.itemView");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(NumberExtendsKt.getDp(Double.valueOf(0.5d)), AppHolder.getAppTheme().getCurrencyColorDivider());
        gradientDrawable.setCornerRadius((float) NumberExtendsKt.getDp((Number) 4));
        gradientDrawable.setColor(AppHolder.getAppTheme().getContentBackgroundColor());
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        itemLargeScrollCardItemBinding.itemView.setTag(2131362753, obj);
        itemLargeScrollCardItemBinding.actionView.setTag(2131362753, obj);
        itemLargeScrollCardItemBinding.subTitleView.setTag(2131362753, obj);
        TextView textView = itemLargeScrollCardItemBinding.actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        textView.setVisibility(!z ? 0 : 8);
        TextView textView2 = itemLargeScrollCardItemBinding.actionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
        textView2.setBackground(this.actionBg);
        itemLargeScrollCardItemBinding.subTitleView.setTextColor(this.subTitleColor);
        TextView textView3 = itemLargeScrollCardItemBinding.subTitleView;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.subTitleView");
        str = this.subTitle;
        if (!(str != null || str.length() == 0)) {
        }
        textView3.setVisibility(i);
        LargeScrollCardItemViewHolder largeScrollCardItemViewHolder = this;
        ViewUtil.clickListener(itemLargeScrollCardItemBinding.itemView, largeScrollCardItemViewHolder);
        ViewUtil.clickListener(itemLargeScrollCardItemBinding.actionView, largeScrollCardItemViewHolder);
        Intrinsics.checkNotNullExpressionValue(itemLargeScrollCardItemBinding, "binding");
        itemLargeScrollCardItemBinding.setModel(this);
        itemLargeScrollCardItemBinding.setTransformer(this.transformer);
        itemLargeScrollCardItemBinding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(2131362753);
        int id = view.getId();
        if (id != 2131361981) {
            if (id != 2131362768) {
                super.onClick(view);
            } else if (tag instanceof Entity) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Entity entity = (Entity) tag;
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
                StatisticHelper instance = StatisticHelper.Companion.getInstance();
                DataBindingComponent component = getComponent();
                int i = null;
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
                BindingViewHolder bindingViewHolder = this.parentViewHolder;
                if (bindingViewHolder != null) {
                    i = Integer.valueOf(bindingViewHolder.getAdapterPosition());
                }
                if (i == null) {
                    i = -1;
                }
                StatisticHelper.recordEntityEvent$default(instance, fixedRecordId, entity, i.intValue(), this.parentCard, null, 16, null);
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
        }
    }
}
