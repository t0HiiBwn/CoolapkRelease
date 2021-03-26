package com.coolapk.market.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemIconGridCardItemBinding;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.DyhModel;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.util.ShapeUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.cardlist.EntityListPresenter;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 82\u00020\u0001:\u00018B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u0010\u00107\u001a\u0002042\u0006\u0010\u0002\u001a\u00020\u0003H\u0016R\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001a\u0010-\u001a\u00020.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u00069"}, d2 = {"Lcom/coolapk/market/viewholder/IconGridCardItemViewHolder;", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "presenter", "Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;Lcom/coolapk/market/view/cardlist/EntityListPresenter;)V", "actionText", "", "getActionText", "()Ljava/lang/String;", "setActionText", "(Ljava/lang/String;)V", "binding", "Lcom/coolapk/market/databinding/ItemIconGridCardItemBinding;", "kotlin.jvm.PlatformType", "isFollow", "", "()Z", "setFollow", "(Z)V", "logo", "getLogo", "setLogo", "parentCard", "Lcom/coolapk/market/model/Entity;", "getParentCard", "()Lcom/coolapk/market/model/Entity;", "setParentCard", "(Lcom/coolapk/market/model/Entity;)V", "parentViewHolder", "getParentViewHolder", "()Lcom/coolapk/market/viewholder/BindingViewHolder;", "setParentViewHolder", "(Lcom/coolapk/market/viewholder/BindingViewHolder;)V", "getPresenter", "()Lcom/coolapk/market/view/cardlist/EntityListPresenter;", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "titleLine", "", "getTitleLine", "()I", "setTitleLine", "(I)V", "bindTo", "", "data", "", "onClick", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: IconGridCardItemViewHolder.kt */
public class IconGridCardItemViewHolder extends BindingViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558785;
    public String actionText;
    private final ItemIconGridCardItemBinding binding = ((ItemIconGridCardItemBinding) getBinding());
    private boolean isFollow;
    public String logo;
    private Entity parentCard;
    private BindingViewHolder parentViewHolder;
    private final EntityListPresenter presenter;
    private String subTitle;
    public String title;
    private int titleLine = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IconGridCardItemViewHolder(View view, DataBindingComponent dataBindingComponent, EntityListPresenter entityListPresenter) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
        Intrinsics.checkNotNullParameter(entityListPresenter, "presenter");
        this.presenter = entityListPresenter;
    }

    public final EntityListPresenter getPresenter() {
        return this.presenter;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/IconGridCardItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: IconGridCardItemViewHolder.kt */
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
        this.binding.itemView.setTag(2131362764, obj);
        IconGridCardItemViewHolder iconGridCardItemViewHolder = this;
        ViewUtil.clickListener(this.binding.itemView, iconGridCardItemViewHolder);
        int i = 0;
        String str = "";
        if (obj instanceof DyhModel) {
            DyhModel dyhModel = (DyhModel) obj;
            String logo2 = dyhModel.getLogo();
            if (logo2 == null) {
                logo2 = str;
            }
            this.logo = logo2;
            String title2 = dyhModel.getTitle();
            if (title2 != null) {
                str = title2;
            }
            this.title = str;
            this.subTitle = dyhModel.getFollowNum() + "人订阅";
            boolean isDyhFollowed = dyhModel.isDyhFollowed();
            this.isFollow = isDyhFollowed;
            this.actionText = isDyhFollowed ? "已订阅" : "订阅";
            this.titleLine = 2;
            z = true;
            if (AppHolder.getAppTheme().isDarkTheme()) {
                ItemIconGridCardItemBinding itemIconGridCardItemBinding = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemIconGridCardItemBinding, "binding");
                itemIconGridCardItemBinding.setPlaceHolder(2131231283);
            } else {
                ItemIconGridCardItemBinding itemIconGridCardItemBinding2 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemIconGridCardItemBinding2, "binding");
                itemIconGridCardItemBinding2.setPlaceHolder(2131231282);
            }
        } else {
            if (obj instanceof Product) {
                this.logo = EntityExtendsKt.picOrLogo((Entity) obj);
                Product product = (Product) obj;
                String title3 = product.getTitle();
                if (title3 == null) {
                    title3 = str;
                }
                this.title = title3;
                this.subTitle = product.getSubTitle();
                this.isFollow = false;
                this.actionText = str;
                this.titleLine = 2;
                ItemIconGridCardItemBinding itemIconGridCardItemBinding3 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemIconGridCardItemBinding3, "binding");
                itemIconGridCardItemBinding3.setPlaceHolder(2131231374);
            } else if (obj instanceof Entity) {
                Entity entity = (Entity) obj;
                this.logo = EntityExtendsKt.picOrLogo(entity);
                String title4 = entity.getTitle();
                if (title4 == null) {
                    title4 = str;
                }
                this.title = title4;
                this.subTitle = entity.getSubTitle();
                this.isFollow = false;
                this.actionText = str;
                this.titleLine = 2;
                ItemIconGridCardItemBinding itemIconGridCardItemBinding4 = this.binding;
                Intrinsics.checkNotNullExpressionValue(itemIconGridCardItemBinding4, "binding");
                itemIconGridCardItemBinding4.setPlaceHolder(2131231374);
            } else {
                throw new RuntimeException("unable to bind the not-entity-type ");
            }
            z = false;
        }
        ItemIconGridCardItemBinding itemIconGridCardItemBinding5 = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemIconGridCardItemBinding5, "binding");
        itemIconGridCardItemBinding5.setModel(this);
        this.binding.actionView.setTag(2131362764, obj);
        TextView textView = this.binding.actionView;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.actionView");
        if (!z) {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = this.binding.actionView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.actionView");
        textView2.setBackground(this.isFollow ? ShapeUtils.createDyhFollowedRevealBg(getContext()) : ShapeUtils.createDyhUnFollowedRevealBg(getContext()));
        ImageView imageView = this.binding.iconView;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.iconView");
        UtilExtendsKt.clipViewByData(imageView, obj, 8);
        ViewUtil.clickListener(this.binding.itemView, iconGridCardItemViewHolder);
        ViewUtil.clickListener(this.binding.actionView, iconGridCardItemViewHolder);
        this.binding.executePendingBindings();
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(2131362764);
        Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.Entity");
        Entity entity = (Entity) tag;
        int id = view.getId();
        if (id != 2131361982) {
            if (id != 2131362779) {
                super.onClick(view);
                return;
            }
            if (entity instanceof ServiceApp) {
                ServiceApp serviceApp = (ServiceApp) entity;
                ActionManager.startAppViewActivity(getContext(), serviceApp.getPackageName(), serviceApp.getExtraAnalysisData(), serviceApp.getRequestContext(), serviceApp.getExtraFromApi(), EntityExtendsKt.urlClientConfig(entity));
            } else {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            }
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
        } else if (entity instanceof DyhModel) {
            EntityListPresenter entityListPresenter = this.presenter;
            DyhModel dyhModel = (DyhModel) entity;
            String id2 = dyhModel.getId();
            Intrinsics.checkNotNull(id2);
            Intrinsics.checkNotNullExpressionValue(id2, "data.id!!");
            entityListPresenter.followSubscription(id2, dyhModel.isDyhFollowed(), dyhModel.getFollowNum());
        }
    }
}
