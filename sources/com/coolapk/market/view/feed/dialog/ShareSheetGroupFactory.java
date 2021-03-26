package com.coolapk.market.view.feed.dialog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.model.DyhArticle;
import com.coolapk.market.model.Entity;
import com.coolapk.market.model.Feed;
import com.coolapk.market.util.PackageUtils;
import com.coolapk.market.util.StringUtils;
import com.coolapk.market.util.UiUtils;
import com.coolapk.market.view.sharev8.ShareUtils;
import com.coolapk.market.widget.Toast;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0013H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/feed/dialog/ShareSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/Entity;", "context", "Landroid/content/Context;", "(Lcom/coolapk/market/model/Entity;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getData", "()Lcom/coolapk/market/model/Entity;", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "shareApps", "Landroid/content/pm/ResolveInfo;", "shareInfo", "Lcom/coolapk/market/view/sharev8/ShareUtils$ShareInfo;", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/feed/dialog/ShareSheetGroupFactory$ShareAction;", "title", "", "resource", "", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "wrapAsSheetGroup", "ShareAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ShareSheetGroupFactory.kt */
public final class ShareSheetGroupFactory implements SheetCallback {
    private final Context context;
    private final Entity data;
    private final List<SheetDataItem> dataList = new ArrayList();
    private final List<ResolveInfo> shareApps;
    private final ShareUtils.ShareInfo shareInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/ShareSheetGroupFactory$ShareAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "Feed", "PM", "KKH", "WeChat", "WeChatTimeline", "QQ", "WeiBo", "Tim", "Zhihu", "CopyLink", "More", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ShareSheetGroupFactory.kt */
    public enum ShareAction implements SheetAction {
        Feed,
        PM,
        KKH,
        WeChat,
        WeChatTimeline,
        QQ,
        WeiBo,
        Tim,
        Zhihu,
        CopyLink,
        More
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ShareAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ShareAction.Feed.ordinal()] = 1;
            iArr[ShareAction.PM.ordinal()] = 2;
            iArr[ShareAction.KKH.ordinal()] = 3;
            iArr[ShareAction.WeChat.ordinal()] = 4;
            iArr[ShareAction.WeChatTimeline.ordinal()] = 5;
            iArr[ShareAction.QQ.ordinal()] = 6;
            iArr[ShareAction.Tim.ordinal()] = 7;
            iArr[ShareAction.Zhihu.ordinal()] = 8;
            iArr[ShareAction.CopyLink.ordinal()] = 9;
            iArr[ShareAction.More.ordinal()] = 10;
            iArr[ShareAction.WeiBo.ordinal()] = 11;
        }
    }

    public ShareSheetGroupFactory(Entity entity, Context context2) {
        Intrinsics.checkNotNullParameter(entity, "data");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.data = entity;
        this.context = context2;
        ArrayList arrayList = new ArrayList();
        List<ResolveInfo> shareApps2 = PackageUtils.getShareApps(context2);
        Intrinsics.checkNotNullExpressionValue(shareApps2, "PackageUtils.getShareApps(context)");
        arrayList.addAll(shareApps2);
        Unit unit = Unit.INSTANCE;
        this.shareApps = arrayList;
        this.shareInfo = ShareUtils.obtainShareInfo(entity);
    }

    public final Context getContext() {
        return this.context;
    }

    public final Entity getData() {
        return this.data;
    }

    public final SheetGroup create() {
        T t;
        T t2;
        T t3;
        T t4;
        T t5;
        boolean z = true;
        if (!this.dataList.isEmpty()) {
            return wrapAsSheetGroup();
        }
        if (this.shareInfo.getUrl().length() <= 0) {
            z = false;
        }
        if (z) {
            insertItem(ShareAction.Feed, "动态", 2131231326);
            insertItem(ShareAction.PM, "私信", 2131231507);
        }
        Entity entity = this.data;
        if ((entity instanceof Feed) || (entity instanceof DyhArticle)) {
            insertItem(ShareAction.KKH, "看看号", 2131231327);
        }
        Iterator<T> it2 = this.shareApps.iterator();
        while (true) {
            t = null;
            if (!it2.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it2.next();
            if (Intrinsics.areEqual(((ResolveInfo) t2).activityInfo.packageName, "com.tencent.mm")) {
                break;
            }
        }
        if (t2 != null) {
            insertItem(ShareAction.WeChat, "微信", 2131231332);
            insertItem(ShareAction.WeChatTimeline, "朋友圈", 2131231329);
        }
        Iterator<T> it3 = this.shareApps.iterator();
        while (true) {
            if (!it3.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it3.next();
            if (Intrinsics.areEqual(((ResolveInfo) t3).activityInfo.packageName, "com.sina.weibo")) {
                break;
            }
        }
        if (t3 != null) {
            insertItem(ShareAction.WeiBo, "微博", 2131231333);
        }
        Iterator<T> it4 = this.shareApps.iterator();
        while (true) {
            if (!it4.hasNext()) {
                t4 = null;
                break;
            }
            t4 = it4.next();
            if (Intrinsics.areEqual(((ResolveInfo) t4).activityInfo.packageName, "com.tencent.mobileqq")) {
                break;
            }
        }
        if (t4 != null) {
            insertItem(ShareAction.QQ, "QQ", 2131231330);
        }
        Iterator<T> it5 = this.shareApps.iterator();
        while (true) {
            if (!it5.hasNext()) {
                t5 = null;
                break;
            }
            t5 = it5.next();
            if (Intrinsics.areEqual(((ResolveInfo) t5).activityInfo.packageName, "com.tencent.tim")) {
                break;
            }
        }
        if (t5 != null) {
            insertItem(ShareAction.Tim, "TIM", 2131231331);
        }
        Iterator<T> it6 = this.shareApps.iterator();
        while (true) {
            if (!it6.hasNext()) {
                break;
            }
            T next = it6.next();
            if (Intrinsics.areEqual(((ResolveInfo) next).activityInfo.packageName, "com.zhihu.android")) {
                t = next;
                break;
            }
        }
        if (t != null) {
            insertItem(ShareAction.Zhihu, "知乎", 2131231334);
        }
        insertItem(ShareAction.CopyLink, "复制链接", 2131231325);
        insertItem(ShareAction.More, "更多", 2131231328);
        return wrapAsSheetGroup();
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        T t;
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof ShareAction)) {
            return SheetResult.Companion.getNothing();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[((ShareAction) sheetAction).ordinal()]) {
            case 1:
                ActionManager.startShareFeedV8Activity(UiUtils.getActivityNullable(this.context), this.shareInfo.getUrl());
                break;
            case 2:
                ActionManager.startRecentActivity(UiUtils.getActivityNullable(this.context), this.data);
                break;
            case 3:
                ActionManager.startDyhIncludActivity(UiUtils.getActivityNullable(this.context), this.data.getId());
                break;
            case 4:
                ShareUtils.shareToWechatUrl(this.context, this.data, false);
                break;
            case 5:
                ShareUtils.shareToWechatUrl(this.context, this.data, true);
                break;
            case 6:
                ShareUtils.shareToQQ(this.context, this.data);
                break;
            case 7:
                ShareUtils.shareToQQ(this.context, this.data);
                break;
            case 8:
                Iterator<T> it2 = this.shareApps.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        t = it2.next();
                        if (Intrinsics.areEqual(((ResolveInfo) t).activityInfo.packageName, "com.zhihu.android")) {
                        }
                    } else {
                        t = null;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setComponent(new ComponentName(((ResolveInfo) t2).activityInfo.packageName, ((ResolveInfo) t2).activityInfo.name));
                    intent.setType("text/*");
                    intent.putExtra("android.intent.extra.TEXT", this.shareInfo.getContent());
                    intent.addFlags(268435456);
                    this.context.startActivity(intent);
                    break;
                } else {
                    return SheetResult.Companion.getNothing();
                }
            case 9:
                StringUtils.copyText(this.context, this.shareInfo.getUrl());
                Toast.show$default(this.context, "链接已复制", 0, false, 12, null);
                break;
            case 10:
                Context context2 = this.context;
                ActionManager.shareTextBySystem(context2, "分享到：" + this.shareInfo.getTitle(), this.shareInfo.getTitle(), this.shareInfo.getContent());
                break;
            case 11:
                ShareUtils.shareToWeibo(this.context, this.data);
                break;
        }
        return SheetResult.Companion.getClose();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.Share, this.dataList);
    }

    private final void insertItem(ShareAction shareAction, String str, int i) {
        this.dataList.add(new SheetDataItem(shareAction, str, SheetDataItem.Companion.createResourceApplyer(i), this, null, 0, false, false, 240, null));
    }
}
