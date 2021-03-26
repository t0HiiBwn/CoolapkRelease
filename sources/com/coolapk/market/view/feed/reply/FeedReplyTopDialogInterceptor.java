package com.coolapk.market.view.feed.reply;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.FeedReply;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.base.WrapDialogFragmentKt;
import com.coolapk.market.view.feed.dialog.SheetDataKt;
import com.coolapk.market.view.feed.dialog.SheetGroup;
import com.coolapk.market.view.feed.dialog.SheetGroupModifier;
import com.coolapk.market.view.feed.dialog.SheetGroupType;
import com.coolapk.market.view.feed.dialog.reply.ReplyUserSheetGroupFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0014H\u0002J\u001e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u001a\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/coolapk/market/view/feed/reply/FeedReplyTopDialogInterceptor;", "Lcom/coolapk/market/view/feed/dialog/SheetGroupModifier;", "activity", "Landroid/app/Activity;", "topIds", "", "", "feed", "Lcom/coolapk/market/model/Feed;", "(Landroid/app/Activity;Ljava/util/List;Lcom/coolapk/market/model/Feed;)V", "getActivity", "()Landroid/app/Activity;", "getFeed", "()Lcom/coolapk/market/model/Feed;", "getTopIds", "()Ljava/util/List;", "checkAndShowSetFeedTopHint", "", "oldValue", "", "Lcom/coolapk/market/model/FeedReply;", "modifySheet", "data", "", "items", "Lcom/coolapk/market/view/feed/dialog/SheetGroup;", "setFeedToNodeTop", "shouldModify", "anchorActivity", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: FeedReplyTopDialogInterceptor.kt */
public final class FeedReplyTopDialogInterceptor implements SheetGroupModifier {
    private final Activity activity;
    private final Feed feed;
    private final List<String> topIds;

    public FeedReplyTopDialogInterceptor(Activity activity2, List<String> list, Feed feed2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(list, "topIds");
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.activity = activity2;
        this.topIds = list;
        this.feed = feed2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final List<String> getTopIds() {
        return this.topIds;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public boolean shouldModify(Object obj, Activity activity2) {
        Intrinsics.checkNotNullParameter(obj, "data");
        if ((obj instanceof FeedReply) && Intrinsics.areEqual(activity2, this.activity)) {
            FeedReply feedReply = (FeedReply) obj;
            if (Intrinsics.areEqual(feedReply.getFeedId(), this.feed.getId()) && !feedReply.hasParentReply()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.coolapk.market.view.feed.dialog.SheetGroupModifier
    public void modifySheet(Object obj, List<SheetGroup> list) {
        Intrinsics.checkNotNullParameter(obj, "data");
        Intrinsics.checkNotNullParameter(list, "items");
        SheetGroupModifier.DefaultImpls.modifySheet(this, obj, list);
        if (obj instanceof FeedReply) {
            SheetDataKt.findAndIndex(list, SheetGroupType.ReplyUser, ReplyUserSheetGroupFactory.ReplyAction.ViewChat, new FeedReplyTopDialogInterceptor$modifySheet$1(this, obj));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: private */
    public final void checkAndShowSetFeedTopHint(boolean z, FeedReply feedReply) {
        if (z || !(!this.topIds.isEmpty())) {
            setFeedToNodeTop(z, feedReply);
            return;
        }
        AlertDialog create = new AlertDialog.Builder(this.activity).setMessage("已经存在置顶回复，是否用当前回复替换旧的置顶回复?").setPositiveButton("确定", new FeedReplyTopDialogInterceptor$checkAndShowSetFeedTopHint$1(this, z, feedReply)).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        Intrinsics.checkNotNullExpressionValue(create, "AlertDialog.Builder(acti…                .create()");
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(this.activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        WrapDialogFragmentKt.show(create, supportFragmentManager, null);
    }

    /* access modifiers changed from: private */
    public final void setFeedToNodeTop(boolean z, FeedReply feedReply) {
        if (z) {
            DataManager.getInstance().cancelReplyTopFromFeed(this.feed.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedReplyTopDialogInterceptor$setFeedToNodeTop$1(this, feedReply));
        } else {
            DataManager.getInstance().addReplyTopToFeed(feedReply.getId(), this.feed.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new FeedReplyTopDialogInterceptor$setFeedToNodeTop$2(this, feedReply));
        }
    }
}
