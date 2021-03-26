package com.coolapk.market.view.live;

import android.app.Activity;
import com.coolapk.market.manager.DataManager;
import com.coolapk.market.model.LiveMessage;
import com.coolapk.market.util.RxUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Subscription;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/coolapk/market/view/live/LivePost;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "callback", "Lcom/coolapk/market/view/live/LivePost$Callback;", "getCallback", "()Lcom/coolapk/market/view/live/LivePost$Callback;", "setCallback", "(Lcom/coolapk/market/view/live/LivePost$Callback;)V", "<set-?>", "", "isPosting", "()Z", "sub", "Lrx/Subscription;", "post", "", "liveId", "", "message", "unsubscribe", "Callback", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
/* compiled from: LivePost.kt */
public final class LivePost {
    private final Activity activity;
    private Callback callback;
    private volatile boolean isPosting;
    private Subscription sub;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/coolapk/market/view/live/LivePost$Callback;", "", "onError", "", "error", "", "onNext", "data", "", "Lcom/coolapk/market/model/LiveMessage;", "onSubscribe", "onUnsubscribe", "presentation_coolapkAppRelease"}, k = 1, mv = {1, 4, 2})
    /* compiled from: LivePost.kt */
    public interface Callback {
        void onError(Throwable th);

        void onNext(List<? extends LiveMessage> list);

        void onSubscribe();

        void onUnsubscribe();
    }

    public LivePost(Activity activity2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        this.activity = activity2;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final boolean isPosting() {
        return this.isPosting;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public final void post(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "liveId");
        Intrinsics.checkNotNullParameter(str2, "message");
        if (!this.isPosting) {
            this.sub = DataManager.getInstance().postLiveMessage(str, str2, CollectionsKt.emptyList(), "", 0, "live").compose(RxUtils.applyIOSchedulers()).map(RxUtils.checkResultToData()).doOnSubscribe(new LivePost$post$1(this)).doOnUnsubscribe(new LivePost$post$2(this)).subscribe(new LivePost$post$3(this), new LivePost$post$4(this));
        }
    }

    public final void unsubscribe() {
        Subscription subscription = this.sub;
        if (subscription != null) {
            subscription.unsubscribe();
        }
    }
}
