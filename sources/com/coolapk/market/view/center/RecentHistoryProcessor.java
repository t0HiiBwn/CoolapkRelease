package com.coolapk.market.view.center;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.RecentHistory;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/center/RecentHistoryProcessor;", "", "()V", "addToTopRecent", "", "activity", "Landroid/app/Activity;", "recentHistory", "Lcom/coolapk/market/model/RecentHistory;", "removeAllFromRecent", "removeFromRecent", "unsetTopRecent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: RecentHistoryEvent.kt */
public final class RecentHistoryProcessor {
    public static final RecentHistoryProcessor INSTANCE = new RecentHistoryProcessor();

    private RecentHistoryProcessor() {
    }

    public final void removeFromRecent(Activity activity, RecentHistory recentHistory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(recentHistory, "recentHistory");
        DataManager.getInstance().deleteRecentHistory(recentHistory.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new RecentHistoryProcessor$removeFromRecent$1(activity, recentHistory));
    }

    public final void removeAllFromRecent(Activity activity, RecentHistory recentHistory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(recentHistory, "recentHistory");
        ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要清空全部常去记录么？该操作不可恢复哦", "确定清空", "取消");
        newInstance.setOnOkRunnable(new RecentHistoryProcessor$removeAllFromRecent$1(activity, recentHistory));
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }

    public final void addToTopRecent(Activity activity, RecentHistory recentHistory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(recentHistory, "recentHistory");
        DataManager.getInstance().addToTopRecentHistory(recentHistory.getTargetId(), recentHistory.getTargetType()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new RecentHistoryProcessor$addToTopRecent$1(activity, recentHistory));
    }

    public final void unsetTopRecent(Activity activity, RecentHistory recentHistory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(recentHistory, "recentHistory");
        DataManager.getInstance().removeFromTopRecentHistory(recentHistory.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new RecentHistoryProcessor$unsetTopRecent$1(activity, recentHistory));
    }
}
