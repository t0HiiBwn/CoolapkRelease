package com.coolapk.market.view.photo;

import android.app.Dialog;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.coolapk.market.event.ProductEventRequester;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.manager.StatisticHelper;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.CollectionUtils;
import com.coolapk.market.util.KotlinExtendKt;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.view.base.ActionItem;
import com.coolapk.market.view.base.MultiItemDialogFragmentKt;
import com.coolapk.market.view.feed.ConfirmDialog;
import com.coolapk.market.widget.Toast;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import rx.Observable;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/coolapk/market/view/base/ActionItem;", "invoke"}, k = 3, mv = {1, 4, 2})
/* compiled from: SaveImageDialog.kt */
final class SaveImageDialog$onActivityCreated$1 extends Lambda implements Function1<List<ActionItem>, Unit> {
    final /* synthetic */ SaveImageDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SaveImageDialog$onActivityCreated$1(SaveImageDialog saveImageDialog) {
        super(1);
        this.this$0 = saveImageDialog;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<ActionItem> list) {
        invoke(list);
        return Unit.INSTANCE;
    }

    public final void invoke(List<ActionItem> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        String string = this.this$0.getString(2131886982);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.str_share_image)");
        MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, string) {
            /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass1 */
            final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

            {
                this.this$0 = r2;
            }

            @Override // com.coolapk.market.view.base.ActionItem
            public void takeAction() {
                GlideUrl glideUrl;
                StatisticHelper.Companion.getInstance().recordCoolPicAction("分享图片");
                SaveImageDialog saveImageDialog = this.this$0.this$0;
                PhotoViewUrl access$getPhotoViewUrl$p = SaveImageDialog.access$getPhotoViewUrl$p(this.this$0.this$0);
                Integer needCoolapkHeader = access$getPhotoViewUrl$p.getNeedCoolapkHeader();
                if (needCoolapkHeader != null && needCoolapkHeader.intValue() == 1) {
                    LazyHeaders.Builder createGlideCoolApkHeader = KotlinExtendKt.createGlideCoolApkHeader();
                    KotlinExtendKt.appendCoolApkCookies(createGlideCoolApkHeader);
                    glideUrl = new GlideUrl(access$getPhotoViewUrl$p.getSource(), createGlideCoolApkHeader.build());
                } else {
                    glideUrl = new GlideUrl(access$getPhotoViewUrl$p.getSource());
                }
                saveImageDialog.saveImageAndShare(glideUrl);
            }
        });
        String string2 = this.this$0.getString(2131886930);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.str_photo_view_save_photo)");
        MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, string2) {
            /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass2 */
            final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

            {
                this.this$0 = r2;
            }

            @Override // com.coolapk.market.view.base.ActionItem
            public void takeAction() {
                GlideUrl glideUrl;
                StatisticHelper.Companion.getInstance().recordCoolPicAction("保存原图");
                SaveImageDialog saveImageDialog = this.this$0.this$0;
                PhotoViewUrl access$getPhotoViewUrl$p = SaveImageDialog.access$getPhotoViewUrl$p(this.this$0.this$0);
                Integer needCoolapkHeader = access$getPhotoViewUrl$p.getNeedCoolapkHeader();
                if (needCoolapkHeader != null && needCoolapkHeader.intValue() == 1) {
                    LazyHeaders.Builder createGlideCoolApkHeader = KotlinExtendKt.createGlideCoolApkHeader();
                    KotlinExtendKt.appendCoolApkCookies(createGlideCoolApkHeader);
                    glideUrl = new GlideUrl(access$getPhotoViewUrl$p.getSource(), createGlideCoolApkHeader.build());
                } else {
                    glideUrl = new GlideUrl(access$getPhotoViewUrl$p.getSource());
                }
                saveImageDialog.saveImage(glideUrl);
            }
        });
        final boolean z = true;
        if (CollectionUtils.safeSize(SaveImageDialog.access$getPhotoViewUrls$p(this.this$0)) > 1) {
            MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, "保存全部原图") {
                /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass3 */
                final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r2;
                }

                @Override // com.coolapk.market.view.base.ActionItem
                public void takeAction() {
                    StatisticHelper.Companion.getInstance().recordCoolPicAction("保存全部原图");
                    ConfirmDialog newInstance = ConfirmDialog.newInstance("保存全部原图", "确认要保存全部" + CollectionUtils.safeSize(SaveImageDialog.access$getUrls$p(this.this$0.this$0)) + "张图片么？", "确认保存", "取消");
                    newInstance.setOnOkRunnable(new SaveImageDialog$onActivityCreated$1$3$takeAction$1(this));
                    FragmentActivity requireActivity = this.this$0.this$0.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                    FragmentManager supportFragmentManager = requireActivity.getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "requireActivity().supportFragmentManager");
                    newInstance.show(supportFragmentManager, (String) null);
                }
            });
        }
        if (TextUtils.equals(this.this$0.feedType, "picture")) {
            String string3 = this.this$0.getString(2131887154);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.str_wallpaper_set)");
            MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, string3) {
                /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass4 */
                final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r2;
                }

                @Override // com.coolapk.market.view.base.ActionItem
                public void takeAction() {
                    StatisticHelper.Companion.getInstance().recordCoolPicAction("设为壁纸");
                    this.this$0.this$0.saveImageAndSetWallpaper(SaveImageDialog.access$getUrl$p(this.this$0.this$0));
                }
            });
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        Intrinsics.checkNotNullExpressionValue(loginSession, "DataManager.getInstance().loginSession");
        if (loginSession.isAdmin()) {
            MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, "复制图片链接") {
                /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass5 */
                final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r2;
                }

                @Override // com.coolapk.market.view.base.ActionItem
                public void takeAction() {
                    StringUtils.copyText(this.this$0.this$0.getActivity(), SaveImageDialog.access$getUrl$p(this.this$0.this$0));
                    Toast.show$default(this.this$0.this$0.getActivity(), "链接已复制", 0, false, 12, null);
                }
            });
            if (SaveImageDialog.access$getPhotoViewUrl$p(this.this$0).getMediaID().length() > 0) {
                MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, "设为精选产品图") {
                    /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass6 */
                    final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

                    {
                        this.this$0 = r2;
                    }

                    @Override // com.coolapk.market.view.base.ActionItem
                    public void takeAction() {
                        ProductEventRequester.INSTANCE.requestAddToMediaList(SaveImageDialog.access$getPhotoViewUrl$p(this.this$0.this$0).getMediaID());
                    }
                });
            }
            MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, "管理") {
                /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass7 */
                final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

                {
                    this.this$0 = r2;
                }

                @Override // com.coolapk.market.view.base.ActionItem
                public void takeAction() {
                    PicAdminDialog newInstance = PicAdminDialog.Companion.newInstance(SaveImageDialog.access$getUrl$p(this.this$0.this$0));
                    FragmentManager childFragmentManager = this.this$0.this$0.getChildFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    newInstance.show(childFragmentManager, (String) null);
                    Dialog dialog = this.this$0.this$0.getDialog();
                    if (dialog != null) {
                        dialog.dismiss();
                    }
                }
            });
            if (TextUtils.equals(this.this$0.feedType, "picture") && this.this$0.feed != null) {
                DataManager instance2 = DataManager.getInstance();
                Intrinsics.checkNotNullExpressionValue(instance2, "DataManager.getInstance()");
                LoginSession loginSession2 = instance2.getLoginSession();
                Intrinsics.checkNotNullExpressionValue(loginSession2, "DataManager.getInstance().loginSession");
                if (loginSession2.isAdmin()) {
                    Feed feed = this.this$0.feed;
                    Integer valueOf = feed != null ? Integer.valueOf(feed.getRecommend()) : null;
                    Intrinsics.checkNotNull(valueOf);
                    if (valueOf.intValue() <= 0) {
                        z = false;
                    }
                    MultiItemDialogFragmentKt.addItem(list, new ActionItem(this, z ? "取消推荐" : "上推荐") {
                        /* class com.coolapk.market.view.photo.SaveImageDialog$onActivityCreated$1.AnonymousClass8 */
                        final /* synthetic */ SaveImageDialog$onActivityCreated$1 this$0;

                        {
                            this.this$0 = r1;
                        }

                        @Override // com.coolapk.market.view.base.ActionItem
                        public void takeAction() {
                            Observable.just(Boolean.valueOf(z)).flatMap(new SaveImageDialog$onActivityCreated$1$8$takeAction$1(this)).map(RxUtils.checkResultToData()).compose(RxUtils.applyIOSchedulers()).subscribe((Subscriber) new SaveImageDialog$onActivityCreated$1$8$takeAction$2(this));
                        }
                    });
                }
            }
        }
    }
}
