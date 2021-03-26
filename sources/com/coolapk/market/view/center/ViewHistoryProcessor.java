package com.coolapk.market.view.center;

import android.app.Activity;
import androidx.fragment.app.FragmentManager;
import com.coolapk.market.extend.ContextExtendsKt;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.UserHistory;
import com.coolapk.market.util.RxUtils;
import com.coolapk.market.view.feed.ConfirmDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/coolapk/market/view/center/ViewHistoryProcessor;", "", "()V", "removeAllFromRecent", "", "activity", "Landroid/app/Activity;", "history", "Lcom/coolapk/market/model/UserHistory;", "removeFromRecent", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: ViewHistoryEvent.kt */
public final class ViewHistoryProcessor {
    public static final ViewHistoryProcessor INSTANCE = new ViewHistoryProcessor();

    private ViewHistoryProcessor() {
    }

    public final void removeFromRecent(Activity activity, UserHistory userHistory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userHistory, "history");
        DataManager.getInstance().deleteViewHistory(userHistory.getId()).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new ViewHistoryProcessor$removeFromRecent$1(activity, userHistory));
    }

    public final void removeAllFromRecent(Activity activity, UserHistory userHistory) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(userHistory, "history");
        ConfirmDialog newInstance = ConfirmDialog.newInstance("", "确定要清空全部浏览历史么？该操作不可恢复哦", "确定清空", "取消");
        newInstance.setOnOkRunnable(new ViewHistoryProcessor$removeAllFromRecent$1(activity, userHistory));
        FragmentManager supportFragmentManager = ContextExtendsKt.requireAppCompatActivity(activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.requireAppCompa…().supportFragmentManager");
        newInstance.show(supportFragmentManager, (String) null);
    }
}
