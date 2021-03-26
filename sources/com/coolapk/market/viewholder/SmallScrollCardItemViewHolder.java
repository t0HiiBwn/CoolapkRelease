package com.coolapk.market.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.fragment.app.Fragment;
import com.coolapk.market.AppHolder;
import com.coolapk.market.binding.FragmentBindingComponent;
import com.coolapk.market.databinding.ItemSmallScrollCardItemBinding;
import com.coolapk.market.event.Event;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.User;
import com.coolapk.market.model.UserInfo;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.util.UtilExtendsKt;
import com.coolapk.market.util.ViewUtil;
import com.coolapk.market.view.base.BaseFragment;
import com.coolapk.market.view.product.ProductGlobalData;
import com.coolapk.market.widget.UserAvatarView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 H2\u00020\u0001:\u0001HB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020@H\u0014J\u0010\u0010D\u001a\u00020@2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020GH\u0016R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\u001c\u00106\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001b\"\u0004\b8\u0010\u001dR\u001a\u00109\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001b\"\u0004\b;\u0010\u001dR\u001a\u0010<\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017¨\u0006I"}, d2 = {"Lcom/coolapk/market/viewholder/SmallScrollCardItemViewHolder;", "Lcom/coolapk/market/viewholder/StateViewHolder;", "view", "Landroid/view/View;", "component", "Landroidx/databinding/DataBindingComponent;", "(Landroid/view/View;Landroidx/databinding/DataBindingComponent;)V", "binding", "Lcom/coolapk/market/databinding/ItemSmallScrollCardItemBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/coolapk/market/databinding/ItemSmallScrollCardItemBinding;", "hiddenScore", "", "getHiddenScore", "()Z", "setHiddenScore", "(Z)V", "imagePlaceHolderId", "", "getImagePlaceHolderId", "()I", "setImagePlaceHolderId", "(I)V", "logo", "", "getLogo", "()Ljava/lang/String;", "setLogo", "(Ljava/lang/String;)V", "parentCard", "Lcom/coolapk/market/model/Entity;", "getParentCard", "()Lcom/coolapk/market/model/Entity;", "setParentCard", "(Lcom/coolapk/market/model/Entity;)V", "parentViewHolder", "Lcom/coolapk/market/viewholder/BindingViewHolder;", "getParentViewHolder", "()Lcom/coolapk/market/viewholder/BindingViewHolder;", "setParentViewHolder", "(Lcom/coolapk/market/viewholder/BindingViewHolder;)V", "score", "getScore", "setScore", "serviceApp", "Lcom/coolapk/market/model/ServiceApp;", "getServiceApp", "()Lcom/coolapk/market/model/ServiceApp;", "setServiceApp", "(Lcom/coolapk/market/model/ServiceApp;)V", "showDownloadButton", "getShowDownloadButton", "setShowDownloadButton", "subTitle", "getSubTitle", "setSubTitle", "title", "getTitle", "setTitle", "titleLine", "getTitleLine", "setTitleLine", "bindTo", "", "data", "", "onBindWithApp", "onClick", "onStateEventChanged", "event", "Lcom/coolapk/market/event/Event;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: SmallScrollCardItemViewHolder.kt */
public class SmallScrollCardItemViewHolder extends StateViewHolder {
    public static final Companion Companion = new Companion(null);
    public static final int LAYOUT_ID = 2131558942;
    private final ItemSmallScrollCardItemBinding binding = ((ItemSmallScrollCardItemBinding) getBinding());
    private boolean hiddenScore;
    private int imagePlaceHolderId;
    public String logo;
    private Entity parentCard;
    private BindingViewHolder parentViewHolder;
    private String score;
    private ServiceApp serviceApp;
    private boolean showDownloadButton;
    private String subTitle;
    public String title;
    private int titleLine = 1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallScrollCardItemViewHolder(View view, DataBindingComponent dataBindingComponent) {
        super(view, dataBindingComponent, null);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dataBindingComponent, "component");
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

    public final int getImagePlaceHolderId() {
        return this.imagePlaceHolderId;
    }

    public final void setImagePlaceHolderId(int i) {
        this.imagePlaceHolderId = i;
    }

    public final String getScore() {
        return this.score;
    }

    public final void setScore(String str) {
        this.score = str;
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
    public final ItemSmallScrollCardItemBinding getBinding() {
        return this.binding;
    }

    public final ServiceApp getServiceApp() {
        return this.serviceApp;
    }

    public final void setServiceApp(ServiceApp serviceApp2) {
        this.serviceApp = serviceApp2;
    }

    public final boolean getShowDownloadButton() {
        return this.showDownloadButton;
    }

    public final void setShowDownloadButton(boolean z) {
        this.showDownloadButton = z;
    }

    public final boolean getHiddenScore() {
        return this.hiddenScore;
    }

    public final void setHiddenScore(boolean z) {
        this.hiddenScore = z;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/coolapk/market/viewholder/SmallScrollCardItemViewHolder$Companion;", "", "()V", "LAYOUT_ID", "", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: SmallScrollCardItemViewHolder.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.coolapk.market.viewholder.BindingViewHolder
    public void bindTo(Object obj) {
        int i = 2;
        String str = "";
        boolean z = false;
        if (obj instanceof User) {
            User user = (User) obj;
            String userAvatar = user.getUserAvatar();
            if (userAvatar == null) {
                userAvatar = str;
            }
            this.logo = userAvatar;
            String userName = user.getUserName();
            Intrinsics.checkNotNullExpressionValue(userName, "data.userName");
            this.title = userName;
            this.subTitle = str;
            Entity entity = this.parentCard;
            if (entity != null) {
                if (EntityExtendsKt.isSingleLineTitle(entity)) {
                    i = 1;
                }
                this.titleLine = i;
            }
            this.imagePlaceHolderId = 2131231162;
            this.score = null;
            UserAvatarView userAvatarView = this.binding.iconView;
            UserInfo userInfo = user.getUserInfo();
            userAvatarView.bind(userInfo != null ? userInfo.getVerifyStatusIcon() : null, true);
            UserAvatarView userAvatarView2 = this.binding.iconView;
            Intrinsics.checkNotNullExpressionValue(userAvatarView2, "binding.iconView");
            userAvatarView2.setClipToOutline(false);
            this.serviceApp = null;
        } else if (obj instanceof ServiceApp) {
            this.logo = EntityExtendsKt.picOrLogo((Entity) obj);
            ServiceApp serviceApp2 = (ServiceApp) obj;
            String appName = serviceApp2.getAppName();
            if (appName != null) {
                str = appName;
            }
            this.title = str;
            this.titleLine = 1;
            this.imagePlaceHolderId = 2131231374;
            this.score = serviceApp2.getScore();
            this.subTitle = serviceApp2.getSubTitle();
            this.binding.iconView.bind(null, false);
            UserAvatarView userAvatarView3 = this.binding.iconView;
            Intrinsics.checkNotNullExpressionValue(userAvatarView3, "binding.iconView");
            UtilExtendsKt.clipViewByData(userAvatarView3, obj, 8);
            this.serviceApp = serviceApp2;
        } else if (obj instanceof Product) {
            this.logo = EntityExtendsKt.picOrLogo((Entity) obj);
            Product product = (Product) obj;
            String title2 = product.getTitle();
            if (title2 != null) {
                str = title2;
            }
            this.title = str;
            this.subTitle = product.getSubTitle();
            this.titleLine = 2;
            this.imagePlaceHolderId = 2131231374;
            this.score = null;
            this.binding.iconView.bind(null, false);
            UserAvatarView userAvatarView4 = this.binding.iconView;
            Intrinsics.checkNotNullExpressionValue(userAvatarView4, "binding.iconView");
            UtilExtendsKt.clipViewByData(userAvatarView4, obj, 8);
            this.serviceApp = null;
        } else if (obj instanceof Entity) {
            Entity entity2 = (Entity) obj;
            this.logo = EntityExtendsKt.picOrLogo(entity2);
            String title3 = entity2.getTitle();
            if (title3 != null) {
                str = title3;
            }
            this.title = str;
            this.subTitle = entity2.getSubTitle();
            this.titleLine = 1;
            this.imagePlaceHolderId = 2131231374;
            this.score = null;
            this.binding.iconView.bind(null, false);
            UserAvatarView userAvatarView5 = this.binding.iconView;
            Intrinsics.checkNotNullExpressionValue(userAvatarView5, "binding.iconView");
            UtilExtendsKt.clipViewByData(userAvatarView5, obj, 8);
            this.serviceApp = null;
        }
        Entity entity3 = this.parentCard;
        this.showDownloadButton = entity3 != null && EntityExtendsKt.getIntExtraData(entity3, "showDownloadButton", 0) == 1;
        Entity entity4 = this.parentCard;
        if (entity4 != null && EntityExtendsKt.getIntExtraData(entity4, "hiddenScore", 0) == 1) {
            z = true;
        }
        this.hiddenScore = z;
        Entity entity5 = this.parentCard;
        if (entity5 != null) {
            TextView textView = this.binding.titleView;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.titleView");
            textView.setTextSize((float) EntityExtendsKt.getTextSizeInt(entity5));
        }
        ItemSmallScrollCardItemBinding itemSmallScrollCardItemBinding = this.binding;
        Intrinsics.checkNotNullExpressionValue(itemSmallScrollCardItemBinding, "binding");
        itemSmallScrollCardItemBinding.setModel(this);
        ImageView imageView = this.binding.scoreViewIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.scoreViewIcon");
        imageView.setImageTintList(ColorStateList.valueOf(AppHolder.getAppTheme().getColorAccent()));
        this.binding.executePendingBindings();
        TextView textView2 = this.binding.scoreView;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.scoreView");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView2.setTypeface(ProductGlobalData.getNumberTypeface(context));
        this.binding.itemView.setTag(2131362764, obj);
        this.binding.actionContainer.setTag(2131362764, obj);
        SmallScrollCardItemViewHolder smallScrollCardItemViewHolder = this;
        ViewUtil.clickListener(this.binding.itemView, smallScrollCardItemViewHolder);
        ViewUtil.clickListener(this.binding.actionContainer, smallScrollCardItemViewHolder);
        onBindWithApp();
    }

    protected void onBindWithApp() {
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 != null) {
            this.binding.actionContainer.bindWithApp(serviceApp2, false);
        }
    }

    @Override // com.coolapk.market.viewholder.StateViewHolder, com.coolapk.market.util.RVStateEventChangedAdapter.IStateViewHolder
    public boolean onStateEventChanged(Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        ServiceApp serviceApp2 = this.serviceApp;
        if (serviceApp2 != null) {
            return StateViewHolder.isEventBelongTo(event, serviceApp2);
        }
        return false;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x012a: APUT  (r5v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v5 java.lang.String) */
    @Override // com.coolapk.market.viewholder.BindingViewHolder, android.view.View.OnClickListener
    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Object tag = view.getTag(2131362764);
        int id = view.getId();
        int i = null;
        if (id == 2131361887) {
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.coolapk.market.model.ServiceApp");
            ServiceApp serviceApp2 = (ServiceApp) tag;
            UpgradeInfo upgradeInfo = null;
            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp2.getPackageName());
            if (mobileAppExistFast != null) {
                upgradeInfo = mobileAppExistFast.getUpgradeInfo();
            }
            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp2).packageName(serviceApp2.getPackageName()).targetUrl(serviceApp2.getDownloadUrl(0));
            String[] strArr = new String[4];
            strArr[0] = serviceApp2.getDownloadUrlMd5(0);
            strArr[1] = serviceApp2.getDownloadUrlMd5(2);
            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
            if (upgradeInfo != null) {
                i = upgradeInfo.getDownloadUrlMd5(1);
            }
            strArr[3] = i;
            StateUtils.handleClick(UiUtils.getActivity(getContext()), targetUrl.downloadKeys(strArr).build(), view);
        } else if (id != 2131362779) {
            super.onClick(view);
        } else {
            if (tag instanceof User) {
                User user = (User) tag;
                ActionManager.startUserSpaceActivity(((ItemSmallScrollCardItemBinding) getBinding()).iconView, user.getUid(), user.getUserAvatar());
            } else if (tag instanceof ServiceApp) {
                ServiceApp serviceApp3 = (ServiceApp) tag;
                ActionManager.startAppViewActivity(getContext(), serviceApp3.getPackageName(), serviceApp3.getExtraAnalysisData(), serviceApp3.getRequestContext(), serviceApp3.getExtraFromApi(), EntityExtendsKt.urlClientConfig((Entity) tag));
            } else if (tag instanceof Entity) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Entity entity = (Entity) tag;
                ActionManagerCompat.startActivityByUrl(context, entity.getUrl(), entity.getTitle(), entity.getSubTitle());
            }
            if ((tag instanceof Entity) && this.parentCard != null) {
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
                Entity entity2 = (Entity) tag;
                BindingViewHolder bindingViewHolder = this.parentViewHolder;
                if (bindingViewHolder != null) {
                    i = Integer.valueOf(bindingViewHolder.getAdapterPosition());
                }
                if (i == null) {
                    i = -1;
                }
                StatisticHelper.recordEntityEvent$default(instance, fixedRecordId, entity2, ((Number) i).intValue(), this.parentCard, null, 16, null);
            }
        }
    }
}
