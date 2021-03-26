package com.coolapk.market.view.feed.question;

import android.view.View;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.Feed;
import com.coolapk.market.model.User;
import com.coolapk.market.util.RxUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscriber;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0011J\u001c\u0010\u001b\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/coolapk/market/view/feed/question/QuestionPresenter;", "", "view", "Lcom/coolapk/market/view/feed/question/QuestionView;", "feed", "Lcom/coolapk/market/model/Feed;", "(Lcom/coolapk/market/view/feed/question/QuestionView;Lcom/coolapk/market/model/Feed;)V", "getFeed", "()Lcom/coolapk/market/model/Feed;", "setFeed", "(Lcom/coolapk/market/model/Feed;)V", "isPostingFollow", "", "()Z", "setPostingFollow", "(Z)V", "<set-?>", "", "order", "getOrder", "()Ljava/lang/String;", "getView", "()Lcom/coolapk/market/view/feed/question/QuestionView;", "followQuestion", "", "isFollowing", "id", "inviteUser", "users", "", "Lcom/coolapk/market/model/User;", "setOrderType", "type", "showOrderPopMenu", "cursorView", "Landroid/view/View;", "Companion", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: QuestionPresenter.kt */
public final class QuestionPresenter {
    public static final Companion Companion = new Companion(null);
    public static final String KEY_TYPE_BLOCK = "block";
    public static final String KEY_TYPE_DATELINE = "dateline";
    public static final String KEY_TYPE_LIKE = "like";
    public static final String KEY_TYPE_REPLY = "reply";
    private Feed feed;
    private boolean isPostingFollow;
    private String order = "reply";
    private final QuestionView view;

    public QuestionPresenter(QuestionView questionView, Feed feed2) {
        Intrinsics.checkNotNullParameter(questionView, "view");
        Intrinsics.checkNotNullParameter(feed2, "feed");
        this.view = questionView;
        this.feed = feed2;
    }

    public final Feed getFeed() {
        return this.feed;
    }

    public final QuestionView getView() {
        return this.view;
    }

    public final void setFeed(Feed feed2) {
        Intrinsics.checkNotNullParameter(feed2, "<set-?>");
        this.feed = feed2;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/coolapk/market/view/feed/question/QuestionPresenter$Companion;", "", "()V", "KEY_TYPE_BLOCK", "", "KEY_TYPE_DATELINE", "KEY_TYPE_LIKE", "KEY_TYPE_REPLY", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: QuestionPresenter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final boolean isPostingFollow() {
        return this.isPostingFollow;
    }

    public final void setPostingFollow(boolean z) {
        this.isPostingFollow = z;
    }

    public final String getOrder() {
        return this.order;
    }

    public final void inviteUser(List<? extends User> list, String str) {
        Intrinsics.checkNotNullParameter(list, "users");
        Intrinsics.checkNotNullParameter(str, "id");
        if (!this.isPostingFollow) {
            DataManager instance = DataManager.getInstance();
            List<? extends User> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getUid());
            }
            instance.inviteUserToAnswer(arrayList, str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new QuestionPresenter$inviteUser$2(this));
        }
    }

    public final void followQuestion(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!this.isPostingFollow) {
            this.isPostingFollow = true;
            if (z) {
                DataManager.getInstance().unFollowQuestion(str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new QuestionPresenter$followQuestion$1(this, z));
            } else {
                DataManager.getInstance().followQuestion(str).compose(RxUtils.apiCommonToData()).subscribe((Subscriber<? super R>) new QuestionPresenter$followQuestion$2(this, z));
            }
        }
    }

    public final void showOrderPopMenu(View view2) {
        Intrinsics.checkNotNullParameter(view2, "cursorView");
        this.view.showOrderPopMenu(view2);
    }

    public final void setOrderType(String str) {
        Intrinsics.checkNotNullParameter(str, "type");
        if (!Intrinsics.areEqual(this.order, str)) {
            this.order = str;
            this.view.onOrderChange(str);
        }
    }
}
