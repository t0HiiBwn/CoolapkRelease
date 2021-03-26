package com.coolapk.market.viewholder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.coolapk.market.extend.EntityExtendsKt;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.ActionManagerCompat;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.ClickInfo;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.MobileApp;
import com.coolapk.market.model.Product;
import com.coolapk.market.model.ServiceApp;
import com.coolapk.market.model.Topic;
import com.coolapk.market.model.UpgradeInfo;
import com.coolapk.market.model.User;
import com.coolapk.market.util.StateUtils;
import com.coolapk.market.util.UiUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0012\u001a\u00020\fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/coolapk/market/viewholder/EntityItemModel;", "", "context", "Landroid/content/Context;", "item", "Lcom/coolapk/market/model/Entity;", "(Landroid/content/Context;Lcom/coolapk/market/model/Entity;)V", "doAction", "", "view", "Landroid/view/View;", "getCardCover", "", "getCardSubTitle", "getCardTitle", "getCardVideoParams", "getCardVideoUrl", "getDisplayPicCover", "getLogo", "getServiceApp", "Lcom/coolapk/market/model/ServiceApp;", "getSubtitle", "getTitle", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: EntityItemModel.kt */
public final class EntityItemModel {
    private final Context context;
    private final Entity item;

    public EntityItemModel(Context context2, Entity entity) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(entity, "item");
        this.context = context2;
        this.item = entity;
    }

    public final String getLogo() {
        Entity entity = this.item;
        String str = "";
        if (entity instanceof ServiceApp) {
            String logo = ((ServiceApp) entity).getLogo();
            if (logo != null) {
                str = logo;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.logo ?: \"\"");
            return str;
        } else if (entity instanceof User) {
            String userAvatar = ((User) entity).getUserAvatar();
            return userAvatar != null ? userAvatar : str;
        } else if (entity instanceof Product) {
            String logo2 = ((Product) entity).getLogo();
            if (logo2 != null) {
                str = logo2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.logo ?: \"\"");
            return str;
        } else if (!(entity instanceof Topic)) {
            return EntityExtendsKt.picOrLogo(entity);
        } else {
            String logo3 = ((Topic) entity).getLogo();
            if (logo3 != null) {
                str = logo3;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.logo ?: \"\"");
            return str;
        }
    }

    public final String getTitle() {
        Entity entity = this.item;
        String str = "";
        if (entity instanceof ServiceApp) {
            String appName = ((ServiceApp) entity).getAppName();
            if (appName != null) {
                str = appName;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.appName ?: \"\"");
            return str;
        } else if (entity instanceof User) {
            String userName = ((User) entity).getUserName();
            Intrinsics.checkNotNullExpressionValue(userName, "item.userName");
            return userName;
        } else if (entity instanceof Product) {
            String title = ((Product) entity).getTitle();
            if (title != null) {
                str = title;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.title ?: \"\"");
            return str;
        } else if (entity instanceof Topic) {
            String title2 = ((Topic) entity).getTitle();
            if (title2 != null) {
                str = title2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.title ?: \"\"");
            return str;
        } else {
            String title3 = entity.getTitle();
            if (title3 != null) {
                str = title3;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.title ?: \"\"");
            return str;
        }
    }

    public final String getSubtitle() {
        String stringExtraDataOrNull;
        Entity entity = this.item;
        String str = "";
        if (entity instanceof ServiceApp) {
            stringExtraDataOrNull = ((ServiceApp) entity).getApkSubTitle();
            if (stringExtraDataOrNull == null) {
                stringExtraDataOrNull = EntityExtendsKt.getStringExtraDataOrNull(this.item, "subTitle");
            }
            if (TextUtils.isEmpty(stringExtraDataOrNull)) {
                stringExtraDataOrNull = this.context.getString(2131886912, ((ServiceApp) this.item).getDownCount(), ((ServiceApp) this.item).getCommentCount());
            }
            if (stringExtraDataOrNull == null) {
                return str;
            }
        } else if (entity instanceof User) {
            String bio = ((User) entity).getBio();
            if (bio == null) {
                bio = ((User) this.item).getSubTitle();
            }
            if (bio != null) {
                str = bio;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.bio ?: item.subTitle ?: \"\"");
            return str;
        } else if (entity instanceof Product) {
            String subTitle = ((Product) entity).getSubTitle();
            if (subTitle != null) {
                str = subTitle;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.subTitle ?: \"\"");
            return str;
        } else if (entity instanceof Topic) {
            String description = ((Topic) entity).getDescription();
            if (description != null) {
                str = description;
            }
            Intrinsics.checkNotNullExpressionValue(str, "item.description ?: \"\"");
            return str;
        } else {
            stringExtraDataOrNull = EntityExtendsKt.getStringExtraDataOrNull(entity, "subTitle");
            if (stringExtraDataOrNull == null) {
                stringExtraDataOrNull = this.item.getSubTitle();
            }
            if (stringExtraDataOrNull == null) {
                return str;
            }
        }
        return stringExtraDataOrNull;
    }

    public final String getCardTitle() {
        return EntityExtendsKt.getStringExtraDataOrNull(this.item, "cardTitle");
    }

    public final String getCardSubTitle() {
        return EntityExtendsKt.getStringExtraDataOrNull(this.item, "cardSubTitle");
    }

    public final String getCardCover() {
        return EntityExtendsKt.getStringExtraDataOrNull(this.item, "cover");
    }

    public final String getCardVideoUrl() {
        return EntityExtendsKt.getStringExtraDataOrNull(this.item, "videoCover");
    }

    public final String getCardVideoParams() {
        return EntityExtendsKt.getStringExtraDataOrNull(this.item, "videoParams");
    }

    public final String getDisplayPicCover() {
        if (getCardVideoUrl() != null) {
            return null;
        }
        String cardCover = getCardCover();
        return cardCover != null ? cardCover : this.item.getPic();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0067: APUT  (r5v2 java.lang.String[]), (2 ??[int, float, short, byte, char]), (r0v11 java.lang.String) */
    public final void doAction(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Entity entity = this.item;
        if (entity instanceof ServiceApp) {
            if (view.getId() != 2131361887) {
                ActionManager.startAppViewActivity(this.context, ((ServiceApp) entity).getPackageName());
                return;
            }
            String str = null;
            UpgradeInfo upgradeInfo = null;
            ServiceApp serviceApp = (ServiceApp) entity;
            MobileApp mobileAppExistFast = DataManager.getInstance().getMobileAppExistFast(serviceApp.getPackageName());
            if (mobileAppExistFast != null) {
                upgradeInfo = mobileAppExistFast.getUpgradeInfo();
            }
            ClickInfo.Builder targetUrl = ClickInfo.newBuilder(serviceApp).packageName(serviceApp.getPackageName()).targetUrl(serviceApp.getDownloadUrl(0));
            String[] strArr = new String[4];
            strArr[0] = serviceApp.getDownloadUrlMd5(0);
            strArr[1] = serviceApp.getDownloadUrlMd5(2);
            strArr[2] = upgradeInfo != null ? upgradeInfo.getDownloadUrlMd5(0) : null;
            if (upgradeInfo != null) {
                str = upgradeInfo.getDownloadUrlMd5(1);
            }
            strArr[3] = str;
            StateUtils.handleClick(UiUtils.getActivity(this.context), targetUrl.downloadKeys(strArr).build(), view);
        } else if (entity instanceof User) {
            ActionManager.startUserSpaceActivity(this.context, ((User) entity).getUid());
        } else if (entity instanceof Product) {
            ActionManager.startProductActivity(this.context, ((Product) entity).getId());
        } else if (entity instanceof Topic) {
            ActionManager.startTopicFeedActivity(this.context, ((Topic) entity).getId());
        } else {
            ActionManagerCompat.startActivityByUrl(this.context, entity.getUrl(), this.item.getTitle(), this.item.getSubTitle());
        }
    }

    public final ServiceApp getServiceApp() {
        Entity entity = this.item;
        if (entity instanceof ServiceApp) {
            return (ServiceApp) entity;
        }
        return null;
    }
}
