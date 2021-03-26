package com.coolapk.market.view.feed.dialog.reply;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.local.LoginSession;
import com.coolapk.market.manager.ActionManager;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.ResourceUtils;
import com.coolapk.market.util.UriUtils;
import com.coolapk.market.view.feed.dialog.SheetAction;
import com.coolapk.market.view.feed.dialog.SheetCallback;
import com.coolapk.market.view.feed.dialog.SheetDataItem;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.SheetResult;
import com.coolapk.market.view.feed.post.ConfirmDeleteDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001!B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012J4\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/coolapk/market/view/feed/dialog/reply/ReplyUserSheetGroupFactory;", "Lcom/coolapk/market/view/feed/dialog/SheetCallback;", "data", "Lcom/coolapk/market/model/FeedReply;", "activity", "Landroid/app/Activity;", "(Lcom/coolapk/market/model/FeedReply;Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "bgColor", "", "getData", "()Lcom/coolapk/market/model/FeedReply;", "dataList", "", "Lcom/coolapk/market/view/feed/dialog/SheetDataItem;", "userItemColor", "create", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "insertItem", "", "action", "Lcom/coolapk/market/view/feed/dialog/reply/ReplyUserSheetGroupFactory$ReplyAction;", "title", "", "resource", "iconTintColor", "bandageText", "onSheetClick", "Lcom/coolapk/market/view/feed/dialog/SheetResult;", "sheetAction", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "wrapAsSheetGroup", "ReplyAction", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ReplyUserSheetGroupFactory.kt */
public final class ReplyUserSheetGroupFactory implements SheetCallback {
    private final Activity activity;
    private final int bgColor;
    private final FeedReply data;
    private final List<SheetDataItem> dataList = new ArrayList();
    private final int userItemColor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/feed/dialog/reply/ReplyUserSheetGroupFactory$ReplyAction;", "", "Lcom/coolapk/market/view/feed/dialog/SheetAction;", "(Ljava/lang/String;I)V", "Top", "Copy", "ViewChat", "ViewPic", "Report", "Delete", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: ReplyUserSheetGroupFactory.kt */
    public enum ReplyAction implements SheetAction {
        Top,
        Copy,
        ViewChat,
        ViewPic,
        Report,
        Delete
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReplyAction.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ReplyAction.ViewChat.ordinal()] = 1;
            iArr[ReplyAction.Copy.ordinal()] = 2;
            iArr[ReplyAction.ViewPic.ordinal()] = 3;
            iArr[ReplyAction.Report.ordinal()] = 4;
            iArr[ReplyAction.Delete.ordinal()] = 5;
        }
    }

    public ReplyUserSheetGroupFactory(FeedReply feedReply, Activity activity2) {
        Intrinsics.checkNotNullParameter(feedReply, "data");
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.data = feedReply;
        this.activity = activity2;
        this.bgColor = ResourceUtils.getColorInt(activity2, 2131100054);
        this.userItemColor = ResourceUtils.resolveData(activity2, 2130969438);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final FeedReply getData() {
        return this.data;
    }

    public final SheetGroup create() {
        boolean z = true;
        if (!this.dataList.isEmpty()) {
            return wrapAsSheetGroup();
        }
        DataManager instance = DataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "DataManager.getInstance()");
        LoginSession loginSession = instance.getLoginSession();
        String uid = this.data.getUid();
        Intrinsics.checkNotNullExpressionValue(loginSession, "session");
        boolean areEqual = Intrinsics.areEqual(uid, loginSession.getUid());
        insertItem$default(this, ReplyAction.ViewChat, "查看会话", 2131231608, 0, null, 24, null);
        insertItem$default(this, ReplyAction.Copy, "复制", 2131231244, 0, null, 24, null);
        String pic = this.data.getPic();
        if (!(pic == null || pic.length() == 0)) {
            z = false;
        }
        if (!z) {
            insertItem$default(this, ReplyAction.ViewPic, "查看图片", 2131231489, 0, null, 24, null);
        }
        if (areEqual || loginSession.isAdmin()) {
            insertItem$default(this, ReplyAction.Delete, "删除", 2131231252, 0, null, 24, null);
        }
        if (!areEqual) {
            insertItem$default(this, ReplyAction.Report, "举报", 2131231657, 0, null, 24, null);
        }
        return wrapAsSheetGroup();
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetCallback
    public SheetResult onSheetClick(SheetAction sheetAction) {
        Intrinsics.checkNotNullParameter(sheetAction, "sheetAction");
        if (!(sheetAction instanceof ReplyAction)) {
            return SheetResult.Companion.getNothing();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[((ReplyAction) sheetAction).ordinal()];
        if (i == 1) {
            ActionManager.startFeedReplyDetailActivity(this.activity, this.data);
        } else if (i == 2) {
            return SheetResult.Companion.replace$default(SheetResult.Companion, CollectionsKt.mutableListOf(new ReplyCopySheetGroupFactory(this.data, this.activity).create()), false, 2, null);
        } else {
            if (i == 3) {
                Activity activity2 = this.activity;
                String pic = this.data.getPic();
                Intrinsics.checkNotNull(pic);
                ActionManager.startPhotoViewActivity(activity2, new String[]{pic}, new String[]{this.data.getMiddleSizePic()}, 0);
            } else if (i == 4) {
                String id = this.data.getId();
                Intrinsics.checkNotNull(id);
                Intrinsics.checkNotNullExpressionValue(id, "data.id!!");
                ActionManager.startWebViewActivity(this.activity, UriUtils.buildFeedReplyReportUrl(id));
            } else if (i == 5) {
                String string = this.activity.getString(2131886784);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str….str_dialog_delete_title)");
                String string2 = this.activity.getString(2131886781, new Object[]{this.data.getUserName(), this.data.getMessage()});
                Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.str…a.userName, data.message)");
                ConfirmDeleteDialog newInstance = ConfirmDeleteDialog.newInstance(string, string2);
                newInstance.setDeleteTarget(this.data);
                FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
                newInstance.show(supportFragmentManager, (String) null);
            }
        }
        return SheetResult.Companion.getClose();
    }

    private final SheetGroup wrapAsSheetGroup() {
        return new SheetGroup(SheetGroupType.ReplyUser, this.dataList);
    }

    static /* synthetic */ void insertItem$default(ReplyUserSheetGroupFactory replyUserSheetGroupFactory, ReplyAction replyAction, String str, int i, int i2, String str2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            i2 = replyUserSheetGroupFactory.userItemColor;
        }
        if ((i3 & 16) != 0) {
            str2 = "";
        }
        replyUserSheetGroupFactory.insertItem(replyAction, str, i, i2, str2);
    }

    private final void insertItem(ReplyAction replyAction, String str, int i, int i2, String str2) {
        this.dataList.add(new SheetDataItem(replyAction, str, SheetDataItem.Companion.createIconBgApplyer(i, i2, this.bgColor), this, str2, 0, false, false, 224, null));
    }
}
