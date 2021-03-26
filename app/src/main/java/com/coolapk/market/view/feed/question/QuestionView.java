package com.coolapk.market.view.feed.question;

import android.view.View;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0011"}, d2 = {"Lcom/coolapk/market/view/feed/question/QuestionView;", "", "onInviteResult", "", "result", "", "error", "", "onOrderChange", "type", "pickUserToInvite", "setFollowSate", "isFollowing", "", "showOrderPopMenu", "view", "Landroid/view/View;", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionPresenter.kt */
public interface QuestionView {
    void onInviteResult(String str, Throwable th);

    void onOrderChange(String str);

    void pickUserToInvite();

    void setFollowSate(boolean z, Throwable th);

    void showOrderPopMenu(View view);
}
